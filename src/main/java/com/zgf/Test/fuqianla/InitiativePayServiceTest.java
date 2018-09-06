package com.zgf.Test.fuqianla;

import com.alibaba.fastjson.JSON;
import com.lycheepay.gateway.client.GatewayClientException;
import com.lycheepay.gateway.client.InitiativePayService;
import com.lycheepay.gateway.client.dto.initiativepay.*;
import com.lycheepay.gateway.client.security.KeystoreSignProvider;
import com.lycheepay.gateway.client.security.SignProvider;

/**
 * @author fuchengken
 */
public class InitiativePayServiceTest {
    InitiativePayService service;
    String merchantId = "2015062500079840";// 2015062500079840 2017030200113367
    String secMerchantId = "111111111112";
    // String productNo = "productNo";
    public static final String WX_BANK_NO = "0000001";
    public static final String ZFB_BANK_NO = "0000002";
    public static final String YL_BANK_NO = "0000003";
    String orderNo = String.valueOf(System.currentTimeMillis());
    String authCode = "6227028434124571675";
    String amount = "550000";
    String currency = "CNY";
    String tradeName = "tradeName";
    String remark = "remark";
    String tradeTime = "20170225150011";
    String bankNo = WX_BANK_NO;
    String operatorId = "operatorId";
    String storeId = "storeId";
    String terminalId = "49000002";
    String notifyUrl = "http://cashier-por01.lycheepay.org:8080/cashier-initiativepay-test/passivescanpay/notify";
    String couponFlag = "";
    String isS0 = "0";
    String terminalIp = "192.167.1.1";
    String productId = "11111";
    String userOpenId = "11111111";


    public static void main(String[] args) throws Exception {
        InitiativePayServiceTest initiativePayServiceTest = new InitiativePayServiceTest();
        initiativePayServiceTest.init();

        initiativePayServiceTest.action1();
    }

    public void init() throws Exception {
        // 初始化证书
        String merchantIp = "10.36.160.23";
        // 证书类型、证书路径、证书密码、别名、证书容器密码
        SignProvider keystoreSignProvider = new KeystoreSignProvider("PKCS12", "/Users/zgf/Downloads/temp/openssl.pfx", "123456".toCharArray(), null,
                "123456".toCharArray());
        // 签名提供者、商户服务器IP(callerIp)、下载文件路径(暂时没用)
        service = new InitiativePayService(keystoreSignProvider, merchantIp, "zh_CN", "/Users/zgf/Downloads/temp/zip");
        // 设置的交易连接超时时间要大于0小于2分钟,单位:秒.0表示不超时,一直等待,默认30秒
        service.setConnectionTimeoutSeconds(1 * 60);
        // 设置的交易响应超时时间,要大于0小于10分钟,单位:秒.0表示不超时,一直等待,默认5分钟,ps：对应获取对账文件这个应该设长一点时间
        service.setResponseTimeoutSeconds(10 * 60);
    }

