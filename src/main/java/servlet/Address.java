package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDAO;
import dao.ReceiptDAO;
import model.CustomerModel;
import model.RecCusViewModel;
import model.addressModel;

/**
 * Servlet implementation class Address
 */
@WebServlet("/Address")
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			
			if (session.getAttribute("customer") != null) {
				AddressDAO addressDAO = new AddressDAO();
				CustomerModel cus = (CustomerModel)session.getAttribute("customer");
				String detail = request.getParameter("address");
				addressModel add = new addressModel( detail, cus);
				addressDAO.addAddress(add);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/address.jsp");
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
