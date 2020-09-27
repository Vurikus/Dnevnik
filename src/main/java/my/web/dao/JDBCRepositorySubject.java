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
        final String INSERT_SUBJECT = "INSERT INTO subject (subjectName, idTeacher, idclass) VALUES (?, ?, ?);";
        this.jdbcTemplate.update(INSERT_SUBJECT, subject.getNameSubject(), subject.getIdTeacher(), subject.getIdClass());
    }

    @Override
    public Subject get(int id) {
        final String SELECT_SQL = "SELECT * FROM subject WHERE idSubject = ?;";
        Subject subject = this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{id}, new RowMapper<Subject>() {
            @Override
            public Subject mapRow(ResultSet rs, int i) throws SQLException {
                Subject s = new Subject();
                s.setIdSubject(rs.getInt("idSubject"));
                s.setNameSubject(rs.getString("subjectName"));
                s.setIdClass(rs.getInt("idClass"));
                s.setIdTeacher(rs.getInt("idTeacher"));
                return s;
            }
        });
        return subject;
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
                subject.setIdSubject(rs.getInt("idSubject"));
                subject.setNameSubject(rs.getString("subjectName"));
                subject.setIdTeacher(rs.getInt("idTeacher"));
                subject.setIdClass(rs.getInt("idClass"));
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
        final String DELETE_SQL = "DELETE FROM subject WHERE idSubject = ?;";
        this.jdbcTemplate.update(DELETE_SQL, subject.getIdSubject());
    }
}
