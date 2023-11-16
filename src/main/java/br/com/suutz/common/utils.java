package br.com.suutz.common;

import java.util.Random;

public class utils {

    public static boolean getRandomBoolean() {

        Random random = new Random();
        return random.nextBoolean();
        
    }

    public static double returnNewPrice(double price){
        double priceToAdd = price/100;
        if(getRandomBoolean()){
            return price+priceToAdd;
        } else {
            return price-priceToAdd;
        }
    }
}