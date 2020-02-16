import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg)
    {
        Scanner in = new Scanner(System.in);
        long n = 0;
        while(true) {
            System.out.println("Введите число:");
            try {
                n = in.nextLong();
                System.out.println(n + " = " + NumToStr.convert(n));
            }
            catch (InputMismatchException e)
            {
                System.out.println("Ошибка! Неверный ввод.");
                in.next();
            }
        }

    }

}
