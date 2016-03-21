<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h1>${user.name}</h1>

<button type="button" class="btn btn-primary btn-large" data-toggle="modal" data-target="#myModal">Launch demo modal</button>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="purchaseLabel">Purchase</h4>
                </div>
                <div class="modal-body">
                    sup?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Purchase</button>
                </div>
            </div>
        </div>
    </div>

<c:forEach items="${user.blogs}" var="blog">
	<h1>${blog.name}</h1>
	<p>${blog.url}</p>

	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link></th>
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${item.link}</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>

</c:forEach>

