package web.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class DbInit {
    private final DataSource dataSource;

    public DbInit(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @PostConstruct
    public void init() throws IOException, SQLException {
        Resource resource = new ClassPathResource("data.sql");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
    }
}
