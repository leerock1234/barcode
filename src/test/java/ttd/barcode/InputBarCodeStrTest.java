package ttd.barcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class InputBarCodeStrTest {
	
	@Test
	public void should_return_barcode_number_one_by_one(){
		InputNumberList inputBarCodeStr = InputNumberList.fromStr("12345");
		List<Integer> barCodeNums = inputBarCodeStr.getBarCodeNumbers(); 
		assertEquals(1, barCodeNums.get(0).intValue());
		assertEquals(2, barCodeNums.get(1).intValue());
		assertEquals(3, barCodeNums.get(2).intValue());
		assertEquals(4, barCodeNums.get(3).intValue());
		assertEquals(5, barCodeNums.get(4).intValue());
		
	}
	

}
