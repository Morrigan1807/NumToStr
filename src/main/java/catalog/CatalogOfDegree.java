package catalog;

import java.util.HashMap;
import java.util.Map;
//Singleton catalog
public class CatalogOfDegree {
    private final static CatalogOfDegree CATALOG_INSTANCE = new CatalogOfDegree();
    public final static Map<Integer, String> CATALOG_DEGREE = new HashMap<Integer, String>(); //контейнер для значения степеней (k/3)

    private CatalogOfDegree() {
        init();
    }

    private void init() {
        CATALOG_DEGREE.put(1, "тысяч");
        CATALOG_DEGREE.put(2, "миллион");
        CATALOG_DEGREE.put(3, "миллиард");
        CATALOG_DEGREE.put(4, "триллион");
        CATALOG_DEGREE.put(5, "квадриллион");
        CATALOG_DEGREE.put(6, "квинтиллион");
        CATALOG_DEGREE.put(7, "секстиллион");
        CATALOG_DEGREE.put(8, "септиллион");
        CATALOG_DEGREE.put(9, "октиллион");
        CATALOG_DEGREE.put(10, "нониллион");
        CATALOG_DEGREE.put(11, "дециллион");
        CATALOG_DEGREE.put(12, "андециллион");
        CATALOG_DEGREE.put(13, "дуодециллион");
        CATALOG_DEGREE.put(14, "тредециллион");
        CATALOG_DEGREE.put(15, "кваттордециллион");
        CATALOG_DEGREE.put(16, "квиндециллион");
        CATALOG_DEGREE.put(17, "сексдециллион");
        CATALOG_DEGREE.put(18, "септемдециллион");
        CATALOG_DEGREE.put(19, "октодециллион");
        CATALOG_DEGREE.put(20, "новемдециллион");
        CATALOG_DEGREE.put(21, "вигинтиллион");
    }

    public static CatalogOfDegree getInstance() {
        return CATALOG_INSTANCE;
    }
}