package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.student;
import com.model.student100;

public class admindao {
	String url="jdbc:mysql://localhost:3306/palle";
	String username="root";
	String pwd="admin";
	 Connection con=null;
	 PreparedStatement ps=null;
	Statement stm=null;
	ResultSet rs= null;
	public  ArrayList<student100> displayStudent() {
		ArrayList<student100> al=new ArrayList<student100>();
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish connection
			con=DriverManager.getConnection(url,username,pwd);
			
			stm=con.createStatement();
			rs=  stm.executeQuery("select * from student100");
			
			while(rs.next()) {
				int sno=rs.getInt("sno");
				String sname=rs.getString("name");
				String sub=rs.getString("sub");
				student100  s = new student100(sno, sname, sub);
				
				al.add(s);
				
			}
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		 catch (SQLException e) {
		
			 e.printStackTrace();
		 }
		finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	
	public int insert(student100 s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish connection
			con=DriverManager.getConnection(url,username,pwd);
			ps=con.prepareStatement("insert into student100 values(?,?,?)");
			
			ps.setInt(1,s.getSno());
			ps.setString(2, s.getSname());
			ps.setString(3, s.getSub());
			return ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
		
	}
	public  String validate(student st) {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//establish connection
				con=DriverManager.getConnection(url,username,pwd);
				
				stm=con.createStatement();
				rs=  stm.executeQuery("select * from admin");
				
				while(rs.next()) {
					String demail=rs.getString("email");
					String dpass=rs.getString("password");
					
					if(demail.equals(st.getEmail()) && dpass.equals(st.getPass())) {
						return "success";
					}
				}
				
				
			}
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			 catch (SQLException e) {
			
				 e.printStackTrace();
			 }
			finally {
				try {
					rs.close();
					stm.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "failure";
	}
		
	

}
