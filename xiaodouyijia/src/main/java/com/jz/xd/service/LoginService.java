package com.jz.xd.service;

import com.github.pagehelper.PageHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jz.xd.mapper.*;
import com.jz.xd.mapper.ext.*;
import com.jz.xd.model.*;
import com.jz.xd.model.ext.*;
import com.jz.xd.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HARU on 2017/3/17.
 */
@Service
public class LoginService {
    private static Logger logger = LogManager.getLogger(LoginService.class);
    @Autowired
    private IndexService indexService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TbSysUserBoyMapper tbSysUserBoyMapper;
    @Autowired
    private TbSysUserAddressMapper tbSysUserAddressMapper;
    @Autowired
    private TbSysProvinceMapper tbSysProvinceMapper;
    @Autowired
    private TbSysCityMapper tbSysCityMapper;
    @Autowired
    private TbSysCityAreaMapper tbSysCityAreaMapper;
    @Autowired
    private TbROrderMapper tbROrderMapper;
    @Autowired
    private ProductMapperExt productMapperExt;
    @Autowired
    private CouponMapperExt couponMapperExt;
    @Autowired
    private TbRRequestcodeTjrLogMapper tbRRequestcodeTjrLogMapper;
    @Autowired
    private TbSysUBeanMapper tbSysUBeanMapper;
    @Autowired
    private TbSysUBeanDetailMapper tbSysUBeanDetailMapper;
    @Autowired
    private TbSysDiscountpageTypeMapper tbSysDiscountpageTypeMapper;
    @Autowired
    private TbRUDiscountpageLogMapper tbRUDiscountpageLogMapper;
    @Autowired
    private AddressMapperExt addressMapperExt;
    @Autowired
    private TbRULoginLogMapper tbRULoginLogMapper;
    @Autowired
    private SignMapperExt signMapperExt;
    @Autowired
    private TbRProductStockMapper tbRProductStockMapper;
    @Autowired
    private TbSysProductMapper tbSysProductMapper;
    @Autowired
    private TbROrderGoodsMapper tbROrderGoodsMapper;
    @Autowired
    private ItemsMapperExt itemsMapperExt;
    @Autowired
    private TbRRequestcodeNtjrLogMapper tbRRequestcodeNtjrLogMapper;
    @Autowired
    private OutvideoMapper outvideoMapper;
    @Autowired
    private OutkindMapper outkindMapper;
    @Autowired
    private OutVideoExt outVideoExt;
    @Autowired
    private FeedbackMapper feedbackMapper;

    private static String fictitiousPath = "/file/";
    //    private static String fictitiousPath = "http://oqhj39gfk.bkt.clouddn.com/";//七牛云远程地址
    private String newFileName = "";
    private List<City> provinces = new LinkedList<>();
    private String[] validateCode = new String[2];
    private List<TbSysCity> tbSysCities = new LinkedList<>();
    private List<AddressExt> tbSysUserAddresses = new LinkedList<>();
    private String provinceCode;
    private int[][] signArray = new int[6][7];
    private int[][] currentCalendar = new int[6][7];
    private Integer continuityDay;
    private Integer oid = 0;
    private StringBuffer sb = null;
    private Integer couponId;
    private String invitation;
    private Integer point;
    private TbROrder tbROrder;
    private String preONo = "";

    public void updateProductStock(Integer pid, Integer mount) {
        TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
        tbRProductStockExample.createCriteria().andPIdEqualTo(pid).andActiveEqualTo(1);
        List<TbRProductStock> tbRProductStocks = tbRProductStockMapper.selectByExample(tbRProductStockExample);
        logger.debug("通过pid查找库存信息", tbRProductStocks.toString());
        if (tbRProductStocks.size() > 0) {
            TbRProductStock tbRProductStockData = tbRProductStocks.get(0);
            Integer surplusMount = tbRProductStockData.getpNum() - mount;
            tbRProductStockData.setpNum(surplusMount);
            int column = tbRProductStockMapper.updateByPrimaryKey(tbRProductStockData);
            logger.debug("修改库存信息", column);
        }
    }

    public Integer createOrders(Integer state, List<TbSysProduct> tbSysProducts, Integer mount, Integer mount2, Date date1, long time1) {
        TbROrder tbROrder = new TbROrder();
        tbROrder.setActive(1);
        tbROrder.setuId(this.getUser().getUid());
        tbROrder.setSyscreated(new Timestamp(time1));
        tbROrder.setBuyTime(new Timestamp(time1));
        tbROrder.setoStates(state);
        Integer maxOId = 0;
        TbROrderExample tbROrderExample1 = new TbROrderExample();
        tbROrderExample1.createCriteria().andActiveEqualTo(1);
        List<TbROrder> tbROrders1 = tbROrderMapper.selectByExample(tbROrderExample1);
        logger.debug("查找所有的订单", tbROrders1.toString());
        for (TbROrder tbROrder1 : tbROrders1) {
            if (tbROrder1.getoId() > maxOId) {
                maxOId = tbROrder1.getoId();
            }
        }
        tbROrder.setoId(maxOId + 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(date1);
        tbROrder.setoNo(format + this.getUser().getUid() + tbROrder.getoId());
        Integer price1 = tbSysProducts.get(0).getpPrice();
        Integer price2 = tbSysProducts.get(0).getpPriceBoy();
        if (price2 == null) {
            price2 = 0;
        }
        Integer cMount = mount2;
        if (cMount == null) {
            cMount = 0;
        }
        tbROrder.setTotalFee(price1 * mount + price2 * cMount);
        int insert = tbROrderMapper.insert(tbROrder);
        logger.debug("创建购物车订单", ((Integer) insert).toString());
        oid = maxOId + 1;
        return maxOId;
    }

    public void createOrderItem(Integer maxOId, List<TbSysProduct> tbSysProducts, Integer mount, Integer mount2, Integer pid, long time1) {
        TbROrderGoods tbROrderGoods = new TbROrderGoods();
        tbROrderGoods.setoId(maxOId + 1);
        tbROrderGoods.setActive(1);
        tbROrderGoods.setpPrice(tbSysProducts.get(0).getpPrice());
        tbROrderGoods.setcPrice(tbSysProducts.get(0).getpPriceBoy());
        if (mount2 == null) {
            tbROrderGoods.setNum(mount);
        } else {
            tbROrderGoods.setLargMenNum(mount);
            tbROrderGoods.setSmallMenNum(mount2);
        }
        tbROrderGoods.setpId(pid);
        tbROrderGoods.setpName(tbSysProducts.get(0).getpName());
        tbROrderGoods.setImg(tbSysProducts.get(0).getImg());
        tbROrderGoods.setSyscreated(new Timestamp(time1));
        tbROrderGoods.setSendNum(0);

        TbROrderGoodsExample tbROrderGoodsExample = new TbROrderGoodsExample();
        tbROrderGoodsExample.createCriteria().andPIdEqualTo(pid).andOIdEqualTo(maxOId + 1).andActiveEqualTo(1);
        List<TbROrderGoods> tbROrderGoodses = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample);
        logger.debug("查找同一件商品", tbROrderGoodses.toString());
        if (tbROrderGoodses.size() > 0 && tbROrderGoodses.get(0).getNum() != null) {
            TbROrderGoods tbROrderGoods1 = tbROrderGoodses.get(0);
            tbROrderGoodses.get(0).setNum(tbROrderGoodses.get(0).getNum() + mount);
            int i = tbROrderGoodsMapper.updateByPrimaryKey(tbROrderGoods1);
            logger.debug("更新同一件商品", ((Integer) i).toString());
        } else {
            int insert1 = tbROrderGoodsMapper.insert(tbROrderGoods);
            logger.debug("创建购物车订单项", ((Integer) insert1).toString());
        }
    }

    public void createBuyOrder(Integer mount, Integer mount2, Integer pid) {
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andOStatesEqualTo(0).andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找是否有处于购买创建的订单", tbROrders.toString());

        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPIdEqualTo(pid).andActiveEqualTo(1);
        List<TbSysProduct> tbSysProducts = tbSysProductMapper.selectByExample(tbSysProductExample);
        logger.debug("查找商品信息", tbSysProducts.toString());

        Date date1 = new Date();
        long time1 = date1.getTime();

        Integer maxOId = this.createOrders(0, tbSysProducts, mount, mount2, date1, time1);
        this.createOrderItem(maxOId, tbSysProducts, mount, mount2, pid, time1);
    }

    public void createOrder(Integer mount, Integer mount2, Integer pid) {
        //先去查找是否有处于购物车创建状态的订单，有，直接插入订单项；没有，创建新订单。
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andOStatesEqualTo(1).andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找是否有处于购物车创建的订单", tbROrders.toString());

        TbSysProductExample tbSysProductExample = new TbSysProductExample();
        tbSysProductExample.createCriteria().andPIdEqualTo(pid).andActiveEqualTo(1);
        List<TbSysProduct> tbSysProducts = tbSysProductMapper.selectByExample(tbSysProductExample);
        logger.debug("查找商品信息", tbSysProducts.toString());

        Date date1 = new Date();
        long time1 = date1.getTime();
        if (tbROrders.size() > 0) {
            Integer price0 = tbSysProducts.get(0).getpPrice();
            Integer price3 = tbSysProducts.get(0).getpPriceBoy();
            if (price3 == null) {
                price3 = 0;
            }
            Integer cMount2 = mount2;
            if (cMount2 == null) {
                cMount2 = 0;
            }
            tbROrders.get(0).setTotalFee(tbROrders.get(0).getTotalFee() + price0 * mount + price3 * cMount2);
            int i = tbROrderMapper.updateByPrimaryKey(tbROrders.get(0));
            logger.debug("更新订单总价", ((Integer) i).toString());
            this.createOrderItem(tbROrders.get(0).getoId() - 1, tbSysProducts, mount, mount2, pid, time1);
        } else {
            Integer maxOId = this.createOrders(1, tbSysProducts, mount, mount2, date1, time1);
            this.createOrderItem(maxOId, tbSysProducts, mount, mount2, pid, time1);
        }
    }

