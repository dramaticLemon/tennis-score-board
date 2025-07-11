<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New Match</title>
	<style>
		body, html {
			margin: 0;
			padding: 0;
			height: 100%;
			font-family: Arial, sans-serif;
		}

		.bg-container {
			position: relative;
			background-image: url('${pageContext.request.contextPath}/images/create-new-match.jpg');
			background-size: cover;
			background-position: center;
			height: 100vh;
			width: 100%;
		}

		.form-wrapper {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			background-color: rgba(255, 255, 255, 0.9); /* немного прозрачный белый */
			padding: 30px;
			border-radius: 8px;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
			width: 300px;
			text-align: center;
		}

		.form-wrapper h2 {
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
			width: 100%;
			padding: 10px;
			border: 1px solid #ddd;
			border-radius: 4px;
			box-sizing: border-box;
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

		.error-message {
			color: red;
			text-align: center;
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="bg-container">
		<c:if test="${not empty errorMessage}">
			<p class="error-message">${errorMessage}</p>
		</c:if>

		<div class="form-wrapper">
			<h2>Create new match</h2>
			<form action="${pageContext.request.contextPath}/new-match" method="POST">
				<div class="form-group">
					<label for="player1Name">Name player 1:</label>
					<input type="text" id="player1Name" name="player-one-name" required>
				</div>
				<div class="form-group">
					<label for="player2Name">Name player 2:</label>
					<input type="text" id="player2Name" name="player-two-name" required>
				</div>
				<button type="submit">Start game</button>
			</form>
		</div>
	</div>

</body>
</html>
