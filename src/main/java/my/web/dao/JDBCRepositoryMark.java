package my.web.dao;

import my.web.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class JDBCRepositoryMark implements CRUDdao<Mark> {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void add(Mark mark) {

    }

    @Override
    public Mark get(int id) {
        return null;
    }

    @Override
    public List<Mark> getAll() {
        return null;
    }

    @Override
    public void update(Mark mark) {

    }

    @Override
    public void delete(Mark mark) {

    }
}
