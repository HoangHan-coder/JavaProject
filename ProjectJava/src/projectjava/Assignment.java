/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi Kim Ngan - CE190411
 */
public class Assignment {

    private ArrayList<Assignment> listAssignment = new ArrayList<>();
    private String assignmentName;
    private int status;
    private String day;
    private String time;
    private LocalDateTime deadline;  // Thời gian bài tập dưới dạng LocalDateTime

    public Assignment() {
    }

    public Assignment(String assignmentName, int status, String day, String time) {
        this.assignmentName = assignmentName;
        this.status = status;
        this.day = day;
        this.time = time;
        // Chuyển đổi String thành LocalDateTime 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH-mm");
        this.deadline = LocalDateTime.parse(day + " " + time, formatter);
    }

    // Phương thức kiểm tra deadline (trả về 1 nếu đã hoàn thành, 0 nếu chưa)
    public int checkDeadline() {
        if (status == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    // Thêm bài tập vào danh sách
    public void addAssignment(Assignment assignment) {
        listAssignment.add(assignment);
    }

    // Cập nhật bài tập dựa trên chỉ mục
    public void updateAssignment(int index, Assignment newAssignment) {
        if (index >= 0 && index < listAssignment.size()) {
            listAssignment.set(index, newAssignment);
        }
    }

    // Phương thức xóa bài tập dựa trên chỉ mục
    public void removeAssignment(int index) {
        if (index >= 0 && index < listAssignment.size()) {
            listAssignment.remove(index);
        }
    }

    // Phương thức in thông tin bài tập
    public void printInfo() {
        String statusText;
        if (status == 1) {
            statusText = "Done";
        } else {
            statusText = "Not Done";
        }
        System.out.println("Assignment: " + assignmentName + " | Deadline: " + day + " " + time + " | Status: " + statusText);
    }

}
