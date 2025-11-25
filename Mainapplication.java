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
