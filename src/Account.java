import java.util.Scanner;

public class Account {
    private int id;
    private String ownerName;
    private double balance;
    private Card card;
    private double loanAmount;
    private double salary;

    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (card.getTypeOfCard().equals(TypeOfCard.CREDIT)) {
            if (amount >= 0) {
                if (this.balance >= amount * 1.03) {
                    balance -= amount * 1.03;
                } else {
                    System.out.println("Not enough money on your account");
                }
            }
        } else {
            if (amount >= 0) {
                if (this.balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Not enough money on your account");
                }
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

    public void checkBankToTransfer(double amount, Account receivingAccount) {
        if (this.card.getBank().getName().equals(receivingAccount.card.getBank().getName())) {
            transfer(amount, receivingAccount);
        } else {
            System.out.println("Preparing to send $" + amount + " to account " + receivingAccount.getId());
            if (this.balance >= amount + 150) {
                this.balance = this.balance - amount - 150;
                receivingAccount.setBalance(receivingAccount.getBalance() + amount);
                System.out.println("$" + amount + " successfully sent from account " + this.getId() + " to account " + receivingAccount.getId());
            } else {
                System.out.println("Not enough money on your account");
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id = " + id +
                ", ownerName = '" + ownerName + '\'' +
                ", balance = " + balance +
                ", \n card = " + card +
                ", loanAmount = " + loanAmount +
                '}';
    }

    public Account(int id, String ownerName, double balance, double salary) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
        this.salary = salary;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
