package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class QuestionsRowMapper implements RowMapper {

  @Override
  public Object mapRow(ResultSet rs, int line) throws SQLException {
    QuestionsResultSetExtractor extractor = new QuestionsResultSetExtractor();
    return extractor.extractData(rs);
  }

} 