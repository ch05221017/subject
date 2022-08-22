<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
      <%@ page import="com.orderDetail.model.*" %>
        <%@ page import="com.orderMainFile.model.*" %>

          <% OrderDetailService detailSvc=new OrderDetailService(); 
          List<OrderDetailVO> listOrderDetail =detailSvc.getAllOrderDetail();
            pageContext.setAttribute("listOrderDetail", listOrderDetail);

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
              <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
                integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />
              <!-- Theme style -->
              <link rel="stylesheet" href="../css/adminlte.min.css" />
              
              <style>
              .DtailPic{
              width: 250px;
			min-height: 150px;
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
                <nav id="navbar-header" class="main-header navbar navbar-expand navbar-white navbar-light">
                  <!-- Left navbar links -->
                  <ul class="navbar-nav">
                    <!-- 漢堡條 -->
                    <li class="nav-item">
                      <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <!-- 文字區域 -->
                    <li class="nav-item d-none d-sm-inline-block">
                      <a href="#" class="nav-link">
                        賣家中心
                      </a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">

                      <a href="#" class="nav-link">
                        <ion-icon name="arrow-forward-outline"></ion-icon>
                      </a>

                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                      <a href="#" class="nav-link">訂單管理</a>
                    </li>

                  </ul>

                  <!-- Right navbar links -->
                  <ul class="navbar-nav ml-auto">




<!--                     掃描票券icon -->
<!--                     <li class="nav-item"> -->
<!--                       <a class="nav-link" data-widget="" href="#" role="button"> -->
<!--                         <ion-icon name="scan-outline"></ion-icon> -->
<!--                       </a> -->
<!--                     </li> -->

                    <!-- 右邊登出icon -->
                    <li class="nav-item">
                      <a class="nav-link" data-widget="login-out" href="#" role="button">
                        <i class="fas fa-arrow-right-from-bracket"></i>
                      </a>
                    </li>
                  </ul>
                </nav>
                <!-- /.navbar -->


                <!-- Main Sidebar Container 主側邊欄-->
                <aside id="sidebar" class="main-sidebar sidebar-dark-primary elevation-4">
                  <!-- Brand Logo -->
                 <a href="" class="brand-link"> <img src="../img/Frame 6.svg" alt="LetItGo Logo"
													class="brand-image elevation-3"  />
												<span class="brand-text font-weight-light">樂意購</span></a>

                  <!-- Sidebar -->
                  <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                      <div class="image">
                        <img src="../img/SellerPic.png" class="img-circle elevation-2" alt="User Image" />
                      </div>
                      <div class="info">
                        <a href="#" class="d-block">尾玉牛肉麵</a>
                      </div>
                    </div>

                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                      <ul class="nav nav-pills nav-sidebar flex-column"
														data-widget="treeview" role="menu" data-accordion="false">
														<li class="nav-item"><a href="Order.jsp" class="nav-link   active">
																<ion-icon name="newspaper-outline"></ion-icon>
																<p class="btn text-light">
																	訂單管理
																</p>
															</a></li>
														<li class="nav-item menu-open"><a href="product.jsp"
																class="nav-link">
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
                            </div>

                            <!-- tab所有頁面 -->
                            <div class="card-body">
                              <div class="tab-content">

                                <!-- tab下  頁面一(我的銷售頁面) -->
                                <div class="active tab-pane" id="activity">

                                  <!-- 可以下拉的表格，點擊表格會有下拉的訂單明細 -->
                                  <div class="card-body">
                                    <table class="table table-bordered table-hover">
                                      <thead>
                                        <tr>
                                          <th>訂單編號</th>
                                          <th>商品名稱</th>
                                          <th>商品金額</th>
                                          <th>商品數量</th>
                                          <th>商品圖片</th>

                                        </tr>
                                      </thead>

                                      <tbody>

                                        <tr data-widget="expandable-table" aria-expanded="true">

                                                                <%  int rowsPerPage = 5;  //每頁的筆數    
																    int rowNumber=0;      //總筆數
																    int pageNumber=0;     //總頁數      
																    int whichPage=1;      //第幾頁
																    int pageIndexArray[]=null;
																    int pageIndex=0; 
																%>
																
																<%  
																    rowNumber=listOrderDetail.size();
																    if (rowNumber%rowsPerPage !=0)
																         pageNumber=rowNumber/rowsPerPage + 1;
																    else pageNumber=rowNumber/rowsPerPage;    
																
																    pageIndexArray=new int[pageNumber]; 
																    for (int i=1 ; i<=pageIndexArray.length ; i++)
																         pageIndexArray[i-1]=i*rowsPerPage-rowsPerPage;
																%>
																
																<%  try {
																       whichPage = Integer.parseInt(request.getParameter("whichPage"));
																       pageIndex=pageIndexArray[whichPage-1];
																    } catch (NumberFormatException e) { //第一次執行的時候
																       whichPage=1;
																       pageIndex=0;
																      } catch (ArrayIndexOutOfBoundsException e) { //總頁數之外的錯誤頁數
																         if (pageNumber>0){
																              whichPage=pageNumber;
																              pageIndex=pageIndexArray[pageNumber-1];
																         }
																    } 
																%>
																
																<%if (pageNumber>0){%>
																  <b><font>第<%=whichPage%>/<%=pageNumber%>頁</font></b>
																<%}%>

                                                    <c:forEach var="OrderDetailVO" items="${listOrderDetail}"
                                                      begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
                                                      <c:if
                                                        test="${OrderMainFileVO.orderserialnumber == OrderDetailVO.orderserialnumber}">

		                                        <tr>
		                                          <td>${OrderDetailVO.orderserialnumber}</td>
		                                          <td>${OrderDetailVO.itemname}</td>
		                                          <td>${OrderDetailVO.orderdetailprice}</td>
		                                          <td>${OrderDetailVO.orderdetailquantity}</td>
		                                         
		                                          <td>
		                                            <img class="DtailPic"
		                                              src="<%=request.getContextPath()%>/sellers/sellerOrderDetail?action=getImg&itemNo=${OrderDetailVO.itemserialnumber}"
		                                              alt="No image">
		                                          </td>
		                                        </tr>
		                                        </c:if>
		                                        </c:forEach>


                                      </tbody>
                                    </table>
                                    <%@ include file="page2.file" %>
                                  </div>
                                </div> <!-- /.active tab-pane -->
                              </div>
                              <!--/.tab-content-->
                            </div>
                            <!--/.card-body-->
                          </div> <!-- /.tab-content -->
                        </div> <!-- /.col-12 -->
                      </div> <!-- /.row mb-2 -->
                    </div> <!-- /.container-fluid -->
                  </div> <!-- /.content-header -->
                </div> <!-- /.content-wrapper -->



                <!-- ============ Footer段落 ============ -->
                <footer class="main-footer">
                  <!-- 讓footer維持滿的 -->
                  <div class="col-12">
                    <!-- To the right -->
                    <div class="float-right d-none d-sm-inline">Tibame TGA102 第三組</div>
                    <!-- Default to the left -->
                    <strong>Copyright &copy; 2022
                      <!-- 下面連結要不要換成關於我們頁面連結 -->
                      <a href="https://adminlte.io">TEAM LETITGO </a>.
                    </strong>
                    All rights reserved.
                </footer>
                <!-- Control Sidebar -->
                <aside class="control-sidebar control-sidebar-dark">
                  <!-- Control sidebar content goes here -->
                </aside>
                <!-- /.control-sidebar -->
              </div>
              <!-- /.wrapper -->
              <!-- ============ Footer段落 ============ -->






              <!-- jQuery -->
              <script src="../js/jquery.min.js"></script>
              <!-- Bootstrap 4 -->
              <script src="../js/bootstrap.bundle.min.js"></script>
              <!-- AdminLTE App -->
              <script src="../js/adminlte.min.js"></script>
              <!-- ionicon  -->
              <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
              <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
            </body>

            </html>