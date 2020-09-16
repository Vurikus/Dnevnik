package my.web.service;

import my.web.model.*;

import java.util.List;

public interface CRUDService {
    void addTeacher(Teacher teacher);
    void addSubject(Subject subject);
    void addSchoolClass(SchoolClass schoolClass);
    void addMark(Mark mark);
    void addLearner(Learner learner);
    List<Teacher> getAllTeacher();
    List<Subject> getAllSubject();
    List<SchoolClass> getAllSchoolClass();
    List<Mark> getAllMark();
    List<Learner> getAllLearner();

}
