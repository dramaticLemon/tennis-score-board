<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Match result</title>
    <style>
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
<h1>Final score table</h1>
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

</body>
</html>
