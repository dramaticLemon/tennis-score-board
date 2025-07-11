<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Match result</title>
    <script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js"></script>

    <style>
        .bg-container {
			position: relative;
			background-image: url('${pageContext.request.contextPath}/images/score-table-view.jpg');
			background-size: cover;
			background-position: center;
			height: 100vh;
			width: 100%;
		}

        table {
            border-collapse: collapse;
            margin: 20px auto;
            font-family: Arial, sans-serif;
            width: 60%;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        caption {
            font-size: 24px;
            margin-bottom: 10px;
            font-weight: bold;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="bg-container">
    <table>
        <tr>
            <th>Player</th>
            <th>Sets</th>
            <th>Games</th>
            <th>Points</th>
        </tr>
        <tr>
            <td><%= request.getAttribute("first-name") %></td>
            <td><%= request.getAttribute("sets-score-first") %></td>
            <td><%= request.getAttribute("games-score-first") %></td>
            <td><%= request.getAttribute("points-score-first") %></td>
        </tr>
        <tr>
            <td><%= request.getAttribute("last-name") %></td>
            <td><%= request.getAttribute("sets-score-last") %></td>
            <td><%= request.getAttribute("games-score-last") %></td>
            <td><%= request.getAttribute("points-score-last") %></td>
        </tr>
    </table>
</div>
</body>

<script>
    window.onload = function () {
        const duration = 2 * 1000;
        const end = Date.now() + duration;

        (function frame() {
            confetti({
                particleCount: 7,
                angle: 60,
                spread: 70,
                origin: { x: 0 },
            });
            confetti({
                particleCount: 7,
                angle: 120,
                spread: 70,
                origin: { x: 1 },
            });

            if (Date.now() < end) {
                requestAnimationFrame(frame);
            }
        })();

    };
</script>


</html>
