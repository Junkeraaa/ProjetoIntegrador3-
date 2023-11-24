package br.com.suutz.common;

import java.util.ArrayList;

import br.com.suutz.DAO.FixedIncomeDAO;
import br.com.suutz.entity.FixedIncome;
import br.com.suutz.entity.FixedIncomeClient;
import br.com.suutz.entity.User;

public class ReturnFixedIncomesByUser {
    public static ArrayList<MyAssetsFixedIncomeInterface> ReturnFixedIncomesByUserFunction(User user){
        ArrayList<MyAssetsFixedIncomeInterface> fixedIncomeByUser = new ArrayList<MyAssetsFixedIncomeInterface>();
        ArrayList<FixedIncomeClient> fixedIncomePerClient = new ArrayList<FixedIncomeClient>();
        
        fixedIncomePerClient= FixedIncomeDAO.getFixedIncomeByUserId(user.getId());

        ArrayList<FixedIncome> fixedIncomeByUserSearch = new ArrayList<FixedIncome>();
        for (FixedIncomeClient interactive: fixedIncomePerClient ){
            fixedIncomeByUserSearch.add(FixedIncomeDAO.getFixedIncomesById(interactive.getFixedIncomeId()));
        }

        for(FixedIncome interactive : fixedIncomeByUserSearch){
            MyAssetsFixedIncomeInterface MyAssetsFixedIncomeInterfaceClient = new MyAssetsFixedIncomeInterface();
            MyAssetsFixedIncomeInterfaceClient.setPrice(interactive.getPrice());
            MyAssetsFixedIncomeInterfaceClient.setFee(interactive.getFee());
            MyAssetsFixedIncomeInterfaceClient.setName(interactive.getName());
            MyAssetsFixedIncomeInterfaceClient.setType(interactive.getType());
           fixedIncomeByUser.add(MyAssetsFixedIncomeInterfaceClient);
        }


        return fixedIncomeByUser;
    }
}
