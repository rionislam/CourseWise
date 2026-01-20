package coursewise.service;

import coursewise.model.Course;
import coursewise.model.Enrollment;
import coursewise.util.Constant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EnrollmentService {

    public boolean addEnrollment(String studentId, Course course) {
        try (FileWriter w = new FileWriter(Constant.ENROLLMENT_FILE, true)) {
            Enrollment e = new Enrollment(course.getCode(), studentId, course.getDay1(), 
                    course.getStart1(), course.getEnd1(), course.getDay2(), 
                    course.getStart2(), course.getEnd2(), course.getSection(), 
                    course.getStatus(), course.getSemester(), -1);
            w.write(e.toString() + "\n");
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String[] getEnrolledCourses(String studentId) {
        String[] courses = new String[100];
        int count = 0;
        try (Scanner sc = new Scanner(new File(Constant.ENROLLMENT_FILE))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length >= 12 && p[1].equals(studentId)) {
                    courses[count++] = p[0].trim() + "-" + p[8].trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] out = new String[count];
        System.arraycopy(courses, 0, out, 0, count);
        return out;
    }
}
