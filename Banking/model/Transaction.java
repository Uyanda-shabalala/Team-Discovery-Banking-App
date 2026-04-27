//The ticket is completed when all 7 requirements are met

//1: create the class in the banking model
package banking.model;

//imports needed
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    //2: public enum
    public enum Type {
        DEPOSIT, WITHDRAWAL
    }

    //3&4: private final fields
    private final Type type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;

    //5: constructor
    public Transaction(Type type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }

    //6: getters
    public Type getType() { return type; }
    public double getAmount() { return amount; }
    public double getBalanceAfter() { return balanceAfter; }
    public LocalDateTime getTimestamp() { return timestamp; }

    //7: toString() method
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("[%s]  %-10s  R %8.2f   Balance: R %.2f",
                timestamp.format(formatter),
                type,
                amount,
                balanceAfter);
    }
}