<%--
  Created by IntelliJ IDEA.
  User: Justice
  Date: 26.12.2018
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <input id="q" type="text" onkeyup="search(document.getElementById('q').value)">
    <br>
    <div id="movie_table">

    </div>
</div>

<script>
    function search(query) {
        $.ajax({
            type: 'GET',
            url: '/search',
            data: {
                q: query
            }
        }).done(function (data) {
            $.ajax({
                type: 'GET',
                url: '/search',
                data: {
                    q: query
                }
            }).done(function (data) {
                let tableHtml = "";
                tableHtml += '<table>';
                tableHtml +=
                    '<tr>' +
                    '<th>' +
                    'id' +
                    '</th>' +
                    '<th>' +
                    'title' +
                    '</th>' +
                    '<th>' +
                    'director' +
                    '</th>' +
                    '<th>' +
                    'actors' +
                    '</th>' +
                    '<th>' +
                    'description' +
                    '</th>' +
                    '<th>' +
                    'duration' +
                    '</th>' +
                    '</tr>';
                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].id_movie + '</td>' +
                        '<td>' + data[i].title + '</td>' +
                        '<td>' + data[i].director + '</td>' +
                        '<td>' + data[i].actors + '</td>' +
                        '<td>' + data[i].description + '</td>'+
                        '<td>' + data[i].duration_min + '</td>' +
                        '</tr>';
                }
                $("#movie_table").html(tableHtml);
            }).fail(function (jqXHR, exception) {
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                alert(msg)
            });
        })
    }
</script>
</body>

</html>