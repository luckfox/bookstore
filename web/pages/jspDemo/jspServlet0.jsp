<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.mchange.lang.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: luckf
  Date: 2022/4/14
  Time: 上午 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jspServlet0</title>
</head>
<body>
        <%-- 這是宣告格式--%>
        <%!
            private Integer id;
            private String name;
            private static HashMap<String,Object> map;
        %>
        <%!
            static
            {
                map=new HashMap<String,Object>();
                map.put("key1","value1");
                map.put("key2","value2");
                map.put("key3","value3");
            }
        %>
        <%!
            int getValue(int a,int b)
            {
                return a+b;
            }
        %>
        <%!
            public class user
            {
                Integer id;
                String name;
            }
        %>
        <%-- 這是輸出格式--%>

        <%= 6+5 %><br/>
        <%= ("This is jspServlet0") %><br/>
        <%= map %>

        <%-- 以下是代碼格式 注意--%>
        <%
            for (Map.Entry<String, Object> entry : map.entrySet())
            {
                System.out.println("key=["+entry.getKey()+"]   value=["+entry.getValue()+"]");
            }
        %>
        <%
            //map.forEach((k, v) -> System.out.println(k + ":" + v));
            //map.forEach((u, v) ->System.out.println("key=["+u+"]  value=["+v+"]"));

        %>

</body>
</html>
