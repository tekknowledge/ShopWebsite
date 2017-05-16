package Models;

public abstract class OrderDecorator implements IOrder {
  
  protected IOrder baseOrder;
  
  public OrderDecorator(IOrder baseOrder){
    this.baseOrder = baseOrder;
  }
  
  public String print(){
    return baseOrder.print();
  }
  
}