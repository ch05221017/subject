<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.order_detail.model.*"%>


<%
    Order_detail_Service orderdetailSvc = new Order_detail_Service();
	List<Order_detail_VO> orderdetaillist = orderdetailSvc.getAll();
	pageContext.setAttribute("orderdetaillist",orderdetaillist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--               ${Order_detail_VO.order_detail_serial_number} --%>


<!--     <table> -->
<%--     	<c:forEach var="Order_detail_VO" items="${orderdetaillist}" begin="${offset}" end="<%=orderdetaillist.size()%>"> --%>
        
<!--                 <li> -->
          
<%--               ${Order_detail_VO.order_detail_serial_number} --%>
    
<!--         </li> -->
        
        
<!--     </FORM> -->

<%-- 	</c:forEach> --%>
<!-- 	</table> -->

			<img src="${fileName}">

<%--               ${fileName} --%>
	
</body>
</html>