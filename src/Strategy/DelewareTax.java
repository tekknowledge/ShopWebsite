package Strategy;
import Models.Tax;

public class DelewareTax extends TaxComputationStrategy {
  private final String state = "Deleware";
  private double percentage = .06;
  
  public DelewareTax(){
  }
  
  @Override
  public Tax Implement(){
    return new Tax(.00, "Deleware");
  }
}