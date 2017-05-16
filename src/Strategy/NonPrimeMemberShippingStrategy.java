package Strategy;

public class NonPrimeMemberShippingStrategy extends ComputeShippingStrategy {
  @Override
  public Double Implement(){
    return 2.99;
  }
  
  @Override
  public String toString(){
    return "$2.99";
  }
}