package my.web.model;

public class SchoolClass {

    private int idClass;
    private String nameClass;

    public SchoolClass() {
    }

    public SchoolClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
