package servicesubscriber1;

public class Methods {

	public static boolean isDouble(String amount) {

		try {
			double amountInDoble = Double.parseDouble(amount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isInt(String amount) {

		try {
			int amountInInt = Integer.parseInt(amount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
