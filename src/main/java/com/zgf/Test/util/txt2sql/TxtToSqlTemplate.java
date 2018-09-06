package com.zgf.Test.util.txt2sql;

import java.io.*;

/**
 * Created by zgf on 17/7/7.
 */
public class TxtToSqlTemplate {
    private String sqlTemplate;
    private String filePath;
    private String targetPath;

    public TxtToSqlTemplate(String sqlTemplate, String filePath, String targetPath) {
        this.sqlTemplate = sqlTemplate;
        this.filePath = filePath;
        this.targetPath = targetPath;
    }

    public void buildSql() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        File targetFile = new File(targetPath);
        if (targetFile.exists()) {
            throw new RuntimeException("文件" + targetPath + "已经存在");
        }
        targetFile.createNewFile();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetPath), "UTF-8"));

        String str = null;
        do {
            str = reader.readLine();
            if (str != null) {
                System.out.println(str);
                String[] split = str.split("\\s+");
            }
        } while (str != null);

        writer.flush();
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        String sqlTemplate = "";
        String filePath = "";
        String targetPath = "";

        TxtToSqlTemplate txtToSqlTemplate = new TxtToSqlTemplate(sqlTemplate, filePath, targetPath);
        txtToSqlTemplate.buildSql();
        System.out.println("生成SQL结束");
    }
}
