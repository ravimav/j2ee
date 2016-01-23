package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import domainmodel.Questions;
import domainmodel.Users;
import domainmodel.Answers;

public class AnswersResultSetExtractor implements ResultSetExtractor {

  @Override
  public Object extractData(ResultSet rs) throws SQLException {
    Answers ans = new Answers();
	Users user =new Users();
	Questions que=new Questions();
//	que.setId(rs.getInt("QUESTION_ID"))
	
	user.setUsername(rs.getString(3));
  //  ans.setId(rs.getInt(3));
    ans.setUser(user);
	ans.setText(rs.getString(1));
//	questions.setCreatedAt(rs.getDate(4));
    return ans;
  }

} 