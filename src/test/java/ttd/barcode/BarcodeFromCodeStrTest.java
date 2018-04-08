package ttd.barcode;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BarcodeFromCodeStrTest {
	
	@Test
	public void should_be_able_to_give_barcode_of_11111(){
		assertEquals("11111", BarCode.fromBarCode("|:::||:::||:::||:::||:::||:|:|:|").toPostNumber());
	}

	@Test
	public void should_be_able_to_give_barcode_of_12359(){
		assertEquals("12359", BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|::||:::|").toPostNumber());
	}

	@Test
	public void should_be_able_to_give_barcode_from_number_123591234(){
		assertEquals("12359-1234", BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|").toPostNumber());
	}

	@Rule 
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void should_throw_error_if_the_size_is_incorrect(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The size of the parameter is not correct.");
		BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||::::|");
	}

	@Test
	public void should_throw_error_if_it_is_not_ended_with_bar(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("It should end with bar(|).");
		BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||::::");
	}

	@Test
	public void should_throw_error_if_it_is_not_start_with_bar(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("It should start with bar(|).");
		BarCode.fromBarCode("::::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|");
	}

	@Test
	public void should_throw_error_if_it_contains_special_chars(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("It should only contain bar(|) or comma(:).");
		BarCode.fromBarCode("|a::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|");
	}

	@Test
	public void should_throw_error_if_it_is_not_valid_bar_code(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The bar code of '|::||' is illegal.");
		BarCode.fromBarCode("||::||::|:|::||::|:|:|:|:::::||::|:|::||::|::|||:::|");
	}

	@Test
	public void should_throw_error_if_it_is_not_valid_bar_code_verify_in_check_number_part(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The bar code of '|::::' is illegal.");
		BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::||::::|");
	}

	@Test
	public void should_throw_error_if_the_check_code_is_incorrect(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The check code is '|:::|', but should be '||:::'.");
		BarCode.fromBarCode("|:::||::|:|::||::|:|:|:|:::::||::|:|::||::|::||:::||");
	}

}
