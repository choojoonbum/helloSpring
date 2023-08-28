<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fdt" tagdir="/WEB-INF/tags" %>
<div class="container-fluid px-4">
    <h1 class="mt-4">게시글 상세</h1>
    <div class="card mb-4">
        <div class="card-body">
            <form>
                <div class="mb-3">
                    <label for="witer" class="form-label">title</label> <input
                        type="text" class="form-control" id="witer" name="witer"
                        value="${board.user.userId}" disabled>
                </div>

                <div class="mb-3">
                    <label for="title" class="form-label">title</label> <input
                        type="text" class="form-control" id="title" name="title"
                        value="${board.title}" disabled>
                </div>
                <div class="mb-3">
                    <label class="form-label">content</label>
                    <div class="card">
                        <div class="card-body">
                            ${board.content}
                        </div>
                    </div>
                </div>
                <c:forEach var="img" items="${attachList}">
                <div class="mb-3 card" style="width: 18rem;">
                    <img src="<c:url value="/display?filename=${img.uploadPath}/${img.changeFile}"/>" class="card-img-top" >
                </div>
                </c:forEach>
                <div class="mb-3">
                    <label class="form-label">regDate</label> <br>
                    <span><fdt:formatDateTime value="${board.createDate}" pattern="yyyy-MM-dd hh:mm:ss" /></span>
                </div>

                <a href="<c:url value="/board"/>" class="btn btn-outline-secondary">list</a>

                <c:if test="${!empty authInfo.userNo && (board.user.userNo == authInfo.userNo)}">
                <a href="<c:url value="/board/modify/${board.boardNo}"/>" class="btn btn-outline-warning">modify</a>
                <a href="<c:url value="/board/remove/${board.boardNo}"/>" class="btn btn-outline-danger"
                   onclick="return confirm('삭제하시겠습니까?')">remove</a>
                </c:if>
            </form>
        </div>
    </div>
</div>