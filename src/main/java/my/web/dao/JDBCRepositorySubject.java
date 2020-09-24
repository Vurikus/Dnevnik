package my.web.dao;

import my.web.model.Subject;
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
public class JDBCRepositorySubject implements CRUDdao<Subject> {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Subject subject) {
        final String INSERT_SUBJECT = "INSERT INTO subject (subjectName, idTeacher) VALUES (?, ?);";
        this.jdbcTemplate.update(INSERT_SUBJECT, subject.getNameSubject(), subject.getIdTeacher());
    }

    @Override
    public Subject get(int id) {
        return null;
    }

    @Override
    public List<Subject> getAll() {
        return null;
    }

    @Override
    public List<Subject> getAllForId(int idTeacher) {
        final String QUERY_SQL = "SELECT * FROM subject;";
        List<Subject> subjectList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Subject>() {
            public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
                Subject subject = new Subject();
                subject.setNameSubject(rs.getString("subjectName"));
                subject.setIdTeacher(rs.getInt("idTeacher"));
                return subject;
            }
        });
        return subjectList;
    }

    @Override
    public void update(Subject subject) {

    }

    @Override
    public void delete(Subject subject) {

    }
}
