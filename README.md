# 🎾 Tennis Score Board

A simple web application for keeping track of tennis match scores.  

## 🚀 Features
- Tracks **games** and **sets**  
- Handles special scoring rules for **deuce** and **advantage**  
- Allows **resetting the score**  
- Supports **switching player sides**  

## 🛠️ How to Run Locally

1. **Clone the repository**:
   ```bash
   git clone https://github.com/dramaticLemon/tennis-score-board.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd tennis-scote-board
   ```
3. **Build and run with Docker**
   ```bash
   make run
   ```
4. **Open the application in your browser at:**
   ```bash
   http://localhost:8080/
   ```
## Project Structure
```
Directory structure:
├── Dockerfile
├── Makefile
├── README.md
├── docker-compose.yml
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       └── dch
        │           ├── models
        │           │   ├── Match.java
        │           │   └── Player.java
        │           ├── repository
        │           │   ├── MatchRepository.java
        │           │   └── PlayerRepository.java
        │           ├── service
        │           │   ├── FinishMatchesPersistenseService.java
        │           │   ├── OngoingMatchesService.java
        │           │   └── calculate
        │           │       └── score
        │           │           └── logic
        │           │               ├── CurrentMatch.java
        │           │               ├── GameEvent.java
        │           │               ├── PlayerScore.java
        │           │               ├── Scorable.java
        │           │               ├── ScoreCurrentMatch.java
        │           │               ├── enums
        │           │               │   ├── GameEventType.java
        │           │               │   ├── MatchResult.java
        │           │               │   ├── SetResult.java
        │           │               │   └── TennisPointState.java
        │           │               └── type
        │           │                   ├── GameScore.java
        │           │                   ├── PointScore.java
        │           │                   └── SetScore.java
        │           ├── servlet
        │           │   ├── ArhiveMatchesServlet.java
        │           │   ├── MatchScoreServlet.java
        │           │   └── NewMatchServlet.java
        │           └── utils
        │               ├── ErrorHandlerServlet.java
        │               ├── ErrorLoggingFilter.java
        │               ├── HeadersFilter.java
        │               ├── JpaUtil.java
        │               └── TransactionHelper.java
        ├── resources
        │   ├── META-INF
        │   │   └── persistence.xml
        │   └── log4j2.xml
        └── webapp
            ├── WEB-INF
            │   └── web.xml
            ├── arhive-matches.jsp
            ├── create-match.jsp
            ├── final-table-score.jsp
            ├── header.jsp
            ├── home.jsp
            └── view-score-table.jsp
```
## Tech Stack
- Java (Jakarta EE/Servlets)
- JSP for views
- JPA (Hibernate) for persistence
- Log4j2 for logging
- Docker & Docker Compose for containerization
