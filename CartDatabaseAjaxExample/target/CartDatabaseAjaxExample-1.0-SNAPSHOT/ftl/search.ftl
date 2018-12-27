<!DOCTYPE html>
<html>
<head>
    <title>FreeMarker test</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form class="navbar-form" role="search" action="<"search" />" method="get">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="<@fmt.message key='searchbox.placeholder'/>" name="query">
        <div class="input-group-btn">
            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
        </div>
    </div>
</form>
</body>
</html>