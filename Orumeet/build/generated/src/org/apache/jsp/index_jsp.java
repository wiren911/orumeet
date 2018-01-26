package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.*;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
                        + "values (?, ?, ?)");
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
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Insert Users to Database</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <form name=\"myForm\" action=\"index.jsp\" method=\"POST\">           \n");
      out.write("            Username: <input type=\"text\" name=\"uname\">\n");
      out.write("            Email: <input type=\"text\" name=\"email\">\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
