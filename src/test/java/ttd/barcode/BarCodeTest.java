package ttd.barcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BarCodeTest {
	
	@Test
	public void should_be_able_to_calculate_check_num_for_11112(){
		assertEquals(BarCodeItem.fromNumber(6), BarCode.fromNumberStr("11112").getCheckNumBarCodeItem());
	}

	@Test
	public void should_be_able_to_calculate_check_num_for_95713(){
		assertEquals(BarCodeItem.fromNumber(5), BarCode.fromNumberStr("95713").getCheckNumBarCodeItem());
	}

}
