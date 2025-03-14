/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mahfuz
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentPerformanceWindow {

    public StudentPerformanceWindow(List<StudentRecord> records) {
        JFrame frame = new JFrame("Student Performance");
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        if (records.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No records found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Finding Highest & Lowest Marks Subjects
        StudentRecord highest = records.get(0);
        StudentRecord lowest = records.get(0);
        double totalGPA = 0;

        for (StudentRecord record : records) {
            int totalMarks = record.getTotalMarks();
            totalGPA += calculateGPA(totalMarks);

            if (totalMarks > highest.getTotalMarks()) {
                highest = record;
            }
            if (totalMarks < lowest.getTotalMarks()) {
                lowest = record;
            }
        }

        double cgpa = totalGPA / records.size();

        // Generating Performance Tips
        String tip = generatePerformanceTip(cgpa);

        // Creating Performance Summary
        JTextArea feedbackArea = new JTextArea(
                "Highest Marks: " + highest.subject + " (" + highest.getTotalMarks() + ")\n"
                + "Lowest Marks: " + lowest.subject + " (" + lowest.getTotalMarks() + ")\n"
                + "Overall CGPA: " + String.format("%.2f", cgpa) + "\n"
                + "Performance Tip: " + tip
        );

        feedbackArea.setEditable(false);
        frame.add(new JScrollPane(feedbackArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public double calculateGPA(int marks) {
        if (marks >= 80) {
            return 4.0;
        }
        if (marks >= 75) {
            return 3.75;
        }
        if (marks >= 70) {
            return 3.5;
        }
        if (marks >= 65) {
            return 3.25;
        }
        if (marks >= 60) {
            return 3.0;
        }
        if (marks >= 55) {
            return 2.75;
        }
        if (marks >= 50) {
            return 2.5;
        }
        if (marks >= 45) {
            return 2.25;
        }
        if (marks >= 40) {
            return 2.0;
        }
        return 0.0;
    }

    public String generatePerformanceTip(double cgpa) {
        if (cgpa >= 3.75) {
            return "Excellent! Keep up the great work!";
        }
        if (cgpa >= 3.5) {
            return "Very Good! Stay focused and aim higher.";
        }
        if (cgpa >= 3.0) {
            return "Good! Some improvements can be made.";
        }
        if (cgpa >= 2.75) {
            return "Fair! Consider working harder.";
        }
        if (cgpa >= 2.5) {
            return "Needs Improvement! Focus on weaker subjects.";
        }
        return "Poor performance! You need serious effort to pass.";
    }
}
