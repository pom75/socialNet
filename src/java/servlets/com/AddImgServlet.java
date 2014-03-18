/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.com;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ErrorL;
import services.ServicesTools;

/**
 *
 * @author Steph
 */
public class AddImgServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        if (request.getContentLength() <= 307890) {


            OutputStream out = response.getOutputStream();
            String mess = "";

            ServletInputStream aa = request.getInputStream();
            byte[] buffer = new byte[1024];

            aa.readLine(buffer, 0, 1024);
            String t = new String(buffer, "Cp1252");
            mess += t + "\n";
            aa.readLine(buffer, 0, 1024);
            t = new String(buffer, "Cp1252");
            mess += t + "\n";
            aa.readLine(buffer, 0, 1024);
            t = new String(buffer, "Cp1252");
            mess += t + "\n";
            aa.readLine(buffer, 0, 1024);
            t = new String(buffer, "Cp1252");
            mess += t + "\n";
            mess += "FIN";
            System.out.println(mess);



            response.setContentType("image/png");



            int len = 0;
            while ((len = aa.read()) >= 0) {
                out.write(len);
            }


            aa.close();
            out.close();



        } else {
            response.getWriter().println(ServicesTools.erreur(ErrorL.getErrorL(20), 20));
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
