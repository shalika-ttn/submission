<%--
  Created by IntelliJ IDEA.
  User: shalika
  Date: 26/2/16
  Time: 5:04 PM
--%>

<%@ page contentType=" text/html;charset=UTF-8 %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>
<div class="container-fluid">

    <div class="col-xs-7" style="float:left">
        <div class="row">
            <g:render template="/login/recentPost" model="resources"/>
        </div>

        <div class="row">
            <g:render template="/login/topPost" model="resources"/>
        </div>
    </div>

    <div class="col-xs-4" style="float:right">
        <div class="row">
            <g:render template="loginform"/>
        </div>

        <div class="row">
            <g:render template="/user/createForm"/>
        </div>
    </div>
</div>

</body>
</html>