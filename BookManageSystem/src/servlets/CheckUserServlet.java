package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.ManagerDao;
import javaBean.UserDao;

/**
 * Servlet implementation class CheckUserManager
 */
@WebServlet("/docheck")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String idf = request.getParameter("userid");
		int id=Integer.parseInt(idf);
		String password=request.getParameter("password");
		String select=request.getParameter("select");
		System.out.println(select);
		if("user".equals(select)) {//用户登录     
			UserDao userdao=new UserDao();
		         boolean isSuccess=userdao.loginUser(id, password);
		         if(isSuccess) {
		        	  RequestDispatcher view=request.getRequestDispatcher("useroperate.jsp");
		        	  view.forward(request, response);
		         }else {
		        	  RequestDispatcher view=request.getRequestDispatcher("errorpage.jsp");
		        	  view.forward(request, response);
		         }
		}else if("manager".equals(select)) {//管理员登录
			ManagerDao managerdao=new ManagerDao();
	         boolean isSuccess=managerdao.loginManager(id, password);
	         if(isSuccess) {
	        	  RequestDispatcher view=request.getRequestDispatcher("manageroperate.jsp");
	        	  view.forward(request, response);
	         }else {
	        	  RequestDispatcher view=request.getRequestDispatcher("errorpage.jsp");
	        	  view.forward(request, response);
	         }   
		}
	}

}
