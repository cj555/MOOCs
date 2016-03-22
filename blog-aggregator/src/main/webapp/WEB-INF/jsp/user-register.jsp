<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div>
	<br> <br>

</div>

<form:form commandName="user" cssClass="form-horizontal">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful</div>
	</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name: </label>
		<div class="col-sm-5">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" />
		</div>
	</div>

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email: </label>
		<div class="col-sm-5">
			<form:input path="email" cssClass="form-control" />
			<form:errors path="email" />
		</div>
	</div>


	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:
		</label>
		<div class="col-sm-5">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-2">
			<form:button type="Submit" value="Save"
				class="btn btn-lg btn-primary"> Register</form:button>
		</div>
	</div>



</form:form>