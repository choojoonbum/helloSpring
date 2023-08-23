<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="starter-template">
    <h1><spring:message code="member.register"/></h1>
    <p><spring:message code="register.done" arguments="${formData.name}"/> </p>
    <p><a href="<c:url value='/main'/>">[<spring:message code="go.main"/>]</a></p>
</div>
