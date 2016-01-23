package dao;

import java.util.List;
import javax.sql.DataSource;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import dao.mapper.QuestionsRowMapper;
import dao.mapper.AnswersRowMapper;
import domainmodel.Questions;
import domainmodel.Users;
import domainmodel.Answers;

public class DerbyDao implements IDAO {
  private DataSource dataSource;

  /** 

    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds){
		dataSource = ds;
	}
   public List<Questions> listQuestions(){
	List<Questions> quesList=new ArrayList<Questions>();
	 JdbcTemplate select = new JdbcTemplate(dataSource);
	 String sql="SELECT USER.USERNAME,QUES.TEXT,QUES.ID FROM QUESTIONS QUES,USERS USER WHERE QUES.USER_ID=USER.ID";
	 quesList = select.query(sql,new QuestionsRowMapper());
	return quesList;
   }
   
   
   
   
   public List<Questions> selectAll() {
    JdbcTemplate select = new JdbcTemplate(dataSource);
    return select.query("select * from Questions",new QuestionsRowMapper());
  }
  public List<Answers> listAnswers(int id){
  int quesId=id;
  //System.out.println("Id is "+quesId);
  JdbcTemplate select = new JdbcTemplate(dataSource);
  List<Answers> ansList=new ArrayList<Answers>();
	 String sql="Select ans.text,ans.question_id ,user.username,ans.created_at from questions que,users user ,answers ans where ans.question_id=que.id and ans.user_id=user.id and ans.question_id='"+quesId+"'order by ans.id";
	 ansList = select.query(sql,new AnswersRowMapper());
	return ansList;
  }
   /** 
    * This is the method to be used to list down
    * a record from the Question table corresponding
    * to a passed Question id.
    */
 /**  public Questions getQuestionByUserId(Integer id)
	{
		Questions questions=null;
	return questions;
	}  
*/

  /** 
    * This is the method to be used to list down
    * all the records from the Question table.
    */
  
   public List<Users> listUsers(){
	List<Users> usesList=new ArrayList<Users>();
	return usesList;
   
   }
   public List<Answers> listAnswers(){
   List <Answers> ans=new ArrayList<Answers>();
	return ans;
   }
   
   
}