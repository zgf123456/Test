package com.zgf.Test.util;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by zgf on 17/6/13.
 */
public class TxtToSql {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/zgf/Downloads/cityinfo"), "UTF-8"));
        String str = null;

        try {
            LinkedHashSet<CityInfoModel> prov = new LinkedHashSet<CityInfoModel>();
            LinkedHashMap<String, List<CityInfoModel>> provCity = new LinkedHashMap<String, List<CityInfoModel>>();
            LinkedHashMap<String, List<CityInfoModel>> cityArea = new LinkedHashMap<String, List<CityInfoModel>>();

            String strPre1 = null;
            String strPre2 = null;
            String strPre3 = null;

            do {
                str = reader.readLine();
                if (str != null) {
                    str = str.trim().replaceAll("\\u00A0", "").replaceAll((char) 12288 + "", "");

//                    if (str.indexOf("重庆市") != -1) {
//                        System.out.println(str);
//                    }
                    strPre1 = str.substring(0, 2);
                    strPre2 = str.substring(2, 4);
                    strPre3 = str.substring(4, 6);

                    String code = str.substring(0, 6);
                    String name = str.substring(6);

                    // 省级
                    if ("00".equalsIgnoreCase(strPre2) && "00".equalsIgnoreCase(strPre3)) {
                        prov.add(new CityInfoModel(name, code, strPre1));
                    }
                    // 市级
                    else if (!"90".equalsIgnoreCase(strPre2) && "00".equalsIgnoreCase(strPre3)) {
                        List<CityInfoModel> cityInfoModels = provCity.get(strPre1);
                        if (cityInfoModels == null) {
                            cityInfoModels = new ArrayList<>();
                            provCity.put(strPre1, cityInfoModels);
                        }
                        cityInfoModels.add(new CityInfoModel(name, code, strPre1 + strPre2));
                    }
                    // 省直辖市级
                    else if ("90".equalsIgnoreCase(strPre2) && !"00".equalsIgnoreCase(strPre3)) {
                        List<CityInfoModel> cityInfoModels = provCity.get(strPre1);
                        if (cityInfoModels == null) {
                            cityInfoModels = new ArrayList<>();
                            provCity.put(strPre1, cityInfoModels);
                        }
                        cityInfoModels.add(new CityInfoModel(name, code, strPre1 + strPre2));
                    } else if (!"00".equalsIgnoreCase(strPre2) && !"00".equalsIgnoreCase(strPre3) && !"市辖区".equalsIgnoreCase(name)) {
                        List<CityInfoModel> cityInfoModels = cityArea.get(strPre1 + strPre2);
                        if (cityInfoModels == null) {
                            cityInfoModels = new ArrayList<>();
                            cityArea.put(strPre1 + strPre2, cityInfoModels);
                        }
                        cityInfoModels.add(new CityInfoModel(name, code, strPre1 + strPre2 + strPre3));
                    }
                    // 区级
                    else {
                        System.out.println("未处理==>" + str + ",s1=" + strPre1 + ",s2=" + strPre2 + ",s3=" + strPre3);
                    }
                }
            } while (str != null);

            System.out.println(prov.size() + "," + prov.toString());
            System.out.println();
            System.out.println();
            System.out.println(provCity.size() + "," + provCity.toString());
            System.out.println();
            System.out.println();
            System.out.println(cityArea.size() + "," + cityArea.toString());


//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/zgf/Documents/work/开发/付钱拉/现在支付添加省市区编码/cityinfoSql"), "UTF-8"));
//
//            // 省级别
//            for (CityInfoModel p : prov) {
//                String sql = "insert into fq_city_info(LEMMA_ITEM, ITEM_NAME, VERSION, MODEL_FLAG, REMARK, PRAENT_LEMMA_ITEM) values('" + p.getCode() + "', '" + p.getName() + "', 0, 1, 'sql导入', '0');";
//                writer.write(sql);
//                writer.newLine();
//
//                // 市级别
//                List<CityInfoModel> cityInfoModels = provCity.get(p.getShortCode());
//                if (cityInfoModels != null) {
//                    for (CityInfoModel city : cityInfoModels) {
//                        sql = "insert into fq_city_info(LEMMA_ITEM, ITEM_NAME, VERSION, MODEL_FLAG, REMARK, PRAENT_LEMMA_ITEM) values('" + city.getCode() + "', '" + city.getName() + "', 0, 1, 'sql导入', '" + p.getCode() + "');";
//                        writer.write(sql);
//                        writer.newLine();
//
//                        // 区级别
//                        List<CityInfoModel> cityAreaInfoModels = cityArea.get(city.getShortCode());
//                        if (cityAreaInfoModels != null) {
//                            for (CityInfoModel cityAreaInfo : cityAreaInfoModels) {
//                                sql = "insert into fq_city_info(LEMMA_ITEM, ITEM_NAME, VERSION, MODEL_FLAG, REMARK, PRAENT_LEMMA_ITEM) values('" + cityAreaInfo.getCode() + "', '" + cityAreaInfo.getName() + "', 0, 1, 'sql导入', '" + city.getCode() + "');";
//                                writer.write(sql);
//                                writer.newLine();
//                            }
//                        }
//                    }
//                }
//            }
//
//            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(str);
            e.printStackTrace();
        }
    }
}

class CityInfoModel {
    private String name;
    private String code;
    private String shortCode;

    public CityInfoModel(String name, String code, String shortCode) {
        this.name = name;
        this.code = code;
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return "CityInfoModel{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