    public List<ItemsExt> updateShopCarItem(Integer state) {
        TbROrderExample tbROrderExample0 = new TbROrderExample();
        tbROrderExample0.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(2).andActiveEqualTo(1);
        List<TbROrder> tbROrders0 = tbROrderMapper.selectByExample(tbROrderExample0);
        logger.debug("查找用户之前未提交的订单", tbROrders0.toString());
        if (tbROrders0.size() > 0) {
            for (TbROrder tbROrder : tbROrders0) {
                int i = tbROrderMapper.deleteByPrimaryKey(tbROrder.getId());
                logger.debug("删除用户之前未提交的订单", ((Integer) i).toString());
            }
        }

        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(state).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找用户之前购物车生产的订单", tbROrders.toString());
        if (tbROrders.size() > 0) {
            oid = tbROrders.get(0).getoId();
        } else {
            oid = 0;
        }
        List<ItemsExt> tbROrderGoodsList = itemsMapperExt.getOrderItems(oid);
        logger.debug("查找订单项", tbROrderGoodsList.toString());
        return tbROrderGoodsList;
    }

    public Integer checkInvitation(String invitation) {
        TbRRequestcodeTjrLogExample tbRRequestcodeTjrLogExample = new TbRRequestcodeTjrLogExample();
        tbRRequestcodeTjrLogExample.createCriteria().andRcodeEqualTo(invitation).andActiveEqualTo(1);
        List<TbRRequestcodeTjrLog> tbRRequestcodeTjrLogs = tbRRequestcodeTjrLogMapper.selectByExample(tbRRequestcodeTjrLogExample);
        logger.debug("查找邀请码", tbRRequestcodeTjrLogs.toString());
        if (tbRRequestcodeTjrLogs.size() <= 0) {
            return 1;
        } else {
            Date syscreated = tbRRequestcodeTjrLogs.get(0).getSyscreated();
            Date nowDate = new Date();
            if (nowDate.getTime() - syscreated.getTime() > ((long) (tbRRequestcodeTjrLogs.get(0).getDurationDay())) * 24 * 60 * 60 * 1000) {
                return 2;
            } else {
                TbRRequestcodeNtjrLogExample tbRRequestcodeNtjrLogExample = new TbRRequestcodeNtjrLogExample();
                tbRRequestcodeNtjrLogExample.createCriteria().andUserIdEqualTo(this.getUser().getUid()).andRcodeEqualTo(invitation).andActiveEqualTo(1);
                List<TbRRequestcodeNtjrLog> tbRRequestcodeNtjrLogs = tbRRequestcodeNtjrLogMapper.selectByExample(tbRRequestcodeNtjrLogExample);
                logger.debug("查找使用人邀请码", tbRRequestcodeNtjrLogs.toString());
                if (tbRRequestcodeNtjrLogs.size() > 0) {
                    return 3;
                } else {
                    return 4;
                }
            }
        }
    }

    public void deleteItem(Integer itemId) {
        TbROrderGoodsExample tbROrderGoodsExample = new TbROrderGoodsExample();
        tbROrderGoodsExample.createCriteria().andIdEqualTo(itemId).andActiveEqualTo(1);
        List<TbROrderGoods> tbROrderGoodses = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample);
        logger.debug("查找订单项", tbROrderGoodses.toString());
        if (tbROrderGoodses.size() > 0) {
            TbROrderGoods tbROrderGoods = tbROrderGoodses.get(0);

            TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
            tbRProductStockExample.createCriteria().andPIdEqualTo(tbROrderGoods.getpId()).andActiveEqualTo(1);
            List<TbRProductStock> tbRProductStocks1 = tbRProductStockMapper.selectByExample(tbRProductStockExample);
            logger.debug("查找库存", tbRProductStocks1.toString());
            if (tbRProductStocks1.size() > 0 && tbROrderGoods.getNum() != null) {
                TbRProductStock tbRProductStock1 = tbRProductStocks1.get(0);
                tbRProductStock1.setpNum(tbRProductStock1.getpNum() + tbROrderGoods.getNum());
                int i1 = tbRProductStockMapper.updateByPrimaryKey(tbRProductStock1);
                logger.debug("还原商品库存", ((Integer) i1).toString());
            }

            int i = tbROrderGoodsMapper.deleteByPrimaryKey(tbROrderGoods.getId());
            logger.debug("模拟删除订单项", ((Integer) i).toString());

            Integer num = tbROrderGoods.getNum();
            Integer pPrice = tbROrderGoods.getpPrice();
            Integer cPrice = tbROrderGoods.getcPrice();
            Integer largMenNum = tbROrderGoods.getLargMenNum();
            Integer smallMenNum = tbROrderGoods.getSmallMenNum();
            Integer totalPrice = 0;
            if (cPrice == null) {
                totalPrice = pPrice * num;
            } else {
                totalPrice = pPrice * largMenNum + cPrice * smallMenNum;
            }

            TbROrderExample tbROrderExample0 = new TbROrderExample();
            tbROrderExample0.createCriteria().andOIdEqualTo(tbROrderGoods.getoId()).andActiveEqualTo(1);
            List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample0);
            logger.debug("查找订单", tbROrders.toString());
            TbROrder tbROrder = tbROrders.get(0);
            tbROrder.setTotalFee(tbROrder.getTotalFee() - totalPrice);
            int i2 = tbROrderMapper.updateByPrimaryKey(tbROrder);
            logger.debug("修改总价", ((Integer) i2).toString());

