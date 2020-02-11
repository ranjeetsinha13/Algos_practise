import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class Polygons {
    enum Shape {
        Square, Rectangle, Other
    }

    private static Shape shape(int a, int b, int c, int d) {
        if (a<=0 || b<=0 || c<=0 || d <= 0) {
            return Shape.Other;
        }

        if (a==b && b==c && c==d) {
            return Shape.Square;
        }

        if (a==c && b==d) {
            return Shape.Rectangle;
        }

        return Shape.Other;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        Map enumMap  = new EnumMap(Shape.class);
        enumMap.put(Shape.Other,0);
        enumMap.put(Shape.Square,0);
        enumMap.put(Shape.Rectangle,0);

        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            Shape shp = shape(a,b,c,d);
            enumMap.put(shp, (Integer)enumMap.get(shp)+1);
        }

        System.out.println(enumMap.get(Shape.Square)+" "+enumMap.get(Shape.Rectangle)+" "+ enumMap.get(Shape.Other));
    }
}