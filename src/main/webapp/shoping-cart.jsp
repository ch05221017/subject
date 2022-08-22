<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mycart.model.*"%>
<%@ page import="com.item.model.*"%>

<%
    Mycart_Service cartsvc = new Mycart_Service();
	List<Mycart_VO> cartlist = cartsvc.getAll();
	pageContext.setAttribute("cartlist",cartlist);
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
  <title>Ogani | Template</title>

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet" />
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
</head>

<body>
  <!-- Page Preloder -->
  <!-- <div id="preloder">
      <div class="loader"></div>
    </div> -->
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


  <!--一鍵購物車 -->
  <!-- Shoping Cart Section Begin -->
  <section class="shoping-cart spad">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="shoping__cart__table">
            <table>
              <thead>
                <tr>
                  <th class="shoping__product">商品</th>
                  <th>單價</th>
                  <th>數量</th>
                  <th>總價(元)</th>
                  <!--鎮鴻改，以上四行--->
                  <th></th>
                </tr>
              </thead>
              
              
              <c:set var="ageTotal" value="${0}" />
              
              
<%--               <%int sum; %> --%>
              
                                      <table>
    	<c:forEach var="Mycart_VO" items="${cartlist}" begin="${offset}" end="<%=cartlist.size()%>">
    	    	<c:if test="${memID == Mycart_VO.member_serial_number}">
    	
    	
    	
    	<c:forEach var="Item_VO" items="${list1}" begin="${offset}" end="<%=list1.size()%>">
    	    	<c:if test="${Mycart_VO.item_serial_number == Item_VO.item_serial_number}">
    	    	
    	    	
    	    	               <tr>
    	    	
					<td class="shoping__cart__item">
<!--                       <img src="img/cart/cart-1.jpg" alt="" /> -->

                      <h5>${Item_VO.item_name}</h5>
                      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                      <h5>${Math.round(Item_VO.item_price*0.9) * 1}</h5>
                      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                      <h5>${Mycart_VO.cart_item_quantity * 1}</h5>
                      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                      <h5>${Mycart_VO.cart_item_quantity * 1 * Math.round(Item_VO.item_price*0.9)}</h5>
<%--                       <%int a = ${Mycart_VO.cart_item_quantity} ; %> --%>
  <c:set var="ageTotal" value="${ageTotal + Mycart_VO.cart_item_quantity*Math.round(Item_VO.item_price*0.9)}" />


    <FORM  METHOD="post" ACTION="<%=request.getContextPath()%>/Mycart_Servlet" >
        <input type="hidden" name="my_cart_number", value="${Mycart_VO.cart_serial_number}">
        <input type="hidden" name="action" value="deletecart">
        <input type="submit" value="刪除">
    </FORM>
                    </td>

<!--                     <td class="shoping__cart__item__close"> -->
<%--                       <span class="icon_close" onclick="deleteItem(${Mycart_VO.my_favorite_number});"></span> --%>
<!--                             <li><a href="#"></a> -->
                            

                            </li>
                            
<!--                                                          		<div  style="border: 5px solid #ddd;"> -->
<%--                  <img id="img_content" src="<%=request.getContextPath()%>/Item_Servlet?action=VOUpdate&No=${Item_VO.item_serial_number}"  name="action"  alt="No Image" style="width:100%;height:280px" /> --%>
                                   
<!--          </div> -->
                            
