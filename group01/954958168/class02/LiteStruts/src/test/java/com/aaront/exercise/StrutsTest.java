package com.aaront.exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class StrutsTest {

    private LiteStruts liteStruts;

    @Before
    public void setUp() {
        liteStruts = new LiteStruts();
    }

    @Test
    public void testLoginActionSuccess() {

        String actionName = "login";

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "test");
        params.put("password", "1234");


        View view = liteStruts.runAction(actionName, params);

        Assert.assertEquals("/jsp/homepage.jsp", view.getJsp());
        Assert.assertEquals("login successful", view.getParameters().get("message"));
    }

    @Test
    public void testLoginActionFailed() {
        String actionName = "login";
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "test");
        params.put("password", "123456"); //密码和预设的不一致

        View view = liteStruts.runAction(actionName, params);

        Assert.assertEquals("/jsp/showLogin.jsp", view.getJsp());
        Assert.assertEquals("login failed,please check your user/pwd", view.getParameters().get("message"));
    }
}
