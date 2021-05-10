<%--
  Created by IntelliJ IDEA.
  User: Ambas
  Date: 5/8/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>miu.edu.com.Quiz Servlet Lab</title>
</head>
<body>
<h1>The Number of miu.edu.com.Quiz</h1>
<p>Current your score is ${score}</p>
<p>Guess the next number in the sequence.</p>
<hr/>
<form method="post">
    Your answer: <p>${nextQuestion}</p>
    <input type="text" name="response" pattern="[0-9]{1,5}"/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
