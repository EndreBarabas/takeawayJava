package takeaway;

import java.util.Calendar;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Confirmator {
    public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("AUTH_TOKEN");
  
    public void sendMessage(){
      // I need to source the env variables every time I open a WSL terminal
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      Calendar time = Calendar.getInstance();
      Integer hour = time.get(Calendar.HOUR_OF_DAY);
      time.add(Calendar.MINUTE, 30);
      Integer minute = time.get(Calendar.MINUTE);
      String text = String.format("Thank you! Your order was placed and will be delivered before %d:%d", hour, minute);
      Message message = Message.creator(
        new PhoneNumber(System.getenv("MY_PHONE_NO")),
        new PhoneNumber("+447723414926"), 
        text).create();
      System.out.println(message.getSid());
    }
    public static void main(String[] args) {
      Confirmator confirmator = new Confirmator();
      confirmator.sendMessage();
    }
}
