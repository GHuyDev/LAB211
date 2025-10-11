package shortp109;

public class OnlineCourse extends Course {

    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String line() {
        return baseLine() + "-" + platform + "-" + instructors + "-" + note;
    }
}