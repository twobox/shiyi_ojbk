package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ojbk.admin.Admin;
import net.ojbk.admin.AdminHandle;

/**
 * Servlet implementation class AdminLogin
 * 
 * 这里就是 Servket ! 这里是 MVC C 层。
 * 
 * @author twobox
 * @version v1.0
 */
@WebServlet("/AdminLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		Admin admin = new Admin();
		AdminHandle adminHandle = new AdminHandle();
		
		String admName = request.getParameter("textid");
		String admPassword = request.getParameter("textPassword");
		
		admin.setAdmName(admName);
		admin.setAdmPassword(admPassword);
		
		if (adminHandle.checkAdmin(admin)) {
			HttpSession session = request.getSession(); // 获取会话
			session.setAttribute("login", "ok");
			session.setMaxInactiveInterval(-1);
			
			request.getRequestDispatcher("user_index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
