<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<br>
<br>
<table class="table table-hover table-bordered">

	<thead>
		<tr class="success">
			<th>user name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td> <a href="<spring:url value="/users/${user.id}.html" />" />
					${user.name}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

