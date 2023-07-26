# Movie Shop - Java Desktop Application

Movie Shop is a Java desktop application developed using IntelliJ IDEA, FXML, and SceneBuilder. The application allows users to register or login, browse available movies, purchase movies, and view their purchased movie collection. Additionally, the app supports a Command-Line Interface (CLI) for certain functionalities.

## Features

- User Authentication: Users can register and login to access the movie shop functionalities securely.

- Browse Movies: Users can browse through the list of available movies and get details about each movie, such as title, description, and price.

- Purchase Movies: Authenticated users can buy movies from the shop using their account balance.

- My Movies Section: Users can view the movies they have purchased in the "My Movies" section.

- Command-Line Interface (CLI): The application also supports a CLI for certain tasks, which can be accessed through the terminal.

## Prerequisites

- Java Development Kit (JDK) version 8 or above.

- Internet Access: The application requires internet access to connect to the database.

## How to Run the Application

1. Clone the repository to your local machine using Git or download it as a ZIP file and extract it.

2. Open the project in IntelliJ IDEA.

3. Use SceneBuilder to design the frontend FXML files, and ensure that the necessary libraries are included.

4. Build the project by running the following commands in the terminal:

   ```
   mvn clean install
   ```

5. Run the application with the following command:

   ```
   mvn clean javafx:run
   ```

6. The application's GUI will be launched, and you can interact with it using mouse clicks.

## Command-Line Interface (CLI) Usage

You can also use the application through the Command-Line Interface (CLI) for specific tasks. To access the CLI, run the following command in the terminal:

```
java -jar Projekat-0.1-jar-with-dependencies.jar [option] 'something else if needed'
```

Replace `[option]` with one of the following options:

- `addM`: To add a movie to the database.
- `getM`: To view the list of movies from the database
- `getC`: To view the list of registered customers.
- `addC`: To register a new customer.

