package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import entity.Accout;

/**
 * Servlet implementation class LoginControll
 */
@WebServlet("/login")
public class LoginControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControll() {
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
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		Dao dao = new Dao();
		Accout a = dao.login(user, pass);
		if (a == null) {
			// Nếu đăng nhập không thành công, set một thuộc tính vào request để hiển thị
			// thông báo lỗi
			
			request.setAttribute("mess", "Tài khoản hoặc mật khẩu không đúng xin vui lòng nhập lại");
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			//response.sendRedirect("views/login.jsp");
		} else {
			//request.getRequestDispatcher("home").forward(request, response);
			response.sendRedirect("home");
		}

		doGet(request, response);
	}

}
