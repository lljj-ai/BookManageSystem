package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.BookDao;
import javaBean.BorrowcardDao;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
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
		int userid=Integer.parseInt(idf);
		String ide = request.getParameter("bookid");
		int bookid=Integer.parseInt(ide);
		String bookname=request.getParameter("bookname");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		BookDao bookdao=new BookDao();
		BorrowcardDao borrowcarddao=new BorrowcardDao();
		if(borrowcarddao.isborrowcard(userid)) {
			      bookdao.borrowbook(userid,bookid,bookname,author,publisher);
			      bookdao.bookupdate(bookid);
			      response.setHeader("refresh", "0;URL=borrow.jsp");
			      //response.setHeader("refresh", "0;URL=jishi.jsp");
		}else {
			      response.setHeader("refresh", "0;URL=errorpage.jsp");
		}
	}

}
