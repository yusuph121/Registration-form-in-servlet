package com.servlet.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		String n=req.getParameter("name");  
		String p=req.getParameter("email");  
		String e=req.getParameter("pass"); 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps=con.prepareStatement(  
					"insert into reg values(?,?,?)");  
					  
					ps.setString(1,n);  
					ps.setString(2,p);  
					ps.setString(3,e);  
				 
					          
					int i=ps.executeUpdate();  
					if(i>0) { 
					out.print("You are successfully registered...");  
					}else {
					out.print("You are not successfully registered...");  	
					}
			
		}catch(Exception e1) {
			out.println(e1);
		}
		
	}

}
