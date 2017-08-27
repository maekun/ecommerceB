<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/common.jsp" %>

<!-- 商品一覧画面(トップ画面) -->

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<%@ include file="../common/nav.jsp" %>

	<div class="container">
		<!-- search form -->
		<div class="row">
			<div
				class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">商品を検索する</div>
					</div>
					<div class="panel-body">
						<form:form modelAttribute="searchForm" action="${pageContext.request.contextPath}/top/search" class="form-horizontal">
							<div class="form-group">
								<label for="code" class="control-label col-sm-2">商品名</label>
								<div class="col-sm-9">
									<form:input path="searchWord" id="code" class="form-control input-sm" placeholder="商品名のキーワードを入れてください　(例:じゃが　チーズ　ベーコン)"/>
								</div>
							</div>
							<div class="text-center">
								<button type="submit" value="検索" class="btn btn-primary">検索</button>
								<button type="reset" value="クリア" class="btn btn-default">クリア</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

		<!-- table -->
		<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
				<table class="table table-striped">
					<tbody>
					
					<!-- 商品一覧画面(トップ画面) -->
					
						<c:if test="${notFound != null}">
							<div align="center"><font size="20" color="red" face="ＭＳ ゴシック"><c:out value="${notFound}"/></font></div><br>
							<br>
						</c:if>

						<c:forEach var="item" items="${itemList}" varStatus="status">
							<c:if test="${status.count % 3 == 1}">
								<tr>
							</c:if>
							
							<th>
								<a href="${pageContext.request.contextPath}/item-detail-controller/show?id=<c:out value="${item.id}"/>">
								<img src="${item.imagePath}"
										class="img-responsive img-rounded" width="200" height="600"></a><br>
								<a href="${pageContext.request.contextPath}/item-detail-controller/show?id=<c:out value="${item.id}"/>"><c:out value="${item.name}"/></a><br>
								<span class="price">&nbsp;М&nbsp;</span>&nbsp;&nbsp;<fmt:formatNumber value="${item.priceM}" pattern="###,###"/>円(税抜)<br>
								<span class="price">&nbsp;Ｌ</span>&nbsp;&nbsp;<fmt:formatNumber value="${item.priceM}" pattern="###,###"/>円(税抜)<br>
							</th>
							
							<c:if test="${status.count % 3 == 0 }">
								</tr>
							</c:if>
							
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>