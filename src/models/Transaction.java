package models;

import exceptions.InvalidAmountException;

interface Printable {
    void printDetails();
}

public abstract class Transaction implements Printable {

    protected double amount;
    protected String note;

    public class Validator {
        public void validate(double amt) throws InvalidAmountException {
            if (amt <= 0) {
                throw new InvalidAmountException("Amount must be positive!");
            }
        }
    }

    public Transaction(double amount, String note) {
        this.amount = amount;
        this.note = note;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }
}
