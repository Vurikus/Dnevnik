package my.web.model;

public class Subject {

    private int idSubject;
    private String nameSubject;
    private int idTeacher;
    private int idClass;

    public Subject() {
    }

    public Subject(String nameSubject, int idTeacher, int idClass) {
        this.nameSubject = nameSubject;
        this.idTeacher = idTeacher;
        this.idClass = idClass;
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

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", nameSubject='" + nameSubject + '\'' +
                ", idTeacher=" + idTeacher +
                ", idClass=" + idClass +
                '}';
    }
}

