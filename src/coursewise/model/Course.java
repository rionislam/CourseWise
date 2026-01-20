package coursewise.model;

public class Course {
    private String code;
    private String name;
    private String day1;
    private String start1;
    private String end1;
    private String day2;
    private String start2;
    private String end2;
    private String section;
    private int capacity;
    private int count;
    private String status;
    private String semester;

    public Course(String code, String name, String day1, String start1, String end1,
                  String day2, String start2, String end2, String section, int capacity,
                  int count, String status, String semester) {
        this.code = code;
        this.name = name;
        this.day1 = day1;
        this.start1 = start1;
        this.end1 = end1;
        this.day2 = day2;
        this.start2 = start2;
        this.end2 = end2;
        this.section = section;
        this.capacity = capacity;
        this.count = count;
        this.status = status;
        this.semester = semester;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDay1() { return day1; }
    public String getStart1() { return start1; }
    public String getEnd1() { return end1; }
    public String getDay2() { return day2; }
    public String getStart2() { return start2; }
    public String getEnd2() { return end2; }
    public String getSection() { return section; }
    public int getCapacity() { return capacity; }
    public int getCount() { return count; }
    public String getStatus() { return status; }
    public String getSemester() { return semester; }

    @Override
    public String toString() {
        return code + "-" + section + " | " + name + " | " + day1 + " " + start1 + "-" + end1 + (day2.isEmpty()?"":"; " + day2 + " " + start2 + "-" + end2) + " | Sem: " + semester;
    }
}
