package utilities;

import com.mailosaur.*;

public class Mailosaur {

    //Mailosaur details
    private static final String apikey = "E1uXBsBhhg7cfPY";
    private static final String SERVER_ID = "v66ryipz";

    /**
     * Creates random email address
     */
    public static String getRandomAddress() {
    	Log.debug("Generate random e-mail address.");
    	MailosaurClient client = new MailosaurClient(apikey);
    	// Returns random address, e.g. ab234es.automation-practice@mailosaur.io
    	String randomEmailAddress = client.servers().generateEmailAddress(SERVER_ID);
    	Log.debug("Random e-mail address: " + randomEmailAddress);
    	return randomEmailAddress.toString();
    }
}