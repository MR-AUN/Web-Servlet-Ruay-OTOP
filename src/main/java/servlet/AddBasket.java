package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import dao.CombinGroupDAO;
import dao.GoodOptionDAO;
import model.CombinGroupModel;
import model.GoodOptionModel;
import model.GoodsModel;

/**
 * Servlet implementation class AddBasket
 */
@WebServlet("/AddBasket")
public class AddBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gson json = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods");
			String good = json.toJson(goodList);
			PrintWriter out = response.getWriter();
			out.print(good);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods");
//			ArrayList<GoodsModel> goodList = (ArrayList<GoodsModel>) session.getAttribute("goods");
			ArrayList<Integer> numberGood = null;
			ArrayList<CombinGroupModel> combinList = null ;
			if (goodList == null) {
				numberGood = new ArrayList<Integer>();
				combinList = new ArrayList<CombinGroupModel>();
				goodList =new HashMap<String, Object>();
			}else {
				numberGood = (ArrayList<Integer>)goodList.get("goodNumber");
				combinList = (ArrayList<CombinGroupModel>)goodList.get("combingood");
			}
			String goodId = request.getParameter("goodId");
			String[] optionId = request.getParameterValues("option");
			String[] groupId = request.getParameterValues("groupId");
			String number = request.getParameter("number");
			String success = "" ;
			if( optionId != null && groupId != null ) {
				if(groupId.length == optionId.length) {
					ArrayList<GoodOptionModel> optionList = new ArrayList<GoodOptionModel>();
					for (String id : optionId) {
						int option_id = Integer.parseInt(id);
						GoodOptionModel option = new GoodOptionDAO().searchOptionById(option_id);
						optionList.add(option);
					}
					String CombinName = optionList.get(0).getGroup().getGood().getGoodName() ;
					for (int i = 0 ; i < optionList.size();i++) {
						CombinName += "-"+optionList.get(i).getGroup().getGroupName()+" "+optionList.get(i).getOptionName();
					}
					CombinGroupModel combinGood = new CombinGroupDAO().searchCustomerName(CombinName);
					
					if(combinGood != null) {
						int numberInt = Integer.parseInt(number);
						if(numberInt <= combinGood.getCombinQua()) {
							boolean check = true;
							for(CombinGroupModel com : combinList) {
								if(com.getCombinId() == combinGood.getCombinId()) {
									check=false ;
									break;
								}
							}
							if(check) {
								numberGood.add(numberInt);
								combinList.add(combinGood);

								goodList.put("goodNumber", numberGood);
								goodList.put("combingood", combinList);
								session.setAttribute("goods", goodList);
								success = json.toJson("success");
							}else {
								success = json.toJson("สินค้าอยู่ในตะกร้าแล้ว");
							}
							

						}else {
							success = json.toJson("จำนวนสินค้าเกินมา "+(numberInt - combinGood.getCombinQua())+ " จำนวน");
						}
					}else {
						success = json.toJson("ไม่เหลือสินค้า");
					}
				}else {
					success = json.toJson("เลือกกลุ่มตัวเลือกไม่ครบ");
				}
			}else {
				int numberInt = Integer.parseInt(number);
				int good_id = Integer.parseInt(goodId);
				CombinGroupModel combinGood = new CombinGroupDAO().searchCustomerByIdGood(good_id);
				if(combinGood != null) {
					if(numberInt <= combinGood.getCombinQua()) {
						boolean check = true;
						for(CombinGroupModel com : combinList) {
							if(com.getCombinId() == combinGood.getCombinId()) {
								check=false ;
								break;
							}
						}
						if(check) {
							numberGood.add(numberInt);
							combinList.add(combinGood);

							goodList.put("goodNumber", numberGood);
							goodList.put("combingood", combinList);
							session.setAttribute("goods", goodList);
							success = json.toJson("success");
						}else {
							success = json.toJson("สินค้าอยู่ในตะกร้าแล้ว");
						}
					}
				}else {
					success = json.toJson("ไม่เหลือสินค้า");
				}
			}
			


			PrintWriter out = response.getWriter();
			out.print(success);
			out.flush();
//			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
