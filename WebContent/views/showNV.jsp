
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý sinh viên</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	font-family: 'Arial, sans-serif';
}

/* Style cho menu */
ul.nav {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li.nav {
	float: left;
}

li.nav a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li.nav a:hover {
	background-color: #555;
}

/* Style cho bảng sinh viên */
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #333;
	color: white;
}

/* Style cho thẻ a (liên kết) */
a {
	color: #333;
	text-decoration: none;
}

a:hover {
	color: #555;
}

/* Style cho nút "Thêm sinh viên" */
.add-button {
	display: inline-block;
	padding: 10px 20px;
	font-size: 16px;
	text-align: center;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.add-button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<!-- Nội dung trang -->
	<ul class="nav">
		<li class="nav"><a href="views/trangchu.jsp">Trang Chủ</a></li>
		<li class="nav"><a href="home">Danh sách sinh viên</a></li>
		<li class="nav"><a href="views/login.jsp">Login</a></li>
		<li class="nav"><a href="views/login.jsp">Logout</a></li>
	</ul>

	<h3 style="text-align: center;">Danh sách sinh viên</h3>
	<div style="width: 800px; margin: 0 auto;">
		<a href="views/addsv.jsp" class="add-button">Thêm sinh viên</a>
		 <!-- Search Form -->
  <form action="search" method="POST" style="float: right; margin-bottom: 10px;">
    <input value = "${txts }" type="text" name="keyword" placeholder="Enter search...">
    <button type="submit">Search</button>
</form>
		<table>
			<thead>
				<tr>
					<th>Mã SV</th>
					<th>Student's name</th>
					<th>Class</th>
					<th>Old</th>
					<th>Address</th>
					<th>Email</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<!-- Sử dụng thẻ c:forEach để lặp qua danh sách sinh viên -->
				<c:forEach var="sv" items="${lishsv}">
					<tr>
						<td><c:out value="${sv.id}" /></td>
						<td><c:out value="${sv.tensv}" /></td>
						<td><c:out value="${sv.lop}" /></td>
						<td><c:out value="${sv.tuoi}" /></td>
						<td><c:out value="${sv.diachi}" /></td>
						<td><c:out value="${sv.email}" /></td>
						<td>
							<!-- Sửa liên kết cập nhật --> &ensp;<a class = ""
							href="views/updatesv.jsp?id=${sv.id}&tensv=${sv.tensv}&lop=${sv.lop}&tuoi=${sv.tuoi}&diachi=${sv.diachi}&email=${sv.email}
							 "  >Edit</a>
							 <p class="text-success">${hienthi}</p>
							&ensp; <a href="delete?idsv=${sv.id}"
							onclick="return confirm('Bạn có muốn chắc chắn xóa hay không?')"
							class="btn btn-danger">Delete</a>
						</td>



						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
	<!-- <script>
    window.location.href = 'views/trangchu.jsp';
</script> -->

</html>







