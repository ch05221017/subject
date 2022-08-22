<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="subject.ticket.model.*"%>
<%@ page import="com.order_detail.model.*"%>
<%@ page import="com.item_category.model.*"%>
<%@ page import="com.item.model.*" %>
<%@ page import="web.vo.Member"%>
<%@ page import="web.member.dao.*" %>
<%@ page import="web.member.service.*" %>

<%
	Order_detail_Service orderdetailSvc = new Order_detail_Service();
	List<Order_detail_VO> orderdetaillist = orderdetailSvc.getAll();
	pageContext.setAttribute("orderdetaillist",orderdetaillist);
%>
<%
    TicketService ticketSvc = new TicketService();
    List<TicketVO> list = ticketSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LetItGo | 會員中心</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet"><!--自然改-->
    <!--自然改-->
    <!-- Css Styles -->
    <link rel="stylesheet" href="tickethtml/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/jquery-ui.min.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="tickethtml/css/style.css" type="text/css" />
    <style>
      /* table.table_t1 {
        background-color: rgb(255, 191, 105);
      } */

      table thead th {
        text-align: center;
        border: 1px solid rgb(185, 185, 185);
      }
      tr td {
        text-align: center;
        border: 1px solid rgb(185, 185, 185);
      }
      td button {
        border-radius: 10px;
        border: none;
        box-shadow: 0px 3px 5px -2px;
      }

      #tab-demo {
        width: 350px;
        height: 200px;
      }
      .tab-pane fade show active {
        background-color: green;
      }
      li.nav-item {
        width: 282px;
        text-align: center;
      }

      .nav-pills .nav-link.active,
      .nav-pills .show > .nav-link {
        color: #fff;
        background-color: #7fad39;
      }
      .nav-tabs .nav-link.active {
        color: #7fad39;
        background-color: #fff;
        border-color: #dee2e6 #dee2e6 #fff;
      }
      a {
        color: black;
        text-decoration: none;
        background-color: transparent;
      }
       body {
  font: 12px/20px 'Lucida Grande', Verdana, sans-serif;
  color: #404040;
  background: #eee;
}

.widget {
  position: relative;
  margin: 20px auto 10px;
  width: 320px;
  background: white;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
}
.widget1 {
  position: relative;
  margin: 20px auto 10px;
  width: 320px;
  background: white;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
}
.widget2 {
  position: relative;
  margin: 20px auto 10px;
  width: 320px;
  background: white;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
}

.widget-tabs {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  padding: 9px 12px 0;
  text-align: left;
  direction: rtl;
  background: #f5f5f5;
  border-bottom: 1px solid #ddd;
  border-radius: 3px 3px 0 0;
}
.widget-tabs1 {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  padding: 9px 12px 0;
  text-align: left;
  direction: rtl;
  background: #f5f5f5;
  border-bottom: 1px solid #ddd;
  border-radius: 3px 3px 0 0;
}
.widget-tabs2 {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  padding: 9px 12px 0;
  text-align: left;
  direction: rtl;
  background: #f5f5f5;
  border-bottom: 1px solid #ddd;
  border-radius: 3px 3px 0 0;
}

.widget-tab,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child ~ .widget-tab,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) ~ .widget-tab,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child ~ .widget-tab {
  position: relative;
  display: inline-block;
  vertical-align: top;
  margin-top: 3px;
  line-height: 36px;
  font-weight: normal;
  color: #999;
  background: #fcfcfc;
  border: solid #ddd;
  border-width: 1px 1px 0;
  border-radius: 5px 5px 0 0;
  padding-bottom: 0;
  bottom: auto;
}
.widget-tab1,
.widget-list1:target:first-of-type ~ .widget-tabs1 > .widget-tab1:first-child ~ .widget-tab1,
.widget-list1:target:nth-of-type(2) ~ .widget-tabs1 > .widget-tab1:nth-child(2) ~ .widget-tab1,
.widget-list1:target:last-of-type ~ .widget-tabs1 > .widget-tab1:last-child ~ .widget-tab1 {
  position: relative;
  display: inline-block;
  vertical-align: top;
  margin-top: 3px;
  line-height: 36px;
  font-weight: normal;
  color: #999;
  background: #fcfcfc;
  border: solid #ddd;
  border-width: 1px 1px 0;
  border-radius: 5px 5px 0 0;
  padding-bottom: 0;
  bottom: auto;
}
.widget-tab2,
.widget-list2:target:first-of-type ~ .widget-tabs2 > .widget-tab2:first-child ~ .widget-tab2,
.widget-list2:target:nth-of-type(2) ~ .widget-tabs2 > .widget-tab2:nth-child(2) ~ .widget-tab2,
.widget-list2:target:last-of-type ~ .widget-tabs2 > .widget-tab2:last-child ~ .widget-tab2 {
  position: relative;
  display: inline-block;
  vertical-align: top;
  margin-top: 3px;
  line-height: 36px;
  font-weight: normal;
  color: #999;
  background: #fcfcfc;
  border: solid #ddd;
  border-width: 1px 1px 0;
  border-radius: 5px 5px 0 0;
  padding-bottom: 0;
  bottom: auto;
}

