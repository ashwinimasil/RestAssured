package assertions;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
@Test

public class GenerateDynamicValues {
	public void generateDynamicValues() {
		Faker fake = new Faker();
		String fullName = fake.name().fullName();
		String emailAddress = fake.internet().emailAddress();
		System.out.println(fullName+"\n"+ emailAddress);
		
	}

}
