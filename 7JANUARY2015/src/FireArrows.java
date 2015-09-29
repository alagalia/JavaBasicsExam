import java.util.Scanner;

/**
 * Created by Dell on 29.9.2015 ã..
 */
public class FireArrows {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); scan.nextLine();
        char[][] ma3x = new char[n][n];
        for (int i = 0; i < n; i++) {
            ma3x[i]= scan.nextLine().toCharArray();
        }

        int widht= ma3x[0].length;

        for (int i = 0; i < widht ; i++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col <ma3x[row].length; col++) {
                    switch (ma3x[row][col]){
                        case '>':
                            if (col<widht-1&& ma3x[row][col+1]=='o'){
                                ma3x[row][col]='o';
                                ma3x[row][col+1]='>';
                            }
                            break;
                        case '<':
                            if(col>0&&ma3x[row][col-1]=='o' ){
                                ma3x[row][col]='o';
                                ma3x[row][col-1]='<';
                            }
                            break;
                        case '^':
                            if (row>0 && ma3x[row-1][col]=='o'){
                                ma3x[row][col]='o';
                                ma3x[row-1][col]='^';
                            }
                            break;
                        case 'v':
                            if (row<n-1 && ma3x[row+1][col]=='o'){
                                ma3x[row][col]='o';
                                ma3x[row+1][col]='v';
                            }
                    }
                }
            }
        }
        for (char[] chars : ma3x) {
            System.out.println(chars);
        }
    }
}
