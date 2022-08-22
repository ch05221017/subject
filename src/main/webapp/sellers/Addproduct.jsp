<%@page import="subject.vo.*" %>
<%@page import="subject.dao.*" %>
<%@page import="subject.service.impl.Itemservice" %>
<%@page import="subject.service.impl.Itemcateservice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%itemvo itemvo=(itemvo) request.getAttribute("itemvo");%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />z
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>樂意購 | 賣家後台</title>
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
	<!-- Font Awesome Icons -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
		integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- Theme style -->
	<link rel="stylesheet" href="../css/adminlte.min.css" />

	<style type="text/css">
		/* 圖片預覽css */
		#preview {
			border: 1px solid lightgray;
			display: inline-block;
			width: 400px;
			min-height: 300px;
		}

		#preview span.text {
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
			z-index: -1;
			color: lightgray;
		}

		#preview img.preview_img {
			width: 100%;

		}

		.my-pic {
			width: 400px;
			min-height: 300px;

		}

		/* 模板改顏色 */
		.main-sidebar {
			background-color: rgb(26, 60, 64);
		}

		#navbar-header,
		.card-body,
		.card-header,
		#Picfile {
			background-color: rgb(237, 230, 219);
		}

		.btn-primary {
			background-color: rgb(65, 125, 122);
		}

		.nav-pills .nav-link.active,
		.nav-pills .show>.nav-link {
			color: #fff;
			background-color: rgb(65, 125, 122);
		}

		.sidebar-dark-primary .nav-sidebar>.nav-item>.nav-link.active,
		.sidebar-light-primary .nav-sidebar>.nav-item>.nav-link.active {
			background-color: rgb(65, 125, 122);
			color: #fff;
		}

		.nav-pills .nav-link.active,
		.nav-pills .show>.nav-link {
			color: #fff;
			background-color: rgb(29, 92, 99);
		}

		.nav-pills .nav-link:not(.active):hover {
			color: rgb(29, 92, 99);
		}

		.btn-primary:hover {
			color: #fff;
			background-color: rgb(152, 216, 213);
			border-color: rgb(152, 216, 213);
		}

		.btn-primary.focus,
		.btn-primary:focus {
			color: #fff;
			background-color: rgb(152, 216, 213);
			border-color: rgb(152, 216, 213);
			box-shadow: 0 0 0 0 rgba(38, 143, 255, 0.5);
		}

		.btn-primary.disabled,
		.btn-primary:disabled {
			color: #fff;
			background-color: rgb(29, 92, 99);
			border-color: rgb(29, 92, 99);
		}

		.btn-primary:not(:disabled):not(.disabled).active,
		.btn-primary:not(:disabled):not(.disabled):active,
		.show>.btn-primary.dropdown-toggle {
			color: #fff;
			background-color: rgb(29, 92, 99);
			border-color: rgb(29, 92, 99);
		}
	</style>


</head>

