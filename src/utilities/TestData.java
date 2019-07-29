package utilities;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.parser.ParserException;

import objects.Customer;

import java.util.HashMap;
import java.util.List;

/**
 * Class for holding test data loaders
 */
public class TestData extends ConfigLoaderBase {

    //Path to data files
    private static final String CUSTOMER_INFORMATION = "/datatest/CustomerInformation.yml";
    static Customer customer;
    /**
     * Loads country-specific Customer data from a corresponding data file
     *
     * @param name is a Customer entity for which to load a country-specific data
     * @return a country-specific Customer data
     * @throws Exception
     */
    public static Customer getPreDefinedCustomerInformation() throws Exception {
        Log.info("Getting Pre-defined Customer Information from data test.");
        customer = new Customer();
        customer.setCustomerFirstName(getYAMLValue(CUSTOMER_INFORMATION, "CUSTOMER_FIRSTNAME"));
        customer.setCustomerSurname(getYAMLValue(CUSTOMER_INFORMATION, "CUSTOMER_SURNAME"));
        customer.setCustomerTitle(getYAMLValue(CUSTOMER_INFORMATION, "TITLES"));
        customer.setEmail(getYAMLValue(CUSTOMER_INFORMATION, "EMAIL"));
        customer.setPassword(getYAMLValue(CUSTOMER_INFORMATION, "PASSWORD"));
        customer.setBillingFirstName(getYAMLValue(CUSTOMER_INFORMATION, "BILLING_FIRSTNAME"));
        customer.setBillingSurname(getYAMLValue(CUSTOMER_INFORMATION, "BILLING_SURNAME"));
        customer.setAddress1(getYAMLValue(CUSTOMER_INFORMATION, "ADDRESS1"));
        customer.setAddress2(getYAMLValue(CUSTOMER_INFORMATION, "ADDRESS2"));
        customer.setCity(getYAMLValue(CUSTOMER_INFORMATION, "CITY"));
        customer.setState(getYAMLValue(CUSTOMER_INFORMATION, "STATE"));
        customer.setDayOfBirth(getYAMLValue(CUSTOMER_INFORMATION, "DAY_OF_BIRTH"));
        customer.setMonthOfBirth(getYAMLValue(CUSTOMER_INFORMATION, "MONTH_OF_BIRTH"));
        customer.setYearOfBirth(getYAMLValue(CUSTOMER_INFORMATION, "YEAR_OF_BIRTH"));
        customer.setHomePhoneNumber(getYAMLValue(CUSTOMER_INFORMATION, "HOME_PHONE"));
        customer.setMobilePhoneNumber(getYAMLValue(CUSTOMER_INFORMATION, "MOBILE_PHONE"));
        customer.setCountry(getYAMLValue(CUSTOMER_INFORMATION, "COUNTRY"));
        customer.setPostCode(getYAMLValue(CUSTOMER_INFORMATION, "POSTCODE"));
        customer.setAddressAlias(getYAMLValue(CUSTOMER_INFORMATION, "ADDRESS_ALIAS"));
        return customer;
    }

    public static String getCustomerInformationForSpecificField(String field) throws Exception {
        return getYAMLValue(CUSTOMER_INFORMATION, field);
    }

    private static String getYAMLValue(String ymlFile, String field) throws Exception {
    	Log.info("Getting test data for [" + field + "].");
        try {
            HashMap data = readYAMLValuesAsHashMap(ymlFile);
            String result = data.get(field).toString();
            Log.debug("Yaml value for field [" + field + "] in YAML file [" + ymlFile + "] is: [" + result + "]");
            return result;
        } catch (ParserException ex) {
            throw new Exception("Unable to parse YML file", ex);
        }
    }


}