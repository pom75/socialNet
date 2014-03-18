package servlets.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.com.AddPostService;

/**
 * Servlet implementation class LoginServlet
 */
public class AddPostServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletInputStream aa;
    private byte[] aab;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
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
            response.setCharacterEncoding("UTF-8");
        }

        String key = request.getParameter("key");
        String iduserA = request.getParameter("idA");
        String iduserH = request.getParameter("idH");
        String text = request.getParameter("text");

        AddPostService addPostService = new AddPostService(key, iduserA, text, iduserH);

        response.setContentType("text/plain");
        response.getWriter().println(addPostService.service());

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