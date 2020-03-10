import java.util.Scanner;
import ohtu.*;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Multiplier kolme = new Multiplier(3);
        System.out.println("Kuka olet?");
        String nimi = lukija.nextLine();

        System.out.println("Hello " +nimi);

        System.out.println("anna luku");
        int luku = lukija.nextInt();

        System.out.println("luku kertaa kolme on " + kolme.multipliedBy(luku));
    }
}