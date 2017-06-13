package com.jz.xd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jz.xd.mapper.*;
import com.jz.xd.mapper.ext.ProductMapperExt;
import com.jz.xd.mapper.ext.VideoMapperExt;
import com.jz.xd.model.*;
import com.jz.xd.model.ext.ProductStock;
import com.jz.xd.service.shiro.Encrypt;
import com.jz.xd.util.*;
import it.sauronsoftware.jave.EncoderException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by HARU on 2017/3/21.
 */
@Service
public class IndexService {
    private static Logger logger = LogManager.getLogger(IndexService.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TbRProductStockMapper tbRProductStockMapper;
    @Autowired
    private ProductMapperExt productMapperExt;
    @Autowired
    private VideoMapperExt videoMapperExt;
    @Autowired
    private TbSysUserParticipateMapper tbSysUserParticipateMapper;
    @Autowired
    private TbSysUserBoyMapper tbSysUserBoyMapper;
    @Autowired
    private TbRProductVideoMapper tbRProductVideoMapper;
    @Autowired
    private TbSysProductMapper tbSysProductMapper;
    @Autowired
    TbSysUBeanDetailMapper tbSysUBeanDetailMapper;
    @Autowired
    private TbSysProvinceMapper tbSysProvinceMapper;
    @Autowired
    private TbSysCityMapper tbSysCityMapper;
    @Autowired
    private TbSysUBeanMapper tbSysUBeanMapper;
    @Autowired
    private TbRVideoMapper tbRVideoMapper;
    @Autowired
    private SPermissionMapper sPermissionMapper;
    @Autowired
    private PUMapper puMapper;

    private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";//发送验证码的请求路径URL
    public static String APP_KEY = "5970a1e2f463c2790b3fc90c7e1946ae";
    public static String APP_SECRET = "54f408825a94";
    public static String nonce;

    public List<User> getUserByPhone(String phone) {
        UserExample userExample1 = new UserExample();
        userExample1.createCriteria().andPhoneEqualTo(Long.valueOf(phone)).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample1);
        logger.debug("查找用户手机号", users.toString());
        return users;
    }

    public Object updateCheckUser(String username, String password, Boolean rememberMe) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        logger.debug("查找用户名", users.toString());
        if (users.size() == 0 && CheckMobile.isMobileNO(username)) {
            users = this.getUserByPhone(username);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        if (rememberMe == null) {
            rememberMe = false;
        }
        usernamePasswordToken.setRememberMe(rememberMe);
        subject.login(usernamePasswordToken);
        Object object = subject.getPrincipal();
        //把信息放在Shiro的session中
        //shiro默认的session就是httpSession
        subject.getSession().setAttribute("user", users.get(0));
        users.get(0).setLasttime(System.currentTimeMillis());
        int i = userMapper.updateByPrimaryKey(users.get(0));
        logger.debug("更新用户", ((Integer) i).toString());
        return object;
    }

