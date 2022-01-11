package kar.sot.validators;

import java.util.List;
import java.util.Optional;

import kar.sot.util.interfaces.ValidatingInterface;

import java.util.Arrays;

public class ValidatingNewsCategory implements ValidatingInterface<String> {

	/** 
	 * Validate if the category is supported by News API.
	 * @author Sotirios Karageorgopoulos
	 * @param category - Selected category
	 * @return if is valid or invalid
	 */
	public boolean isValid(String category) {
		List<SupportedNewsCategories> categories = Arrays.asList(SupportedNewsCategories.values());

		Optional<SupportedNewsCategories> newsCategory = categories.stream()
				.filter(c -> c.getCategory().trim().equals(category.trim().toLowerCase())).findFirst();

		if (newsCategory.isEmpty())
			return false;

		return true;
	}
}
