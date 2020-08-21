package javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {
	   public static final String DBDRIVER = "com.mysql.jdbc.Driver";	
	   public static final String DBURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	   public static final String DBUSER = "root";
	   public static final String DBPASS = "liujie13";
	   private Connection conn = null;
	   public boolean loginManager(int managerid,String password){//管理员登录
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
					pstmt=conn.prepareStatement("select * from manager where managerid=? and password=?");
					pstmt.setInt(1,managerid);
					pstmt.setString(2,password);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						return true;
					}else {
						System.out.println("����Ա�����ڣ�");
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
	   public boolean deleteUser(int userid){// 管理用户	  
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
		   	    pstmt = conn.prepareStatement("delete from user where userid=?"); 
		   	    pstmt.setInt(1, userid);
		   	    pstmt.executeUpdate();
		   	    return true;
		      
		   	 }catch(SQLException se){
		   	  	return false;
		   	 }finally{
		   	  	 try{
		   	  	 	conn.close();
		   	  	 }catch(SQLException se){
		   	  	 }
		   	 }
	   }
		 public void registerManager(String managername,String password,String phonenum) {//管理员注册
			 PreparedStatement pstmt=null;
			 try {
				   Class.forName(DBDRIVER);
				   conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			   } catch (ClassNotFoundException e) {
				   e.printStackTrace();
			   } catch (SQLException e) {
				   e.printStackTrace();
			   }
		    try {
				pstmt=conn.prepareStatement("insert into manager(managername,password,phonenum) values(?,?,?)");
				pstmt.setString(1,managername);
				pstmt.setString(2,password);
				pstmt.setString(3,phonenum);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}finally {
				try {
					pstmt.close();
					conn.close();
				}catch(SQLException e) {
				}
			}
		 }
		 public List<Borrowcard> showUserBookCard() {//显示用户借书卡
			   Statement stmt = null;
			   ResultSet rst = null;
			   String sql = "select * from borrowcard order by userid;";
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
				  List<Borrowcard> list = new ArrayList<Borrowcard>();
		   	      while(rst.next()){
		   	    	  	Borrowcard brrowcard = new Borrowcard();
			   	    	brrowcard.setCardid(rst.getInt("cardid"));
			   	    	brrowcard.setUserid(rst.getInt("userid"));
			   	    	brrowcard.setUsername(rst.getString("username"));
			   	    	list.add(brrowcard);
		          }
		   	      return list;
			   	}catch(SQLException se){
			   	  	  return null;
			   	}finally{
			   	  	 try{
			   	  		rst.close();
			   	  		stmt.close();
			   	  		conn.close();
			   	  	 }catch(SQLException se){
			   	  	 }
			   	 }
		 }
		 public List<User> showUser() {//显示用户
			   Statement stmt = null;
			   ResultSet rst = null;
			   String sql = "select * from user order by userid;";
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
				  List<User> list = new ArrayList<User>();
		   	      while(rst.next()){
		   	    	  User user = new User();	
		   	    	  user.setUserid(rst.getInt("userid"));
		   	    	  user.setUsername(rst.getString("username"));
		   	    	  user.setPhonenum(rst.getString("phonenum"));
		   	    	  list.add(user);
		          }
		   	      return list;
			   	}catch(SQLException se){
			   	  	  return null;
			   	}finally{
			   	  	 try{
			   	  		rst.close();
			   	  		stmt.close();
			   	  		conn.close();
			   	  	 }catch(SQLException se){
			   	  	 }
			   	 }
		 }
}
