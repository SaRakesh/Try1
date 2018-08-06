package sessionproject.com.structs2.action.login;

public interface Validator {

	String validCharacter = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890!@#$%^&*";
	public static boolean validatePassword(StringBuffer password) {
		boolean result = false;
		for(int i=0; i<password.length(); i++){
			if(validCharacter.indexOf(password.charAt(i)) == -1)
				break;
			if(i == password.length() -1)
				result = true;
		}
		return result;
	}

}
