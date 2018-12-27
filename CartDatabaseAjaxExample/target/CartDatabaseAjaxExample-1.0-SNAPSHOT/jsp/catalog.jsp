<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Каталог товаров</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css?v=3">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <style> td, th{
        border: 1px solid black;
        text-align: center;
    }</style>
</head>

<script>
    function buyProducts(id) {
        $.ajax({
            type: 'POST',
            url: '/catalog',
            data: {
                product_id: id,
                action: 'buy'
            }
        }).done(function (data) {
            let tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'name' +
                '</th>' +
                '<th>' +
                'quantity' +
                '</th>' +
                '<th>' +
                ' ' +
                '</th>'+
                '</tr>';
            for (var key in data) {
                tableHtml += '<tr>' +
                    '<td>' + getProductName(key) + '</td>' +
                    '<td>' + data[key] + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
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
        })
    }
</script>

<script>
    function deleteProduct(id) {
        $.ajax({
            type: 'POST',
            url: '/catalog',
            data: {
                product_id: id,
                action: 'delete'
            }
        }).done(function (data) {
            console.log(data);
            let tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'name' +
                '</th>' +
                '<th>' +
                'quantity' +
                '</th>' +
                '<th>' +
                ' ' +
                '</th>' +
                '</tr>';
            for (var key in data) {
                tableHtml += '<tr>' +
                    '<td>' + getProductName(key) + '</td>' +
                    '<td>' + data[key] + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
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
    }
</script>
<script>
    function getData() {
        $.ajax({
            url: "/catalog.json",
            type: "GET",
            data_type: "json"
        })
            .done(function (data) {
                console.log(data);
                let tableHtml = "";
                tableHtml += '<table>';
                tableHtml +=
                    '<tr>' +
                    '<th>' +
                    'name' +
                    '</th>' +
                    '<th>' +
                    'quantity' +
                    '</th>' +
                    '<th>' +
                    ' ' +
                    '</th>' +
                    '</tr>';
                for (var key in data) {
                    tableHtml += '<tr>' +
                        '<td>' + getProductName(key) + '</td>' +
                        '<td>' + data[key] + '</td>' +
                        '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
                        '</tr>';
                }
                tableHtml += '</table>';
                $("#goods_table").html(tableHtml);
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
    }
    function getProductId(key) {
        return key.substring(key.indexOf("=") + 1, key.indexOf(","));
    }
    function getProductName(key) {
        return key.substring(key.indexOf("=", key.indexOf("=") + 1) + 1, key.indexOf(",", key.indexOf(",") + 1));
    }
</script>

<body onload="getData()">

<div class="container content">
    <div class="row">
        <div class="col-md-4">
            <div class="list-group">
                <a href="#" class="list-group-item">Sweets</a>
                <a href="#" class="list-group-item">Meat</a>
                <a href="#" class="list-group-item">Fruits</a>
                <a href="#" class="list-group-item">Dunno what else</a>
                <a href="#" class="list-group-item">Dunno what else again</a>
                <a href="../jsp/Redirect.jsp" class="list-group-item">Cart</a>
                <a href="/search" class="list-group-item">Search</a>
                <br>
                <div id="goods_table"></div>
            </div>
        </div>
        <div class="col-md-8 products">
            <div class="row">
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(1)" name="van_marshmellow">
                        <div class="product-img" >
                            <a href="#"><img src="../resources/goods1.jpg" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a>Vanilla marshmellow</a>
                        </p>
                        <p class="product-desc">Tasty and sugary</p>
                        <p class="product-price" id="price">$2.00</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(2)" name="Paste">
                        <div class="product-img">
                            <a href="#"><img src="../resources/goods2.JPG" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a id="name" >Paste</a>
                        </p>
                        <p class="product-desc">Everything you wanna know: it's tasty</p>
                        <p class="product-price">$2.00</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(3)" name="Strawberry marshmellow">
                        <div class="product-img">
                            <a href="#"><img src="../resources/goods3.jpg" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a href="#">Strawberry marshmellow</a>
                        </p>
                        <p class="product-desc">Tastes like strawberry.</p>
                        <p class="product-price">$2.00</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(4)" name="butterscoth">
                        <div class="product-img">
                            <a href="#"><img src="../resources/goods4.jpg" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a href="#">Butterscotch</a>
                        </p>
                        <p class="product-desc">Wanna try it? You must be mad!</p>
                        <p class="product-price">$1.00</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(5)" name="M&M's">
                        <div class="product-img">
                            <a href="#"><img src="../resources/goods5.jpg" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a href="#">M&M's</a>
                        </p>
                        <p class="product-desc">Yeah, M&M's</p>
                        <p class="product-price">$2.00</p>
                </div>
            </div>
                <div class="col-sm-4">
                    <div class="product" onclick="buyProducts(6)" name="Chocolate">
                        <div class="product-img">
                            <a href="#"><img src="../resources/goods6.jpg" alt=""></a>
                        </div>
                        <p class="product-title">
                            <a href="#">Chocolate</a>
                        </p>
                        <p class="product-desc">Just plain chocolate, nothing to worry about. Except gaining weight.</p>
                        <p class="product-price">$1.00</p>
                    </div>
                </div>
</div>
        </div>
    </div>
</div>
</body>
</html>