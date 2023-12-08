package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import entity.Product;

/**
 * Servlet implementation class LoadControll
 */
@WebServlet("/update")
public class UpdateControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateControll() {
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
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String tensv = request.getParameter("tensv");
		String lop = request.getParameter("lop");
		int tuoi = Integer.parseInt(request.getParameter("tuoi"));
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email");

		Dao dao = new Dao();
		try {

			// Assuming you have a method in your Dao to update a student
			dao.updateProduct(id, tensv, lop, tuoi, diachi, email);
			request.setAttribute("hienthi", "Bạn đã update thành công!!!");
			response.sendRedirect("home"); // Chuyển hướng đến trang thành công sau khi cập nhật
		} catch (SQLException e) {
			e.printStackTrace();

		}
		doGet(request, response);
	}

}
