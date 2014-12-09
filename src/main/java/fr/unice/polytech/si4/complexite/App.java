package fr.unice.polytech.si4.complexite;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Box b = new Box(3,3);
        Rectangle r1 = new Rectangle(2,1);
        try {
            b.putRectangle(r1, 1, 2);
        }catch(ArrayIndexOutOfBoundsException e){}
        System.out.println(r1);
        System.out.println(b);
    }
}
