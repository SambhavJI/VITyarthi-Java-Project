package models;

public class Expense extends Transaction {

    private Category category;

    public Expense(double amount, Category category) {
        super(amount, category.name());
        this.category = category;
    }

    @Override
    public void printDetails() {
        System.out.println("[EXPENSE] Amount: " + amount + " | Category: " + category);
    }
}