    /**
     * 主扫
     *
     * @return
     * @throws Throwable
     */
    public int action1() {
        ActiveScanPayReqDTO reqDTO = new ActiveScanPayReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_zdsm_pay");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId(merchantId);
        // reqDTO.setSecMerchantId(secMerchantId)
        reqDTO.setOrderNo(orderNo);
        reqDTO.setTerminalIp(terminalIp);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setAmount(amount);
        reqDTO.setCurrency(currency);
        reqDTO.setTradeName(tradeName);
        reqDTO.setRemark(remark);
        reqDTO.setTradeTime(tradeTime);
        reqDTO.setBankNo(bankNo);
        reqDTO.setOperatorId(operatorId);
        reqDTO.setStoreId(storeId);
        ActiveScanPayRespDTO resp = null;
        try {
            resp = service.activeScanPay(reqDTO);
            System.out.println("主扫支付响应：" + JSON.toJSONString(resp));
        } catch (GatewayClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }// end of action

    /**
     * 被扫
     *
     * @return
     */
    public int action2() {
        PassiveScanPayReqDTO reqDTO = new PassiveScanPayReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_bdsm_pay");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId(merchantId);
        // reqDTO.setSecMerchantId(secMerchantId)
        reqDTO.setOrderNo(orderNo);
        reqDTO.setAuthCode(authCode);
        reqDTO.setAmount(amount);
        reqDTO.setCurrency(currency);
        reqDTO.setTradeName(tradeName);
        reqDTO.setRemark(remark);
        reqDTO.setTradeTime(tradeTime);
        reqDTO.setBankNo(bankNo);
        reqDTO.setOperatorId(operatorId);
        reqDTO.setStoreId(storeId);
        reqDTO.setTerminalId(terminalId);
        reqDTO.setCouponFlag(couponFlag);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setIsS0(isS0);
        try {
            PassiveScanPayRespDTO resp = service.passiveScanPay(reqDTO);
            System.out.println("被扫支付响应：" + JSON.toJSONString(resp));
        } catch (GatewayClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * app支付
     */
    public int action3() {
        AppPayReqDTO reqDTO = new AppPayReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_app_pay");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId(merchantId);
        // reqDTO.setSecMerchantId(secMerchantId)
        reqDTO.setOrderNo(orderNo);
        reqDTO.setTerminalIp(terminalIp);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setProductId(productId);
        reqDTO.setAmount(amount);
        reqDTO.setCurrency(currency);
        reqDTO.setTradeName(tradeName);
        reqDTO.setRemark(remark);
        reqDTO.setTradeTime(tradeTime);
        reqDTO.setSubAppId("subAppId");
        reqDTO.setBankNo(bankNo);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setIsS0(isS0);
        try {
            AppPayRespDTO resp = service.appPay(reqDTO);
            System.out.println("app支付响应：" + JSON.toJSONString(resp));
        } catch (GatewayClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 公众号支付
     */
    public int action4() {
        PublicNoPayReqDTO reqDTO = new PublicNoPayReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_pa_pay");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId(merchantId);
        // reqDTO.setSecMerchantId(secMerchantId)
        reqDTO.setOrderNo(orderNo);
        reqDTO.setTerminalIp(terminalIp);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setProductId(productId);
        reqDTO.setAmount(amount);
        reqDTO.setCurrency(currency);
        reqDTO.setTradeName(tradeName);
        reqDTO.setRemark(remark);
        reqDTO.setTradeTime(tradeTime);
        reqDTO.setSubAppId("subAppId");
        reqDTO.setUserOpenId("oZ29IwcKXzcRquJDimXwpgHasek0");
        reqDTO.setBankNo(bankNo);
        reqDTO.setNotifyUrl(notifyUrl);
        reqDTO.setIsS0(isS0);
        try {
            PublicNoPayRespDTO resp = service.publicNoPay(reqDTO);
            System.out.println("公众号支付响应：" + JSON.toJSONString(resp));
        } catch (GatewayClientException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 退款
     */
    public int action5() {
        RefundReqDTO reqDTO = new RefundReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_refund");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId(merchantId);
        reqDTO.setSecMerchantId(secMerchantId);
        reqDTO.setOrderNo(orderNo);
        reqDTO.setOriginalOrderNo("1487558920783");
        reqDTO.setTradeName("酒店预订退款");
        reqDTO.setTradeTime(tradeTime);
        reqDTO.setCurrency(currency);
        reqDTO.setAmount(amount);
        reqDTO.setRemark(remark);
        try {
            RefundRespDTO resp = service.refund(reqDTO);
            System.out.println("退款响应：" + JSON.toJSONString(resp));
        } catch (GatewayClientException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询
     *
     * @throws Throwable
     */
    public int action6() {
        TradeQueryReqDTO reqDTO = new TradeQueryReqDTO();
        reqDTO.setReqNo(String.valueOf(System.currentTimeMillis()));//请求编号
        reqDTO.setService("kpp_trade_record_query");//接口名称
        reqDTO.setVersion("1.0.0-DEV");//接口版本号
        reqDTO.setMerchantId("2017021600080551");
        reqDTO.setOriginalOrderNo("1487729787982");
        try {
            TradeQueryRespDTO resp = service.tradeQuery(reqDTO);
            System.out.println("查询响应：" + JSON.toJSONString(resp));
        } catch (Exception e) {

            e.printStackTrace();
        }
        return 0;
    }


}
