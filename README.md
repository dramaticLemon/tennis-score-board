# tennis-score-board

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