<!--                     </td>		         -->
                    <p></p>
               </tr>

                    
                    
                    
                     </c:if>
	</c:forEach>
	
	
	
			
		         </c:if>
		
	</c:forEach>
	</table>
	
	
	
              
              

              <tbody id="cart_body">
                <!-- ====商品開始==== -->
                <!-- <tr id="tr_cart">
                    <td class="shoping__cart__item">
                      <img src="img/cart/cart-2.jpg" alt="" /> 
                      <h5><span id="product_name" class="card-title">香蕉你的芭樂</span></h5>
                    </td>
                    <td class="shoping__cart__price">
                      <span id="price" class="card-text">80</span> -->
                <!-- 鎮鴻改-span -->
                <!-- </td>
                    <td class="shoping__cart__quantity">
                      <div class="quantity">
                        <div class="pro-qty add_cart"  > -->
                <!-- data-price="80" -->
                <!-- <input type="text" value="1" class="qy_val amount" /> -->
                <!-- 鎮鴻改-input+class -->
                <!-- </div>
                      </div>
                    </td>
                    <td class="shoping__cart__total">
                      <span id="price_total"></span> -->
                <!-- 鎮鴻改-span -->
                <!-- </td>
                    <td class="shoping__cart__item__close">
                      <span class="icon_close"></span>
                    </td>
                  </tr>
                  <tr id="tr_cart">
                    <td class="shoping__cart__item"> -->
                <!-- <img src="img/cart/cart-3.jpg" alt="" /> -->
                <!-- <span id="product_name">乾檸檬雞排</span></h5>
                    </td>
                    <td class="shoping__cart__price">
                      <span id="price">60</span> -->
                <!-- 鎮鴻改-span -->
                <!-- </td>
                    <td class="shoping__cart__quantity">
                      <div class="quantity">
                        <div class="pro-qty add_cart"  > -->
                <!-- data-price="60" -->
                <!-- <input type="text" value="1" class="qy_val amount"  /> -->
                <!-- 鎮鴻改-input+class -->
                <!-- </div>
                      </div>
                    </td>
                    <td class="shoping__cart__total">
                      <span id="price_total">69</span> -->
                <!-- 鎮鴻改-span -->
                <!-- </td>
                    <td class="shoping__cart__item__close">
                      <span class="icon_close"></span>
                    </td>
                  </tr> -->
                <!-- ====商品結束==== -->
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <!-- <div class="shoping__cart__btns">
              <a href="#" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
              <a href="#" class="primary-btn cart-btn cart-btn-right"
                ><span class="icon_loading"></span> Upadate Cart</a
              >
            </div> -->
          <!-- 鎮鴻改-以上五行 -->
          <!-- </div> -->
          <!-- <div class="col-lg-3">
            <div class="shoping__continue">
              <div class="shoping__discount">
                <h5>優惠券</h5>
                <form action="#">
                  <input
                    id="coupon_val"
                    name="couponname"
                    class="SELECT_COUPON_NAME"
                    type="text"
                    placeholder="請輸入優惠券名稱"
                    pattern="[a-zA-Z]{0,}"
                  />
              
                  <input type="button" class="site-btn" id="coupon_use" value="使用" >
                  </input>
      
                </form>
              </div>
            </div>
          </div> -->
          <!-- 鎮鴻改-以上為Discount Codes  -->
          <!-- <div class="col-lg-3">
            <div class="shoping__continue">
              <div class="shoping__discount">
                <h5>購物金</h5>
                <form action="#">
                  <input
                    id="golden_val"
                    type="text"
                    placeholder="請輸入使用之購物金金額"
                    pattern="\d{0,}"
                  /> -->
          <!-- 鎮鴻改-新增正規化驗證pattern數字四碼 -->
          <!-- <input
                    type="button"
                    class="site-btn"
                    id="golden_use"
                    value="使用"
                  />  </input> -->
          <!-- 鎮鴻改-綁使用存在local -->
          <!-- </form>
              </div>
            </div>
          </div> -->
          <!-- 鎮鴻改-以上為購物金使用金額-->
          <div class="col-lg-">
            <div class="shoping__checkout">
              <ul>
                <!-- <li>Subtotal <span>$454.98</span></li> -->
                <li>總計(元) <span id="total_cart">${ageTotal}</span></li>
              </ul>
              <a href="./checkout.html" class="primary-btn" id="upcoming_pay">進行付款</a>
              <!--鎮鴻改-實際上線時須變更連結及按鈕id-->
              <hr />
