public class Bank {
    private String name;
    private double interestRate;
    private double acceptanceRate;


    public void giveLoan(double amount, int years, Account account) {
        double accountMoney = account.getBalance();
        account.setBalance(accountMoney + amount);

        double loanAmount = amount + amount * interestRate * years;
        account.setLoanAmount(loanAmount);
    }

    public void checkForPayabilityAndGiveLoan(double amount, int years, Account account) {
        double monthlyPayment = (amount + amount * interestRate * years) / (years * 12);
        System.out.println("Monthly payment is " + monthlyPayment);
        if (monthlyPayment > account.getSalary() * acceptanceRate) {
            System.out.println("Your salary is not enough to get this amount of loan");
        } else {
            giveLoan(amount, years, account);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name = '" + name + '\'' +
                ", interestRate = " + interestRate +
                ", acceptanceRate = " + acceptanceRate +
                '}';
    }

    public Bank(String name, double interestRate, double acceptanceRate) {
        this.name = name;
        this.interestRate = interestRate;
        this.acceptanceRate = acceptanceRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }
}
