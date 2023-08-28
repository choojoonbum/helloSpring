<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="py-5 text-center">
    <h2>게시글 등록</h2>
</div>

<div class="row">
    <div class="col-md-11 order-md-1">
        <h4 class="mb-3">기본정보</h4>
        <form:form modelAttribute="formData" class="needs-validation" novalidate="true" enctype="multipart/form-data">
            <div class="mb-3">
                <label>작성자(아이디)</label> <span style="padding-left: 20px">${authInfo.userId}</span>
            </div>
            <div class="mb-3">
                <label for="title">제목</label>
                <form:input path="title" cssClass="form-control" cssErrorClass="form-control is-invalid" />
                <form:errors path="title" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="mb-3">
                <label for="content">내용</label>
                <form:textarea path="content" cssClass="form-control" cssErrorClass="form-control is-invalid" rows="10" cols="5"/>
                <form:errors path="content" cssClass="invalid-feedback" element="div"/>
            </div>

            <div class="mb-3">
                <label for="content">첨부파일</label>
                <input type="file" name="multiFileList" multiple />
                <div class="file-list"></div>
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">작성완료</button>
        </form:form>
    </div>
</div>
<script src="/static/js/form-validation.js"></script>