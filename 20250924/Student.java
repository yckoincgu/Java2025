import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private int year;
    private List<Course> enrolledCourses;
    
    public Student(String studentId, String name, String email, int year) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.year = year;
        this.enrolledCourses = new ArrayList<>();
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getYear() { return year; }
    public List<Course> getEnrolledCourses() { return enrolledCourses; }
    
    // Enroll in a course
    public boolean enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            boolean success = course.enrollStudent(this);
            if (success) {
                enrolledCourses.add(course);
            }
            return success;
        }
        return false; // Already enrolled
    }
    
    // Drop a course
    public boolean dropCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            boolean success = course.dropStudent(this);
            if (success) {
                enrolledCourses.remove(course);
            }
            return success;
        }
        return false; // Not enrolled
    }
    
    // Get total credits
    public int getTotalCredits() {
        return enrolledCourses.stream().mapToInt(Course::getCredits).sum();
    }
    
    // Display student's course schedule
    public void displaySchedule() {
        System.out.println("\n=== Schedule for " + name + " (" + studentId + ") ===");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            enrolledCourses.forEach(course -> 
                System.out.println("• " + course.getCourseCode() + " - " + 
                                 course.getCourseName() + " (" + course.getCredits() + " credits)"));
            System.out.println("Total credits: " + getTotalCredits());
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (Year: %d, Email: %s, Courses: %d)",
                studentId, name, year, email, enrolledCourses.size());
    }
}