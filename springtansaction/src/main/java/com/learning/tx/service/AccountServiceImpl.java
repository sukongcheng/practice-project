package com.learning.tx.service;

import com.learning.tx.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
//    private TransactionTemplate transactionTemplate;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
//
//    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
//        this.transactionTemplate = transactionTemplate;
//    }

    @Override
    public void transfer(final String outer, final String inner, final int money) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                accountDao.out(outer, money);
//                int i = 1/0;
//                accountDao.in(inner, money);
//            }
//        });

        accountDao.out(outer, money);
        int i = 1/0;
        accountDao.in(inner, money);
    }
}
