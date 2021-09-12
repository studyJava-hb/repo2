package com.youyue.service.impl;

import com.youyue.dao.IAccountDao;
import com.youyue.domain.Account;
import com.youyue.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceimpl implements IAccountService {
    @Autowired
    private IAccountDao iAccountDao;

    public List<Account> findAll() {
        return iAccountDao.findAll();
    }

    public void tranfer(String resource, String target) {
        Account rAccount = iAccountDao.findByName(resource);
        Account tAccount = iAccountDao.findByName(target);
        rAccount.setMoney(rAccount.getMoney()-500F);
        tAccount.setMoney(tAccount.getMoney()+500F);
        iAccountDao.update(rAccount);
        /*int a= 1/0;*/
        iAccountDao.update(tAccount);
    }
}
