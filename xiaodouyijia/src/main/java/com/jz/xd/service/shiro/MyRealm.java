package com.jz.xd.service.shiro;

import com.jz.xd.model.SPermission;
import com.jz.xd.model.User;
import com.jz.xd.service.IndexService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HARU on 2017/3/17.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IndexService indexService;

    private static Logger logger = LogManager.getLogger(MyRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限");
        User user = (User) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            User userEntity = indexService.getUser(user.getUsername());
            List<String> permissions = new ArrayList<String>();
            List<SPermission> permission = indexService.getPermission(userEntity);
            for (SPermission permission1 : permission) {
                if (!StringUtils.isEmpty(permission1.getUrl())) {
                    permissions.add(permission1.getUrl());
                }
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            //添加权限信息
            simpleAuthorizationInfo.addStringPermissions(permissions);
            return simpleAuthorizationInfo;
        } else {
            return null;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("验证登录");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取前台传入的username
        String username = usernamePasswordToken.getUsername();
        if (!StringUtils.isEmpty(username)) {
            //如果用名不为空
            User userEntity = indexService.getUser(username);
            if (userEntity == null) {
                userEntity = indexService.getUserByPhone(username).get(0);
            }
            if (userEntity != null) {
                return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), this.getName());
            }
        }
        return null;
    }
}
