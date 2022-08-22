<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.advert.model.advertVO"%>
<%@ page import="com.advert.model.adminService"%>
<%@ page import="com.advert.controller.advertController"%>
<%@ page import="subject.service.*"%>
<%@ page import="subject.vo.*"%>
<%@ page import="subject.dao.*"%>

<%
advertVO advertvo = (advertVO) request.getAttribute("advertvo");
%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>LetItGo | 維護人員系統</title>

    <!-- Google Font: Source Sans Pro -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
    />
    <!-- Font Awesome Icons -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- Theme style -->
    <link rel="stylesheet" href="css/adminlte.min.css" />
    <!-- <link rel="stylesheet" href="css/index_coupon.css" /> -->
    
    <!-- Css OrderMainFile datatables -->
	<link rel="stylesheet"
		href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
	<style>
	
		/* card-header */
		.card-primary:not(.card-outline)>.card-header { 
 		    background-color: #2EC4B6; 
 		}
 		
 		/* all btn */
 		.btn:hover{
 			background-color: #15645c;
 			border-color: #15645c;
 		}
	
		/* img preview */
		#preview {
			display: inline-block;
			width: 250px;
			min-height: 150px;
			/* position: relative; */
		}

		#preview span.text {
			/* position: absolute;
			display: inline-block; */
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
			z-index: -1;
			color: lightgray;
		}

		#preview img.preview_img {
			width: 100%;
		}
		
		.itempic{
			width: 150px;
			min-height: 100px;
		}

		.my-pic{
			width: 200%;
		}
		
	</style>	
 </head>
 <body class="hold-transition sidebar-mini">
   <!-- 主要開發區塊 -->
   <div class="wrapper">
     <!-- Navbar header區塊-->
     <nav
       id="navbar-header"
       class="main-header navbar navbar-expand navbar-white navbar-light"
     >
       <!-- Left navbar links -->
       <ul class="navbar-nav">
         <li class="nav-item">
           <a class="nav-link" data-widget="pushmenu" href="#" role="button"
             ><i class="fas fa-bars"></i
           ></a>
         </li>
    
         <li class="nav-item d-none d-sm-inline-block">
           <a href="../admlogin.jsp" class="nav-link">登出</a>
         </li>
       </ul>

       <!-- Right navbar links -->
       <ul class="navbar-nav ml-auto">
         <!-- Notifications Dropdown Menu -->
         <!-- <li class="nav-item dropdown">
           <a class="nav-link" data-toggle="dropdown" href="#">
             <i class="far fa-bell"></i>
             <span class="badge badge-warning navbar-badge">3</span>
           </a>
           <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
             <span class="dropdown-item dropdown-header">3 Notifications</span>
             <div class="dropdown-divider"></div>
             <a href="#" class="dropdown-item">
               <i class="fas fa-file mr-2"></i> 3 new reports
               <span class="float-right text-muted text-sm">2 days</span>
             </a>
             <div class="dropdown-divider"></div>
             <a href="#" class="dropdown-item dropdown-footer"
               >See All Notifications</a
             >
           </div>
         </li> -->
         <!-- <li class="nav-item">
           <a class="nav-link" data-widget="login-in" href="#" role="button">
             <i class="fas fa-arrow-right-to-bracket"></i>
           </a>
         </li> -->
         <!-- <li class="nav-item">
           <a class="nav-link" data-widget="login-out" href="#" role="button">
             <i class="fas fa-arrow-right-from-bracket"></i>
           </a>
         </li> -->
       </ul>
     </nav>
     <!-- /.navbar -->
     <!-- Main Sidebar Container 主側邊欄-->
     <aside id="sidebar" class="main-sidebar sidebar-dark-primary elevation-4">
       <!-- Brand Logo -->
       <a href="#" class="brand-link">
          <img
            src="../img/Frame 6.svg"
            alt="LETITGO Logo"
            class="brand-image elevation-3"
            style="opacity: 0.8"
          />
         <span class="brand-text font-weight-light">樂易購</span>
       </a>

            <!-- Sidebar -->
       <div class="sidebar">
         <!-- Sidebar user panel (optional) -->
         <div class="user-panel mt-3 pb-3 mb-3 d-flex">
           <div class="image">
             <img
               src="../administrator/images/Adm4.svg"
               class="img-circle elevation-2"
               alt="User Image"
             />
           </div>
           <div class="info">
             <a href="../administrator/admwelcome.jsp" class="d-block">維護人員${user.admname}</a>
           </div>
         </div>

                   <!-- Sidebar Menu -->
          <nav class="mt-2">
            <ul
              class="nav nav-pills nav-sidebar flex-column"
              data-widget="treeview"
              role="menu"
              data-accordion="false"
            >
              <!-- Add icons to the links using the .nav-icon class
                 with font-awesome or any other icon font library -->

              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="fa-solid fa-address-card"></i>
                  <p>
                    會員管理
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                
                  <li class="nav-item">
                    <a href="../administrator/blmemberall.jsp" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>會員停權</p>
                    </a>
                  </li>
                  </ul>
                </li>
              <li class="nav-item menu-open">
                <a href="#" class="nav-link">
                  <i class="fa-solid fa-hand-holding-heart"></i>
                  <p>廣告/活動管理</p>
                  <i class="right fas fa-angle-left"></i>
                </a>
                <ul class="nav nav-treeview open">
                  <li class="nav-item">
                    <a href="Advert.jsp" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>首頁廣告</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="../administrator/couponall.jsp" class="nav-link ">
                      <i class="far fa-circle nav-icon"></i>
                      <p>優惠劵</p>
                    </a>
                  </li>                  
                </ul>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="fa-brands fa-facebook-messenger"></i>
                  <p>公告</p>
                  <i class="right fas fa-angle-left"></i>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="../administrator/froann.jsp" class="nav-link">
                      <i class="far fa-circle nav-icon "></i>
                      <p>首頁公告</p>
                    </a>
                  </li>
