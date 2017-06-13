package com.jz.xd.service;

import com.jz.xd.mapper.*;
import com.jz.xd.mapper.ext.FeedbackMapperExt;
import com.jz.xd.model.*;
import com.jz.xd.model.ext.FeedbackExt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by HARU on 2017/6/2.
 */
@Service
public class RootService {
    private static Logger logger = LogManager.getLogger(RootService.class);
    @Autowired
    private OutkindMapper outkindMapper;
    @Autowired
    private OutvideoMapper outvideoMapper;
    @Autowired
    private TbRVideoMapper tbRVideoMapper;
    @Autowired
    private TbSysProductMapper tbSysProductMapper;
    @Autowired
    private TbRProductVideoMapper tbRProductVideoMapper;
    @Autowired
    private FeedbackMapperExt feedbackMapperExt;
    @Autowired
    private FeedbackMapper feedbackMapper;

    public List<Outkind> getKind(Integer pkid) {
        OutkindExample outkindExample = new OutkindExample();
        outkindExample.createCriteria().andPkidEqualTo(pkid);
        List<Outkind> outkinds = outkindMapper.selectByExample(outkindExample);
        if (outkinds == null) {
            return null;
        }
        logger.debug("查找视频种类", outkinds.toString());
        return outkinds;
    }

    public List<FeedbackExt> getFeedbackList(Integer number, Integer size) {
        List<FeedbackExt> feedbackList = feedbackMapperExt.getFeedbackList();
        logger.debug("查找意见反馈", feedbackList.toString());
        int start = (number - 1) * size;
        int end = number * size;
        if (size > feedbackList.size() - ((number - 1) * size)) {
            end = feedbackList.size();
        }
        feedbackList = feedbackList.subList(start, end);
        return feedbackList;
    }

    public Integer getAllFeedback(Integer size) {
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.setOrderByClause("uploadTime desc");
        List<Feedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
        logger.debug("查找所有意见反馈", feedbacks.toString());
        int totoalPages = feedbacks.size() / size;
        if (feedbacks.size() % size > 0) {
            totoalPages++;
        }
        return totoalPages;
    }

    public Outkind updateKindItem(Integer pkid, String ckname, String icon) {
        Outkind outkind = new Outkind();
        outkind.setKname(ckname);
        outkind.setPkid(pkid);
        outkind.setIconimage(icon);
        int insert = outkindMapper.insert(outkind);
        logger.debug("插入视频二级种类", insert);
        OutkindExample outkindExample = new OutkindExample();
        List<Outkind> outkinds = outkindMapper.selectByExample(outkindExample);
        logger.debug("查找所有视频种类", outkinds.toString());
        return outkinds.get(outkinds.size() - 1);
    }

    public Integer deleteKindItem(Integer kid) {
        int i = outkindMapper.deleteByPrimaryKey(kid);
        logger.debug("删除视频二级种类", i);
        return i;
    }

    public Integer editKindItem(Integer kid, String ckname, String icon) {
        Outkind outkind = outkindMapper.selectByPrimaryKey(kid);
        logger.debug("查找视频种类", outkind);
        outkind.setKname(ckname);
        outkind.setIconimage(icon);
        int i = outkindMapper.updateByPrimaryKey(outkind);
        logger.debug("编辑视频二级种类", i);
        return i;
    }

    public void editVideo(Outvideo outvideo) {
        if (outvideo.getVoname() == null || "".equals(outvideo.getVoname())) {
            String[] split = outvideo.getVourl().split("/");
            String[] split1 = split[split.length - 1].split("\\.");
            outvideo.setVoname(split1[0]);
        }
        outvideo.setVopaly(0);
        Date date = new Date();
        long time = date.getTime();
        outvideo.setUploadtime(new Timestamp(time));
        int half = outvideo.getVoduration() / 2;
        outvideo.setVopic(outvideo.getVourl() + "?vframe/jpg/offset/" + half + "/w/300/h/180");
        int insert = outvideoMapper.insert(outvideo);
        logger.debug("插入视频", insert);
    }

    public void editCourseVideo(Outvideo courseVideo) {
        Integer maxId = 0;
        TbRVideoExample tbRVideoExample = new TbRVideoExample();
        tbRVideoExample.createCriteria().andActiveEqualTo(1);
        tbRVideoExample.setOrderByClause("v_id asc");
        List<TbRVideo> videos = tbRVideoMapper.selectByExample(tbRVideoExample);
        if (videos != null && videos.size() > 0) {
            maxId = videos.get(videos.size() - 1).getvId() + 1;
            logger.debug("查找所有视频", videos.toString());
        }
        TbRVideo tbRVideo = new TbRVideo();
        tbRVideo.setvId(maxId);
        tbRVideo.setPlayCount(0);
        tbRVideo.setvName(courseVideo.getVourl());
        tbRVideo.setActive(1);
        tbRVideo.setDuration(courseVideo.getVoduration() / 60);
        int half = courseVideo.getVoduration() / 2;
        tbRVideo.setvImg(courseVideo.getVourl() + "?vframe/jpg/offset/" + half + "/w/300/h/180");
        Date date = new Date();
        long time = date.getTime();
        tbRVideo.setSyscreated(new Timestamp(time));
        if (courseVideo.getVoname() == null || "".equals(courseVideo.getVoname())) {
            String[] split = courseVideo.getVourl().split("/");
            String[] split1 = split[split.length - 1].split("\\.");
            tbRVideo.setvTital(split1[0]);
        } else {
            tbRVideo.setvTital(courseVideo.getVoname());
        }
        tbRVideo.setStepImg(courseVideo.getStepImg());
        int insert = tbRVideoMapper.insert(tbRVideo);
        logger.debug("添加视频", insert);

        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPKindEqualTo(courseVideo.getKind()).andPAgeEqualTo(courseVideo.getAge()).andPMonthEqualTo(courseVideo.getMonth()).andActiveEqualTo(1);
        List<TbSysProduct> tbSysProducts = tbSysProductMapper.selectByExample(tbSysProductExample);
        if (tbSysProducts != null && tbSysProducts.size() > 0) {
            logger.debug("查找视频相关课程", tbSysProducts.toString());
            Integer pId = tbSysProducts.get(0).getpId();
            TbRProductVideo tbRProductVideo = new TbRProductVideo();
            tbRProductVideo.setpId(pId);
            tbRProductVideo.setvId(maxId);
            Date date1 = new Date();
            long time1 = date1.getTime();
            tbRProductVideo.setSyscreated(new Timestamp(time1));
            tbRProductVideo.setActive(1);
            int insert1 = tbRProductVideoMapper.insert(tbRProductVideo);
            logger.debug("添加视频课程关联", insert1);
        }
    }
}
