<!DOCTYPE html>
<html>
<head>
    <title>Add new user</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<form action="screening?action=editScreening" method="post">
    <label for="id_screening">ID</label>
    <input id="id_screening" type="text" name="id" readonly value="${screening.id_screening}">
    <br>
    <label for="id">MOVIE NAME</label>
    <input id="id" type="text" name="id" readonly value="${screening.id_screening}">
    <br>

    <label for="auditorium_id">AUDITORIUM ROOM</label>
    <input id="auditorium_id" type="text" name="auditorium_id" value="${screening.id_screening}">
    <br>
    <label for="screening_start">SCREENING_START</label>
    <input id="screening_start" type="time" name="screening_start" readonly value="${screening.id_screening}">
    <br>



    <button type="submit">UPDATE</button>

</form>

</body>
</html>