package ChallengesClasses;

public class Task {

    private String name;
    private int rank;

    public Task(String name) {
        this.name = name;
    }
    
    public Task(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
    
    public String getName() {
        return this.name;
    }
 }
