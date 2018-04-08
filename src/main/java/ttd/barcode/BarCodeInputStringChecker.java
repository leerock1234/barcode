package ttd.barcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarCodeInputStringChecker {

	private static final int LONGCODESIZEWITHHYPHEN = 10;
	private static final int LONGCODESIZE = 9;
	private static final int SHORTCODESIZE = 5;
	private static final Pattern DDDDD = Pattern.compile("\\d{5}");
	private static final Pattern DDDDDDDDD = Pattern.compile("\\d{9}");
	private static final Pattern DDDDD_DDDD = Pattern.compile("\\d{5}-\\d{4}");

	String checkedStr;
	int length;
	
	public BarCodeInputStringChecker(String checkedStr){
		this.checkedStr = checkedStr;
		this.length = checkedStr.length();
	}

	public void check() {
		checkLength();
		checkPattern();
	}
	
	private void checkPattern() {
		if (length == 5 && isNotInPattern(DDDDD)) {
			throw new IllegalArgumentException("The pattern of the parameter should be 'DDDDD'. D is for a digitial.");
		}
		if (length == 9 && isNotInPattern(DDDDDDDDD)) {
			throw new IllegalArgumentException("The pattern of the parameter should be 'DDDDDDDDD'. D is for a digitial.");
		}
		if (length == 10 && isNotInPattern(DDDDD_DDDD)) {
			throw new IllegalArgumentException("The pattern of the parameter should be 'DDDDD-DDDD'. D is for a digitial.");
		}
	}

	private void checkLength() {
		if (length !=SHORTCODESIZE && length !=LONGCODESIZE && length != LONGCODESIZEWITHHYPHEN) {
			throw new IllegalArgumentException("The size of the parameter is not correct.");
		}
	}

	private boolean isNotInPattern(Pattern pattern) {
		Matcher matcher = pattern.matcher(checkedStr);
		return !matcher.find();
	}

}
