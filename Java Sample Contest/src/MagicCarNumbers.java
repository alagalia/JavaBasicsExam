import java.util.Scanner;

/**
 * Created by Dell on 30.9.2015 ã..
 */
public class MagicCarNumbers {
    public static void main(String[] args) {
        char[] xy = new char[]{ 'A', 'B', 'C', 'E', 'H', 'K', 'M', 'P', 'T', 'X' };

        Scanner scan = new Scanner(System.in);
        int magicWight = Integer.parseInt(scan.nextLine());
        int counter=0;

        for (int a = 0; a < 10; a++) {
            boolean isNotAPrint=true;
            for (int b = 0; b < 10; b++) {
                for (int x = 0; x < xy.length; x++) {
                    for (int y = 0; y < xy.length; y++) {

                        int num1 = 40+a+a+a+a+(xy[x]-64)*10+(xy[y]-64)*10;
                        if (num1==magicWight && isNotAPrint){
//                            System.out.println("CA"+a+a+a+a+xy[x]+xy[y]);
                            counter+=2;
                            if (xy[x]==xy[y]){counter--;}
                            isNotAPrint=false;
                        }
                        int num2 = 40+a+b+b+b+(xy[x]-64)*10+(xy[y]-64)*10;
                        int num3 = 40+a+a+a+b+(xy[x]-64)*10+(xy[y]-64)*10;
                        int num4 = 40+a+a+b+b+(xy[x]-64)*10+(xy[y]-64)*10;
                        int num5 = 40+a+b+a+b+(xy[x]-64)*10+(xy[y]-64)*10;
                        int num6 = 40+a+b+b+a+(xy[x]-64)*10+(xy[y]-64)*10;

                        if (num2==magicWight&& a!=b){
//                            System.out.println("CA"+a+b+b+b+xy[x]+xy[y]);
                            counter++;
                        }if (num3==magicWight&& a!=b){
//                            System.out.println("CA"+a+a+a+b+xy[x]+xy[y]);
                            counter++;
                        }if (num4==magicWight&& a!=b){
//                            System.out.println("CA"+a+a+b+b+xy[x]+xy[y]);
                            counter++;
                        }if (num5==magicWight&& a!=b){
//                            System.out.println("CA"+a+b+a+b+xy[x]+xy[y]);
                            counter++;
                        }if (num6==magicWight&& a!=b){
//                            System.out.println("CA"+a+b+b+a+xy[x]+xy[y]);
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
