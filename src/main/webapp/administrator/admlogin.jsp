<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>LetItGo | 維護人員系統</title>

<style>   
 
 
</style>

<!-- <img src="./images/Adm4.svg" with="600" heigh="400" alt="一張圖片"> -->
<!-- <body background="./images/Adm4.svg"> -->
<style>
/* body { */
/* 	background-image: url("./images/"); */
/* 	background-color: rgb(29, 230, 237) */
/* }  */
         
</style>
<style>   
     .outer {
  background-color: #bce1f0;
  display: table; /* ★ */
  height: 300px;
}
.inner {
  background-color: #d5e1a3;
  display: table-cell; /* ★ */
  vertical-align: middle; /* ★ */
}

</style>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<div style="display: flex; justify-content: center; align-items: center;">
 <a href="#" class="brand-link">
          <img
            src="./images/Frame 6.svg"
            alt="LETITGO Logo"
            class="brand-image elevation-3"
            style="opacity: 0.8"
          />
         <span class="brand-text font-weight-light"></span>
       	</a>
       	
</div>

<br>
<div style="display: flex; justify-content: center; align-items: center;">
<h3></h3>
</div>
<div style="display: flex; justify-content: center; align-items: center;">
<form action="<c:url value="/administrator/admlogin.controller" />" method="get">
<table>
	<tr>
		<td>帳號 : </td>
		<td><input type="text" name="admname" value="${param.admname}"></td>
		<td><span class="error">${errors.admname}</span></td>
	</tr>
	<tr>
		<td>密碼 : </td>
		<td><input type="text" name="password" value="${param.password}"></td>
		<td><span class="error">${errors.password}</span></td>
	</tr>
	<tr>
		<td> </td>
		<td align="right"><input type="submit" value="登入"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>