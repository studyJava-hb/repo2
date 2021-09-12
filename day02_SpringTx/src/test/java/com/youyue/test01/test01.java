package com.youyue.test01;

import com.youyue.domain.Account;
import com.youyue.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class test01 {

    @Autowired
    private IAccountService iAccountService;

    @Test
    public  void test01() {
        List<Account> list = iAccountService.findAll();
        System.out.println(list);
    }

    @Test
    public  void tranfer() {
        iAccountService.tranfer("aaa","bbb");
    }
}
