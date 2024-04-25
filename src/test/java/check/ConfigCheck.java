package check;

import utils.ConfigReader;

public class ConfigCheck {

	public static void main(String[] args) {
		String text = ConfigReader.getTextValue( "firefoxBin");
		System.out.println(text);
	}

}
