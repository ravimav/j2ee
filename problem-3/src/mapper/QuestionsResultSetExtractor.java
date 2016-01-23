package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import domainmodel.Questions;
import domainmodel.Users;

public class QuestionsResultSetExtractor implements ResultSetExtractor {

  @Override
  public Object extractData(ResultSet rs) throws SQLException {
    Questions questions = new Questions();
	Users user =new Users();
	user.setUsername(rs.getString(1));
    questions.setId(rs.getInt(3));
    questions.setUser(user);
	questions.setText(rs.getString(2));
//	questions.setCreatedAt(rs.getDate(4));
    return questions;
  }

} 