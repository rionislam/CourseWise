package coursewise.service;

import coursewise.model.Course;
import coursewise.util.Constant;

import java.io.File;
import java.util.Scanner;

public class CourseService {

    public Course[] getAllCourses() {
        File f = new File(Constant.COURSE_FILE);
        try (Scanner sc = new Scanner(f)) {
            // first pass - count valid lines
            int count = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length >= 13) count++;
            }
            Course[] arr = new Course[count];
            // second pass - read into array
            try (Scanner sc2 = new Scanner(f)) {
                int idx = 0;
                while (sc2.hasNextLine()) {
                    String line = sc2.nextLine().trim();
                    if (line.isEmpty()) continue;
                    String[] p = line.split("\\|");
                    if (p.length >= 13) {
                        try {
                            String code = p[0].trim();
                            String name = p[1].trim();
                            String day1 = p[2].trim();
                            String start1 = p[3].trim();
                            String end1 = p[4].trim();
                            String day2 = p[5].trim();
                            String start2 = p[6].trim();
                            String end2 = p[7].trim();
                            String section = p[8].trim();
                            int capacity = Integer.parseInt(p[9].trim());
                            int enrolled = Integer.parseInt(p[10].trim());
                            String status = p[11].trim();
                            String semester = p[12].trim();
                            
                            Course c = new Course(code, name, day1, start1, end1, day2, start2, end2, section, capacity, enrolled, status, semester);
                            arr[idx++] = c;
                        } catch (Exception e) {
                            System.err.println("Error parsing course line: " + line + " - " + e.getMessage());
                        }
                    }
                }
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Course[0];
    }

    public Course[] search(String query) {
        String q = query == null ? "" : query.trim().toLowerCase();
        Course[] all = getAllCourses();
        if (q.isEmpty()) return all;
        // collect matches in a temporary array sized to all.length
        Course[] temp = new Course[all.length];
        int idx = 0;
        for (Course c : all) {
            if (c != null && (c.getCode().toLowerCase().contains(q) || c.getName().toLowerCase().contains(q))) {
                temp[idx++] = c;
            }
        }
        Course[] out = new Course[idx];
        System.arraycopy(temp, 0, out, 0, idx);
        return out;
    }
}
