package ch.qiminfo.demo.database.dao;

import ch.qiminfo.demo.database.entities.Coin;
import ch.qiminfo.demo.database.entities.exception.NotEnoughCoinsException;

import javax.ejb.Remote;

/**
 * Created by patrick-edouard on 3/10/16.
 */

@Remote
public interface ICoinDAO {

    public Coin getBiggestCoin(int payedAmount) throws NotEnoughCoinsException;

    void addNewCoin(Coin coin);
}
