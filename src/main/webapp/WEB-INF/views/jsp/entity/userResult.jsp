<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<html>
<head>
    <title>Demo Spring MVC User Handling</title>
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css /bootstrap.min.css'/>
    <script src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<h2>User Registration Result</h2>

    <table>
        <tr>
            <td>First Name (*)</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Last Name (*)</td>
            <td>${user.lastname}</td>
        </tr>
        <tr>
            <td>Last Name (*)</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>Detail </td>
            <td>${user.detail}</td>
        </tr>
        <tr>
            <td>Birth Date </td>
            <td>${user.birthDate}</td>
        </tr>
        <tr>
            <td>Gender </td>
            <td>${user.gender}</td>
        </tr>
        <tr>
            <td>Country (*)</td>
            <td>${user.country}</td>
        </tr>

        <tr>
            <td>No-Smoking (*)</td>
            <td>${user.nonSmoking}</td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit" value="Submit">
            </td>
        </tr>
    </table>

</body>
</html>