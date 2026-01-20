package coursewise.service;

import coursewise.model.Student;
import coursewise.util.Constant;

import java.io.*;
import java.util.Scanner;

public class StudentService {

    public Student authenticateStudent(String studentId, String password) {
        try (Scanner scanner = new Scanner(new File(Constant.STUDENT_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    Student student = parseStudentFromLine(line);
                    if (student != null && student.getStudentId().equals(studentId) 
                        && student.getPassword().equals(password)) {
                        return student;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(String studentId) {
        try (Scanner scanner = new Scanner(new File(Constant.STUDENT_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    Student student = parseStudentFromLine(line);
                    if (student != null && student.getStudentId().equals(studentId)) {
                        return student;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student[] getAllStudents() {
        int count = 0;
        try (Scanner scanner = new Scanner(new File(Constant.STUDENT_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Student[] students = new Student[count];
        int index = 0;
        try (Scanner scanner = new Scanner(new File(Constant.STUDENT_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    Student student = parseStudentFromLine(line);
                    if (student != null) {
                        students[index] = student;
                        index++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean addStudent(Student student) {
        try (FileWriter writer = new FileWriter(Constant.STUDENT_FILE, true)) {
            writer.write(student.toString());
            writer.write("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        Student[] students = getAllStudents();
        try (FileWriter writer = new FileWriter(Constant.STUDENT_FILE)) {
            for (Student s : students) {
                if (s.getStudentId().equals(student.getStudentId())) {
                    writer.write(student.toString());
                } else {
                    writer.write(s.toString());
                }
                writer.write("\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String studentId) {
        Student[] students = getAllStudents();
        try (FileWriter writer = new FileWriter(Constant.STUDENT_FILE)) {
            for (Student s : students) {
                if (!s.getStudentId().equals(studentId)) {
                    writer.write(s.toString());
                    writer.write("\n");
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Student parseStudentFromLine(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length == 8) {
                return new Student(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    parts[4],
                    Integer.parseInt(parts[5]),
                    Double.parseDouble(parts[6]),
                    parts[7],
                    "default-avatar.jpg"
                );
            } else if (parts.length == 9) {
                return new Student(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    parts[4],
                    Integer.parseInt(parts[5]),
                    Double.parseDouble(parts[6]),
                    parts[7],
                    parts[8]
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
