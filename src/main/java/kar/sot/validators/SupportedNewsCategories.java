package kar.sot.validators;

public enum SupportedNewsCategories {
	BUSINESS("business"), ENTERTAINMENT("entertainment"), HEALTH("health"), SCIENCE("science"), SPORTS("sports"),
	TECNOLOGY("tecnology"), GENERAL("general");

	private String category;

	SupportedNewsCategories(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
