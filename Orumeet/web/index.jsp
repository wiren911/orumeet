<%-- 
    Document   : index
    Created on : 2018-jan-25, 09:59:38
    Author     : user
--%>
<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date" %>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert Users to Database</h1>
        <%!
            public class User{
                String url = "jdbc:mysql://localhost:3306/oru";
                String Username = "root";
                String PassWord = "";
                
                Connection connection = null;
                PreparedStatement insertUser = null;
                ResultSet resultSet = null;

                public User(){
                    try {
                        connection = DriverManager.getConnection(url, Username, PassWord);
                        
                        insertUser = connection.prepareStatement(
                        "insert into larare (username, email, date)"
                        + "values (David, david, '1999-19-19')");
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                public int setUser(String uname, String email, Timestamp timeStamp){
                    
                    int result = 0;
                    
                    try {
                        insertUser.setString(1, uname);
                        insertUser.setString(2, email);
                        insertUser.setTimestamp(3, timeStamp);
                        result = insertUser.executeUpdate();
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        %>
        
        <%
            int result = 0;
            String Name = new String();
            String Email = new String();
            
            if(request.getParameter("uname") != null){
                Name = request.getParameter("uname");
            }
            if(request.getParameter("email") != null){
                Email = request.getParameter("email");
            }
            
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            
            User user = new User();
            result = user.setUser(Name, Email, timeStamp);
        %>
        <form name="myForm" action="index.jsp" method="POST">           
            Username: <input type="text" name="uname">
            Email: <input type="text" name="email">

            <input type="submit" value="Submit" name="Submit">
        </form>
    </body>
</html>
