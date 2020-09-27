package my.web.dao;


import my.web.model.SchoolClass;
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
public class JDBCRepositorySchoolClass implements CRUDdao<SchoolClass> {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(SchoolClass schoolClass) {
        final String INSERT_SCHOOL_CLASS = "INSERT INTO class (classname) VALUES (?);";
        this.jdbcTemplate.update(INSERT_SCHOOL_CLASS, schoolClass.getNameClass());
    }

    @Override
    public SchoolClass get(int id) {
        final String SELECT_SQL = "SELECT * FROM class WHERE idClass = ?;";
        SchoolClass schoolClass = this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{id}, new RowMapper<SchoolClass>() {
            @Override
            public SchoolClass mapRow(ResultSet rs, int i) throws SQLException {
                return new SchoolClass(rs.getInt("idClass"), rs.getString("className"));
            }
        });
        return schoolClass;
    }

    @Override
    public List<SchoolClass> getAll() {
        final String QUERY_SQL = "SELECT * FROM class;";
        List<SchoolClass> classList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<SchoolClass>() {
            public SchoolClass mapRow(ResultSet rs, int rowNum) throws SQLException {
                SchoolClass schoolClass = new SchoolClass();
                schoolClass.setIdClass(rs.getInt("idClass"));
                schoolClass.setNameClass(rs.getString("className"));
                return schoolClass;
            }
        });
        return classList;
    }

    @Override
    public List<SchoolClass> getAllForId(int id) {
        return null;
    }

    @Override
    public void update(SchoolClass schoolClass) {
        final String UPDATE_SQL = "UPDATE class SET className = ? WHERE idClass = ?;";
        this.jdbcTemplate.update(UPDATE_SQL, schoolClass.getNameClass(), schoolClass.getIdClass());
    }

    @Override
    public void delete(SchoolClass schoolClass) {
        final String DELETE_SQL = "DELETE FROM class WHERE idClass = ?;";
        this.jdbcTemplate.update(DELETE_SQL, schoolClass.getIdClass());
    }
}
