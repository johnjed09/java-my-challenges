package ChallengesClasses;

import ChallengesClasses.Attendance.Status;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRecord {

    private static String schoolName;
    private static String schoolID;
    private static int schoolYear;
    private static int region;
    private Student student;
    private ArrayList<Student> students = new ArrayList<>();

    public ClassRecord(String schoolName, String shoolID, int schoolYear, int region) {
        this.schoolName = schoolName;
        this.schoolID = shoolID;
        this.schoolYear = schoolYear;
        this.region = region;
    }

    public ClassRecord(String schoolName) {
        this.schoolName = schoolName;
    }

    public ClassRecord() {
    }

    public void addStudent(String studentID, String firstName, String lastName, String middleName) {
        this.student = new Student(studentID, firstName, lastName, middleName);

        this.students.add(student);
    }

    public Student getStudent() {
        return this.student;
    }

    public ArrayList<Student> getAllStudents() {
        return this.students;
    }

    /**
     *
     * @return Map
     */
    public Map<String, Status> getAllStudentsAttendance() {
        Map<String, Status> mapStudentAttendance = new HashMap<String, Status>();

        this.students.forEach(student -> {
            mapStudentAttendance.put(student.getStudentID(), student.getAttendanceStatus());
        });

        return mapStudentAttendance;
    }

    public Student getStudent(String lastName, String firstName) {

        return this.student;
    }

    public void setAttendance(String studentID, Attendance.Status attendance) {
        for (Student student : this.students) {
            if (student.getStudentID() == studentID) {
                student.setAttendance(attendance);
            }
        }
    }

    public Attendance.Status getAttendance(String studentID) {

        for (Student student : this.students) {
            if (student.getStudentID() == studentID) {
                return student.getAttendanceStatus();
            }
        }

        return null;

    }

    public void saveToFile() {
        try {

            FileWriter file = new FileWriter("C:\\Users\\john.jedidiah.getes\\Documents\\NetBeansProjects\\Hello World\\results\\Challenge03.txt");
            BufferedWriter buffer = new BufferedWriter(file);

            for (Student student : this.students) {
                String studentDetails = String.format("%s||%s||%s||%s||%s\n", student.getStudentID(), student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getAttendanceStatus());

                buffer.write(studentDetails);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            FileReader file = new FileReader("C:\\Users\\john.jedidiah.getes\\Documents\\NetBeansProjects\\Hello World\\results\\Challenge03.txt");
            BufferedReader buffer = new BufferedReader(file);
            String line = "";

            while ((line = buffer.readLine()) != null) {
                String[] lineDetails = line.split("\\|\\|");

                addStudent(lineDetails[0], lineDetails[1], lineDetails[2], lineDetails[3]);
                setAttendance(lineDetails[0], Status.valueOf(lineDetails[4]));
            }

            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
