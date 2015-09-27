import java.util.Scanner;

public class LabyrinthDash {

    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n= scan.nextInt();
        scan.nextLine();
        int lives=3;
        char[][] map = new char[n][];

        for (int i = 0; i < n; i++) {
            char[] line= scan.nextLine().toCharArray();
            map[i]=line;
        }

        //take steps
        char[] steps = scan.nextLine().toCharArray();
        int moves=0;

        row = 0;
        col = 0;

        int prevRow=0;
        int prevCol=0;

        for (int i = 0; i < steps.length; i++) {
            if(lives==0){
                System.out.println("No lives left! Game Over!");
                break;
            }
            prevRow= row;
            prevCol= col;
            switch (steps[i]){
                case '>':col++; break;
                case '<':col--; break;
                case 'v':row++; break;
                case '^':row--; break;
            }

            if (OutsideOfMap(row, col, map) || map[row][col]==' '){
                DropOut();
                moves++;
                break;
            }
            else if (map[row][col]=='_' || map[row][col]=='|') {
                HitWall();
                row = prevRow;
                col = prevCol;
                continue;
            }
            else if (map[row][col]=='@' || map[row][col]=='*' || map[row][col]=='#') {
                lives--;
                LandOnObstacle(lives);
                moves++;
            }
            else if (map[row][col]=='$') {
                map[row][col] = '.';
                lives++;
                GetNewLife(lives);
                moves++;
            } else {
                Land();
                moves++;
            }
        }
        System.out.println("Total moves made: "+moves);
    }


    private static boolean OutsideOfMap(int row, int col, char[][] map) {
        if (row<0 || row>=map.length || col<0 || col>=map[row].length){
            return true;
        }
        return false;
    }

    private static void HitWall(){
        System.out.println("Bumped a wall.");
    }

    private static void LandOnObstacle(int lives){
        System.out.println("Ouch! That hurt! Lives left: "+lives);
    }

    private static void GetNewLife(int lives){
        System.out.println("Awesome! Lives left: "+lives);
    }

    private static void DropOut(){
        System.out.println("Fell off a cliff! Game Over!");
    }

    private static void Land(){
        System.out.println("Made a move!");
    }

}
