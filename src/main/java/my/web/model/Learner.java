package my.web.model;

public class Learner {

    private int idLearner;
    private String nameLearner;
    private int idClass;

    public Learner() {
    }

    public Learner(int idLearner, String nameLearner, int idClass) {
        this.idLearner = idLearner;
        this.nameLearner = nameLearner;
        this.idClass = idClass;
    }

    public int getIdLearner() {
        return idLearner;
    }

    public void setIdLearner(int idLearner) {
        this.idLearner = idLearner;
    }

    public String getNameLearner() {
        return nameLearner;
    }

    public void setNameLearner(String nameLearner) {
        this.nameLearner = nameLearner;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }
}
