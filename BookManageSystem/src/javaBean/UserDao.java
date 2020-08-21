package javaBean;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class UserDao {
	   public static final String DBDRIVER = "com.mysql.jdbc.Driver";	
	   public static final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	   public static final String DBUSER = "root";
	   public static final String DBPASS = "liujie13";
	   private Connection conn = null;

       public boolean loginUser(int userid,String password){//用户登录
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
				pstmt=conn.prepareStatement("select * from user where userid=? and password=?");
				pstmt.setInt(1,userid);
				pstmt.setString(2,password);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return true;
				}else {
					System.out.println("用户不存在");
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
      public void registeruser(String username,String password,String phonenum) {//用户注册
    	  PreparedStatement pstmt=null;
    	  try {
	    	  Class.forName(DBDRIVER);
	      }catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
	    	  System.out.println("不对");
	      }
		    try{
				conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
				pstmt=conn.prepareStatement("insert into user(username,password,phonenum) values(?,?,?)");
				pstmt.setString(1,username);
				pstmt.setString(2,password);
				pstmt.setString(3,phonenum);
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
 
 }
     

