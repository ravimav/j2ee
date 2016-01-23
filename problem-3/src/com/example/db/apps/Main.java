package com.example.db.apps;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.sql.DataSource;
import dao.DerbyDao;
import domainmodel.Questions;
import domainmodel.Users;
import domainmodel.Answers;
import java.util.List;
import java.util.Iterator;	
	

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) throws SQLException
  {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	DataSource ds = (DataSource) ctx.getBean("qandaDataSource");
	DerbyDao dao = new DerbyDao(); 
	
	dao.setDataSource(ds);
	Connection con = null;
	try
	{
		con = ds.getConnection();
	}catch(SQLException e) 
	{
		System.out.println("Could not connect to DB: "+ e.getMessage());
	}
		
		List<Questions> list = dao.listQuestions();
		for (Questions ques : list)
		{
			Users user =new Users();
			int quesId= ques.getId();
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println();
			System.out.println();
			System.out.print(ques.getUser().getUsername()+" :: ");
			System.out.print(ques.getText() + " ");
			
			
			if(quesId >0)
			{
			List<Answers> ansList = dao.listAnswers(quesId);
			System.out.println();
			System.out.println(ansList.size()+" Answers");
			for(Answers ans : ansList)
				{
				//	String ansBy=rs1.getString("username");
					String ansBy=ans.getUser().getUsername();
					String ansText=ans.getText();
					System.out.println();
					System.out.println(ansBy+":"+ansText);
				}
			
			  //System.out.print("Id is "+ ques.getId() + "--> "+quesId);
			
			
			}
		}
	
	
	
  }
}