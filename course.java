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
