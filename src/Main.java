public class Main {
    public static void main(String[] args) {

        Bank kaspi = new Bank("Kaspi", 0.2d, 0.5d);
        Account account1 = new Account(1, "Medet", 77500d, 5000d);
        Card card1 = new Card(kaspi, TypeOfCard.DEBIT);
        account1.setCard(card1);


        Bank jusan = new Bank("Jusan", 0.17d, 0.3d);
        Account account2 = new Account(2, "Bekzhan", 60000d, 10000d);
        Card card2 = new Card(jusan, TypeOfCard.CREDIT);
        account2.setCard(card2);

        kaspi.checkForPayabilityAndGiveLoan(30000d, 6, account1);
        jusan.checkForPayabilityAndGiveLoan(1000000d, 10, account2);
        System.out.println(account1);
        System.out.println(account2);
    }
}