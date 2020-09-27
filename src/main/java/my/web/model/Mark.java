package my.web.model;

import java.time.LocalDate;

public class Mark {

    private int idMark;
    private LocalDate dateMark;
    private int mark;
    private int idSubject;
    private int idLearner;

    public Mark() {
    }

    public Mark(int idMark, LocalDate dateMark, int mark, int idSubject, int idLearner) {
        this.idMark = idMark;
        this.dateMark = dateMark;
        this.mark = mark;
        this.idSubject = idSubject;
        this.idLearner = idLearner;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public LocalDate getDateMark() {
        return dateMark;
    }

    public void setDateMark(LocalDate dateMark) {
        this.dateMark = dateMark;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdLearner() {
        return idLearner;
    }

    public void setIdLearner(int idLearner) {
        this.idLearner = idLearner;
    }
}
