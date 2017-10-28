package stefellenberger.taxfreeapp;

import java.util.ArrayList;

/**
 * Created by Stefan on 27.10.2017.
 */

public class Quota {
    //green red indicator
    private boolean ok = false;
    //amounts
    private int beerN;
    private int wineN;
    private int spiritN;
    private int tobaccoN;

    //olgrense 6500 ml
    private final int BEERLIMIT = 6500;
    //vingrense 4500 ml
    private final int WINELIMIT = 4500;
    //spritgrense 1000 ml
    private final int SPIRITLIMIT = 1000;
    //tobakkgrense 220g
    private final int TOBACCOLIMIT = 220;

    //modifiers
    private boolean spirit = false;
    private boolean tobacco = false;
    //olgrense med sprit
    private final int SPIRITBEERWINELIMIT = 5000;
    private final int SPIRITWINELIMIT = 3000;
    //olgrense med tobakk
    private final int TOBACCOBEERLIMIT = 5000;
    private final int TOBACCOWINELIMIT = 3000;
    //olgrense med begge
    private final int BOTHBEERLIMIT = 3500;
    private final int BOTHWINELIMIT = 1500;

    public Quota(){
        beerN = 0;
        wineN = 0;
        spiritN = 0;
        tobaccoN = 0;
    }

    public boolean add(ArrayList<Product> products){
        boolean r = true;
        for (Product p : products){
            boolean check = add(p);
            if (!check){
                r = false;
            }
        }
        return r;
    }

    public boolean add(Product p){
        if (p.category().equals(Category.BEER)){
            beerN += p.amount();
        }
        if (p.category().equals(Category.WINE)){
            wineN += p.amount();
        }
        if (p.category().equals(Category.SPIRIT)){
            spiritN += p.amount();
        }
        if (p.category().equals(Category.TOBACCO)){
            tobaccoN += p.amount();
        }
        return ok();
    }

    public boolean remove(Product p){
        if (p.category().equals(Category.BEER)){
            beerN -= p.amount();
        }
        if (p.category().equals(Category.WINE)){
            wineN -= p.amount();
        }
        if (p.category().equals(Category.SPIRIT)){
            spiritN -= p.amount();
        }
        if (p.category().equals(Category.TOBACCO)){
            tobaccoN -= p.amount();
        }
        return ok();
    }

    private boolean ok(){
        if (check()){
            return true;
        } else {
            return false;
        }
    }

    private boolean check(){
        //adjust modifiers
        if (spiritN > 0){
            spirit = true;
        } else {
            spirit = false;
        }
        if (tobaccoN > 0){
            tobacco = true;
        } else {
            tobacco = false;
        }
        //correct for negative
        if (beerN < 0)
            beerN = 0;
        if (wineN < 0)
            wineN = 0;
        if (spiritN < 0)
            spiritN = 0;
        if (tobaccoN < 0)
            tobaccoN = 0;

        //modifiers (add both first)
        //todo: add if spirit && tobacco
        if (spirit && tobacco)
            return checkBoth();
        if (spirit){
            return checkSpirit();
        }
        if (tobacco){
            return checkTobacco();
        }
        //both false
        if (beerN > BEERLIMIT)
            return false;
        if (wineN > WINELIMIT)
            return false;
        if (beerN + wineN > BEERLIMIT)
            return false;
        return true;
    }
    private boolean checkSpirit(){
        if (beerN + wineN > SPIRITBEERWINELIMIT)
            return false;
        if (wineN > SPIRITWINELIMIT)
            return false;
        if (spiritN > SPIRITLIMIT)
            return false;
        return true;
    }
    private boolean checkTobacco(){
        if (beerN + wineN > TOBACCOBEERLIMIT)
            return false;
        if (wineN > TOBACCOWINELIMIT)
            return false;
        if (tobaccoN > TOBACCOLIMIT)
            return false;
        return true;
    }
    private boolean checkBoth(){
        if (beerN + wineN > BOTHBEERLIMIT)
            return false;
        if (wineN > BOTHWINELIMIT)
            return false;
        if (spiritN > SPIRITLIMIT)
            return false;
        if (tobaccoN > TOBACCOLIMIT)
            return false;

        return true;
    }

    public String toString(){
        String r = "";
        if (beerN > 0){
            r += "Beer: " + beerN + "\n";
        }
        if (wineN > 0){
            r += "Wine: " + wineN + "\n";
        }
        if (spiritN > 0){
            r += "Spirit: " + spiritN + "\n";
        }
        if (tobaccoN > 0){
            r += "Tobacco: " + tobaccoN;
        }
        return r;
    }
}
