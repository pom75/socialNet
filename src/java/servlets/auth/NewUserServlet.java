package servlets.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.auth.NewUserService;

/**
 * Servlet implementation class NewUser <br>
 * Cette class permet de gérer la création d'un nouvelle utilisateur dans la
 * base de donné <br>
 * et delegue son service é la classe NewUserService
 */

public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public NewUserServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * La methode doGet recoit comme parametre : login, pass, name et mail <br>
	 * et retourn un text format JSON en cas d'erreur
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String fname = req.getParameter("fname");
		String mail = req.getParameter("mail");

		// Creation du service
		NewUserService newUserService = new NewUserService(login, pass, name, fname , mail);

		// Recupération du resultat en JSONObj
		res.setContentType("text/plain");
		res.getWriter().println(newUserService.service());
	}

	/**
	 * La methode doPost recoit comme parametre : login, pass, name et mail <br>
	 * et retourn un text format JSON en cas d'erreur
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.doGet(req, res);
	}
}
