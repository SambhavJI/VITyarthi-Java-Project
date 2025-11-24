package main;

import models.*;
import services.*;
import exceptions.InvalidAmountException;
import utils.ConfigManager;

import java.util.*;

public class App {

    public static void main(String[] args) {

        FinanceManager manager = new FinanceManager();
        FileManager fileManager = new FileManager(manager);

        fileManager.loadFromFile();

        Thread autoSaveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    manager.autoSave(fileManager);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                }
            }
        });
        autoSaveThread.start();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----------------------------");
            System.out.println("   PERSONAL FINANCE TRACKER");
            System.out.println("----------------------------");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Summary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter source: ");
                        String src = sc.nextLine();

                        manager.addIncome(amt, src);
                    } catch (InvalidAmountException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Select Category: FOOD, TRAVEL, BILLS, SHOPPING, OTHER");
                        String cat = sc.nextLine();

                        Category c = Category.valueOf(cat.toUpperCase());

                        manager.addExpense(amt, c);
                    } catch (InvalidAmountException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid Category!");
                    }
                    break;

                case 3:
                    manager.viewTransactions();
                    break;

                case 4:
                    manager.viewSummary();
                    break;

                case 5:
                    System.out.println("Saving & exiting...");
                    fileManager.saveToFile();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
