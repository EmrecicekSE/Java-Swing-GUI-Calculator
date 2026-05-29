# Java Swing GUI Calculator

A simple desktop calculator application built with **Java Swing**.
This project was developed to practice Java GUI programming, event handling, exception handling, and MVC architecture.

## Screenshot

(<img width="398" height="400" alt="Screenshot-javaCalculator" src="https://github.com/user-attachments/assets/d82acca3-475e-4a03-b7ee-ac76a9cfd773" />
)

## Features

* Graphical user interface built with Java Swing
* Basic arithmetic operations:

  * Addition
  * Subtraction
  * Multiplication
  * Division
* Decimal number support
* Clear button
* Backspace button
* Error handling for invalid operations
* Dark themed calculator interface
* MVC-based project structure

## Project Structure

The project follows a simple MVC architecture:

```text
MyProjects/
└── Calculator/
    ├── Main.java
    ├── CalculatorModel.java
    ├── CalculatorView.java
    ├── CalculatorController.java
    └── CalculatorModelException.java
```

## MVC Architecture

### Model

`CalculatorModel.java` contains the calculation logic.
It handles arithmetic operations and throws exceptions for invalid operations.

### View

`CalculatorView.java` creates the graphical user interface using Java Swing components such as:

* `JFrame`
* `JButton`
* `JPanel`
* `JTextField`
* `GridLayout`
* `BorderLayout`

### Controller

`CalculatorController.java` handles button click events, reads user input, updates the screen, and connects the View with the Model.

### Custom Exception

`CalculatorModelException.java` is a custom exception class used for invalid calculator operations.

## What I Learned

While developing this project, I practiced:

* Building GUI applications with Java Swing
* Using `ActionListener` for button events
* Organizing code with MVC architecture
* Handling exceptions in Java
* Working with user input from GUI buttons
* Designing a simple dark themed interface
* Structuring Java projects with packages

## How to Run

Make sure the files are inside the correct package folder:

```text
MyProjects/Calculator/
```

Compile the project from the parent directory:

```bash
javac MyProjects/Calculator/*.java
```

Run the application:

```bash
java MyProjects.Calculator.Main
```

## Technologies Used

* Java
* Java Swing
* Object-Oriented Programming
* MVC Architecture

## Future Improvements

Possible improvements for this project:

* Add keyboard input support
* Show error messages with a separate warning label
* Improve negative number handling
* Add calculation history
* Improve button layout and responsiveness
* Add more advanced mathematical operations

## Author

Developed by Emre as a Java Swing GUI calculator project.
