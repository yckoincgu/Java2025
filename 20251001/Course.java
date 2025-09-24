import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String courseName;
    private String instructor;
    private int maxCapacity;
    private int credits;
    private List<Student> enrolledStudents;
    
    public Course(String courseCode, String courseName, String instructor, int maxCapacity, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }
    
    // Getters
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getCredits() { return credits; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getCurrentEnrollment() { return enrolledStudents.size(); }
    public boolean hasSeatsAvailable() { return enrolledStudents.size() < maxCapacity; }
    
    // Enroll a student in this course
    public boolean enrollStudent(Student student) {
        if (hasSeatsAvailable() && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }
    
    // Drop a student from this course
    public boolean dropStudent(Student student) {
        return enrolledStudents.remove(student);
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (Instructor: %s, Credits: %d, Enrollment: %d/%d)",
                courseCode, courseName, instructor, credits, getCurrentEnrollment(), maxCapacity);
    }
}