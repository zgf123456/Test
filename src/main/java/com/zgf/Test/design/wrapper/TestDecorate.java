package com.zgf.Test.design.wrapper;

import java.util.UUID;

/**
 * Created by zgf on 17/6/15.
 */
public class TestDecorate {
    public static void main(String[] args) throws Exception {
//        BufferedReader aaaaa = new BufferedReader(new InputStreamReader(new FileInputStream("aaaaa")));

        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
    }
}
