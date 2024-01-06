import java.util.Scanner;

public class Account {
    private int id;
    private String ownerName;
    private double balance;

    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount >= 0) {
            if (this.balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Not enough money on your account");
            }
        }
    }

    public void transfer(double amount, Account receivingAccount) {
        if (this.balance >= amount) {
            if (receivingAccount != null) {
                System.out.println("Preparing to send $" + amount + " to account " + receivingAccount.getId());
                this.balance = this.balance - amount;
                receivingAccount.setBalance(receivingAccount.getBalance() + amount);
                System.out.println("$" + amount + " successfully sent from account " + this.getId() + " to account " + receivingAccount.getId());
            }
        } else {
            System.out.println("Not enough money on your account");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id = " + id +
                ", ownerName = '" + ownerName + '\'' +
                ", balance = " + balance +
                '}';
    }

    public Account(int id, String ownerName, double balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}