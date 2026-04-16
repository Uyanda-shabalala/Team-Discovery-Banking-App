package banking.model;

/**
 * Custom checked exception thrown when a withdrawal cannot be completed due to insufficient funds
 * in the account.
 */

public class InsufficientFundsException extends Exception {

    //Stores how much more money is needed to complete the withdrawal
    private final double shortfall;

    /**
     * Constructor calculates the shortfall based on the requested amount and the
     * available balance
     *
     * @param amountRequested The amount the user wants to withdraw
     * @param availableBalance The current balance in the account
     */

    public InsufficientFundsException(double amountRequested, double availableBalance){
        this.shortfall = amountRequested - availableBalance;
    }

    /**
     * Returns the amount still needed to complete the withdrawal.
     *
     * @return shortfall amount
     */

    public double getShortfall(){
        return shortfall;
    }

    /**
     * Returns a user-friendly error message including the shortfall,
     * formatted to two decimal places.
     */

    @override
    public String getMessage(){
        return "Insufficient funds. You need R "
                +string.format("%.2f", shortfall)
                +" more to complete this withdrawal."
    }
}