package stefellenberger.taxfreeapp;

/**
 * Created by Stefan on 27.10.2017.
 */

public enum Product {
    SMALLBEER (Category.BEER, 330, "Small beer"),
    LARGEBEER (Category.BEER, 500, "Large beer"),
    SMALLPACK (Category.BEER, SMALLBEER.amount * 6, "6-pack small beers"),
    LARGEPACK (Category.BEER, LARGEBEER.amount * 6, "6-pack large beers"),

    BOTTLEWINE (Category.WINE, 750, "Wine (bottle)"),
    SMALLBOXWINE (Category.WINE, BOTTLEWINE.amount * 2, "Wine (small box)"),
    LARGEBOXWINE (Category.WINE, BOTTLEWINE.amount * 4, "Wine (large box)"),

    HALFSPIRIT (Category.SPIRIT, 500, "Spirit (500ml)"),
    FULLSPIRIT (Category.SPIRIT, 1000, "Spirit (1000ml)"),

    CIGARETTES (Category.TOBACCO, 200, "Cigarettes (200)"),
    HALFSNUS (Category.TOBACCO, 110, "Snus (half roll)"),
    WHOLESNUS (Category.TOBACCO, 210, "Snus (full roll)");

    private final Category c;
    private final int amount;
    private String printable;

    Product (Category c, int amount, String printable){
        this.c = c;
        this.amount = amount;
        this.printable = printable;
    }

    int amount(){
        return amount;
    }
    Category category() {return c;}

    public String toString(){
        return this.printable;
    }

}