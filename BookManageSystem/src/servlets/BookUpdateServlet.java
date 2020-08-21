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
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
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
		//修改一条图书记录
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		int bookid = Integer.parseInt(request.getParameter("bookid")); 
		Book book = new Book(bookid,request.getParameter("bookname"),request.getParameter("author"),
			request.getParameter("publisher"),Integer.parseInt(request.getParameter("currentcount")),
			Integer.parseInt(request.getParameter("count")));
		System.out.println(book.getBookid()+book.getBookname());
		BookDao bookdao = new BookDao();
		bookdao.updateBook(book);

		RequestDispatcher view = request.getRequestDispatcher("managebook.jsp");
		view.forward(request, response);
	}

}