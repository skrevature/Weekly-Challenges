import java.util.Scanner;
import java.util.ArrayList;

public class Octal {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();

            converter(a);

        }

        public static void converter(int a){
            ArrayList<Integer> numberArray = new ArrayList<Integer>();
            for(int i=0; a>8; i++){
                numberArray.add(a%8);
                a=a/8;
            }
            System.out.print(a);
            for (int i=numberArray.size()-1; i>=0; i--)
            System.out.print(numberArray.get(i));

        }

}
