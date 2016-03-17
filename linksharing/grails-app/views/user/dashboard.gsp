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

<div class="col-xs-5" style="float:left">

    <g:render template="usershow"/>
    <g:render template="subscription" model="[subscriptions: subscriptions]"/>
    <ls:trendingTopics> </ls:trendingTopics>
</div>

<div class="col-xs-6" style="float:right">
    %{--<div class=" panel panel-default">--}%
        %{--<g:if test="${flash.error}">--}%
            %{--<h3>${flash.error}</h3>--}%

        %{--</g:if>--}%

        %{--<g:if test="${flash.message}">--}%
            %{--<h3>${flash.message}</h3>--}%

        %{--</g:if>--}%
    %{--</div>--}%

    <g:render template="inbox" model="[readingItems: readingItems]"/>
</div>


</body>
</html>