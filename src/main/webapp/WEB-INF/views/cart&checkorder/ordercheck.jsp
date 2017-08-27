<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/common.jsp" %>
</head>
<body>
		<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
				<h3 class="text-center">注文内容確認</h3>
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>
								<div class="text-center">
									商品名
								</div>
							</th>
							<th>
								<div class="text-center">
									サイズ、価格(税抜)、数量
								</div>
							</th>
							<th>
								<div class="text-center">
									トッピング、価格(税抜)
								</div>
							</th>
							<th>
								<div class="text-center">
									小計
								</div>
							</th>
						</tr>
						<c:forEach var="orderItem" items="${a}">
							<tr>
								<td>
									<div class="center">
										<img src="${a}"
											class="img-responsive img-rounded" width="100" height="300"><br>
										<c:out value="${s}"/>
									</div>
								</td>
								<td>
									<span class="price">&nbsp;Ｌ</span>&nbsp;&nbsp;<c:out value=""/>円
									&nbsp;&nbsp;<c:out value="${a}"/>個
								</td>
								<td>
									<ul>
										<c:forEach var="topping" items="${a}">
											<li>
												<c:out value="${topping.}"/>
											</li>
										</c:forEach>
									</ul>
								</td>
								<td>
									<div class="text-center">
										<c:out value="${a}"/>円
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="form-group text-center">
					<span id="total-price">消費税：<fmt:formatNumber value="${a}" pattern="###,###"/>円</span><br>
					<span id="total-price">ご注文金額合計：<fmt:formatNumber value="${a}" pattern="###,###"></fmt:formatNumber> (税込)</span>
				</div>
			</div>
		</div>
		<form:form modelAttribute="orderForm" action="${pageContext.request.contextPath}/">
			<div class="row">
				<div
					class="table-responsive col-lg-offset-3 col-lg-6 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
					<h3 class="text-center">お届け先情報</h3>
						<table class="table table-striped">
							<tbody>
								<tr>
									<td>
										<div class="text-center">
											お名前
										</div>
									</td>
									<td>
										
										<form:input path="destinationName"/>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											メールアドレス
										</div>
									</td>
									<td>
										<form:input path="destinationEmail"/>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											郵便番号
										</div>
									</td>
									<td>
										<form:input path="destinationZipcode"/>&nbsp;&nbsp;<button>住所検索</button>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											住所
										</div>
									</td>
									<td>
										<form:input path="destinationAddress"/>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											電話番号
										</div>
									</td>
									<td>
										<form:input path="destinationTel"/>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											配達日時
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-12">
													<label
														class="control-label" style="color: red" for="inputPeriod">配達日時を入力してください</label>
												</div>
												<div class="col-sm-5">
													<input type="date" name="orderDate" id="name"
														class="form-control input-sm" />
												</div>
												
											</div>
											<div class="row">
												<div class="col-sm-12">
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" checked="checked" value="10">
														10時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="11"> 
														11時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="12"> 
														12時
													</label><br>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="13"> 
														13時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="14"> 
														14時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="15"> 
														15時
													</label><br>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="16"> 
														16時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="17"> 
														17時
													</label>
													<label class="radio-inline"> 
														<input type="radio"
															name="deliveryTime" value="18"> 
														18時
													</label><br>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					
				</div>
			</div>
		
			<div class="row">
				<div
					class="table-responsive col-lg-offset-3 col-lg-6 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
					<h3 class="text-center">お支払い方法</h3>
					
						<table class="table table-striped">
							<tbody>
								<tr>
									<td>
										<div class="text-center">
											代金引換
										</div>
									</td>
									<td>
										<div class="row">
											<div class="col-sm-12">
												<label class="radio-inline"> 
													<input type="radio"
														name="paymentethod" checked="checked" value="1">
													代金引換
												</label>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="text-center">
											クレジットカード決済
										</div>
									</td>
									<td align="center">
										<div class="row">
											<div class="col-sm-12">
												<label class="radio-inline"> 
													<input type="radio"
														name="paymentethod" checked="checked" value="2">
													クレジットカード
												</label><br><br>
											</div>
										</div>
										<script src="https://checkout.webpay.jp/v3/" class="webpay-button" data-key="test_public_87Aa3Pe1r1XffA3dwB8TH690" data-lang="ja" data-partial="true"></script>
									</td>
								</tr>
							</tbody>
						</table>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-offset-4 col-xs-4">
					<div class="form-group">
							<input class="form-control btn btn-warning btn-block"
								type="submit" value="この内容で注文する">
					</div>
				</div>
			</div>
			</form:form>
		
		
</body>
</html>