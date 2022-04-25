package net.aplux.services;

import net.aplux.pojo.User;

/**
 * Created by luckf on 2022/4/8.
 */
public interface UserService
{
    public void registerUser(User user);
    public User loginUser(String username,String password);
    public boolean existUsername(String username);
}
