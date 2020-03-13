package com.learning.springbootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DruidTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void connectTest() throws SQLException {
        System.out.println("数据源类名：" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("是否获取连接：" + (connection != null));
    }
}
