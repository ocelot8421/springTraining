package springJdbcTemp;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class EmployeeDaoTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private EmployeeDao employeeDao;

    @Before
    public void init() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void testCreateThenList() {
        employeeDao.createEmployee("Veréb");
        List<String> employees = employeeDao.listEmployeeNames();

        assertEquals(Arrays.asList("Veréb"), employees);
    }

    @Test
    public void testThenFind() {
        long id = employeeDao.createEmployee("Bari");
        System.out.println(id);
        String name = employeeDao.findEmployeeNameById(id);
        assertEquals("Bari", name);
    }
}
