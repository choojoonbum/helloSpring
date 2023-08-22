<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<main role="main" class="container">

    <div class="py-5 text-center">
        <h2>회원 가입</h2>
    </div>

    <div class="row">
        <div class="col-md-11 order-md-1">
            <h4 class="mb-3">기본정보</h4>
            <form method="post" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label for="userId">아이디</label>
                    <input type="text" class="form-control" id="userId" name="userId" required>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="confirmPassword">비밀번호 확인</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>

                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                </div>

                <button class="btn btn-primary btn-lg btn-block" type="submit">회원등록</button>
            </form>
        </div>
    </div>

</main>
<script src="/static/js/form-validation.js"></script>