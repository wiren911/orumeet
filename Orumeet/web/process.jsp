<%@page import="com.oreilly.servlet.MultipartRequest" %>

<%

    MultipartRequest m=new MultipartRequest(request, "C:/uploads");

    out.println("Successfully Uploaded..");

    %>