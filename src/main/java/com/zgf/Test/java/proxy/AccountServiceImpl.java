package com.zgf.Test.java.proxy;

public class AccountServiceImpl implements IAccountService {
    @Override
    public void transfer() {
        System.out.println("do transfer");
    }
}
