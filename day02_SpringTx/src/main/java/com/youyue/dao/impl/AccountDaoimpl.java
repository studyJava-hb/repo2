package com.youyue.dao.impl;

import com.youyue.dao.IAccountDao;
import com.youyue.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoimpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        List<Account> list = null;
       list = jdbcTemplate.query("select * from account", new RowMapper<Account>() {
           public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
               Account account = new Account();
               account.setId(rs.getInt("id"));
               account.setName(rs.getString("name"));
               account.setMoney(rs.getFloat("money"));
               return account;
           }
       });
        return list;
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set money = ?,name = ? where id = ?",account.getMoney(),account.getName(),account.getId());

    }

    public Account findByName(String name) {
        List<Account> list =  jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
       return list.get(0);
    }
}