.widget-tab > .widget-tab-link,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child ~ .widget-tab > .widget-tab-link,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) ~ .widget-tab > .widget-tab-link,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child ~ .widget-tab > .widget-tab-link {
  margin: 0;
  border-top: 0;
}
.widget-tab1 > .widget-tab-link1,
.widget-list1:target:first-of-type ~ .widget-tabs1 > .widget-tab1:first-child ~ .widget-tab1 > .widget-tab-link1,
.widget-list1:target:nth-of-type(2) ~ .widget-tabs1 > .widget-tab1:nth-child(2) ~ .widget-tab1 > .widget-tab-link1,
.widget-list1:target:last-of-type ~ .widget-tabs1 > .widget-tab1:last-child ~ .widget-tab1 > .widget-tab-link1 {
  margin: 0;
  border-top: 0;
}
.widget-tab2 > .widget-tab-link2,
.widget-list2:target:first-of-type ~ .widget-tabs2 > .widget-tab2:first-child ~ .widget-tab2 > .widget-tab-link2,
.widget-list2:target:nth-of-type(2) ~ .widget-tabs2 > .widget-tab2:nth-child(2) ~ .widget-tab2 > .widget-tab-link2,
.widget-list2:target:last-of-type ~ .widget-tabs2 > .widget-tab2:last-child ~ .widget-tab2 > .widget-tab-link2 {
  margin: 0;
  border-top: 0;
}

.widget-tab + .widget-tab {
  margin-right: -1px;
}
.widget-tab1 + .widget-tab1 {
  margin-right: -1px;
}
.widget-tab2 + .widget-tab2 {
  margin-right: -1px;
}

.widget-tab:last-child,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2),
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child {
  bottom: -1px;
  margin-top: 0;
  padding-bottom: 2px;
  line-height: 34px;
  font-weight: bold;
  color: #555;
  background: white;
  border-top: 0;
}
.widget-tab1:last-child,
.widget-list1:target:first-of-type ~ .widget-tabs1 > .widget-tab1:first-child,
.widget-list1:target:nth-of-type(2) ~ .widget-tabs1 > .widget-tab1:nth-child(2),
.widget-list1:target:last-of-type ~ .widget-tabs1 > .widget-tab1:last-child {
  bottom: -1px;
  margin-top: 0;
  padding-bottom: 2px;
  line-height: 34px;
  font-weight: bold;
  color: #555;
  background: white;
  border-top: 0;
}
.widget-tab2:last-child,
.widget-list2:target:first-of-type ~ .widget-tabs2 > .widget-tab2:first-child,
.widget-list2:target:nth-of-type(2) ~ .widget-tabs2 > .widget-tab2:nth-child(2),
.widget-list2:target:last-of-type ~ .widget-tabs2 > .widget-tab2:last-child {
  bottom: -1px;
  margin-top: 0;
  padding-bottom: 2px;
  line-height: 34px;
  font-weight: bold;
  color: #555;
  background: white;
  border-top: 0;
}

.widget-tab:last-child > .widget-tab-link,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child > .widget-tab-link,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) > .widget-tab-link,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child > .widget-tab-link {
  margin: 0 -1px;
  border-top: 4px solid #4cc8f1;
}
.widget-tab1:last-child > .widget-tab-link1,
.widget-list1:target:first-of-type ~ .widget-tabs1 > .widget-tab1:first-child > .widget-tab-link1,
.widget-list1:target:nth-of-type(2) ~ .widget-tabs1 > .widget-tab1:nth-child(2) > .widget-tab-link1,
.widget-list1:target:last-of-type ~ .widget-tabs1 > .widget-tab1:last-child > .widget-tab-link1 {
  margin: 0 -1px;
  border-top: 4px solid #4cc8f1;
}
.widget-tab2:last-child > .widget-tab-link2,
.widget-list2:target:first-of-type ~ .widget-tabs2 > .widget-tab2:first-child > .widget-tab-link2,
.widget-list2:target:nth-of-type(2) ~ .widget-tabs2 > .widget-tab2:nth-child(2) > .widget-tab-link2,
.widget-list2:target:last-of-type ~ .widget-tabs2 > .widget-tab2:last-child > .widget-tab-link2 {
  margin: 0 -1px;
  border-top: 4px solid #4cc8f1;
}