            TbROrderGoodsExample tbROrderGoodsExample1 = new TbROrderGoodsExample();
            tbROrderGoodsExample1.createCriteria().andOIdEqualTo(tbROrderGoods.getoId()).andActiveEqualTo(1);
            List<TbROrderGoods> tbROrderGoodses1 = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample1);
            logger.debug("查找订单中是否还有订单项", tbROrderGoodses1.toString());
            if (tbROrderGoodses1.size() <= 0) {
                int i1 = tbROrderMapper.deleteByPrimaryKey(tbROrder.getId());
                logger.debug("模拟删除订单", ((Integer) i1).toString());
            }
        }
    }

    public User getUser() {
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getSession().getAttribute("user");
    }

    public void insertAddress() {
        String weather = Wweather.weather();
        String[] split = weather.split(",");
        for (int i = 0; i < split.length; ++i) {
            String[] strArr = split[i].split("\\|");
            /*TbSysProvince tbSysProvince = new TbSysProvince();
            tbSysProvince.setProId(Integer.valueOf(strArr[0]));
            tbSysProvince.setProName(strArr[1]);
            tbSysProvince.setActive(1);
            Date date0 = new Date();
            long time0 = date0.getTime();
            tbSysProvince.setSyscreated(new Timestamp(time0));
            tbSysProvinceMapper.insert(tbSysProvince);*/
            String[] strArray2 = Wweather.secondCity(strArr[0]).split(",");
            for (int j = 0; j < strArray2.length; ++j) {
                /*TbSysCity tbSysCity = new TbSysCity();
                tbSysCity.setActive(1);
                tbSysCity.setProId(Integer.valueOf(strArr[0]));
                Date date = new Date();
                long time = date.getTime();
                tbSysCity.setSyscreated(new Timestamp(time));
                tbSysCity.setCityName(strArray2[j].split("\\|")[1]);
                tbSysCity.setCityId(Integer.valueOf(strArray2[j].split("\\|")[0]));
                tbSysCityMapper.insert(tbSysCity);*/
                String[] strArray3 = Wweather.weatherCityId(strArray2[j].split("\\|")[0]).split(",");
                for (int m = 0; m < strArray3.length; ++m) {
                    TbSysCityArea tbSysCityArea = new TbSysCityArea();
                    tbSysCityArea.setCityId(Integer.valueOf(strArray2[j].split("\\|")[0]));
                    tbSysCityArea.setProId(Integer.valueOf(strArr[0]));
                    tbSysCityArea.setActive(1);
                    Date date1 = new Date();
                    long time1 = date1.getTime();
                    tbSysCityArea.setSyscreated(new Timestamp(time1));
                    tbSysCityArea.setAreaId(Integer.valueOf(strArray3[m].split("\\|")[0]));
                    tbSysCityArea.setAreaName(strArray3[m].split("\\|")[1]);
                    tbSysCityAreaMapper.insert(tbSysCityArea);
                }
            }
        }
    }

    public void uploadHead(String head) throws IOException {
        newFileName = FileUtils.base642File(head);
    }

    public void updateUserHead(User newUser) {
        if (!newFileName.equals("")) {
            newUser.setImg(fictitiousPath + newFileName);
        }
        int id = userMapper.updateByPrimaryKey(newUser);
        logger.debug("更新用户头像", ((Integer) id).toString());
    }

    public void updateUserRecommendHead(String head) {
        User user = this.getUser();
        user.setImg("/resources/image/" + head);
        int id = userMapper.updateByPrimaryKey(user);
        logger.debug("更新用户推荐头像", ((Integer) id).toString());
    }

    public Integer selectUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andActiveEqualTo(1);
        List<User> users = userMapper.selectByExample(userExample);
        logger.debug("查找用户名", users.toString());
        if (users.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void updateUserInfo(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        logger.debug("更新用户信息", ((Integer) i).toString());
    }

    public void updateChildren(Integer cid, String uBoyName, String sex, String birthdayDate) {
        TbSysUserBoyExample tbSysUserBoyExample = new TbSysUserBoyExample();
        tbSysUserBoyExample.createCriteria().andIdEqualTo(cid).andActiveEqualTo(1);
        List<TbSysUserBoy> tbSysUserBoys = tbSysUserBoyMapper.selectByExample(tbSysUserBoyExample);
        logger.debug("查找孩子通过孩子ID", tbSysUserBoys.toString());
        TbSysUserBoy tbSysUserBoy = tbSysUserBoys.get(0);
        tbSysUserBoy.setuBoyName(uBoyName);
        tbSysUserBoy.setSex(sex.split(",")[1]);
        String[] split = birthdayDate.split("-");
        int year = Integer.parseInt(split[0]);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        int nowYear = Integer.parseInt(simpleDateFormat.format(new Date()));
        tbSysUserBoy.setAge(String.valueOf(nowYear - year + 1));
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tbSysUserBoy.setBirthday(simpleDateFormat1.parse(birthdayDate));
            tbSysUserBoyMapper.updateByPrimaryKey(tbSysUserBoy);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<City> getProvince() {
        if (provinces == null || provinces.size() == 0) {
            TbSysProvinceExample tbSysProvinceExample = new TbSysProvinceExample();
            tbSysProvinceExample.createCriteria().andActiveEqualTo(1);
            List<TbSysProvince> tbSysProvinces = tbSysProvinceMapper.selectByExample(tbSysProvinceExample);
            logger.debug("查找省份", tbSysProvinces.toString());
            for (TbSysProvince tbSysProvince : tbSysProvinces) {
                City city = new City();
                city.setCode(tbSysProvince.getProId().toString());
                city.setName(tbSysProvince.getProName());
                provinces.add(city);
            }
        }
        return provinces;
    }

    public List<City> getCity(String pCode) {
        provinceCode = pCode;
        TbSysCityExample tbSysCityExample = new TbSysCityExample();
        tbSysCityExample.createCriteria().andProIdEqualTo(Integer.valueOf(pCode)).andActiveEqualTo(1);
        tbSysCities = tbSysCityMapper.selectByExample(tbSysCityExample);
        logger.debug("查找城市", tbSysCities.toString());
        List<City> cityList1 = new LinkedList<>();
        for (TbSysCity tbSysCity : tbSysCities) {
            City city2 = new City();
            city2.setCode(tbSysCity.getCityId().toString());
            city2.setName(tbSysCity.getCityName());
            cityList1.add(city2);
        }
        return cityList1;
    }

    public List<City> getArea(String cCode) {
        TbSysCityAreaExample tbSysCityAreaExample = new TbSysCityAreaExample();
        tbSysCityAreaExample.createCriteria().andCityIdEqualTo(Integer.valueOf(cCode)).andProIdEqualTo(Integer.valueOf(provinceCode)).andActiveEqualTo(1);
        List<TbSysCityArea> tbSysCityAreas = tbSysCityAreaMapper.selectByExample(tbSysCityAreaExample);
        logger.debug("查找地区", tbSysCityAreas.toString());
        List<City> areaList1 = new LinkedList<>();
        for (TbSysCityArea TbSysCityArea : tbSysCityAreas) {
            City city3 = new City();
            city3.setCode(TbSysCityArea.getAreaId().toString());
            city3.setName(TbSysCityArea.getAreaName());
            areaList1.add(city3);
        }
        return areaList1;
    }

    public String[] getCode(String phone, Integer type) throws IOException {
        if (type == 2) {
            validateCode = MailUtils.sendTxtMail(this.getUser().getMail());
        } else {
            validateCode[0] = indexService.getMessage(phone, 4, "3049570").getVerificationCode();
        }
        return validateCode;
    }

    public int[][] getCurrentCalendar() {
        currentCalendar = CalendarUtils.getCurrentCalendar();
        return currentCalendar;
    }

    public Map<String, Object> updateSignHistory(Integer uid) throws ParseException {
        Integer userId;
        if (uid == null) {
            userId = this.getUser().getUid();
        } else {
            userId = uid;
        }
        Calendar c = Calendar.getInstance();
        int today = c.get(Calendar.MONTH) + 1;
        int yearNow = c.get(Calendar.YEAR);
        int preMonth = 0;
        int preYear = 0;
        TbRULoginLogExample tbRULoginLogExample0 = new TbRULoginLogExample();
        tbRULoginLogExample0.createCriteria().andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbRULoginLog> tbRULoginLogs0 = tbRULoginLogMapper.selectByExample(tbRULoginLogExample0);
        if (tbRULoginLogs0 == null) {
            return null;
        }
        logger.debug("查找用户的签到记录", tbRULoginLogs0.toString());
        if (tbRULoginLogs0.size() > 0) {
            TbRULoginLog tbRULoginLog = tbRULoginLogs0.get(tbRULoginLogs0.size() - 1);
            Date preDate = tbRULoginLog.getTodayDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(preDate);
            preMonth = calendar.get(Calendar.MONTH) + 1;
            preYear = c.get(Calendar.YEAR);
            calendar.clear();
        }

        if (yearNow != preYear || today != preMonth) {
            signArray = new int[6][7];
            TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
            tbSysUBeanExample.createCriteria().andUIdEqualTo(userId).andActiveEqualTo(1);
            List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
            if (tbSysUBeen == null || tbSysUBeen.size() <= 0) {
                return null;
            }
            logger.debug("查找用户豆值", tbSysUBeen.toString());
            TbSysUBean tbSysUBean = tbSysUBeen.get(0);
            tbSysUBean.setBeanValAnother(0);
            int i = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
            if (i <= 0) {
                return null;
            }
            logger.debug("更新用户的额外豆值", ((Integer) i).toString());
            continuityDay = 0;
        }
        Map<String, Object> map = new HashMap<>();
        TbRULoginLogExample tbRULoginLogExample = new TbRULoginLogExample();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat1.format(new Date());
        Date parse = simpleDateFormat1.parse(format);
        tbRULoginLogExample.createCriteria().andTodayDateEqualTo(parse).andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbRULoginLog> tbRULoginLogs = tbRULoginLogMapper.selectByExample(tbRULoginLogExample);
        if (tbRULoginLogs == null) {
            return null;
        }
        logger.debug("查找用户的今天是否签到", tbRULoginLogs.toString());
        if (tbRULoginLogs.size() == 0) {
            map.put("todayIsSign", 0);
        } else {
            map.put("todayIsSign", 1);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String format1 = simpleDateFormat.format(new Date());
        List<TbRULoginLog> signs = signMapperExt.getSigns(userId, format1 + "%");
        if (signs == null) {
            return null;
        }
        logger.debug("查找用户的本月签到历史", signs.toString());

        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        int[] signsArray = new int[maxDate];
        a.clear();

        for (TbRULoginLog tbRULoginLog : signs) {
            Date todayDate = tbRULoginLog.getTodayDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(todayDate);
            int week_month = calendar.get(Calendar.WEEK_OF_MONTH);
            int now_day_month = calendar.get(Calendar.DAY_OF_WEEK);
            signArray[week_month - 1][now_day_month - 1] = 1;
            int days = calendar.get(Calendar.DAY_OF_MONTH);
            signsArray[days - 1] = 1;
            calendar.clear();
        }
        if (uid == null) {
            map.put("signHistory", signArray);
        } else {
            map.put("signHistoryInterface", signsArray);
        }
        map.put("successDay", signs.size());

        TbRULoginLogExample tbRULoginLogExample1 = new TbRULoginLogExample();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        Date timeYesterday = calendar.getTime();
        String formatYesterday = simpleDateFormat2.format(timeYesterday);
        Date parseYesterday = simpleDateFormat1.parse(formatYesterday);
        tbRULoginLogExample1.createCriteria().andTodayDateEqualTo(parseYesterday).andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbRULoginLog> tbRULoginLogsYesterday = tbRULoginLogMapper.selectByExample(tbRULoginLogExample1);
        if (tbRULoginLogsYesterday == null) {
            return null;
        }
        logger.debug("查找用户的昨天是否签到", tbRULoginLogsYesterday.toString());
        if (tbRULoginLogsYesterday.size() == 0 || calendar.get(Calendar.MONTH) + 1 != currentMonth) {
            continuityDay = 0;
        } else {
            continuityDay = tbRULoginLogsYesterday.get(0).getFlagSinedDays();
        }
        calendar.clear();
        if (tbRULoginLogs.size() != 0) {
            continuityDay = tbRULoginLogs.get(0).getFlagSinedDays();
        }
        map.put("continuity", continuityDay);
        TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
        tbSysUBeanExample.createCriteria().andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
        if (tbSysUBeen == null) {
            return null;
        }
        logger.debug("查找用户未收取的额外豆值", tbSysUBeen.toString());
        map.put("anotherBeanVal", tbSysUBeen.get(0).getBeanValAnother());
        map.put("beanVal", tbSysUBeen.get(0).getBeanVal());
        return map;
    }

    public Map<String, Object> updateSignInfo(Integer uid) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Integer userId;
        if (uid == null) {
            userId = this.getUser().getUid();
        } else {
            userId = uid;
        }
        TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
        tbSysUBeanExample.createCriteria().andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
        if (tbSysUBeen == null || tbSysUBeen.size() <= 0) {
            return null;
        }
        logger.debug("查找用户豆值", tbSysUBeen.toString());
        TbSysUBean tbSysUBean = tbSysUBeen.get(0);

        TbRULoginLogExample tbRULoginLogExample = new TbRULoginLogExample();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat1.format(new Date());
        map.put("today", format);
        Date parse = simpleDateFormat1.parse(format);
        tbRULoginLogExample.createCriteria().andTodayDateEqualTo(parse).andUIdEqualTo(userId).andActiveEqualTo(1);
        List<TbRULoginLog> tbRULoginLogs = tbRULoginLogMapper.selectByExample(tbRULoginLogExample);
        if (tbRULoginLogs == null) {
            return null;
        }
        logger.debug("查找用户的今天是否签到", tbRULoginLogs.toString());
        if (tbRULoginLogs.size() != 0) {
            map.put("beanValue", tbSysUBean.getBeanVal());
            map.put("signed", 1);
            return map;
        } else {
            tbSysUBean.setBeanVal(tbSysUBean.getBeanVal() + 1);
            int i = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
            if (i <= 0) {
                return null;
            }
            logger.debug("更新用户的豆值", ((Integer) i).toString());
            map.put("beanValue", tbSysUBean.getBeanVal());

            TbRULoginLogExample tbRULoginLogExample1 = new TbRULoginLogExample();
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            Date timeYesterday = calendar.getTime();
            String formatYesterday = simpleDateFormat2.format(timeYesterday);
            Date parseYesterday = simpleDateFormat2.parse(formatYesterday);
            tbRULoginLogExample1.createCriteria().andTodayDateEqualTo(parseYesterday).andUIdEqualTo(userId).andActiveEqualTo(1);
            List<TbRULoginLog> tbRULoginLogsYesterday = tbRULoginLogMapper.selectByExample(tbRULoginLogExample1);
            if (tbRULoginLogsYesterday == null) {
                return null;
            }
            logger.debug("查找用户的昨天是否签到", tbRULoginLogsYesterday.toString());
            Integer continuityDay = 0;
            if (tbRULoginLogsYesterday.size() != 0 && calendar.get(Calendar.MONTH) + 1 == currentMonth) {
                continuityDay = tbRULoginLogsYesterday.get(0).getFlagSinedDays();
            }
            calendar.clear();
            TbRULoginLog tbRULoginLog = new TbRULoginLog();
            tbRULoginLog.setFlagSinedDays(continuityDay + 1);
            tbRULoginLog.setActive(1);
            tbRULoginLog.setFlagSigned(1);
            Date date = new Date();
            long time = date.getTime();
            tbRULoginLog.setSyscreated(new Timestamp(time));
            tbRULoginLog.setLoginTime(new Timestamp(time));
            tbRULoginLog.setTodayDate(date);
            tbRULoginLog.setuId(userId);
            int insert = tbRULoginLogMapper.insert(tbRULoginLog);
            if (insert <= 0) {
                return null;
            }
            logger.debug("插入今天签到记录", ((Integer) insert).toString());

            if (this.insertBeanDetail("签到", 1, 1, userId) <= 0) {
                return null;
            }

            Integer beanValAnother = tbSysUBean.getBeanValAnother();
            int continuityDay2 = continuityDay + 1;
            switch (continuityDay2) {
                case 3:
                    beanValAnother += 10;
                    break;
                case 5:
                    beanValAnother += 20;
                    break;
                case 7:
                    beanValAnother += 40;
                    break;
                case 10:
                    beanValAnother += 60;
                    break;
                case 20:
                    beanValAnother += 80;
                    break;
                case 30:
                    beanValAnother += 100;
                    break;
            }
            tbSysUBean.setBeanValAnother(beanValAnother);
            int iv = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
            if (iv <= 0) {
                return null;
            }
            logger.debug("更新用户的额外豆值", ((Integer) iv).toString());
            return map;
        }
    }

    public void updateBeanVal() {
        TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
        tbSysUBeanExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
        logger.debug("查找用户豆值", tbSysUBeen.toString());
        TbSysUBean tbSysUBean = tbSysUBeen.get(0);
        tbSysUBean.setBeanVal(tbSysUBean.getBeanValAnother() + tbSysUBean.getBeanVal());

        this.insertBeanDetail("收取豆值", tbSysUBean.getBeanValAnother(), 1, this.getUser().getUid());

        tbSysUBean.setBeanValAnother(0);
        int i = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
        logger.debug("更新用户的豆值", ((Integer) i).toString());

    }

    public TbSysUserBoy getChildren(User user) {
        TbSysUserBoyExample tbSysUserBoyExample = new TbSysUserBoyExample();
        tbSysUserBoyExample.createCriteria().andUidEqualTo(user.getUid()).andActiveEqualTo(1);
        List<TbSysUserBoy> tbSysUserBoys = tbSysUserBoyMapper.selectByExample(tbSysUserBoyExample);
        logger.debug("查找孩子", tbSysUserBoys.toString());
        return tbSysUserBoys.get(0);
    }

    public List<AddressExt> getAddress(Integer uid) {
        tbSysUserAddresses = addressMapperExt.getAddressList(uid);
        logger.debug("查找收货地址按是否默认排序", tbSysUserAddresses.toString());
        return tbSysUserAddresses;
    }

    public void addAddress(TbSysUserAddress tbSysUserAddress) {
        List<AddressExt> address = tbSysUserAddresses = this.getAddress(null);
        Integer maxAddressId = 0;
        for (TbSysUserAddress tbSysUserAddress1 : address) {
            tbSysUserAddress1.setDefaultAddress(false);
            if (tbSysUserAddress1.getAddressId() >= maxAddressId) {
                maxAddressId = tbSysUserAddress1.getAddressId();
            }
            int i = tbSysUserAddressMapper.updateByPrimaryKey(tbSysUserAddress1);
            logger.debug("更新所有地址为非默认", ((Integer) i).toString());
        }
        tbSysUserAddress.setAddressId(maxAddressId + 1);
        tbSysUserAddress.setUid(this.getUser().getUid());
        tbSysUserAddress.setDefaultAddress(true);
        Date date = new Date();
        long time = date.getTime();
        tbSysUserAddress.setSyscreated(new Timestamp(time));
        tbSysUserAddress.setActive(1);
        int insert = tbSysUserAddressMapper.insert(tbSysUserAddress);
        logger.debug("插入新增地址", ((Integer) insert).toString());
    }

    public void deleteAddress(Integer aid, Integer index) {
        TbSysUserAddressExample tbSysUserAddressExample = new TbSysUserAddressExample();
        tbSysUserAddressExample.createCriteria().andAddressIdEqualTo(aid).andActiveEqualTo(1);
        List<TbSysUserAddress> tbSysUserAddresses = tbSysUserAddressMapper.selectByExample(tbSysUserAddressExample);
        logger.debug("查找收货地址按地址ID", tbSysUserAddresses.toString());
        //暂定
        TbSysUserAddress tbSysUserAddress1 = tbSysUserAddresses.get(0);
        tbSysUserAddress1.setActive(0);
        tbSysUserAddress1.setDefaultAddress(false);
        int i = tbSysUserAddressMapper.updateByPrimaryKey(tbSysUserAddress1);
        logger.debug("模拟删除地址", ((Integer) i).toString());
    }

    public void setDefault(Integer aid) {
        List<TbSysUserAddress> tbSysUserAddresses2 = this.setDefaultNo(aid);

        TbSysUserAddress tbSysUserAddress = tbSysUserAddresses2.get(0);
        tbSysUserAddress.setDefaultAddress(true);
        int i = tbSysUserAddressMapper.updateByPrimaryKey(tbSysUserAddress);
        logger.debug("更新地址为非默认", ((Integer) i).toString());
    }

    public void editAddress(Integer aid, String receivedPerson, String province, String city, String area, String address, String receivedPersonPhone) {
        List<TbSysUserAddress> tbSysUserAddresses2 = this.setDefaultNo(aid);
        TbSysUserAddress tbSysUserAddress = tbSysUserAddresses2.get(0);
        tbSysUserAddress.setReceivedPerson(receivedPerson);
        tbSysUserAddress.setProvince(province);
        tbSysUserAddress.setCity(city);
        tbSysUserAddress.setArea(area);
        tbSysUserAddress.setAddress(address);
        tbSysUserAddress.setReceivedPersonPhone(receivedPersonPhone);
        tbSysUserAddress.setDefaultAddress(true);
        int i = tbSysUserAddressMapper.updateByPrimaryKey(tbSysUserAddress);
        logger.debug("编辑地址", ((Integer) i).toString());
    }

    public List<TbSysUserAddress> setDefaultNo(Integer aid) {
        List<AddressExt> address = this.getAddress(this.getUser().getUid());
        for (AddressExt tbSysUserAddress1 : address) {
            tbSysUserAddress1.setDefaultAddress(false);
            int i = tbSysUserAddressMapper.updateByPrimaryKey(tbSysUserAddress1);
            logger.debug("更新所有地址为非默认", ((Integer) i).toString());
        }
        TbSysUserAddressExample tbSysUserAddressExample = new TbSysUserAddressExample();
        tbSysUserAddressExample.createCriteria().andAddressIdEqualTo(aid).andActiveEqualTo(1);
        List<TbSysUserAddress> tbSysUserAddresses1 = tbSysUserAddressMapper.selectByExample(tbSysUserAddressExample);
        logger.debug("查找收货地址按地址ID", tbSysUserAddresses1.toString());
        return tbSysUserAddresses1;
    }

    public Integer getTotalPages(Integer size, Integer state) {
        TbROrderExample tbROrderExample = new TbROrderExample();
        if (state != 0) {
            tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(state).andActiveEqualTo(1);
        } else {
            tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        }
        tbROrderExample.setOrderByClause("syscreated desc");
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找用户的订单", tbROrders.toString());
        int allPages = tbROrders.size() / size;
        if (tbROrders.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<TbROrder> getOrdersListByPage(Integer number, Integer size, Integer state) {
        TbROrderExample tbROrderExample = new TbROrderExample();
        if (state != 0) {
            tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(state).andActiveEqualTo(1);
        } else {
            tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        }
        tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(state).andActiveEqualTo(1);
        tbROrderExample.setOrderByClause("syscreated desc");
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找用户的订单分页", tbROrders.toString());
        int start = (number - 1) * size;
        int end = number * size;
        if (size > tbROrders.size() - ((number - 1) * size)) {
            end = tbROrders.size();
        }
        tbROrders = tbROrders.subList(start, end);
        return tbROrders;
    }

    public Map<Integer, List<OrderItem>> getItems(List<TbROrder> ordersListByPage) {
        Map<Integer, List<OrderItem>> map = new LinkedHashMap<>();
        for (TbROrder tbROrder : ordersListByPage) {
            List<OrderItem> items = productMapperExt.getItems(tbROrder.getoId());
            logger.debug("查找订单中的项", items.toString());
            map.put(tbROrder.getoId(), items);
        }
        return map;
    }

    public void deleteOrder(Integer oId) {
        if (oId == null) {
            TbROrderExample tbROrderExample = new TbROrderExample();
            tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(0).andActiveEqualTo(1);
            List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
            logger.debug("查找用户之前购买生产的订单", tbROrders.toString());
            if (tbROrders.size() > 0) {
                oid = tbROrders.get(0).getoId();
            } else {
                return;
            }
        } else {
            oid = oId;
        }
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andOIdEqualTo(oid).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找订单按oid", tbROrders.toString());


        Integer payTypeCode = 0;
        if (tbROrders.get(0).getPayType() == 2) {
            payTypeCode = 22;
        }
        if (tbROrders.get(0).getPayType() == 3) {
            payTypeCode = 21;
        }
        if (tbROrders.get(0).getoStates() == 3) {
            this.cancelPay(tbROrders.get(0).getoNo(), payTypeCode);
        }

        if (tbROrders.size() > 0) {
            TbROrder tbROrder = tbROrders.get(0);
            int i = tbROrderMapper.deleteByPrimaryKey(tbROrder.getId());
            logger.debug("删除订单", ((Integer) i).toString());
            List<OrderItem> items = productMapperExt.getItems(tbROrder.getoId());
            logger.debug("查找订单中的项", items.toString());
            for (OrderItem orderItem : items) {
                TbROrderGoodsExample tbROrderGoodsExample = new TbROrderGoodsExample();
                tbROrderGoodsExample.createCriteria().andOIdEqualTo(oid).andActiveEqualTo(1);
                List<TbROrderGoods> tbROrderGoodList = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample);
                logger.debug("查找订单项", tbROrderGoodList.toString());
                for (TbROrderGoods tbROrderGoodsItem : tbROrderGoodList) {
                    int i1 = tbROrderGoodsMapper.deleteByPrimaryKey(tbROrderGoodsItem.getId());
                    logger.debug("删除订单项", ((Integer) i1).toString());
                }

                TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
                tbRProductStockExample.createCriteria().andPIdEqualTo(orderItem.getpId()).andActiveEqualTo(1);
                List<TbRProductStock> tbRProductStocks = tbRProductStockMapper.selectByExample(tbRProductStockExample);
                logger.debug("查找库存", tbRProductStocks.toString());
                if (tbRProductStocks.size() > 0) {
                    TbRProductStock tbRProductStock = tbRProductStocks.get(0);
                    if (tbRProductStock.getpNum() == null || orderItem.getNum() == null) {
                        return;
                    }
                    tbRProductStock.setpNum(tbRProductStock.getpNum() + orderItem.getNum());
                    int i1 = tbRProductStockMapper.updateByPrimaryKey(tbRProductStock);
                    logger.debug("更新库存订单中的项", ((Integer) i1).toString());
                }
            }
        }
    }

    public TbROrder updateItems(Integer[] mount, Integer[] itemId) {
        Integer total = 0;
        Integer oid = 0;
        TbROrderGoodsExample tbROrderGoodsExample = new TbROrderGoodsExample();
        tbROrderGoodsExample.createCriteria().andIdEqualTo(itemId[0]).andActiveEqualTo(1);
        List<TbROrderGoods> tbROrderGoodses = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample);
        logger.debug("查找订单oid", tbROrderGoodses.toString());
        oid = tbROrderGoodses.get(0).getoId();

        TbROrderGoodsExample tbROrderGoodsExample2 = new TbROrderGoodsExample();
        tbROrderGoodsExample2.createCriteria().andOIdEqualTo(oid).andActiveEqualTo(1);
        List<TbROrderGoods> tbROrderGoodses2 = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample2);
        logger.debug("查找订单项按oid", tbROrderGoodses2.toString());
        for (TbROrderGoods tbROrderGoods : tbROrderGoodses2) {
            if (!Arrays.asList(itemId).contains(tbROrderGoods.getId())) {
                if (tbROrderGoods.getNum() != null) {
                    TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
                    tbRProductStockExample.createCriteria().andPIdEqualTo(tbROrderGoods.getpId()).andActiveEqualTo(1);
                    List<TbRProductStock> tbRProductStocks = tbRProductStockMapper.selectByExample(tbRProductStockExample);
                    logger.debug("查找库存", tbRProductStocks.toString());

                    tbRProductStocks.get(0).setpNum(tbRProductStocks.get(0).getpNum() + tbROrderGoods.getNum());
                    int i2 = tbRProductStockMapper.updateByPrimaryKey(tbRProductStocks.get(0));
                    logger.debug("还原库存", ((Integer) i2).toString());

                }
                int i = tbROrderGoodsMapper.deleteByPrimaryKey(tbROrderGoods.getId());
                logger.debug("删除订单项", ((Integer) i).toString());
            }
        }

        Integer stock = 0;
        for (int i = 0; i < itemId.length; i++) {
            TbROrderGoodsExample tbROrderGoodsExample1 = new TbROrderGoodsExample();
            tbROrderGoodsExample1.createCriteria().andIdEqualTo(itemId[i]).andActiveEqualTo(1);
            List<TbROrderGoods> tbROrderGoodses1 = tbROrderGoodsMapper.selectByExample(tbROrderGoodsExample1);
            logger.debug("查找订单项", tbROrderGoodses1.toString());

            if (tbROrderGoodses.get(0).getNum() != null) {
                stock = mount[i] - tbROrderGoodses.get(0).getNum();
                TbRProductStockExample tbRProductStockExample = new TbRProductStockExample();
                tbRProductStockExample.createCriteria().andPIdEqualTo(tbROrderGoodses.get(0).getpId()).andActiveEqualTo(1);
                List<TbRProductStock> tbRProductStocks = tbRProductStockMapper.selectByExample(tbRProductStockExample);
                logger.debug("查找库存", tbRProductStocks.toString());

                tbRProductStocks.get(0).setpNum(tbRProductStocks.get(0).getpNum() - stock);
                int i2 = tbRProductStockMapper.updateByPrimaryKey(tbRProductStocks.get(0));
                logger.debug("更新库存", ((Integer) i2).toString());

                tbROrderGoodses.get(0).setNum(mount[i]);
                int i1 = tbROrderGoodsMapper.updateByPrimaryKey(tbROrderGoodses.get(0));
                logger.debug("更新数量", ((Integer) i1).toString());

                total += tbROrderGoodses.get(0).getNum() * tbROrderGoodses.get(0).getpPrice();
            } else {
                total += tbROrderGoodses.get(0).getLargMenNum() * tbROrderGoodses.get(0).getpPrice() + tbROrderGoodses.get(0).getSmallMenNum() * tbROrderGoodses.get(0).getcPrice();
            }
        }
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andOIdEqualTo(oid).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找订单", tbROrders.toString());
        tbROrders.get(0).setoStates(2);
        tbROrders.get(0).setExpressFee(1);
        tbROrders.get(0).setTotalFee(total);
        int i = tbROrderMapper.updateByPrimaryKey(tbROrders.get(0));
        logger.debug("更新订单", ((Integer) i).toString());
        return tbROrders.get(0);
    }

    public TbROrder updateOrder(TbROrder tbROrder, Integer payMethodId, Integer addressId, Integer couponId, String invitation, Integer point, Integer totalPrice) {
        tbROrder.setoStates(3);
        tbROrder.setTotalFee(totalPrice);
        Date date = new Date();
        long time = date.getTime();
        tbROrder.setSyscreated(new Timestamp(time));
        tbROrder.setPayType(payMethodId);
        tbROrder.setAddressId(addressId);
        tbROrder.setDpId(couponId);
        tbROrder.setBeanVal(point);
        tbROrder.setrCode(invitation);
        int i = tbROrderMapper.updateByPrimaryKey(tbROrder);
        logger.debug("更新订单", ((Integer) i).toString());
        this.couponId = couponId;
        this.invitation = invitation;
        this.point = point;
        return tbROrder;
    }

    public TbROrder getOrder(Integer oid) {
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andOIdEqualTo(oid).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找订单", tbROrders.toString());
        return tbROrders.get(0);
    }

    public void updateDateInfo() {
        TbRUDiscountpageLogExample tbRUDiscountpageLogExample = new TbRUDiscountpageLogExample();
        tbRUDiscountpageLogExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andStateEqualTo(0).andActiveEqualTo(1);
        List<TbRUDiscountpageLog> tbRUDiscountpageLogs = tbRUDiscountpageLogMapper.selectByExample(tbRUDiscountpageLogExample);
        logger.debug("查找用户优惠券", tbRUDiscountpageLogs.toString());
        for (TbRUDiscountpageLog tbRUDiscountpageLog : tbRUDiscountpageLogs) {
            long getTime = tbRUDiscountpageLog.getrTime().getTime();
            long now = new Date().getTime();
            if (now - getTime > (long) 90 * 24 * 60 * 60 * 1000) {
                tbRUDiscountpageLog.setState(1);
                int i = tbRUDiscountpageLogMapper.updateByPrimaryKey(tbRUDiscountpageLog);
                logger.debug("更新用户优惠券过期", ((Integer) i).toString());
            }
        }

        Calendar c = Calendar.getInstance();
        int today = c.get(Calendar.YEAR);
        int preYear = 0;
        TbRULoginLogExample tbRULoginLogExample0 = new TbRULoginLogExample();
        tbRULoginLogExample0.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbRULoginLog> tbRULoginLogs0 = tbRULoginLogMapper.selectByExample(tbRULoginLogExample0);
        logger.debug("查找用户的签到记录", tbRULoginLogs0.toString());
        if (tbRULoginLogs0.size() > 0) {
            TbRULoginLog tbRULoginLog = tbRULoginLogs0.get(tbRULoginLogs0.size() - 1);
            Date todayDate = tbRULoginLog.getTodayDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(todayDate);
            preYear = calendar.get(Calendar.YEAR);
            calendar.clear();
        }
        if (today != preYear) {
            TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
            tbSysUBeanExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
            List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
            logger.debug("查找用户豆值", tbSysUBeen.toString());
            TbSysUBean tbSysUBean = tbSysUBeen.get(0);
            this.insertBeanDetail("新年归零", tbSysUBean.getBeanVal(), 0, this.getUser().getUid());
            tbSysUBean.setBeanVal(0);
            int i = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
            logger.debug("更新用户的豆值", ((Integer) i).toString());
        }

        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(3).andActiveEqualTo(1);
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        for (TbROrder tbROrder : tbROrders) {
            long buyTime = tbROrder.getBuyTime().getTime();
            long now = new Date().getTime();
            if (now - buyTime > (long) 24 * 60 * 60 * 1000) {
                this.deleteOrder(tbROrder.getoId());
            }
        }
    }

    public TreeMap<String, Object> updateQrCode(TbROrder tbROrder) throws IOException {
        Integer payTypeCode = 0;
        if (tbROrder.getPayType() == 2) {
            payTypeCode = 22;
        }
        if (tbROrder.getPayType() == 3) {
            payTypeCode = 21;
        }
        String key = "testJIZHIsignKey";
        String orderId = tbROrder.getoNo();
        double totalAmount = (tbROrder.getTotalFee() + tbROrder.getExpressFee()) / 100.0;
        SortedMap<String, Object> map = new TreeMap<String, Object>();
        map.put("mallCode", "100000");
        map.put("shopCode", "100000110000010001");
        map.put("posCode", "1000001100000100010001");
        map.put("orderId", "");
        map.put("totalAmount", totalAmount);
        map.put("payTypeCode", payTypeCode);
        map.put("posFlow", orderId);
        String vsign = MD5.MD5sign(map, key);
        JSONObject obj = new JSONObject();
        obj.put("sign", vsign);
        obj.put("mallCode", "100000");
        obj.put("shopCode", "100000110000010001");
        obj.put("posCode", "1000001100000100010001");
        obj.put("orderId", "");
        obj.put("totalAmount", totalAmount);
        obj.put("payTypeCode", payTypeCode);
        obj.put("posFlow", orderId);

        TbROrder tbROrder1 = tbROrderMapper.selectByPrimaryKey(tbROrder.getId());
        String demo = tbROrder1.getDemo();
        if (demo != null && !"".equals(demo)) {
            sb = new StringBuffer(demo);
        } else {
            sb = null;
        }
        if (sb == null) {
            // 创建url资源
            URL url = new URL("https://pay.tangchaogouwu.com/java/rest/payment/trade/precreate");
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(true);
            // 设置文件字符集:
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // 开始连接请求
            conn.connect();
            //POST请求
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            //读取响应
            out.write(obj.toString().getBytes("UTF-8"));//这样可以处理中文乱码问题
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String lines;
            sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            // 断开连接
            conn.disconnect();
        }
        JSONObject jsonObject = JSON.parseObject(sb.toString());
        DataConvertUtil.jsonToMap(new org.json.JSONObject(jsonObject.toJSONString()));
        SortedMap<String, Object> stringObjectSortedMap = DataConvertUtil.jsonToMap(new org.json.JSONObject(jsonObject.toJSONString()));

        TreeMap<String, Object> data = (TreeMap<String, Object>) stringObjectSortedMap.get("data");
        SortedMap<String, Object> map2 = new TreeMap<String, Object>();
        map2.put("mallCode", "100000");
        map2.put("posCode", "1000001100000100010001");
        preONo = ((String) ((TreeMap) stringObjectSortedMap.get("data")).get("orderId"));
        map2.put("orderId", preONo);
        String vsign2 = MD5.MD5sign(map2, key);
        data.put("sign", vsign2);
        data.put("mallCode", "100000");
        data.put("posCode", "1000001100000100010001");
        tbROrder.setDemo(sb.toString());
        int i = tbROrderMapper.updateByPrimaryKey(tbROrder);
        logger.debug("更新订单DEMO", ((Integer) i).toString());
        this.tbROrder = tbROrder;
        return data;
    }

    public void cancelPay(String oNo, Integer payTypeCode) {
        StringBuffer s = null;
        SortedMap<String, Object> map = new TreeMap<String, Object>();
        String key = "testJIZHIsignKey";
        map.put("orderId", oNo);
        map.put("mallCode", "100000");
        map.put("posCode", "1000001100000100010001");
        map.put("payTypeCode", payTypeCode);
        String vsign = MD5.MD5sign(map, key);
        JSONObject obj = new JSONObject();
        obj.put("sign", vsign);
        obj.put("orderId", oNo);
        obj.put("mallCode", "100000");
        obj.put("posCode", "1000001100000100010001");
        obj.put("payTypeCode", payTypeCode);
        try {
            // 创建url资源
            URL url = new URL("https://pay.tangchaogouwu.com/java/rest/payment/trade/closeOrder");
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(true);
            // 设置文件字符集:
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // 开始连接请求
            conn.connect();
            //POST请求
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            //读取响应
            out.write(obj.toString().getBytes("UTF-8"));//这样可以处理中文乱码问题
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String lines;
            s = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                s.append(lines);
            }
            reader.close();
            // 断开连接
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderFinish() {
        if (this.tbROrder.getPayTime() == null) {
            Date date = new Date();
            long time = date.getTime();
            this.tbROrder.setPayTime(new Timestamp(time));
            this.tbROrder.setoStates(4);
            Integer maxRId = 0;
            TbRRequestcodeTjrLogExample tbRRequestcodeTjrLogExample = new TbRRequestcodeTjrLogExample();
            tbRRequestcodeTjrLogExample.createCriteria().andActiveEqualTo(1);
            List<TbRRequestcodeTjrLog> tbRRequestcodeTjrLogs = tbRRequestcodeTjrLogMapper.selectByExample(tbRRequestcodeTjrLogExample);
            logger.debug("查找所有的邀请码", tbRRequestcodeTjrLogs.toString());
            for (TbRRequestcodeTjrLog tbRRequestcodeTjrLog1 : tbRRequestcodeTjrLogs) {
                if (tbRRequestcodeTjrLog1.getrId() > maxRId) {
                    maxRId = tbRRequestcodeTjrLog1.getrId();
                }
            }
            if (this.tbROrder.getTotalFee() >= 1) {
                String invitationString = RandomNumber.randomString(1000, 9999);
                this.tbROrder.setrCode(invitationString);
                TbRRequestcodeTjrLog tbRRequestcodeTjrLog = new TbRRequestcodeTjrLog();
                tbRRequestcodeTjrLog.setActive(1);
                tbRRequestcodeTjrLog.setDurationDay(90);
                tbRRequestcodeTjrLog.setOrderId(this.tbROrder.getoId());
                tbRRequestcodeTjrLog.setRcode(invitationString);
                tbRRequestcodeTjrLog.setUserId(this.getUser().getUid());
                tbRRequestcodeTjrLog.setSyscreated(new Timestamp(time));
                tbRRequestcodeTjrLog.setrId(maxRId + 1);
                int insert = tbRRequestcodeTjrLogMapper.insert(tbRRequestcodeTjrLog);
                logger.debug("获取邀请码", ((Integer) insert).toString());
            }
            int i = tbROrderMapper.updateByPrimaryKey(this.tbROrder);
            logger.debug("更新订单", ((Integer) i).toString());

            TbRRequestcodeNtjrLog tbRRequestcodeNtjrLog = new TbRRequestcodeNtjrLog();
            tbRRequestcodeNtjrLog.setSyscreated((new Timestamp(time)));
            tbRRequestcodeNtjrLog.setUserId(this.getUser().getUid());
            tbRRequestcodeNtjrLog.setRcode(this.invitation);
            tbRRequestcodeNtjrLog.setOrderId(tbROrder.getoId());
            tbRRequestcodeNtjrLog.setActive(1);
            tbRRequestcodeNtjrLog.setFlag(1);
            tbRRequestcodeNtjrLog.setrId(maxRId + 1);
            int insert = tbRRequestcodeNtjrLogMapper.insert(tbRRequestcodeNtjrLog);
            logger.debug("使用邀请码", ((Integer) insert).toString());

            TbRUDiscountpageLogExample tbRUDiscountpageLogExample = new TbRUDiscountpageLogExample();
            if (this.couponId != null) {
                tbRUDiscountpageLogExample.createCriteria().andIdEqualTo(this.couponId).andActiveEqualTo(1);
                List<TbRUDiscountpageLog> tbRUDiscountpageLogs = tbRUDiscountpageLogMapper.selectByExample(tbRUDiscountpageLogExample);
                logger.debug("查找优惠券", tbRUDiscountpageLogs.toString());
                tbRUDiscountpageLogs.get(0).setState(2);
                int i1 = tbRUDiscountpageLogMapper.updateByPrimaryKey(tbRUDiscountpageLogs.get(0));
                logger.debug("更新优惠券状态", ((Integer) i1).toString());
            }

            TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
            tbSysUBeanExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
            List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
            logger.debug("查找用户豆值", tbSysUBeen.toString());
            tbSysUBeen.get(0).setBeanVal(tbSysUBeen.get(0).getBeanVal() - this.point);
            int i2 = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBeen.get(0));
            logger.debug("更新用户豆值使用豆值", ((Integer) i2).toString());

            if (this.point > 0) {
                this.insertBeanDetail("购物使用豆值", this.point, 0, this.getUser().getUid());
            }

            if (this.tbROrder.getTotalFee() / 100 > 0) {
                tbSysUBeen.get(0).setBeanVal(tbSysUBeen.get(0).getBeanVal() + this.tbROrder.getTotalFee() / 100);
                int i3 = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBeen.get(0));
                logger.debug("更新用户豆值购物价格", ((Integer) i3).toString());
                this.insertBeanDetail("购物赠送", this.tbROrder.getTotalFee() / 100, 1, this.getUser().getUid());
            }
        }
    }

    public List<ItemsExt> getOrderItems(Integer oid) {
        List<ItemsExt> tbROrderGoodsList = itemsMapperExt.getOrderItems(oid);
        logger.debug("查找订单项", tbROrderGoodsList.toString());
        return tbROrderGoodsList;
    }

    public TbSysDiscountpageType getCoupon(Integer couponId) {
        TbSysDiscountpageTypeExample tbSysDiscountpageTypeExample = new TbSysDiscountpageTypeExample();
        tbSysDiscountpageTypeExample.createCriteria().andDpIdEqualTo(couponId).andActiveEqualTo(1);
        List<TbSysDiscountpageType> tbSysDiscountpageTypes = tbSysDiscountpageTypeMapper.selectByExample(tbSysDiscountpageTypeExample);
        logger.debug("查找优惠券", tbSysDiscountpageTypes.toString());
        return tbSysDiscountpageTypes.get(0);
    }

    public List<CouponExt> getCoupons(Integer state) {
        List<CouponExt> coupons = couponMapperExt.getCoupons(this.getUser().getUid(), state);
        logger.debug("查找用户优惠券", coupons.toString());
        return coupons;
    }

    public List<CourseExt> getMaterial() {
        List<CourseExt> list = new LinkedList<>();
        TbROrderExample tbROrderExample = new TbROrderExample();
        tbROrderExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andOStatesEqualTo(3).andActiveEqualTo(1);
        tbROrderExample.setOrderByClause("syscreated desc");
        List<TbROrder> tbROrders = tbROrderMapper.selectByExample(tbROrderExample);
        logger.debug("查找用户订单", tbROrders.toString());
        for (TbROrder tbROrder : tbROrders) {
            List<CourseExt> materials = productMapperExt.getMaterials(tbROrder.getoId());
            logger.debug("查找订单课程材料包", materials.toString());
            list.addAll(materials);
        }
        return list;
    }

    public Integer getInvitationPages(Integer size) {
        TbRRequestcodeTjrLogExample tbRRequestcodeTjrLogExample = new TbRRequestcodeTjrLogExample();
        tbRRequestcodeTjrLogExample.createCriteria().andUserIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        tbRRequestcodeTjrLogExample.setOrderByClause("syscreated desc");
        List<TbRRequestcodeTjrLog> tbRRequestcodeTjrLogs = tbRRequestcodeTjrLogMapper.selectByExample(tbRRequestcodeTjrLogExample);
        logger.debug("查找用户的邀请码", tbRRequestcodeTjrLogs.toString());
        int allPages = tbRRequestcodeTjrLogs.size() / size;
        if (tbRRequestcodeTjrLogs.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<TbRRequestcodeTjrLog> getInvitationList(Integer number, Integer size) {
        TbRRequestcodeTjrLogExample tbRRequestcodeTjrLogExample = new TbRRequestcodeTjrLogExample();
        tbRRequestcodeTjrLogExample.createCriteria().andUserIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        tbRRequestcodeTjrLogExample.setOrderByClause("syscreated desc");
        List<TbRRequestcodeTjrLog> tbRRequestcodeTjrLogs = tbRRequestcodeTjrLogMapper.selectByExample(tbRRequestcodeTjrLogExample);
        logger.debug("查找用户的邀请码分页", tbRRequestcodeTjrLogs.toString());
        int start = (number - 1) * size;
        int end = number * size;
        if (size > tbRRequestcodeTjrLogs.size() - ((number - 1) * size)) {
            end = tbRRequestcodeTjrLogs.size();
        }
        tbRRequestcodeTjrLogs = tbRRequestcodeTjrLogs.subList(start, end);
        return tbRRequestcodeTjrLogs;
    }

    public Integer getUserPoint() {
        TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
        tbSysUBeanExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
        logger.debug("查找用户的豆值", tbSysUBeen.toString());
        return tbSysUBeen.get(0).getBeanVal();
    }

    public Integer getPointPages(Integer state, Integer size) {
        TbSysUBeanDetailExample tbSysUBeanDetailExample = new TbSysUBeanDetailExample();
        if (state == 3) {
            tbSysUBeanDetailExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        }
        if (state != 3) {
            tbSysUBeanDetailExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1).andIncomePayEqualTo(state);
        }
        List<TbSysUBeanDetail> tbSysUBeanDetails = tbSysUBeanDetailMapper.selectByExample(tbSysUBeanDetailExample);
        logger.debug("查找用户的豆值明细", tbSysUBeanDetails.toString());
        int allPages = tbSysUBeanDetails.size() / size;
        if (tbSysUBeanDetails.size() % size != 0) {
            allPages++;
        }
        return allPages;
    }

    public List<TbSysUBeanDetail> getPointList(Integer state, Integer number, Integer size) {
        TbSysUBeanDetailExample tbSysUBeanDetailExample = new TbSysUBeanDetailExample();
        if (state == 3) {
            tbSysUBeanDetailExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        }
        if (state != 3) {
            tbSysUBeanDetailExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1).andIncomePayEqualTo(state);
        }
        tbSysUBeanDetailExample.setOrderByClause("syscreated desc");
        List<TbSysUBeanDetail> tbSysUBeanDetails = tbSysUBeanDetailMapper.selectByExample(tbSysUBeanDetailExample);
        logger.debug("查找用户的豆值明细", tbSysUBeanDetails.toString());
        int start = (number - 1) * size;
        int end = number * size;
        if (size > tbSysUBeanDetails.size() - ((number - 1) * size)) {
            end = tbSysUBeanDetails.size();
        }
        tbSysUBeanDetails = tbSysUBeanDetails.subList(start, end);
        return tbSysUBeanDetails;
    }

    public List<TbSysDiscountpageType> getCouponList() {
        TbSysDiscountpageTypeExample tbSysDiscountpageTypeExample = new TbSysDiscountpageTypeExample();
        tbSysDiscountpageTypeExample.createCriteria().andActiveEqualTo(1);
        tbSysDiscountpageTypeExample.setOrderByClause("syscreated desc");
        List<TbSysDiscountpageType> tbSysDiscountpageTypes = tbSysDiscountpageTypeMapper.selectByExample(tbSysDiscountpageTypeExample);
        logger.debug("查找使用优惠券", tbSysDiscountpageTypes.toString());
        return tbSysDiscountpageTypes;
    }

    public List<TbSysUBean> getPoint() {
        TbSysUBeanExample tbSysUBeanExample = new TbSysUBeanExample();
        tbSysUBeanExample.createCriteria().andUIdEqualTo(this.getUser().getUid()).andActiveEqualTo(1);
        List<TbSysUBean> tbSysUBeen = tbSysUBeanMapper.selectByExample(tbSysUBeanExample);
        logger.debug("查找用户的豆值", tbSysUBeen.toString());
        return tbSysUBeen;
    }

    public void exchangeCoupon(Integer point_val, Integer dpid, Integer userPoint) {
        List<TbSysUBean> tbSysUBeen = this.getPoint();

        TbSysUBean tbSysUBean = tbSysUBeen.get(0);
        tbSysUBean.setBeanVal(userPoint - point_val);
        int i = tbSysUBeanMapper.updateByPrimaryKey(tbSysUBean);
        logger.debug("更新用户的豆值", ((Integer) i).toString());

        TbRUDiscountpageLog tbRUDiscountpageLog = new TbRUDiscountpageLog();
        tbRUDiscountpageLog.setuId(this.getUser().getId());
        tbRUDiscountpageLog.setDpId(dpid);
        Date date = new Date();
        long time = date.getTime();
        tbRUDiscountpageLog.setSyscreated(new Timestamp(time));
        tbRUDiscountpageLog.setrTime(new Timestamp(time));
        tbRUDiscountpageLog.setActive(1);
        tbRUDiscountpageLog.setState(0);
        int insert = tbRUDiscountpageLogMapper.insert(tbRUDiscountpageLog);
        logger.debug("插入优惠兑换的优惠券", ((Integer) insert).toString());

        this.insertBeanDetail("优惠券兑换", point_val, 0, this.getUser().getUid());
    }

    public int insertBeanDetail(String action, Integer point_val, Integer incomePay, Integer uid) {
        TbSysUBeanDetail tbSysUBeanDetail = new TbSysUBeanDetail();
        tbSysUBeanDetail.setuId(uid);
        tbSysUBeanDetail.setAction(point_val);
        tbSysUBeanDetail.setDescribebean(action);
        Date date1 = new Date();
        long time1 = date1.getTime();
        tbSysUBeanDetail.setSyscreated(new Timestamp(time1));
        tbSysUBeanDetail.setActive(1);
        tbSysUBeanDetail.setIncomePay(incomePay);
        int insert1 = tbSysUBeanDetailMapper.insert(tbSysUBeanDetail);
        logger.debug("插入豆值支出收入详情", ((Integer) insert1).toString());
        return insert1;
    }

    /*机器人接口*/

    public Map<String, Object> updateSignHistoryInterface(JSONObject jsonObject) throws ParseException {
        return updateSignHistory(jsonObject.getInteger("uid"));
    }

    public Map<String, Object> getLoginInfo() {
        Map<String, Object> returnMap = new HashMap<>();
        User user = getUser();
        TbSysUserBoy children = getChildren(user);
        returnMap.put("uid", user.getUid());
        returnMap.put("username", user.getUsername());
        returnMap.put("password", user.getPassword());
        returnMap.put("phonenum", user.getPhone());
        returnMap.put("beanname", children.getuBoyName());
        returnMap.put("age", children.getAge());
        returnMap.put("sex", children.getSex());
        return returnMap;
    }

    public Map<String, Object> updateSign(JSONObject jsonObject) throws ParseException {
        return updateSignInfo(jsonObject.getInteger("uid"));
    }

    public Map<String, Object> getCKindList() {
        Map<String, Object> returnMap = new HashMap<>();
        Integer[] pKind = new Integer[]{1, 2, 3, 4};
        String[] pKindName = new String[]{"song", "story", "study", "animation"};
        int i = 0;
        for (Integer pKindItem : pKind) {
            OutkindExample outkindExample = new OutkindExample();
            outkindExample.createCriteria().andPkidEqualTo(pKindItem);
            List<Outkind> cOutkinds = outkindMapper.selectByExample(outkindExample);
            if (cOutkinds == null) {
                return null;
            }
            logger.debug("查找子种类", cOutkinds.toString());
            returnMap.put(pKindName[i++], cOutkinds);
        }
        return returnMap;
    }

    public Map<String, Object> getOutVideoList(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        Integer kindId = jsonObject.getInteger("kindId");
        Integer page = jsonObject.getInteger("page");
        Integer size = jsonObject.getInteger("size");
        PageHelper.startPage(page, size);
        OutvideoExample outvideoExample = new OutvideoExample();
        outvideoExample.createCriteria().andSkindEqualTo(kindId);
        outvideoExample.setOrderByClause("vopaly desc");
        List<Outvideo> outvideos = outvideoMapper.selectByExample(outvideoExample);
        if (outvideos == null) {
            return null;
        }
        logger.debug("查找分类外部视频", outvideos.toString());
        returnMap.put("outVideo", outvideos);
        return returnMap;
    }

    public Map<String, Object> updateOutVideoCount(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        OutvideoExample outvideoExample = new OutvideoExample();
        outvideoExample.createCriteria().andOvidEqualTo(jsonObject.getInteger("ovid"));
        List<Outvideo> outvideos = outvideoMapper.selectByExample(outvideoExample);
        if (outvideos == null || outvideos.size() <= 0) {
            return null;
        }
        logger.debug("查找外部视频", outvideos.toString());
        Outvideo outvideo = outvideos.get(0);
        outvideo.setVopaly(outvideo.getVopaly() + 1);
        int i = outvideoMapper.updateByPrimaryKey(outvideo);
        logger.debug("外部视频播放数加一", i);
        if (i <= 0) {
            return null;
        }
        returnMap.put("videoDetail", outvideo);
        return returnMap;
    }

    public Map<String, Object> getRecommendOutVideoList() {
        Map<String, Object> returnMap = new HashMap<>();
        OutvideoExample outvideoExample = new OutvideoExample();
        outvideoExample.setOrderByClause("vopaly desc");
        List<Outvideo> outvideos = outvideoMapper.selectByExample(outvideoExample);
        if (outvideos == null) {
            return null;
        }
        logger.debug("查找外部视频按播放数排序", outvideos.toString());
        returnMap.put("playCount", outvideos.subList(0, 4));
        OutvideoExample outvideoExample1 = new OutvideoExample();
        outvideoExample1.setOrderByClause("uploadTime desc");
        List<Outvideo> outvideos1 = outvideoMapper.selectByExample(outvideoExample1);
        if (outvideos1 == null) {
            return null;
        }
        logger.debug("查找外部视频按上传时间排序", outvideos1.toString());
        returnMap.put("uploadTime", outvideos1.subList(0, 4));
        return returnMap;
    }

    public Map<String, Object> getOutVideoSearch(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Outvideo> outVideoList = new LinkedList<>();
        String keyWord = jsonObject.getString("keyword");
        String[] split = keyWord.split("\\s+");
        String regEx = "[-`~!@#$%^&*()_+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        for (String splitItem : split) {
            Matcher m = p.matcher(splitItem);
            String trim = m.replaceAll("").trim();
            if (!"".equals(trim)) {
                List<Outvideo> outVideoListSearch = outVideoExt.getOutVideoListSearch(trim);
                if (outVideoListSearch == null) {
                    return null;
                }
                logger.debug("搜索外部视频", outVideoListSearch.toString());
                outVideoList.addAll(outVideoListSearch);
                for (int i = 0; i < outVideoList.size(); i++) {
                    for (int j = outVideoList.size() - 1; j > i; j--) {
                        if (outVideoList.get(i).getOvid().equals(outVideoList.get(j).getOvid())) {
                            outVideoList.remove(j);
                        }
                    }
                }
            }
        }
        returnMap.put("search", outVideoList);
        return returnMap;
    }

    public Map<String, Object> insertFeedback(JSONObject jsonObject) {
        Map<String, Object> returnMap = new HashMap<>();
        Feedback feedback = new Feedback();
        feedback.setUid(jsonObject.getInteger("uid"));
        feedback.setContactway(jsonObject.getString("contactWay"));
        Date date = new Date();
        long time = date.getTime();
        feedback.setUploadtime(new Timestamp(time));
        feedback.setSuggestion(jsonObject.getString("suggestion"));
        int insert = feedbackMapper.insert(feedback);
        if (insert <= 0) {
            return null;
        } else {
            logger.debug("插入意见反馈", insert);
        }
        return returnMap;
    }
}
