package services;

import java.io.*;
import models.*;

public class FileManager {

    private FinanceManager manager;

    public FileManager(FinanceManager manager) {
        this.manager = manager;
    }

    public synchronized void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter("finance.txt");
            for (Transaction t : manager.getList()) {
                if (t instanceof Income)
                    pw.println("INCOME," + t.getAmount() + "," + t.getNote());
                else
                    pw.println("EXPENSE," + t.getAmount() + "," + t.getNote());
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromFile() {
        try {
            File file = new File("finance.txt");
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[0].equals("INCOME"))
                    manager.getList().add(new Income(Double.parseDouble(parts[1]), parts[2]));
                else
                    manager.getList().add(new Expense(Double.parseDouble(parts[1]),
                            Category.valueOf(parts[2])));
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error loading previous data.");
        }
    }
}
