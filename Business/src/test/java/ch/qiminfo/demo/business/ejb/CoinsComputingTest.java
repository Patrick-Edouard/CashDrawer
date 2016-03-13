package ch.qiminfo.demo.business.ejb;

import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.exception.NotEnoughCoinsException;
import ch.qiminfo.demo.utility.CoinUtility;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by patrick-edouard on 3/8/16.
 */
public class CoinsComputingTest {

    @org.junit.Test
    public void testGetMoney() throws Exception {

    	/*
        boolean notEnoughCoins = false;

        try {

            CoinsComputing coinsComputing = new CoinsComputing();
            coinsComputing.initData();

            for (int i = 0; i <= 500; ++i) {

                List<Coin> coins = coinsComputing.getMoney(CoinUtility.getCentValue(8.60));

                System.out.println("Money : ");
                for (Coin coin : coins){
                    System.out.println(coin);
                }
                
            }

        }catch(NotEnoughCoinsException e){
            notEnoughCoins = true;
        }

        assertTrue(notEnoughCoins);
        */
    }
}