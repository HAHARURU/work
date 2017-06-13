package com.jz.xd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jz.xd.model.Outkind;
import com.jz.xd.model.Outvideo;
import com.jz.xd.service.IndexService;
import com.jz.xd.service.RootService;
import com.qiniu.util.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by HARU on 2017/6/1.
 */
@Controller
@RequestMapping(value = "/root")
public class RootController {
    private static Logger logger = LogManager.getLogger(RootController.class);
    private static final String CHARSET = ";UTF-8";
    @Autowired
    private RootService rootService;
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/toCourseVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toCourseVideo(Model model) {
        logger.info("转入上传课程视频");
        return "root/courseVideo";
    }

    @RequestMapping(value = "/toUploadVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toUploadVideo(Model model) {
        logger.info("转入上传视频");
        model.addAttribute("fKind", rootService.getKind(0));
        return "root/uploadVideo";
    }

    @RequestMapping(value = "/toEditKind", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toEditKind(Model model) {
        logger.info("转入修改种类");
        model.addAttribute("fKind", rootService.getKind(0));
        return "root/editKind";
    }

    @RequestMapping(value = "/toFeedback", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toFeedback(Model model, Integer page, Integer size) {
        logger.info("转入反馈列表");
        model.addAttribute("feedbackList", rootService.getFeedbackList(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", rootService.getAllFeedback(size));
        return "root/feedbackList";
    }

    @RequestMapping(value = "/changeCourseKindAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    List changeCourseKindAjax(String kind) {
        return indexService.getMonths(kind);
    }

    @RequestMapping(value = "/changeKindAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    List<Outkind> changeKindAjax(Integer fkid) {
        return rootService.getKind(fkid);
    }

    @RequestMapping(value = "/addKindAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Outkind addKindAjax(Integer fkid, String ckname, String icon) {
        return rootService.updateKindItem(fkid, ckname, icon);
    }

    @RequestMapping(value = "/deleteKindAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer deleteKindAjax(Integer kid) {
        return rootService.deleteKindItem(kid);
    }

    @RequestMapping(value = "/editKindAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer editKindAjax(Integer kid, String ckname, String icon) {
        return rootService.editKindItem(kid, ckname, icon);
    }

    @RequestMapping(value = "/uploadVideoAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer uploadVideoAjax(Model model, @RequestBody Outvideo outvideo) throws IOException {
        logger.info("异步上传视频");
        rootService.editVideo(outvideo);
        return 1;
    }

    @RequestMapping(value = "/uploadCourseVideoAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer uploadCourseVideoAjax(Model model, @RequestBody Outvideo outvideo) throws IOException {
        logger.info("异步上传课程视频");
        rootService.editCourseVideo(outvideo);
        return 1;
    }

    @RequestMapping(value = "uptoken", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> makeToken() {
        Auth auth = Auth.create("SG07wlHwxd9VdGs61nT7n14G72Fc1EQgKhwpshQc", "vdbhOSfQoscemSLUzPfNS_WW3EXR96KthpYi0GlL");
        String bucketName = "outvideo";
        String upToken = auth.uploadToken(bucketName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uptoken", upToken);
        return new ResponseEntity(jsonObject, HttpStatus.OK);
    }

    @RequestMapping(value = "uptoken2", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> makeToken2() {
        Auth auth = Auth.create("SG07wlHwxd9VdGs61nT7n14G72Fc1EQgKhwpshQc", "vdbhOSfQoscemSLUzPfNS_WW3EXR96KthpYi0GlL");
        String bucketName = "course";
        String upToken = auth.uploadToken(bucketName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uptoken", upToken);
        return new ResponseEntity(jsonObject, HttpStatus.OK);
    }
}
