<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<style>
		body {
			margin: 0;
			padding: 0;
			font-family: Arial, sans-serif;
			background-color: #f5f5f5;
		}

		.main-container {
			max-width: 800px;
			margin: 0 auto;
			padding: 40px 20px;
			text-align: center;
		}

		img {
			max-width: 100%;
			height: auto;
			border-radius: 10px;
			box-shadow: 0 2px 10px rgba(0,0,0,0.1);
			margin-bottom: 30px;
		}

		.button-container {
			display: flex;
			justify-content: center;
			gap: 20px;
			flex-wrap: wrap;
		}

		.button-container a {
			text-decoration: none;
		}

		button {
			background-color: #007bff;
			color: white;
			border: none;
			padding: 12px 25px;
			font-size: 1rem;
			border-radius: 8px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}

		button:hover {
			background-color: #0056b3;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="main-container">
		<img src="${pageContext.request.contextPath}/images/home.jpeg" alt="index-image">

		<div class="button-container">
			<a href="${pageContext.request.contextPath}/new-match">
				<button>Create match</button>
			</a>
			<a href="${pageContext.request.contextPath}/mathes">
				<button>Matches archive</button>
			</a>
		</div>
	</div>
</body>
</html>
