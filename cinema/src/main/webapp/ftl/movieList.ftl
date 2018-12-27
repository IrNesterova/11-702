<!DOCTYPE html>
<html>
<head>
    <title>Movie list</title>
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
                        <th class="column2">NO.</th>
                        <th class="column2">MOVIE NAME</th>
                        <th class="column3">DIRECTOR</th>
                        <th class="column">ACTORS</th>
                        <th class="column1">DESCRIPTION</th>

                        <th colspan="3">ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list movieList as movieList>
                    <tr>
                        <td>${movieList.id_movie}</td>
                        <td>${movieList.title}</td>
                        <td>${movieList.director}</td>
                        <td>${movieList.actors}</td>
                        <td>${movieList.description}</td>
                        <td><a href = "movieList?action=editMovie&id_movie=${movieList.id_movie}">UPDATE</a></td>
                        <td><a href = "movieList?action=deleteMovie&id_movie=${movieList.id_movie}">DELETE</a></td>
                    </tr>
                    </#list>
                    </tbody>

                </table>
                <a href="movieList?action=addMovie">Add new movie</a>
            </div>
        </div>
    </div>
</div>
<p>

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