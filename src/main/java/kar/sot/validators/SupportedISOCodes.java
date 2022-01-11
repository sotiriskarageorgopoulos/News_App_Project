package kar.sot.validators;

public enum SupportedISOCodes {
	UNITED_ARAB_EMIRATES("United Arab Emirates", "ae"), ARGENTINA("Argentina", "ar"), AUSTRIA("Austria", "at"),
	AUSTRALIA("Australia", "au"), BELGIUM("Belgium", "be"), BULGARIA("Bulgaria", "bg"), BRAZIL("Brazil", "br"),
	CANADA("Canada", "ca"), SWITZERLAND("Switzerland", "ch"), CHINA("China", "cn"), COLOMBIA("Colombia", "co"),
	CUBA("Cuba", "cu"), CZECHIA("Czechia", "cz"), GERMANY("Germany", "de"), EGYPT("Egypt", "eg"),
	FRANCE("France", "fr"), UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND("United Kingdom", "gb"),
	GREECE("Greece", "gr"), HONG_KONG("Hong Kong", "hk"), HUNNGARY("Hungary", "hu"), INDONESIA("Indonesia", "id"),
	IRELAND("Ireland", "ie"), ISRAEL("Israel", "il"), INDIA("India", "in"), ITALY("Italy", "it"), JAPAN("Japan", "jp"),
	REPUBLIC_OF_KOREA("South Korea", "kr"), LITHUANIA("Lithuania", "lt"), LATVIA("Latvia", "lv"),
	MAROCCO("Marocco", "ma"), MEXICO("Mexico", "mx"), MALAYSIA("Malaysia", "my"), NIGERIA("Nigeria", "ng"),
	NETHERLANDS("Netherland", "nl"), NORWAY("Norway", "no"), NEW_ZEALAND("New Zealand", "nz"),
	PHILIPPINES("Philippines", "ph"), POLAND("Poland", "pl"), PORTUGAL("Portugal", "pt"), ROMANIA("Romania", "ro"),
	RUSSIAN_FEDERATION("Russia", "ru"), SAUDI_ARABIA("Saudi Arabia", "sa"), SWEDEN("Sweden", "se"),
	SINGAPORE("Singapore", "sg"), SLOVENIA("Slovenia", "si"), SLOVAKIA("Slovakia", "sk"), THAILAND("Thailand", "th"),
	TURKEY("Turkey", "tr"), TAIWAN("Taiwan", "tw"), UKRAINE("Ukraine", "ua"),
	UNITED_STATES_OF_AMERICA("United States", "us"), VENEZUELA("Venezuela", "ve"), SOUTH_AFRICA("South Africa", "za");

	private String country;
	private String countryCode;

	SupportedISOCodes(String country, String countryCode) {
		this.country = country;
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
