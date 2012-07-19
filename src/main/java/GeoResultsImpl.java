import java.util.HashSet;
import java.util.Set;

public class GeoResultsImpl implements GeoResults
{
    public static String GeoResults_KEY ="geo_key";

    public Set getCustomerServicePhoneNumbers()
    {
        Set phoneNumbers = new HashSet();

        phoneNumbers.add("123456");
        phoneNumbers.add("654321");
        phoneNumbers.add("948737");

        return phoneNumbers;
    }
}
