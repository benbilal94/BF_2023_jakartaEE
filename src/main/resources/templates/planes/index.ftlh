<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col s6">
            <#if name??>
                <h1>Bonjour ${ name }</h1>
            </#if>
            <form action="${ contextPath }/plane" method="get">
                <div class="input-field">
                    <input type="text" name="name" id="name">
                    <label for="name">Name</label>
                </div>
                <button type="submit">Change greeting</button>
            </form>
        </div>
        <div class="col s6">
            <ul>
                <#list names as str>
                    <li>${ str_index } - ${ str }</li>
                </#list>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
