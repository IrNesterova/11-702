<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="C:\Users\Justice\Desktop\11-702\databaseproject\src\web\css\styles.css" rel="stylesheet">
</head>
<body>
<div class="form-style-3">
    <form method="post">
        <fieldset>
            <legend>Personal</legend>
            <label for="title"><span>Title</span><input id="title" name="title"
                                                                  type="text"
                                                                  class="input-field"
                                                                  value=""/></label>
            <label for="description"><span>Description</span><input id="description" name="description"
                                                                type="text"
                                                                class="input-field"
                                                                value=""/></label>
            <label for="director"><span>Director </span><input id="director" type="text" name="director"
                                                         class="input-field"
                                                         value=""/></label>
            <label for="actors"><span>Password </span><input id="actors" name="actors"
                                                               type="text"
                                                               class="input-field"
                                                               value=""/></label>
            <label for="duration_min"><span>Duration </span><input id="duration_min" name="duration_min"
                                                             type="text"
                                                             class="input-field"
                                                             value=""/></label>
        </fieldset>
        <fieldset>
            <label><span>&nbsp;</span><input type="submit" value="Submit"/></label>
        </fieldset>
    </form>
</div>
</body>
</html>