<%--
  Created by IntelliJ IDEA.
  User: shalika
  Date: 26/2/16
  Time: 6:19 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>


<div class ="col-xs-5" style="float:left">

    <g:render template="usershow"/>
    %{--<g:render template="/user/trendingTopic" model="[trendingTopics:trendingTopics]" />--}%
    <g:render template="trendingTopic"/>
</div>



%{--<div class="container-fluid">--}%
    %{--<!--<div class=row>-->--}%
    %{--<div class ="col-xs-5" style="float:left">--}%

     %{--<g:render template="trendingTopic" model="topicVo"/>--}%
    %{--</div>--}%
    %{--</div>--}%



</body>
</html>