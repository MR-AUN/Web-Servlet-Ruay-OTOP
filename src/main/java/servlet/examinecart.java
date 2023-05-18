package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.AddressDAO;
import dao.CombinGroupDAO;
import dao.OptionpayDAO;
import dao.ReceiptDAO;
import dao.ReceiptDetailDAO;
import dao.TransportDAO;
import model.CombinGroupModel;
import model.CustomerModel;
import model.OptionpayModel;
import model.ReceiptDetailModel;
import model.ReceiptModel;
import model.TransportModel;
import model.addressModel;

/**
 * Servlet implementation class examinecart
 */
@WebServlet("/examinecart")
public class examinecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gson json = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public examinecart() {
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
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String success = "";
		double amount = 0 ;
		try {
			if (session.getAttribute("customer") != null) {
				String[] numberList = request.getParameterValues("number");
				
				Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods");
				if (goodList != null || numberList != null) {
					ArrayList<Integer> numberGood = (ArrayList<Integer>) goodList.get("goodNumber");
					ArrayList<CombinGroupModel> combinList = (ArrayList<CombinGroupModel>)goodList.get("combingood");
					for (int i = 0; i < numberGood.size(); i++) {
						CombinGroupModel combin = new CombinGroupDAO().searchCustomerById(combinList.get(i).getCombinId());
						if(Integer.parseInt(numberList[i]) <= combin.getCombinQua()) {
							numberGood.set(i, Integer.parseInt(numberList[i]));
							amount += Integer.parseInt(numberList[i]) * combin.getCombinPrice();
						}else {
							success += (combin.getCombinName() == null ?combin.getGood().getGoodName() : combin.getCombinName()) +" จำนวนสินค้าเกินมา "+(Integer.parseInt(numberList[i]) - combin.getCombinQua())+ " จำนวน \n";
						}
					}
					if(success.equals("")) {
						success = json.toJson("success");
						session.setAttribute("productAmount", amount);
						
					}else {
						success = json.toJson(success);
					}
				} else {
					success = json.toJson("cart");
				}
			} else {
				success = json.toJson("login");
			}
			out.print(success);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
