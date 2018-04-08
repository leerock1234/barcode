package ttd.barcode;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BarcodeFromNumberStrTest {
	
	@Test
	public void should_be_able_to_give_barcode_from_number_11111(){
		assertEquals("|:::||:::||:::||:::||:::||:|:|:|", BarCode.fromNumberStr("11111").toBarCode());
	}

	@Test
	public void should_be_able_to_give_barcode_from_number_12359(){
		assertEquals("|:::||::|:|::||::|:|:|:|::||:::|", BarCode.fromNumberStr("12359").toBarCode());
	}

	@Test
	public void should_be_able_to_give_barcode_from_number_123591234(){
		assertEquals("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|", BarCode.fromNumberStr("123591234").toBarCode());
	}

	@Test
	public void should_be_able_to_give_barcode_from_number_12359_1234(){
		assertEquals("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|", BarCode.fromNumberStr("12359-1234").toBarCode());
	}
	
	@Rule 
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void should_throw_error_if_the_size_is_incorrect(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The size of the parameter is not correct.");
		BarCode.fromNumberStr("123456");
	}

	@Test
	public void should_throw_error_if_the_pattern_is_incorrect_for_5_number(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The pattern of the parameter should be 'DDDDD'. D is for a digitial.");
		BarCode.fromNumberStr("0000-");
	}

	@Test
	public void should_throw_error_if_the_pattern_is_incorrect_for_9_number(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The pattern of the parameter should be 'DDDDDDDDD'. D is for a digitial.");
		BarCode.fromNumberStr("12345-789");
	}

	@Test
	public void should_throw_error_if_the_pattern_is_incorrect_for_10_number(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The pattern of the parameter should be 'DDDDD-DDDD'. D is for a digitial.");
		BarCode.fromNumberStr("1234-56789");
	}
}
