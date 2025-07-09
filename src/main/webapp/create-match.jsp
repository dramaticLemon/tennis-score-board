<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New Match</title>
	<style>
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .container h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        .form-group input[type="text"] {
            width: calc(100% - 20px); /* Adjust for padding */
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box; /* Include padding and border in the element's total width and height */
            font-size: 16px;
        }
        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.2s ease-in-out;
        }
        button:hover {
            background-color: #0056b3;
        }
	</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
        <h2>Create new match</h2>
        <form action="${pageContext.request.contextPath}/new-match" method="POST">
            <div class="form-group">
                <label for="player1Name">Name player 1:</label>
                <input type="text" id="player1Name" name="player1Name" required>
            </div>
            <div class="form-group">
                <label for="player2Name">Name player 2:</label>
                <input type="text" id="player2Name" name="player2Name" required>
            </div>
            <button type="submit">Starn game</button>
        </form>
    </div>
</body>
</html>