<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="starter-template">
    <h1><spring:message code="login.done"/></h1>
    <p class="lead">${authInfo.userId}님 환영합니다. <a href="<c:url value='/'/>">[<spring:message code="go.main"/>]</p>
</div>

