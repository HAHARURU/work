package com.jz.xd.mapper.ext;

import com.jz.xd.model.TbRVideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/5/3.
 */
public interface VideoMapperExt {
    List<TbRVideo> getVideos(@Param("pid") Integer pid, @Param("number") Integer number, @Param("size") Integer size);

    TbRVideo getVideoDetail(@Param("vid") Integer vid);
}
