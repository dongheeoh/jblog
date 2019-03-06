<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <h1><a style="color:white;'" href="${pageContext.request.contextPath}/${authUser.id}">${blogVo.title }</a></h1>
			<c:choose>
				<c:when test="${empty authUser }">
				<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/user/join">회원가입</a></li>
				</c:when>
			<c:otherwise>
				<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin">블로그관리</a></li>
			</c:otherwise>
			</c:choose>