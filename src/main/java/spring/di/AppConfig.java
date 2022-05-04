package spring.di;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
@PropertySource("classpath:/application.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(environment.getProperty("jdbc.url"));
//        dataSource.setURL("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser(environment.getProperty("jdbc.username"));
//        dataSource.setUser("root");
        dataSource.setPassword(environment.getProperty("jdbc.password"));
//        dataSource.setPassword("Test123!");
        return dataSource;
    }
}
