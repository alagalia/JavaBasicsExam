
import java.util.Scanner;

public class SandGlass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int astrix =n;
        int dot=0;
        for (int repeat=0 ; repeat<=n/2; repeat++,dot++,astrix-=2) {
            System.out.printf(
                    new String(new char[dot]).replace("\0", ".")+
                    new String(new char[astrix]).replace("\0", "*")+
                    new String(new char[dot]).replace("\0", "."));
            System.out.println();
        }


        astrix =3;
        dot=(n-3)/2;
        for (int repeat=0 ; repeat<n/2; repeat++,dot--,astrix+=2) {
            System.out.printf("%1$s%2$s%1$s",
                    new String(new char[dot]).replace("\0", "."),
                    new String(new char[astrix]).replace("\0", "*"));
            System.out.println();
        }

    }
}
