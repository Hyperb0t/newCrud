<%--
  Created by IntelliJ IDEA.
  User: Vitaly
  Date: 01.03.2020
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.css"/>">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <aside class="col-8">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
                    <hr>
                    <form:form method="POST" modelAttribute="user" id="userform">
                        <p class="text-danger text-center" id="errors"><form:errors path=""/></p>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Email</span>
                                </div>
                                <form:input name="email" class="form-control" placeholder="Email or login" type="email"
                                        id="email" path="email"/>
                            </div>
                            <div class="text-danger"><form:errors path="email"/></div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Password</span>
                                </div>
                                <form:input name="password" class="form-control" placeholder="Password" type="password"
                                        id="password" path="password"/>
                            </div>
                            <div class="text-danger"><form:errors path="password"/></div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Repeat password</span>
                                </div>
                                <form:input name="repassword" class="form-control" placeholder="Repeat password"
                                       type="password" id="repassword" path="repassword"/>
                            </div>
                            <div class="text-danger"><form:errors path="repassword"/></div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Country</span>
                                </div>
                                <form:input name="country" class="form-control" placeholder="Country" type="text"
                                        id="country" path="country"/>
                             </div>
                            <div class="text-danger"><form:errors path="country"/></div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Gender</span>
                                </div>
                                <form:select name="gender" class="form-control" id="gender" path="gender">
                                    <option value="m">Male</option>
                                    <option value="f">Female</option>
                                </form:select>
                            </div>
                            <div class="text-danger"><form:errors path="gender"/></div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Birthday</span>
                                </div>
                                <form:input name="birthday" class="form-control" placeholder="Birthday"
                                            type="date" id="birthday" path="birthday"/>
                            </div>
                            <div class="text-danger"><form:errors path="birthday"/></div>
                        </div>
                        <div class="form-group">
                            <div class="form-check justify-content-center">
                                <form:checkbox name="accept" class="form-check-input" id="accept"
                                            path="agreement"/>
                                <label class="form-check-label text-center" for="accept">
                                    I accept terms of usage
                                </label>
                            </div>
                            <div class="text-danger"><form:errors path="agreement"/></div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block" id="submitButton">Register</button>
                        </div>
                        <p class="text-success text-center">${success}</p>
                    </form:form>
                    <div class="text-center">
                        <p class="my-0">Already have an account?</p>
                        <a class="text-center" href="#">Log in</a>
                    </div>
                </article>
            </div>
        </aside>
    </div>
</div>

</body>
</html>
