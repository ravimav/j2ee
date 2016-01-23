package com.example.db.apps;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Database {
  public static void main(String[] args) throws SQLException {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	DataSource ds = (DataSource) ctx.getBean("qandaDataSource");
	Connection con = null;
	try{
		con = ds.getConnection();
	}catch(SQLException e) {
		System.out.println("Could not connect to DB: "+ e.getMessage());
	}
	
	if(con!=null)
	{
	Statement stmt = null; 
		try{
			stmt = con.createStatement();
		}catch(SQLException e){
			System.out.println("Could not create statement: "+ e.getMessage());
		}
		if(stmt!= null){
			ResultSet rs = null;
			try{
				rs = stmt.executeQuery("SELECT USER.USERNAME,QUES.TEXT,QUES.ID FROM QUESTIONS QUES,USERS USER WHERE QUES.USER_ID=USER.ID");
			}catch(SQLException e){	
				System.out.println("Could not execute statement: "+ e.getMessage());
			}
			if(rs!=null){
				try{
					String quesId = null;
					while (rs.next()) {
						String username = rs.getString("username");
						//int cnt=0;
						quesId = rs.getString("ID");
						String questext = rs.getString("text");
						
						System.out.println();
						System.out.println("--------------------------------");
						System.out.println();
						System.out.println();
						System.out.println("Question from :"+username);
						System.out.println();
						System.out.println(questext);	
						System.out.println();
						if(quesId!=null)
						{
							ResultSet rsCnt = null;
							try{
								String cntQuery="SELECT COUNT(QUESTION_ID)AS cnt FROM questions que,users user ,answers ans WHERE ans.question_id= que.id AND ans.question_id='"+quesId+"'AND ans.user_id=user.id";
								rsCnt = stmt.executeQuery(cntQuery);
							}catch(SQLException e){	
								System.out.println("Could not execute statement: "+ e.getMessage());
							}
							if(rsCnt != null){
								try{
									while(rsCnt.next())	
									{
										int cnt1=rsCnt.getInt(1);
										System.out.println(cnt1+" "+"Answers");
									}
								}catch(SQLException e){
									System.out.println("Could not fetch from result set: "+ e.getMessage());
								}
							}
							ResultSet rs1 = null;
							try{
								String query1="SELECT ans.text,ans.question_id ,user.username,ans.created_at FROM questions que,users user ,answers ans WHERE ans.question_id=que.id AND ans.user_id=user.id AND ans.question_id='"+quesId+"'ORDER BY ans.id";
								rs1 = stmt.executeQuery(query1);
							}catch(SQLException e){	
								System.out.println("Could not execute statement: "+ e.getMessage());
							}
							if(rs1 != null){
								try{
									System.out.println();
						
									//System.out.println(rsCnt.getRow());	
									while(rs1.next())	
									{
										
										String ansBy=rs1.getString("username");
										String ansText=rs1.getString("text");
										System.out.println();
										System.out.println(ansBy+":"+ansText);
								//		System.out.println("Question id is"+quesId);
										//System.out.println("Answer is"+);
									}
								}catch(SQLException e){
									System.out.println("Could not fetch from result set: "+ e.getMessage());
								}
							}					
						}
					}
				}catch(SQLException e){
					System.out.println("Could not fetch from result set: "+ e.getMessage());
				}
			}
		}
	}
  }
}