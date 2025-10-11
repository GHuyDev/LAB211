package shortp109;

import java.time.LocalDate;

public class OfflineCourse extends Course {
    // begin, end, campus
    private LocalDate begin;
    private LocalDate end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = LocalDate.now();
        this.end = LocalDate.now();
        this.campus = "";
    }

    public LocalDate getBegin() { return begin; }
    public void setBegin(LocalDate begin) { this.begin = begin; }

    public LocalDate getEnd() { return end; }
    public void setEnd(LocalDate end) { this.end = end; }

    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }

    public String line() {
        return baseLine() + "-" + Validator.DATE_FMT.format(begin) + "-" +
               Validator.DATE_FMT.format(end) + "-" + campus;
    }
}
