<%@page import="subject.blacklist.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="subject.blacklist.model.*"%>

<%
  BlacklistVO blacklistVO = (BlacklistVO) request.getAttribute("blacklistVO");
%>
<%-- <%= blacklistVO==null %>--${blacklistVO}-- --%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>�ַN�� | ��a��x</title>

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
    <link rel="stylesheet" href="blacklisthtml/css/adminlte.min.css" />
<style>
/*   table#table-1 { */
/* 	background-color: #CCCCFF; */
/*     border: 1px solid black; */
/*     text-align: center; */
/*   } */
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
   button {
  	border:1px solid rgb(0,123,255);
  	border-radius:2px;
   
  }
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
   /* �ҪO���C�� */
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
<body bgcolor='white'>
<class class="hold-transition sidebar-mini">
    <!-- �D�n�}�o�϶� -->
    <div class="wrapper">
      <!-- Navbar header�϶�-->
      <nav
        id="navbar-header"
        class="main-header navbar navbar-expand navbar-white navbar-light"
      >
        <!-- Left navbar links -->
        <ul class="navbar-nav">
          <!-- �~���� -->
          <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"
              ><i class="fas fa-bars"></i
            ></a>
          </li>
          <!-- ��r�ϰ� -->
          <li class="nav-item d-none d-sm-inline-block">
            <a href="#" class="nav-link"> ��a���� </a>
          </li>
          <li class="nav-item d-none d-sm-inline-block">
            <a href="#" class="nav-link"
              ><ion-icon name="arrow-forward-outline"></ion-icon
            ></a>
          </li>
          <li class="nav-item d-none d-sm-inline-block">
            <a href="#" class="nav-link">�b��޲z</a>
          </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
          <!-- ���y����icon -->
          <li class="nav-item">
            <a class="nav-link" data-widget="" href="#" role="button">
              <ion-icon name="scan-outline"></ion-icon>
            </a>
          </li>

          <!-- Notifications Dropdown Menu -->
          <li class="nav-item dropdown">
            <a class="nav-link" data-toggle="dropdown" href="#">
              <i class="far fa-bell"></i>
              <span class="badge badge-warning navbar-badge">15</span>
            </a>
            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
              <span class="dropdown-item dropdown-header"
                >15 Notifications</span
              >
              <div class="dropdown-divider"></div>
              <a href="#" class="dropdown-item">
                <i class="fas fa-envelope mr-2"></i> 4 new messages
                <span class="float-right text-muted text-sm">3 mins</span>
              </a>
              <div class="dropdown-divider"></div>
              <a href="#" class="dropdown-item">
                <i class="fas fa-users mr-2"></i> 8 friend requests
                <span class="float-right text-muted text-sm">12 hours</span>
              </a>
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
          </li>
          <!-- �k��n�Jicon -->
          <!-- <li class="nav-item">
          <a class="nav-link" data-widget="login-in" href="#" role="button">
            <i class="fas fa-arrow-right-to-bracket"></i>
          </a>
        </li> -->

          <!-- �k��n�Xicon -->
          <li class="nav-item">
            <a class="nav-link" data-widget="login-out" href="#" role="button">
              <i class="fas fa-arrow-right-from-bracket"></i>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.navbar -->

      <!-- Main Sidebar Container �D������-->
      <aside id="sidebar" class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
          <img
           src="../img/Frame 6.svg"
            alt="LetItGo Logo"
            class="brand-image elevation-3"
            style="opacity: 0.8"
          />
          <span class="brand-text font-weight-light">�ַN��</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
              <img
                src="https://fakeimg.pl/160/"
                class="img-circle elevation-2"
                alt="User Image"
              />
            </div>
            <div class="info">
              <a href="#" class="d-block">���ɤ�����</a>
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
                  <ion-icon name="newspaper-outline"></ion-icon>
                  <!-- <i class="fa-solid fa-house-chimney-medical"></i> -->
                  <p>
                    �q��޲z
                    <!-- <i class="right fas fa-angle-left"></i> -->
                  </p>
                </a>
                <!-- <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>��v�޲z</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>�f����g</p>
                    </a>
                  </li>
                </ul> -->
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <ion-icon name="fast-food-outline"></ion-icon>
                  <!-- <i class="fa-solid fa-calendar-check"></i> -->
                  <p>
                    �ӫ~�޲z
                    <!-- <i class="right fas fa-angle-left"></i> -->
                  </p>
                </a>
                <!-- <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>�@�z�H���޲z</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>����</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>�Z��t��</p>
                    </a>
                  </li>
                </ul> -->
              </li>
