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
 * Servlet implementation class SignupControll
 */
@WebServlet("/signup")
public class SignupControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControll() {
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
		
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("newUsername");
		String pass =  request.getParameter("newPassword");
		String re_pass = request.getParameter("repeatPassword");
		if(!pass.equals(re_pass)) {
			//request.setAttribute("messs", "Xin vui lòng nhâp lại");
			request.getRequestDispatcher("views/signup.jsp").forward(request, response);
		}else {
			Dao dao = new Dao();
			Accout a = dao.checkacountExits(user);
			
			if(a==null) {
				//dc signup
				dao.signup(user, pass);
				response.sendRedirect("views/login.jsp");
				
			}else {
				// khong được thì đẩy về tang signup
				request.setAttribute("messs", "Tài khoản đã tồn tại");
		        request.getRequestDispatcher("views/signup.jsp").forward(request, response);
		    }
			}
			
		
		doGet(request, response);
	}

}
