<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.myfavorite.model.*"%>
<%@ page import="com.item.model.*"%>

<%
    Myfavorite_Service myfavoritesvc = new Myfavorite_Service();
	List<Myfavorite_VO> myfavoritelist = myfavoritesvc.getAll();
	pageContext.setAttribute("myfavoritelist",myfavoritelist);
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
    <style>
    li{
    	display:none;
    }
    </style>

    <!-- Google Font -->
    <link
      href="https://fonts.googleapis.com/csㄠs2?family=Cairo:wght@200;300;400;600;900&display=swap"
      
      rel="stylesheet"
    />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet"><!--自然改-->


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
<%--   ${memID} --%>
  

  
  
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>
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

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
      <div class="container">
        <div class="row">

        </div>
      </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <div class="breadcrumb__text">
              <h2>我的最愛</h2>
              <!--鎮鴻改--->
              <div class="breadcrumb__option">
                <a href="./index.html">首頁</a>
                <!--鎮鴻改--->
                <span>我的最愛</span>
                <!--鎮鴻改--->
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Breadcrumb Section End -->

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

                    <!--鎮鴻改，以上四行--->
                    <th></th>
                  </tr>
                </thead>
                
                
                <tbody>
                  <tr>
                                      
                  
                        <table>
    	<c:forEach var="Myfavorite_VO" items="${myfavoritelist}" begin="${offset}" end="<%=myfavoritelist.size()%>">
    	    	<c:if test="${memID == Myfavorite_VO.member_serial_number}">
    	
    	
    	
    	<c:forEach var="Item_VO" items="${list1}" begin="${offset}" end="<%=list1.size()%>">
    	    	<c:if test="${Myfavorite_VO.item_serial_number == Item_VO.item_serial_number}">
    	    	
    	    	
    	    	               <tr>
    	    	
					<td class="shoping__cart__item">
<!--                       <img src="img/cart/cart-1.jpg" alt="" /> -->
                      <h5>${Item_VO.item_name}</h5>
                    </td>

                    <td class="shoping__cart__item__close">
                      <span class="icon_close" onclick="deleteItem(${Myfavorite_VO.my_favorite_number});"></span>
                            <li><a href="#"></a>
                            
    <FORM id="test${Myfavorite_VO.my_favorite_number}" METHOD="post" ACTION="<%=request.getContextPath()%>/Myfavorite_Servlet" >
        <input type="hidden" name="my_favorite_number", value="${Myfavorite_VO.my_favorite_number}">
        <input type="hidden" name="action" value="delete">
        <input id='deleteSubmitButton' type="hidden" value="飯店">
    </FORM>
                            </li>
                            
                                                         		<div  style="border: 5px solid #ddd;">
                 <img id="img_content" src="<%=request.getContextPath()%>/Item_Servlet?action=VOUpdate&No=${Item_VO.item_serial_number}"  name="action"  alt="No Image" style="width:100%;height:280px" />
                                   
         </div>
                            
                    </td>		        
                    <p></p>
               </tr>

                    
                    
                    
                     </c:if>
	</c:forEach>
	
	
	
			
		         </c:if>
		
	</c:forEach>
	</table>

               </tr>
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




        </div>
      </div>
    </section>
    <!-- Shoping Cart Section End -->

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
    	function deleteItem(e) {
    		console.log(e);
    		$('#test' + e).submit();
    	}
//       $("td.shoping__cart__item__close").on("click", "span.icon_close", function(e){
//     	  console.log(e.target);
//     	  console.log('test');
//     	  $('#test').submit();
   
//   });
    </script>
  </body>
</html>
