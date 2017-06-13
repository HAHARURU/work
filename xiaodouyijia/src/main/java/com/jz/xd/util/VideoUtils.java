package com.jz.xd.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.FFMPEGLocator;
import it.sauronsoftware.jave.MultimediaInfo;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * Created by HARU on 2017/5/4.
 */
public class VideoUtils {
    public static Long getVideoTime(final HttpSession session, String videoName) throws EncoderException {
        File file = new File(videoName);
        FFMPEGLocator locator = new FFMPEGLocator() {
            @Override
            protected String getFFMPEGExecutablePath() {
                //修改为服务器地址
                //return "D:\\ziyuan\\ffmpeg\\ffmpeg.exe";
                return session.getServletContext().getRealPath("/") + "resources/ffmpeg/ffmpeg.exe";
            }
        };
        Encoder encoder = new Encoder(locator);
        MultimediaInfo multimediaInfo = encoder.getInfo(file);
        return multimediaInfo.getDuration() / 1000 / 60;
    }
}
