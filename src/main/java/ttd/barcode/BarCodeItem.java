package ttd.barcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarCodeItem {
	private static final BarCodeItem BARCODEITEM0 = buildBarCodeItem(0,"||:::");
	private static final BarCodeItem BARCODEITEM1 = buildBarCodeItem(1,":::||");
	private static final BarCodeItem BARCODEITEM2 = buildBarCodeItem(2,"::|:|");
	private static final BarCodeItem BARCODEITEM3 = buildBarCodeItem(3,"::||:");
	private static final BarCodeItem BARCODEITEM4 = buildBarCodeItem(4,":|::|");
	private static final BarCodeItem BARCODEITEM5 = buildBarCodeItem(5,":|:|:");
	private static final BarCodeItem BARCODEITEM6 = buildBarCodeItem(6,":||::");
	private static final BarCodeItem BARCODEITEM7 = buildBarCodeItem(7,"|:::|");
	private static final BarCodeItem BARCODEITEM8 = buildBarCodeItem(8,"|::|:");
	private static final BarCodeItem BARCODEITEM9 = buildBarCodeItem(9,"|:|::");

	private static final List<BarCodeItem> BARCODEITEMLIST = new ArrayList<>();
	static {
		BARCODEITEMLIST.add(BARCODEITEM0);
		BARCODEITEMLIST.add(BARCODEITEM1);
		BARCODEITEMLIST.add(BARCODEITEM2);
		BARCODEITEMLIST.add(BARCODEITEM3);
		BARCODEITEMLIST.add(BARCODEITEM4);
		BARCODEITEMLIST.add(BARCODEITEM5);
		BARCODEITEMLIST.add(BARCODEITEM6);
		BARCODEITEMLIST.add(BARCODEITEM7);
		BARCODEITEMLIST.add(BARCODEITEM8);
		BARCODEITEMLIST.add(BARCODEITEM9);
	}
	
	static final Map<String, BarCodeItem> BARCODEITEMMAP = new HashMap<>();
	static {
		BARCODEITEMMAP.put(BARCODEITEM0.code, BARCODEITEM0);
		BARCODEITEMMAP.put(BARCODEITEM1.code, BARCODEITEM1);
		BARCODEITEMMAP.put(BARCODEITEM2.code, BARCODEITEM2);
		BARCODEITEMMAP.put(BARCODEITEM3.code, BARCODEITEM3);
		BARCODEITEMMAP.put(BARCODEITEM4.code, BARCODEITEM4);
		BARCODEITEMMAP.put(BARCODEITEM5.code, BARCODEITEM5);
		BARCODEITEMMAP.put(BARCODEITEM6.code, BARCODEITEM6);
		BARCODEITEMMAP.put(BARCODEITEM7.code, BARCODEITEM7);
		BARCODEITEMMAP.put(BARCODEITEM8.code, BARCODEITEM8);
		BARCODEITEMMAP.put(BARCODEITEM9.code, BARCODEITEM9);
	}

	int number;
	String code;
	
	public static BarCodeItem fromNumber(int barCodeItemNum) {
		return BARCODEITEMLIST.get(barCodeItemNum);
	}
	
	private static BarCodeItem buildBarCodeItem(int number, String code) {
		BarCodeItem item = new BarCodeItem();
		item.code = code;
		item.number = number;
		return item;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarCodeItem other = (BarCodeItem) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	public String toBarCode() {
		return code;
	}

	private static BarCodeItem fromCodeStr(String barCodeStr) {
		return BARCODEITEMMAP.get(barCodeStr);
	}

	static List<BarCodeItem> fromCodeStrs(String[] barCodeStrs) {
		List<BarCodeItem> result = new ArrayList<>();
		for(String barCodeStr : barCodeStrs){
			result.add(fromCodeStr(barCodeStr));
		}
		return result;
	}

}
