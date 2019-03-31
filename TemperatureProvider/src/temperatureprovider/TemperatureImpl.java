package temperatureprovider;

public class TemperatureImpl implements Temperature{

	@Override
	public double CelsiusToFahrenheit(double amount) {
		return amount * (9.0 / 5.0) + 32.0;
	}

	@Override
	public double FahrenheitToCelsius(double amount) {
		return ((amount - 32.0) * 5.0) / 9.0;
	}

	@Override
	public double CelsiusToKelvin(double amount) {
		return (amount + 237.15);
	}

	@Override
	public double KelvinToCelsius(double amount) {
		return (amount - 237.15);
	}

	@Override
	public double KelvinToFahrenheit(double amount) {
		//Convert the kelvin amount to celsius
		double celsius = KelvinToCelsius(amount);
		
		//convert the celsius amount to fahrenheit
		return CelsiusToFahrenheit(celsius);
	}

	@Override
	public double FahrenheitToKelvin(double amount) {
		return 273.15 + ((amount - 32.0) * (5.0/9.0));
	}


}
