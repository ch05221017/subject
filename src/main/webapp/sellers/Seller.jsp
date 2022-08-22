<%@page import="javax.persistence.metamodel.SetAttribute" %>
  <%@page import="web.vo.Seller" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <%@ page import="java.util.*" %>

        <%Seller seller=(Seller)request.getAttribute("seller");%>
          <!DOCTYPE html>
          <html>
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
                      <!-- <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false"> -->
                      賣家中心
                    </a>
                  </li>
                  <li class="nav-item d-none d-sm-inline-block">

                    <a href="#" class="nav-link">
                      <ion-icon name="arrow-forward-outline"></ion-icon>
                    </a>

                  <li class="nav-item d-none d-sm-inline-block">
                    <a href="#" class="nav-link">帳戶管理</a>
                  </li>
                </ul>

                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">

                  <!-- 掃描票券icon -->
                  <li class="nav-item">
                    <a class="nav-link" data-widget="" href="#" role="button">
                      <ion-icon name="scan-outline"></ion-icon>
                    </a>
                  </li>


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
                <a href="#" class="brand-link">
                  <img src="../img/Frame 6.svg" alt="LetItGo Logo" class="brand-image elevation-3"
                    style="opacity: 0.8" />
                  <span class="brand-text font-weight-light">樂意購</span>
                </a>

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
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                      data-accordion="false">
                      <li class="nav-item"><a href="Order.jsp" class="nav-link">
                          <ion-icon name="newspaper-outline"></ion-icon>
                          <p class="btn text-light">
                            訂單管理
                          </p>
                        </a></li>
                      <li class="nav-item menu-open"><a href="product.jsp" class="nav-link">
                          <ion-icon name="fast-food-outline"></ion-icon>
                          <p class="btn text-light">
                            商品管理
                          </p>
                        </a></li>

                      <li class="nav-item">
                        <a href="#" class="nav-link   active">
                          <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/sellers/sellerUpdateServlet">
                            <ion-icon name="home-outline"></ion-icon>
                            <button class="btn text-light" type="submit">帳戶管理</button>
                            <input type="hidden" name="SELLER_SERIAL_NUMBER" value="${seller.serialnumber}">
                            <input type="hidden" name="action" value="sellerGetForUpdate">
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
                              <li class="nav-item"><a class="nav-link active" href="#activity"
                                  data-toggle="tab">我的資訊</a></li>

                              <li class="nav-item"><a class="nav-link" href="../blacklist/listAllBlacklist.jsp">黑名單</a>
                              </li>
                            </ul>
                          </div>

                          <!-- tab所有頁面 -->
                          <div class="card-body">
                            <div class="tab-content">
                              <!-- tab下  頁面一(我的資訊頁面) -->
                              <div class="active tab-pane" id="activity">
                                <div class="card card-info">

                                  <div class="card-body">

                                    <FORM METHOD="post"
                                      ACTION="<%=request.getContextPath()%>/sellers/sellerUpdateServlet" name="form1"
                                      class="form-horizontal">

                                      <!-- 基本資料 -->
                                      <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label">公司名稱</label>
                                        <div class="col-10">
                                          <input type="TEXT" class="form-control" name="company_name" size="45"
                                            value="<%=seller.getName()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">統一編號</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="id_number" size="45"
                                            value="<%=seller.getIdnumber()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">電子信箱</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="seller_email" size="45"
                                            value="<%=seller.getEmail()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">公司負責人</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="company_holder" size="45"
                                            value="<%=seller.getHolder()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">負責人身份證字號</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="company_holder_id" size="45"
                                            value="<%=seller.getHolderid()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">公司電話</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="seller_phone_number" size="45"
                                            value="<%=seller.getPhone()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">登記地址</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="seller_main_address" size="45"
                                            value="<%=seller.getMainaddress()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">分店資訊</label>

                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="seller_branch_address" size="45"
                                            value="<%=seller.getBranchaddress()%>" />
                                        </div>
                                      </div>

                                      <div class="form-group row">
                                        <label for="inputPassword3" class="col-sm-2 col-form-label">公司介紹</label>
                                        <div class="col-sm-10">
                                          <input type="TEXT" class="form-control" name="store_description" size="45"
                                            value="<%=seller.getDescription()%>">
                                        </div>
                                      </div>

                                      <div class="form-group row justify-content-end">
                                        <input type="hidden" name="action" value="sellerUpdate">
                                        <input id="sellerUpdate" class="btn  btn-primary" type="submit" value="更新資料">
                                      </div>
                                      <div>
                                        ${SellerUpdateMsg}
                                      </div>

                                    </FORM>
                                    <script>
                                      // 更新完成視窗										
                                      document.querySelector('#sellerUpdate').addEventListener('click', () => {
                                        alert(`更新資訊完成`);
                                      })
                                    </script>

                                  </div>


                                </div>






                              </div>
                              <!--/.card-body-->
                            </div>
                            <!--/.card card-info-->


                          </div> <!-- /.tab-pane1 -->


                          <!-- tab下  頁面三(黑名單頁面) -->
                          <div class="tab-pane" id="settings">
                          </div>
                          <!---tab-pane3 -->

                        </div>
                        <!--/.tab-content -->

                      </div> <!-- /.card-body -->
                    </div> <!-- /.card -->


                  </div> <!-- /.col-12(主欄) -->


                </div> <!-- /.row -->
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
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
          </body>

          </html>