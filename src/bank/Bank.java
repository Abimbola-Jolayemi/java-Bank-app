package bank;

import java.util.ArrayList;

public class Bank {
    private int acctNum = 10000001;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Account createAccount(String firstName, String lastName, String pin) {
        String name = firstName + " " + lastName;
        String accountNumber = String.valueOf(acctNum);
        acctNum++;
        Account account = new Account(name, pin, accountNumber);
        accounts.add(account);
        return account;
    }

    public int countAccount() {
        return accounts.size();
    }

    private Account validateAccount(String accountNumber) {
        for(Account account : accounts) {
            if (account.getNumber().equals(accountNumber))
                    return account;
        }
        return null;
    }

    public void deposit(int amount, String accountNumber) {
        Account queryAccount = validateAccount(accountNumber);
        if(queryAccount != null){
            queryAccount.deposit(amount);
        }
        else{
            System.out.println("Account not found");
        }
    }

    public void withdraw(int amount, String accountNumber, String pin) {
        Account queryAccount = validateAccount(accountNumber);
        if(queryAccount != null){
            queryAccount.withdraw(amount, pin);
        }
    }

    public void transfer(String senderNumber, String receiverNumber, int amount, String pin) {
        Account sender = validateAccount(senderNumber);
        Account receiver = validateAccount(receiverNumber);
        if (sender != null && receiver != null && sender.isCorrectPin(pin) && sender.getBalance(pin) >= amount) {
            sender.withdraw(amount, pin);
            receiver.deposit(amount);
        }
    }

    public int getBalance(String accountNumber, String pin) {
        Account queryAccount = validateAccount(accountNumber);
        if(queryAccount != null){
            return queryAccount.getBalance(pin);
        }
        else{
            return 0;
        }
    }
}
