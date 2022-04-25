package net.aplux.web;

import net.aplux.pojo.User;
import net.aplux.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by luckf on 2022/4/9.
 */
@WebServlet(name = "registerServlet" ,urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserServiceImpl userService=new UserServiceImpl();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String code=request.getParameter("code");


        if("abcde".equalsIgnoreCase(code))
        {//驗證碼正確，檢查帳戶是否存在
            if(userService.existUsername(username))
            {
                System.out.println("用戶名["+username+"]已存在");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }else
            {
                userService.registerUser(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            }
        }else
        {//驗證碼錯誤
            System.out.println("驗證碼["+code+"]錯誤");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
