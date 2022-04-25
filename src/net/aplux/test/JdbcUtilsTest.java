package net.aplux.test;


import net.aplux.utils.jdbcUtils;
import org.junit.Test;

import java.util.HashMap;


/**
 * Created by luckf on 2022/4/7.
 */
public class JdbcUtilsTest
{
    @Test
    public void JdbcUtilsTest01()
    {
        HashMap<String,Object> map;

        map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println(jdbcUtils.getConnection());
        System.out.println("JdbcUtilsTest01");




    }
}
