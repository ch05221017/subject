<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>blacklist</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>blacklist</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for blacklist</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllBlacklist.jsp'>List</a> all blacklist.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/blacklist/blacklist.do" >
        <b>輸入會員流水編號 (如1636001):</b>
        <input type="text" name="memberserialnumber">
        <input type="hidden" name="action" value="">
        <input type="submit" value="送出">
    </FORM>
  </li>

<%--   <jsp:useBean id="blacklistSvc" scope="page" class="subject.blacklist.model.BlacklistService" /> --%>
  <% 
     subject.blacklist.model.BlacklistDAO dao = new subject.blacklist.model.BlacklistDAO(); 
     pageContext.setAttribute("dao", dao);
  %>
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/blacklist/blacklist.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="blacklistnumber">
         <c:forEach var="blacklistVO" items="${blacklistSvc.all}" > 
          <option value="${blacklistVO.blacklist}">${blacklistVO.blacklist}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/blacklist/blacklist.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="blacklistnumber">
         <c:forEach var="blacklistVO" items="${blacklistSvc.all}" > 
          <option value="${blacklistVO.blacklist}">${blacklistVO.blacklist}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addBlacklist.jsp'>Add</a> a new Blacklist.</li>
</ul>

</body>
</html>