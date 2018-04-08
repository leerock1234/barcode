package ttd.barcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InputBarCodeListTest {
	
	@Test
	public void should_split_code_str_to_list(){
		InputBarCodeList inputBarCodeList = InputBarCodeList.fromStr("|:::||::|:|::||::|:|:|:|::||:::|");
		assertEquals(":::||", inputBarCodeList.getContentNumPart()[0]);
		assertEquals("::|:|", inputBarCodeList.getContentNumPart()[1]);
		assertEquals("::||:", inputBarCodeList.getContentNumPart()[2]);
		assertEquals(":|:|:", inputBarCodeList.getContentNumPart()[3]);
		assertEquals("|:|::", inputBarCodeList.getContentNumPart()[4]);
		assertEquals("||:::", inputBarCodeList.getCheckNumPart());
	}

}