<!--                   <li class="nav-item"> -->
<!--                     <a href="#" class="nav-link"> -->
<!--                       <i class="far fa-circle nav-icon"></i> -->
<!--                       <p>賣家公告</p> -->
<!--                     </a> -->
<!--                   </li> -->
              
                </ul>
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
             <div class="card-header py-2">
               <h3 class="m-0 font-weight-bold">修 改 廣 告</h3>
             </div>
			</div>
			<div class="row mb-2">
             <!-- /.col -->
             <div class="col-sm-6">
               <input class="btn btn-primary" type="submit" value="回上一頁" onClick="location.href='Advert.jsp'">
             </div>
             <!-- /.col -->
           </div>
           <!-- /.row -->
         </div>
         <!-- /.container-fluid -->
       </div>
       <!-- /.content-header -->

       <!-- Main content -->
       <div class="content">
         <div class="container-fluid">
           <div class="row">
             <!-- left column -->
             <div class="col-md-12">
               
               <div class="card card-primary">
                 <div class="card-header">
                   <h3 class="card-title">
                     
                     <small></small>
                   </h3>
                 </div>
                 <!-- /.card-header -->
                 <!-- form start -->              
						<%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請修正以下錯誤:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
						<FORM METHOD="post" ACTION="advert.do" name="form1" enctype="multipart/form-data">  
						<!-- 標題 -->
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="form-group">
										<label>廣告編號:<font color=red><b>*</b></font>
											<%=advertvo.getAdvertserialnumber()%>
										</label>
									</div>
								</div>
							</div>
							<!-- 下拉選單 -->
							<div class="row">
		                      <div class="col-4">
		                       <div class="form-group">
		                       <label>維護人員</label>
			                         <input type="TEXT" name="admno" size="45" value="${user.admname}" />
