package Strategy;
import Models.Tax;

public class DelewareTax extends TaxComputationStrategy {
  private final String state = "Deleware";
  private double percentage = .06;
  private double subTotal;
  
  public DelewareTax(double subTotal){
    this.subTotal = subTotal;
  }
  
  @Override
  public Tax Implement(){
    return new Tax(.00, "Deleware");
  }
}