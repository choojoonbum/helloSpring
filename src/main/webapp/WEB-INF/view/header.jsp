<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand">HelloSpring</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/'/>">Home</a>
            </li>
            <c:if test="${empty authInfo}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/login'/>">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/user'/>">회원가입</a>
            </li>
            </c:if>
            <c:if test="${!empty authInfo}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/logout'/>">로그아웃</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">마이페이지</a>
            </li>
            </c:if>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-expanded="false">게시판</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="<c:url value='/board'/>">공지사항</a>
                    <a class="dropdown-item" href="#">답글형</a>
                    <a class="dropdown-item" href="#">파일첨부형</a>
                    <a class="dropdown-item" href="#">비회원전용</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>