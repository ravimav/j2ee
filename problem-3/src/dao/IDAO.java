package dao;

import java.util.List;
import javax.sql.DataSource;
import domainmodel.Questions;
import domainmodel.Users;
import domainmodel.Answers;


public interface IDAO {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
	public List<Questions> listQuestions();
     public List<Questions> selectAll();
    public List<Answers> listAnswers(int id);
   
   /** 
    * This is the method to be used to list down
    * a record from the Question table corresponding
    * to a passed Question id.
    */
//	List<Person> select(String firstname, String lastname);
	
  // public Questions getQuestionByUserId(Integer id);
  // public Answers getAnswersByUserId(Integer id);
   /** 
    * This is the method to be used to list down
    * all the records from the Question table.
    */
	
   
}