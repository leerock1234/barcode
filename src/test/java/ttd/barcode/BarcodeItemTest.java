package ttd.barcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BarcodeItemTest {
	
	@Test
	public void should_get_barcodeitem_by_number(){
		for(int i=0;i<10;i++){
			BarCodeItem expectedItem = getExpectedBarCodeItem(i);
			assertEquals("can not convert "+i, expectedItem, BarCodeItem.fromNumber(i));
		}
	}


	private BarCodeItem getExpectedBarCodeItem(Integer barCodeNumberStr) {
		BarCodeItem item = new BarCodeItem();
		item.number = barCodeNumberStr;
		if (barCodeNumberStr.equals(1)){
			item.code = ":::||";
		}
		else if (barCodeNumberStr.equals(2)){
			item.code = "::|:|";
		}
		else if (barCodeNumberStr.equals(3)){
			item.code = "::||:";
		}
		else if (barCodeNumberStr.equals(4)){
			item.code = ":|::|";
		}
		else if (barCodeNumberStr.equals(5)){
			item.code = ":|:|:";
		}
		else if (barCodeNumberStr.equals(6)){
			item.code = ":||::";
		}
		else if (barCodeNumberStr.equals(7)){
			item.code = "|:::|";
		}
		else if (barCodeNumberStr.equals(8)){
			item.code = "|::|:";
		}
		else if (barCodeNumberStr.equals(9)){
			item.code = "|:|::";
		}
		else if (barCodeNumberStr.equals(0)){
			item.code = "||:::";
		}
		return item;
	}

}
