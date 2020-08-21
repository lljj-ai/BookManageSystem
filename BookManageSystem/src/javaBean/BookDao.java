package javaBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javaBean.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
public class BookDao {
	   public static final String DBDRIVER = "com.mysql.jdbc.Driver";	
	   public static final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	   public static final String DBUSER = "root";
	   public static final String DBPASS = "liujie13";
	   private Connection conn = null;
	   //管理员操作
	   public Book searchBook(int bookid){// 查询	  
	      PreparedStatement pstmt = null;
	      ResultSet rst = null;
	      Book  book = new Book();
	      try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	      try{
	   	    pstmt = conn.prepareStatement("SELECT * FROM book WHERE bookid=?"); 
	   	    pstmt.setInt(1,bookid);
	   	    rst = pstmt.executeQuery();
	   	    if(rst.next()){
	   	      book.setBookid(rst.getInt("bookid"));
	   	      book.setBookname(rst.getString("bookname"));
	          book.setAuthor(rst.getString("author"));
	          book.setPublisher(rst.getString("publisher"));
	          book.setCurrentcount(rst.getInt("currentcount"));
	          book.setCount(rst.getInt("count"));
	   	      
	          return book;
	        }else{
	          return  null;
	        }
	   	 } catch(SQLException se){
	   	  	return null;
	   	 } finally{
	   	  	 try{
	   	  	rst.close();
		  	 	pstmt.close();
		  		conn.close();
	   	  	 }catch(SQLException se){
	   	  	 }
	   	 }
	   }
	       
	   // 插入图书
	   public boolean insertBook(Book book) {  	  
		   PreparedStatement pstmt = null;
		   try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		   try{
		  	 pstmt = conn.prepareStatement(
		  	 	 "insert into book(bookname,author,publisher,currentcount,count) values(?,?,?,?,?)"); 
		     pstmt.setString(1,book.getBookname());
		     pstmt.setString(2,book.getAuthor());
		     pstmt.setString(3,book.getPublisher());
		     pstmt.setInt(4,book.getCurrentcount());
		     pstmt.setInt(5,book.getCount());
		     
		     pstmt.executeUpdate();
		     return true;
		   }catch(SQLException se){
		  	 return false;
		   }finally{
		  	  try{
		  	 	pstmt.close();
		  		conn.close();
		  	  }catch(SQLException se){ }
		   }
	   }
	   // 删除图书
	   public boolean deleteBook(int bookid) {  	  
	      PreparedStatement pstmt = null;
		   try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	      try{
	   	    pstmt = conn.prepareStatement("delete from book WHERE bookid=?"); 
	   	    pstmt.setInt(1, bookid);
	   	    pstmt.executeUpdate();
	   	    return true;
	      
	   	 }catch(SQLException se){
	   	  	return false;
	   	 }finally{
	   	  	 try{
	   	  	 	pstmt.close();
	   	  		conn.close();
	   	  	 }catch(SQLException se){
	   	  	 }
	   	 }
	   } 
	   
