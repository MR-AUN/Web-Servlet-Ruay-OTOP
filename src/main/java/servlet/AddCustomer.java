package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDAO;
import dao.CustomerDAO;
import model.CustomerModel;
import model.addressModel;


/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
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
		String strName = request.getParameter("name");
		String strLastname = request.getParameter("lastname");
		String strUsername = request.getParameter("username");
		String strEmail = request.getParameter("email");
		String strpassword = request.getParameter("pass");
		String strPhone = request.getParameter("phone");
		String strAddress = request.getParameter("message");
		
		try {
			
			if(strName != ""&&strLastname!=""&&strPhone != "" && strUsername != "" && strEmail != "" && strpassword != "" && strAddress != "") {
				CustomerDAO DAO = new CustomerDAO();
				AddressDAO addressDAO = new AddressDAO();
				CustomerModel customer = new CustomerModel(strName, strLastname, strUsername, strEmail, strpassword, 1);
				
				int idCustomer = DAO.addCustomerGetId(customer);
				System.out.println("IdCustomer: "+idCustomer);
				CustomerModel cus = DAO.searchCustomer(idCustomer);
				System.out.println("CustomerModel : "+cus);
				System.out.println("Address : "+strAddress);
				addressModel add = new addressModel( strAddress, cus);
				addressDAO.addAddress(add);
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}else {
				response.sendRedirect(request.getContextPath() + "/register.jsp");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
