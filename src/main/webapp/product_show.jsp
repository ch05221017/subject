<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.item.model.*"%>
<%@ page import="com.frontpage_announcement.model.*"%>

 <% 
    Frontpage_announcement_Service frontpageservice = new Frontpage_announcement_Service();
	List<Frontpage_announcement_VO> frontpagelist = frontpageservice.getAll();
	pageContext.setAttribute("frontpagelist",frontpagelist);
 %> 
 <%
  Item_Service itemSvc = new Item_Service();
  	List<Item_VO> list1 = itemSvc.getAll();
  	pageContext.setAttribute("list1",list1);
  %> 
<!DOCTYPE html>
<html lang="zxx">
  <head>
    <meta charset="UTF-8" />
    <meta name="description" content="Ogani Template" />
    <meta name="keywords" content="Ogani, unica, creative, html" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>LETITGO</title>

    <!-- Google Font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      rel="stylesheet"
    />
    <!--自然改-->

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <style>
      /* ==================== aside 區域 ==================== */

      main.main ul.item_list {
        margin: 0;
        padding: 0;
        list-style: none;
        display: flex;
        flex-wrap: wrap;
      }
      main.main ul.item_list > li {
        width: calc((100% - 60px) / 4);
        margin-bottom: 20px;
        margin-right: 20px;
      }
      @media screen and (max-width: 767px) {
        main.main ul.item_list > li {
          width: calc((100% - 20px) / 2);
        }
      }
      main.main ul.item_list > li:nth-child(4n) {
        margin-right: 0;
      }
      @media screen and (max-width: 767px) {
        main.main ul.item_list > li:nth-child(2n) {
          margin-right: 0;
        }
      }
      main.main ul.item_list > li > a {
        display: inline-block;
        border: 1px solid red;
        text-decoration: none;
        width: 100%;
      }
      main.main ul.item_list > li > a div.img_block {
        border: 1px solid blue;
        font-size: 0;
      }
      main.main ul.item_list > li > a span.item_text {
        border: 1px solid blue;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        display: block;
        width: 100%;
      }

      /*
 * Copyright (c) 2013 Thibaut Courouble
 * http://www.cssflow.com
 * Licensed under the MIT License
 *
 * Sass/SCSS source: https://goo.gl/1r6UDT
 * PSD by Aaron Sananes: https://goo.gl/AlBLzO
 */

      body {
        font: 12px/20px "Lucida Grande", Verdana, sans-serif;
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
      .widget-list:target:first-of-type
        ~ .widget-tabs
        > .widget-tab:first-child
        ~ .widget-tab,
      .widget-list:target:nth-of-type(2)
        ~ .widget-tabs
        > .widget-tab:nth-child(2)
        ~ .widget-tab,
      .widget-list:target:last-of-type
        ~ .widget-tabs
        > .widget-tab:last-child
        ~ .widget-tab {
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
      .widget-list1:target:first-of-type
        ~ .widget-tabs1
        > .widget-tab1:first-child
        ~ .widget-tab1,
      .widget-list1:target:nth-of-type(2)
        ~ .widget-tabs1
        > .widget-tab1:nth-child(2)
        ~ .widget-tab1,
      .widget-list1:target:last-of-type
        ~ .widget-tabs1
        > .widget-tab1:last-child
        ~ .widget-tab1 {
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
      .widget-list2:target:first-of-type
        ~ .widget-tabs2
        > .widget-tab2:first-child
        ~ .widget-tab2,
      .widget-list2:target:nth-of-type(2)
        ~ .widget-tabs2
        > .widget-tab2:nth-child(2)
        ~ .widget-tab2,
      .widget-list2:target:last-of-type
        ~ .widget-tabs2
        > .widget-tab2:last-child
        ~ .widget-tab2 {
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
      .widget-list:target:first-of-type
        ~ .widget-tabs
        > .widget-tab:first-child
        ~ .widget-tab
        > .widget-tab-link,
      .widget-list:target:nth-of-type(2)
        ~ .widget-tabs
        > .widget-tab:nth-child(2)
        ~ .widget-tab
        > .widget-tab-link,
      .widget-list:target:last-of-type
        ~ .widget-tabs
        > .widget-tab:last-child
        ~ .widget-tab
        > .widget-tab-link {
        margin: 0;
        border-top: 0;
      }
      .widget-tab1 > .widget-tab-link1,
      .widget-list1:target:first-of-type
        ~ .widget-tabs1
        > .widget-tab1:first-child
        ~ .widget-tab1
        > .widget-tab-link1,
      .widget-list1:target:nth-of-type(2)
        ~ .widget-tabs1
        > .widget-tab1:nth-child(2)
        ~ .widget-tab1
        > .widget-tab-link1,
      .widget-list1:target:last-of-type
        ~ .widget-tabs1
        > .widget-tab1:last-child
        ~ .widget-tab1
        > .widget-tab-link1 {
        margin: 0;
        border-top: 0;
      }
      .widget-tab2 > .widget-tab-link2,
      .widget-list2:target:first-of-type
        ~ .widget-tabs2
        > .widget-tab2:first-child
        ~ .widget-tab2
        > .widget-tab-link2,
      .widget-list2:target:nth-of-type(2)
        ~ .widget-tabs2
        > .widget-tab2:nth-child(2)
        ~ .widget-tab2
        > .widget-tab-link2,
      .widget-list2:target:last-of-type
        ~ .widget-tabs2
        > .widget-tab2:last-child
        ~ .widget-tab2
        > .widget-tab-link2 {
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
      .widget-list:target:first-of-type
        ~ .widget-tabs
        > .widget-tab:first-child,
      .widget-list:target:nth-of-type(2)
        ~ .widget-tabs
        > .widget-tab:nth-child(2),
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
      .widget-list1:target:first-of-type
        ~ .widget-tabs1
        > .widget-tab1:first-child,
      .widget-list1:target:nth-of-type(2)
        ~ .widget-tabs1
        > .widget-tab1:nth-child(2),
      .widget-list1:target:last-of-type
        ~ .widget-tabs1
        > .widget-tab1:last-child {
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
      .widget-list2:target:first-of-type
        ~ .widget-tabs2
        > .widget-tab2:first-child,
      .widget-list2:target:nth-of-type(2)
        ~ .widget-tabs2
        > .widget-tab2:nth-child(2),
      .widget-list2:target:last-of-type
        ~ .widget-tabs2
        > .widget-tab2:last-child {
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
      .widget-list:target:first-of-type
        ~ .widget-tabs
        > .widget-tab:first-child
        > .widget-tab-link,
      .widget-list:target:nth-of-type(2)
        ~ .widget-tabs
        > .widget-tab:nth-child(2)
        > .widget-tab-link,
      .widget-list:target:last-of-type
        ~ .widget-tabs
        > .widget-tab:last-child
        > .widget-tab-link {
        margin: 0 -1px;
        border-top: 4px solid #4cc8f1;
      }
      .widget-tab1:last-child > .widget-tab-link1,
      .widget-list1:target:first-of-type
        ~ .widget-tabs1
        > .widget-tab1:first-child
        > .widget-tab-link1,
      .widget-list1:target:nth-of-type(2)
        ~ .widget-tabs1
        > .widget-tab1:nth-child(2)
        > .widget-tab-link1,
      .widget-list1:target:last-of-type
        ~ .widget-tabs1
        > .widget-tab1:last-child
        > .widget-tab-link1 {
        margin: 0 -1px;
        border-top: 4px solid #4cc8f1;
      }
      .widget-tab2:last-child > .widget-tab-link2,
      .widget-list2:target:first-of-type
        ~ .widget-tabs2
        > .widget-tab2:first-child
        > .widget-tab-link2,
      .widget-list2:target:nth-of-type(2)
        ~ .widget-tabs2
        > .widget-tab2:nth-child(2)
        > .widget-tab-link2,
      .widget-list2:target:last-of-type
        ~ .widget-tabs2
        > .widget-tab2:last-child
        > .widget-tab-link2 {
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
  
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    
<!--     <table> -->
<%--     	<c:forEach var="Item_VO" items="${list1}" begin="${offset}" end="<%=list1.size()%>"> --%>
<!-- 		<tr> -->
<%-- 		<td>${Item_VO.item_serial_number}</td> --%>
<%-- 		<td>${Item_VO.item_name}</td> --%>
<%-- 		<td>${Item_VO.item_description}</td> --%>
<%-- 		<td>${Item_VO.item_price}</td> --%>
<%-- 		<td>${Item_VO.item_stock}</td> --%>
<%-- 		<td>${Item_VO.seller_serial_number}</td> --%>
<%-- 		<td>${Item_VO.item_category_number}</td> --%>
<%-- 		<td>${Item_VO.item_status_number}</td>	 --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
<!-- 	</table> -->
	
    
<!--     	<tr> -->
<%-- 		<td>${Item_category_VO.item_category_number}</td> --%>
<%-- 		<td>${Item_category_VO.item_category_main_name}</td> --%>
<%-- 		<td>${Item_category_VO.item_category_area_name}</td> --%>
<%-- 		<td>${Item_category_VO.item_category_detail_name}</td> --%>

<!-- 	</tr> -->
	

	
<!-- 	                            <li><a href="#"></a> -->
<%--     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/search_item" > --%>
<!--         <input type="hidden" name="item_serial_number", value="87878701"> -->
<!--         <input type="hidden" name="action" value="getOne_For_Display_for_item"> -->
<!--         <input type="submit" value="一個"> -->
<!--     </FORM> -->
<!--                             </li> -->
<!-- 	                            <li><a href="#"></a> -->
<%--     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/search_item" > --%>
<!--         <input type="hidden" name="item_serial_number", value="87878701"> -->
<!--         <input type="hidden" name="action" value="getOne_For_Display_for_item"> -->
<!--         <input type="submit" value="多個"> -->
<!--     </FORM> -->
<!--                             </li> -->
                            


    <section class="hero">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="hero__categories">
              <div class="hero__categories__all">
                <i class="fa fa-bars"></i>
                <span>美食</span
                ><!--自然改-->
              </div>
                        <ul>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="111">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="中式">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="112">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="西式">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="113">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="東南亞">
    </FORM>
                            </li>
                        </ul>
                    </div>
                    <div class="hero__categories1">
                        <div class="hero__categories1__all">
                            <i class="fa fa-bars"></i>
                            <span>景點</span><!--自然改-->
                        </div>
                        <ul>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="211">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="遊樂園">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="212">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="風景區">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="213">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="展覽">
    </FORM>
                            </li>

                        </ul>
                    </div>
                    <div class="hero__categories2">
                        <div class="hero__categories2__all">
                            <i class="fa fa-bars"></i>
                            <span>住宿</span><!--自然改-->
                        </div>
                        <ul>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="311">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="青旅">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="312">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="飯店">
    </FORM>
                            </li>
                            <li><a href="#"></a>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_category_Servlet" >
        <input type="hidden" name="item_category_number", value="313">
        <input type="hidden" name="action" value="getOne_For_Display_For_item_category">
        <input type="submit" value="民宿">
    </FORM>
                            </li>

                        </ul>
            </div>
          </div>
          <div class="col-lg-9">
            <div class="hero__search" style="height: 165px">


              <div class="hero__search__form">
                <form action="#">
                  <!-- <div class="hero__search__categories">
                                </div> -->
                  <!-- <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button> -->

                             <table>
    	<c:forEach var="Frontpage_announcement_VO" items="${frontpagelist}" begin="${offset}" end="<%=frontpagelist.size()%>">
    	    	    	<c:if test="${Frontpage_announcement_VO.frontpage_announcement_status == 1}">
    	
<%-- 		${Frontpage_announcement_VO.frontpage_announcement_serial_number}<span>為優惠券號碼</span> --%>
		${Frontpage_announcement_VO.frontpage_announcement_description}
				<br>
		
				         </c:if>
		
	</c:forEach>
	</table>
                </form>
              </div>
              <!-- <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div> -->
            </div>
            <div
              class="hero__item set-bg"
              data-setbg="https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
            >
              <!-- <div class="hero__text">
                            <span>FRUIT FRESH</span>
                            <h2>Vegetable <br />100% Organic</h2>
                            <p>Free Pickup and Delivery Available</p>
                            <a href="#" class="primary-btn">SHOP NOW</a>
                        </div> -->
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <!-- Hero Section End -->
    <main class="main">
      <ul class="item_list">

    <table>
    	<c:forEach var="Item_VO" items="${list1}" begin="${offset}" end="<%=list1.size()%>">
    	<c:if test="${Item_VO.item_category_number == Item_category_VO.item_category_number}">
        
                <li>
          
<!--               <img src="https://fakeimg.pl/400x300/" /> -->
<%--               ${Item_VO.photo} --%>
              
              
              
 		<div  style="border: 5px solid #ddd;">
                 <img id="img_content" src="<%=request.getContextPath()%>/Item_Servlet?action=VOUpdate&No=${Item_VO.item_serial_number}"  name="action"  alt="No Image" style="width:100%;height:260px" />
                                   
         </div>
                                    
                                    
                    
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Item_Servlet" >
        <input type="hidden" name="item_serial_number", value="${Item_VO.item_serial_number}">
        <input type="hidden" name="action" value="getOne_For_Display_for_item_show">
                <input type="submit" value="跳轉">
            <span class="item_text"
              >${Item_VO.item_name}</span>
    
        </li>
        
        <input type="hidden" name="temporary", value=${Item_VO.item_serial_number}>
        
    </FORM>

         </c:if>
	</c:forEach>
	</table>
      </ul>

    </main>

   

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
    <section class="from-blog spad">
      <div class="container">
        <!-- <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>From The Blog</h2>
                    </div>
                </div>
            </div> -->
        <!-- <div class="row">
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
            </div> -->
      </div>
    </section>
    <!-- Blog Section End -->

    <jsp:include page="/footer.jsp"></jsp:include>

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
      $(".hero__categories1__all").on("click", function () {
        $(".hero__categories1 ul").slideToggle(400);
      });
      $(".hero__categories2__all").on("click", function () {
        $(".hero__categories2 ul").slideToggle(400);
      });

      $(".featured__controls1 li").on("click", function () {
        $(".featured__controls1 li").removeClass("active");
        $(this).addClass("active");
      });
      $(".featured__controls2 li").on("click", function () {
        $(".featured__controls2 li").removeClass("active");
        $(this).addClass("active");
      });
    </script>
  </body>
</html>