    public User getUser(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        logger.debug("查找用户", users.toString());
        if (users.size() != 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    public int updateRegister(String username, String password, String password2, Integer forget, String cName, String cBirthday, String phone) throws ParseException {
//  public int updateRegister(String username, String password, String password2, Integer forget, String cName, String cAge, String cSex, String phone) throws ParseException {
        if (username.contains(" ") || password.contains(" ") || password2.contains(" ")) {
            return 1;
        }
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(password2)) {
            return -2;
        }
        if (!password.equals(password2)) {
            return -3;
        }
        String md5Password = Encrypt.md5hash(password, Encrypt.SALT);
        User user = new User();
        user.setUsername(username);
        user.setPassword(md5Password);
        user.setPhone(Long.valueOf(phone));
        user.setActive(1);
        int userMaxUid;
        if (forget == 0) {
            if (this.getUser(username) != null) {
                return -4;
            }
            UserExample userExample = new UserExample();
            List<User> users = userMapper.selectByExample(userExample);
            Integer maxUId = 0;
            for (User user1 : users) {
                if (user1.getUid() >= maxUId) {
                    maxUId = user1.getUid();
                }
            }
            userMaxUid = maxUId + 1;
            user.setUid(userMaxUid);
            int insert = userMapper.insert(user);
            logger.debug("注册用户", ((Integer) insert).toString());
            TbSysUserBoy tbSysUserBoy = new TbSysUserBoy();
            tbSysUserBoy.setUid(userMaxUid);
            tbSysUserBoy.setuBoyName(cName);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            String[] split = cBirthday.split("-");
            int age = Integer.parseInt(year) - Integer.parseInt(split[0]);
            tbSysUserBoy.setAge(String.valueOf(age + 1));
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdayDate = simpleDateFormat1.parse(cBirthday);
//            tbSysUserBoy.setAge(cAge);
//            tbSysUserBoy.setSex(cSex);
            tbSysUserBoy.setBirthday(birthdayDate);
            Date date = new Date();
            long time = date.getTime();
            tbSysUserBoy.setSyscreated(new Timestamp(time));
            tbSysUserBoy.setSex("保密");
            tbSysUserBoy.setActive(1);
            int insert1 = tbSysUserBoyMapper.insert(tbSysUserBoy);
            logger.debug("注册孩子", ((Integer) insert1).toString());

            TbSysUBeanDetail tbSysUBeanDetail = new TbSysUBeanDetail();
            tbSysUBeanDetail.setuId(userMaxUid);
            tbSysUBeanDetail.setAction(2);
            tbSysUBeanDetail.setDescribebean("注册");
            Date date1 = new Date();
            long time1 = date1.getTime();
            tbSysUBeanDetail.setSyscreated(new Timestamp(time1));
            tbSysUBeanDetail.setActive(1);
            tbSysUBeanDetail.setIncomePay(1);
            int insertBeanDetail = tbSysUBeanDetailMapper.insert(tbSysUBeanDetail);
            logger.debug("插入豆值支出收入详情", ((Integer) insertBeanDetail).toString());

            TbSysUBean tbSysUBean = new TbSysUBean();
            tbSysUBean.setBeanValAnother(0);
            tbSysUBean.setBeanVal(2);
            tbSysUBean.setuId(userMaxUid);
            tbSysUBean.setActive(1);
            Date date2 = new Date();
            long time2 = date2.getTime();
            tbSysUBean.setSyscreated(new Timestamp(time2));
            tbSysUBean.setBeanValPrize(0);
            int insertBeanValue = tbSysUBeanMapper.insert(tbSysUBean);
            logger.debug("插入用户豆值", ((Integer) insertBeanValue).toString());
            return userMaxUid;
        }
        if (forget == 1) {
            User user1 = this.getUserByPhone(phone).get(0);
            user1.setPassword(md5Password);
            int i = userMapper.updateByPrimaryKey(user1);
            logger.debug("更新用户", ((Integer) i).toString());
            return user1.getUid();
        }
        return 0;
    }

    public SendVerificationResult getMessage(String phone, Integer length, String mid) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);
        nonce = ((int) Math.random() * 100000) + "";
        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, nonce, curTime);
        post.addHeader("AppKey", APP_KEY);
        post.addHeader("Nonce", nonce);
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("mobile", phone));
        nameValuePairs.add(new BasicNameValuePair("codeLen", length + ""));
        nameValuePairs.add(new BasicNameValuePair("templateid", mid));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
        HttpResponse response = httpclient.execute(post);
        String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("接收到的结果:" + responseEntity);
        String resultCode = JSON.parseObject(responseEntity).getString("code");
        String sendId = JSON.parseObject(responseEntity).getString("msg");
        String verificationCode = JSON.parseObject(responseEntity).getString("obj");
        return new SendVerificationResult(resultCode, sendId, verificationCode);
    }

    public boolean getPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(Long.valueOf(phone)).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        logger.debug("查找手机号", users.toString());
        return users.size() > 0;
    }

    public List<TbSysProduct> getProduct(Integer typeId) {
        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPTypeEqualTo(typeId).andActiveEqualTo(1);
        tbSysProductExample.setOrderByClause("syscreated desc");
        List<TbSysProduct> tbSysProducts = tbSysProductMapper.selectByExample(tbSysProductExample);
        logger.debug("查找产品按创建时间排序", tbSysProducts.toString());
        return tbSysProducts;
    }

    public Map<Integer, Integer> getProductStock(List<TbSysProduct> robotProduct) {
        Map<Integer, Integer> mountMap = new HashMap<>();
        for (int i = 0; i < robotProduct.size(); i++) {
            TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
            tbRProductStockExample.createCriteria().andPIdEqualTo(robotProduct.get(i).getpId()).andActiveEqualTo(1);
            List<TbRProductStock> tbRProductStocks = tbRProductStockMapper.selectByExample(tbRProductStockExample);
            logger.debug("查找产品库存", tbRProductStocks.toString());
            mountMap.put(robotProduct.get(i).getpId(), tbRProductStocks.get(0).getpNum());
        }
        return mountMap;
    }

    public Integer getAllPages(Integer state, Integer size, Integer productKind) {
        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPTypeEqualTo(productKind).andBestNewEqualTo(state).andActiveEqualTo(1);
        tbSysProductExample.setOrderByClause("syscreated desc");
        List<TbSysProduct> tourismProduct = tbSysProductMapper.selectByExample(tbSysProductExample);
        logger.debug("查找旅游按创建时间排序", tourismProduct.toString());
        int allPages = tourismProduct.size() / size;
        if (tourismProduct.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<ProductStock> getTourismList(Integer state, Integer number, Integer size) {
        List<ProductStock> tourismProductByPage = productMapperExt.getProductJoinFun(state, number - 1, size);
        logger.debug("查找旅游按创建时间排序分页", tourismProductByPage.toString());
        return tourismProductByPage;
    }

    public TbSysProduct getTourismDetail(Integer pid) {
        TbSysProduct tourismDetail = productMapperExt.getProductByPid(pid);
        logger.debug("查找旅游详情按pid", tourismDetail.toString());
        return tourismDetail;
    }

    public Integer getVideoPages(Integer size) {
        List<TbRVideo> videos = videoMapperExt.getVideos(null, null, null);
        logger.debug("查找视频按创建时间排序", videos.toString());
        int allPages = videos.size() / size;
        if (videos.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<TbRVideo> getVideoList(Integer number, Integer size) {
        List<TbRVideo> videos = videoMapperExt.getVideos(null, number - 1, size);
        logger.debug("查找视频按创建时间排序分页", videos.toString());
        return videos;
    }

    public List<ProductStock> getCourse(String kind, String month, String age) {
        List<ProductStock> courseWithStock = productMapperExt.getCourseWithStock(kind, month, age);
        logger.debug("查找课程按科目月份年龄", courseWithStock.toString());
        return courseWithStock;
    }

    public List getMonths(String kind) {
        List monthList = new LinkedList();
        if (!StringUtils.isEmpty(kind)) {
            if ("全部科目".equals(kind)) {
                monthList.add("半年");
                monthList.add("一年");
            }
            if ("生命科学".equals(kind)) {
                monthList.add("1月份");
                monthList.add("7月份");
                monthList.add("1和7月份");
            }
            if ("玩转数理".equals(kind)) {
                monthList.add("2月份");
                monthList.add("8月份");
                monthList.add("2和8月份");
            }
            if ("趣味生活".equals(kind)) {
                monthList.add("3月份");
                monthList.add("9月份");
                monthList.add("3和9月份");
            }
            if ("天文地理".equals(kind)) {
                monthList.add("4月份");
                monthList.add("10月份");
                monthList.add("4和10月份");
            }
            if ("奇趣物化".equals(kind)) {
                monthList.add("5月份");
                monthList.add("11月份");
                monthList.add("5和11月份");
            }
            if ("美劳美艺".equals(kind)) {
                monthList.add("6月份");
                monthList.add("12月份");
                monthList.add("6和12月份");
            }
        }
        return monthList;
    }

   /* public List getMonths(String kind) {
        List monthList = new LinkedList();
        if (!StringUtils.isEmpty(kind)) {
            if ("全选".equals(kind)) {
                monthList.add("半年");
                monthList.add("一年");
            }
            if ("生命科学".equals(kind)) {
                monthList.add("1月份");
                monthList.add("7月份");
                monthList.add("全选");
            }
            if ("玩转数理".equals(kind)) {
                monthList.add("2月份");
                monthList.add("8月份");
                monthList.add("全选");
            }
            if ("趣味生活".equals(kind)) {
                monthList.add("3月份");
                monthList.add("9月份");
                monthList.add("全选");
            }
            if ("天文地理".equals(kind)) {
                monthList.add("4月份");
                monthList.add("10月份");
                monthList.add("全选");
            }
            if ("奇趣物化".equals(kind)) {
                monthList.add("5月份");
                monthList.add("11月份");
                monthList.add("全选");
            }
            if ("美劳美艺".equals(kind)) {
                monthList.add("6月份");
                monthList.add("12月份");
                monthList.add("全选");
            }
        }
        return monthList;
    }*/

    public Integer getVideos(Integer size, List<ProductStock> courses) {
        List<TbRVideo> videoList = new LinkedList<>();
        for (TbSysProduct course : courses) {
            List<TbRVideo> videos = videoMapperExt.getVideos(course.getId(), null, null);
            logger.debug("查找视频按创建时间排序和课程ID", videos.toString());
            videoList.addAll(videos);
        }
        int allPages = videoList.size() / size;
        if (videoList.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<TbRVideo> getVideosList(Integer number, Integer size, List<ProductStock> courses) {
        List<TbRVideo> videoList = new LinkedList<>();
        for (TbSysProduct course : courses) {
            List<TbRVideo> videos = videoMapperExt.getVideos(course.getpId(), null, null);
            //修改图片地址
            logger.debug("查找视频按创建时间排序和课程ID", videos.toString());
            videoList.addAll(videos);
        }
        int start = (number - 1) * size;
        int end = number * size;
        if (size > videoList.size() - ((number - 1) * size)) {
            end = videoList.size();
        }
        videoList = videoList.subList(start, end);
        return videoList;
    }

    public TbRVideo getVideoDetail(Integer vid) {
        TbRVideo videoDetail = videoMapperExt.getVideoDetail(vid);
        logger.debug("查找视频详情", videoDetail.toString());
        return videoDetail;
    }

    public TbRVideo updateVideoDetail(Integer vid) {
        TbRVideo videoDetail = this.getVideoDetail(vid);
        if (videoDetail == null) {
            return null;
        }
        videoDetail.setPlayCount(videoDetail.getPlayCount() + 1);
        int i = tbRVideoMapper.updateByPrimaryKey(videoDetail);
        logger.debug("视频播放数加一", i);
        return videoDetail;
    }

    public List<TbRVideo> getVideoList(Integer vid) {
        List<TbRVideo> list = new LinkedList<>();
        TbRProductVideoExample tbRProductVideoExample = new TbRProductVideoExample();
        tbRProductVideoExample.createCriteria().andVIdEqualTo(vid).andActiveEqualTo(1);
        List<TbRProductVideo> tbRProductVideos = tbRProductVideoMapper.selectByExample(tbRProductVideoExample);
        logger.debug("查找视频课程关联", tbRProductVideos.toString());

        Integer pid = tbRProductVideos.get(0).getpId();


        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPIdEqualTo(pid).andActiveEqualTo(1);
        List<TbSysProduct> tbSysProducts = tbSysProductMapper.selectByExample(tbSysProductExample);
        logger.debug("查找视频所属课程", tbSysProducts.toString());

        TbSysProduct tbSysProduct = tbSysProducts.get(0);
        String month = tbSysProduct.getpMonth();
        String kind = tbSysProduct.getpKind();
        TbSysProductExample tbSysProductExample1 = new TbSysProductExample();
        tbSysProductExample1.createCriteria().andPMonthEqualTo(month).andPKindEqualTo(kind).andActiveEqualTo(1);
        tbSysProductExample1.setOrderByClause("syscreated asc");
        List<TbSysProduct> tbSysProductsList = tbSysProductMapper.selectByExample(tbSysProductExample1);
        logger.debug("查找课程相关视频", tbSysProductsList.toString());

        for (TbSysProduct tbSysProduct1 : tbSysProductsList) {
            if (!"全年龄".equals(tbSysProduct1.getpAge())) {
                Integer pid2 = tbSysProduct1.getpId();
                TbRProductVideoExample tbRProductVideoExample1 = new TbRProductVideoExample();
                tbRProductVideoExample1.createCriteria().andPIdEqualTo(pid2).andActiveEqualTo(1);
                List<TbRProductVideo> tbRProductVideos1 = tbRProductVideoMapper.selectByExample(tbRProductVideoExample1);
                logger.debug("查找课程相关视频ID", tbRProductVideos1.toString());
                Integer vid1 = tbRProductVideos1.get(0).getvId();
                TbRVideo videoDetail = this.getVideoDetail(vid1);
                if (!vid.equals(vid1)) {
                    list.add(videoDetail);
                }
            }
        }

        /*TbRProductVideoExample tbRProductVideoExample1 = new TbRProductVideoExample();
        tbRProductVideoExample1.createCriteria().andPIdEqualTo(pid).andActiveEqualTo(1);
        List<TbRProductVideo> tbRProductVideos1 = tbRProductVideoMapper.selectByExample(tbRProductVideoExample1);
        logger.debug("查找课程包含的视频", tbRProductVideos1.toString());

        for (TbRProductVideo tbRProductVideo : tbRProductVideos1) {
            Integer vid1 = tbRProductVideo.getvId();
            TbRVideo videoDetail = this.getVideoDetail(vid1);
            if (!vid.equals(vid1)) {
                list.add(videoDetail);
            }
        }*/
        return list;
    }

    public List<Long> getVideoTime(HttpSession session, List<TbRVideo> videoList) throws EncoderException {
        List<Long> timeList = new LinkedList<>();
        for (TbRVideo tbRVideo : videoList) {
            String videoName = "D:\\ziyuan\\image\\" + tbRVideo.getvName();
            Long videoTime = VideoUtils.getVideoTime(session, videoName);
            timeList.add(videoTime);
        }
        return timeList;
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int insertParticipate(Participate participate) {
        TbSysUserParticipate tbSysUserParticipate = new TbSysUserParticipate();
        tbSysUserParticipate.setuBoyName(participate.getName());
        tbSysUserParticipate.setSex(participate.getSex());
        tbSysUserParticipate.setPhone(participate.getPhone());
        tbSysUserParticipate.setAddress(participate.getAddress());

        tbSysUserParticipate.setCity(participate.getCity());
        if (isNumeric(participate.getCity())) {
            TbSysCityExample tbSysCityExample = new TbSysCityExample();
            tbSysCityExample.createCriteria().andCityIdEqualTo(Integer.valueOf(participate.getCity())).andActiveEqualTo(1);
            List<TbSysCity> tbSysCities = tbSysCityMapper.selectByExample(tbSysCityExample);
            logger.debug("查找城市", tbSysCities.toString());
            String cityName = tbSysCities.get(0).getCityName();
            tbSysUserParticipate.setCity(cityName);
        }

        tbSysUserParticipate.setArea(participate.getProvince());
        if (isNumeric(participate.getProvince())) {
            TbSysProvinceExample tbSysProvinceExample = new TbSysProvinceExample();
            tbSysProvinceExample.createCriteria().andProIdEqualTo(Integer.valueOf(participate.getProvince())).andActiveEqualTo(1);
            List<TbSysProvince> tbSysProvinces = tbSysProvinceMapper.selectByExample(tbSysProvinceExample);
            logger.debug("查找省份", tbSysProvinces.toString());
            String proName = tbSysProvinces.get(0).getProName();
            tbSysUserParticipate.setArea(proName);
        }

        Date date = new Date();
        long time = date.getTime();
        tbSysUserParticipate.setSyscreated(new Timestamp(time));
        tbSysUserParticipate.setActive(1);
        int insert = tbSysUserParticipateMapper.insert(tbSysUserParticipate);
        logger.debug("插入报名预约", ((Integer) insert).toString());
        return insert;
    }

    public List<SPermission> getPermission(User user) {
        List<SPermission> permissions = new ArrayList<>();
        PUExample puExample = new PUExample();
        puExample.createCriteria().andUidEqualTo(user.getUid());
        List<PU> pus = puMapper.selectByExample(puExample);
        logger.debug("查找用户权限", pus.toString());
        for (PU pu : pus) {
            SPermissionExample sPermissionExample = new SPermissionExample();
            sPermissionExample.createCriteria().andPridEqualTo(pu.getPrid());
            List<SPermission> sPermissions = sPermissionMapper.selectByExample(sPermissionExample);
            logger.debug("查找权限说明", sPermissions.toString());
            permissions.add(sPermissions.get(0));
        }
        return permissions;
    }

    public Map<String, Object> insertParticipateInterface(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        Participate participate = new Participate();
        participate.setAddress(jsonObject.getString("address"));
        participate.setAdultName(jsonObject.getString("adultName"));
        participate.setCity(jsonObject.getString("city"));
        participate.setName(jsonObject.getString("name"));
        participate.setPhone(jsonObject.getString("phone"));
        participate.setProvince(jsonObject.getString("province"));
        participate.setSex(jsonObject.getString("sex"));
        int row = this.insertParticipate(participate);
        if (row == 0) {
            logger.info("插入报名记录失败");
            return null;
        }
        returnMap.put("row", row);
        return returnMap;
    }

    public Map<String, Object> getVideoList() {
        String[] age = {"3~6岁", "6~8岁", "8~10岁", "10~12岁"};
        String[] ageKey = {"three", "six", "eight", "ten"};
        String[] kind = {"生命科学", "玩转数理", "趣味生活", "天文地理", "奇趣物化", "美劳美艺"};
        String[] kindKey = {"science", "mathematics", "life", "geography", "physics", "labour"};
        Map<String, Object> responseMap = new LinkedHashMap<>();
        int i = 0;
        for (String ageItem : age) {
            int j = 0;
            Map<String, List<TbRVideo>> map = new LinkedHashMap<>();
            for (String kindItem : kind) {
                TbSysProductExample tbSysProductExample1 = new TbSysProductExample();
                tbSysProductExample1.createCriteria().andPAgeEqualTo(ageItem).andPKindEqualTo(kindItem).andActiveEqualTo(1);
                tbSysProductExample1.setOrderByClause("syscreated asc");
                List<TbSysProduct> tbSysProductsList = tbSysProductMapper.selectByExample(tbSysProductExample1);
                if (tbSysProductsList == null) {
                    return null;
                }
                logger.debug("查找课程", tbSysProductsList.toString());
                List<TbRVideo> videos = new LinkedList<>();
                for (TbSysProduct tbSysProduct : tbSysProductsList) {
                    Integer pid2 = tbSysProduct.getpId();
                    TbRProductVideoExample tbRProductVideoExample1 = new TbRProductVideoExample();
                    tbRProductVideoExample1.createCriteria().andPIdEqualTo(pid2).andActiveEqualTo(1);
                    tbRProductVideoExample1.setOrderByClause("syscreated asc");
                    List<TbRProductVideo> tbRProductVideos = tbRProductVideoMapper.selectByExample(tbRProductVideoExample1);
                    if (tbRProductVideos == null) {
                        return null;
                    }
                    logger.debug("查找课程相关视频ID", tbRProductVideos.toString());
                    for (TbRProductVideo tbRProductVideo : tbRProductVideos) {
                        Integer vid = tbRProductVideo.getvId();
                        TbRVideo videoDetail = this.getVideoDetail(vid);
                        videos.add(videoDetail);
                    }
                }
                map.put(kindKey[j++], videos);
            }
            responseMap.put(ageKey[i++], map);
        }
        return responseMap;
    }

    public Map<String, Object> updateVideoCount(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        TbRVideo tbRVideo = this.updateVideoDetail(jsonObject.getInteger("vid"));
        if (tbRVideo == null) {
            logger.info("视频播放加一失败");
            return null;
        }
        returnMap.put("videoDetail", tbRVideo);
        return returnMap;
    }

    public Object updateCheckUserInterface(JSONObject jsonObject) {
        String password = jsonObject.getString("password");
        Object o = updateCheckUser(jsonObject.getString("username"), password, true);
        if (o == null) {
            return null;
        }
        return o;
    }

    public Map<String, Object> getValidateCode(JSONObject jsonObject) throws IOException {
        Map<String, Object> returnMap = new HashMap<>();
        SendVerificationResult phone = getMessage(jsonObject.getString("phone"), 4, "3056497");
        if (phone == null) {
            return null;
        }
        returnMap.put("result", phone);
        return returnMap;
    }

    public int validateMember(JSONObject jsonObject) throws IOException, ParseException {
        return 0;
//        return updateRegister(jsonObject.getString("username"), jsonObject.getString("password"), jsonObject.getString("password"), 0, jsonObject.getString("beanname"), jsonObject.getString("age"), jsonObject.getString("sex"), jsonObject.getString("phonenum"));
    }

    public Map<String, Object> registerMember(int uid) {
        Map<String, Object> returnMap = new HashMap<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidEqualTo(uid).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() <= 0) {
            return null;
        }
        logger.debug("查找用户按UID", users.toString());
        if (users.size() > 0) {
            User user = users.get(0);
            returnMap.put("uid", user.getUid());
            returnMap.put("username", user.getUsername());
            returnMap.put("password", user.getPassword());
            returnMap.put("phonenum", user.getPhone());
            TbSysUserBoyExample tbSysUserBoyExample = new TbSysUserBoyExample();
            tbSysUserBoyExample.createCriteria().andUidEqualTo(user.getUid()).andActiveEqualTo(1);
            List<TbSysUserBoy> tbSysUserBoys = tbSysUserBoyMapper.selectByExample(tbSysUserBoyExample);
            if (tbSysUserBoys == null || tbSysUserBoys.size() <= 0) {
                return null;
            }
            logger.debug("查找孩子", tbSysUserBoys.toString());
            if (tbSysUserBoys.size() > 0) {
                TbSysUserBoy children = tbSysUserBoys.get(0);
                returnMap.put("beanname", children.getuBoyName());
                returnMap.put("age", children.getAge());
                returnMap.put("sex", children.getSex());
            }
        }
        return returnMap;
    }

    public ResponseJSONBean validateRequestJson(JSONObject requestJson, String[] paramKeys) {
        ResponseJSONBean responseJSONBean = new ResponseJSONBean();
        responseJSONBean.setStatusCode(CommonStatusEnums.SUCCESS.getStatusCode());
        responseJSONBean.setStatusMsg(CommonStatusEnums.SUCCESS.getStatusMsg());
        // 验证参数不为空
        if (requestJson == null) {
            responseJSONBean.setStatusCode(CommonStatusEnums.ERROR_REQUEST_PARAM_FORMAT.getStatusCode());
            responseJSONBean.setStatusMsg(CommonStatusEnums.ERROR_REQUEST_PARAM_FORMAT.getStatusMsg());
            logger.error("validateRequestJson error [{}]", responseJSONBean.getStatusMsg());
            return responseJSONBean;
        }
        // 验证key
        for (String paramKey : paramKeys) {
            if (!requestJson.containsKey(paramKey)) {
                responseJSONBean.setStatusCode(CommonStatusEnums.ERROR_REQUEST_PARAM_NULL.getStatusCode());
                responseJSONBean.setStatusMsg(CommonStatusEnums.ERROR_REQUEST_PARAM_NULL.getStatusMsg().replace("{}", "{" + paramKey + "}"));
                logger.error("validateRequestJson error [{}]", responseJSONBean.getStatusMsg());
                return responseJSONBean;
            }
        }
        // 验签
        boolean validateSignSuccess = MD5.vlidateMD5sign(DataConvertUtil.jsonToMap(new org.json.JSONObject(requestJson.toJSONString())), "testJIZHIsignKey");
        if (validateSignSuccess) {
            responseJSONBean.setStatusCode(CommonStatusEnums.SUCCESS.getStatusCode());
            responseJSONBean.setStatusMsg(CommonStatusEnums.SUCCESS.getStatusMsg());
            requestJson.remove("sign");
        } else {
            responseJSONBean.setStatusCode(CommonStatusEnums.SIGN_ERROR.getStatusCode());
            responseJSONBean.setStatusMsg(CommonStatusEnums.SIGN_ERROR.getStatusMsg());
            logger.error("validateRequestJson error [{}]", responseJSONBean.getStatusMsg());
            return responseJSONBean;
        }
        return responseJSONBean;
    }

}
