package br.com.suutz.common;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public static void sendPageLoginDao(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.sendRedirect(req.getContextPath() + "/LoggedInPages/loggedIn.jsp");
    }

    public static void reloadStocks(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.sendRedirect(req.getContextPath() + "/LoggedInPages/Stocks/stocks.jsp");
    }
}