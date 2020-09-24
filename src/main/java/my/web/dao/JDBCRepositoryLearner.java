package my.web.dao;

import my.web.model.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class JDBCRepositoryLearner implements CRUDdao<Learner> {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Learner learner) {

    }

    @Override
    public Learner get(int id) {
        return null;
    }

    @Override
    public List<Learner> getAll() {
        return null;
    }

    @Override
    public List<Learner> getAllForId(int id) {
        return null;
    }

    @Override
    public void update(Learner learner) {
    }


    @Override
    public void delete(Learner learner) {

    }
}
