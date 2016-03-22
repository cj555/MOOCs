<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


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
				<td><a
					href="<spring:url value="/users/remove/${user.id}.html" />"
					class="btn btn-danger"><abbr> Remove </abbr></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

