package com.msj.test;

import com.msj.controller.OrderController;
import com.msj.entity.Cart;
import com.msj.entity.Good;
import com.msj.entity.Order;
import com.msj.mapper.*;
import com.msj.service.CartService;
import com.msj.service.DataListService;
import com.msj.service.OrderService;
import com.msj.util.MD5Utils;
import com.msj.util.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/15 12:30
 */
/*配置运行环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/*加载配置文件*/
@ContextConfiguration({"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class TestMapper {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;

    @Test
    public void getAllClasses() {

        System.out.println(orderMapper.getRecordTotal(1));
    }

    @Test
    public void test() {
        String str = "嘻嘻 哈哈";
        System.out.println(str.substring(0, str.indexOf(" ")));
    }

    @Test
    public void md5() {
        System.out.println(DigestUtils.md5Digest("嘻嘻".getBytes()));
        System.out.println(MD5Utils.md5Password("嘻嘻"));

    }
}