package Controllers;
import Models.Order;
import Models.Customer;
import Models.Cart;
import Views.IView;
import Views.ShowOrder;
import Utility.NullObject;
import Models.IOrder;
import Models.JoinPrimePostDecorator;
import Models.SeasonalSpecialsPreDecorator;

public class OrderController extends Controller<Order> {
  Customer customer;
  Cart cart;
  
  public OrderController(Customer customer, Cart cart) { 
    this.customer = customer;
    this.cart = cart;
  }
  
  public Order Render() {
    Order bOrder = null;
    try {
      bOrder = new Order(cart);
    } catch (Exception ex) {
      return (Order)null;
    }
      
    IOrder order = new JoinPrimePostDecorator(new SeasonalSpecialsPreDecorator(bOrder), customer.getIsPrimeMember());
    
    IView<Order> view = new ShowOrder(customer, order);
    view.Present();
    return bOrder;
  }
}