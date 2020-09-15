package my.web.model;

public class Teacher {

    private int idTeacher;
    private String nameTeacher;

    public Teacher() {
    }

    public Teacher(int idTeacher, String nameTeacher) {
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
}
