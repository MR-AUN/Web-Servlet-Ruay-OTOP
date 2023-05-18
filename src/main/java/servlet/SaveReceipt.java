package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mysql.cj.Session;

import dao.AddressDAO;
import dao.CombinGroupDAO;
import dao.GoodsDAO;
import dao.OptionpayDAO;
import dao.ReceiptDAO;
import dao.ReceiptDetailDAO;
import dao.TransportDAO;
import model.CombinGroupModel;
import model.CustomerModel;
import model.GoodsModel;
import model.OptionpayModel;
import model.ReceiptDetailModel;
import model.ReceiptModel;
import model.TransportModel;
import model.addressModel;

/**
 * Servlet implementation class SaveReceipt
 */
@WebServlet("/SaveReceipt")
public class SaveReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gson json = new Gson();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveReceipt() {
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
		PrintWriter out = response.getWriter();
		CombinGroupDAO DAOCOMBIN = new CombinGroupDAO();
		try {
			if(session.getAttribute("customer") != null) {
				CustomerModel customer = (CustomerModel) session.getAttribute("customer") ;
				Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods");
				ArrayList<Integer>  numberGood = (ArrayList<Integer>)goodList.get("goodNumber");
				ArrayList<CombinGroupModel> combinList = (ArrayList<CombinGroupModel>)goodList.get("combingood");
					
					
				ReceiptDAO recDAO = new ReceiptDAO();
				ReceiptDetailDAO recDeDAO = new ReceiptDetailDAO();
				String  addressId = request.getParameter("address");
				String transportId = request.getParameter("transport");
				String optionpayId = request.getParameter("optionpay");
				
				int address_id = Integer.parseInt(addressId);
				int transport_id  = Integer.parseInt(transportId);
				int optionpay_id = Integer.parseInt(optionpayId);
				double total = 0 ;
				for(int i = 0; i < combinList.size(); i++) {
					total += numberGood.get(i) * combinList.get(i).getCombinPrice();
				}
				addressModel address = new AddressDAO().searchAddressByid(address_id);
				TransportModel transport = new TransportDAO().searchById(transport_id);
				OptionpayModel optionpay = new OptionpayDAO().searchById(optionpay_id);
				ReceiptModel rec = new ReceiptModel(total, address, optionpay, transport);
				System.out.println(rec);
				int idRec = recDAO.addReceiptGetId(rec);
				for(int i = 0; i < combinList.size(); i++) {
					double amount = numberGood.get(i) * combinList.get(i).getCombinPrice();
					ReceiptModel recs = recDAO.searchRecGetId(idRec);
					ReceiptDetailModel rec_de = new ReceiptDetailModel(recs, numberGood.get(i), amount, combinList.get(i));
					recDeDAO.addReceipt(rec_de);
					DAOCOMBIN.updateStockCombin(numberGood.get(i), combinList.get(i).getCombinId());
				}
				session.removeAttribute("goods");
				response.sendRedirect(request.getContextPath());
				String success = json.toJson("success");
				out.print(success);
				out.flush();
			}else {
				String error = json.toJson("error");
				out.print(error);
				out.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/paymentconfirm.jsp");
		}
	}

}
