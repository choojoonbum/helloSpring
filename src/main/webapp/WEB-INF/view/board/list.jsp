<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fdt" tagdir="/WEB-INF/tags" %>

<div class="float-none">
    <h1>게시글 목록</h1>
</div>
<div class="float-md-right" style="width:100px;margin:10px 0;">
    <a href="<c:url value="/board/register"/>" class="btn btn-primary btn-block">등록</a>
</div>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">조회수</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${boardList.content}" var="row" varStatus="loop">
        <tr>
            <th scope="row">${boardList.totalElements - ((boardList.number * boardList.size) + loop.index)}</th>
            <td><a href="<c:url value="/board/view/"/>${row.boardNo}">${row.title}</a></td>
            <td>${row.visitCount}</td>
            <td><fdt:formatDateTime value="${row.createDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="padding-top: 10px">${pagingStr}</div>

