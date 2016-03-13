package ch.qiminfo.demo.database.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.CoinType;
import ch.qiminfo.demo.database.entities.exception.NotEnoughCoinsException;

@Stateless
public class CoinDAO implements ICoinDAO {
	
    @PersistenceContext(unitName = "CashDrawer")
    protected EntityManager entityManager;// = Persistence.createEntityManagerFactory("CashDawler").createEntityManager();
    

    public Coin getBiggestCoin(int payedAmount) throws NotEnoughCoinsException {

        //entityManager.getTransaction().begin();

        Query query = entityManager.createNamedQuery("findAllCoinsByType");

        for(CoinType coinType : CoinType.values()){
            query.setParameter("type",coinType);
            @SuppressWarnings("unchecked")
			List<Coin> coinsForValue = query.getResultList();
            if(!coinsForValue.isEmpty()){
                Coin aCoin = coinsForValue.get(0);

                if(payedAmount>=aCoin.getValue()){
                	entityManager.remove(aCoin);
                    //entityManager.getTransaction().commit();
                    return aCoin;
                }
            }
        }

        //entityManager.getTransaction().commit();

        /*
        for(int i = 0; i<NB_OF_COINS; ++i){
            if(payedAmount>=coinValues[i]) {
                if (!availableCoins.get(coinValues[i] + "").isEmpty()) {
                    Coin coin = availableCoins.get(coinValues[i] + "").get(0);
                    availableCoins.get(coinValues[i] + "").remove(0);
                    return coin;
                }
            }
        }

        for(int i = 0; i<NB_OF_COINS; ++i){
            if(availableCoins.get(coinValues[i] + "").isEmpty()){
                System.out.println("No more coins in "+coinValues[i]);
            }
        }
        */

        throw new NotEnoughCoinsException();
    }

    public void addNewCoin(Coin coin) {
        entityManager.persist(coin);
    }

}