.widget-tab-link1 {
  display: block;
  min-width: 60px;
  padding: 0 15px;
  color: inherit;
  text-align: center;
  text-decoration: none;
  border-radius: 4px 4px 0 0;
}
.widget-tab-link2 {
  display: block;
  min-width: 60px;
  padding: 0 15px;
  color: inherit;
  text-align: center;
  text-decoration: none;
  border-radius: 4px 4px 0 0;
}
.widget-tab-link {
  display: block;
  min-width: 60px;
  padding: 0 15px;
  color: inherit;
  text-align: center;
  text-decoration: none;
  border-radius: 4px 4px 0 0;
}

.widget-list {
  display: none;
  padding-top: 50px;
  list-style: none;

}
.widget-list1 {
  display: none;
  padding-top: 50px;
  list-style: none;

}
.widget-list2 {
  display: none;
  padding-top: 50px;
  list-style: none;

}

.widget-list > li + li {
  border-top: 1px solid #e8e8e8;
}
.widget-list1 > li + li {
  border-top: 1px solid #e8e8e8;
}
.widget-list2 > li + li {
  border-top: 1px solid #e8e8e8;
}

.widget-list:last-of-type {
  display: block;
}
.widget-list1:last-of-type {
  display: block;
}
.widget-list2:last-of-type {
  display: block;
}

.widget-list:target {
  display: block;
}
.widget-list1:target {
  display: block;
}
.widget-list2:target {
  display: block;
}

.widget-list:target ~ .widget-list {
  display: none;
}
.widget-list1:target ~ .widget-list1 {
  display: none;
}
.widget-list2:target ~ .widget-list2 {
  display: none;
}

.widget-list-link {
  display: block;
  line-height: 18px;
  padding: 10px 12px;
  font-weight: bold;
  color: #555;
  text-decoration: none;
  cursor: pointer;
}
.widget-list-link1 {
  display: block;
  line-height: 18px;
  padding: 10px 12px;
  font-weight: bold;
  color: #555;
  text-decoration: none;
  cursor: pointer;
}
.widget-list-link2 {
  display: block;
  line-height: 18px;
  padding: 10px 12px;
  font-weight: bold;
  color: #555;
  text-decoration: none;
  cursor: pointer;
}

.widget-list-link:hover {
  background: #f7f7f7;
}
.widget-list-link1:hover {
  background: #f7f7f7;
}
.widget-list-link2:hover {
  background: #f7f7f7;
}

li:last-child > .widget-list-link {
  border-radius: 0 0 3px 3px;
}
li:last-child > .widget-list-link1 {
  border-radius: 0 0 3px 3px;
}
li:last-child > .widget-list-link2 {
  border-radius: 0 0 3px 3px;
}

.widget-list-link > img {
  float: left;
  width: 32px;
  height: 32px;
  margin: 2px 12px 0 0;
}
.widget-list-link1 > img {
  float: left;
  width: 32px;
  height: 32px;
  margin: 2px 12px 0 0;
}
.widget-list-link2 > img {
  float: left;
  width: 32px;
  height: 32px;
  margin: 2px 12px 0 0;
}

.widget-list-link > span {
  display: block;
  font-size: 11px;
  font-weight: normal;
  color: #999;
}
.widget-list-link1 > span {
  display: block;
  font-size: 11px;
  font-weight: normal;
  color: #999;
}
.widget-list-link2 > span {
  display: block;
  font-size: 11px;
  font-weight: normal;
  color: #999;
}



        


.hero__search__form {
	width: 610px;
	height: 100px;
	border: 1px solid #ebebeb;
	position: relative;
	float: left;
}


    .hero.hero-normal .hero__categories1 {
	position: relative;
}
.hero.hero-normal .hero__categories2 {
	position: relative;
}

.hero.hero-normal .hero__categories1 ul {
	display: none;
	position: absolute;
	left: 0;
	top: 46px;
	width: 100%;
	z-index: 9;
	background: #ffffff;
}
.hero.hero-normal .hero__categories2 ul {
	display: none;
	position: absolute;
	left: 0;
	top: 46px;
	width: 100%;
	z-index: 9;
	background: #ffffff;
}

.hero__categories1__all {
	background: #7fad39;
	position: relative;
	padding: 10px 25px 10px 40px;
	cursor: pointer;
}
.hero__categories2__all {
	background: #7fad39;
	position: relative;
	padding: 10px 25px 10px 40px;
	cursor: pointer;
}


.hero__categories1__all i {
	font-size: 16px;
	color: #ffffff;
	margin-right: 10px;
}
.hero__categories2__all i {
	font-size: 16px;
	color: #ffffff;
	margin-right: 10px;
}


