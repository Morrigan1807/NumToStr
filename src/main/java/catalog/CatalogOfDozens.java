package catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogOfDozens {

    private final static CatalogOfDozens CATALOG_INSTANCE = new CatalogOfDozens();
    public final static Map<Integer, String> CATALOG_DOZENS = new HashMap<Integer, String>();

    private CatalogOfDozens() {
        init();
    }

    private void init() {
        CATALOG_DOZENS.put(2, "двадцать");
        CATALOG_DOZENS.put(3, "тридцать");
        CATALOG_DOZENS.put(4, "сорок");
        CATALOG_DOZENS.put(5, "пятьдесят");
        CATALOG_DOZENS.put(6, "шестьдесят");
        CATALOG_DOZENS.put(7, "семьдесят");
        CATALOG_DOZENS.put(8, "восемьдесят");
        CATALOG_DOZENS.put(9, "девяносто");
    }

    public static CatalogOfDozens getInstance() {
        return CATALOG_INSTANCE;
    }
}
