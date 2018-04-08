package ttd.barcode;

import java.util.ArrayList;
import java.util.List;

public class InputBarCodeList {
	
	String[] contentPart;
	String checkNumPart;
	String[] fullList;

	public static InputBarCodeList fromStr(String barCodeStr) {
		InputBarCodeList result = new InputBarCodeList();
		List<String> splitStrings = splitBarCodeStr(barCodeStr);
		result.contentPart = getListWithoutLastOne(splitStrings);
		result.checkNumPart = getLastItemInList(splitStrings);
		result.fullList = splitStrings.toArray(new String[]{});
		return result;
	}

	private static String[] getListWithoutLastOne(List<String> splitStrings) {
		String[] result = new String[splitStrings.size()-1];
		for(int i=0;i<splitStrings.size()-1;i++){
			result[i] = splitStrings.get(i);
		}
		return result;
	}

	private static String getLastItemInList(List<String> splitStrings) {
		return splitStrings.get(splitStrings.size()-1);
	}

	private static List<String> splitBarCodeStr(String barCodeStr) {
		String barCodeStrWithoutFirstAndLastChar = removeFirstAndLastChar(barCodeStr);
		return splitWith5CharsEach(barCodeStrWithoutFirstAndLastChar);
	}

	private static List<String> splitWith5CharsEach(String barCodeStr) {
		List<String> result = new ArrayList<>();
		int i = 0;
		int length = barCodeStr.length();
		while(i<length){
			int j=(i+5>length)?length:i+5;
			result.add(barCodeStr.substring(i,j));
			i=j;
		}
		return result;
	}

	private static String removeFirstAndLastChar(String barCodeStr) {
		return barCodeStr.substring(1, barCodeStr.length()-1);
	}

	String getCheckNumPart() {
		return checkNumPart;
	}

	String[] getContentNumPart() {
		return contentPart;
	}

	String[] getFullList() {
		return fullList;
	}

	public boolean hasCorrectCheckNumCode(String correctCheckNumCode) {
		return this.getCheckNumPart().equals(correctCheckNumCode);
	}
}
