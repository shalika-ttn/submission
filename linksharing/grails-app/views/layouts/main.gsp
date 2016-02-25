<!DOCTYPE HTML>
<html lang="en">
<html>
<head>
    <title>first bootstrap program>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    <script type="text/javascript" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
    input {
        text-align: center;
    }
    </style>
    <g:layoutHead/>
</head>

<body>
<div class="container-fluid">
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <div class="col-xs-12">
                <a href="#" style="font-family:verdana;font-size:30px">link Sharing</a>
            </div>
        </div>

        <form class="navbar-form navbar-right" style="padding-right:30px" role="search">

            <input type="text" placeholder="Search"><span class="glyphicon glyphicon-search" style="margin-left:-161px">
        </span>

        </form>
    </nav>
</div>
<g:layoutBody/>
</body>
</html>