.hero__categories1__all span {
	font-size: 18px;
	font-weight: 700;
	color: #ffffff;
}
.hero__categories2__all span {
	font-size: 18px;
	font-weight: 700;
	color: #ffffff;
}



.hero__categories1__all:after {
	position: absolute;
	right: 18px;
	top: 9px;
	content: "3";
	font-family: "ElegantIcons";
	font-size: 18px;
	color: #ffffff;
}
.hero__categories2__all:after {
	position: absolute;
	right: 18px;
	top: 9px;
	content: "3";
	font-family: "ElegantIcons";
	font-size: 18px;
	color: #ffffff;
}


.hero__categories1 ul {
	border: 1px solid #ebebeb;
	padding-left: 40px;
	padding-top: 10px;
	padding-bottom: 12px;
}
.hero__categories2 ul {
	border: 1px solid #ebebeb;
	padding-left: 40px;
	padding-top: 10px;
	padding-bottom: 12px;
}


.hero__categories1 ul li {
	list-style: none;
}
.hero__categories2 ul li {
	list-style: none;
}


.hero__categories1 ul li a {
	font-size: 16px;
	color: #1c1c1c;
	line-height: 39px;
	display: block;
}
.hero__categories2 ul li a {
	font-size: 16px;
	color: #1c1c1c;
	line-height: 39px;
	display: block;
}


@media only screen and (min-width: 992px) and (max-width: 1199px) {

	.hero__categories1__all {
		padding: 10px 25px 10px 20px;
	}
	.hero__categories2__all {
		padding: 10px 25px 10px 20px;
	}

	.hero__categories1 ul {
		padding-left: 20px;
	}
	.hero__categories2 ul {
		padding-left: 20px;
	}

}



@media only screen and (min-width: 768px) and (max-width: 991px) {
	.hero__categories1 {
		margin-bottom: 30px;
	}
	.hero__categories2 {
		margin-bottom: 30px;
	}
}



@media only screen and (max-width: 767px) {

	.hero__categories1 {
		margin-bottom: 30px;
	}
	.hero__categories2 {
		margin-bottom: 30px;
	}

}

.featured__controls1 {
	text-align: center;
	margin-bottom: 50px;
}
.featured__controls2 {
	text-align: center;
	margin-bottom: 50px;
}

.featured__controls1 ul li {
	list-style: none;
	font-size: 18px;
	color: #1c1c1c;
	display: inline-block;
	margin-right: 25px;
	position: relative;
	cursor: pointer;
}
.featured__controls2 ul li {
	list-style: none;
	font-size: 18px;
	color: #1c1c1c;
	display: inline-block;
	margin-right: 25px;
	position: relative;
	cursor: pointer;
}


.featured__controls1 ul li.active:after {
	opacity: 1;
}
.featured__controls2 ul li.active:after {
	opacity: 1;
}


.featured__controls1 ul li:after {
	position: absolute;
	left: 0;
	bottom: -2px;
	width: 100%;
	height: 2px;
	background: #7fad39;
	content: "";
	opacity: 0;
}
.featured__controls2 ul li:after {
	position: absolute;
	left: 0;
	bottom: -2px;
	width: 100%;
	height: 2px;
	background: #7fad39;
	content: "";
	opacity: 0;
}


.featured__controls1 ul li:last-child {
	margin-right: 0;
}
.featured__controls2 ul li:last-child {
	margin-right: 0;
}



@media only screen and (max-width: 479px) {

	.featured__controls1 ul li {
		margin-bottom: 10px;
	}
	.featured__controls2 ul li {
		margin-bottom: 10px;
	}

}
  
    </style>


