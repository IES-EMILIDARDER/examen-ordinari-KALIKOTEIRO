package EXAMEN;

import EXAMEN.model.Department;
import EXAMEN.model.Employee;
import examen.utils.GestorExamen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GestorExamen gestor = new GestorExamen();
        
        Set<Department> departments = new HashSet<>();
        Map<String, Employee> employees = new HashMap<>();
        Map<Department, List<Employee>> departmentsXemployees = new HashMap<>();
        
        try {
            gestor.carregaDades(); // Carrega les dades correctament
            gestor.mostraDepartments(); // Mostra els departaments
            gestor.mostraEmployees();   // Mostra empleats
            gestor.mostraDepartmentsXEmployees(); // Mostra relació
            gestor.desaDepartmentsXEmpleatsCSV("c:\\temp\\departmentXEmpleats.cvs");
        } catch(Exception e) {
            System.out.println("Error durant l'execució: " + e.getMessage());
        }

        for (Department d : departments) {
            System.out.println(d);
        }

        for (Employee e : employees.values()) {
            System.out.println(e);
        }

        try (PrintWriter pw = new PrintWriter(new File("departmentsXemployees.csv"))) {
            for (Department d : departments) {
                List<Employee> emps = departmentsXemployees.getOrDefault(d, new ArrayList<>());
                StringBuilder emails = new StringBuilder();
                for (Employee e : emps) {
                    emails.append(e.getEmail()).append(";");
                }
                pw.printf("%d,%s,%s%n", d.getDepartmentId(), d.getName(), emails.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


