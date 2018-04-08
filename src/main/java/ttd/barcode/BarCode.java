package ttd.barcode;

import java.util.ArrayList;
import java.util.List;

public class BarCode {
	
	public static BarCode fromNumberStr(String numbersStr) {
		new BarCodeInputStringChecker(numbersStr).check();
		InputNumberList numbers = InputNumberList.fromStr(numbersStr);
		BarCode barCode = fromCodeNumbers(numbers);
		return barCode;
	}

	private static BarCode fromCodeNumbers(InputNumberList numbers) {
		BarCode barCode = new BarCode();
		barCode.barCodes = convertToBarCodeItems(numbers);
		return barCode;
	}

	private static List<BarCodeItem> convertToBarCodeItems(InputNumberList numbers) {
		List<BarCodeItem> items = new ArrayList<>();
		for(int barCodeNum : numbers.getBarCodeNumbers()){
			items.add(BarCodeItem.fromNumber(barCodeNum));
		}
		return items;
	}

	public static BarCode fromBarCode(String barCodeStr) {
		new BarCodeStrFormatChecker(barCodeStr).check();
		InputBarCodeList inputBarCodeList = InputBarCodeList.fromStr(barCodeStr);
		BarCode barCode = new BarCode();
		barCode.barCodes = BarCodeItem.fromCodeStrs(inputBarCodeList.getContentNumPart());
		if(!inputBarCodeList.hasCorrectCheckNumCode(barCode.calculateCheckNumCode())){
			throw new IllegalArgumentException("The check code is '"+inputBarCodeList.getCheckNumPart()+"', but should be '"+barCode.getCheckNumBarCodeItem().toBarCode()+"'.");
		}
		return barCode;
	}

	
	private String calculateCheckNumCode() {
		return getCheckNumBarCodeItem().toBarCode();
	}


	List<BarCodeItem> barCodes;

	public String toBarCode() {
		return "|"+generateFromBarCode()+generateFromCheckNum()+"|";
	}

	private String generateFromCheckNum() {
		return getCheckNumBarCodeItem().toBarCode();
	}

	private String generateFromBarCode() {
		StringBuilder sb = new StringBuilder();
		for(BarCodeItem item : barCodes){
			sb.append(item.toBarCode());
		}
		return sb.toString();
	}

	public String toPostNumber() {
		StringBuilder sb = new StringBuilder();
		for(BarCodeItem item : this.barCodes){
			sb.append(item.number);
		}
		if (isLongCode()){
			insertHyphen(sb);
		}
		return sb.toString();
	}

	private void insertHyphen(StringBuilder sb) {
		sb.insert(5, '-');
	}

	private boolean isLongCode() {
		return this.barCodes.size()>5;
	}

	private int getCheckNumber() {
		return getSum() % 10;
	}

	private int getSum() {
		int sum=0;
		for(BarCodeItem barCodeItem : barCodes){
			sum+=barCodeItem.number;
		}
		return sum;
	}

	BarCodeItem getCheckNumBarCodeItem() {
		return BarCodeItem.fromNumber(getCheckNumber());
	}
}
