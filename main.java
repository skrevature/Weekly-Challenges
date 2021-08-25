import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        // get card number from user
        Scanner scan = new Scanner(System.in);
        long card = 0L;
        while (String.valueOf(card).length()<14 || String.valueOf(card).length()>19){
            System.out.println("Please enter a card number.");
            card = scan.nextLong();
            if (String.valueOf(card).length()<14 || String.valueOf(card).length()>19){
                System.out.println("Card number must be between 14 and 19 digits.");
            }
        }

        // print out true false value of card by calling method
        System.out.println(validateCard(card));

    }

    public static boolean validateCard(long card){
        long number = card / 10;
        long checkDigit = card % 10;

        // reverse the card number and convert to integer Array
        ArrayList<Long> numberArray = new ArrayList<Long>();
        do {
            numberArray.add(number % 10);
            number /= 10;
        } while (number > 0);

        // double the odd digits and combine the bigger digits into one
        ArrayList<Long> numberArray2 = new ArrayList<Long>();
        for (int i = 0; i < numberArray.size(); i++) {
            if ((i+1) % 2 == 1) {
                long doubled = 0;
                doubled = numberArray.get(i) * 2;
                if (doubled > 9) {
                    numberArray2.add(0, doubled % 10);
                    numberArray2.add(1, doubled / 10);
                    long sum = (numberArray2.get(0) + numberArray2.get(1));
                    numberArray.set(i, sum);
                    continue;
                }
                numberArray.set(i, doubled);
            }
        }

        // find sum of final number
        long totalSum=0;
        for (int i =0; i<numberArray.size(); i++){
            totalSum = (totalSum+numberArray.get(i));
        }

        // make sure number matches check digit
        if (10-(totalSum%10)==checkDigit){
            return true;
        }
        else return false;
    }

}
