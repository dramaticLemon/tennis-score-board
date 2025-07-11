<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="centered-container">
	<a href="${pageContext.request.contextPath}/new-match">
	  <button>Create math</button>
	</a>
	<a href="${pageContext.request.contextPath}/mathes">
	  <button>Mathes arhive</button>
	</a>
  </div>
</body>
</html>