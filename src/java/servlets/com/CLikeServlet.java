package servlets.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.com.CLikeService;

/**
 * Servlet implementation class LoginServlet
 */
public class CLikeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String idP = request.getParameter("idP");
        String idC = request.getParameter("idC");
        String arg = request.getParameter("arg");

        System.out.println(arg);
        
        CLikeService cLikeService = new CLikeService(key, idP, idC, arg);

        response.setContentType("text/plain");
        response.getWriter().println(cLikeService.service());

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}