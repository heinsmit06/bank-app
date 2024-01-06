public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(1, "Medet", 400000d);
        Account account2 = new Account(2, "Bekzhan", 400000d);
        account1.withdraw(10000d);
        account1.transfer(75000d, account2);

        System.out.println(account1);
        System.out.println(account2);
    }
}