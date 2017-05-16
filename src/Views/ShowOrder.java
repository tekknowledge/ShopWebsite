package Views;
import Models.Order;
import Models.Customer;

public class ShowOrder implements IView<Order> {
  
  private Order order;
  private Customer customer;
  
  public ShowOrder(Customer customer, Order order) {
    this.order = order;
    this.customer = customer;
  }
  
  @Override
  public void Present() {
    System.out.println(order.toString());
  }
  
  @Override
  public Order GetData(){
    return (Order)null;
  }
}