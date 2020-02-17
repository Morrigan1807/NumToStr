package catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogOfHundreds {
    private final static CatalogOfHundreds CATALOG_INSTANCE = new CatalogOfHundreds();
    public final static  Map<Integer, String> CATALOG_HUNDREDS = new HashMap<Integer, String>();

    private CatalogOfHundreds() {
        init();
    }

    private void init() {
        CATALOG_HUNDREDS.put(1, "сто");
        CATALOG_HUNDREDS.put(2, "двести");
        CATALOG_HUNDREDS.put(3, "триста");
        CATALOG_HUNDREDS.put(4, "четыреста");
        CATALOG_HUNDREDS.put(5, "пятьсот");
        CATALOG_HUNDREDS.put(6, "шестьсот");
        CATALOG_HUNDREDS.put(7, "семьсот");
        CATALOG_HUNDREDS.put(8, "восемьсот");
        CATALOG_HUNDREDS.put(9, "девятьсот");
    }

    public static CatalogOfHundreds getInstance() {
        return CATALOG_INSTANCE;
    }
}
