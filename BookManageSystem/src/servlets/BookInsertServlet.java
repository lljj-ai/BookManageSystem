package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Book;
import javaBean.BookDao;

/**
 * Servlet implementation class BookManageServlet
 */
@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertServlet() {
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
	    
		//����һ��ͼ���¼
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		Book book = new Book(request.getParameter("bookname"),request.getParameter("author"),
			request.getParameter("publisher"),Integer.parseInt(request.getParameter("currentcount")),
			Integer.parseInt(request.getParameter("count")));
		BookDao bookdao = new BookDao();
		bookdao.insertBook(book);
		RequestDispatcher view = request.getRequestDispatcher("managebook.jsp");
		view.forward(request, response);
		
			
	}
}
