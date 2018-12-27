<!DOCTYPE html>
<html>
<head>
    <title>Add reservation</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>.header {
        color: #36A0FF;
        font-size: 27px;
        padding: 10px;
    }

    .bigicon {
        font-size: 35px;
        color: #36A0FF;
    }</style>
</head>
<body>

<form action="employeeList.ftl?action=addEmployee" method="post">

    <label for="id_reservation">ID</label>
    <input id="id_reservation" type="text" name="id">
    <br>

    <label for="screening_id">screening_id</label>
    <input id="screening_id" type="text" name="username">
    <br>

    <label for="employee_reserved_id">reserved</label>
    <input id="employee_reserved_id" type="password" name="password">
    <br>
    <label for="reservation_type_id">reservation_type</label>
    <input id="reservation_type_id" type="text" name="first_name">
    <br>
    <label for="reservation_contact"></label>
    <input id="reservation_contact" type="text" name="reservation_contact">
    <br>
    <label for="reserved">SEX </label>
    <input id="reserved" type="checkbox" name="reserved">
    <br>
    <label for="employee_reserved_id">PASSWORD</label>
    <input id="employee_reserved_id" type="password" name="password">
    <br>
    <label for="paid">SEX </label>
    <input id="paid" type="checkbox" name="paid">
    <br>
    <label for="active">SEX </label>
    <input id="active" type="checkbox" name="active">
    <br>
    <button type="submit">Submit</button>

</form>

</body>
</html>