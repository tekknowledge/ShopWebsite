package Models;
import Utility.StringUtility;

public class Tax {
  private double percentage;
  private final static double MULTIPLIER = 1;
  private static final int STRING_FORMAT_FIXED_LENGTH = 40;
  private String stateName;
  //private double subTotal;
  
  public Tax(double percentage, String stateName) {
    this.percentage = percentage;
    this.stateName = stateName;
  }
  
  /*public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }*/
  
  @Override
  public String toString(){
    String percentageToRender = Integer.toString(Integer.parseInt(Double.toString(percentage).replace(".", ""))) + "%";
    String stateToRender = this.stateName + " State Tax:";
    //String totalToRender = "$" + Double.toString(Math.round((subTotal * (MULTIPLIER + percentage)) * 100.0)  / 100.0);
    return StringUtility.AddPadding(stateToRender, STRING_FORMAT_FIXED_LENGTH) + 
               StringUtility.AddPadding(percentageToRender, STRING_FORMAT_FIXED_LENGTH) + StringUtility.NEW_LINE;
  }
  
  public String getStateName(){
    return this.stateName;
  }
  
  public double getPercentage(){
    return this.percentage;
  }
    
  public double getTax() {
    return (MULTIPLIER + percentage);
  }
  
}