package banking.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private final String accountNumber;
    private final String ownerName;
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        transactions = new ArrayList<>(); // initialise transaction list
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    // subclasses will use this when withdrawing money
    protected void deductFromBalance(double amount) {
        balance -= amount;
    }

    // each account type must decide its own withdrawal rules
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        Transaction t = new Transaction("DEPOSIT", amount, balance);
        transactions.add(t);

        System.out.println("Deposit successful. New balance: R" + balance);
    }

    public void printStatement() {
        System.out.println("\n--- Last Transactions ---");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        int startIndex = transactions.size() - 5;
        if (startIndex < 0) {
            startIndex = 0;
        }

        for (int i = startIndex; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }
}