<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Sinh Viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        table {
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-size: 16px;
        }

        input {
            width: 50%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div>
        <h1>Thêm Sinh Viên</h1>
        <form action="../add" method="post" accept-charset="UTF-8">
            <label for="tensv">Tên Sinh Viên</label>
            <input type="text" name="tensv" required>
            <br>
            <label for="lop">Lớp Sinh Viên</label>
            <input type="text" name="lop" required>
            <br>
            <label for="tuoi">Tuổi Sinh Viên</label>
            <input type="text" name="tuoi" required>
            <br>
            <label for="diachi">Địa chỉ Sinh Viên</label>
            <input type="text" name="diachi" required>
            <br>
            <label for="email">Email Nhân viên</label>
            <input type="text" name="email" required>
            <br>
            <input type="submit" value="Thêm Sinh Viên">
        </form>
    </div>
</body>
</html>
