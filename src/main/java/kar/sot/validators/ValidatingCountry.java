package kar.sot.validators;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import kar.sot.util.interfaces.ValidatingInterface;

public class ValidatingCountry implements ValidatingInterface<String> {
	
	/** 
	 * Validate if the country is supported by News API.
	 * @author Sotirios Karageorgopoulos
	 * @param country - Selected country
	 * @return if is valid or invalid
	 */
	public boolean isValid(String country) {
		List<SupportedISOCodes> countries = Arrays.asList(SupportedISOCodes.values());
		Optional<SupportedISOCodes> supportedCountry = countries.stream()
				.filter(c -> c.getCountry().trim().equalsIgnoreCase(country.trim())).findFirst();

		if (supportedCountry.isEmpty())
			return false;
		return true;
	}
}
