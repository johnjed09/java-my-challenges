package ChallengesClasses;

public interface Attendance {

    enum Status {

        PRESENT, ABSENT,
    }

    public void setAttendance(Status studentStatus);

    public Attendance.Status getAttendanceStatus();
    
}
