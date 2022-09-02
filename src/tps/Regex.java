package tps;

public interface Regex {
	final String ID = "^[a-zA-Z0-9]{6,12}$";
	final String PASSWORD =  "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
	final String NAME = "^[가-힣]{2,}$";
	final String PHONE = "^[0-9]{11,12}$";
	final String EMAIL = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	
}
