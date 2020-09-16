package my.web.dao;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import web.model.Passport;
import web.model.Person;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCRepositorysd {

    @Autowired
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPerson() {
        final String QUERY_SQL = "SELECT * FROM person;";
        List<Person> personList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Person>() {
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setIdPerson(rs.getInt("id_person"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPatronymic(rs.getString("patronymic"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setIdPassport(rs.getInt("id_passport"));
                return person;
            }
        });
        return personList;
    }

    @Override
    public void addPerson(Person person) {
        final String INSERT_PERSON = "INSERT INTO person (name, surname, patronymic, age, email, id_passport) VALUES (?,?,?,?,?,?);";
        final String INSERT_PASSPORT = "INSERT INTO passport (series, number, issuingDepartment, dateIssue) VALUES (?,?,?,?)";
        Passport passport = person.getPassport();
        this.jdbcTemplate.update(INSERT_PASSPORT, passport.getSeries(), passport.getNumber(),
                passport.getIssuingDepartment(), Date.valueOf(passport.getDateIssue()));
        this.jdbcTemplate.update(INSERT_PERSON, person.getName(), person.getSurname(), person.getPatronymic(),
                person.getAge(), person.getEmail(), passport.getIdPassport());
    }

    @Override
    public Person getPerson(int code) {
        final String SELECT = "SELECT * FROM person WHERE id_person=?";
        Person person = this.jdbcTemplate.queryForObject(SELECT, new Object[]{code}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                return new Person(rs.getInt("id_person"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("patronymic"), rs.getInt("age"), rs.getString("email"),
                        rs.getInt("id_passport"));
            }
        });
        return person;
    }

    public Passport getPassport(Person person) {
        final String SELECT = "SELECT * FROM passport WHERE id_passport=?";
        Passport passport = this.jdbcTemplate.queryForObject(SELECT, new Object[]{person.getIdPassport()}, new RowMapper<Passport>() {
            @Override
            public Passport mapRow(ResultSet rs, int i) throws SQLException {
                return new Passport(rs.getInt("series"),
                        rs.getInt("number"), rs.getString("issuingDepartment"),
                        rs.getDate("dateIssue").toLocalDate());
            }
        });
        return passport;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }
}*/