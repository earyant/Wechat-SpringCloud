package com.earyant.web.utils.logs;

import org.apache.log4j.Logger;

public class LogTool {

    Logger logger = Logger.getLogger(LogTool.class);

    //打印Sql语句
    public static void printSql(String sql, Object[] args) {
        if (args == null) {
            System.out.println(sql.toString());
            return;
        }
        String[] sqlArray = sql.split("\\?");
        StringBuffer new_sql = new StringBuffer();
        for (int i = 0; i < sqlArray.length; i++) {
            new_sql.append(sqlArray[i]);
            if (i < args.length) {
                new_sql.append("'").append(args[i]).append("'");
            }
        }
        System.out.println(new_sql.toString());
    }
}
