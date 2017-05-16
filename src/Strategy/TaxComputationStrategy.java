package Strategy;
import Models.Tax;

public abstract class TaxComputationStrategy implements IStrategy<Tax> { 
  public abstract Tax Implement();
}