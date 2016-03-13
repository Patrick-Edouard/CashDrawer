package ch.qiminfo.demo.database.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by patrick-edouard on 3/10/16.
 */
public class CoinTypeTest {

    @Test
    public void testGetValue() throws Exception {
        for(CoinType coinType : CoinType.values()) {
            System.out.println("value"+coinType);
            System.out.println("getValue()"+coinType.getValue());
            System.out.println("getCoinTypeString"+coinType.getCoinTypeString());
        }
    }
}