package net.aplux.services.impl;

import net.aplux.dao.impl.UserDaoImpl;
import net.aplux.pojo.User;
import net.aplux.services.UserService;

/**
 * Created by luckf on 2022/4/8.
 */
public class UserServiceImpl implements UserService
{

    private UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public void registerUser(User user)
    {
        userDao.saveUser(user);

    }

    @Override
    public User loginUser(String username, String password)
    {
        return userDao.queryUserByUsernameAndPassword(username,password);

    }

    /**
     *
     * @param username 帳號名稱
     * @return 如果存在，則傳回TRUE，反之則傳回FALSE
     */
    @Override
    public boolean existUsername(String username)
    {
        if(userDao.queryUserByUsername(username)!=null) return true;
        return false;
    }
}
