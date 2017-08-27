<%@ page contentType="text/html; charset=UTF-8"%>
<div class="container">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/top/"> <!-- 企業ロゴ --> <img
				alt="main log" src="${pageContext.request.contextPath}/img/header_logo.png" height="35">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<p class="navbar-text navbar-right">
				<a href="${pageContext.request.contextPath}/cart-controller/show" class="navbar-link">ショッピングカート</a>&nbsp;&nbsp;
				<a href="#" class="navbar-link">注文履歴</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/loginform" class="navbar-link">ログイン</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/logout" class="navbar-link">ログアウト</a>
			</p>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
</div>