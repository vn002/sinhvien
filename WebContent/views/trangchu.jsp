<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #navbar {
            background-color: #333;
            overflow: hidden;
        }

        #navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        #navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        #content {
            padding: 20px;
        }
    </style>
</head>
<body>

<div id="navbar">
    <a href="../home" onclick="showStudents()">Danh sách sinh viên</a>
    <a href="views/login.jsp" onclick="showLogin()">Login</a>
    <a href="#" onclick="logout()" id="logoutBtn" style="display: none;">Logout</a>
</div>

<div id="content">
    <!-- Nội dung sẽ được cập nhật ở đây -->
</div>

<script src="script.js"></script>

</body>
</html>
