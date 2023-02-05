
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
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
      <form action="AddEmployee" method="Post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="firstName" placeholder="firstName" name="firstName" required>
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="lastName"  name="lastName" required>
                    <label for="lastName">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="phoneNo" placeholder="phoneNo"  name="phoneNo" required>
                    <label for="phoneNo">Phone Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="address" placeholder="address"  name="address" required>
                    <label for="address">Address</label>
                </div>
                <div class="form-floating">
                    <select name="gender" class="form-select" id="gender" required>
                        <option value=""hidden>Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" required>
                    <label for="floatingInput"> Age</label>
                </div>
                <div class="form-floating">


                    <select name="departmentId" class="form-select" id="departmentId">
                        <option value="" hidden>Select Department </option>

                        <c:forEach var="dept" items="${DepartmentService.getAllDepartment()}">
                            <option value=${dept.getDepartmentId()} >${dept.getDepartmentName()}  </option>
                        </c:forEach>
                    </select>

                </div>
                <div class="form-floating">


                    <select name="roleId" class="form-select" id="roleId">
                        <option value="" hidden>Select Role </option>

                        <c:forEach var="role" items="${RoleService.getAllRoles()}">
                            <option value=${role.getRoleId()} >${role.getRoleName()}  </option>
                        </c:forEach>

                    </select>

                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" required>
                    <label for="floatingInput"> Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="carAllowence" name="carAllowence" required>
                    <label for="floatingInput"> Car Allowance</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
            </form>
        </main>



    </body>
</html>