</head>
<body>
<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


        <!-- Header Section Begin -->

        
        <header class="header">
            <!-- Humberger Begin -->
            <div class="humberger__menu__overlay"></div>
            <div class="humberger__menu__wrapper">
                <div class="humberger__menu__logo">
                    <a href="#"><img src="/subject/src/main/webapp/img/Frame 6.svg" alt=""></a><!--自然改-->
                </div>
                <div class="humberger__menu__cart">
                    <ul>
                        <li><a href="./my_favorite.jsp"><i class="fa fa-heart"></i> </a></li><!--自然改-->
                        <li><a href="./index.jsp"><i class="fa-solid fa-house"></i> </a></li><!--自然改--><!--這個圖示用來做回首頁-->
                        <li><a href="./shoping-cart.html"><i class="fa-solid fa-cart-shopping"></i> </a></li><!--自然改--><!--這個圖示用來做購物車-->
                        <li><a href="./listAllTicket.jsp"><i class="fa-solid fa-ticket"></i></a></li> <!--自然改--><!--這個圖示用來做我的票券-->
                        <li><a href="./logout"><i class="fa-solid fa-person"></i></a></li> <!--自然改--><!--這個圖示用來做登入-->
                    </ul>
                    <!-- <div class="header__cart__price">item: <span>$150.00</span></div> -->
                </div>
                <div class="humberger__menu__widget">
                    <!-- <div class="header__top__right__language">
                        <img src="img/language.png" alt="">
                        <div>English</div>
                        <span class="arrow_carrot-down"></span> -->
                        <!-- <ul>
                            <li><a href="#">Spanis</a></li>
                            <li><a href="#">English</a></li>
                        </ul> -->
                    <!-- </div> -->
                    <!-- <div class="header__top__right__auth">
                        <a href="#"><i class="fa fa-user"></i> Login</a>
                    </div> -->
                </div>
                <nav class="humberger__menu__nav mobile-menu">
                    <ul>
                        <!-- <li class="active"><a href="./index.jsp">Home</a></li>
                        <li><a href="./shop-grid.html">Shop</a></li> -->
                        <li><a href="#">會員中心</a>
                            <ul class="header__menu__dropdown">
                                            <li><a href="./memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li> <!--自然改-->
                                            <li><a href="./orderMainFile/OrderMainFile.jsp">訂單查詢</a></li> <!--自然改-->
                                            <li><a href="./MemberBenefits.html">會員權益</a></li> <!--自然改-->
                                            <li><a href="./CustomerService.html">聯繫客服</a></li> <!--自然改-->
                                            <li><a href="./FAQ.html">會員FAQ</a></li> <!--自然改-->
                            </ul>
                        </li>
                        <li><a href="#">賣家中心</a>
                            <ul class="header__menu__dropdown">
                                            <li><a href="./seller/Order">訂單管理</a></li> <!--自然改-->
                                            <li><a href="./seller/product.jsp">商品管理</a></li> <!--自然改-->
                                            <li><a href="./seller/Seller">帳戶管理</a></li> <!--自然改-->
    
                            </ul>
                        </li>
                        <!-- <li><a href="./blog.html">Blog</a></li>
                        <li><a href="./contact.html">Contact</a></li> -->
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
                <!-- <div class="header__top__right__social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-linkedin"></i></a>
                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                </div> -->
                <!-- <div class="humberger__menu__contact">
                    <ul>
                        <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                        <li>Free Shipping for all Order of $99</li>
                    </ul>
                </div> -->
            </div>
            <!-- Humberger End -->
        
        
                <!-- <div class="header__top">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="header__top__left">
                                    <ul>
                                        <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                        <li>Free Shipping for all Order of $99</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="header__top__right">
                                    <div class="header__top__right__social">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-linkedin"></i></a>
                                        <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                    </div>
                                    <div class="header__top__right__language">
                                        <img src="img/language.png" alt="">
                                        <div>English</div>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="#">Spanis</a></li>
                                            <li><a href="#">English</a></li>
                                        </ul>
                                    </div>
                                    <div class="header__top__right__auth">
                                        <a href="#"><i class="fa fa-user"></i> Login</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="header__logo">
                                <a href="../index.jsp"><img src="tickethtml/img/Frame 6.svg" alt=""></a><!--自然改-->
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <nav class="header__menu">
                                <ul>
<!--                                     <li><a href="#">會員中心</a> -->
<!--                                         <ul class="header__menu__dropdown"> -->
<!--                                             <li><a href="./memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li> 自然改 -->
<!--                                             <li><a href="./orderMainFile/OrderMainFile.jsp">訂單查詢</a></li> 自然改 -->
<!--                                             <li><a href="./MemberBenefits.html">會員權益</a></li> 自然改 -->
<!--                                             <li><a href="./CustomerService.html">聯繫客服</a></li> 自然改 -->
<!--                                             <li><a href="./FAQ.html">買家FAQ</a></li> 自然改 -->
        
