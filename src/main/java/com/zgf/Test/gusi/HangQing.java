package com.zgf.Test.gusi;

import com.zgf.Test.util.HttpClientUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class HangQing {

    public static void main(String[] args) {
        ArrayList<GuPiaoInfo> guPiaoInfos = new ArrayList<GuPiaoInfo>();
        guPiaoInfos.add(new GuPiaoInfo("sh510300", "300ETF", "300"));
        guPiaoInfos.add(new GuPiaoInfo("sh600036", "招商", "zs"));

        String url = "https://hq.sinajs.cn/list={ids}";

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerHangQing(url, guPiaoInfos);
            }
        }, 0, 60000);
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

        int index = 0;
        for (String hq : hqSplit) {
            if (hq.startsWith("var") || hq.startsWith("\nvar")) {
                String[] infoSplit = hq.split(",");
//                System.out.println(Arrays.toString(infoSplit));
                BigDecimal lastEndPrice = new BigDecimal(infoSplit[2]);
                BigDecimal curPrice = new BigDecimal(infoSplit[3]);

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
                GuPiaoInfo guPiaoInfo = guPiaoInfos.get(index);
                System.out.print("[" + guPiaoInfo.getShowName() + "," + upOrDown + divide + "],");
                index++;
            }
        }
        System.out.println();
    }
}
