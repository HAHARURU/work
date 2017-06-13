package com.jz.xd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jz.xd.model.*;
import com.jz.xd.model.ext.AddressExt;
import com.jz.xd.model.ext.ItemsExt;
import com.jz.xd.service.IndexService;
import com.jz.xd.service.LoginService;
import com.jz.xd.util.CommonStatusEnums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by HARU on 2017/3/17.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static Logger logger = LogManager.getLogger(LoginController.class);
    private static final String CHARSET = ";UTF-8";
    @Autowired
    private LoginService loginService;
    @Autowired
    private IndexService indexService;
    private List<City> provinces;
    private String[] validateCode;
    private TbSysUserBoy children;
    private Date birthday;
    private Long phone;
    private String mail;
    private TbSysDiscountpageType coupon;
    private String invitation;
    private Integer point;
    private TbROrder tbROrder;
    private List<AddressExt> address;
    private String phoneString = "";

    @RequestMapping(value = "/toInformation", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toInformation(Model model) {
        logger.info("转入个人中心");
        User user = loginService.getUser();
        model.addAttribute("user", user);
        children = loginService.getChildren(user);
        birthday = children.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("children", children);
        model.addAttribute("birthdayDate", simpleDateFormat.format(birthday));
        phone = user.getPhone();
        model.addAttribute("phoneShow", phone);
        phoneString = phone.toString();
        model.addAttribute("phone", phoneString.substring(0, phoneString.length() - 3) + "***");
        mail = user.getMail();
        model.addAttribute("mailShow", mail);
        model.addAttribute("mail", "***" + mail.substring(3, mail.length()));
//        loginService.insertAddress();
        return "login/newInformation";
    }

    @RequestMapping(value = "/toNewMyCourse", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toMyCourse(Model model) {
        logger.info("转入我的课程");
        model.addAttribute("materialList", loginService.getMaterial());
        return "login/newMyCourse";
    }

    @RequestMapping(value = "/toAddress", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toAddress(Model model) {
        logger.info("转入收货地址");
        User user = loginService.getUser();
        provinces = loginService.getProvince();
        model.addAttribute("addressList", loginService.getAddress(user.getUid()));
        model.addAttribute("provinces", provinces);
        return "login/address";
    }

    @RequestMapping(value = "/getCityAjax", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    List<City> getCityAjax(String pCode) throws IOException {
        logger.info("异步获取城市");
        return loginService.getCity(pCode);
    }

    @RequestMapping(value = "/getAreaAjax", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    List<City> getAreaAjax(String cCode) throws IOException {
        logger.info("异步获取地区");
        return loginService.getArea(cCode);
    }

    @RequestMapping(value = "/toAddAddress", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toAddAddress(Model model, TbSysUserAddress tbSysUserAddress) {
        logger.info("添加收货地址");
        loginService.addAddress(tbSysUserAddress);
        return "redirect:/login/toAddress";
    }

    @RequestMapping(value = "/addEditAddressAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    List<AddressExt> addEditAddressAjax(Model model, @RequestBody TbSysUserAddress address) throws IOException {
        logger.info("异步添加编辑收货地址");
        if (address.getAddressId() == null || address.getAddressId() == -1) {
            loginService.addAddress(address);
        } else {
            loginService.editAddress(address.getAddressId(), address.getReceivedPerson(), address.getProvince(), address.getCity(), address.getArea(), address.getAddress(), address.getReceivedPersonPhone());
        }
        this.address = loginService.getAddress(loginService.getUser().getUid());
        return this.address;
    }

    @RequestMapping(value = "/toEditAddress", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toEditAddress(Model model, Integer aid, String receivedPerson, String province, String city, String area, String address, String receivedPersonPhone) {
        logger.info("编辑收货地址");
        //后台返回的值要有省市区的code和name
        loginService.editAddress(aid, receivedPerson, province, city, area, address, receivedPersonPhone);
        return "redirect:/login/toAddress";
    }

    @RequestMapping(value = "/toDeleteAddress", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toDeleteAddress(Model model, Integer aid, Integer index) {
        logger.info("删除收货地址");
        loginService.deleteAddress(aid, index);
        return "redirect:/login/toAddress";
    }

    @RequestMapping(value = "/toSetDefault", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toSetDefault(Model model, Integer aid) {
        logger.info("设置默认收货地址");
        loginService.setDefault(aid);
        return "redirect:/login/toAddress";
    }

    @RequestMapping(value = "/toUploadByMessage", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toUploadByMessage(Model model, Integer kind) {
        logger.info("转入短信修改");
        User user = loginService.getUser();
        model.addAttribute("user", user);
        Long phone = user.getPhone();
        model.addAttribute("phoneShow", phone);
        phoneString = phone.toString();
        model.addAttribute("phone", phoneString.substring(0, phoneString.length() - 3) + "***");
        String mail = user.getMail();
        model.addAttribute("mailShow", mail);
        model.addAttribute("mail", "***" + mail.substring(3, mail.length()));
        model.addAttribute("kind", kind);
        return "login/uploadByMessage";
    }

    @RequestMapping(value = "/getCode", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer getCode(Integer type) throws IOException {
        logger.info("获取验证码");
        validateCode = loginService.getCode(phoneString, type);
        return 1;
    }

    @RequestMapping(value = "/validateCode", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String validateCode(Model model, String code, Integer kind) {
        logger.info("验证验证码");
        model.addAttribute("step", 2);
        User user = loginService.getUser();
        model.addAttribute("user", user);
        Long phone = user.getPhone();
        model.addAttribute("phoneShow", phone);
        String phoneString = phone.toString();
        model.addAttribute("phone", phoneString.substring(0, phoneString.length() - 3) + "***");
        String mail = user.getMail();
        model.addAttribute("mailShow", mail);
        model.addAttribute("mail", "***" + mail.substring(3, mail.length()));
        model.addAttribute("kind", kind);
        model.addAttribute("code", code);
        if (!code.equals(validateCode[0])) {
            model.addAttribute("step", 1);
            model.addAttribute("error", "验证码错误");
            return "login/uploadByMessage";
        }
        if (kind == 3) {
            long beginTime = Long.parseLong(validateCode[1]);
            if (System.currentTimeMillis() > beginTime + 240000) {
                model.addAttribute("step", 1);
                model.addAttribute("error", "验证码过期");
                return "login/uploadByMessage";
            }
        }
        return "login/updateInfoByMessage";
    }

    @RequestMapping(value = "/validateInfo", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String validateInfo(Model model, Integer kind, String password, String phone, String mail) {
        logger.info("信息修改");
        model.addAttribute("kind", kind);
        User user = loginService.getUser();
        if (kind == 1) {
            user.setPassword(password);
            loginService.updateUserInfo(user);
        }
        if (kind == 2) {
            user.setPhone(Long.valueOf(phone));
            loginService.updateUserInfo(user);
        }
        if (kind == 3) {
            user.setMail(mail);
            loginService.updateUserInfo(user);
        }
        return "login/validateSuccess";
    }

    @RequestMapping(value = "/toUploadHead", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toUploadHead(Model model) {
        logger.info("转入修改头像");
        return "login/newUploadHead";
    }

    @RequestMapping(value = "/updateInfo", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String updateInfo(Model model, String username, Integer cid, String uBoyName, String sex, String birthdayDate) throws IOException {
        logger.info("修改信息");
        User user = loginService.getUser();
        if (loginService.selectUsername(username) == 1) {
            user.setUsername(username);
            model.addAttribute("user", user);
            model.addAttribute("birthdayDate", birthdayDate);
            String[] split = birthdayDate.split("-");
            int year = Integer.parseInt(split[0]);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            int nowYear = Integer.parseInt(simpleDateFormat.format(new Date()));
            children.setAge(String.valueOf(nowYear - year + 1));
            children.setuBoyName(uBoyName);
            children.setSex(sex.split(",")[1]);
            model.addAttribute("children", children);

            phone = user.getPhone();
            model.addAttribute("phoneShow", phone);
            phoneString = phone.toString();
            model.addAttribute("phone", phoneString.substring(0, phoneString.length() - 3) + "***");
            mail = user.getMail();
            model.addAttribute("mailShow", mail);
            model.addAttribute("mail", "***" + mail.substring(3, mail.length()));
            model.addAttribute("errorUsername", "用户名 " + username + " 已存在");
            return "login/newInformation";
        }
        user.setUsername(username);
        loginService.updateUserInfo(user);
        loginService.updateChildren(cid, uBoyName, sex, birthdayDate);
        return "redirect:/login/toInformation";
    }

    @RequestMapping(value = "/uploadHead", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer uploadHead(@RequestBody String img) throws IOException {
        logger.info("ajax修改头像");
        loginService.uploadHead(img);
        loginService.updateUserHead(loginService.getUser());
        return 1;
    }

    @RequestMapping(value = "/uploadRecommendHead", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String uploadRecommendHead(Model model, String img) throws IOException {
        logger.info("修改推荐头像");
        loginService.updateUserRecommendHead(img);
        return "redirect:/login/toInformation";
    }


    @RequestMapping(value = "/toNewCoupon", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toCoupon(Model model, Integer state) {
        logger.info("转入我的优惠券");
        model.addAttribute("userCoupons", loginService.getCoupons(state));
        model.addAttribute("state", state);
        return "login/newCoupon";
    }

    @RequestMapping(value = "/toMyPoint", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toMyPoint(Model model, Integer number, Integer size, Integer state) {
        logger.info("转入我的豆值");
        model.addAttribute("myPoint", loginService.getUserPoint());
        model.addAttribute("totalPages", loginService.getPointPages(state, size));
        model.addAttribute("currentPage", number);
        model.addAttribute("pointList", loginService.getPointList(state, number, size));
        model.addAttribute("couponList", loginService.getCouponList());
        model.addAttribute("state", state);
        return "login/myPoint";
    }

    @RequestMapping(value = "/myPointAjax", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Map<String, Object> myPointAjax(Model model, @RequestBody PageInfo pageInfo) throws IOException {
        logger.info("异步获取豆值");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalPages", loginService.getPointPages(pageInfo.getState(), pageInfo.getSize()));
        map.put("currentPage", pageInfo.getNumber());
        map.put("pointList", loginService.getPointList(pageInfo.getState(), pageInfo.getNumber(), pageInfo.getSize()));
        return map;
    }

    @RequestMapping(value = "/exchangePointAjax", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    Integer exchangePointAjax(Model model, Integer pv, Integer dpid) throws IOException {
        logger.info("异步兑换优惠券");
        loginService.exchangeCoupon(pv, dpid, loginService.getUserPoint());
        return 1;
    }

    @RequestMapping(value = "/toMyInvitation", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toMyInvitation(Model model, Integer number, Integer size) {
        logger.info("转入我的邀请码");
        model.addAttribute("totalPages", loginService.getInvitationPages(size));
        model.addAttribute("currentPage", number);
        model.addAttribute("invitationList", loginService.getInvitationList(number, size));
        return "login/invitation";
    }

    @RequestMapping(value = "/toNewMyOrder", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toNewMyOrder(Model model, Integer number, Integer size, Integer state) {
        logger.info("转入我的订单");
        model.addAttribute("totalPages", loginService.getTotalPages(size, state));
        model.addAttribute("currentPage", number);
        List<TbROrder> ordersListByPage = loginService.getOrdersListByPage(number, size, state);
        model.addAttribute("orders", ordersListByPage);
        model.addAttribute("ordersItems", loginService.getItems(ordersListByPage));
        model.addAttribute("state", state);
        return "login/newMyOrder";
    }

    @RequestMapping(value = "/cancelOrder", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String cancelOrder(Model model, Integer oid, Integer number, Integer size, Integer state) {
        logger.info("取消订单");
        loginService.deleteOrder(oid);
        List<TbROrder> ordersListByPage = loginService.getOrdersListByPage(number, size, state);
        if (ordersListByPage.size() == 0) {
            number--;
        }
        return "redirect:/login/toNewMyOrder?number=" + number + "&size=" + size + "&state=" + state;
    }

    @RequestMapping(value = "/toShopCar", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toShopCar(Model model, HttpServletRequest request) {
        logger.info("转入购物车");
        loginService.deleteOrder(null);
        List<ItemsExt> shopCarItem = loginService.updateShopCarItem(1);
        model.addAttribute("shopCarList", shopCarItem);
        if (shopCarItem.size() > 0) {
            model.addAttribute("oid", shopCarItem.get(0).getoId());
        } else {
            model.addAttribute("oid", 0);
        }
        model.addAttribute("userId", loginService.getUser().getUid());
        model.addAttribute("coupon", loginService.getCoupons(0));
        model.addAttribute("point", loginService.getPoint().get(0).getBeanVal());
        return "login/shopCar";
    }

    @RequestMapping(value = "/toBuy", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toBuy(Model model, Integer mount, Integer mount2, Integer pid, HttpServletRequest request) {
        logger.info("转入购买");
        loginService.deleteOrder(null);
        loginService.updateProductStock(pid, mount);
        loginService.createBuyOrder(mount, mount2, pid);
        request.getSession().setAttribute("first", false);
        List<ItemsExt> shopCarItem = loginService.updateShopCarItem(0);
        model.addAttribute("shopCarList", shopCarItem);
        if (shopCarItem.size() > 0) {
            model.addAttribute("oid", shopCarItem.get(0).getoId());
        } else {
            model.addAttribute("oid", 0);
        }
        model.addAttribute("userId", loginService.getUser().getUid());
        model.addAttribute("coupon", loginService.getCoupons(0));
        model.addAttribute("point", loginService.getPoint().get(0).getBeanVal());

        return "login/shopCar";
    }

    @RequestMapping(value = "/addShopCarAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer addShopCarAjax(Integer mount, Integer mount2, Integer pid) {
        logger.info("异步添加到购物车");
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
        if (object == null) {
            return 0;
        }
        loginService.updateProductStock(pid, mount);
        loginService.createOrder(mount, mount2, pid);
        return 1;
    }

    @RequestMapping(value = "/deleteItem", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer deleteItem(Integer itemId) {
        logger.info("删除购物车");
        loginService.deleteItem(itemId);
        return 1;
    }

    @RequestMapping(value = "/invitationAjax", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer invitationAjax(String invitation) {
        logger.info("AJAX检查邀请码");
        Integer code = 0;
        code = loginService.checkInvitation(invitation);
        return code;
    }

    @RequestMapping(value = "/toCheckOrder", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toCheckOrder(Model model, Integer couponId, String invitation, Integer point, Integer[] mountRequest, Integer[] itemIdHidden) {
        logger.info("转入核对信息");
        User user = loginService.getUser();
        provinces = loginService.getProvince();
        tbROrder = loginService.updateItems(mountRequest, itemIdHidden);
        address = loginService.getAddress(user.getUid());
        model.addAttribute("addressList", address);
        model.addAttribute("provinces", provinces);
        model.addAttribute("order", tbROrder);
        model.addAttribute("orderList", loginService.getOrderItems(tbROrder.getoId()));
        if (couponId != -1) {
            coupon = loginService.getCoupon(couponId);
            model.addAttribute("coupon", coupon);
        } else {
            model.addAttribute("coupon", null);
        }
        model.addAttribute("invitation", invitation);
        model.addAttribute("point", point);
        this.point = point;
        this.invitation = invitation;
        return "login/checkOrder";
    }

    @RequestMapping(value = "/toPay", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toPay(Model model, Integer payMethodId, Integer addressId, Integer totalPrice) throws IOException {
        logger.info("转入支付");
        Integer dpId = null;
        if (coupon != null) {
            dpId = coupon.getDpId();
        }
        tbROrder = loginService.updateOrder(tbROrder, payMethodId, addressId, dpId, invitation, point, totalPrice);
        model.addAttribute("order", tbROrder);
        model.addAttribute("requestInfo", loginService.updateQrCode(tbROrder));
        if (tbROrder.getPayTime() != null) {
            model.addAttribute("finish", 1);
        } else {
            model.addAttribute("finish", 0);
        }
        return "login/pay";
    }

    @RequestMapping(value = "/toPay2", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toPay2(Model model, Integer oid) throws IOException {
        logger.info("转入支付2");
        TbROrder order = loginService.getOrder(oid);
        model.addAttribute("order", order);
        model.addAttribute("requestInfo", loginService.updateQrCode(order));
        if (order.getPayTime() != null) {
            model.addAttribute("finish", 1);
        } else {
            model.addAttribute("finish", 0);
        }
        return "login/pay";
    }

    @RequestMapping(value = "/toFinishPay", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toFinishPay(Model model) {
        logger.info("完成支付");
        loginService.updateOrderFinish();
        return "redirect:/index/toIndex";
    }

    @RequestMapping(value = "/toSign", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toSign(Model model) throws ParseException {
        logger.info("转入签到");
        model.addAttribute("months", loginService.getCurrentCalendar());
        model.addAttribute("signHistory", loginService.updateSignHistory(null));
        return "login/sign";
    }

    @RequestMapping(value = "/signAjax", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer signAjax() throws ParseException {
        logger.info("异步签到");
        loginService.updateSignInfo(null);
        return 1;
    }

    @RequestMapping(value = "/collectionAjax", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public
    @ResponseBody
    Integer collectionAjax() {
        logger.info("异步收取");
        loginService.updateBeanVal();
        return 1;
    }

    @RequestMapping(value = "/toLogout", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public String toLogout() {
        logger.info("退出登录");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index/toIndex";
    }


    /*机器人接口*/

    @RequestMapping(value = "/signHistory", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String signHistory(@RequestBody JSONObject jsonObject) throws IOException, ParseException {
        logger.info("获取签到历史接口》》》[signHistory request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "uid"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.updateSignHistoryInterface(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取签到历史失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[signHistory response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/sign", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String sign(@RequestBody JSONObject jsonObject) throws IOException, ParseException {
        logger.info("签到接口》》》[sign request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "uid"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.updateSign(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("签到失败");
            } else {
                if ((Integer) dataMap.get("signed") == 1) {
                    dataMap.remove("signed");
                    responseJson.setStatusCode(CommonStatusEnums.SIGNED.getStatusCode());
                    responseJson.setStatusMsg(CommonStatusEnums.SIGNED.getStatusMsg());
                }
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[sign response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/outKindList", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String outKindList() throws IOException, ParseException {
        logger.info("二级种类列表接口》》》[outKindList request params] {}");
        ResponseJSONBean responseJson = new ResponseJSONBean();
        responseJson.setStatusCode(CommonStatusEnums.SUCCESS.getStatusCode());
        responseJson.setStatusMsg(CommonStatusEnums.SUCCESS.getStatusMsg());
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.getCKindList();
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取二级种类列表失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[outKindList response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/outVideoListPage", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String outVideoListPage(@RequestBody JSONObject jsonObject) throws IOException, ParseException {
        logger.info("外部视频列表接口》》》[outVideoListPage request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "kindId", "page", "size"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.getOutVideoList(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取外部视频列表失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[outVideoListPage response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/outVideoCount", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String outVideoCount(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("外部视频播放加一接口》》》[videoCount request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "ovid"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.updateOutVideoCount(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("外部视频播放加一失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[videoCount response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/recommendOutVideo", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String recommendOutVideo() throws IOException, ParseException {
        logger.info("推荐外部视频列表接口》》》[recommendOutVideo request params] {}");
        ResponseJSONBean responseJson = new ResponseJSONBean();
        responseJson.setStatusCode(CommonStatusEnums.SUCCESS.getStatusCode());
        responseJson.setStatusMsg(CommonStatusEnums.SUCCESS.getStatusMsg());
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.getRecommendOutVideoList();
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("获取推荐外部视频列表失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[recommendOutVideo response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/outVideoSearch", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String outVideoSearch(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("外部视频搜索接口》》》[outVideoSearch request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "keyword"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.getOutVideoSearch(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("外部视频搜索失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[outVideoSearch response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }

    @RequestMapping(value = "/feedback", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String feedback(@RequestBody JSONObject jsonObject) throws IOException {
        logger.info("意见反馈接口》》》[feedback request params] {}", jsonObject.toJSONString());
        // 请求参数中应该包含的Key
        String[] paramKeys = {"sign", "uid", "contactWay", "suggestion"};
        // jsonObject 参数校验
        ResponseJSONBean responseJson = indexService.validateRequestJson(jsonObject, paramKeys);
        Map<String, Object> dataMap = new HashMap<>();
        // 通过校验
        if (CommonStatusEnums.SUCCESS.getStatusCode().equals(responseJson.getStatusCode())) {
            dataMap = loginService.insertFeedback(jsonObject);
            if (dataMap == null) {
                responseJson.setStatusCode(CommonStatusEnums.FAILURE.getStatusCode());
                responseJson.setStatusMsg("提交意见反馈失败");
            }
        }
        responseJson.setData(dataMap == null ? new HashMap<String, Object>() : dataMap);
        logger.debug("[feedback response json string ] {}", responseJson.toJSONString());
        return responseJson.toJSONString();
    }
}