	   // 更新图书
	   public boolean updateBook(Book book) {  	  
		   System.out.println(book.getBookid()+book.getBookname());
		   PreparedStatement pstmt = null;
		   try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		   try{
		  	 pstmt = conn.prepareStatement(
		  			 "update book "
		  			 + "set bookname = '?',author = '?',publisher = '?',currentcount = ?,count = ? "
		  			 + "where bookid = ?"); 
		     pstmt.setString(1,book.getBookname());
		     pstmt.setString(2,book.getAuthor());
		     pstmt.setString(3,book.getPublisher());
		     pstmt.setInt(4,book.getCurrentcount());
		     pstmt.setInt(5,book.getCount());
		     pstmt.setInt(6,book.getBookid());
		     
		     pstmt.executeUpdate();
		     return true;
		   }catch(SQLException se){
		  	 return false;
		   }finally{
		  	  try{
		  	 	pstmt.close();
		  		conn.close();
		  	  }catch(SQLException se){ }
		   }
	   }
	   //用户操作
	  /*public void borrowbook(int userid,int bookid) {
		   Book book = getBookMessage(bookid);
		   PreparedStatement pstmt=null;
	    	  Date date=new Date();
	    	  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  String today=df.format(date);
	    	  try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
			    try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("insert into borrow(userid,bookid,bookname,author,publisher,borrowtime) values(?,?,?,?,?,?)");
					pstmt.setInt(1,userid);
					pstmt.setInt(2,bookid);
					pstmt.setString(3,book.getBookname());
					pstmt.setString(4,book.getAuthor());
					pstmt.setString(5,book.getPublisher());
					pstmt.setString(6,today);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      }
	   }*/
	     public void borrowbook(int userid,int bookid,String bookname,String author,String publisher) {//借书
	    	  PreparedStatement pstmt=null;
	    	  Date date=new Date();
	    	  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  String today=df.format(date);
	    	  try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
			    try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("insert into borrow(userid,bookid,bookname,author,publisher,borrowtime) values(?,?,?,?,?,?)");
					pstmt.setInt(1,userid);
					pstmt.setInt(2,bookid);
					pstmt.setString(3,bookname);
					pstmt.setString(4,author);
					pstmt.setString(5,publisher);
					pstmt.setString(6,today);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      }
	      }	    
	   public void bookupdate(int bookid){//借书更新图书库
		   PreparedStatement pstmt=null;
	    	  try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
	    	  try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("update book set currentcount=currentcount-1 where bookid=? ");
					pstmt.setInt(1,bookid);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      }
	   }
	   public void returnbook(int bookid) {//还书
		      PreparedStatement pstmt=null;
		      Date date=new Date();
	    	  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  String today=df.format(date);
	    	  try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
			    try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("update borrow set returntime=? where bookid=? ");
					pstmt.setString(1, today);
					pstmt.setInt(2,bookid);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      }
	   }
	   public void bookupdate1(int bookid) {//还书更新图书库
		   PreparedStatement pstmt=null;
	    	  try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
	    	  try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("update book set currentcount=currentcount+1 where bookid=? ");
					pstmt.setInt(1,bookid);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	      }
	   }
	   public List<Borrow> showBorrow() { //显示已借图书	  
		   
		   java.sql.Statement stmt = null;
		   ResultSet rst = null;
		   String sql = "select * from borrow order by bookid;";
		   try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		   try{
			  stmt = conn.createStatement();
			  rst = stmt.executeQuery(sql);
			  List<Borrow> list = new ArrayList<Borrow>();
	   	      while(rst.next()){
	   	    	  Borrow book = new Borrow();
	   	    	  book.setUserid(rst.getInt("userid"));
	   	    	  book.setBookid(rst.getInt("bookid"));
	   	    	  book.setBookname(rst.getString("bookname"));
	   	    	  book.setAuthor(rst.getString("author"));
	   	    	  book.setPublisher(rst.getString("publisher"));
	   	    	  book.setBorrowtime(rst.getString("borrowtime"));
	              book.setReturntime(rst.getString("returntime"));
	   	    	  list.add(book);
	   	    	
	   	      }
	   	   return list;
		   	}catch (SQLException e) {
				// TODO Auto-generated catch block
			    return null;
			}finally {
				try {
					rst.close();
					stmt.close();
					conn.close();
				}catch(SQLException e) {
					
				}
			}
	
	   }
public List<Book> showBook() { //显示数据库 	  
		   
		   java.sql.Statement stmt = null;
		   ResultSet rst = null;
		   String sql = "select * from book order by bookid;";
		   try {
			   Class.forName(DBDRIVER);
			   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		   try{
			  stmt = conn.createStatement();
			  rst = stmt.executeQuery(sql);
			  List<Book> list = new ArrayList<Book>();
	   	      while(rst.next()){
	   	    	  Book book = new Book();
	   	    	  book.setBookid(rst.getInt("bookid"));
	   	    	  book.setBookname(rst.getString("bookname"));
	   	    	  book.setAuthor(rst.getString("author"));
	   	    	  book.setPublisher(rst.getString("publisher"));
	   	    	  book.setCurrentcount(rst.getInt("currentcount"));
	   	    	  book.setCount(rst.getInt("count"));
	   	    	  list.add(book);
	   	      }
	   	   return list;
		   	}catch (SQLException e) {
				// TODO Auto-generated catch block
			    return null;
			}finally {
				try {
					rst.close();
					stmt.close();
					conn.close();
				}catch(SQLException e) {
					
				}
			}
	
	   }
/*public Book getBookMessage(int bookid) {
	   java.sql.Statement stmt = null;
	   ResultSet rst = null;
	   String sql = "select * from book where bookid=?";
	   try {
		   Class.forName(DBDRIVER);
		   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	   } catch (ClassNotFoundException e) {
		   e.printStackTrace();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   try{
		  Book book = new Book();
		  stmt = conn.createStatement();
		  rst = stmt.executeQuery(sql);
		  ((PreparedStatement) stmt).setInt(1,bookid);
	      while(rst.next()){
	    	  book.setBookname(rst.getString("bookname"));
	    	  book.setAuthor(rst.getString("author"));
	    	  book.setPublisher(rst.getString("publisher"));
	      }
	   return book;
	   	}catch (SQLException e) {
			// TODO Auto-generated catch block
		    return null;
		}finally {
			try {
				rst.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				
			}
		}

}*/
   /*public Book getBookMessage(int bookid) {
	   Book book = new Book();
	   PreparedStatement pstmt=null;
	   ResultSet rst = null;
	   try {
		   Class.forName(DBDRIVER);
		   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	   } catch (ClassNotFoundException e) {
		   e.printStackTrace();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   try{
		   pstmt = conn.prepareStatement("select * from book where bookid=?");
		   pstmt.setInt(1,bookid);
		   rst = pstmt.executeQuery();
   	    	  book.setBookname(rst.getString("bookname"));
   	    	  book.setAuthor(rst.getString("author"));
   	    	  book.setPublisher(rst.getString("publisher"));
   	    	  return book;
	   	}catch (SQLException e) {
			// TODO Auto-generated catch block
		   return null;
		}finally {
			try {
				rst.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				
			}
		}

   }*/
   
}

                  

