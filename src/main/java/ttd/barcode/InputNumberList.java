package ttd.barcode;

import java.util.ArrayList;
import java.util.List;

public class InputNumberList {

	public static InputNumberList fromStr(String barCodeNumbers) {
		List<Integer> barCodeNumberList = toIntegerList(barCodeNumbers);
		InputNumberList inputBarCodeNumbers = new InputNumberList();
		inputBarCodeNumbers.barCodeNumbers = barCodeNumberList;
		return inputBarCodeNumbers;
	}

	private static List<Integer> toIntegerList(String barCodeNumbers) {
		List<Integer> barCodeNumberList = new ArrayList<>();
		char[] barCodeStrChars = barCodeNumbers.toCharArray();
		for(char barCodeStrChar : barCodeStrChars){
			if (barCodeStrChar!='-') {
				barCodeNumberList.add(Character.getNumericValue(barCodeStrChar));
			}
		}
		return barCodeNumberList;
	}

	List<Integer> barCodeNumbers = new ArrayList<>();

	private InputNumberList() {
	}

	public List<Integer> getBarCodeNumbers() {
		return this.barCodeNumbers;
	}

	
}