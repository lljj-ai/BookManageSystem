package javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowcardDao {
	   public static final String DBDRIVER = "com.mysql.jdbc.Driver";	
	   public static final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	   public static final String DBUSER = "root";
	   public static final String DBPASS = "liujie13";
	   private Connection conn = null;
	   public void borrowcard(int userid,String username) {//办理借书卡
		   PreparedStatement pstmt=null;
		   try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
			    try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("insert into borrowcard(userid,username) values(?,?)");
					pstmt.setInt(1,userid);
	       			pstmt.setString(2,username);
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
	   public boolean isborrowcard(int userid) {//借书时判断是否办理借书卡
		   PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      try {
		    	  Class.forName(DBDRIVER);
		      }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
		    	  System.out.println("δ����");
		      }
			    try{
					conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
					pstmt=conn.prepareStatement("select * from borrowcard where userid=?");
					pstmt.setInt(1,userid);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						return true;
					}else {
						System.out.println("error��");
						return false;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					return false;
				} finally {
					try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	   }
	}
             

