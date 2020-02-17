import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class TestNumToStr {
    @Test
    public void testFigures() throws Exception
    {
        ArrayList <String> figures = new ArrayList<String>();
        figures.add("ноль");
        figures.add("один");
        figures.add("два");
        figures.add("три");
        figures.add("четыре");
        figures.add("пять");
        figures.add("шесть");
        figures.add("семь");
        figures.add("восемь");
        figures.add("девять");

        for (int i = 0; i < 10; i++) {
            String result = NumToStr.convert(i);
            Assert.assertEquals("Ошибка с числом " + i + ". Эталонный результат \""
                    +  figures.get(i) + "\". Получилось \"" + result + "\"." , figures.get(i), result);
        }
    }

    @Test
    public void testDozens() throws Exception
    {
        ArrayList <String> dozens = new ArrayList<String>();
        dozens.add("десять");
        dozens.add("двадцать");
        dozens.add("тридцать");
        dozens.add("сорок");
        dozens.add("пятьдесят");
        dozens.add("шестьдесят");
        dozens.add("семьдесят");
        dozens.add("восемьдесят");
        dozens.add("девяносто");
        dozens.add("пятьдесят один");
        dozens.add("сорок два");
        dozens.add("тридцать три");
        dozens.add("шестьдесят четыре");
        dozens.add("пятнадцать");
        dozens.add("двадцать шесть");
        dozens.add("семьдесят девять");
        dozens.add("восемьдесят семь");
        dozens.add("девяносто восемь");

        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 51, 42, 33, 64, 15, 26, 79, 87, 98};

        for (int i = 0; i != numbers.length; i++)
        {
            String result = NumToStr.convert(numbers[i]);
            Assert.assertEquals("Ошибка с числом " + numbers[i] + ". Эталонный результат \""
                    +  dozens.get(i) + "\". Получилось \"" + result + "\"." , dozens.get(i), result);
        }
    }

    @Test
    public void testHundreds() throws Exception
    {
        ArrayList <String> hundreds = new ArrayList<String>();
        hundreds.add("сто");
        hundreds.add("двести");
        hundreds.add("триста");
        hundreds.add("четыреста");
        hundreds.add("пятьсот");
        hundreds.add("шестьсот");
        hundreds.add("семьсот");
        hundreds.add("восемьсот");
        hundreds.add("девятьсот");
        hundreds.add("сто одиннадцать");
        hundreds.add("триста тридцать один");
        hundreds.add("четыреста семьдесят");
        hundreds.add("пятьсот один");
        hundreds.add("шестьсот двадцать два");
        hundreds.add("семьсот девяносто девять");
        hundreds.add("восемьсот три");
        hundreds.add("девятьсот сорок пять");

        int[] numbers = {100, 200, 300, 400, 500, 600, 700, 800, 900, 111, 331, 470, 501, 622, 799, 803, 945};

        for (int i = 0; i != numbers.length; i++)
        {
            String result = NumToStr.convert(numbers[i]);
            Assert.assertEquals("Ошибка с числом " + numbers[i] + ". Эталонный результат \""
                    +  hundreds.get(i) + "\". Получилось \"" + result + "\"." , hundreds.get(i), result);
        }
    }

    @Test
    public void testLong()
    {
        ArrayList <String> long_nums = new ArrayList<String>();
        long_nums.add("одна тысяча");
        long_nums.add("один миллион");
        long_nums.add("две тысячи");
        long_nums.add("два миллиона");
        long_nums.add("пять тысяч");
        long_nums.add("семь миллионов");
        long_nums.add("двадцать одна тысяча");
        long_nums.add("шестьдесят один миллион");
        long_nums.add("одна тысяча один");
        long_nums.add("две тысячи два");
        long_nums.add("один миллион один");
        long_nums.add("два миллиона два");
        long_nums.add("тридцать миллионов три тысячи пять");
        long_nums.add("одна тысяча сорок");
        long_nums.add("двадцать семь квадриллионов сто пятьдесят четыре триллиона " +
                "двести девяносто девять миллиардов пятьсот восемьдесят семь миллионов тридцать пять тысяч пять");

        long[] numbers = {1000, 1000000, 2000, 2000000, 5000, 7000000, 21000, 61000000, 1001, 2002, 1000001,
                2000002, 30003005, 1040, 27154299587035005L};

        for (int i = 0; i != numbers.length; i++)
        {
            String result = NumToStr.convert(numbers[i]);
            Assert.assertEquals("Ошибка с числом " + numbers[i] + ". Эталонный результат \""
                    +  long_nums.get(i) + "\". Получилось \"" + result + "\"." , long_nums.get(i), result);
        }
    }

    @Test
    public void testWithExcel() throws Exception
    {
        ArrayList <String> str_numbers = new ArrayList<String>();
        ArrayList <Integer> numbers = new ArrayList<Integer>();
        InputStream in = new FileInputStream("excelForTest/TryDoThis.xls");
        HSSFWorkbook wb = new HSSFWorkbook(in);
        HSSFSheet sh = wb.getSheet("Sheet1");
        Iterator<Row> it = sh.iterator();
        while(it.hasNext())
        {
            Row row  = it.next();
            if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                numbers.add((int)row.getCell(0).getNumericCellValue());
            }

            if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING){
                str_numbers.add(row.getCell(1).getStringCellValue());
            }
        }
        wb.close();

        for (int i = 0; i != str_numbers.size(); i++)
        {
            String result = NumToStr.convert(numbers.get(i));
            Assert.assertEquals("Ошибка с числом " + numbers.get(i) + ". Эталонный результат \""
                    +  str_numbers.get(i) + "\". Получилось \"" + result + "\"." , str_numbers.get(i), result);
        }
    }
}
