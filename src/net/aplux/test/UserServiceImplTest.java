package net.aplux.test;

import net.aplux.pojo.User;
import net.aplux.services.UserService;
import net.aplux.services.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luckf on 2022/4/9.
 */
public class UserServiceImplTest
{
    UserServiceImpl userService=new UserServiceImpl();
    @Test
    public void registerUser() throws Exception
    {
        userService.registerUser(new User(null,"kid0927","123456","kid0927@gmail.com"));
        userService.registerUser(new User(null,"ming0302","123456","ming0302@gmail.com"));
    }

    @Test
    public void loginUser() throws Exception
    {
        userService.loginUser("luckfox0927","a122731470");
    }

    @Test
    public void existUsername() throws Exception
    {
        userService.existUsername("kid0927");
        userService.existUsername("luckfox0927");
        userService.existUsername("aaa456");
    }

}