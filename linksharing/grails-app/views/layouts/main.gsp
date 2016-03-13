<%@ page import="com.ttnd.linksharing.Enum.Visiblity" %>
<!DOCTYPE HTML>
<html lang="en">

<head>
    <title>first bootstrap program>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    %{--<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>--}%
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
    <g:link action="index" controller="user"><h2>Link Sharing</h2></g:link>
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
                    <span class="glyphicon glyphicon-file" style="font-size:20px"></span>
                </button>
            </li>

            <span class="glyphicon glyphicon-user" style="font-size:23px"></span>

        <div class="dropdown" style="float:right">
            <button class="btn" data-toggle="dropdown">${session.user.firstName}<span class="caret"
                                                                                      style="font-size:20px">
</span></button>
    <ul class="dropdown-menu">
        <li><g:link controller="user" action="privateProfile" params="[id:session.user.id]">profile</g:link></li>
        %{--<li><a href="#">user</a></li>--}%
        <li><g:link controller="user" action="list" >user</g:link></li>

        <g:link action="logout" controller="login">Logout</g:link>
    </ul>
    </div>
</ul>
</li>

</ul>
</form>
</div>
</nav>
</div>
    <g:render template="/topic/createTopic"/>
    <g:render template="/topic/sendInvitation" model="[listOfTopics:session.user.subscribedTopics]"/>
    <g:render template="/documentResource/createDocument"/>
    <g:render template="/linkResource/createLink"/>
    </div>
</g:if>
<g:else>
    <div class="container-fluid">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <div class="col-xs-12">
                    <g:link action="index" controller="login"><h2>Link Sharing</h2></g:link>
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

<div class="alert messageAlert" id="alert" style="display:none">
</div>

<g:layoutBody/>
<asset:javascript src="application.js"/>
<asset:stylesheet href="application.css"/>
<asset:javascript src="jquery-2.2.1.min.js"/>
<asset:javascript src="jquery.validate.min.js"/>

</body>
</html>

