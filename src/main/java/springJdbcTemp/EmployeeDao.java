package springJdbcTemp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createEmployee(String name){
        jdbcTemplate.update("insert into employees(emp_name) values (?)", name);
    }

    public List<String> listEmployeeNames(){
        return jdbcTemplate.query("select emp_name from employees order by emp_name", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return resultSet.getString("emp_name");
            }
        });
    }
}
