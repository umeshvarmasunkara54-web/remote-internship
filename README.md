# Remote Internship Management and Evaluation System (Frontend)

This is a JavaFX frontend-only demo app (no backend). It uses an in-memory `DataStore` to hold internships and tasks.

Requirements
- Java 17
- Maven

Run

```powershell
mvn clean javafx:run
```

Project structure

```
remote-internship-frontend/
│ pom.xml
│ README.md
│ .gitignore
└── src/
    └── main/
        ├── java/
        │   └── com/intern/ui/
        │       ├── Main.java
        │       ├── DataStore.java
        │       ├── models/
        │       │   ├── Internship.java
        │       │   └── Task.java
        │       └── controllers/
        │           ├── DashboardController.java
        │           ├── InternshipController.java
        │           └── TaskController.java
        └── resources/
            ├── fxml/
            │   ├── dashboard.fxml
            │   ├── internship.fxml
            │   └── task.fxml
            └── css/
                └── style.css
```
