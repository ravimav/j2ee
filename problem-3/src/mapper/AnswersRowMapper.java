package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AnswersRowMapper implements RowMapper {

  @Override
  public Object mapRow(ResultSet rs, int line) throws SQLException {
    AnswersResultSetExtractor extractor = new AnswersResultSetExtractor();
    return extractor.extractData(rs);
  }

} 