package com.jz.xd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jz.xd.model.*;
import com.jz.xd.model.ext.ProductStock;
import com.jz.xd.service.IndexService;
import com.jz.xd.service.LoginService;
import com.jz.xd.util.CommonStatusEnums;
import com.jz.xd.util.ErrorCodeUtils;
import org.apache.commons.codec.EncoderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HARU on 2017/3/17.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {
    private static Logger logger = LogManager.getLogger(IndexController.class);
    private static final String CHARSET = ";UTF-8";
    private List<City> provinces;
    @Autowired
    private IndexService indexService;
    @Autowired
    private LoginService loginService;
    private String cName;
    private String cBirthday;
    private String cAge;
    private String cUrl = "";
    private String verificationCode = "";
    private String phone;
    private String cSex;

    @RequestMapping(value = "/toIndex", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toIndex() {
        logger.info("转入目录页");
        return "newIndex";
    }

    @RequestMapping(value = "/toRobot", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toRobot(Model model) {
        logger.info("转入机器人页");
        List<TbSysProduct> robotProduct = indexService.getProduct(1);
        model.addAttribute("robotDemoList", robotProduct);
        model.addAttribute("robotStockMap", indexService.getProductStock(robotProduct));
        return "newRobot";
    }

    @RequestMapping(value = "/toCourse", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toCourse(Model model, Integer number, Integer size) {
        logger.info("转入课程页");
        model.addAttribute("totalPages", indexService.getVideoPages(size));
        model.addAttribute("currentPage", number);
        model.addAttribute("videoList", indexService.getVideoList(number, size));
        return "newCourse";
    }

    @RequestMapping(value = "/toCourseAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Map<String, Object> toCourseAjax(Integer number, Integer size, String kind, String month, String age) {
        logger.info("异步获取课程");
        Map<String, Object> map = new HashMap<String, Object>();
        //课程
        List<ProductStock> course = indexService.getCourse(kind, month, age);
        Integer price = 0;
        if (course.size() == 1) {
            price = course.get(0).getpPrice();
            map.put("courseDetail", course.get(0));
        }
        map.put("price", price);
        map.put("monthList", indexService.getMonths(kind));
        //视频
        map.put("totalPages", indexService.getVideos(size, course));
        map.put("currentP", number);
        map.put("videoList", indexService.getVideosList(number, size, course));
        return map;
    }

    @RequestMapping(value = "/toVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toVideo(Model model, Integer vid, HttpServletRequest request) throws EncoderException, it.sauronsoftware.jave.EncoderException {
        logger.info("转入视频页");
//        model.addAttribute("videoDetail", indexService.getVideoDetail(vid));
        model.addAttribute("videoDetail", indexService.updateVideoDetail(vid));
        List<TbRVideo> videoList = indexService.getVideoList(vid);
        model.addAttribute("videoList", videoList);
        model.addAttribute("timeList", indexService.getVideoTime(request.getSession(), videoList));
        return "video";
    }

    @RequestMapping(value = "/toTourism", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toTourism(Model model, Integer state, Integer number, Integer size) {
        logger.info("转入旅游页");
        model.addAttribute("state", state);
        model.addAttribute("allPages", indexService.getAllPages(state, size, 3));
        model.addAttribute("number", number);
        model.addAttribute("tourismList", indexService.getTourismList(state, number, size));
        return "tourism";
    }

    @RequestMapping(value = "/toTourismDetail", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toTourismDetail(Model model, Integer tid) {
        logger.info("转入旅游详情页");
        model.addAttribute("tourismDetail", indexService.getTourismDetail(tid));
        return "tourismDetail";
    }

    @RequestMapping(value = "/toLogin", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toLogin(String url) {
        logger.info("转入登录");
        cUrl = url;
        return "login";
    }

    @RequestMapping(value = "/validate", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toValidate(Model model, String username, String password, Boolean rememberMe, HttpServletRequest request) {
        logger.info("验证用户");

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        try {
            indexService.updateCheckUser(username, password, rememberMe);
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("error", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "账号不存在");
            return "login";
        }
        try {
            String requestUrl = WebUtils.getSavedRequest(request).getRequestUrl();
            loginService.updateDateInfo();
            return "redirect:" + requestUrl;
        } catch (NullPointerException e) {
            if (cUrl != null && !"".equals(cUrl)) {
                loginService.updateDateInfo();
                return "redirect:" + cUrl;
            } else {
                cUrl = "";
                if ("root".equals(username)) {
                    return "redirect:/root/toUploadVideo";
                }
                return "redirect:/index/toIndex";
            }
        }
    }

    @RequestMapping(value = "/toRegister", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toRegister(Model model) {
        logger.info("转入注册");
        model.addAttribute("state", 1);
        return "register";
    }

    @RequestMapping(value = "/toForgetPassword", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toForgetPassword(Model model) {
        logger.info("转入找回密码");
        model.addAttribute("state", 1);
        return "forgetPassword";
    }

    @RequestMapping(value = "/getCode", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer getCode(String phone) throws IOException {
        logger.info("获取验证码");
        this.phone = phone;
        SendVerificationResult message = indexService.getMessage(phone, 4, "3056497");
        if ("200".equals(message.getResultCode())) {
            verificationCode = message.getVerificationCode();
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/validateCode", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String validateCode(Model model, String phoneNumber, String code, Integer forget) {
        logger.info("验证验证码");
        model.addAttribute("state", 2);
        model.addAttribute("phone", phoneNumber);
        model.addAttribute("code", code);
        if (!verificationCode.equals(code)) {
            model.addAttribute("state", 1);
            model.addAttribute("error", "验证码错误");
        }
        if (forget != 1) {
            if (indexService.getPhone(phoneNumber)) {
                model.addAttribute("state", 1);
                model.addAttribute("error", "手机号已被注册");
            }
        }
        return (forget == 1) ? "forgetPassword" : "register";
    }

    /*@RequestMapping(value = "/toWriteChildren", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toWriteChildren(Model model, String cdName, String age, String sex) {
        logger.info("转入填写孩子信息");
        cName = cdName;
        cAge = age;
        cSex = sex;
        model.addAttribute("state", 3);
        return "register";
    }*/

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String register(Model model, String cdName, String age, String sex, String username, String password, String password2, Integer forget, HttpServletRequest request) throws ParseException {
        logger.info("注册会员");
        model.addAttribute("state", 2);
        if (cdName == null || "".equals(cdName)) {
            model.addAttribute("error", "豆宝姓名不能为空");
        }
        model.addAttribute("cdName", cdName);
        model.addAttribute("age", age);
        model.addAttribute("sex", sex);
        cName = cdName;
        cAge = age;
        cSex = sex;
        int registerInfo = indexService.updateRegister(username, password, password2, forget, cName, cBirthday, this.phone);
//        int registerInfo = indexService.updateRegister(username, password, password2, forget, cName, cAge, cSex, this.phone);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("password2", password2);
        if (registerInfo == -1) {
            model.addAttribute("error", "用户名或密码中不应有空格");
            return (forget == 1) ? "forgetPassword" : "register";
        }
        if (registerInfo == -2) {
            model.addAttribute("error", "用户名或密码不能为空");
            return (forget == -1) ? "forgetPassword" : "register";
        }
        if (registerInfo == -3) {
            model.addAttribute("error", "两次密码不一样");
            return (forget == 1) ? "forgetPassword" : "register";
        }
        if (registerInfo == -4) {
            model.addAttribute("error", "用户名已被注册");
            return (forget == 1) ? "forgetPassword" : "register";
        }
        return "registerSuccess";
    }

    @RequestMapping(value = "/toParticipate", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toParticipate(Model model) {
        logger.info("转入报名页");
        provinces = loginService.getProvince();
        model.addAttribute("provinces", provinces);
        return "participate";
    }

    @RequestMapping(value = "/getCityAjax", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    List<City> getCityAjax(String pCode) throws IOException {
        logger.info("异步获取城市");
        return loginService.getCity(pCode);
    }

    @RequestMapping(value = "/submitParticipateAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer submitParticipateAjax(@RequestBody Participate participate) throws IOException {
        logger.info("异步提交报名");
        indexService.insertParticipate(participate);
        return 1;
    }

    @RequestMapping(value = "/to404", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String to404() {
        logger.info("转入404");
        return "404";
    }

    @RequestMapping(value = "/to500", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String to500() {
        logger.info("转入500");
        return "500";
    }


    /*机器人接口*/

    @RequestMapping(value = "/participate", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    String participate(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("报名接口》》》[participate request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "name", "phone", "sex", "province", "city", "adultName", "address"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = indexService.insertParticipateInterface(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("插入报名记录失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[participate response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/videoList", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String videoList() throws IOException {
        logger.info("获取视频列表接口》》》[videoList request params] {}");
        ResponseJSONBean responseJson = new ResponseJSONBean();
        responseJson.setStatusCode(CommonStatusEnums.SUCCESS.getStatusCode());
        responseJson.setStatusMsg(CommonStatusEnums.SUCCESS.getStatusMsg());
        Map<String, Object> dataMap = new HashMap<>();
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = indexService.getVideoList();
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取视频列表失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[videoList response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/videoCount", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String videoCount(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("获取视频详情接口》》》[videoCount request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "vid"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = indexService.updateVideoCount(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("视频播放加一失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[videoCount response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/loginUser", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String loginUser(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("登录接口》》》[loginUser request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "username", "password"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        Object o;
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            try {
                o = indexService.updateCheckUserInterface(jsonObject);
                if (o == null) {
                    responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                    responseJson.setStatusMsg("登录失败");
                }
                dataMap = loginService.getLoginInfo();
            } catch (IncorrectCredentialsException e) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE2.getStatusCode());
                responseJson.setStatusMsg("密码错误");
            } catch (AuthenticationException e) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE3.getStatusCode());
                responseJson.setStatusMsg("账号不存在");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[loginUser response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/getValidateCode", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String getValidateCode(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("获取验证码接口》》》[getValidateCode request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "phone"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = indexService.getValidateCode(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取验证码失败");
            } else {
                SendVerificationResult result = (SendVerificationResult) dataMap.get("result");
                if (!"200".equals(result.getResultCode())) {
                    responseJson.setStatusCode(result.getResultCode());
                    responseJson.setStatusMsg(ErrorCodeUtils.getInfoByCode(result.getResultCode()));
                }
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[getValidateCode response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/registerMember", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String registerMember(@RequestBody JSONObject jsonObject) throws IOException, ParseException {
        logger.info("注册会员接口》》》[registerMember request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "username", "password", "beanname", "phonenum", "sex", "age"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        int uid;
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            uid = indexService.validateMember(jsonObject);
            switch (uid) {
                case -1:
                    responseJson.setStatusCode(CommonStatusEnums.CONTAIN_BLACK.getStatusCode());
                    responseJson.setStatusMsg("用户名或密码中不应有空格");
                    break;
                case -2:
                    responseJson.setStatusCode(CommonStatusEnums.REQUIRED.getStatusCode());
                    responseJson.setStatusMsg("用户名或密码不能为空");
                    break;
                case -4:
                    responseJson.setStatusCode(CommonStatusEnums.EXISTENCE.getStatusCode());
                    responseJson.setStatusMsg("用户名已被注册");
                    break;
                default:
                    dataMap = indexService.registerMember(uid);
                    if (dataMap == null) {
                        responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                        responseJson.setStatusMsg("注册会员失败");
                    }
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[registerMember response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

}
