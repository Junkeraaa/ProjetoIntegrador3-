package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.DAO.StocksDAO;
import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;
import br.com.suutz.entity.StockClient;

public class main {
    public static void main(String[] args) {
        ArrayList<FixedIncomeClient> teste = new ArrayList<FixedIncomeClient>();
        teste = FixedIncomeDAO.getFixedIncomeByUserId(35);

        System.out.println("teste");

        for ( FixedIncomeClient a : teste) {

            FixedIncome teste2 = new FixedIncome();
        teste2 = FixedIncomeDAO.getFixedIncomesById(a.getFixedIncomeId());

        System.out.println(teste2.getName());
        }
    }
}
