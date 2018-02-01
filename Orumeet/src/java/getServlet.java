/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author Anton Söderberg
 */
@WebServlet(urlPatterns = {"/getServlet"})
public class getServlet extends HttpServlet {
 
    Connection conn;
    Statement stmt;
    String datum;
 
    String dburl = "jdbc:mysql://localhost:3306/oru?zeroDateTimeBehavior=convertToNull";
    String Username = "root";
    String PassWord = "";  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            datum = request.getParameter("valjDatum");
            /* TODO output your page here. You may use following sample code. */
           
            Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dburl, Username, PassWord);
                stmt = conn.createStatement();
                String query = "select * from mote where datum ='"+datum+"'";
                ResultSet rs = stmt.executeQuery(query);
                out.println("<h1> Här presenteras alla möten under valt datum</h1>");
               out.println("<button onclick=goBack()>Go Back");
               out.println("</button>");
               out.println("<script>");
               out.println("function goBack() {");
               out.println("window.history.back()");
               out.println("}");
               out.println("</script>");
               
                while (rs.next()) {
                String titel = rs.getString("title");
                String plats = rs.getString("plats");
                String tid = rs.getString("tid");
                String ettDatum = rs.getString("datum");
               
               
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Info om möte</title>");            
            out.println("</head>");
            out.println("<body>");
           
            
            out.println("<h1>Datum: "+ettDatum+" Tid: "+tid+" <br>Titel: "+titel+" Plats: "+plats+"!</h1>");
            
            out.println("</body>");
            out.println("</html>");
                }//response.sendRedirect("index.html");
                //RequestDispatcher rd = request.getRequestDispatcher("index.html");
                //rd.include(request, response);
        } catch (Exception e){
                e.printStackTrace();
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
