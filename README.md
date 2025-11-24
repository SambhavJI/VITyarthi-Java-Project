# 📌 Personal Finance Tracker (Java CLI Project)

A simple and efficient **Command-Line Personal Finance Tracker** built
using **Core Java**, designed to help users manage income, expenses,
budgets, and category-wise spending.\
This project was developed as part of a flipped-course assignment to
apply Java concepts in a real-world application.

------------------------------------------------------------------------

## ✨ Features

-   ✔ **Add Income**
-   ✔ **Add Expenses (with categories)**
-   ✔ **Prevent Negative Balance**
-   ✔ **View Financial Summary**
-   ✔ **View Transaction History**
-   ✔ **Simple and Clean CLI Interface**
-   ✔ **Fully Modular Code (OOP-based)**

------------------------------------------------------------------------

## 🧱 Tech Stack

-   **Java SE (Core Java)**
-   **Object-Oriented Programming**
-   **Collections Framework (ArrayList, HashMap)**
-   **Exception Handling**
-   **CMD/Terminal-based User Interface**

------------------------------------------------------------------------

## 📁 Project Structure

    src/
    │
    ├── exceptions/
    │ └── InvalidAmountException.java # Custom exception for invalid amounts
    │
    ├── main/
    │ └── App.java # Main entry point (CLI menu controller)
    │
    ├── models/
    │ ├── Category.java # Represents expense categories
    │ ├── Expense.java # Expense transaction model
    │ ├── Income.java # Income transaction model
    │ └── Transaction.java # Base model for all transactions
    │
    ├── services/
    │ ├── FileManager.java # Handles saving/loading data (finance.txt)
    │ └── FinanceManager.java # Core business logic (income, expenses, budget)
    │
    ├── utils/
    │ └── ConfigManager.java # Utility class for config/settings
    │
    └── finance.txt # Stored financial data file

------------------------------------------------------------------------

## 🚀 How to Run

### Windows CMD / PowerShell / VS Code Terminal

1.  Clone the repository:

``` bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>/src
```

2.  Compile the project:

``` bash
javac -d bin src\main\App.java src\models\*.java src\services\*.java src\exceptions\*.java src\utils\*.java
```

3.  Run the project:

``` bash
java -cp bin main.App
```

------------------------------------------------------------------------

## 📌 Usage

After running, you will see a menu like:

    1. Add Income
    2. Add Expense
    3. View Summary
    4. View Transactions
    6. Exit

Choose any option to manage your finances efficiently.


------------------------------------------------------------------------

## 📚 Concepts Used

-   Java Classes & Objects\
-   Constructors\
-   Methods & Recursion\
-   Inheritance (optional versions)\
-   Access Modifiers\
-   Arrays & Collections\
-   Exception Handling\
-   Java Flow Control\
-   Loops, switch-case, break, continue\
-   OOP Principles (Encapsulation & Modularization)

------------------------------------------------------------------------

## 🌟 Future Enhancements

-   Persistent storage (save data to CSV/JSON)
-   Edit & delete transactions
-   Monthly analytics
-   Export summary reports
-   GUI version using JavaFX or Swing
-   Login system for data privacy


------------------------------------------------------------------------

## 🤝 Contribute

Feel free to fork the repo and create pull requests for improvements!
