package coursewise.model;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private int creditsCompleted;
    private double cgpa;
    private String enrolledCourses; // Comma-separated course IDs
    private String avatarFilename; // Avatar image filename

    public Student() {
    }

    public Student(String studentId, String name, String email, String password, 
                   String phone, int creditsCompleted, double cgpa, String enrolledCourses) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.creditsCompleted = creditsCompleted;
        this.cgpa = cgpa;
        this.enrolledCourses = enrolledCourses;
        this.avatarFilename = "default-avatar.jpg";
    }

    public Student(String studentId, String name, String email, String password, 
                   String phone, int creditsCompleted, double cgpa, String enrolledCourses, String avatarFilename) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.creditsCompleted = creditsCompleted;
        this.cgpa = cgpa;
        this.enrolledCourses = enrolledCourses;
        this.avatarFilename = avatarFilename;
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

    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    public void setCreditsCompleted(int creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
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

    public String getAvatarFilename() {
        return avatarFilename;
    }

    public void setAvatarFilename(String avatarFilename) {
        this.avatarFilename = avatarFilename;
    }

    @Override
    public String toString() {
         return studentId + "|" + name + "|" + email + "|" + password + "|" + 
             phone + "|" + creditsCompleted + "|" + cgpa + "|" + enrolledCourses + "|" + avatarFilename;
    }
}
