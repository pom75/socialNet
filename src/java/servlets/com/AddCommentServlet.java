package servlets.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.com.AddCommentService;

/**
 * Servlet implementation class LoginServlet
 */
public class AddCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String encoding = request.getCharacterEncoding();
        if (encoding == null || !encoding.equals("UTF-8")) {
            request.setCharacterEncoding("UTF-8");
        }

        String key = request.getParameter("key");
        String idP = request.getParameter("idP");
        String text = request.getParameter("text");

        AddCommentService addComService = new AddCommentService(key, idP, text);

        response.setContentType("text/plain");
        response.getWriter().println(addComService.service());

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