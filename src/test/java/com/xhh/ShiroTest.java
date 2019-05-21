package com.xhh;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * shiro 测试类
 */
public class ShiroTest {

    @Test
    public void testlogin() throws Exception{
        // 创建securityManager 加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 通过工厂对象，创建SecurityManager对象
        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager绑定在当前运行环境中：让系统随时都可以访问SecurityManager对象
        SecurityUtils.setSecurityManager(securityManager);
        /* 创建当前登录的主体，注意:此时的主体没有经过认证 */
        Subject subject = SecurityUtils.getSubject();
        // 绑定主体登录的身份凭证
        UsernamePasswordToken token = new UsernamePasswordToken("sfy","123456");
        // 主体登录
        subject.login(token);
        // 判断登陆是否成功yang
        System.out.println("验证登陆是否成功！"+ subject.isAuthenticated());
        // 注销
        subject.logout();
        System.out.println("验证登陆是否成功！"+ subject.isAuthenticated());

    }
}
