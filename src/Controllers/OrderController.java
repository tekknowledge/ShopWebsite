package Controllers;
import Models.Order;
import Models.Customer;
import Models.Cart;

public class OrderController extends Controller<Order> {
  Customer customer;
  Cart cart;
  
  public OrderController(Customer customer, Cart cart) { 
    this.customer = customer;
    this.cart = cart;
  }
  
  public Order Render(){
      Order order = null;
      return order;
  }
}