<!--                                         </ul> -->
<!--                                     </li> -->
                                    <li><a href="#">賣家中心</a>
                                        <ul class="header__menu__dropdown">
                                            <li><a href="./seller/Order">訂單管理</a></li> <!--自然改-->
                                            <li><a href="./seller/product.jsp">商品管理</a></li> <!--自然改-->
                                            <li><a href="./seller/Seller">帳戶管理</a></li> <!--自然改-->

                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-lg-3">
                            <div class="header__cart">
                                <ul>
                                    <li><a href="../my_favorite.jsp"><i class="fa fa-heart"></i> </a></li><!--自然改-->
                                    <li><a href="../index.jsp"><i class="fa-solid fa-house"></i> </a></li><!--自然改--><!--這個圖示用來做回首頁-->
                                    <li><a href="../shoping-cart.html"><i class="fa-solid fa-cart-shopping"></i> </a></li><!--自然改--><!--這個圖示用來做購物車-->
                                    <li><a href="../ticket/listAllTicket.jsp"><i class="fa-solid fa-ticket"></i></a></li> <!--自然改--><!--這個圖示用來做我的票券-->
                                    <li><a href="../login.html"><i class="fa-solid fa-person"></i></a></li> <!--自然改--><!--這個圖示用來做登入-->
                                    <li><a href="../logout"><i class="fa fa-sign-out"></i></a></li> <!--自然改--><!--這個圖示用來做登入-->
                                </ul>
                                <!-- <div class="header__cart__price">item: <span>$150.00</span></div> -->
                            </div>
                        </div>
                    </div>
                    <div class="humberger__open">
                        <i class="fa fa-bars"></i>
                    </div>
                </div>
            </header>
            <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="hero__categories">
              <div class="hero__categories__all">
                <i class="fa fa-bars"></i>
                <span>會員中心</span>
                <!--韋爾改-->
              </div>
              <ul style="border:1px solid #c8c8c8;">
               <li><a href="../memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li>
                <!--韋爾改-->
                <li><a href="../orderMainFile/OrderMainFile.jsp">訂單查詢</a></li>
                <!--韋爾改-->
                <li><a href="listAllTicket.jsp">我的票夾</a></li>
                <li><a href="../my_favorite.jsp">我的最愛</a></li>
                <!--韋爾改-->
                <li><a href="../MemberBenefits.html">會員權益</a></li>
                <!--韋爾改-->
                <li><a href="../CustomerService.html">聯繫客服</a></li>
                <!--韋爾改-->
                <li><a href="../FAQ.html">會員FAQ</a></li>
                <!--韋爾改-->
                <!-- <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li> -->
              </ul>
            </div>
          </div>
          <div class="col-lg-9">
            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
<!--               <li class="nav-item"> -->
<!--                 <a -->
<!--                   class="nav-link active" -->
<!--                   id="pills-home-tab" -->
<!--                   data-toggle="pill" -->
<!--                   href="#pills-home" -->
<!--                   role="tab" -->
<!--                   aria-controls="pills-home" -->
<!--                   aria-selected="true" -->
<!--                   >未兌換</a -->
<!--                 > -->
<!--               </li> -->
<!--               <li class="nav-item"> -->
<!--                 <a -->
<!--                   class="nav-link" -->
<!--                   id="pills-profile-tab" -->
<!--                   data-toggle="pill" -->
<!--                   href="#pills-profile" -->
<!--                   role="tab" -->
<!--                   aria-controls="pills-profile" -->
<!--                   aria-selected="false" -->
<!--                   >已兌換</a -->
<!--                 > -->
<!--               </li> -->
<!--               <li class="nav-item"> -->
<!--                 <a -->
<!--                   class="nav-link" -->
<!--                   id="pills-contact-tab" -->
<!--                   data-toggle="pill" -->
<!--                   href="#pills-contact" -->
<!--                   role="tab" -->
<!--                   aria-controls="pills-contact" -->
<!--                   aria-selected="false" -->
<!--                   >已失效</a> -->
<!--               </li> -->
            </ul>
            <div class="tab-content" id="pills-tabContent">
              <div
                class="tab-pane fade show active"
                id="pills-home"
                role="tabpanel"
                aria-labelledby="pills-home-tab"
              >
                <!-- <table class="table_t1">
                  <thead>
                    <th style="width: 59px">1</th>
                    <th style="width: 200px; height: 200px">
                      <img
                        src="data:image/png;base64,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"
                        alt=""
                      />
                    </th>

                    <th style="width: 540px">
                      <p>【麥當勞】</p>
                      <p>訂單編號:22050829805497</p>
                    </th>
                  </thead>
                </table> -->
                <table style="
                    height: 200px;
                    width: 800px;
                    border: 1px solid rgb(168, 159, 159);
                  "
                >
                  <thead
                    style="color: white; background-color: rgb(127, 173, 57)"
                  >
                    <th>訂單編號</th>
                    <th>商品編號</th>
                    <th>商品名稱</th>
                    <th>日期</th>
                    <th>兌換</th>
                  </thead>

                  </tr>
<%-- 	<%@ include file="page1.file" %>  --%>
<%-- 	<c:forEach var="ticketVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		<c:forEach var="ticketVO" items="${list}"  begin="${offset}" end="<%=list.size()%>">
		 <c:if test="${memID == ticketVO.memberserialnumber}">
		<tr style="background-color:white;">
			
			<td>${ticketVO.orderserialnumber}</td>
			<td>${ticketVO.orderdetailserialnumber}</td>
			<td>${ticketVO.itemname}</td>
			<td><fmt:formatDate value="${ticketVO.orderdate}" pattern="yyyy.MM.dd"/></td>
