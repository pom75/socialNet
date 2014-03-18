/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.mess;

/**
 *
 * @author Steph
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.mess.GetMessService;
import services.mess.SendMessService;

/**
 * Servlet implementation class SearchServlet
 */
public class SendMessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key=request.getParameter("key");
                    String idp=request.getParameter("idp");
                    String mess=request.getParameter("mess");
          

		SendMessService messService=new SendMessService(key,idp,mess);

		response.setContentType("text/plain");
		response.getWriter().println(messService.service());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}