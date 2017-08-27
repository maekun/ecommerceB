<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/common.jsp" %>

<!-- 商品詳細画面 -->

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<%@ include file="../common/nav.jsp" %>

	<div class="container">
	
		<form:form modelAttribute="orderItemForm" action="${pageContext.request.contextPath}/cart-add-controller/add">
		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">

				<h3 class="text-center">商品詳細</h3>
				<div class="row">
					<div class="col-xs-5">
						<img src="${item.imagePath}" class="img-responsive img-rounded">
					</div>

					<div class="col-xs-5">
						<div class="bs-component">
							<h4><c:out value="${item.name}"/></h4> <br>
							<br>
							<p><c:out value="${item.description}"/></p>
						</div>
					</div>
				</div><br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="inputResponsibleCompany">サイズ</label>
								</div>
								<div class="col-sm-12">
									<label class="radio-inline"> 
										<input type="radio"
											name="size" checked="checked">
										<span class="price">&nbsp;М&nbsp;</span>&nbsp;&nbsp;<c:out value="${item.priceM}"/>円(税抜)
									</label>
									<label class="radio-inline"> 
										<input type="radio"
											name="size"> 
										<span class="price">&nbsp;Ｌ</span>&nbsp;&nbsp;<c:out value="${item.priceL}"/>円(税抜)
									</label>
								</div>
							</div>
						</div>
					</div>
				</div><br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label for="inputResponsibleCompany">
										トッピング：&nbsp;1つにつき
										<span>&nbsp;М&nbsp;</span>&nbsp;&nbsp;200円(税抜)
										<span>&nbsp;Ｌ</span>&nbsp;&nbsp;300円(税抜)
									</label>
								</div>
								<c:forEach var="topping" items="${item.toppingList}" varStatus="status">
	 							<!--<div class="col-sm-12" id="checkbox-sort">  -->
	 									<c:if test="${status.count == 1}">
	 									&nbsp;&nbsp;
	 									</c:if>
										<label class="checkbox-inline">
											<input type="checkbox" name="orderToppingList" value="${topping.id}"><c:out value="${topping.name}"/>
										</label>
								<!--</div>  -->
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<div class="row">
								<div class="col-xs-5 col-sm-5">
									<label for="">数量:</label>
									<!-- <label class="control-label"
										style="color: red" for="inputError">数量を選択してください</label>
									-->
										<form:select class="form-control" path="quantity" items="${quantityMap}"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-8">
						<div class="form-group">
							<span id="total-price">この商品金額：1,490 (税抜)</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-offset-2 col-xs-3">
						<div class="form-group">
							<p>
								<input class="form-control btn btn-warning btn-block"
									type="submit" value="カートに入れる">
							</p>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		</form:form>

	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>

</body>
</html>