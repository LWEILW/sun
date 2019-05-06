//package com.sunshine;
//
//
//import org.junit.Test;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Connection;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JdbcTest {
//
//
//    @Test
//    public void jdbcall() throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
//        String username = "root";
//        String password = "123456";
//        Connection conn = DriverManager.getConnection(url, username, password);//用参数得到连接对象
//        System.out.println("连接成功！");
//        System.out.println(conn);
//    }
//}
//
