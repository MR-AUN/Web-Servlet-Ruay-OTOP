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

import model.CombinGroupModel;
import model.GoodsModel;

/**
 * Servlet implementation class deleteBasket
 */
@WebServlet("/deleteBasket")
public class deleteBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gson json = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBasket() {
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
			Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods");
			ArrayList<Integer> numberGood = (ArrayList<Integer>)goodList.get("goodNumber");
			ArrayList<CombinGroupModel> combinList = (ArrayList<CombinGroupModel>)goodList.get("combingood");
			String combinId = request.getParameter("id");
			int combin_id = Integer.parseInt(combinId);
			for (int i = 0 ; i < combinList.size() ; i++) {
				if(combinList.get(i).getCombinId() == combin_id) {
					numberGood.remove(i);
					combinList.remove(i);
					break;
				}
			}
			goodList.put("goodNumber", numberGood);
			goodList.put("combingood", combinList);
			session.setAttribute("goods", goodList);
			PrintWriter out = response.getWriter();
			out.print(json.toJson("success"));
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
