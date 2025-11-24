package models;

public class Income extends Transaction {

    public Income(double amount, String source) {
        super(amount, source);
    }

    @Override
    public void printDetails() {
        System.out.println("[INCOME] Amount: " + amount + " | Source: " + note);
    }
}
