package my.web.dao;

import my.web.model.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        final String QUERY_SQL = "SELECT * FROM learner;";
        List<Learner> learnerList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Learner>() {
            public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
                Learner learner = new Learner();
                learner.setIdClass(rs.getInt("idLearner"));
                learner.setNameLearner(rs.getString("name"));
                learner.setIdClass(rs.getInt("idClass"));
                return learner;
            }
        });
        return learnerList;
    }

    @Override
    public void update(Learner learner) {
    }


    @Override
    public void delete(Learner learner) {

    }
}
