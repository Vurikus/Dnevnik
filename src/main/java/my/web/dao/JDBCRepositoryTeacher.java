package my.web.dao;


import my.web.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class JDBCRepositoryTeacher implements CRUDdao<Teacher> {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Teacher teacher) {

    }

    @Override
    public Teacher get(int id) {
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        return null;
    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void delete(Teacher teacher) {

    }
}
