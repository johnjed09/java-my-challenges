package ChallengesClasses;

public class Student implements Attendance {

    private String studentID;
    private String firstName;
    private String lastName;
    private String middleName;
    private Attendance.Status studentAttendanceStatus;

    public Student(String studentID, String firstName, String lastName, String middleName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getStudentID() {
        return this.studentID;
    }

    @Override
    public void setAttendance(Attendance.Status studentAttendanceStatus) {
        this.studentAttendanceStatus = studentAttendanceStatus;
    }

    @Override
    public Attendance.Status getAttendanceStatus() {
        return this.studentAttendanceStatus;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }
}
