package nerdschool.bar;

import java.util.HashMap;
import java.util.Map;

public class Pub {


    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public static final Map<String,Integer> price_list = fillPriceList();



    private static Map<String, Integer> fillPriceList() {
        HashMap<String, Integer> priceList = new HashMap<>();

        priceList.put(ONE_BEER, 74);
        priceList.put(ONE_CIDER, 103);
        priceList.put(A_PROPER_CIDER, 110);
        priceList.put(GT, getGTPrice());
        priceList.put(BACARDI_SPECIAL, getBacardiPrice());

        return priceList;
    }

    private static int getBacardiPrice() {

        return getGinPrice()/2 + getRumPrice() + getGrenadinePrice() + getLimeJuicePrice();
    }

    private static int getGTPrice() {


        return getGinPrice()+ getTonicPrice()+ getGreenStuffPrice();
    }



    public int computeCost(String drink, boolean student, int amount) {

        checkForLegalOrder(drink, amount);

        int actual_price =   price_list.get(drink);

        if(student && !(drink.equals(GT) || drink.equals(BACARDI_SPECIAL))){
            actual_price = actual_price - actual_price/10;
        }

        return actual_price*amount;

    }




//    private int priceFactory(String drink,boolean student, int amount){

//    }

    private void checkForLegalOrder(String drink, int amount) {

        if(!price_list.containsKey(drink)){
            throw new RuntimeException("No such drink exists");
        }

        if(amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))){
            throw new RuntimeException("Too many drinks, max 2");

        }
    }

    //one unit of rum
    private static int getRumPrice() {
        return 65;
    }

    //one unit of grenadine
    private static int getGrenadinePrice() {
        return 10;
    }

    //one unit of lime juice
    private static int getLimeJuicePrice() {
        return 10;
    }
    
    //one unit of green stuff
    private static int getGreenStuffPrice() {
        return 10;
    }

    //one unit of tonic water
    private static int getTonicPrice() {
        return 20;
    }

    //one unit of gin
    private static int getGinPrice() {
        return 85;
    }
}


/*
    Differences between lecturer and mine:
        Made beverage-object
        made beverage-object amountLimited
        checked for test-failing throughout
        did other stuff.



 */