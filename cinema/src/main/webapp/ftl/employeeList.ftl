<!DOCTYPE html>
<html>
<head>
    <title>Screening</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 200px;
        background-color: #f1f1f1;
    }

    .li a {
        display: block;
        color: #000;
        padding: 8px 16px;
        text-decoration: none;
    }

    /* Change the link color on hover */
    .li a:hover {
        background-color: #555;
        color: white;</style>
    <link rel="icon" type="image/png" href="../images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/main.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="screening">Screening List</a>
            <a class="nav-item nav-link" href="movieList">Movie List</a>
            <a class="nav-item nav-link" href="employeeList">Employee List</a>

        </div>
    </div>
</nav>
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
                <table>
                    <thead>
                    <tr class="table100-head">
                        <th class="column1">FIRST NAME</th>
                        <th class="column2">LAST NAME</th>
                        <th class="column3">SEX</th>
                        <th colspan="2">ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list employeeList as employee>
                    <tr>
                        <td>${employee.first_name}</td>
                        <td>${employee.last_name}</td>
                        <td>${employee.sex}</td>
                        <td><a href = "employeeList?action=editEmployee&id_employee=${employee.id_employee}">UPDATE</a></td>
                        <td><a href = "employeeList?action=deleteEmployee&id_employee=${employee.id_employee}">DELETE</a></td>

                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<p>
    <a href="employeeList?action=addEmployee">Add new employee</a>
</p>
<script src="../vendor/jquery/jquery.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/bootstrap/js/popper.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../js/main.js"></script>
</body>
</html>