<%-- 			<td>${ticketVO.memberserialnumber}</td>> --%>
			<td>
				
					<table>   					
    					<c:set var="number" scope="session" value="${ticketVO.orderdetailserialnumber}"/>
						<c:if test="${number == ticketVO.orderdetailserialnumber}">
						  <FORM METHOD="get" ACTION="<%=request.getContextPath()%>/qr_code" >
        						<input type="hidden" name="order_detail_serial_number", value="${ticketVO.orderdetailserialnumber}">  
        						<input type="hidden" name="action" value="我要兌換">
        						<input type="submit" value="我要兌換">
    						</FORM>
						</c:if>
						
						
					</table>
			
			</td> 
			
			
			 
		</tr>
		</c:if>
	</c:forEach>
<%--   <%@ include file="page2.file" %> --%>
                </table>
              </div>
              <div
                class="tab-pane fade"
                id="pills-profile"
                role="tabpanel"
                aria-labelledby="pills-profile-tab"
              >
                <table class="table_t1">
                  <thead>
                    <th style="width: 54px">1</th>
                    <th style="width: 200px; height: 200px">
                      <img
                        src="https://foodtracer.taipei.gov.tw/Backend/upload/company//23928945/23928945_img2.png"
                        alt=""
                      />
                    </th>

                    <th style="width: 545px">
                      <p>【摩斯漢堡】</p>
                      <p>訂單編號:22050829807654</p>
                    </th>
                  </thead>
                </table>
                <table
                  style="
                    height: 340px;
                    width: 800px;
                    border: 1px solid rgb(168, 159, 159);
                  "
                >
                  <thead style="background-color: rgb(127, 173, 57)">
                    <th>序號</th>
                    <th>商品</th>
                    <th>票券序號</th>
                    <th>購買日期</th>
                    <th>兌換</th>
                  </thead>

                  <tr>
                    <td>1-1</td>
                    <td>【摩斯漢堡】海洋珍珠堡即享券</td>
                    <td>MS202207111</td>
                    <td>20220711</td>
                    <td>
                      <a href="MemberEvaluation.html">
                        <button>我要評價</button>
                      </a>
                    </td>
                  </tr>
                  <tr>
                    <td>1-2</td>
                    <td>【摩斯漢堡】海洋珍珠堡即享券</td>
                    <td>MS202207112</td>
                    <td>20220711</td>
                    <td>
                      <a href="MemberEvaluation.html">
                        <button>我要評價</button>
                      </a>
                    </td>
                  </tr>
                </table>
              </div>
              <div
                class="tab-pane fade"
                id="pills-contact"
                role="tabpanel"
                aria-labelledby="pills-contact-tab"
              >
                <table class="table_t1">
                  <thead>
                    <th style="width: 55px">1</th>
                    <th style="width: 200px">
                      <img
                        src="https://upload.wikimedia.org/wikipedia/zh/thumb/7/7b/Louisa_Coffee_logo.svg/1200px-Louisa_Coffee_logo.svg.png"
                        alt=""
                      />
                    </th>

                    <th style="width: 545px">
                      <p>【路易莎咖啡】</p>
                      <p>訂單編號:22050829800824</p>
                    </th>
                  </thead>
                </table>
                <table
                  style="
                    height: 170px;
                    width: 800px;
                    border: 1px solid rgb(168, 159, 159);
                  "
                >
                  <thead style="background-color: rgb(127, 173, 57)">
                    <th>序號</th>
                    <th>商品</th>
                    <th>票券序號</th>
                    <th>購買日期</th>
                    <th>兌換</th>
                  </thead>

                  <tr>
                    <td>1-1</td>
                    <td>【路易沙咖啡】義式濃縮兌換券</td>
                    <td>LS202207301</td>
                    <td>20220730</td>
                    <td>
                      <a href="MemberEvaluation.html">
                        <button>我要評價</button>
                      </a>
                    </td>
                  </tr>
                </table>
              </div>
            </div>

            <!-- <div class="hero__search"> 
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                    <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
                        <div class="hero__text">
                            <span>FRUIT FRESH</span>
                            <h2>Vegetable <br />100% Organic</h2>
                            <p>Free Pickup and Delivery Available</p>
                            <a href="#" class="primary-btn">SHOP NOW</a>
                        </div> -->
          </div>
        </div>
      </div>
    </section>

    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <!-- <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-1.jpg">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-2.jpg">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-3.jpg">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-4.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-5.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <!-- <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Featured Product</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".oranges">Oranges</li>
                            <li data-filter=".fresh-meat">Fresh Meat</li>
                            <li data-filter=".vegetables">Vegetables</li>
                            <li data-filter=".fastfood">Fastfood</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-1.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fastfood">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-2.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-3.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood oranges">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-4.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-5.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fastfood">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-6.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat vegetables">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-7.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood vegetables">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-8.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">Crab Pool Security</a></h6>
                            <h5>$30.00</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <!-- <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div> -->
    <!-- Banner End -->

    <!-- Latest Product Section Begin -->
    <!-- <section class="latest-product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Latest Products</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Top Rated Products</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Review Products</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                            <div class="latest-prdouct__slider__item">
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-1.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-2.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                                <a href="#" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="img/latest-product/lp-3.jpg" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>Crab Pool Security</h6>
                                        <span>$30.00</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Latest Product Section End -->

    <!-- Blog Section Begin -->
    <!-- <section class="from-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>From The Blog</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="img/blog/blog-1.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                <li><i class="fa fa-comment-o"></i> 5</li>
                            </ul>
                            <h5><a href="#">Cooking tips make cooking simple</a></h5>
                            <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="img/blog/blog-2.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                <li><i class="fa fa-comment-o"></i> 5</li>
                            </ul>
                            <h5><a href="#">6 ways to prepare breakfast for 30</a></h5>
                            <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="img/blog/blog-3.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                <li><i class="fa fa-comment-o"></i> 5</li>
                            </ul>
                            <h5><a href="#">Visit the clean farm in the US</a></h5>
                            <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam quaerat </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Blog Section End -->

  <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.jsp"><img src="./img/Frame 6.svg" alt=""></a>
                        </div>
                        <ul>
                            <li>地址：100 台北市中正區濟南路一段321號</li><!--自然改-->
                            <li>電話：02-12345678</li><!--自然改-->
                            <li>Email: caldonic@gmail.com</li><!--自然改-->
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>相關連結</h6>
<!--                         <ul class="header__menu__dropdown"> -->
<!--                                             <li><a href="./memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li> 自然改 -->
<!--                                             <li><a href="./orderMainFile/OrderMainFile.jsp">訂單查詢</a></li> 自然改 -->
<!--                                             <li><a href="./MemberBenefits.html">會員權益</a></li> 自然改 -->
<!--                                             <li><a href="./CustomerService.html">聯繫客服</a></li> 自然改 -->
<!--                                             <li><a href="./FAQ.html">買家FAQ</a></li> 自然改 -->

