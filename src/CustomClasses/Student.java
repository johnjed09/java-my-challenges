package CustomClasses;

public class Student {

    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public void println() {
        System.out.printf("%s\t%f\n", this.name, this.gpa);
    }

    public String getName() {
        return this.name;
    }

    public double getGpa() {
        return this.gpa;
    }
}
