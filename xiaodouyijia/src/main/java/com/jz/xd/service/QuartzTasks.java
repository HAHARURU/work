package com.jz.xd.service;

import com.jz.xd.mapper.TbSysUserBoyMapper;
import com.jz.xd.model.TbSysUserBoy;
import com.jz.xd.model.TbSysUserBoyExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HARU on 2017/5/31.
 */
@Service("quartzTasks")
public class QuartzTasks {
    private static Logger logger = LogManager.getLogger(QuartzTasks.class);
    @Autowired
    private TbSysUserBoyMapper tbSysUserBoyMapper;

    public void updateAge() {
        TbSysUserBoyExample tbSysUserBoyExample = new TbSysUserBoyExample();
        tbSysUserBoyExample.createCriteria().andActiveEqualTo(1);
        List<TbSysUserBoy> tbSysUserBoys = tbSysUserBoyMapper.selectByExample(tbSysUserBoyExample);
        logger.debug("查找所孩子", tbSysUserBoys.toString());
        for (TbSysUserBoy tbSysUserBoy : tbSysUserBoys) {
            tbSysUserBoy.setAge(String.valueOf(Integer.parseInt(tbSysUserBoy.getAge()) + 1));
            int i = tbSysUserBoyMapper.updateByPrimaryKey(tbSysUserBoy);
            logger.debug("孩子年龄加一", ((Integer) i).toString());
        }
    }
}