<!--               <li class="nav-item"> -->
<!--                 <a href="#" class="nav-link"> -->
<!--                   <ion-icon name="cash-outline"></ion-icon> -->
                  <!-- <i class="fa-solid fa-store"></i> -->
<!--                   <p> -->
<!--                     �]�Ⱥ޲z -->
                    <!-- <i class="right fas fa-angle-left"></i> -->
<!--                   </p> -->
<!--                 </a> -->
<!--               </li> -->
              <li class="nav-item menu-open">
                <a href="#" class="nav-link active">
                  <ion-icon name="home-outline"></ion-icon>
                  <!-- <i class="fa-solid fa-hand-holding-heart"></i> -->
                  <p>
                    �b��޲z
                    <!-- <i class="right fas fa-angle-left"></i> -->
                  </p>
                </a>
                <!-- <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>����</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>����٧U</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>�H�e��T</p>
                    </a>
                  </li>
                </ul> -->
              </li>
<!--               <li class="nav-item"> -->
<!--                 <a href="#" class="nav-link"> -->
<!--                   <ion-icon name="stats-chart-outline"></ion-icon> -->
<!--                   <i class="fa-brands fa-facebook-messenger"></i> -->
<!--                   <p> -->
<!--                     �ڪ����� -->
<!--                     <i class="right fas fa-angle-left"></i> -->
<!--                   </p> -->
<!--                 </a> -->
<!--               </li> -->

<!--               <li class="nav-item"> -->
<!--                 <a href="#" class="nav-link"> -->
<!--                   <ion-icon name="library-outline"></ion-icon> -->
<!--                   <i class="fa-solid fa-book-open"></i> -->
<!--                   <p> -->
<!--                     FAQ -->
<!--                     <i class="right fas fa-angle-left"></i> -->
<!--                   </p> -->
<!--                 </a> -->
<!--               </li> -->
            </ul>
          </nav>
          <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content �D�������-->

      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
          <div class="container-fluid">
            <div class="row mb-2">
             

               <!-- Main content -->
              <!-- ����D�� -->
               
              
              <div class="col-12">              
                <div class="card">                
                 <!-- tab���@�� -->
                
                  <div class="card-header p-2">
                 
                    <ul class="nav nav-pills">
                     <li class="nav-item"><a class="nav-link" href="">�ڪ���T</a></li>
                      <li class="nav-item"><a class="nav-link active" href="../blacklist/listAllBlacklist2.jsp">�¦W��</a></li>
                    
<!--                         <a href="#" style="font-size:18px ; padding:10px">�ڪ���T</a>  -->
<!--                		    <a href="listAllBlacklist.jsp" style="font-size:18px ; padding:10px">�¦W��</a> -->
<!--                       <li class="nav-item">  -->
<!--                         <a class="nav-link " href="#activity" data-toggle="tab">�ڪ���T</a> -->
<!--                      </li>                       -->
                      
<!--                        <li class="nav-item">  -->
<!--                         <a class="nav-link" href="#settings" data-toggle="tab">�¦W��</a> -->
<!--                       </li>  -->
                    </ul>
                  </div>

                  <!-- tab�Ҧ����� -->
                  <div class="card-body">
                    <div class="tab-content">
                      <!-- tab�U  �����@(�ڪ���T����) -->
<!--                       <div class="active tab-pane" id="activity"> -->
<!--                         <table class="table table-head-fixed text-nowrap"> -->
<!--                           <thead> -->
<!--                             <tr> -->
<!--                               <th>�ӫ~�s��</th> -->
<!--                               <th>�ӫ~�W��</th> -->
<!--                               <th>�������</th> -->
<!--                               <th>�P�P����</th> -->
<!--                               <th>�ƶq</th> -->
<!--                               <th>���A</th> -->
<!--                               <th>�ާ@</th> -->
<!--                             </tr> -->
<!--                           </thead> -->

