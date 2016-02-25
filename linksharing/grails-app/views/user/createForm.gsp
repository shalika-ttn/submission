<%--
  Created by IntelliJ IDEA.
  User: shalika
  Date: 25/2/16
  Time: 10:51 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<head>
    <title></title>
</head>

<body>
<g:hasErrors bean="${user}">
    <div class="alert alert-danger">
        <g:eachError><g:message error="${it}"/> </g:eachError>
    </div>
</g:hasErrors>
<g:renderErrors  bean="${user}"/>

<g:form action="register">
    <lable>FirstName  <g:textField name="myField" value="firstname"/></lable><br>
    <lable>LastName  <g:textField name="myField" value="lastname"/></lable><br>
    <lable>UserName  <g:textField name="myField" value="userame"/></lable><br>
    <lable>Email  <g:textField name="myField" value="email"/></lable><br>
    <lable>Password  <g:passwordField name="myPasswordField" value="password"/></lable><br>
    <g:submitButton name="submit" value="submit"/>

</g:form>
<tl:showAdmin admin="${session.user.admin}">I am Admin</tl:showAdmin>

</body>
</html>