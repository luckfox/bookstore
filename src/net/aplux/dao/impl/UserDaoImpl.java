package net.aplux.dao.impl;

import net.aplux.dao.UserDao;
import net.aplux.pojo.User;

/**
 * Created by luckf on 2022/4/8.
 */
public class UserDaoImpl extends BaseDao implements UserDao
{


    /**
     * description 根據用戶名查詢用戶是否存在
     *
     * @param username 用戶名
     * @return 如果返回null，則表示沒有此用戶
     */
    @Override
    public User queryUserByUsername(String username)
    {
        String sql ="select `id`,`username`,`password`,`email` from t_user where username = ?";
        User user= queryForOne(User.class,sql,username);
        if(user!=null) System.out.println(user.toString());
        else System.out.println("該使用者["+username+"]不存在");
        return user;
    }

    /**
     * description 根據用戶名稱與密碼查詢用戶資料
     *
     * @param username 用戶名
     * @param password 用戶密碼
     * @return
     */
    @Override
    public User queryUserByUsernameAndPassword(String username, String password)
    {
        String sql ="select `id`,`username`,`password`,`email` from t_user where username = ? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user)
    {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";

        int ret=update(sql,user.getUsername(),user.getPassword(),user.getEmail());
        return ret;

    }
}
