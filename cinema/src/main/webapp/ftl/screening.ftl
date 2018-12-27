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

<ul>
    <li><a href="ftl/screening.ftl">Screening</a></li>
    <li><a href="ftl/movieList.ftl">Movie List</a></li>
    <li><a href="ftl/employeeList.ftl">Employee List</a></li>

</ul>
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
                <table>
                    <thead>
                    <tr class="table100-head">
                        <th class="column1">ID</th>
                        <th class="column2">MOVIE NAME</th>
                        <th class="column3">AUDITORIUM</th>
                        <th class="column3">START</th>
                        <th colspan="3">ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list screeningList as screeningList>
                    <tr>
                        <td>${screeningList.id_screening}</td>
                        <td>${screeningList.id_movie}</td>
                        <td>${screeningList.auditorium_id}</td>
                        <td>${screeningList.screening_start}</td>
                        <td><a href = "screening?action=reserveSeat&id=${screeningList.id_screening}">RESERVE SEAT</a></td>
                        <td><a href = "screening?action=editScreening&id=${screeningList.id_screening}">UPDATE</a></td>
                        <td><a href = "screening?action=deleteScreening&id=${screeningList.id_screening}">DELETE</a></td>

                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<p>
    <a href="screening?action=addScreening">Add new screening</a>
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