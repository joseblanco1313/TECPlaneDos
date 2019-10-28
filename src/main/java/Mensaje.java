//
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Mensaje {

    public static final String ACCOUNT_SID = "AC23fd84417b787644e94ec987e5d9714a";
    public static final String AUTH_TOKEN = "834423b8a325c08a55d443af2ecffcfd";

    //public static void main(String[] args) {
    public void EnviarMensaje(String Texto) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            Message message = Message.creator(new PhoneNumber("+50685184388"), new PhoneNumber("+12056276912"), Texto).create();

            System.out.println(message.getSid());
        } catch (Exception e) {
            System.out.println("GG");
        }

    }

    //}
}
