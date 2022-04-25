package net.aplux.dao;

import net.aplux.pojo.User;

/**
 * Created by luckf on 2022/4/8.
 */
public interface UserDao
{

    /**
     *  description 根據用戶名查詢用戶是否存在
     * @param username 用戶名
     * @return  如果返回null，則表示沒有此用戶
     */
    public User queryUserByUsername(String username);

    /**
     * description 根據用戶名稱與密碼查詢用戶資料
     * @param username 用戶名
     * @param password  用戶密碼
     * @return
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     *
     * @param user
     * @return
     */
    public int saveUser(User user);


}
