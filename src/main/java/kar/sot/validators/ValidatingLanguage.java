package kar.sot.validators;

import java.util.Arrays;
import java.util.Optional;
import kar.sot.util.interfaces.ValidatingInterface;
import java.util.List;

public class ValidatingLanguage implements ValidatingInterface<String> {
	
	/** 
	 * Validate if the language is supported by News API.
	 * @author Sotirios Karageorgopoulos
	 * @param language - Selected language
	 * @return if is valid or invalid
	 */
	public boolean isValid(String language) {
		List<SupportedISOLanguages> langs = Arrays.asList(SupportedISOLanguages.values());

		Optional<SupportedISOLanguages> lang = langs.stream()
				.filter(l -> l.getLanguage().equalsIgnoreCase(language.trim())).findFirst();

		if (lang.isEmpty())
			return false;

		return true;
	}
}
