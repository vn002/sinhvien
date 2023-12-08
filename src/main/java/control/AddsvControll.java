package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class AddsvControll
 */
@WebServlet("/add")
public class AddsvControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddsvControll() {
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
		

		request.setCharacterEncoding("UTF-8");
		String tensv = request.getParameter("tensv");
		String lop = request.getParameter("lop");
		int tuoi = Integer.parseInt(request.getParameter("tuoi"));
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email");

		Dao dao = new Dao();
		dao.insertProduct(tensv, lop, tuoi, diachi, email);
		request.getRequestDispatcher("home").forward(request, response);
		//response.sendRedirect("home");
		doGet(request, response);
	}

}
