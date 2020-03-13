package com.learning.tx.dao;

public interface AccountDao {
    public void out(String outer, int money);

    public void in(String inner, int money);
}
