package coursewise.model;

public class Enrollment {
    private String courseCode;
    private String studentId;
    private String day1;
    private String start1;
    private String end1;
    private String day2;
    private String start2;
    private String end2;
    private String section;
    private String status;
    private String semester;
    private double result;

    public Enrollment(String courseCode, String studentId, String day1, String start1, String end1,
                     String day2, String start2, String end2, String section, String status,
                     String semester, double result) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.day1 = day1;
        this.start1 = start1;
        this.end1 = end1;
        this.day2 = day2;
        this.start2 = start2;
        this.end2 = end2;
        this.section = section;
        this.status = status;
        this.semester = semester;
        this.result = result;
    }

    public String getCourseCode() { return courseCode; }
    public String getStudentId() { return studentId; }
    public String getDay1() { return day1; }
    public String getStart1() { return start1; }
    public String getEnd1() { return end1; }
    public String getDay2() { return day2; }
    public String getStart2() { return start2; }
    public String getEnd2() { return end2; }
    public String getSection() { return section; }
    public String getStatus() { return status; }
    public String getSemester() { return semester; }
    public double getResult() { return result; }

    public void setResult(double result) { this.result = result; }

    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + day1 + "|" + start1 + "|" + end1 + "|" + 
               day2 + "|" + start2 + "|" + end2 + "|" + section + "|" + status + "|" + semester + "|" + result;
    }
}
