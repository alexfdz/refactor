import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

import java.util.Set;

public class CustomerService
{

    public String DEFAULT_CS_NUMBER = "999999";

    /**
     * Produce customer service phone numbers from Geo results stored in the HTTP session. Each geographic region has its' zero or more customer service phone numbers. It is
     * possible to show more than one phone number. If there is no phone number associated a default phone number is used.
     */
    public String getCustomerServicePhoneNumber(HttpSession session)
    {

        String phoneNumber = "";
        GeoResults result = (GeoResults) session.getAttribute(GeoResultsImpl.GeoResults_KEY);

        if (result != null)
        {

            Set phoneNumbers = result.getCustomerServicePhoneNumbers();

            if (phoneNumbers != null)
            {

                for (Object string : phoneNumbers)
                {
                    phoneNumber += phoneNumbers.iterator().next();
                }
            }
            else
            {
                Logger.getLogger(this.getClass()).warn("No customer service numbers found.");
                phoneNumber = DEFAULT_CS_NUMBER;
            }
        }

        return phoneNumber;
    }
}