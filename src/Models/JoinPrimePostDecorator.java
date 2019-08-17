package Models;
import Utility.StringUtility;

public class JoinPrimePostDecorator extends OrderDecorator {
  private boolean isPrime;
  public JoinPrimePostDecorator(IOrder baseOrder, boolean isPrime) {
    super(baseOrder);
        this.isPrime = isPrime;
  }
  
  @Override
  public String print(){
        String promotion = "";
        if (!isPrime){
          promotion = "Join prime now for free shipping!";
        }

        return baseOrder.print() + StringUtility.NEW_LINE + promotion; 
  }
}