<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
				<c:import url="/WEB-INF/views/include/blogheader.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${mainPost.title }</h4> <!-- ${blog.post_title} for문 list의 [0]번째 post_title -->
					<p>
						${mainPost.contents } <!-- ${blog.content} for문 list의 [0]번째 content -->
					<p>	
				</div>
				<ul class="blog-list">
				<c:forEach items="${postList }" var="vo"> <!-- 포스트 리스트 -->
						<li>
							<c:choose>
								<c:when test="${vo.title == mainPost.title }">
									<a href="${pageContext.request.contextPath}/${authUser.id}/${vo.categoryNo}/${vo.no}" style="color:red">${vo.title }</a> 
									<span  style="color: red">${vo.regDate }</span>
								</c:when>
								
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/${authUser.id}/${vo.categoryNo}/${vo.no}">${vo.title }</a> 
									<span>${vo.regDate }</span>
								</c:otherwise>
							</c:choose>
						</li>	
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${blogVo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryNameList }" var="vo" varStatus="status">
					<li>
						<a href="${pageContext.request.contextPath}/${authUser.id}/${vo.no}">${vo.name }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/include/blogfooter.jsp"/>
		</div>
	</div>
</body>
</html>