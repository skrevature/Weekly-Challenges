import java.util.Scanner;

public class Rot13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        Encoder(s);

    }

    public static void Encoder(String s){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M' ) c += 13;
            else if  (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z') c -= 13;
            System.out.print(c);
        }

    }

}