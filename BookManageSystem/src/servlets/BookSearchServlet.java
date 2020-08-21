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
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
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
		request.setCharacterEncoding("UTF-8");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		System.out.println(bookid);
	    BookDao bookdao = new BookDao();
	    Book book = bookdao.searchBook(bookid);
	    
	    if(book!=null){
	      request.getSession().setAttribute("book", book);
	      RequestDispatcher view = request.getRequestDispatcher("/searchbook.jsp");
	      view.forward(request, response);
	    }else{
	      RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
	      view.forward(request, response);
	    }
	}

}