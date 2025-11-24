title - # Complete-Student-Management-System

overview of the project

A web-based Student Management System that streamlines academic administration. It manages student records, courses, and grades through an intuitive platform, automating processes for efficiency.

Features used for the project

Student Management: Add, view, update, and delete student profiles.
Course Management: Maintain course catalog, credits, and instructor details.
Grade Management: Assign and track student grades for courses.
Academic Reporting: Generate performance reports and calculate GPA.
Department Analytics: View student and course statistics by department.
RESTful API: Programmable interface for all system functions.
Responsive Web Interface: Accessible on desktop and mobile devices.

Technologies/tools used

Backend: Python, Flask, SQLAlchemy
Frontend: HTML, CSS, JavaScript, Bootstrap
Database: SQLite
Tools: Git, REST API, unittest
Steps to install & run the project
1.Install Python (3.8 or higher)
2.Install dependencies:
pip install -r requirements.txt
3.Run the application:
python app.py
4.Access system:
Open http://localhost:5000 in your browser

Instructions for testing

1.Run all tests:
python -m unittest discover tests/
2.Test specific module:
python tests/test_students.py
3.Manual testing:
Add/update/delete students
Create courses and assign grades
Generate reports
Verify data persists

CODE USED
package model;

import java.time.LocalDate;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate enrollmentDate;
    private String department;

    // Constructors
    public Student() {}

    public Student(String studentId, String firstName, String lastName, 
                  String email, String phone, LocalDate enrollmentDate, String department) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enrollmentDate = enrollmentDate;
        this.department = department;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("Student ID: %s, Name: %s %s, Email: %s, Department: %s", 
                studentId, firstName, lastName, email, department);
    }
}
Student.java (Model Class)
package model;

import java.time.LocalDate;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate enrollmentDate;
    private String department;

    // Constructors
    public Student() {}

    public Student(String studentId, String firstName, String lastName, 
                  String email, String phone, LocalDate enrollmentDate, String department) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enrollmentDate = enrollmentDate;
        this.department = department;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return String.format("Student ID: %s, Name: %s %s, Email: %s, Department: %s", 
                studentId, firstName, lastName, email, department);
    }
}
Course.java (Model Class)
package model;

public class Course {
    private String courseId;
    private String courseName;
    private String description;
    private int credits;
    private String instructor;
    private int maxCapacity;

    // Constructors, Getters, and Setters
    public Course() {}

    public Course(String courseId, String courseName, String description, 
                  int credits, String instructor, int maxCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
    }

    // Getters and Setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    @Override
    public String toString() {
        return String.format("Course ID: %s, Name: %s, Credits: %d, Instructor: %s", 
                courseId, courseName, credits, instructor);
    }
}
StudentService.java (Service Layer)
package service;

import model.Student;
import dao.StudentDAO;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public boolean addStudent(Student student) {
        // Validate student data
        if (!isValidStudent(student)) {
            return false;
        }
        return studentDAO.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        if (!isValidStudent(student)) {
            return false;
        }
        return studentDAO.updateStudent(student);
    }

    public boolean deleteStudent(String studentId) {
        return studentDAO.deleteStudent(studentId);
    }

    public Optional<Student> getStudentById(String studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public List<Student> searchStudents(String keyword) {
        return studentDAO.searchStudents(keyword);
    }

    private boolean isValidStudent(Student student) {
        return student != null &&
               student.getStudentId() != null && !student.getStudentId().isEmpty() &&
               student.getFirstName() != null && !student.getFirstName().isEmpty() &&
               student.getEmail() != null && student.getEmail().contains("@");
    }
}
StudentDAO.java (Data Access Layer)
package dao;

import model.Student;
import java.util.*;
import java.util.stream.Collectors;

public class StudentDAO {
    private Map<String, Student> students;
    private static final String STUDENT_ID_PREFIX = "STU";

    public StudentDAO() {
        this.students = new HashMap<>();
        // Initialize with sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        Student student1 = new Student("STU001", "John", "Doe", 
                "john.doe@email.com", "1234567890", 
                java.time.LocalDate.now(), "Computer Science");
        
        Student student2 = new Student("STU002", "Jane", "Smith", 
                "jane.smith@email.com", "0987654321", 
                java.time.LocalDate.now(), "Electrical Engineering");
        
        students.put(student1.getStudentId(), student1);
        students.put(student2.getStudentId(), student2);
    }

    public boolean addStudent(Student student) {
        if (students.containsKey(student.getStudentId())) {
            return false; // Student ID already exists
        }
        students.put(student.getStudentId(), student);
        return true;
    }

    public boolean updateStudent(Student student) {
        if (!students.containsKey(student.getStudentId())) {
            return false; // Student not found
        }
        students.put(student.getStudentId(), student);
        return true;
    }

    public boolean deleteStudent(String studentId) {
        if (!students.containsKey(studentId)) {
            return false; // Student not found
        }
        students.remove(studentId);
        return true;
    }

    public Optional<Student> getStudentById(String studentId) {
        return Optional.ofNullable(students.get(studentId));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Student> searchStudents(String keyword) {
        return students.values().stream()
                .filter(student -> 
                    student.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getStudentId().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getEmail().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public String generateStudentId() {
        int nextId = students.size() + 1;
        return String.format("%s%03d", STUDENT_ID_PREFIX, nextId);
    }
}
InputValidator.java (Utility Class)
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator {
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
    
    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static boolean isPositiveInteger(String str) {
        try {
            int value = Integer.parseInt(str);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
 MainApplication.java (Main Class)
 package main;

import model.Student;
import service.StudentService;
import util.InputValidator;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private StudentService studentService;
    private Scanner scanner;

    public MainApplication() {
        this.studentService = new StudentService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🎓 Welcome to Student Management System 🎓");
        
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("=================");
    }

    private void addStudent() {
        System.out.println("\n--- Add New Student ---");
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }
        
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setDepartment(department);
        student.setEnrollmentDate(LocalDate.now());
        
        if (studentService.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student. Student ID might already exist.");
        }
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> students = studentService.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private void searchStudent() {
        System.out.print("\nEnter search keyword: ");
        String keyword = scanner.nextLine();
        
        List<Student> results = studentService.searchStudents(keyword);
        
        if (results.isEmpty()) {
            System.out.println("No students found matching your search.");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }

    private void updateStudent() {
        System.out.print("\nEnter Student ID to update: ");
        String studentId = scanner.nextLine();
        
        // Implementation for update
        System.out.println("Update functionality to be implemented...");
    }

    private void deleteStudent() {
        System.out.print("\nEnter Student ID to delete: ");
        String studentId = scanner.nextLine();
        
        if (studentService.deleteStudent(studentId)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found or deletion failed.");
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.start();
    }
}










