package CustomComparators;

import CustomClasses.Student;
import java.util.Comparator;

public class StudentGpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        double gpa1 = s1.getGpa();
        double gpa2 = s2.getGpa();

        gpa1 *= 1000;
        gpa2 *= 1000;

        return (int) -(gpa1 - gpa2);

    }
}
