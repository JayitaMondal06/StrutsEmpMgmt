/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String address;
    private String gender;
    private String age;
    private String departmentId;
    private String roleId;
    private String basicSalary;
    private String carAllowence;
//private String email;
//private String password;
    private String departmentName;
    private String roleName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getCarAllowence() {
        return carAllowence;
    }

    public void setCarAllowence(String carAllowence) {
        this.carAllowence = carAllowence;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    /**
     *
     * @return @throws Exception
     */
    public String doAddEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().doAddEmployee(this);
        if (success) {
           
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();

            sessionMap.put("EmpList", empList);

        
            result = "SUCCESS";
        } else {
            String errorMsg = "Data entry is wrong!! Please try again!";
            sessionMap.put("ErrorMsg", errorMsg);

        }

        return result;

    }

    public String doSearchEmployee() throws Exception {
       String result = "FAILURE";
      // String result = "SUCCESS";
        ArrayList empList = EmployeeService.getInstance().doSearchEmployee(this);

       if (empList != null) {
            sessionMap.put("EmpList", empList);
            result = "SUCCESS";
       }

return result;
    }
        
  
   public String doUpdateEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().doUpdateEmployee(this,this.employeeId);
        
        if (success) {
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList", empList);
            result = "SUCCESS";
        } 
        return result;
    }
   
   
   
    public String doEditEmployee() throws Exception {
        Employee emp = EmployeeService.getInstance().doGetEmployee(this.employeeId);
        ArrayList deptList = DepartmentService.getAllDepartment();
        ArrayList roleList = RoleService.getAllRoles();

        sessionMap.put("Emp", emp);
        sessionMap.put("DeptList", deptList);
        sessionMap.put("RoleList", roleList);
        
        return "SUCCESS";
    }
}
