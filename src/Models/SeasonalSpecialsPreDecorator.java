package Models;
import Utility.StringUtility;
import java.util.Date;

public class SeasonalSpecialsPreDecorator extends OrderDecorator {
  public SeasonalSpecialsPreDecorator(IOrder baseOrder) {
    super(baseOrder);
  }
  
  @Override
  public String print(){
        int m = new Date().getMonth();
        String promotion = "";
        if (m >= 1 && m < 4) {
          promotion = "Check out our spring deals!";
        } else if (m >= 4 && m < 8){
          promotion = "Check out our summer deals!";
        } else if (m >=8 && m < 11 ) {
          promotion = "Check out our autumn deals!";
        } else {
          promotion = "Check out our winter deals!";
        }
        
        return promotion + StringUtility.NEW_LINE + baseOrder.print();
  }
}