<!--                           <tbody> -->
<!--                             <tr> -->
<!--                               <td>0087</td> -->
<!--                               <td>���ɤ�����</td> -->
<!--                               �n��Ϥ���? -->
<!--                               <td>$199</td> -->
<!--                               <td>$187</td> -->
<!--                               <td>87</td> -->
<!--                               <td>�W�[��</td> -->
<!--                               <td><button>��s</button></td> -->
<!--                             </tr> -->

<!--                             <tr> -->
<!--                               <td>0087</td> -->
<!--                               <td>���ɤ�����</td> -->
<!--                               �n��Ϥ���? -->
<!--                               <td>$199</td> -->
<!--                               <td>$187</td> -->
<!--                               <td>87</td> -->
<!--                               <td>�W�[��</td> -->
<!--                               <td><button>��s</button></td> -->
<!--                             </tr> -->
<!--                           </tbody> -->
<!--                         </table> -->
<!--                       </div> -->
<!--                       /.tab-pane1 -->

                     

                      <!-- tab�U  �����T(�¦W�歶��) -->
                      <div >
                        <table >
                          <thead style="width: 1000px">
                            <!--������-->
                            <!-- <tr>
                              <th style="width: 1000px; text-align: center">
                                �¦W��s��
                              </th>

                              <th style="width: 1000px; text-align: center">
                                �|���s��
                              </th>

                              <th style="width: 1000px; text-align: center">
                                �^��
                              </th>
                            </tr> -->
                          </thead>
                          
<table id="table-1" style="background-color:rgb(237,230,219)">
	<tr><td>
		 <button class="btn  btn-primary"><a href="listAllBlacklist2.jsp" style="color:white;">�^�¦W���`��</a></button>
	</td></tr>
</table>
<br>
<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red"></font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/blacklist/blacklist.do" name="form1">
<table style="background-color:rgb(237,230,219)">
	<tr>
		<td>��a�y���s��:</td>
		<td><input type="TEXT" name="serialnumber" size="40" 
			 value="<%= (blacklistVO==null)? "" : blacklistVO.getSerialnumber()%>" /></td>
	</tr>
	<tr>
		<td>�|���y���s��:</td>
		<td><input type="TEXT" name="memberserialnumber" size="40" 
			 value="<%= (blacklistVO==null)? "163600" : blacklistVO.getMemberserialnumber()%>" /></td>
	</tr>
	<tr>
		<td>�|���b��:</td>
		<td><input type="TEXT" name="account" size="40" 
			 value="<%= (blacklistVO==null)? "" : blacklistVO.getAccount()%>" /></td>
	</tr>
	<tr>
		<td>�¦W�檬�A:</td>
		<td><input type="TEXT" name="blackliststatus" size="40" 
			 value="<%= (blacklistVO==null)? "true" : blacklistVO.isBlackliststatus()%>" readonly /></td>
	</tr>
	

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input class="btn  btn-primary" type="submit" value="�e�X�s�W"></FORM>
                        </table>
                      </div>
                      <!-- /.tab-pane2 -->
                    </div>
                    <!---tab-pane3 -->
                  </div>
                  <!-- /.tab-content -->
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
            <!-- /.col-12(�D��) -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->
    </div>
    <!-- /.content-wrapper -->

    <!-- ============ Footer�q�� ============ -->
    <footer class="main-footer">
      <!-- ��footer�������� -->
      <div class="col-12">
        <!-- To the right -->
        <div class="float-right d-none d-sm-inline">Tibame TGA102 �ĤT��</div>
        <!-- Default to the left -->
        <strong
          >Copyright &copy; 2022
          <!-- �U���s���n���n��������ڭ̭����s�� -->
          <a href="https://adminlte.io">TEAM LETITGO </a>.</strong
        >
        All rights reserved.
      </div>
    </footer>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
      <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->

    <!-- /.col -->
    <!-- ============ Footer�q�� ============ -->
    <!-- /.content-wrapper -->

    <!-- jQuery -->
    <script src="blacklisthtml/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="blacklisthtml/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="blacklisthtml/js/adminlte.min.js"></script>
    <!-- ionicon  -->
    <script
      type="module"
      src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
    ></script>
 
</html>