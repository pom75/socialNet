package servlets.friend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.friend.AccFriendService;

/**
 * Servlet implement
 */
public class AccFriendServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String idF = request.getParameter("idF");
        String accF = request.getParameter("accF");

        AccFriendService accFriService = new AccFriendService(key, idF , accF);

        response.setContentType("text/plain");
        response.getWriter().println(accFriService.service());

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