package my.web.service;

import my.web.dao.CRUDdao;
import my.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CRUDModelService implements CRUDService {

    @Autowired
    private CRUDdao<SchoolClass> serviceSchoolClass;

    @Override
    public void addTeacher(Teacher teacher) {

    }

    @Override
    public void addSubject(Subject subject) {

    }

    @Override
    public void addSchoolClass(SchoolClass schoolClass) {
        serviceSchoolClass.add(schoolClass);
    }

    @Override
    public void addMark(Mark mark) {

    }

    @Override
    public void addLearner(Learner learner) {

    }

    @Override
    public List<Teacher> getAllTeacher() {
        return null;
    }

    @Override
    public List<Subject> getAllSubject() {
        return null;
    }

    @Override
    public List<SchoolClass> getAllSchoolClass() {
        return serviceSchoolClass.getAll();
    }

    @Override
    public List<Mark> getAllMark() {
        return null;
    }

    @Override
    public List<Learner> getAllLearner() {
        return null;
    }
}
