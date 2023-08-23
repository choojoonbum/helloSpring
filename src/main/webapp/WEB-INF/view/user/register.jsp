<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="py-5 text-center">
    <h2><spring:message code="member.register"/></h2>
</div>

<div class="row">
    <div class="col-md-11 order-md-1">
        <h4 class="mb-3">기본정보</h4>
        <form:form modelAttribute="formData" class="needs-validation" novalidate="true">
            <div class="mb-3">
                <label for="userId">아이디</label>
                <form:input path="userId" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                <form:errors path="userId" cssClass="invalid-feedback" element="div"/>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="password">비밀번호</label>
                    <form:password path="password" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                    <form:errors path="password" cssClass="invalid-feedback" element="div"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="confirmPassword">비밀번호 확인</label>
                    <form:password path="confirmPassword" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                    <form:errors path="confirmPassword" cssClass="invalid-feedback" element="div"/>
                </div>
            </div>

            <div class="mb-3">
                <label for="name">이름</label>
                <form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                <form:errors path="name" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="mb-3">
                <label for="email">Email</label>
                <form:input path="email" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                <form:errors path="email" cssClass="invalid-feedback" element="div"/>
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">회원등록</button>
        </form:form>
    </div>
</div>

<script src="/static/js/form-validation.js"></script>