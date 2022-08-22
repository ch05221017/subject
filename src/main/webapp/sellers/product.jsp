<%@page import="subject.vo.itemvo" %>
	<%@page import="subject.service.impl.Itemservice" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<%@ page import="java.util.*" %>

					<% Itemservice itemSvc=new Itemservice(); List<itemvo> list = itemSvc.getAll();
						pageContext.setAttribute("list", list);
						%>


						<!DOCTYPE html>
						<html lang="en">

						<head>
							<meta charset="utf-8" />
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
							<style>
								/* 圖片拖曳css */
								#drop_zone {
									border: 1px dashed #ccc;
									height: 50px;
									/* position: relative; */
								}

								#drop_zone span.text {
									/* position: absolute; */
									/* display: inline-block; */
									left: 50%;
									top: 50%;
									transform: translate(-50%, -50%);
									z-index: -1;
									color: lightgray;
								}

								#drop_zone.-on {
									border: 1px dashed lightblue;
									box-shadow: 3px 3px 5px lightblue inset, -3px -3px 5px lightblue inset;
								}

								/* 圖片預覽css */
								#preview {
									border: 1px solid lightgray;
									display: inline-block;
									width: 250px;
									min-height: 150px;

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

								.itempic {
									width: 200px;
									min-height: 100px;

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
										<li class="nav-item d-none d-sm-inline-block"><a href="#" class="nav-link"> 賣家中心
											</a></li>
										<li class="nav-item d-none d-sm-inline-block"><a href="#" class="nav-link">
												<ion-icon name="arrow-forward-outline"></ion-icon>
											</a></li>
										<li class="nav-item d-none d-sm-inline-block"><a href="#"
												class="nav-link">商品管理</a></li>

									</ul>

									<!-- Right navbar links -->
									<ul class="navbar-nav ml-auto">

										<!-- 										掃描票券icon -->
										<!-- 										<li class="nav-item"><a class="nav-link" data-widget="" href="#" role="button"> -->
										<!-- 												<ion-icon name="scan-outline"></ion-icon> -->
										<!-- 											</a></li> -->



										<!-- 右邊登出icon -->
										<li class="nav-item"><a class="nav-link" data-widget="login-out" href="./logout"
												role="button"> <i class="fas fa-arrow-right-from-bracket"></i>
											</a></li>
									</ul>
								</nav>
								<!-- /.navbar -->


								<!-- Main Sidebar Container 主側邊欄-->
								<aside id="sidebar" class="main-sidebar sidebar-dark-primary elevation-4">
									<!-- Brand Logo -->
									<a href="" class="brand-link"> <img src="../img/Frame 6.svg" alt="LetItGo Logo"
											class="brand-image elevation-3" />
										<span class="brand-text font-weight-light">樂意購</span></a>

									<!-- Sidebar -->
									<div class="sidebar">
										<!-- Sidebar user panel (optional) -->
										<div class="user-panel mt-3 pb-3 mb-3 d-flex">
											<div class="image">
												<img src="../img/SellerPic.png" class="img-circle elevation-2"
													alt="User Image" />
											</div>
											<div class="d-block">
												<a class="d-block">尾玉牛肉麵</a>
											</div>
										</div>

										<!-- Sidebar Menu -->
										<nav class="mt-2">
											<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview"
												role="menu" data-accordion="false">

												<li class="nav-item"><a href="Order.jsp" class="nav-link">
														<ion-icon name="newspaper-outline"></ion-icon>
														<p class="btn text-light">
															訂單管理
														</p>
													</a></li>
												<li class="nav-item menu-open"><a href="product.jsp"
														class="nav-link  active">
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
															<button class="btn text-light" type="submit">帳戶管理</button>
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
																<li class="nav-item"><a class="nav-link active"
																		href="product.jsp">我的商品</a>
																</li>
																<li class="nav-item"><a class="nav-link"
																		href="Addproduct.jsp">新增/更新商品
																	</a>
																</li>
															</ul>
														</div>


														<!-- tab所有頁面 -->
														<div class="card-body">
															<div class="tab-content">
																<!-- tab下  頁面一(我的商品頁面) -->
																<div class="active tab-pane" id="activity">

																	<table class="table table-head-fixed text-nowrap">
																		<thead>
																			<tr>
																				<th
																					style="background-color: rgb(237,230,219);">
																					商品名稱</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					商品圖示</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					商品描述</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					市售價格</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					促銷價格</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					數量</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																					操作</th>
																				<th
																					style="background-color: rgb(237,230,219);">
																				</th>
																			</tr>
																		</thead>

																		<tbody>
																			<%@ include file="page1.file" %>
																				<c:forEach var="itemvo" items="${list}"
																					begin="<%=pageIndex%>"
																					end="<%=pageIndex+rowsPerPage-1%>">
																					<tr>

																						<td>${itemvo.name}</td>
																						<td>
																							<img src="<%=request.getContextPath()%>/sellers/itemservlet?action=getImg&itemNo=${itemvo.serialnumber}"
																								alt="no image"
																								class="itempic">
																						</td>
																						<td>${itemvo.description}</td>
																						<td>${Math.round(itemvo.price/0.9)}</td>
																						<td>${itemvo.price}</td>
																						<td>${itemvo.stock}</td>

																					
																						<td>

																							<FORM METHOD="post"
																								ACTION="<%=request.getContextPath()%>/sellers/itemservlet"
																								style="margin-bottom: 0px;">
																								<input type="submit"
																									value="更新"
																									class="btn  btn-primary">
																								<input type="hidden"
																									name="item_serial_number"
																									value="${itemvo.serialnumber}">
																								<input type="hidden"
																									name="action"
																									value="getOne_For_Update">
																							</FORM>
																						</td>
																						<td>
																							<FORM METHOD="post"
																								ACTION="<%=request.getContextPath()%>/sellers/itemservlet"
																								style="margin-bottom: 0px;">
																								<input type="submit"
																									value="刪除"
																									id="deleteProduct"
																									class="btn  btn-primary"
																									onClick="delcfm()">
																								<input type="hidden"
																									name="item_serial_number"
																									value="${itemvo.serialnumber}">
																								<input type="hidden"
																									name="action"
																									value="delete">
																							</FORM>
																						</td>
																					</tr>
																				</c:forEach>
																		</tbody>
																	</table>
																	<%@ include file="page2.file" %>

																		<script>
																	    function delcfm() { 
																	        if (!confirm("確定要刪除此商品嗎？")) {
																	            window.event.returnValue = false; 
																	        } 
																	    }

																		</script>

																</div>
																<!-- /.tab-pane1 -->


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
										<!-- 下面連結要不要換成關於我們頁面連結 --> <a href="https://adminlte.io">TEAM LETITGO </a>.
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
							<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


						</body>

						</html>