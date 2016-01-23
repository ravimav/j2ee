import java.io.*;
import java.sql.SQLException;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;

public class DatabaseApp {
	public static void main(String[] args) throws SQLException {
	
		String driver = "org.hsqldb.jdbc.JDBCDriver";
		String url = "jdbc:hsqldb:hsql://localhost/cpsc476;ifexists=true";
		String dbUsername = "SA";
		String dbPassword = "Passw0rd";
		
		try{
			  Class.forName(driver);
		}catch (Exception e)
			   {
			System.out.println("ERROR: failed to load HSQLDB JDBC driver:" + e.getMessage());
			 e.printStackTrace();
		}
		
			
		try{
		Connection con = DriverManager.getConnection(url,dbUsername,dbPassword);
		Statement stmt = con.createStatement();
		String query = "SELECT USER.USERNAME,QUES.TEXT,QUES.ID FROM QUESTIONS QUES,USERS USER WHERE QUES.USER_ID=USER.ID;";
		ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				String username = rs.getString("username");
				int cnt=0;
				String quesId= rs.getString("ID");
				String questext = rs.getString("text");
				
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println();
				System.out.println();
				System.out.println("Question from :"+username);
				System.out.println();
				System.out.println(questext);	
				System.out.println();
				
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
						int cnt1=rsCnt.getInt(1);
						System.out.println(cnt1+" "+"Answers");
					}
					
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
					 
					
				}
			}	
				
		} catch(SQLException e) {
		System.out.println(e.getMessage());
		}

	}
}


