<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<br>
<br>


<h1>Latest news from the java world:</h1>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>date</th>
			<th>item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>
					<h5>
						<c:out value="${item.blog.name}" />

					</h5> <br /> <c:out value="${item.publishedDate}" />
				</td>

				<td><strong> <a href="<c:out value="${item.link}" />"
						target="_blank"> <c:out value="${item.title}" />
					</a>
				</strong> <br /> ${item.description}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


