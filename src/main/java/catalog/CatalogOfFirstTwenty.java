package catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogOfFirstTwenty {
    private final static CatalogOfFirstTwenty CATALOG_INSTANCE = new CatalogOfFirstTwenty();
    public final static Map<Integer, String> CATALOG_FIRST_TWENTY = new HashMap<Integer, String>();

    private CatalogOfFirstTwenty() {
        init();
    }

    private void init() {
        CATALOG_FIRST_TWENTY.put(0, "ноль");
        CATALOG_FIRST_TWENTY.put(1, "один");
        CATALOG_FIRST_TWENTY.put(2, "два");
        CATALOG_FIRST_TWENTY.put(3, "три");
        CATALOG_FIRST_TWENTY.put(4, "четыре");
        CATALOG_FIRST_TWENTY.put(5, "пять");
        CATALOG_FIRST_TWENTY.put(6, "шесть");
        CATALOG_FIRST_TWENTY.put(7, "семь");
        CATALOG_FIRST_TWENTY.put(8, "восемь");
        CATALOG_FIRST_TWENTY.put(9, "девять");
        CATALOG_FIRST_TWENTY.put(10, "десять");
        CATALOG_FIRST_TWENTY.put(11, "одиннадцать");
        CATALOG_FIRST_TWENTY.put(12, "двенадцать");
        CATALOG_FIRST_TWENTY.put(13, "тринадцать");
        CATALOG_FIRST_TWENTY.put(14, "четырнадцать");
        CATALOG_FIRST_TWENTY.put(15, "пятнадцать");
        CATALOG_FIRST_TWENTY.put(16, "шестнадцать");
        CATALOG_FIRST_TWENTY.put(17, "семнадцать");
        CATALOG_FIRST_TWENTY.put(18, "восемнадцать");
        CATALOG_FIRST_TWENTY.put(19, "девятнадцать");
    }

    public static CatalogOfFirstTwenty getInstance() {
        return CATALOG_INSTANCE;
    }
}
