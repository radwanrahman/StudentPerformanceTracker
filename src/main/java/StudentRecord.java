/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mahfuz
 */
public class StudentRecord {

    String subject;
    int mid, classTest, assignment, finalExam, attendance;

    public StudentRecord(String subject, int mid, int classTest, int assignment, int finalExam, int attendance) {
        this.subject = subject;
        this.mid = mid;
        this.classTest = classTest;
        this.assignment = assignment;
        this.finalExam = finalExam;
        this.attendance = attendance;
    }

    public int getTotalMarks() {
        return mid + classTest + assignment + finalExam + attendance;
    }
}
