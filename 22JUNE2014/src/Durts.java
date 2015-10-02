import java.util.Scanner;

/**
 make a special game, called “Durts”. The rules of the game were easy: all players throw one dart and if the dart get into the figure, the player takes a point.
 The shape of the figure represents a cross. Your task is to write a program that calculates if the dart is in the figure.
 Each game starts with given coordinates of the center (CX, CY) of the figure, the size r, the count n, and n coordinates (X, Y) of the darts.
 */
public class Durts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int centerX = sc.nextInt();
        int centerY = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();

        double vreiticalMinX = centerX-(0.5* r);
        double vreiticalMaxX = centerX+(0.5* r);
        double vreiticalMinY = centerY-r;
        double vreiticalMaxY = centerY+r;

        double horizontalMinX = centerX-r;
        double horizontalMaxX= centerX+r;
        double horizontalMinY = centerY-(0.5* r);
        double horizontalMaxY = centerY+(0.5* r);

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (    isPointInRectangle(x,y, vreiticalMinX, vreiticalMaxX,  vreiticalMinY, vreiticalMaxY) ||
                    isPointInRectangle(x,y,horizontalMinX,horizontalMaxX, horizontalMinY,horizontalMaxY)){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPointInRectangle(int x, int y,
                                              double minX, double maxX, double minY, double maxY) {
        boolean inside = (x >= minX) && (x <= maxX) && (y >= minY) && (y <= maxY);
        return inside;
    }
}
