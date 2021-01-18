package com.zgf.Test.gusi;

import com.zgf.Test.util.HttpClientUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class HangQing {

    public static void main(String[] args) {
        String url = "https://hq.sinajs.cn/list={ids}";
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerHangQing(url, GuPiaoInfo.guPiaoInfos);
            }
        }, 0, 20000);
    }

    private static void handlerHangQing(String url, ArrayList<GuPiaoInfo> guPiaoInfos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (GuPiaoInfo guPiaoInfo : guPiaoInfos) {
            stringBuffer.append(",");
            stringBuffer.append(guPiaoInfo.getId());
        }
        stringBuffer.deleteCharAt(0);
        url = url.replace("{ids}", stringBuffer.toString());

        String respContent = HttpClientUtil.httpRequest(url, null, null);
//        System.out.println(respContent);
        String[] hqSplit = respContent.split(";");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.print(simpleDateFormat.format(new Date()) + " ");
        int index = 0;
        for (String hq : hqSplit) {
            if (hq.startsWith("var") || hq.startsWith("\nvar")) {
                String[] infoSplit = hq.split(",");
//                System.out.println(Arrays.toString(infoSplit));
                BigDecimal lastEndPrice = new BigDecimal(infoSplit[2]);
                BigDecimal curPrice = new BigDecimal(infoSplit[3]);
                BigDecimal upPrice = new BigDecimal(infoSplit[4]);
                BigDecimal downPrice = new BigDecimal(infoSplit[5]);

                GuPiaoInfo guPiaoInfo = guPiaoInfos.get(index);
                System.out.print("[" + guPiaoInfo.getShowName());
                if (guPiaoInfo.isShowCurPrice()) {
                    System.out.print("," + curPrice);
                }

                // 计算当前价
                calculateCurPrice(lastEndPrice, curPrice);

                // 计算up价
                if(!"3".equals(guPiaoInfo.getShowName())) {
                    calculateUpPrice(upPrice, curPrice);
                }

                // 计算down价
//                calculateDownPrice(downPrice, curPrice);

                System.out.print("],");
                index++;
            }
        }
        System.out.println();
    }

    /**
     * 当前价格
     *
     * @param lastEndPrice
     * @param curPrice
     */
    private static void calculateCurPrice(BigDecimal lastEndPrice, BigDecimal curPrice) {
        String upOrDown = "+";
        BigDecimal subPrice;
        if (curPrice.compareTo(lastEndPrice) >= 0) {
            subPrice = curPrice.subtract(lastEndPrice);
        } else {
            upOrDown = "-";
            subPrice = lastEndPrice.subtract(curPrice);
        }
        BigDecimal divide = subPrice.divide(lastEndPrice, 4, RoundingMode.HALF_UP);
        divide = divide.multiply(new BigDecimal(100));
        divide = divide.setScale(2);
        System.out.print("," + upOrDown + divide);
    }

    /**
     * up价
     *
     * @param upPrice
     * @param curPrice
     */
    private static void calculateUpPrice(BigDecimal upPrice, BigDecimal curPrice) {
        String upOrDown = "+";
        BigDecimal subPrice;
        if (curPrice.compareTo(upPrice) >= 0) {
            subPrice = curPrice.subtract(upPrice);
        } else {
            upOrDown = "-";
            subPrice = upPrice.subtract(curPrice);
        }
        BigDecimal divide = subPrice.divide(upPrice, 4, RoundingMode.HALF_UP);
        divide = divide.multiply(new BigDecimal(100));
        divide = divide.setScale(2);
        System.out.print(",u" + upOrDown + divide);
    }

    /**
     * down价
     *
     * @param downPrice
     * @param curPrice
     */
    private static void calculateDownPrice(BigDecimal downPrice, BigDecimal curPrice) {
        String upOrDown = "+";
        BigDecimal subPrice;
        if (curPrice.compareTo(downPrice) >= 0) {
            subPrice = curPrice.subtract(downPrice);
        } else {
            upOrDown = "-";
            subPrice = downPrice.subtract(curPrice);
        }
        BigDecimal divide = subPrice.divide(downPrice, 4, RoundingMode.HALF_UP);
        divide = divide.multiply(new BigDecimal(100));
        divide = divide.setScale(2);
        System.out.print(",d" + upOrDown + divide);
    }
}
