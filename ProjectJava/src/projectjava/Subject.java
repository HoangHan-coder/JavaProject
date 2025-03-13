/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Nguyen Hoang Han - CE192048
 */
public class Subject {
    private String subjectName;
    private String subjectCode;
    private String subjectId;
    private int assignment;
    
    private static ArrayList<Subject> listSubject = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subjectName, String subjectCode, String subjectId, int assignment) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.subjectId = subjectId;
        this.assignment = assignment;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getAssignment() {
        return assignment;
    }

    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    

// methods
    

   public static void addSubject(Subject subject) {
       listSubject.add(subject);
   }
   
   public static void removeSubject(String subjectId) {
       listSubject.removeIf(subject -> subject.getSubjectId().equals(subjectId));
   }
   
   public static void updateSubject(String subjectId, String newName, String newCode, int newAssignment ) {
       for ( Subject subject : listSubject) {
           if (subject.getSubjectId().equals(subjectId) ) {
               subject.setSubjectName(newName);
               subject.setSubjectCode(newCode);
               subject.setAssignment(newAssignment);
               break;
           }
       }
   }
    
   public static Subject searchSubject(String subjectId) {
       for ( Subject subject : listSubject) {
           if(subject.getSubjectId().equals(subjectId)) {
               return subject;
           }
       }
              
       return null;
   }
   
   public String printInfo() {
       
   }
}
