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
 * Created by luckf on 2022/4/10.
 */
@WebServlet(name = "loginServlet" ,urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        UserServiceImpl userService=new UserServiceImpl();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(userService.loginUser(username,password)!=null)
        {
            System.out.println("用戶名["+username+"]登錄成功");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }else
        {
            System.out.println("用戶名["+username+"]登錄失敗");
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