<body class="hold-transition sidebar-mini">

	<!-- 主要開發區塊 -->
	<div class="wrapper">

		<!-- Navbar header區塊-->
		<nav id="navbar-header"
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<!-- 漢堡條 -->
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="#"
						role="button"><i class="fas fa-bars"></i></a></li>
				<!-- 文字區域 -->
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
						class="nav-link"> 賣家中心</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
						class="nav-link">
						<ion-icon name="arrow-forward-outline"></ion-icon>
					</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#"
						class="nav-link">商品管理</a></li>
			</ul>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">

				<!-- 掃描票券icon -->
				<!--<li class="nav-item"><a class="nav-link" data-widget="" href="#" -->
				<!-- role="button"> -->
				<!-- <ion-icon name="scan-outline"></ion-icon> -->
				<!-- </a></li> -->



				<!-- 右邊登出icon -->
				<li class="nav-item"><a class="nav-link" data-widget="login-out"
						href="../index.jsp" role="button"> <i
							class="fas fa-arrow-right-from-bracket"></i>
					</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->


		<!-- Main Sidebar Container 主側邊欄-->
		<aside id="sidebar" class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="../index.jsp" class="brand-link"> <img src="../img/Frame 6.svg"
					alt="LetItGo Logo" class="brand-image elevation-3" />
				<span class="brand-text font-weight-light">樂意購</span></a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="../img/SellerPic.png" class="img-circle elevation-2"
							alt="User Image" />
					</div>
					<div class="info">
						<a class="d-block">尾玉牛肉麵</a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<li class="nav-item"><a href="Order.jsp" class="nav-link">
								<ion-icon name="newspaper-outline"></ion-icon>
								<p class="btn text-light">
									訂單管理
								</p>
							</a></li>
						<li class="nav-item menu-open"><a href="product.jsp"
								class="nav-link active">
								<ion-icon name="fast-food-outline"></ion-icon>
								<p class="btn text-light">
									商品管理
								</p>
							</a></li>

						<li class="nav-item">
							<a href="#" class="nav-link">
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/sellers/sellerUpdateServlet">
									<ion-icon name="home-outline"></ion-icon>
									<button class="btn text-light"
										type="submit">帳戶管理</button>
									<input type="hidden" name="SELLER_SERIAL_NUMBER"
										value="${seller.serialnumber}">
									<input type="hidden" name="action"
										value="sellerGetForUpdate">
								</FORM>
							</a>
						</li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content 主頁面欄位-->

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<!-- Main content -->
						<!-- 整塊主欄 -->
						<div class="col-12">
							<div class="card">
								<!-- tab那一條 -->
								<div class="card-header p-2">
									<ul class="nav nav-pills">
										<li class="nav-item"><a class="nav-link"
												href="product.jsp">我的商品</a></li>
										<li class="nav-item"><a class="nav-link active"
												href="Addproduct.jsp">新增/更新商品 </a>
										</li>
									</ul>
								</div>


								<!-- tab所有頁面 -->
								<div class="card-body">

									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/sellers/itemservlet"
										name="form1" enctype="multipart/form-data">
										<!-- tab下  頁面二(商品新增/更新頁面) -->
										<div class="tab-pane" id="timeline">



											<!-- 標題 -->
											<div class="card-header">
												<h3 class="card-title">
													<i class="fas fa-edit"></i>
													新增商品
												</h3>
											</div>
											<%-- 錯誤表列 --%>
												<c:if test="${not empty errorMsgs}">
													<font
														style="color:rgb(204, 10, 10)">
														請修正以下錯誤:
													</font>
													<ul>
														<c:forEach var="message"
															items="${errorMsgs}">
															<li
																style="color:rgb(204, 10, 10)">
																${message}</li>
														</c:forEach>
													</ul>
												</c:if>
												<div class="card-body">

													<!-- 下拉選單 -->
													<div class="row">

														<div class="col-4">
															<div class="form-group">
																<label
																	for="exampleSelectBorder">種類</label>
																<jsp:useBean
																	id="itemcateSvc"
																	scope="page"
																	class="subject.service.impl.Itemcateservice" />
																<select
																	class="custom-select form-control-border"
																	name="item_category_number">
																	<c:forEach
																		var="Itemcatevo"
																		items="${itemcateSvc.all}">
																		<option
																			value="${Itemcatevo.categoryno}"
																			${("itemvo.categoryno"
																			eq "Itemcatevo.categoryno"
																			)? "selected":''}>
																			${Itemcatevo.mainname}
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-12">
															<div class="form-group">
																<label>商品名稱</label>
																<input type="TEXT"
																	id="name"
																	name="item_name"
																	size="45"
																	class="form-control"
																	value="<%= (itemvo==null)? "" : itemvo.getName()%>" />
															</div>
														</div>

													</div>

													<div class="row">
														<div class="col-12">
															<div class="form-group">
																<label>商品敘述</label>
																<input type="TEXT"
																	id="discription"
																	class="form-control"
																	name="item_description"
																	size="45"
																	value="<%= (itemvo==null)? "" : itemvo.getDescription()%>" />
															</div>
														</div>
													</div>

													<div class="row">

														<div class="col-4">
															<div class="form-group ">
																<label>市售價格</label>
																<input type="text"
																	id="localPrice"
																	class="form-control"
																	value="">
															</div>
														</div>

														<div class="col-4">
															<div class="form-group">
																<label>促銷價格</label>
																<input type="text"
																	id="price" size="45"
																	name="item_price"
																	class="form-control"
																	value="<%= (itemvo==null)? "" : itemvo.getPrice()%>" />
															</div>
														</div>

														<div class="col-4">
															<div class="form-group">
																<label>商品數量</label>
																<input type="text"
																	id="stock"
																	name="item_stock"
																	class="form-control"
																	value="<%= (itemvo==null)? "" : itemvo.getStock()%>">
															</div>
														</div>

														<div class="col-12">
															<div class="form-group">
																<label>商品圖片：</label>
																<input type="file"
																	id="Picfile"
																	name="photo"
																	class="form-control"
																	multiple />
															</div>
														</div>

														<div class="col-3">
															<div id="preview">
																<span
																	class="text">預覽圖</span>
															</div>
														</div>
													</div>
												</div>

										</div>
										<!--/.card-body -->
										<!-- <button type="submit">資料送出</button> -->
										<div class="row justify-content-end">
											<input type="hidden" name="action"
												value="insert">
											<input class="btn  btn-primary"
												id="addProduct" type="submit"
												value="新增商品">
											<script>
												// 新增商品成功/失敗視窗	
												const name = document.querySelector('#name');
												const discription = document.querySelector('#discription');
												const localPrice = document.querySelector('#localPrice');
												const price = document.querySelector('#price');
												const stock = document.querySelector('#stock');
												document.querySelector('#addProduct').addEventListener('click', () => {
													
													if (name.value.trim() == "" || discription.value.trim() == "" || localPrice.value.trim() == "" || price.value.trim() == "" || stock.value.trim() == "") {

														alert(`新增商品失敗~再檢查一下吧~`);
													} else {
														alert(`新增商品成功`);
													}
												})

												// 圖片上傳
												const myData = {
													img: ''
												}
												document.querySelector('#Picfile').onchange = (e) => {
													let reader = new FileReader();
													reader.readAsDataURL(e.target.files[0]);
													reader.onload = (e) => {
														let img = document.createElement('img')

														// 取得value(為什麼刪掉就不能預覽????????why?????????)
														let res = {
															data: [
																{ img: e.target.result.slice(23) },
															]
														}
														//預覽圖(img.src)
														img.src = e.target.result
														myData.img = e.target.result
														// 添加class
														img.className = 'my-pic'
														// 預覽
														document.querySelector('#preview').append(img)
													}
												}

											</script>

										</div>
									</FORM>

								</div>


							</div>
							<!--/.card card-primary card-outline -->

						</div>
						<!--/.tab-pane2 -->

					</div>
					<!--/.tab-content -->


				</div>
				<!-- /.card-body -->

			</div>
			<!-- /.card -->
		</div>
		<!-- /.col-12(整個tab) -->

	</div>
	<!-- /.row mb-2 -->


	</div>
	<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->
	</div>
	<!-- /.content-wrapper -->
	</div>
	<!-- /.wrapper -->

	<!-- ============ Footer段落 ============ -->
	<footer class="main-footer">
		<!-- 讓footer維持滿的 -->

		<div class="col-12">
			<!-- To the right -->
			<div class="float-right d-none d-sm-inline">Tibame TGA102 第三組</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2022
				<!-- 下面連結要不要換成關於我們頁面連結 --> <a href="https://adminlte.io">TEAM LETITGO
				</a>.
			</strong> All rights reserved.
	</footer>

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
	</div>
	<!-- /.col -->
	<!-- ============ Footer段落 ============ -->
	<!-- /.content-wrapper -->
	</div>

	<!-- jQuery -->
	<script src="../js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../js/adminlte.min.js"></script>
	<!-- ionicon  -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<!-- sweet alert -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="sweetalert2.all.min.js"></script>
	<link rel="stylesheet" href="sweetalert2.min.css">


</body>

</html>