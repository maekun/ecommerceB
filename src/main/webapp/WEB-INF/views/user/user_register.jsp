<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>
</head>
<body>
<!-- 
login form -->
<div class="row">
	<div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
		<div class="well">
			<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/register">
				<fieldset>
					<legend>ユーザ登録</legend>
					<div class="form-group">
						<label for="inputName">名前:</label>
						<label style="color: red" for="inputError"><form:errors path="name" id="inputError"/></label>
						<form:input path="name" id="inputName" class="form-control" placeholder="Name"/>
					</div>
					<div class="form-group">
						<label for="inputEmail">メールアドレス:</label>
						<label style="color: red" for="inputError"><form:errors path="email" id="inputError"/></label>
						<form:input path="email" id="inputEmail" class="form-control" placeholder="Email"/>
					</div>
					<div class="form-group">
						<label for="inputAddress">住所:</label>
						<label style="color: red" for="inputError"><form:errors path="address" id="inputError"/></label>
						<form:input path="address" id="inputAddress" class="form-control" placeholder="Address"/>
					</div>
					<div class="form-group">
						<label for="inputTel">電話番号:</label>
						<label style="color: red" for="inputError"><form:errors path="telephone" id="inputError"/></label>
							<form:input path="telephone" id="inputTel" class="form-control" placeholder="Tel"/>
					</div>
					<div class="form-group">
						<label for="inputPassword">パスワード:</label>
						<label style="color: red" for="inputError"><form:errors path="password" id="inputError"/></label>
						<form:password path="password" id="inputPassword" class="form-control" placeholder="Password"/>
					</div>
					<div class="form-group">
						<label for="inputConfirmationPassword">確認用パスワード:</label>
						<label style="color: red" for="inputError"><form:errors path="confirmationPassword" id="inputError"/></label>
						<form:password path="confirmationPassword" id="inputConfirmationPassword" class="form-control" placeholder="Confirmation Password"/>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">登録</button>
						<button type="reset" class="btn btn-primary">クリア</button>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
<!-- end container -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>