package Views;
import Models.Order;
import Models.Customer;
import javax.swing.JOptionPane;
import Models.IOrder;

public class ShowOrder implements IView<Order> {
  
  private IOrder order;
  private Customer customer;
  
  public ShowOrder(Customer customer, IOrder order) {
    this.order = order;
    this.customer = customer;
  }
  
  @Override
  public void Present() {
    //null, message, title, JOptionPane.YES_NO_OPTION
    if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, order.print(), "Confirm Order", JOptionPane.YES_NO_OPTION) ){
      
    }
  }
  
  @Override
  public Order GetData(){
    return (Order)null;
  }
}