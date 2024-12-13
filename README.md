# Bautista_final-project_oop


I. A Brief Project Overview
The Crepay Lister Application is a Java-based tool designed to help users manage and organize their payment reminders efficiently. The program allows users to register and log in securely, add payment reminders, and view their saved reminders. The system is structured to ensure user privacy and personalized functionality, making it a practical tool for financial organization and can help them remind for their next upcoming payment.

Key functionalities include:

User registration and login with secure credential management.
Addition of detailed payment reminders (payment name,amount,account, due date).
Viewing all reminders in a structured format.
A menu-driven interface for seamless navigation.

II. Explanation of How OOP Principles Were Applied
The program was designed with a strong emphasis on Object-Oriented Programming principles:

Encapsulation:

User credentials (username, password) and reminders are private fields in the User class.
Public methods (getUsername, validatePassword, etc.) are used to control access to these fields.
This ensures data security and prevents unauthorized modifications.
Inheritance:

The abstract User class provides a blueprint for user-related functionalities.
The StandardUser class inherits from User, extending its functionality while reusing common properties and methods.
Polymorphism:

The displayMenu method is overridden in StandardUser to customize the menu for standard users.
Polymorphism allows the program to dynamically call the appropriate menu display method for different user types.
Abstraction:

The User class is abstract, defining essential methods (displayMenu) that must be implemented by subclasses.
This hides implementation details while exposing a clear interface for interaction with user objects.


III. Details of the Chosen SDG and Its Integration into the Project
The project supports Sustainable Development Goal 8: Decent Work and Economic Growth, specifically focusing on financial literacy and responsible money management.

How It Aligns:

Encourages users to track their financial commitments, reducing the risk of missed payments.
Supports better economic decision-making by providing a tool to organize financial data effectively.
Integration:

The core functionality of adding and viewing payment reminders is designed to promote financial awareness and timely action.
The tool can be scaled in the future to include features like payment notifications or budgeting advice, further enhancing its impact on SDG 8.

IV.Instructions for Running the Program

Upon launch, you will see a main menu with options to Register, Login, or Exit.
Register with a unique username and password.
Login with the registered credentials to access the User Menu.
once you insert your login account you will choose either choose payment reminder or choose view payment reminder to view all of your save information
and while choosing payment remider your will put yout information like (name,account number,amount,and due date)
Use the User Menu to add payment reminders or view existing reminders.


Logout to return to the main menu, or exit the program.
