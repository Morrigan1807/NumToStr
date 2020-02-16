import java.util.HashMap;
import java.util.Map;

/**
 * @author Burmaco Veronika
 */
public abstract class NumToStr {
    /**
     * Метод для преобразования чисел(long) в числовой записи в строковую
     * @param number число, необходимое преобразовать
     */
    public static String convert(long number)
    {
        boolean neg_flag = false; //флаг для обозначения отричательности числа (если число отрицательное - true)
        if (number < 0) {
            neg_flag = true;
            number *= -1;
        }
        String result = "";
        String temp_result = "";
        int temp_number = 0;
        Map <Integer, String> str_long = new HashMap<Integer, String>(); //контейнер для значения степеней (k/3)
        str_long.put(1, "тысяч");
        str_long.put(2, "миллион");
        str_long.put(3, "миллиард");
        str_long.put(4, "триллион");
        str_long.put(5, "квадриллион");
        str_long.put(6, "квинтиллион");
        str_long.put(7, "секстиллион");
        str_long.put(8, "септиллион");
        str_long.put(9, "октиллион");
        str_long.put(10, "нониллион");
        str_long.put(11, "дециллион");
        str_long.put(12, "андециллион");
        str_long.put(13, "дуодециллион");
        str_long.put(14, "тредециллион");
        str_long.put(15, "кваттордециллион");
        str_long.put(16, "квиндециллион");
        str_long.put(17, "сексдециллион");
        str_long.put(18, "септемдециллион");
        str_long.put(19, "октодециллион");
        str_long.put(20, "новемдециллион");
        str_long.put(21, "вигинтиллион");

        int number_length = ((int)Math.log10(number) + 1 + 2) / 3; //подсчет количества цифра в числе с последующим делением на 3

        if (number == 0)
            return figures((int)number, false);

        for(int i = 0; i < number_length; i++)
        {
            temp_number = (int)(number % 1000);
            if (temp_number == 0) {
                number /= 1000;
                continue;
            }
            if(i == 0) {
                result = figures(temp_number, false);
            }
            else {
                if(i == 1) {
                    temp_result = figures(temp_number, true);
                    if ((temp_number / 10) % 10 != 1 && temp_number % 10 == 1)
                        result = temp_result + " " + str_long.get(i) + "а " + result;
                    else if ((temp_number / 10) % 10 != 1 && (temp_number % 10 >= 2 || temp_number % 10 <= 4))
                        result = temp_result + " " + str_long.get(i) + "и " + result;
                    else
                        result = temp_result + " " + str_long.get(i) + " " + result;
                }
                else{
                    temp_result = figures(temp_number, false);
                    if ((temp_number / 10) % 10 != 1 && temp_number % 10 == 1)
                        result = temp_result + " " + str_long.get(i) + " " + result;
                    else if ((temp_number / 10) % 10 != 1 && (temp_number % 10 >= 2 || temp_number % 10 <= 4))
                        result = temp_result + " " + str_long.get(i) + "а " + result;
                    else
                        result = temp_result + " " + str_long.get(i) + "ов " + result;
                }
            }
            number /= 1000;
        }
        if(neg_flag)
            result = "минус " + result;
        return result.trim();
    }

    /**
     * Метод для преобразования трехзначих чисел в числовой записи в строковую
     * @param num число, необходимое преобразовать
     * @param dec_flag флаг, отвечающий за окончания(один(false)/одна, два(false)/две)
     */
    public static String figures(int num, boolean dec_flag)
    {
        String result = "";
        Map<Integer, String> str_figures = new HashMap<Integer, String>(); //хранилище для первых 19 чисел, начиная с 0
        str_figures.put(0, "ноль");
        str_figures.put(1, "один");
        str_figures.put(2, "два");
        str_figures.put(3, "три");
        str_figures.put(4, "четыре");
        str_figures.put(5, "пять");
        str_figures.put(6, "шесть");
        str_figures.put(7, "семь");
        str_figures.put(8, "восемь");
        str_figures.put(9, "девять");
        str_figures.put(10, "десять");
        str_figures.put(11, "одиннадцать");
        str_figures.put(12, "двенадцать");
        str_figures.put(13, "тринадцать");
        str_figures.put(14, "четырнадцать");
        str_figures.put(15, "пятнадцать");
        str_figures.put(16, "шестнадцать");
        str_figures.put(17, "семнадцать");
        str_figures.put(18, "восемнадцать");
        str_figures.put(19, "девятнадцать");

        Map<Integer, String> str_alter_figures = new HashMap<Integer, String>(); //хранилище для склонений 1 и 2
        str_alter_figures.put(1, "одна");
        str_alter_figures.put(2, "две");

        Map<Integer, String> str_dozens = new HashMap<Integer, String>(); //хранилище для десятков
        str_dozens.put(2, "двадцать");
        str_dozens.put(3, "тридцать");
        str_dozens.put(4, "сорок");
        str_dozens.put(5, "пятьдесят");
        str_dozens.put(6, "шестьдесят");
        str_dozens.put(7, "семьдесят");
        str_dozens.put(8, "восемьдесят");
        str_dozens.put(9, "девяносто");

        Map<Integer, String> str_hundreds = new HashMap<Integer, String>(); //хранилище для сотен
        str_hundreds.put(1, "сто");
        str_hundreds.put(2, "двести");
        str_hundreds.put(3, "триста");
        str_hundreds.put(4, "четыреста");
        str_hundreds.put(5, "пятьсот");
        str_hundreds.put(6, "шестьсот");
        str_hundreds.put(7, "семьсот");
        str_hundreds.put(8, "восемьсот");
        str_hundreds.put(9, "девятьсот");

        if(num == 0 && !dec_flag)
        {
            return str_figures.get(0);
        }
        else if(dec_flag && (num == 1 || num == 2 ))
        {
            return str_alter_figures.get(num);
        }
        else if(num < 20)
        {
            return str_figures.get(num);
        }
        else if(num < 100)
        {
            if(dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                return str_dozens.get(num/10) + " " + str_alter_figures.get(num%10);
            else if (num % 10 == 0)
                return str_dozens.get(num/10);
            else
                return str_dozens.get(num/10) + " " + str_figures.get(num%10);
        }
        else
        {
            result = str_hundreds.get(num/100) ;
            if((num/10) % 10 == 0) //если _0?
            {
                if((num % 10) == 0) //если _00
                    return result;
                else { //если _0_
                    if (dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                        return result + " " + str_alter_figures.get(num % 10);
                    else
                        return result + " " + str_figures.get(num % 10);
                }
            }
            else if ((num % 10) == 0) //если __0
            {
                if((num / 10) % 10 == 1)
                    return result + " " + str_figures.get(10);
                else
                    return result + " " + str_dozens.get((num / 10) % 10);
            }
            else
            {
                if (num % 100 < 20)
                    return result + " " + str_figures.get(num % 100);
                else {
                    if (dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                        return result + " " + str_dozens.get((num / 10) % 10) + " " + str_alter_figures.get(num % 10);
                    else
                        return result + " " + str_dozens.get((num / 10) % 10) + " " + str_figures.get(num % 10);
                }
            }
        }
    }
}
