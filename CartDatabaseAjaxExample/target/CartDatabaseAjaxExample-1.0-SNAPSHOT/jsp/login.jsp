<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <meta charset="utf-8">
    <title>Login</title>

    <style>
        .col-centered{
            float: none;
            margin-top: 150px;
            margin-left: 380px;
        }
    </style>
</head>
<body style="background-color: #003366">
<div class="container">
    <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
        <div class="jumbotron">
            <h3>Please, just login</h3>
            <form method="post">
                <div class="form-group">
                    <input name="name" class="form-control" placeholder="Name">
                </div>
                <div class="form-group">
                    <input type="password" name="password_hash" class="form-control" placeholder="Enter password">
                </div>
                <div class="custom-checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn-primary form-control">Login</button>
            </form>
        </div>
    </div>

</div>
</body>