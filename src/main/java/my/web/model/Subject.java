package my.web.model;

public class Subject {

    private int idSubject;
    private String nameSubject;
    private int idTeacher;

    public Subject() {
    }

    public Subject(String nameSubject, int idTeacher) {
        this.nameSubject = nameSubject;
        this.idTeacher = idTeacher;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }
}
