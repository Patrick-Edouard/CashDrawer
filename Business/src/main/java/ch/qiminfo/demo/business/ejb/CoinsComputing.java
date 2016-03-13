package ch.qiminfo.demo.business.ejb;

import ch.qiminfo.demo.business.ejb.exception.NotPaidEnoughException;
import ch.qiminfo.demo.database.dao.ICoinDAO;
import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.exception.NotEnoughCoinsException;
import ch.qiminfo.demo.utility.CoinUtility;

import java.util.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by patrick-edouard on 3/8/16.
 */

@Stateless
public class CoinsComputing {
	
	@EJB
	ICoinDAO coinDAO;
	
    public CoinsComputing(){
        
    }
    
    public List<Coin> getMoney(double price, double payedAmount)throws NotEnoughCoinsException, NotPaidEnoughException {
    	return getMoney(CoinUtility.getCentValue(price), CoinUtility.getCentValue(payedAmount));
    }
    

    public List<Coin> getMoney(int price, int payedAmount) throws NotEnoughCoinsException, NotPaidEnoughException {
    	int reimbursement = payedAmount-price;
    	
    	if(reimbursement>=0){
    		List<Coin> coins = new ArrayList<Coin>();

            return getMoney(coins, reimbursement);
    	}
    	else{
    		throw new NotPaidEnoughException();
    	}
    	
    }

    private List<Coin> getMoney(List<Coin> coins, int payedAmount) throws NotEnoughCoinsException{

        Coin coin = getBiggestCoin(payedAmount);
        coins.add(coin);

        payedAmount = payedAmount - coin.getValue();

        if(payedAmount>0){
            getMoney(coins, payedAmount);
        }

        return coins;
    }

    private Coin getBiggestCoin(int payedAmount) throws NotEnoughCoinsException{
    	return coinDAO.getBiggestCoin(payedAmount);
    }

}
