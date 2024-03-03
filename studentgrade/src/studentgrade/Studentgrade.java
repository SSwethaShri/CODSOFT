/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgrade;

/**
 *
 * @author sswet
 */
import java.util.Scanner;

public class Studentgrade{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        boolean pass = true;
        double totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            double marks = scanner.nextDouble();
            if (marks < 35) {
                pass = false;
                System.out.println("Failed in subject " + i);
            }
            totalMarks += marks;
        }

        double averagePercentage = (totalMarks / (numSubjects * 100)) * 100;
        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        if (pass) {
            System.out.println("Congratulations! You have passed.");
        } else {
            System.out.println("Sorry, you have failed.");
        }

        scanner.close();
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
