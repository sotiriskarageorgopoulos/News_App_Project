package kar.sot.validators;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import kar.sot.util.interfaces.ValidatingInterface;

public class ValidatingISOCountryCodes implements ValidatingInterface<String> {

	/** 
	 * Validate if the ISO code is supported by News API.
	 * @author Sotirios Karageorgopoulos
	 * @param code - Selected ISO Code
	 * @return if is valid or invalid
	 */
	public boolean isValid(String code) {
		List<SupportedISOCodes> codes = Arrays.asList(SupportedISOCodes.values());

		Optional<SupportedISOCodes> countryCode = codes.stream()
				.filter(c -> c.getCountryCode().trim().equalsIgnoreCase(code.trim())).findFirst();

		if (countryCode.isEmpty())
			return false;

		return true;
	}
}
