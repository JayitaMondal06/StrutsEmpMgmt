
<!doctype html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@page import="com.exavalu.services.RoleService"%>
    <%@page import="com.exavalu.services.DepartmentService"%>
    <%@page import="com.exavalu.models.Department"%>
    <%@page import="com.exavalu.models.Role"%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Add Employee - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
<!--        <link href="css/signin.css" rel="stylesheet">-->

    </head>

    <body class="text-center">
   <jsp:include page="menu.jsp"></jsp:include>

       <main class="form-signin w-100 m-auto">
           <c:set var="emp" value="${Emp}"></c:set>       
            <form action="SaveEmployee" class="form-inline" method="Post">
                <div class="card-header">
                    <h1 class="h3 mb-3 fw-normal">Please edit employee data</h1>
                </div>
                    <div class="container">
                        <div class="row">
                            <div class="form-floating" >
                                <input type="text" class="form-control" id="floatingInput" placeholder="employee id " name="employeeId" value=${emp.getEmployeeId()} readonly>
                            <label for="floatingInput">Employee Id</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=${emp.getFirstName()}>
                            <label for="floatingInput">First Name</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${emp.getLastName()}>
                            <label for="floatingInput">Last Name</label>
                        </div>
                        <div class="form-floating ">
                            <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" value=${emp.getAddress()}>
                            <label for="floatingInput">Address</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="phoneNo" name="phoneNo" value=${emp.getPhoneNo()}>
                            <label for="floatingInput">Phone</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" value=${emp.getGender()}>
                            <label for="floatingInput">Gender</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" value=${emp.getAge()}>
                            <label for="floatingInput">Age</label>
                        </div>
                        <div class="form-floating">
                    
                            <select name="departmentId" class="form-select" id="departmentId">
                                <option value="0">Select a Department</option>
                                   <c:forEach items="${DeptList}" var="dept" >
                                <option value=${dept.getDepartmentId()}<c:if test="${dept.getDepartmentName().equalsIgnoreCase(emp.getDepartmentName())}" > selected </c:if>> ${dept.getDepartmentName()} </option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-floating">

                            <select name="roleId" class="form-select" id="roleId">
                                <option value="0">Select a Role</option>
                               <c:forEach items="${RoleList}" var="role" >
                                <option value=${role.getRoleId()}<c:if test="${role.getRoleName().equalsIgnoreCase(emp.getRoleName())}" > selected </c:if> > ${role.getRoleName()}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" value=${emp.getBasicSalary()}>
                            <label for="floatingInput">Basic Salary</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="carAllowence" name="carAllowence" value=${emp.getCarAllowence()}>
                            <label for="floatingInput">Car Allowance</label>
                        </div>
                        <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
                        
                    </div>
                </div>
            

                                                     
            </div>

</form>
    </main>
    </body>
</html>