<!--               <a class="btn btn-secondary text-white" id="clear">清空購物車</a> -->
              <!-- 鎮鴻改-以上測試按鈕-->
            </div>
            <!-- 鎮鴻改-以上為購物車總價區  -->
          </div>
        </div>
      </div>
  </section>
  <!-- Shoping Cart Section End -->
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
                        <ul class="header__menu__dropdown">
                                            <li><a href="./memberupdate/listAllMemberupdate.jsp">帳戶管理</a></li> <!--自然改-->
                                            <li><a href="./orderMainFile/OrderMainFile.jsp">訂單查詢</a></li> <!--自然改-->
                                            <li><a href="./MemberBenefits.html">會員權益</a></li> <!--自然改-->
                                            <li><a href="./CustomerService.html">聯繫客服</a></li> <!--自然改-->
                                            <li><a href="./FAQ.html">買家FAQ</a></li> <!--自然改-->

                        </ul>
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
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.nice-select.min.js"></script>
  <script src="js/jquery-ui.min.js"></script>
  <script src="js/jquery.slicknav.js"></script>
  <script src="js/mixitup.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/main.js"></script>

  <script>
    //// 鎮鴻改sessionStorage
    $(function () {
      const getCart = () => {
        if (sessionStorage.getItem("memcart_data")) {
          var memcart = JSON.parse(sessionStorage.getItem("memcart_data"));
          console.log(memcart);
          var price = 0;
          var total = 0;
          var i = 0;
          //// 設定唯一值index刪除memcart_data
          for (i = 0; i < memcart.length; i++) {
            var html = "";
            html += `
            <tr id="tr_cart" class="${memcart[i].itemserialnumber}">
                <td class="shoping__cart__item">
                  <h5><span id="product_name" class="card-title">${memcart[i].itemname
              }</span></h5></td>
                <td class="shoping__cart__price">
                  <span id="price" class="card-text">${memcart[i].itemprice
              }元</span></td>
                <td class="shoping__cart__quantity">
                  <div class="quantity">
                    <div class="pro-qty add_cart">
                      <input type="text" value=" ${memcart[i].itemquantity
              }" class="qy_val amount" data="${i}"/>
                 </div>
                      </div></td>
                      <td class="shoping__cart__total">
                      <span id="price_total"></span>${memcart[i].itemprice * memcart[i].itemquantity
              } </td>
                          <td class="shoping__cart__item__close">
                      <span class="icon_close"></span>
                    </td>
                          </tr>  `;
            ////計算單項商品總價
            price = memcart[i].itemprice * memcart[i].itemquantity;
            ////計算購物車總價
            total += price;
            $("#cart_body").append(html);
            $("#total_cart").html(total);
          }
          ///數量更新
          $(".qy_val").on("change",
            function (e) {
              let c = confirm("確認是否更新此項商品?");
              if (c) {
                $(this)
                  .closest("#tr_cart")
                  .find(".qy_val")
                  .val();

                var index = this.getAttribute("data");
                memcart[index]["itemquantity"] = Number(this.value);
                console.log("======", memcart)

                sessionStorage.setItem("memcart_data", JSON.stringify(memcart)); //更新sessionStorage
                location.reload(); //網頁重整
              }
            }
          );
          ////移除商品
          // $("td.shoping__cart__item__close").on(
          //   "click",
          //   "span.icon_close",
          //   function (e) {
          //     let c = confirm("確認是否移除此項商品?");
          //     if (c) {
          //       $(this)
          //         .closest("#tr_cart")
          //         .fadeOut(100, () => {
          //           $(this).remove(); //移除網頁上被指定項目
          //           console.log(memcart[i]);
          //           // console.log(i);
          //           memcart.splice(memcart.indexOf("memcart[i]")); //刪除陣列單項商品
          //           sessionStorage.setItem(
          //             "memcart_data",
          //             JSON.stringify(memcart)
          //           ); //sessionStorage
          //           location.reload(); //網頁重整(只能從最後一個刪)
          //         });
          //     }
          //   }
          // );
        }

      }
      ////購物車項目
      ////清空購物車
     
    /*-------------------
            Quantity change
          // --------------------- */
    // $(function () {
    //   var proQty = $(".pro-qty");
    //   proQty.prepend('<span class="dec qtybtn">-</span>');
    //   proQty.append('<span class="inc qtybtn">+</span>');
    //   proQty.on("click", ".qtybtn", function () {
    //     var $button = $(this);
    //     var oldValue = $button.parent().find("input").val();
    //     if ($button.hasClass("inc")) {
    //       var newVal = parseFloat(oldValue) + 1;
    //     } else {
    //       // Don't allow decrementing below zero
    //       if (oldValue > 0) {
    //         var newVal = parseFloat(oldValue) - 1;
    //       } else {
    //         newVal = 0;
    //       }
    //     }
    //     $button.parent().find("input").val(newVal);
    //   });
    // });




    })
  </script>
  <script>


  </script>
</body>

</html>