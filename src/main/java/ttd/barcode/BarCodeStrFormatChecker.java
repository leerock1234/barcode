package ttd.barcode;

import java.util.regex.Pattern;

public class BarCodeStrFormatChecker {
	
	private static final int LONGCODESIZE = 52;
	private static final int SHORTCODESIZE = 32;
	String barCodeStr;
	int length;

	public BarCodeStrFormatChecker(String barCodeStr) {
		this.barCodeStr = barCodeStr;
		this.length = barCodeStr.length();
	}

	public void check() {
		if (length!=SHORTCODESIZE && length!=LONGCODESIZE){
			throw new IllegalArgumentException("The size of the parameter is not correct.");
		}
		if (!endWithBar()){
			throw new IllegalArgumentException("It should end with bar(|).");
		}
		if (!startWithBar()){
			throw new IllegalArgumentException("It should start with bar(|).");
		}
		if (containsSpecialChars()){
			throw new IllegalArgumentException("It should only contain bar(|) or comma(:).");
		}
		checkIfCanBeConvertToBarCode();
	}
	
	private void checkIfCanBeConvertToBarCode() {
		InputBarCodeList inputBarCodeList = InputBarCodeList.fromStr(barCodeStr);
		for(String barCodeStr: inputBarCodeList.getFullList()){
			if(theBarCodeIsNotValid(barCodeStr)){
				throw new IllegalArgumentException("The bar code of '"+barCodeStr+"' is illegal.");
			}
		}
	}

	private boolean theBarCodeIsNotValid(String barCodeStr) {
		return !BarCodeItem.BARCODEITEMMAP.containsKey(barCodeStr);
	}

	static final Pattern patternContainsSpecialChars = Pattern.compile("[^:|]");

	private boolean containsSpecialChars() {
		return patternContainsSpecialChars.matcher(barCodeStr).find();
	}

	private boolean startWithBar() {
		return barCodeStr.startsWith("|");
	}

	private boolean endWithBar() {
		return barCodeStr.endsWith("|");
	}

}
