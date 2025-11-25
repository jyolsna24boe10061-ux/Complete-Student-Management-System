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
