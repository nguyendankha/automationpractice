package objects;

import java.util.Random;

import org.joda.time.DateTime;

import utilities.Log;
import utilities.Mailosaur;


public class Customer {

	private String email;
	private String customerSurname;
	private String customerFirstName;
	private String customerTitle;
	private String billingSurname;
	private String billingFirstName;
	private String address1;
	private String address2;
	private String postCode;
	private String city;
	private String state;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String dayOfBirth;
	private String monthOfBirth;
	private String yearOfBirth;
	private boolean takeAdvantagePromotions;
	private boolean takeAdvantagePartners;
	private String password;
	private String country;
	private String addressAlias;
	private boolean isRegistered = false;

	//data for random generator
	private String[] titles = new String[]{"MR", "MRS"};
	private String[] customerSurnames = new String[]{"Francis xavier", "Marco polo", "O'Ramen"};
	private String[] customerFirstNames = new String[]{"Qakalli", "Qakundi", "Qaxilla's"};
	private String[] billingSurnames = new String[]{"Le roux", "Men�ndez mara�on", "O'Niell"};
	private String[] billingFirstNames = new String[]{"Qal�o", "Qaram�n", "Qabob's"};
	private String[] addresses1 = new String[]{"1 Smartbox Street", "1 Sesame Street", "6 Accacia Avenue", "99'th Street Avenue"};
	private String[] addresses2 = new String[]{"Charlestown", "Orchard", "Fitzroy", "Val-d'Oise"};
	private String[] cities = new String[]{"Paris", "Lyon", "Nancy", "Val-d'Oise"};
	private String[] states = new String[]{"Alabama", "Alaska", "Arizona"};
	private String[] DOBs = new String[]{"1-1-1970", "30-4-1970", "1-3-1971", "1-1-1969", "1-2-1970", "1-2-1971", "31-12-1970", "31-12-1969", "1-9-1950", "1-8-2000", "29-2-2004"};
	private String[] homePhone = new String[]{"1234567890", "0987654321", "1234509876"};
	private String[] mobilePhone = new String[]{"1234509876", "0987612345", "1234567890"};
	private String[] countries = new String[]{"United States"};
	private String[] addressAliases = new String[]{"Alias1", "Alias2", "Alias3"};
	private static final String DEFAULT_PASSWORD = "password123";
	private static final String DEFAULT_RESET_PASSWORD = "password123456";

	public Customer() throws Exception {
		email = null;
		customerSurname = null;
		customerFirstName = null;
		customerTitle = null;
		billingSurname = null;
		billingFirstName = null;
		address1 = null;
		address2 = null;
		postCode = null;
		city = null;
		state = null;
		homePhoneNumber = null;
		mobilePhoneNumber = null;
		dayOfBirth = null;
		monthOfBirth = null;
		yearOfBirth = null;
		takeAdvantagePromotions = false;
		takeAdvantagePartners = false;
		password = null;
		country = null;
		addressAlias = null;
		isRegistered = false;
	}

	//Create full random beneficiary
	public void createCustomerWithRandomizedInformation() throws Exception {
		//fill all details from arrays
		Log.debug("Create Customer with randomized information.");
		DateTime now = new DateTime();
		Random rand = new Random(now.getMillis());

		setRandomEmail();
		setPasswordToDefault();

		this.setCustomerSurname(customerSurnames[rand.nextInt(customerSurnames.length - 1)]);
		this.setCustomerFirstName(customerFirstNames[rand.nextInt(customerFirstNames.length - 1)]);
		this.setCustomerTitle(titles[rand.nextInt(titles.length - 1)]);

		//get random date of birth
		String DoB = DOBs[rand.nextInt(DOBs.length - 1)];
		String[] dobParts = DoB.split("-");
		this.setDayOfBirth(dobParts[0]);
		this.setMonthOfBirth(dobParts[1]);
		this.setYearOfBirth(dobParts[2]);

		this.setBillingSurname(billingSurnames[rand.nextInt(billingSurnames.length - 1)]);
		this.setBillingFirstName(billingFirstNames[rand.nextInt(billingFirstNames.length - 1)]);

		this.setAddress1(addresses1[rand.nextInt(addresses1.length - 1)]);
		this.setAddress2(addresses2[rand.nextInt(addresses2.length - 1)]);
		this.setCity(cities[rand.nextInt(cities.length - 1)]);
		this.setState(states[rand.nextInt(states.length - 1)]);
		this.setPostCode(String.valueOf(((int) (Math.random()*(99999 - 10000))) + 10000));
		this.setHomePhoneNumber(homePhone[rand.nextInt(homePhone.length - 1)]);
		this.setMobilePhoneNumber(mobilePhone[rand.nextInt(mobilePhone.length - 1)]);
		this.setAddressAlias(addressAliases[rand.nextInt(addressAliases.length - 1)]);
		this.setCountry(countries[rand.nextInt(countries.length)]);
		//set newsletter signup options by default
		setTakeAdvantagePromotions(true);
		setTakeAdvantagePartners(false);
	}

	//Set password back to default
	public void setPasswordToDefault() {
		this.setPassword(DEFAULT_PASSWORD);
	}

	//Set password to password reset default
	public void setPasswordToResetDefault() {
		this.setPassword(DEFAULT_RESET_PASSWORD);
	}

	//Set random password with format "passwordXXX"
	public void setRandomPassword() {
		DateTime now = new DateTime();
		Random rand = new Random(now.getMillis());
		int randomNum = rand.nextInt(999);
		this.setPassword("Password: " + String.valueOf(randomNum));
	}

	//Set specific password for Beneficiary
	public void setPassword(String specificPassword) {
		this.password = specificPassword;
	}

	//Get random password with format "passwordXXX"
	public String getRandomPassword() {
		DateTime now = new DateTime();
		Random rand = new Random(now.getMillis());
		int randomNum = rand.nextInt(999);
		String randomPassword = "Password: " + String.valueOf(randomNum);
		return randomPassword;
	}

	//Set password to password reset default
	public void setRandomEmail() {
		this.setEmailAddress(Mailosaur.getRandomAddress());
	}


	public void setEmailAddress(String email) {
		this.
				email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerTitle() {
		return customerTitle;
	}

	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}

	public String getBillingSurname() {
		return billingSurname;
	}

	public void setBillingSurname(String billingSurname) {
		this.billingSurname = billingSurname;
	}

	public String getBillingFirstName() {
		return billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}


	public String getMonthOfBirth() {
		return monthOfBirth;
	}

	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public void setAddressAlias(String addressAlias) {
		this.addressAlias = addressAlias;
	}

	public boolean isTakeAdvantagePromotions() {
		return takeAdvantagePromotions;
	}

	public void setTakeAdvantagePromotions(boolean takeAdvantagePromotions) {
		this.takeAdvantagePromotions = takeAdvantagePromotions;
	}

	public boolean isTakeAdvantagePartners() {
		return takeAdvantagePartners;
	}

	public void setTakeAdvantagePartners(boolean takeAdvantagePartners) {
		this.takeAdvantagePartners = takeAdvantagePartners;
	}

	public String getPassword() {
		return password;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
}