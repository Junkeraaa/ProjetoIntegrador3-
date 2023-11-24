package br.com.suutz.common;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.entity.FixedIncome;

import java.util.ArrayList;

public class UpdateIncomeUser {
    static double amoutYeld = 0.0;
    public static double updateIncomeUserFunction(){
        System.out.println("Rendendo");

        ArrayList<FixedIncome> listOfIncomes = new ArrayList<>();
        listOfIncomes = FixedIncomeDAO.getIncomes();

        for(FixedIncome fixedIncome: listOfIncomes){

           double amount =  FixedIncomeDAO.getAmountByUserId(GlobalData.userLogged.getId(), fixedIncome.getID());

           amoutYeld = amount * (1+(FixedIncomeDAO.getFee()/100));//Valor após a aplicação da taxa


        }

        return amoutYeld;

    }
}
