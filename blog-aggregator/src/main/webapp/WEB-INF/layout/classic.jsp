<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<tilesx:useAttribute name="current" />


<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><tiles:getAsString name="title" /> Blog Aggregator</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Data Science Space</h1>
			<p class="lead">Basic grid layouts to get you familiar with
				building within the Bootstrap grid system.</p>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<a href="http://gate.guokr.com/submit/interest/1/" class="">
					<button type="button" class="btn btn-xs">+</button> <u>大类</u>
				</a>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-6">
				<h5>类</h5>
				<div class="row">
					<div class="col-lg-2">
						<a href="#" id="" class="subClass" rel="popover"
							data-content="This is the body of Popover"
							data-original-title="数学">数学</a>
					</div>
					<div class="col-lg-2">
						<a href="#" class="subClass" rel="popover"
							data-content="This is the body of Popover"
							data-original-title="数学">数学</a>
					</div>
					<div class="col-lg-2">
						<a href="#" class="subClass" rel="popover"
							data-content="This is the body of Popover"
							data-original-title="数学">数学</a>
					</div>
					<div class="col-lg-2">
						<a href="#" id="example4" class="" rel="popover"
							data-content="This is the body of Popover"
							data-original-title="数学">数学</a>
					</div>
					<div class="col-lg-2">
						<a href="#" id="example5" class="" rel="popover"
							data-content="This is the body of Popover"
							data-original-title="数学">数学</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<h5>类</h5>
				<div class="row">
					<div class="col-lg-2">下属类1</div>
					<div class="col-lg-2">下属类1</div>
					<div class="col-lg-2">下属类1</div>
					<div class="col-lg-2">下属类1</div>
					<div class="col-lg-2">下属类1</div>
					<div class="col-lg-2">下属类1</div>
				</div>
			</div>
		</div>

		<div id='intellect' class="title-b">
			<h3>
				<a href="http://gate.guokr.com/submit/interest/1/" class="">
					<button type="submit" class="btn btn-default">+</button>
				</a> 数据源
			</h3>
			<script type="text/javascript">
				$(document).ready(function() {
					$(function() {
						$('.subClass').popover();
					});
				});
			</script>

			<br />
			<ul class="list">
				<li style="overflow: visible; z-index: 0; position: relative;"><a
					data-desc="中文数学杂志《数学文化》网站" target="_blank"
					href="http://www.global-sci.org/mc/">数学文化</a></li>

				<li style="overflow: visible; z-index: 0; position: relative;"><a
					data-desc="著名互联网数学杂志" target="_blank"
					href="http://plus.maths.org/content/">Plus</a></li>
				<a href="#" id="example" class="" rel="popover"
					data-content="This is the body of Popover" data-original-title="数学">数学</a>
			</ul>
		</div>

	</div>

	<!--   <nav class="navbar navbar-inverse navbar-fixed-top">      
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>/.nav-collapse
      </div>
    </nav>

    <div class="container">

      <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      </div>

    </div>/.container -->

	<div class="container">
		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/" />">Blog
						Aggregator</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : ''}"><a
							href='<spring:url value="/" />'>Home</a></li>

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href='<spring:url value="/users.html" />'>Users</a></li>
						</security:authorize>

						<li class="${current == 'register' ? 'active' : ''}"><a
							href='<spring:url value="/register.html" />'>Registration</a></li>

						<security:authorize access="!isAuthenticated()">
							<li class="${current == 'login' ? 'active' : ''}"><a
								href='<spring:url value="/login.html" />'>Login</a></li>
						</security:authorize>

						<security:authorize access="isAuthenticated()">
							<li><a href='<spring:url value="/logout" />'>Logout</a></li>
						</security:authorize>

						<security:authorize access="isAuthenticated()">
							<li><a href='<spring:url value="/account.html" />'>My
									account</a></li>
						</security:authorize>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="./">Default</a></li>
						<li><a href="../navbar-static-top/">Static top</a></li>
						<li><a href="../navbar-fixed-top/">Fixed top</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->


			<tiles:insertAttribute name="body" />

			<br> <br>
			<center>
				<tiles:insertAttribute name="footer" />
			</center>
</body>
</html>