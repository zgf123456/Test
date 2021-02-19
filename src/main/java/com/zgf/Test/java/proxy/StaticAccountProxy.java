package com.zgf.Test.java.proxy;

/**
 * 静态代理，需要有接口才行，实现被代理类的接口，持有被代理对象
 * 静态代理会为每一个业务增强都提供一个代理类, 由代理类来创建代理对象
 */
public class StaticAccountProxy implements IAccountService {
    private IAccountService accountService;

    public StaticAccountProxy(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void transfer() {
        System.out.println("before");
        accountService.transfer();
    }

    public static void main(String[] args) {
        AccountServiceImpl accountService = new AccountServiceImpl();
        StaticAccountProxy staticAccountProxy = new StaticAccountProxy(accountService);
        staticAccountProxy.transfer();
    }
}
