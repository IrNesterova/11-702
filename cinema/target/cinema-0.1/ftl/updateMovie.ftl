<!DOCTYPE html>
<html>
<head>
    <title>Update user</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        input[readonly] {
            background-color:lightGray;
        }
    </style>
</head>
<body>

<form action="movieList?action=editMovie" method="post">

    <label for="id_movie">Id:</label>
    <input id="id_movie" type="text" name="id_movie" readonly value="${movieList.id_movie}">
    <br>

    <label for="title">Title:</label>
    <input id="title" type="text" name="title" value="${movieList.title}">
    <br>

    <label for="actors">Actors:</label>
    <input id="actors" type="text" name="actors" value="${movieList.actors}">
    <br>
    <label for="director">Director:</label>
    <input id="director" type="text" name="director" value="${movieList.director}">
    <br>
    <label for="description">Description:</label>
    <input id="description" type="text" name="description" value="${movieList.description}">
    <br>
    <button type="submit">Update</button
</form>

</body>
</html>