package net.aplux.test;

import net.aplux.dao.UserDao;
import net.aplux.dao.impl.UserDaoImpl;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import net.aplux.pojo.User;
import org.junit.Test;
//import org.junit.runner.RunWith;


/**
 * Created by luckf on 2022/4/8.
 */
//@RunWith(Arquillian.class)
public class UserDaolTest
{
    @Test
    public void queryUserByUsername() throws Exception
    {
        UserDao userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
        if(userDao!=null)  System.out.println("該帳戶存在");
        else System.out.println("該帳戶不存在");

    }

    @Test
    public void queryUserByUsernameAndPassword() throws Exception
    {
        UserDao userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin","admin"));
        if(userDao!=null)  System.out.println("該帳戶密碼一致");
        else System.out.println("該帳戶密碼不一致");
    }

    @Test
    public void saveUser() throws Exception
    {
        UserDao userDao=new UserDaoImpl();
        User user=new User(null,"luckfox0727","a122731470","luckfox0727@gmail.com");
        if(userDao.saveUser(user)<0) System.out.println("加入使用者資料失敗");
        else System.out.println("成功添加使用者資料");
    }

/*
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(net.aplux.dao.impl.UserDaoImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
*/
}
