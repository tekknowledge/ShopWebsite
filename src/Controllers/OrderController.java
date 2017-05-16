package Controllers;
import Models.Order;
import Models.Customer;
import Models.Cart;
import Views.IView;
import Views.ShowOrder;
import Utility.NullObject;

public class OrderController extends Controller<Order> {
  Customer customer;
  Cart cart;
  
  public OrderController(Customer customer, Cart cart) { 
    this.customer = customer;
    this.cart = cart;
  }
  
  public Order Render() {
    Order order = null;
    try {
      order = new Order(cart);
    } catch (Exception ex) {
      return (Order)null;
    }
      
      IView<Order> view = new ShowOrder(customer, order);
      view.Present();
      return order;
  }
}