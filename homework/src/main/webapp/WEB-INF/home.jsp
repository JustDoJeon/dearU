<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){

				location.href = "/login";

			})

			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
			});



		})
	</script>
	<body>
	이건 과제 전형 시작 테스트를 위해 만들어놓은것 과제 제출 X

		<section id="container">
			<form action="/member/register" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">이메일</label>
					<input class="form-control" type="text" id="userId" name="email" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">닉네임</label>
					<input class="form-control" type="text" id="userPass" name="nickname" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">성별(F , M)</label>
					<input class="form-control" type="text" id="userName" name="gender" />
				</div>
					<div class="form-group has-feedback">
                	<label class="control-label" for="userName">생년월일</label>
                	<input class="form-control" type="text" id="userName" name="birthdate" />
                </div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>

	</body>

</html>