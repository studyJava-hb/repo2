package com.youyue.service;

import com.youyue.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    void tranfer(String resource,String target);
}
