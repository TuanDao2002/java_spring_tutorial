package task3;

public class Task3 {
    public static void main(String[] args) {
        Deal deal = new Deal();

        for (int i = 0; i < 4; i++) {
            System.out.printf("Card number %d: %s\n", i + 1, deal.getCard());
        }
    }
}
