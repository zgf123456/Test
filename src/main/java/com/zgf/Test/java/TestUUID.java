package com.zgf.Test.java;


import org.bouncycastle.util.encoders.Hex;

public class TestUUID {
    public static void main(String[] args) throws Exception {
//        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
//        // 签名前金额兼容处理
//        BigDecimal amountYuan = new BigDecimal(100).divide(new BigDecimal(100));
//        BigDecimal setScale = amountYuan.setScale(2);
//        System.out.println(setScale.toString());

//        ArrayList<City> cities = new ArrayList<>();
//        cities.add(new City("a", "a1"));
//        cities.add(new City("b", "d1"));
//        cities.add(new City("c", "d1"));
//        cities.add(new City("d", "d1"));
//
//        System.out.println(JSON.toJSONString(cities));
        byte[] bytes = Hex.decode("687866756E64737387866756E647373687866756E647373");

    }

    public static class City {
        public String cityName;
        private String cityCode;

        public City(String cityName, String cityCode) {
            this.cityName = cityName;
            this.cityCode = cityCode;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }
    }
}
