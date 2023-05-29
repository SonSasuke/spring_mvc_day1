<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<html>
<head>
    <title>Demo Spring MVC User Form</title>
    <link rel='stylesheet' type='text/css' href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css'/>
    <script src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<!--
<h2>User Registration Form</h2>

    <mvc:form modelAttribute="user" action="result">
        <table>
            <tr tyle="width: 100%">
                <td class="col-6">First Name (*)</td>
                <td class="col-6"><mvc:input path="name" required="true" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><mvc:input path="lastname" required="true" placeholder="Last Name"/></td>
            </tr>
            <tr>
                <td>Password (*)</td>
                <td><mvc:password path="password" required="true" placeholder="Password"/></td>
            </tr>
            <tr>
                <td>Detail </td>
                <td><mvc:textarea path="detail" required="true" placeholder="Detail information"/></td>
            </tr>
            <tr>
                <td>Birth Date </td>
                <td><mvc:input path="birthDate" type="Date"/></td>
            </tr>
            <tr>
                <td>Gender </td>
                <td><mvc:radiobuttons path="gender" items="${genders}"/></td>
            </tr>
            <tr>
                <td>Country (*)</td>
                <td><mvc:select path="country" items="${countries}"/></td>
            </tr>

            <tr>
                <td>No Smoking </td>
                <td><mvc:checkbox path="nonSmoking" checked="true"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-primary" type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </mvc:form> -->
  <div class="container">
    <h2>User Registration Form</h2>
    <form modelAttribute="user" action="result">
        <div class="form-group">
            <label for="name">FirstName:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter FirstName" name="name">
        </div>
        <div class="form-group">
            <label for="lastname">LastName:</label>
            <input type="text" class="form-control" id="lastname" placeholder="Enter LastName" name="lastname">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="detail">Details:</label>
            <input type="text" class="form-control" id="detail" placeholder="Enter Details" name="detail">
        </div>
        <div class="form-group">
            <label for="birthDate">Birth Date:</label>
            <input type="date" class="form-control" id="birthDate"  name="birthDate">
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <div style="margin: 10px" class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                <label class="form-check-label" for="inlineRadio1">1</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                <label class="form-check-label" for="inlineRadio2">2</label>
            </div>
        </div>
        <div class="form-group">
            <label for="country">Country:</label>
            <select class="form-select" aria-label="Select Country">
                <option selected>Open this select menu</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>

        </div>
        <div  style="margin: 10px; margin-left: -1px" class="form-group">
            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
            <label class="form-check-label" for="flexCheckDefault">
                Non Smoking
            </label>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>