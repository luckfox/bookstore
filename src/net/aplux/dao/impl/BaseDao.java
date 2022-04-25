package net.aplux.dao.impl;

import net.aplux.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by luckf on 2022/4/8.
 */
public abstract class BaseDao
{
    private QueryRunner queryRunner=new QueryRunner();

    /**
     * description:執行insert/update/delete
     * @param sql 要執行的SQL語句
     * @param args 參數串列
     * @param password
     * @param email
     * @return  -1表示失敗,其餘表示處理的SQL行數
     */
    public int update(String sql, Object ... args)
    {
        int iret=-1;
        Connection conn=jdbcUtils.getConnection();
        try
        {
            iret=queryRunner.update(conn,sql,args);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            jdbcUtils.close(conn);
        }
        return iret;

    }

    /**
     * 查詢一個javaBean的SQL
     * @param type  返回類型對象
     * @param sql   執行SQL語句
     * @param args  SQL對應參數
     * @param <T>  返回類型的泛型
     * @return 結果
     */
    public <T> T queryForOne(Class<T> type ,String sql,Object ... args)
    {
        Connection conn=jdbcUtils.getConnection();
        try
        {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            jdbcUtils.close(conn);
        }
        return null;
    }

    public <T>List<T> queryForList(Class<T>type , String sql, Object ... args)
    {
        Connection conn=jdbcUtils.getConnection();
        try
        {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            jdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 執行返回一行一列的SQL語句
     * @param sql   執行的SQL語句
     * @param args  SQL語句參數
     * @return 結果
     */

    public Object queryForSingleValue(String sql,Object... args)
    {
        Connection conn=jdbcUtils.getConnection();
        try
        {
            return queryRunner.query(conn,sql,new ScalarHandler<>(),args);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            jdbcUtils.close(conn);
        }
        return null;
    }
}
