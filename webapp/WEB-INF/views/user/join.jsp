<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	$("#join-form").submit(function(){
		// 1.이름 체크
		if($("#name").val()==""){
			alert("이름은 필수 입력 항목입니다.");
			$("#name").focus();
			return false;
		}
		//2. 아이디 체크
		if($("#id").val()==""){
			alert("아이디는 필수 입력 항목입니다.");
			$("#id").focus();
			return false;
		}
		
		if($("#img-checkemail").is(":visible")==false){
			alert("아이디 중복 체크를 해야합니다.");
			return false;
		}
		
		
		//3. 비밀번호 확인
		if($("input[type='password']").val()==""){
			alert("비밀번호는 필수 입력 항목입니다.");
			$("input[type='password']").focus();
			return false;
		}
		// 4. 약관(체크박스) 확인
		if($("#agree-prov").is(":checked")==false){
			alert("약관동의를 해야 합니다.");
			return false;
		}
		
		return true;
	});
	
	$("#id").change(function(){
		$("#btn-checkemail").show();
		$("#img-checkemail").hide();
	});
	
	//2-2. 중복체크 유무
		$("#btn-checkemail").click(function(){
		var id=$("#id").val();
		if(id==""){
			return;
		}
		
		$.ajax({
			url:"${pageContext.request.contextPath }/user/api/checkid?id=" + id,
			type:"get",		
			dataType:"json",
			data: "",
			success:function(response){
				if(response.data==true){
					alert("이미 존재하는 아이디입니다. 다른 아이디를 사용해주세요.");
					$("#id").val("").focus();
					return;
				}
				
				//사용가능한 이메일
				$("#btn-checkemail").hide();
				$("#img-checkemail").show();
			},
			error:function(xhr,status,e){
				console.error(status+":"+e);
			}
		});
		
	});
});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<c:import url="/WEB-INF/views/include/header.jsp"/>
		</ul>
		<form:form modelAttribute="userVo"  id="join-form" name="joinForm" method="post" action="">
			<label class="block-label" for="name">이름</label>
			<form:input path="name"/>
			<p style="margin:0;padding:0;text-align:left;color:red;font-weight:bold">
						<form:errors path="name"/>
			</p>
				
				
			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="id"/>
				<p style="margin:0;padding:0;text-align:left;color:red;font-weight:bold">
						<form:errors path="id"/>
				</p>
			
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<p style="text-align:center;">
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			</p>
			<label class="block-label" for="password">패스워드</label>
			<form:password path="password" />
				<p style="margin:0;padding:0;text-align:left;color:red;font-weight:bold">
						<form:errors path="password"/>
				</p>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">
		</form:form>
	</div>
</body>
</html>
