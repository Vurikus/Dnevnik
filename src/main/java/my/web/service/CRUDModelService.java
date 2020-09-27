package my.web.service;

import my.web.dao.CRUDdao;
import my.web.dao.JDBCRepositorySubject;
import my.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CRUDModelService implements CRUDService {

    @Autowired
    private CRUDdao<SchoolClass> daoSchoolClass;
    @Autowired
    private CRUDdao<Teacher> daoTeacher;
    @Autowired
    private CRUDdao<Mark> daoMark;
    @Autowired
    private CRUDdao<Learner> daoLearner;
    @Autowired
    private CRUDdao<Subject> daoSubject;

    //TEACHER
    @Override
    public void addTeacher(Teacher teacher) {
        daoTeacher.add(teacher);
    }
    @Override
    public List<Teacher> getAllTeacher() {
        return daoTeacher.getAll();
    }
    @Override
    public Teacher getTeacher(int idTeacher) {
        return daoTeacher.get(idTeacher);
    }

    //SUBJECT
    @Override
    public void addSubject(Subject subject) {
        daoSubject.add(subject);
    }
    @Override
    public void deleteSubject(String nameSubject) {

    }
    @Override
    public List<Subject> getAllSubject(int idTeacher) {
        return daoSubject.getAllForId(idTeacher);
    }


    //SCHOOL_CLASS
    @Override
    public void addSchoolClass(SchoolClass schoolClass) {
        daoSchoolClass.add(schoolClass);
    }
    @Override
    public SchoolClass getSchoolClass(int idClass) {
        return daoSchoolClass.get(idClass);
    }
    @Override
    public void updateSchoolClass(SchoolClass schoolClass) {
        daoSchoolClass.update(schoolClass);
    }
    @Override
    public void deleteSchoolClass(SchoolClass schoolClass) {
        daoSchoolClass.delete(schoolClass);
    }
    @Override
    public List<SchoolClass> getAllSchoolClass() {
        return daoSchoolClass.getAll();
    }


    //MARKS
    @Override
    public void addMark(Mark mark) {
        daoMark.add(mark);
    }
    @Override
    public List<Mark> getAllMark() {
        return daoMark.getAll();
    }


    //LEARNER
    @Override
    public void addLearner(Learner learner) {
        daoLearner.add(learner);
    }
    @Override
    public List<Learner> getAllLearner() {
        return daoLearner.getAll();
    }
    @Override
    public Learner getLearner(int idLearner) {
        return null;
    }
}
