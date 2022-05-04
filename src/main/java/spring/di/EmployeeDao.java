package spring.di;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private DataSource dataSource;

    public EmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    private List<String> employees = Collections.synchronizedList(new ArrayList<>());

    public void saveEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("insert into employees (emp_name) values (?)")) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalArgumentException("Can not insert", se);
        }
    }

    public List<String> listEmployees() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select emp_name from employees");
             ResultSet rs = ps.executeQuery()) {

            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
            return names;

        } catch (SQLException se) {
            throw new IllegalArgumentException("Can not insert", se);
        }
    }

}
