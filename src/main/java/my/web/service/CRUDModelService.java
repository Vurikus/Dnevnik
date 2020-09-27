package my.web.service;

import my.web.dao.CRUDdao;
import my.web.dao.JDBCRepositorySubject;
import my.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Subject getSubject(int idSubject) {
        return daoSubject.get(idSubject);
    }
    @Override
    public void deleteSubject(int idSubject) {
        Subject s = new Subject();
        s.setIdSubject(idSubject);
        daoSubject.delete(s);
    }
    @Override
    public List<Subject> getAllSubject(int idTeacher, int idClass) {
        List<Subject> listSubjectSomeTeacher = daoSubject.getAllForId(idTeacher);
        List<Subject> listSubjectSomeTeacherSomeClass = new ArrayList<>();
        for(Subject subject:listSubjectSomeTeacher){
            if(subject.getIdClass()==idClass) listSubjectSomeTeacherSomeClass.add(subject);
        }
        return listSubjectSomeTeacherSomeClass;
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
    public List<Learner> getAllLearner(int idClass) {
        return daoLearner.getAllForId(idClass);
    }
    @Override
    public Learner getLearner(int idLearner) {
        return null;
    }
}
