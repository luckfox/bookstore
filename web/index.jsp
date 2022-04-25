<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: luckf
  Date: 2022/4/6
  Time: 下午 06:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%!
      private Integer id;
      private String name;
      private static Map<String,Object> map;
      %>
    <%!
      static
      {
          map=new HashMap<String,Object>();
          map.put("key1","value1");
          map.put("key2","value2");
          map.put("key3","value3");
      }

      public int abc()
      {
          return 12;
      }
      public static class A
      {
          private Integer id=12;
          private String abc="1bc";
      }
    %>
    <%= 12+6 %>
  $END$
  </body>
</html>
