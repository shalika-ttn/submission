<!DOCTYPE HTML>
<html lang="en">

<head>
    <title>first bootstrap program>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <asset:javascript src="application.js"/>
    <asset:stylesheet href="application.css"/>
    <asset:javascript src="jquery-2.2.1.min.js"/>



    <style>
    input {
        text-align: center;
    }
    </style>
    <g:layoutHead/>
</head>

<body>
<g:if test="${session.user}">
    <div class="container-fluid">

        <div class="navbar navbar-default">
            <div class="navbar-header">
                <div class="col-xs-12">
                    <a href="#" style="font-family:verdana;font-size:30px">link Sharing</a>
                </div>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin:10px">
                <div class="navbar-form  navbar-right" role="search">

                    <input type="text" placeholder="Search"><span class="glyphicon glyphicon-search"
                                                                  style="margin-left:-161px">
                </span>
                </input>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <!--<div class="col-xs-7" style="float:right" >-->
                            <button type="button" data-toggle="modal" data-target="#myModal2">
                                <span class="glyphicon glyphicon-cloud" style="font-size:20px"></span>
                            </button>
                        </li>
                        <li>
                            <button type="button" data-toggle="modal" data-target="#myModal1">
                                <span class="glyphicon glyphicon-envelope" style="font-size:20px"></span>
                            </button>
                        </li>
                        <li>
                            <button type="button" data-toggle="modal" data-target="#myModal3">
                                <span class="glyphicon glyphicon-paperclip" style="font-size:20px"></span>
                            </button>
                        </li>
                        <li>
                            <button type="button" data-toggle="modal" data-target="#myModal4">
                                <span class="glyphicon glyphicon-inbox" style="font-size:20px"></span>
                            </button>
                        </li>

                        <span class="glyphicon glyphicon-user" style="font-size:23px"></span>

                    <div class="dropdown" style="float:right">
                        <button class="btn" data-toggle="dropdown">Uday<span class="caret"
                                                                             style="font-size:20px">
                        </span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">profile</a></li>
                        <li><a href="#">user</a></li>
                        <li><a href="#">topic</a></li>
                        <li><a href="#">Post</a></li>
    <g:link action="logout" controller="login">Logout</g:link>
    </ul>
    </div>
</div>
</li>

</ul>
</form>
</div>
</nav>
</div>
    <g:render template="/topic/createTopic"/>
    <g:render template="/topic/sendInvitation"/>
    <g:render template="/documentResource/createDocument"/>
    <g:render template="/linkResource/createLink"/>
    <div class="container-fluid">

    </div>

</g:if>
<g:else>
    <div class="container-fluid">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <div class="col-xs-12">
                    <a href="#" style="font-family:verdana;font-size:30px">link Sharing</a>
                </div>
            </div>

            <form class="navbar-form navbar-right" style="padding-right:30px" role="search">

                <input type="text" placeholder="Search"><span class="glyphicon glyphicon-search"
                                                              style="margin-left:-161px">
            </span>

            </form>
        </nav>
    </div>

</g:else>
<g:layoutBody/>

</body>
</html>

