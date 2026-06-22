package com.example.macaron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class SuperRepository {

    // 接続情報は本来外部ファイル化すべきですが、教育上の簡略化のため直接記述します
    private static final String DB_URI =
    		"jdbc:mysql://localhost:3306/sip_a?characterEncoding=utf8&"
            + "useSSL=false&serverTimezone=GMT%2B9&"
            + "rewriteBatchedStatements=true";
    private static final String DB_USER = "newuser";
    private static final String DB_PASS = "0";

    /**
     * データベース接続を取得する
     * 呼び出し元で try-with-resources を使用して確実に close することを想定
     * @return データベース接続オブジェクト
     * @throws SQLException 接続失敗時にスロー
     */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
    }
}