<%@page import="com.oreilly.servlet.MultipartRequest" %>

<%

    MultipartRequest m=new MultipartRequest(request, "/Users/Davidsson/Desktop");

    out.println("Successfully Uploaded..");

    %>