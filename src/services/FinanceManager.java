package services;

import java.util.*;
import models.*;
import exceptions.InvalidAmountException;

public class FinanceManager {

    private List<Transaction> list = new ArrayList<>();

    // Add Income
    public void addIncome(double amt, String src) throws InvalidAmountException {
        Transaction.Validator validator = new Transaction(amt, src) {
            @Override public void printDetails() {}
        }.new Validator();

        validator.validate(amt);
        list.add(new Income(amt, src));
        System.out.println("Income added.");
    }

    // Add Expense
    // Add Expense with balance check
public void addExpense(double amt, Category c) throws InvalidAmountException {

    // validate amount
    Transaction.Validator validator = new Transaction(amt, c.name()) {
        @Override public void printDetails() {}
    }.new Validator();
    validator.validate(amt);

    // calculate current balance
    double income = 0, expense = 0;
    for (Transaction t : list) {
        if (t instanceof Income) income += t.getAmount();
        else expense += t.getAmount();
    }
    double currentBalance = income - expense;

    // check if balance is enough
    if (currentBalance <= 0) {
        System.out.println("ERROR: No income available! Add income first.");
        return;
    }

    if (amt > currentBalance) {
        System.out.println("ERROR: Expense exceeds current balance (" + currentBalance + ")");
        return;
    }

    list.add(new Expense(amt, c));
    System.out.println("Expense added.");
}

    // View all (uses anonymous class for sorting)
    public void viewTransactions() {
        Collections.sort(list, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return Double.compare(t1.getAmount(), t2.getAmount());
            }
        });

        for (Transaction t : list) t.printDetails();
    }

    // Summary
    public void viewSummary() {
        double income = 0, expense = 0;

        for (Transaction t : list) {
            if (t instanceof Income) income += t.getAmount();
            else expense += t.getAmount();
        }

        System.out.println("\n--- SUMMARY ---");
        System.out.println("Total Income: " + income);
        System.out.println("Total Expense: " + expense);
        System.out.println("Balance: " + (income - expense));
    }

    // Auto-save
    public void autoSave(FileManager fm) {
        fm.saveToFile();
    }

    public List<Transaction> getList() {
        return list;
    }
}
