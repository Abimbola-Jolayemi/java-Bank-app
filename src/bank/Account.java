package bank;

public class Account{

    private int balance;
    private String pin;
    private String name;
    private String accountNumber;

    public Account(String name, String pin, String accountNumber){
        this.pin = pin;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public int getBalance(String pin) {
        return isCorrectPin(pin) ? this.balance : 0;
    }

    public void deposit(int amount) {
        if (amount > 0){
            balance += amount;
        }
    }
    public void withdraw(int amount, String pin) {
        if (isCorrectPin(pin)) {
            if (amount < balance && amount > 0) {
                balance = balance - amount;
            }
        }
    }

    public boolean isCorrectPin(String pin) {
        return this.pin.equals(pin);
    }

    public void updatePin(String oldPin, String newPin){
        this.pin = newPin;
    }

    public String getNumber(){
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}
