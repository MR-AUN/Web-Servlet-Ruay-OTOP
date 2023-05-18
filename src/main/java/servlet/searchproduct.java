package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.GoodsListDAO;
import model.AdminGoodsModel;

/**
 * Servlet implementation class searchproduct
 */
@WebServlet("/searchproduct")
public class searchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gson json = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchproduct() {
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
		GoodsListDAO DAO = new GoodsListDAO();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String result = "" ;
		try {
			String categorie = request.getParameter("categorie");
			String supcategorie = request.getParameter("supcategorie");
			String province = request.getParameter("province");
			if(categorie != null) {
				ArrayList<AdminGoodsModel> good = DAO.searchGoodsByCategorie(Integer.parseInt(categorie));
				result= json.toJson(good);
			}else if (supcategorie != null) {
				ArrayList<AdminGoodsModel> good = DAO.searchGoodsBySupCategorie(Integer.parseInt(supcategorie));
				result= json.toJson(good);
			}else if (province != null) {
				ArrayList<AdminGoodsModel> good = DAO.searchGoodsByProvince((Integer.parseInt(province)));
				result= json.toJson(good);
			}else {
				result= json.toJson("error");
			}
			 
			out.print(result);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
