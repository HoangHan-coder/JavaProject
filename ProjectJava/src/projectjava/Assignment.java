/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.time.LocalDateTime;
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
        this.status = status; // Nhận giá trị ban đầu
        this.day = day;
        this.time = time;

        // Chuyển đổi String thành LocalDateTime 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH-mm");
        this.deadline = LocalDateTime.parse(day + " " + time, formatter);
    }

    public ArrayList<Assignment> getListAssignment() {
        return listAssignment;
    }

    public void setListAssignment(ArrayList<Assignment> listAssignment) {
        this.listAssignment = listAssignment;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    // Kiểm tra deadline
    public int checkDeadline() {
        LocalDateTime now = LocalDateTime.now(); // Lấy thời gian hiện tại

        if (now.isAfter(deadline)) {
            // Nếu deadline đã qua
            if (status == 0) {
                status = -1; // Không hoàn tất vì quá hạn
                System.out.println("Deadline passed! Assignment not completed.");
            }
            if (status == 1) {
                System.out.println("The deadline has passed, but the assignment is completed.");
            }
        }

        if (now.isBefore(deadline)) {
            // Nếu deadline chưa đến
            if (status == 0) {
                System.out.println("Assignment in progress.");
            }
            if (status == 1) {
                System.out.println("Assignment is complete.");
            }
        }

        return status;
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
        } else if (status == -1) {
            statusText = "Not Done ";
        } else {
            statusText = "In Progress";
        }
        System.out.println("Assignment: " + assignmentName + " | Deadline: " + day + " " + time + " | Status: " + statusText);
    }

}
