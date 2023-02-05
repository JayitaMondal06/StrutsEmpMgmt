/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {

    public static EmployeeService employeeService = null;

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            return new EmployeeService();
        } else {
            return employeeService;
        }
    }

    public ArrayList getAllEmployees() {
        ArrayList empList = new ArrayList();
        //  String sql = "Select * from employees";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhoneNo(rs.getString("phoneNo"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowence(rs.getString("carAllowence"));

                empList.add(emp);

            }

        } catch (SQLException ex) {
        }
        System.out.println("Number of employees = " + empList.size());
        return empList;
    }

    public boolean doAddEmployee(Employee emp) {
        boolean success = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql = "INSERT INTO employees ( firstName, lastName, phoneNo, address, gender, age, basicSalary, carAllowence, departmentId, roleId) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // preparedStatement.setString(1, emp.getEmployeeId());
            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhoneNo());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7, emp.getBasicSalary());
            preparedStatement.setString(8, emp.getCarAllowence());
            preparedStatement.setString(9, emp.getDepartmentId());
            preparedStatement.setString(10, emp.getRoleId());

//                preparedStatement.setDouble(10, Double.parseDouble(emp.getBasicSalary()));
//                preparedStatement.setDouble(11, Double.parseDouble(emp.getCarAllowence()));
            System.out.println("preparedstatement :" + preparedStatement);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                success = true;

            }
        } catch (SQLException ex) {
        }

        return success;
    }

    public ArrayList doSearchEmployee(Employee emp) {
        ArrayList empList = new ArrayList();

        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId having e.firstName like ? and e.lastName like ? and e.gender like ? and d.departmentName like ? and r.roleName like ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFirstName() + "%");
            preparedStatement.setString(2, emp.getLastName() + "%");
            preparedStatement.setString(3, emp.getGender() + "%");
            preparedStatement.setString(4, emp.getDepartmentName() + "%");
            preparedStatement.setString(5, emp.getRoleName() + "%");

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Sql=" + preparedStatement);
            while (rs.next()) {
                Employee empy = new Employee();
                empy.setAddress(rs.getString("address"));
                empy.setEmployeeId(rs.getString("employeeId"));
                empy.setFirstName(rs.getString("firstName"));
                empy.setLastName(rs.getString("lastName"));
                empy.setPhoneNo(rs.getString("phoneNo"));
                empy.setGender(rs.getString("gender"));
                empy.setAge(rs.getString("age"));
                empy.setDepartmentName(rs.getString("departmentName"));
                empy.setRoleName(rs.getString("roleName"));
                empy.setBasicSalary(rs.getString("basicSalary"));
                empy.setCarAllowence(rs.getString("carAllowence"));

                empList.add(empy);
            }
        } catch (SQLException ex) {

        }

        return empList;
    }

    public boolean doUpdateEmployee(Employee emp,String employeeId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employeedb.employees\n"
                    + "SET firstName = ? , lastName = ? , phoneNo = ? , address = ? ,\n"
                    + "gender = ? , age = ? , basicSalary = ?,carAllowence = ?, departmentId=?, roleId=?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhoneNo());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setDouble(7, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(8, Double.parseDouble(emp.getCarAllowence()));
            preparedStatement.setString(9, emp.getDepartmentId());
            preparedStatement.setString(10, emp.getRoleId());

            preparedStatement.setString(11, employeeId);
            System.out.println("sql=" + preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
        }
        return result;
    }

    public  Employee doGetEmployee(String employeeId) {

        Employee emp = new Employee();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId and e.employeeId =?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
System.out.println("sql"+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhoneNo(rs.getString("phoneNo"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowence(rs.getString("carAllowence"));
                emp.setDepartmentId(rs.getString("departmentId"));
                emp.setRoleId(rs.getString("roleId"));

            }

        } catch (SQLException ex) {
        }

        return emp;

    }

}
