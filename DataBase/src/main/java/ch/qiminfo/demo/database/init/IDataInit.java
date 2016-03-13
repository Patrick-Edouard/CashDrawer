package ch.qiminfo.demo.database.init;

import javax.ejb.Remote;

/**
 * Created by patrick-edouard on 3/9/16.
 */

@Remote
public interface IDataInit {

    void initializeData();
}
