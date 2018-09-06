package com.zgf.Test.java;

/**
 * Created by zgf on 18/1/11.
 */
public class TestReplace {
    public static void main(String[] args) {
        final String template = "update fq_tunnel_bns_config set partner = '{{0}}', private_key = '{{1}}' where merch_id='{{2}}' and pmt_prod_code like 'wx%';";
        String data = "m1712130042\tC151610364260110723\t726ec37c80964c69a47c4542a877ad17\n" +
                "m1712130047\tC151610355560610071\t963b7dad5f1b4699b76a61a3d9a991c1\n" +
                "m1712130053\tC151610370877310071\t361412082a254a90af86497053acc59b\n";


        String[] splits = data.split("\\n");
        for (String s : splits) {
            String[] subSplits = s.split("\\t");
            System.out.println(template.replace("{{0}}", subSplits[1]).replace("{{1}}", subSplits[2]).replace("{{2}}", subSplits[0]));
        }
    }
}
