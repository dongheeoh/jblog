<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<c:choose>
			<c:when test='${param.menu == "main" }'>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin">기본설정</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/write">글작성</a></li>
			</c:when>
			<c:when test='${param.menu == "category" }'>
				<li ><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin">기본설정</a></li>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/write">글작성</a></li>
			</c:when>
			<c:when test='${param.menu == "write" }'>
				<li ><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin">기본설정</a></li>
				<li ><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/write">글작성</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin">기본설정</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/write">글작성</a></li>
			</c:otherwise>
		</c:choose>