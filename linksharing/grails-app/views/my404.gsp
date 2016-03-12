<%--
  Created by IntelliJ IDEA.
  User: shalika
  Date: 12/3/16
  Time: 1:19 PM
--%>
<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Grails</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>

</head>
<body>
<p>Page Not found</p>
<g:if env="development">
    <g:renderException exception="${exception}" />
</g:if>
<g:else>
    <ul class="errors">
        <li>An error has occurred</li>
    </ul>
</g:else>
</body>
</html>