<!-- 		                        <label -->
<!-- 		                         for="exampleSelectBorder">維護人員</label> -->
<%-- 		                        <jsp:useBean id="adminSvc" scope="page" class="com.advert.model.adminService" /> --%>
<!-- 		                        <select -->
<!-- 		                         class="custom-select form-control-border" -->
<!-- 		                         name="adminserialnumber"> -->
<%-- 		                         <c:forEach var="adminvo" items="${adminSvc.all}"> --%>
<%-- 								 <option value="${adminvo.adminserialnumber}" ${(advertvo.adminserialnumber==adminvo.adminserialnumber)? 'selected':'' } >${adminvo.adminaccount} --%>
<%-- 								 </c:forEach> --%>
<!-- 		                        </select> -->
		                       </div>
		                      </div>																
							</div>	
	
							<div class="row">
								<div class="col-12">
									<div class="form-group">
										<label>商品編號</label> <input id="itemnumber" type="TEXT" name="itemserialnumber"
											size="45" class="form-control"
											value="<%=advertvo.getItemserialnumber()%>" />
										<label>廣告敘述</label> <input id="description" type="TEXT"
											class="form-control" name="advertdescription" size="45"
											value="<%=advertvo.getAdvertdescription()%>" />
									</div>
								</div>
							</div>	
					
							<div class="row">
								<div class="col-12">
									<div class="form-group">
										<label>廣告圖示：
											<img src="<%=request.getContextPath()%>/advert/advert.do?actionAd=getadImg&adNo=${advertvo.advertserialnumber}" alt="no image" class="itempic">
										</label>
										<input type="file" id="Picfile"
											name="advertphoto" class="form-control" multiple />														
									</div>
								</div>
								<div class="col-3">
									<div id="preview">
										<span class="text">預覽圖</span>
									</div>
								</div>
							</div>
							<script>
								const myData = {
									img: ''
								}
									document.querySelector('#Picfile').onchange = (e) => {
									let reader = new FileReader();
									reader.readAsDataURL(e.target.files[0]);
									reader.onload = (e) => {
										let img = document.createElement('img')
	
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
						<!--/.card-body -->
<!-- 					<div class="row justify-content-end"> -->
						<div class="row">
							<div class="col-3">
								<input type="hidden" name="action" value="update">
								<input type="hidden" name="advertserialnumber" value="<%=advertvo.getAdvertserialnumber()%>">
								<input id="adUpdate" class="btn  btn-primary" type="submit" value="送出修改">
							</div>
						</div>
					</FORM>	
<!-- 						</div> -->
            	</div>
           		<!-- /.card -->
          	</div>
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6"></div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
	<!-- ============ Footer段落 ============ -->
     <footer class="main-footer">
       <!-- 讓footer維持滿的 -->
       <div class="col-12">
       <!-- To the right -->
       <div class="float-right d-none d-sm-inline">Tibame TGA102 第三組</div>
       <!-- Default to the left -->
       <strong
         >Copyright &copy; 2022
         <a href="https://adminlte.io">AdminLTE.io</a>.</strong
       >
       All rights reserved.
     </footer>
     <!-- Control Sidebar -->
     <aside class="control-sidebar control-sidebar-dark">
       <!-- Control sidebar content goes here -->
     </aside>
     <!-- /.control-sidebar -->
     <!-- ============ Footer段落 ============ -->
     <!-- /.content-wrapper -->
   </div>
   <!-- jQuery -->
   <script src="plugins/jquery/jquery.min.js"></script>
   <script src="./vendors/jquery/jquery-3.6.0.min.js"></script>
   <!-- Bootstrap 4 -->
   <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
   <!-- AdminLTE App -->
   <script src="js/adminlte.min.js"></script>
   <script src="./js/index_advertisement.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
   
   <script>

	   const itemnumber = document.querySelector('#itemnumber');
	   const description = document.querySelector('#description');
	   document.querySelector('#adUpdate').addEventListener('click', () => {
	    
	    if (itemnumber.value.trim() == "" || description.value.trim() == "") {
	
	     alert(`修改廣告失敗，請再檢查`);
	    } else {
	     alert(`修改廣告成功`);
	    }
	   })
   </script>

 </body>
</html>
