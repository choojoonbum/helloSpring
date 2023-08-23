<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form cssClass="form-signin needs-validation" modelAttribute="loginCommand" novalidate="true">
    <h1 class="h3 mb-3 font-weight-normal"><spring:message code="login.title"/></h1>
    <form:errors cssClass="alert alert-success" element="div"/>
    <form:input path="userId" cssClass="form-control" placeholder="아이디" cssErrorClass="form-control is-invalid" />
    <form:errors path="userId" cssClass="invalid-feedback" element="div"/>
    <form:password path="password" cssClass="form-control" placeholder="비밀번호" cssErrorClass="form-control is-invalid" />
    <form:errors path="password" cssClass="invalid-feedback" element="div"/>
    <div class="checkbox mb-3">
        <label>
            <form:checkbox path="rememberUserId" /> <spring:message code="rememberId"/>
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login.btn"/></button>
</form:form>

<script src="/static/js/form-validation.js"></script>