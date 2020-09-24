package my.web.dao;


import my.web.model.Teacher;
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
        final String INSERT_TEACHER = "INSERT INTO teacher (nameTeacher) VALUES (?);";
        this.jdbcTemplate.update(INSERT_TEACHER, teacher.getNameTeacher());
    }

    @Override
    public Teacher get(int id) {
        final String SELECT = "SELECT * FROM teacher WHERE idTeacher=?";
        Teacher teacher = this.jdbcTemplate.queryForObject(SELECT, new Object[]{id}, new RowMapper<Teacher>() {
            @Override
            public Teacher mapRow(ResultSet rs, int i) throws SQLException {
                return new Teacher(rs.getInt("idTeacher"), rs.getString("nameTeacher"));
            }
        });
        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        final String QUERY_SQL = "SELECT * FROM teacher;";
        List<Teacher> teachersList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Teacher>() {
            public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setIdTeacher(rs.getInt("idTeacher"));
                teacher.setNameTeacher(rs.getString("nameTeacher"));
                return teacher;
            }
        });
        return teachersList;
    }

    @Override
    public List<Teacher> getAllForId(int id) {
        return null;
    }

    @Override
    public void update(Teacher teacher) {
        final String UPDATE_SQL = "UPDATE teacher SET nameTeacher = ? WHERE idteacher = ?;";
        this.jdbcTemplate.update(UPDATE_SQL, teacher.getNameTeacher(), teacher.getIdTeacher());
    }

    @Override
    public void delete(Teacher teacher) {
        final String DELETE_SQL = "DELETE FROM teacher WHERE idteacher = ?;";
        this.jdbcTemplate.update(DELETE_SQL, teacher.getIdTeacher());
    }
}
