<!DOCTYPE html>
<html>
<head>
    <title>Add new user</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<form action="employeeList.ftl?action=addEmployee" method="post">

    <label for="id">ID</label>
    <input id="id" type="text" name="id" readonly value="${reservationList.id}">
    <br>

    <label for="screening_id">SCREENING</label>
    <input id="screening_id" type="text" name="username" value="${reservationList.screening_id}">
    <br>

    <label for="employee_reserved_id">EMPLOYEE RESERVED</label>
    <input id="employee_reserved_id" type="password" name="employee_reserved_id" value="${reservationList.employee_reserved_id}">
    <br>
    <label for="reservation_type_id">RESERVATION TYPE</label>
    <input id="reservation_type_id" type="text" name="reservation_type_id" value = "${reservationList.reservation_type_id}">
    <br>
    <label for="reservation_contact">RESERVATION_CONTACT</label>
    <input id="reservation_contact" type="text" name="reservation_contact" value="${reservationList.reservation_contact}">
    <br>
    <label for="reserved">RESERVED </label>
    <input id="reserved" type="checkbox" name="reserved" value="${reservationList.reserved}">
    <br>
    <label for="employee_reserved_id">PASSWORD</label>
    <input id="employee_reserved_id" type="password" name="password" value="${reservationList.employee_reserved_id}">
    <br>
    <label for="paid">SEX </label>
    <input id="paid" type="checkbox" name="paid" value="${reservationList.paid}">
    <br>
    <label for="active">SEX </label>
    <input id="active" type="checkbox" name="active" value="${reservationList.active}">
    <br>
    <button type="submit">UPDATE</button>

</form>

</body>
</html>