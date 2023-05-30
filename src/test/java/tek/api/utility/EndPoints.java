package tek.api.utility;

public enum EndPoints {
	
	TOKEN_GENERATION("/api/token"),
	TOKEN_VERIFY("/api/token/verify"),
	GET_ALL_ACCOUNTS("/api/accounts/get-all-accounts"),
	GET_ACCOUNT("/api/accounts/get-account"),
	DELETE ("/api/accounts/delete-account"),
	GET_USER_PROFILE("/api/user/profile"),
	ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
	ADD_ACCOUNT_PHONE("/api/accounts/add-account-phone");
	
	
	private String value; 
	
	EndPoints(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
