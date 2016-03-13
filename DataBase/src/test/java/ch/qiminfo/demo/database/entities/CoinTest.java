package ch.qiminfo.demo.database.entities;

import ch.qiminfo.demo.database.init.DataInit;
import org.junit.Test;

/**
 * Created by patrick-edouard on 3/9/16.
 */
public class CoinTest {

    @Test
    public void testToString() throws Exception {

        Coin c = new Coin();
        c.setCoinType(CoinType.FIFTY_CENT);
        System.out.println(c.toString());

    }

    @Test
    public void testInitCoins() throws Exception {

        DataInit dataInit = new DataInit();
        //dataInit.initializeData();

    }
    
}