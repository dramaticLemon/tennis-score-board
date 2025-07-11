<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Match Archive</title>
    <style>
        body {
            font-family: 'Comic Sans MS', cursive, sans-serif; /* A font similar to the image's handwriting */
            background-color: #fcefe7; /* Light peachy background */
            margin: 0;
            padding: 0; /* Remove padding from body to let header span full width if it desires */
            display: flex;
            flex-direction: column;
            /* No align-items: center here to prevent centering everything */
        }
        .main-content {
            display: flex;
            flex-direction: column;
            align-items: center; /* Center the main content (title, search, match blocks) */
            padding: 20px; /* Add padding here for the main content area */
            width: 100%;
        }
        h1 {
            text-align: center;
            margin-top: 30px;
            color: #333;
            width: 100%; /* Ensure heading takes full width for centering */
        }
        .search-form {
            margin: 20px 0;
            padding: 15px;
            background-color: white;
            border: 1px solid #d3c6bc;
            border-radius: 10px;
            box-shadow: 1px 1px 5px rgba(0,0,0,0.05);
            display: flex;
            gap: 10px;
            align-items: center;
            max-width: 600px; /* Match max-width of match blocks */
            width: 100%;
        }
        .search-form label {
            font-weight: bold;
            color: #555;
        }
        .search-form input[type="text"] {
            flex-grow: 1; /* Allows input to take up available space */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }
        .search-form button {
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }
        .search-form button:hover {
            background-color: #0056b3;
        }
        .match-container {
            display: flex;
            flex-direction: column;
            gap: 20px; /* Space between match blocks */
            width: 100%;
            max-width: 600px; /* Max width for the match blocks */
            margin-top: 20px; /* Space between search form and first match */
        }
        .match-block {
            background-color: white;
            border: 1px solid #d3c6bc; /* Softer border color */
            border-radius: 15px; /* Rounded corners */
            padding: 15px 25px;
            box-shadow: 2px 2px 8px rgba(0,0,0,0.1); /* Subtle shadow */
            display: flex;
            justify-content: space-around;
            align-items: center;
            text-align: center;
            flex-wrap: wrap; /* Allow wrapping on smaller screens */
        }
        .match-item {
            flex: 1; /* Distribute space equally */
            min-width: 120px; /* Minimum width for each item to prevent too much squishing */
            margin: 5px; /* Small margin around items */
        }
        .match-label {
            font-size: 0.9em;
            color: #666;
            margin-bottom: 5px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        .match-name {
            font-size: 1.2em;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>

    <jsp:include page="header.jsp" />

    <div class="main-content">
        <h1>Match Archive</h1>

        <form action="${pageContext.request.contextPath}/mathes" method="POST" class="search-form">
            <label for="query">Search:</label>
            <input type="text" id="query" name="query" placeholder="Enter player name or match ID" value="${param.query}">
            <button type="submit">Search</button>
        </form>

        <div class="match-container">
            <c:choose>
                <c:when test="${empty matchesList}">
                    <p style="text-align: center; color: #777; margin-top: 30px;">No matches found.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="match" items="${matchesList}">
                        <div class="match-block">
                            <div class="match-item">
                                <div class="match-label">player 1</div>
                                <div class="match-name">&lt; ${match.alfa.name} &gt;</div>
                            </div>
                            <div class="match-item">
                                <div class="match-label">player 2</div>
                                <div class="match-name">&lt; ${match.omega.name} &gt;</div>
                            </div>
                            <div class="match-item">
                                <div class="match-label">winner</div>
                                <div class="match-name">&lt; ${match.winner.name} &gt;</div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <div style="text-align: center; margin-top: 20px;">
    <c:if test="${totalPages > 1}">
        <c:if test="${currentPage > 1}">
            <a href="?page=${currentPage - 1}">&laquo; Previous</a>
        </c:if>

        <c:forEach begin="1" end="${totalPages}" var="p">
            <c:choose>
                <c:when test="${p == currentPage}">
                    <strong>[${p}]</strong>
                </c:when>
                <c:otherwise>
                    <a href="?page=${p}">${p}</a>
                </c:otherwise>
            </c:choose>
            &nbsp;
            </c:forEach>

            <c:if test="${currentPage < totalPages}">
                <a href="?page=${currentPage + 1}">Next &raquo;</a>
            </c:if>
        </c:if>
    </div>


</body>
</html>