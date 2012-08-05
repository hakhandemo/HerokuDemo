<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet" type="text/css" media="screen" />
    <title>Listing Tramps</title>
</head>
<body>
<div class="container">
<h1>Tweets from IamSRK</h1>
<c:if test="${not empty tweets}">
 
    <table class="normal-table">
        <thead>
            <tr>
                <th>Date/Time</th>
                <th>Tweet</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="tweet" items="${tweets}">
            <tr>
                <td>${tweet.key}</td>
                <td>${tweet.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
 
</div>
</body>
</html>