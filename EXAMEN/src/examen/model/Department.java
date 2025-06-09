package EXAMEN.model;

import java.util.Objects;

public class Department {
    private int departmentId;
    private String name;
    
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId;
    }
     @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }

    @Override
    public String toString() {
        return departmentId + "   " + name;
    }
    
}
