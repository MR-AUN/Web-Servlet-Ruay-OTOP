package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import model.CustomerModel;

/**
 * Servlet implementation class loginCustomer
 */
@WebServlet("/loginCustomer")
public class loginCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String strUsername = request.getParameter("name");
		String strpassword = request.getParameter("pass");
		try {

			if (strUsername != "" && strpassword != "") {
				CustomerDAO DAO = new CustomerDAO();
				CustomerModel customer = new CustomerModel(strUsername, strpassword);

				CustomerModel result = DAO.loginCustomer(customer);
				if (result != null) {
					session.setAttribute("customer", result);
					response.sendRedirect(request.getContextPath());
				} else {
					response.sendRedirect(request.getContextPath() + "/login.jsp");
				}

			}else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
