package net.aplux.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by luckf on 2022/4/7.
 */
public class jdbcUtils
{
    private static DruidDataSource dataSource;
    static
    {
        Properties properties=new Properties();
        InputStream inputStream=jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try
        {
            properties.load(inputStream);
            //建立資料庫
            dataSource= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
            System.out.println("dataSource init OK");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static Connection getConnection()
    {
         Connection conn=null;
        try
        {
            conn= dataSource.getConnection();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn)
    {
        if(conn!=null) try
        {
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