<!--                         </ul> -->
                        <ul class="header__menu__dropdown">
                                            <li><a href="./seller/Order">訂單管理</a></li> <!--自然改-->
                                            <li><a href="./seller/product.jsp">商品管理</a></li> <!--自然改-->
                                            <li><a href="./seller/Seller">帳戶管理</a></li> <!--自然改-->
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <!-- <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form> -->
<!--                         <div class="footer__widget__social"> -->
<!--                             <a href="#"><i class="fa fa-facebook"></i></a> -->
<!--                             <a href="#"><i class="fa fa-instagram"></i></a> -->
<!--                             <a href="#"><i class="fa-solid fa-envelope"></i></a> -->
<!--                         </div> -->
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> 版權所有 copyright © 2022 TEAM LETITGO All Rights Reserved.  <!--自然改-->
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <!-- <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div> -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->
    <!-- Js Plugins -->
     <!-- Js Plugins -->
   
    <script src="tickethtml/js/jquery-3.3.1.min.js"></script>
    <script src="tickethtml/js/bootstrap.min.js"></script>
    <script src="tickethtml/js/jquery.nice-select.min.js"></script>
    <script src="tickethtml/js/jquery-ui.min.js"></script>
    <script src="tickethtml/js/jquery.slicknav.js"></script>
    <script src="tickethtml/js/mixitup.min.js"></script>
    <script src="tickethtml/js/owl.carousel.min.js"></script>
    <script src="tickethtml/js/main.js"></script>
     <script>
    $('.hero__categories1__all').on('click', function(){
        $('.hero__categories1 ul').slideToggle(400);
    });
    $('.hero__categories2__all').on('click', function(){
        $('.hero__categories2 ul').slideToggle(400);
    });

    $('.featured__controls1 li').on('click', function () {
            $('.featured__controls1 li').removeClass('active');
            $(this).addClass('active');
        });
        $('.featured__controls2 li').on('click', function () {
            $('.featured__controls2 li').removeClass('active');
            $(this).addClass('active');
        });        
        
    </script>

</body>
</html>