<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        #btn {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <header>
        <h1>Quản lý sinh viên</h1>
    </header>

    <form action="../update" method="post" accept-charset="UTF-8">
        <label for="id">Mã sinh viên:</label>
       <input type="hidden" name="id" value="<%=request.getParameter("id")%>">


        <label for="tensv">Họ và tên</label>
        <input type="text" name="tensv" value="<%=request.getParameter("tensv")%>" required>

        <label for="tuoi">Tuổi</label>
        <input type="text" name="tuoi" value="<%=request.getParameter("tuoi")%>" required>

        <label for="lop">Lớp</label>
        <input type="text" name="lop" value="<%=request.getParameter("lop")%>" required>

        <label for="diachi">Địa chỉ</label>
        <input type="text" name="diachi" value="<%=request.getParameter("diachi")%>" required>

        <label for="email">Email</label>
        <input type="text" name="email" value="<%=request.getParameter("email")%>" required>

        <input id="btn" type="submit" value="Cập nhật thông tin Sinh viên">
        
    </form>
</body>
</html>
