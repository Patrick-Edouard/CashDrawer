package ch.qiminfo.demo.business.ejb.exception;

/**
 * Created by patrick-edouard on 3/7/16.
 */
public class NotPaidEnoughException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotPaidEnoughException(){
        //super("The input paid amount is lower than the price");
    }

    public String getMessage(){
        return "The input paid amount is lower than the price\n"+super.getMessage();
    }
}
