package ch.qiminfo.demo.business.ejb.db.acces;

import ch.qiminfo.demo.database.dao.ICoinDAO;
import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.CoinType;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Map;

/**
 * Created by patrick-edouard on 3/10/16.
 */

@Stateless
public class DbAcces {

    @EJB
    ICoinDAO coinDAO;

    public void addNewCoins(Map<String, String> info){
        int numberOfCoin;
        for(CoinType coinType : CoinType.values()){

            numberOfCoin = Integer.parseInt(info.get(coinType.getCoinTypeString()));
            System.out.println("Adding "+ numberOfCoin + " coin of "+ coinType);
            for(int i = 0; i <= numberOfCoin; ++i){
                Coin coin = new Coin();
                coin.setCoinType(coinType);

                coinDAO.addNewCoin(coin);
            }
        }
    }
}
