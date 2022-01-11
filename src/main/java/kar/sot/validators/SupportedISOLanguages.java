package kar.sot.validators;

public enum SupportedISOLanguages {
	ARABIC("arabic", "ar"), GERMAN("german", "de"), ENGLISH("english", "en"), SPANISH("spanish", "es"),
	FRENCH("french", "fr"), HEBREW("hebrew", "he"), ITALIAN("italian", "it"), DUTCH("dutch", "nl"),
	NORWEGIAN("norwegian", "no"), PORTUGUESE("portuguese", "pt"), RUSSIAN("russian", "ru"),
	NORTHERN_SAMI("nothern sami", "se"), UD("ud", "ud"), CHINESE("chinese", "zh");

	private String language;
	private String isoCode;

	SupportedISOLanguages(String language, String isoCode) {
		this.language = language;
		this.isoCode = isoCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

}
