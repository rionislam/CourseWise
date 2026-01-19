package coursewise.model;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String semester;
    private double cgpa;
    private String enrolledCourses; // Comma-separated course IDs

    public Student() {
    }

    public Student(String studentId, String name, String email, String password, 
                   String phone, String semester, double cgpa, String enrolledCourses) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.semester = semester;
        this.cgpa = cgpa;
        this.enrolledCourses = enrolledCourses;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(String enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return studentId + "|" + name + "|" + email + "|" + password + "|" + 
               phone + "|" + semester + "|" + cgpa + "|" + enrolledCourses;
    }
}
