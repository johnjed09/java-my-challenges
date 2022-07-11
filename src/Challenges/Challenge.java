package Challenges;

import ChallengesClasses.Addition;
import ChallengesClasses.Attendance;
import ChallengesClasses.Attendance.Status;
import ChallengesClasses.ClassRecord;
import ChallengesClasses.ProjectConfig;
import ChallengesClasses.Division;
import ChallengesClasses.MathOperations;
import ChallengesClasses.Multiplication;
import ChallengesClasses.MyMultithreading;
import ChallengesClasses.Rank;
import ChallengesClasses.Student;
import ChallengesClasses.Subtraction;
import ChallengesClasses.Task;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {

    public static void challenge01() {
        System.out.printf("Challenge 01\n");

        Scanner scanner = new Scanner(System.in);
        ArrayList<MathOperations> operations = new ArrayList<>();
        int firstNumber, secondNumber = 0;

        // INPUTS
        System.out.println("ADDITION");
        System.out.println("Input first number: ");
        firstNumber = scanner.nextInt();
        System.out.println("Input second number: ");
        secondNumber = scanner.nextInt();
        operations.add(new Addition(firstNumber, secondNumber));

        System.out.println("SUBTRACTION");
        System.out.println("Input first number: ");
        firstNumber = scanner.nextInt();
        System.out.println("Input second number: ");
        secondNumber = scanner.nextInt();
        operations.add(new Subtraction(firstNumber, secondNumber));;

        System.out.println("MULTIPLICATION");
        System.out.println("Input first number: ");
        firstNumber = scanner.nextInt();
        System.out.println("Input second number: ");
        secondNumber = scanner.nextInt();
        operations.add(new Multiplication(firstNumber, secondNumber));

        System.out.println("DIVISION");
        System.out.println("Input first number: ");
        firstNumber = scanner.nextInt();
        System.out.println("Input second number: ");
        secondNumber = scanner.nextInt();
        operations.add(new Division(firstNumber, secondNumber));

        // OUTPUT
        String textToFile = "";
        for (MathOperations operation : operations) {
            textToFile += operation.printAnswer();
        }

        createFile(textToFile);
        readFile();
    }

    /**
     * ToDo Priority Ranking -Accepts and randomly prioritize your tasks for the
     * day.
     */
    public static void challenge02() {
        ArrayList<Task> todos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("List your ToDo's for the day!!! :)");
        System.out.println("Total tasks: ");
        int numberTasks = input.nextInt();
        for (int i = 0; i < numberTasks; i++) {
            input = new Scanner(System.in);

            System.out.printf("Task %d: ", i + 1);
            String task = input.nextLine();

            todos.add(new Task(task));
        }

        Rank<Task> ranker = new Rank<Task>(todos);
        ArrayList<String> rankedTodoArray = new ArrayList<>();
        for (Task rankedTodo : ranker.rankedTodos) {
            rankedTodoArray.add(rankedTodo.getName());
        }

        try {
            FileWriter file = new FileWriter("C:\\Users\\john.jedidiah.getes\\Documents\\NetBeansProjects\\Hello World\\results\\Challenge02.txt");
            BufferedWriter buffer = new BufferedWriter(file);

            System.out.println("File created.");

            for (String todo : rankedTodoArray) {
                buffer.write(todo);
                buffer.newLine();
            }

            buffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader file = new FileReader("C:\\Users\\john.jedidiah.getes\\Documents\\NetBeansProjects\\Hello World\\results\\Challenge02.txt");
            BufferedReader buffer = new BufferedReader(file);

            System.out.println("From File.");
            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);

            }
            buffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("Ranked Todos %s \n", rankedTodoArray.toString());
    }

    /**
     * 6/9/2022 Teacher Personal Assistant App -Class Record -Lesson Plan -Note
     * taker
     */
    public static void challenge03() {
        System.out.println("Teacher Personal Assitant(TPA)");
        int option = 0;

        System.out.println("Start your day!");

        // Options
        System.out.println("1. Work on your class record.");
        System.out.println("2. Prepare your lesson plans.");
        System.out.println("3. Note your idea.");
        Scanner scannerOption = new Scanner(System.in);
        option = scannerOption.nextInt();

        // IF/Else
        switch (option) {
            case 1:
                System.out.println("My Class Record");
                ClassRecord classRecord = new ClassRecord();

//                classRecord.addStudent("0001", "John Jedidiah", "Getes", "Gador");
//                classRecord.addStudent("0002", "John Jedidiah", "Getes", "Gador");
//                classRecord.addStudent("0003", "John Jedidiah", "Getes", "Gador");
//
//                classRecord.setAttendance("0001", Status.PRESENT);
//                classRecord.setAttendance("0002", Status.ABSENT);
//                classRecord.setAttendance("0003", Status.PRESENT);
//                classRecord.saveToFile();
//                classRecord.readFromFile();
//                System.out.printf("Student %s is %s.\n", classRecord.getStudent().getStudentID(), classRecord.getAttendance("0001"));
                for (Map.Entry m : classRecord.getAllStudentsAttendance().entrySet()) {
                    System.out.println(m);
                }
                break;
            case 2:
                System.out.println("Lesson Plans");
                break;
            case 3:
                System.out.println("Notes");
                break;
        }

    }

    /**
     * 6/20/2022
     *
     * @param textToFile
     */
    public static void challenge04() {
        MyMultithreading gwapoKauKo = new MyMultithreading(2);
        MyMultithreading gwapoKauKo2 = new MyMultithreading(2);

        gwapoKauKo.start();
        gwapoKauKo2.start();
    }

    public static void challenge05() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Valid Email: ");
        String input = scanner.nextLine();

//        Pattern p = Pattern.compile(".s");
//        Matcher m = p.matcher(input);
//        boolean output = m.matches();
        boolean output = Pattern.matches(".s", input);

        System.out.printf("Input %s \n", output);

        try {
            FileWriter file = new FileWriter(ProjectConfig.CHALLENGE_URI + "\\Challenge05.txt");
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(input);
            buffer.write(output ? "true" : "false");

            System.out.println("Saved Successfully!");
            buffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createFile(String textToFile) {
        try {
            FileWriter file = new FileWriter(ProjectConfig.FILE_URI);

            System.out.println("Created file.");
            file.write(textToFile);

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            File file = new File(ProjectConfig.FILE_URI);
            Scanner scanner = new Scanner(file);

            System.out.println("From the file.");
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                System.out.printf("%s\n", (String) data);
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
