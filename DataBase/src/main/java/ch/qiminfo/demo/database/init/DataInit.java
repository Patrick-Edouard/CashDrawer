package ch.qiminfo.demo.database.init;

import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.CoinType;
import ch.qiminfo.demo.ressources.RessourcesParsor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

/**
 * Created by patrick-edouard on 3/7/16.
 */

@Stateless
public class DataInit implements IDataInit {

    /**
     * Map of <Key, Value> containing db properties.
     */
    private Map<String, String> dataBaseProperties = RessourcesParsor.getDbProperties();

    @PersistenceContext(name = "CashDrawer")
    EntityManager entityManager;// = Persistence.createEntityManagerFactory("CashDawler").createEntityManager();

    /**
     * Service that allow to add coins in the DataBase
     */
    public DataInit(){

    }

    public void initializeData() {
    	
    	for(CoinType coinType : CoinType.values()){
    		entityManager.persist(coinType);
    	}

        Coin currentCoin;
       //entityManager.getTransaction().begin();

        for(CoinType coinType : CoinType.values()) {
            int numberOfCoins = Integer.parseInt(dataBaseProperties.get(coinType.getCoinTypeString()+"_NUMBER"));
            for(int i = 0; i<= numberOfCoins; ++i){
                currentCoin = new Coin();
                currentCoin.setCoinType(coinType);
                entityManager.persist(currentCoin);
            }
            entityManager.flush();
        }
        
        //entityManager.getTransaction().commit();
        //entityManager.close();
    }
}
