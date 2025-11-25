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
