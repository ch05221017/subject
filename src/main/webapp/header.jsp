<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LETITGO</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet"><!--自然改-->

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>

/*
 * Copyright (c) 2013 Thibaut Courouble
 * http://www.cssflow.com
 * Licensed under the MIT License
 *
 * Sass/SCSS source: https://goo.gl/1r6UDT
 * PSD by Aaron Sananes: https://goo.gl/AlBLzO
 */

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
                    <a href="#"><img src="/subject/src/main/webapp/img/logo.png" alt=""></a><!--自然改-->
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
                                            <li><a href="./FAQ.html">買家FAQ</a></li> <!--自然改-->
                            </ul>
                        </li>
                        <li><a href="#">賣家中心</a>
                            <ul class="header__menu__dropdown">
                                            <li><a href="./sellers/Order.jsp">訂單管理</a></li> <!--自然改-->
                                            <li><a href="./sellers/product.jsp">商品管理</a></li> <!--自然改-->
                                            <li><a href="./sellers/Seller.jsp">帳戶管理</a></li> <!--自然改-->
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
                                <a href="./index.jsp"><img src="./img/Frame 6.svg" alt=""></a><!--自然改-->
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <nav class="header__menu">
                                <ul>
                                    <li><a href="#">會員中心</a>
                                        <ul class="header__menu__dropdown">
                                            <li><a href="./memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li> <!--自然改-->
                                            <li><a href="./orderMainFile/OrderMainFile.jsp">訂單查詢</a></li> <!--自然改-->
                                            <li><a href="./MemberBenefits.html">會員權益</a></li> <!--自然改-->
                                            <li><a href="./CustomerService.html">聯繫客服</a></li> <!--自然改-->
                                            <li><a href="./FAQ.html">買家FAQ</a></li> <!--自然改-->
        
                                        </ul>
                                    </li>
                                    <li><a href="#">賣家中心</a>
                                        <ul class="header__menu__dropdown">
                                           <li><a href="./sellers/Order.jsp">訂單管理</a></li> <!--自然改-->
                                            <li><a href="./sellers/product.jsp">商品管理</a></li> <!--自然改-->
                                            <li><a href="./sellers/Seller.jsp">帳戶管理</a></li> <!--自然改-->

                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-lg-3">
                            <div class="header__cart">
                                <ul>
                                    <li><a href="./my_favorite.jsp"><i class="fa fa-heart"></i> </a></li><!--自然改-->
                                    <li><a href="./index.jsp"><i class="fa-solid fa-house"></i> </a></li><!--自然改--><!--這個圖示用來做回首頁-->
                                    <li><a href="./shoping-cart.html"><i class="fa-solid fa-cart-shopping"></i> </a></li><!--自然改--><!--這個圖示用來做購物車-->
                                    <li><a href="./ticket/listAllTicket.jsp"><i class="fa-solid fa-ticket"></i></a></li> <!--自然改--><!--這個圖示用來做我的票券-->
                                    <li><a href="./login.html"><i class="fa-solid fa-person"></i></a></li> <!--自然改--><!--這個圖示用來做登入-->
                                    <li><a href="./logout"><i class="fa fa-sign-out"></i></a></li> <!--自然改--><!--這個圖示用來做登入-->
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



    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
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