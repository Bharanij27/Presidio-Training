package day16;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class SMSDemo {
	public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static final String AUTH_TOKEN = "your_auth_token";

	public void sendSMS(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+15558675309"),
				new PhoneNumber("+15017250604"), 
				"INVOICE ID" + args.toString()).create();

		System.out.println(message.getSid());
	}
}
