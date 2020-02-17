import catalog.CatalogOfDegree;
import catalog.CatalogOfDozens;
import catalog.CatalogOfFirstTwenty;
import catalog.CatalogOfHundreds;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Burmaco Veronika
 */
public class NumToStr {

    private final static Map<Integer, String> CATALOG_OF_DEGREE = CatalogOfDegree.getInstance().CATALOG_DEGREE;
    private final static Map<Integer, String> CATALOG_OF_HUNDREDS = CatalogOfHundreds.getInstance().CATALOG_HUNDREDS;
    private final static Map<Integer, String> CATALOG_OF_DOZENS = CatalogOfDozens.getInstance().CATALOG_DOZENS;
    private final static Map<Integer, String> CATALOG_OF_FIRST_TWENTY = CatalogOfFirstTwenty.getInstance().CATALOG_FIRST_TWENTY;
    private final static String SPACE = " ";

    /**
     * Метод для преобразования чисел(long) в числовой записи в строковую
     * @param number число, необходимое преобразовать
     */
    public static String convert(long number)
    {
        String result = "";
        String tempResult = "";
        int numberReminder = 0;

        if (number < 0) {
            number *= -1;
            result += "минус ";
        }

        int numberLength = ((int)Math.log10(number) + 3) / 3; //подсчет количества цифра в числе с последующим делением на 3

        if (number == 0) {
            return figures((int)number, false);
        }

        String convertedValue = "";
        for(int i = 0; i < numberLength; i++)
        {
            numberReminder = (int)(number % 1000);
            if (numberReminder == 0) {
                number /= 1000;
                continue;
            }

            if(i == 0) {
                convertedValue = figures(numberReminder, false);
            }

            if(i == 1) {
                tempResult = figures(numberReminder, true);
                convertedValue = getConvertedThousandValue(tempResult, numberReminder, i) + convertedValue;
            }

            if(i > 1) {
                tempResult = figures(numberReminder, false);
                convertedValue = getConvertedValueMoreThanThousand(tempResult, numberReminder, i) + convertedValue;
            }

            number /= 1000;
        }

        return (result + convertedValue).trim();
    }

    private static String getConvertedThousandValue(String tempResult, int numberReminder, int order) {
        if ((numberReminder / 10) % 10 != 1 && numberReminder % 10 == 1)
            return buildValue(tempResult, order, "a ");
        else if ((numberReminder / 10) % 10 != 1 && (numberReminder % 10 >= 2 || numberReminder % 10 <= 4))
            return buildValue(tempResult, order, "и ");
        else
            return buildValue(tempResult, order, SPACE);
    }

    private static String getConvertedValueMoreThanThousand(String tempResult, int numberReminder, int order) {
        if ((numberReminder / 10) % 10 != 1 && numberReminder % 10 == 1)
            return buildValue(tempResult, order, SPACE);
        else if ((numberReminder / 10) % 10 != 1 && (numberReminder % 10 >= 2 || numberReminder % 10 <= 4))
            return buildValue(tempResult, order, "a ");
        else
            return buildValue(tempResult, order, "ов ");
    }

    private static String buildValue(String tempResult, int order, String wordEnd) {
        return tempResult + SPACE + CATALOG_OF_DEGREE.get(order) + wordEnd;
    }

    /**
     * Метод для преобразования трехзначих чисел в числовой записи в строковую
     * @param num число, необходимое преобразовать
     * @param dec_flag флаг, отвечающий за окончания(один(false)/одна, два(false)/две)
     */
    private static String figures(int num, boolean dec_flag)
    {
        String result = "";

        Map<Integer, String> str_alter_figures = new HashMap<Integer, String>(); //хранилище для склонений 1 и 2
        str_alter_figures.put(1, "одна");
        str_alter_figures.put(2, "две");



        if(num == 0 && !dec_flag)
        {
            return CATALOG_OF_FIRST_TWENTY.get(0);
        }
        else if(dec_flag && (num == 1 || num == 2 ))
        {
            return str_alter_figures.get(num);
        }
        else if(num < 20)
        {
            return CATALOG_OF_FIRST_TWENTY.get(num);
        }
        else if(num < 100)
        {
            if(dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                return CATALOG_OF_DOZENS.get(num/10) + " " + str_alter_figures.get(num%10);
            else if (num % 10 == 0)
                return CATALOG_OF_DOZENS.get(num/10);
            else
                return CATALOG_OF_DOZENS.get(num/10) + " " + CATALOG_OF_FIRST_TWENTY.get(num%10);
        }
        else
        {
            result = CATALOG_OF_HUNDREDS.get(num/100) ;
            if((num/10) % 10 == 0) //если _0?
            {
                if((num % 10) == 0) //если _00
                    return result;
                else { //если _0_
                    if (dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                        return result + " " + str_alter_figures.get(num % 10);
                    else
                        return result + " " + CATALOG_OF_FIRST_TWENTY.get(num % 10);
                }
            }
            else if ((num % 10) == 0) //если __0
            {
                if((num / 10) % 10 == 1)
                    return result + " " + CATALOG_OF_FIRST_TWENTY.get(10);
                else
                    return result + " " + CATALOG_OF_DOZENS.get((num / 10) % 10);
            }
            else
            {
                if (num % 100 < 20)
                    return result + " " + CATALOG_OF_FIRST_TWENTY.get(num % 100);
                else {
                    if (dec_flag && ((num % 10) == 1 || (num % 10) == 2))
                        return result + " " + CATALOG_OF_DOZENS.get((num / 10) % 10) + " " + str_alter_figures.get(num % 10);
                    else
                        return result + " " + CATALOG_OF_DOZENS.get((num / 10) % 10) + " " + CATALOG_OF_FIRST_TWENTY.get(num % 10);
                }
            }
        }
    }
}
