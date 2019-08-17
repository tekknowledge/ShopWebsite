package Strategy;
import Models.Tax;

public class MarylandTax extends TaxComputationStrategy {
  private final String state = "Maryland";
  private double percentage = .06;
  private double subTotal;
  
  public MarylandTax(){
  }
  
  @Override
  public Tax Implement(){
    return new Tax(.06, "Maryland");
  }
}