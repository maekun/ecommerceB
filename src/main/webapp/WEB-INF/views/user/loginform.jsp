<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>
</head>
<body>
<!-- login form -->
<div class="row">
	<div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
		<div class="well">
			<form:form modelAttribute="loginUserForm" action="${pageContext.request.contextPath}/login">
				<fieldset>
					<legend>
						ログイン
					</legend>
					<c:if test="${loginErrorMessage != null}">
					<label style="color: red" for="inputError">
						<c:out value="${loginErrorMessage}"/>
					</label>
					</c:if>
					<div class="form-group">
						<label for="inputEmail">メールアドレス:</label>
						<label class="control-label" style="color: red" for="inputError">
							<form:errors name="email" id="inputError"/>
						</label>
						<form:input path="email" id="inputEmail" class="form-control" placeholder="Email"/>
					</div>
					<div class="form-group">
						<label for="inputPassword">パスワード:</label>
						<label class="control-label" style="color: red" for="inputError">
							<form:errors path="password" id="inputError"/>
						</label>
						<form:password path="password" id="inputPassword" class="form-control" placeholder="Password"/>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">ログイン</button>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>

<div class="row">
	<div class="text-center">
		<a href="${pageContext.request.contextPath}/">ユーザ登録はこちら</a>
	</div>
</div>
<!-- end container -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>