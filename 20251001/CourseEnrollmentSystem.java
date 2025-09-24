import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseEnrollmentSystem {
    private List<Student> students;
    private List<Course> courses;
    private Scanner scanner;
    
    public CourseEnrollmentSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeData();
    }
    
    // Initialize with sample data
    private void initializeData() {
        // Create sample courses
        courses.add(new Course("CS101", "Introduction to Programming", "Dr. Smith", 30, 3));
        courses.add(new Course("MATH201", "Calculus I", "Dr. Johnson", 25, 4));
        courses.add(new Course("PHY301", "Physics Fundamentals", "Dr. Brown", 20, 4));
        courses.add(new Course("ENG101", "English Composition", "Dr. Davis", 35, 3));
        courses.add(new Course("CHEM201", "General Chemistry", "Dr. Wilson", 15, 4));
        
        // Create sample students
        students.add(new Student("S001", "Alice Johnson", "alice@university.edu", 1));
        students.add(new Student("S002", "Bob Smith", "bob@university.edu", 2));
        students.add(new Student("S003", "Carol Davis", "carol@university.edu", 1));
    }
    
    // Main menu
    public void displayMenu() {
        while (true) {
            System.out.println("\n=== COURSE ENROLLMENT SYSTEM ===");
            System.out.println("1. Display All Courses");
            System.out.println("2. Display All Students");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Drop Student from Course");
            System.out.println("5. View Student Schedule");
            System.out.println("6. View Course Enrollment");
            System.out.println("7. Add New Student");
            System.out.println("8. Add New Course");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1 -> displayAllCourses();
                case 2 -> displayAllStudents();
                case 3 -> enrollStudent();
                case 4 -> dropStudent();
                case 5 -> viewStudentSchedule();
                case 6 -> viewCourseEnrollment();
                case 7 -> addNewStudent();
                case 8 -> addNewCourse();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }
    
    private void displayAllCourses() {
        System.out.println("\n=== AVAILABLE COURSES ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                String availability = course.hasSeatsAvailable() ? "Available" : "FULL";
                System.out.printf("%d. %s [%s]\n", i + 1, course, availability);
            }
        }
    }
    
    private void displayAllStudents() {
        System.out.println("\n=== REGISTERED STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, students.get(i));
            }
        }
    }
    
    private void enrollStudent() {
        displayAllStudents();
        System.out.print("Select student (number): ");
        int studentIndex = scanner.nextInt() - 1;
        
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection!");
            return;
        }
        
        displayAllCourses();
        System.out.print("Select course to enroll (number): ");
        int courseIndex = scanner.nextInt() - 1;
        
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course selection!");
            return;
        }
        
        Student student = students.get(studentIndex);
        Course course = courses.get(courseIndex);
        
        if (student.enrollInCourse(course)) {
            System.out.println("Successfully enrolled " + student.getName() + " in " + course.getCourseName());
        } else {
            System.out.println("Enrollment failed! Course may be full or student already enrolled.");
        }
    }
    
    private void dropStudent() {
        displayAllStudents();
        System.out.print("Select student (number): ");
        int studentIndex = scanner.nextInt() - 1;
        
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection!");
            return;
        }
        
        Student student = students.get(studentIndex);
        List<Course> enrolledCourses = student.getEnrolledCourses();
        
        if (enrolledCourses.isEmpty()) {
            System.out.println("Student is not enrolled in any courses.");
            return;
        }
        
        System.out.println("\nCourses enrolled by " + student.getName() + ":");
        for (int i = 0; i < enrolledCourses.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, enrolledCourses.get(i).getCourseName());
        }
        
        System.out.print("Select course to drop (number): ");
        int courseIndex = scanner.nextInt() - 1;
        
        if (courseIndex < 0 || courseIndex >= enrolledCourses.size()) {
            System.out.println("Invalid course selection!");
            return;
        }
        
        Course course = enrolledCourses.get(courseIndex);
        if (student.dropCourse(course)) {
            System.out.println("Successfully dropped " + student.getName() + " from " + course.getCourseName());
        } else {
            System.out.println("Drop failed!");
        }
    }
    
    private void viewStudentSchedule() {
        displayAllStudents();
        System.out.print("Select student (number): ");
        int studentIndex = scanner.nextInt() - 1;
        
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection!");
            return;
        }
        
        students.get(studentIndex).displaySchedule();
    }
    
    private void viewCourseEnrollment() {
        displayAllCourses();
        System.out.print("Select course (number): ");
        int courseIndex = scanner.nextInt() - 1;
        
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course selection!");
            return;
        }
        
        Course course = courses.get(courseIndex);
        System.out.println("\n=== ENROLLMENT FOR " + course.getCourseCode() + " ===");
        System.out.println("Enrolled students: " + course.getCurrentEnrollment() + "/" + course.getMaxCapacity());
        
        List<Student> enrolledStudents = course.getEnrolledStudents();
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("• " + student.getName() + " (" + student.getStudentId() + ")");
            }
        }
    }
    
    private void addNewStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        students.add(new Student(studentId, name, email, year));
        System.out.println("Student added successfully!");
    }
    
    private void addNewCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();
        
        courses.add(new Course(courseCode, courseName, instructor, maxCapacity, credits));
        System.out.println("Course added successfully!");
    }
    
    public static void main(String[] args) {
        CourseEnrollmentSystem system = new CourseEnrollmentSystem();
        system.displayMenu();
    }
}