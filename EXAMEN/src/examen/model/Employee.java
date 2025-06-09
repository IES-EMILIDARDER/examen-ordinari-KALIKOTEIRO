package EXAMEN.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Department department;

    public Employee(String fisrtName, String lastName, String email, Department department) {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }
    public String getFristName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public Department getDepartment(){
        return department;
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }
     @Override
    public int hashCode() {
        return Objects.hash(email);
    }
    
    
    
    @Override
    public String toString() {
        return firstName + "  " + lastName + " (" + email + ")";
    }

}
