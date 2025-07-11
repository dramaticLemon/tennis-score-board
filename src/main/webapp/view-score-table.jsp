<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Score Match</title>
    <style>
        .bg-container {
			position: relative;
			background-image: url('${pageContext.request.contextPath}/images/score-table-view.jpg');
			background-size: cover;
			background-position: center;
			height: 100vh;
			width: 100%;
		}

        body {
            background-color: #f7f9fc;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            margin: 40px auto;
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        caption {
            font-size: 26px;
            margin: 20px 0;
            font-weight: bold;
            color: #333;
        }

        th, td {
            padding: 14px 16px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #e3eaf2;
            color: #333;
            text-transform: uppercase;
            font-size: 14px;
            letter-spacing: 0.5px;
        }

        tr:hover {
            background-color: #f1f5fb;
        }

        td button {
            background-color: #28a745;
            border: none;
            color: white;
            padding: 8px 12px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
            font-size: 14px;
        }

        td button:hover {
            background-color: #218838;
        }

        .add-point-form {
            display: inline-block;
        }

        @media (max-width: 600px) {
            table, caption {
                width: 95%;
                font-size: 14px;
            }

            td button {
                padding: 6px 10px;
                font-size: 12px;
            }
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="bg-container">
<table>
    <caption>Score match: <%= request.getAttribute("first-name") %> vs <%= request.getAttribute("last-name") %></caption>
    <tr>
        <th>Player</th>
        <th>Sets</th>
        <th>Games</th>
        <th>Points</th>
        <th>Action</th>
    </tr>
    <tr>
        <td><%= request.getAttribute("first-name") %></td>
        <td><%= request.getAttribute("sets-score-first") %></td>
        <td><%= request.getAttribute("games-score-first") %></td>
        <td><%= request.getAttribute("points-score-first") %></td>
        <td>
            <form class="add-point-form" method="post" action="${pageContext.request.contextPath}/match-score">
                <input type="hidden" name="match_id" value="<%= request.getParameter("match_id") %>" />
                <input type="hidden" name="username" value="<%= request.getAttribute("first-name") %>" />
                <button type="submit">➕ Point</button>
            </form>
        </td>
    </tr>
    <tr>
        <td><%= request.getAttribute("last-name") %></td>
        <td><%= request.getAttribute("sets-score-last") %></td>
        <td><%= request.getAttribute("games-score-last") %></td>
        <td><%= request.getAttribute("points-score-last") %></td>
        <td>
            <form class="add-point-form" method="post" action="${pageContext.request.contextPath}/match-score">
                <input type="hidden" name="match_id" value="<%= request.getParameter("match_id") %>" />
                <input type="hidden" name="username" value="<%= request.getAttribute("last-name") %>" />
                <button type="submit">➕ Point</button>
            </form>
        </td>
    </tr>
</table>
</div>
</body>
</html>
