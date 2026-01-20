package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartamentDao();

        System.out.println("=== Test 1: Department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n === Test 2: Department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list){
            System.out.println(dep);
        }

        System.out.println("\n === Test 3: Department insert ===");
        Department newDepartment = new Department(null, "Smartphones");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! Id = " + newDepartment.getId());

        System.out.println("\n === Test 4: Department update ===");
        Department department1 = new Department(1, "Notebooks");
        departmentDao.update(department1);
        System.out.println("Update Completed");

        System.out.println("\n === Test 5: Department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Id deleted!");

    }
}
