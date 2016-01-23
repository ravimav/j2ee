package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

@WebServlet ("/list")
public class DatabaseAppServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
						throws ServletException, IOException{
					 
		resp.setContentType("text/html");
					 
		PrintWriter out = resp.getWriter();
		//out.println("<H1> Hello World</H1>");
		
		//out.println("<h3> Database code starts here</h3>");
		
		
		String driver = "org.hsqldb.jdbc.JDBCDriver";
		String url = "jdbc:hsqldb:hsql://localhost/cpsc476;ifexit=true";
		String dbUsername = "SA";
		String dbPassword = "Passw0rd";
	
			try{
				  Class.forName(driver);
			}   

			catch (Exception e){
				System.out.println("<h3>ERROR: failed to load HSQLDB JDBC driver:</h3>" + e.getMessage());
				 e.printStackTrace();
			}
		
			
			try{
				Connection con = DriverManager.getConnection(url,dbUsername,dbPassword);
				Statement stmt = con.createStatement();
				String query = "SELECT USER.USERNAME,QUES.TEXT,QUES.ID FROM QUESTIONS QUES,USERS USER WHERE QUES.USER_ID=USER.ID;";
				ResultSet rs = stmt.executeQuery(query);
			
				int cnt = 0;
				while (rs.next()) {
					String username = rs.getString("username");
					String quesId = rs.getString("ID");
					String questext = rs.getString("text");
					
					out.println();
					if(cnt!=0) {
						out.println("<h3>--------------------------------</h3>");
					}
					cnt = 1;
					out.println();
					out.println();
					out.println("<h3>Question from :" + username + "</h3>");
					out.println();
					out.println("<p>" + questext + "</p>");	
					out.println();
					
					//System.out.println(quesId);
					 //System.out.println();
				
					if(quesId!=null)
					{
						String query1="Select ans.text,ans.question_id ,user.username,ans.created_at from questions que,users user ,answers ans where ans.question_id=que.id and ans.user_id=user.id and ans.question_id='"+quesId+"'order by ans.id";
						String cntQuery="Select COUNT(QUESTION_ID)AS cnt from questions que,users user ,answers ans where ans.question_id= que.id and ans.question_id='"+quesId+"'and ans.user_id=user.id";
						ResultSet rs1 = stmt.executeQuery(query1);
						ResultSet rsCnt = stmt.executeQuery(cntQuery);
						while(rsCnt.next())	
						{
							int cnt1 = rsCnt.getInt(1);
							out.println("<p>" + cnt1 + " Answers" + "</p>");
						}
						
						//out.println();
					
						//System.out.println(rsCnt.getRow());
						out.println("<p>");
						while(rs1.next())	
						{
							
							String ansBy=rs1.getString("username");
							String ansText=rs1.getString("text");							
							out.println(ansBy + ": " + ansText);
							out.println("<br />");
							
					//		System.out.println("Question id is"+quesId);
							//System.out.println("Answer is"+);
						}
						out.println("</p>"); 
						
					}
				}	
				
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}	
			out.close();
			
	}

}

