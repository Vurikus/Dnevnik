package my.web.service;

import my.web.model.*;

import java.util.List;

public interface CRUDService {
    void addTeacher(Teacher teacher);
    Teacher getTeacher(int idTeacher);
    List<Teacher> getAllTeacher();

    void addSubject(Subject subject);
    void deleteSubject (String nameSubject);
    List<Subject> getAllSubject(int idTeacher);

    void addSchoolClass(SchoolClass schoolClass);
    SchoolClass getSchoolClass (int idClass);
    void deleteSchoolClass (SchoolClass schoolClass);
    void updateSchoolClass (SchoolClass schoolClass);
    List<SchoolClass> getAllSchoolClass();

    void addMark(Mark mark);
    List<Mark> getAllMark();

    void addLearner(Learner learner);
    List<Learner> getAllLearner();
    Learner getLearner (int idLearner);

}
