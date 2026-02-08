import java.util.Scanner;

class Student {
    int javaMarks;
    int mathsMarks;
    double average;
    String result;
    char grade;

    void calculateResult() {
        average = (javaMarks + mathsMarks) / 2.0;

        if (average >= 75) {
            grade = 'A';
            result = "Pass";
        } else if (average >= 60) {
            grade = 'B';
            result = "Pass";
        } else if (average >= 50) {
            grade = 'C';
            result = "Pass";
        } else if (average >= 40) {
            grade = 'D';
            result = "Pass";
        } else {
            grade = 'F';
            result = "Fail";
        }
    }

    void display(int index) {
        System.out.println("Student " + index +
                " | Java: " + javaMarks +
                " | Maths: " + mathsMarks +
                " | Avg: " + average +
                " | Grade: " + grade +
                " | Result: " + result);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[10];

        int totalJava = 0, totalMaths = 0;
        double totalAvg = 0;

        for (int i = 0; i < 10; i++) {
            students[i] = new Student();

            System.out.println("\nEnter marks for Student " + (i + 1));
            System.out.print("Java: ");
            students[i].javaMarks = sc.nextInt();

            System.out.print("Maths: ");
            students[i].mathsMarks = sc.nextInt();

            students[i].calculateResult();

            totalJava += students[i].javaMarks;
            totalMaths += students[i].mathsMarks;
            totalAvg += students[i].average;
        }

        System.out.println("\n----- Student Details -----");
        for (int i = 0; i < 10; i++) {
            students[i].display(i + 1);
        }

        System.out.println("\n----- Overall Averages -----");
        System.out.println("Average Java Marks: " + (totalJava / 10.0));
        System.out.println("Average Maths Marks: " + (totalMaths / 10.0));
        System.out.println("Average Total Marks of Students: " + (totalAvg / 10.0));

        sc.close();
    }
}

