<%-- 
    Document   : searchemployee
    Created on : 03-Feb-2023, 12:29:38 am
    Author     : USER
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="com.exavalu.services.RoleService"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="com.exavalu.models.Department"%>
<%@page import="com.exavalu.models.Role"%>
<%@page import="com.exavalu.models.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="text-center">
        <jsp:include page="menu.jsp"></jsp:include>

            <div class="card-header">
                <h3 class="card-title">Search!</h3>
            </div>
            <form class="form-inline"action="SearchEmployee" method="Post">
                <div class="container" >
                    <div class="row">
                        <div class="form-control col-sm">
                            <input class="form-control" type="text" id="floatingInput" placeholder="First Name" name="firstName">

                        </div>
                        <div class="form-control col-sm">
                            <input class="form-control" type="text" id="floatingInput" placeholder="Last Name" name="lastName">

                        </div>

                        <div class="form-control col-sm">
                            <select name="gender" class="form-select" id="gender">
                                <option value="" hidden>Gender</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>


                        <div class="form-control col-sm">


                        <c:set var= "department" value="${DepartmentService.getAllDepartment()}"></c:set>
                            <select name="departmentName" class="form-select" id="departmentName">
                                <option value="" hidden>Select Department </option>


                            <c:forEach var="dept" items="${department}">

                                <option value=${dept.getDepartmentName()}> ${dept.getDepartmentName()}  </option>
                            </c:forEach>

                        </select>

                    </div>
                    <div class="form-control col-sm">

                        <c:set var = "role" value="${RoleService.getAllRoles()}"></c:set>
                            <select name="roleName" class="form-select" id="roleName">
                                <option value="" hidden>Select Role </option>

                            <c:forEach var="role" items="${role}">
                                <option value=${role.getRoleName()}> ${role.getRoleName()} </option>
                            </c:forEach>

                        </select>

                    </div>

                    <button class="w-100 btn btn-lg btn-primary" type="submit">Search</button>

                </div>
            </div>

        </form>



        <c:if test="${EmpList != null}">

            <div class="row justify-content-center">
                <div class="col-auto">
                    <table class="table table-bordered table-striped text-center " id="example">
                        <thead>
                            <tr>
                                <th>Employee Id  </th>
                                <th>First Name </th>
                                <th>Last Name</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Gender</th>
                                <th>Age</th>
                                <th>Department</th>
                                <th>Role</th>
                                <th>Basic Salary</th>
                                <th>Car Allowance</th>
                                <th>Action</th>


                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach  var="emp" items="${EmpList}" >
                                <tr>

                                    <td>${emp.getEmployeeId()}</td>
                                    <td>${emp.getFirstName()}</td>
                                    <td>${emp.getLastName()}</td>
                                    <td>${emp.getAddress()}</td>
                                    <td>${emp.getPhoneNo()}</td>
                                    <td>${emp.getGender()}</td>
                                    <td>${emp.getAge()}</td>
                                    <td>${emp.getDepartmentName()}</td>
                                    <td>${emp.getRoleName()}</td>
                                    <td>${emp.getBasicSalary()}</td>
                                    <td>${emp.getCarAllowence()}</td>
                                    <td><a href=EditEmployee?employeeId=${emp.getEmployeeId()}>Edit</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                </div>
            </div>
        </c:if>

    </body>
</html>
