package servicesubscriber2;

import datatransferrateprovider.DataRateService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import lengthprovider.Length;
import massprovider.Mass;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import temperatureprovider.Temperature;
import java.util.Scanner;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference TemperatureReference;
	private ServiceReference LengthReference;
	private ServiceReference MassReference;
	private ServiceReference DTRReference;
	private Scanner input = new Scanner(System.in);

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		System.out.println("Start Subscriber Service");

		TemperatureReference = context.getServiceReference(Temperature.class.getName());
		Temperature temperature = (Temperature) context.getService(TemperatureReference);

		LengthReference = context.getServiceReference(Length.class.getName());
		Length length = (Length) context.getService(LengthReference);

		MassReference = context.getServiceReference(Mass.class.getName());
		Mass mass = (Mass) context.getService(MassReference);

		DTRReference = context.getServiceReference(DataRateService.class.getName());
		DataRateService dtr = (DataRateService) context.getService(DTRReference);

		try {

			while (true) {

				System.out.println("\n\n");
				System.out.println("-----------------Mulitple Unit Converter-----------------");
				System.out.println("\n");
				System.out.println("Select The Conversion Type");
				System.out.println("1 - Data Rate Conversions");
				System.out.println("2 - Length Conversions");
				System.out.println("3 - Temperature Rate Conversions");
				System.out.println("4 - Mass Conversions");
				System.out.println("0 - Exit");
				System.out.println("\n");

				int selectedOption = 0;

				do {

					System.out.print("Select Option: ");
					selectedOption = input.nextInt();

					if (selectedOption < 0 && selectedOption > 4) {
						System.out.println("Invalid Option.Please Try Again");
					}

				} while (selectedOption < 0 && selectedOption > 4);

				if (selectedOption == 0) {
					System.out.println("Exiting");
					break;
				} else if (selectedOption == 1) {

					String amountString = "";

					do {
						System.out.println("\n");
						System.out.print("Enter Amount To Be Converted: ");
						amountString = input.nextLine();

					} while (Methods.isDouble(amountString) == false);

					double conversionAmount = Double.parseDouble(amountString);

					while (true) {

						System.out.println("1.KbPsToMbPs");
						System.out.println("2.MbPsToKbPs");
						System.out.println("3.MbPsToGbPs");
						System.out.println("4.GbPsToMbPs");
						System.out.println("5.KbPsToGbPs");
						System.out.println("6.GbPsToKbPs");
						System.out.println("0.Back");
						System.out.println("\n");

						String secondOption = "";

						do {
							System.out.print("Select Your Option: ");
							secondOption = input.nextLine();
						} while (Methods.isInt(secondOption) == false);

						int secondOptionInt = Integer.parseInt(secondOption);

						if (secondOptionInt == 1) {
							System.out.println("\n");
							System.out.println(conversionAmount + " KbPs=" + dtr.KbPsToMbPs(conversionAmount) + "MbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 2) {
							System.out.println("\n");
							System.out.println(conversionAmount + " MbPs=" + dtr.MbPsToKbPs(conversionAmount) + "KbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 3) {
							System.out.println("\n");
							System.out.println(conversionAmount + " MbPs=" + dtr.MbPsToGbPs(conversionAmount) + "GbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 4) {
							System.out.println("\n");
							System.out.println(conversionAmount + " GbPs=" + dtr.GbPsToMbPs(conversionAmount) + "MbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 5) {
							System.out.println("\n");
							System.out.println(conversionAmount + " KbPs=" + dtr.KbPsToGbPs(conversionAmount) + "GbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 6) {
							System.out.println("\n");
							System.out.println(conversionAmount + " GbPs=" + dtr.GbPsToKbPs(conversionAmount) + "KbPs");
							System.out.println("\n");
						} else if (secondOptionInt == 0) {
							break;
						}

					}

				} else if (selectedOption == 2) {

					String amountString = "";

					do {
						System.out.println("\n");
						System.out.print("Enter Amount To Be Converted: ");
						amountString = input.nextLine();

					} while (Methods.isDouble(amountString) == false);

					double conversionAmount = Double.parseDouble(amountString);

					while (true) {
						System.out.println("\n");
						System.out.println("1 - Kilometre (Km) --> Miles");
						System.out.println("2 - Miles --> Kilometre(Km)");
						System.out.println("3 - Metre (m) --> Feet (f)");
						System.out.println("4 - Feet --> Metre (m)");
						System.out.println("5 - Centimetre (Cm) --> Inches");
						System.out.println("6 - Inches --> CentiMetre");
						System.out.println("7 - Yards --> Metre");
						System.out.println("8 - Metre --> Yards");
						System.out.println("9 - Yards --> Kilometre");
						System.out.println("10 - Kilometre --> Yards");
						System.out.println("11 - Yard --> Miles");
						System.out.println("12 - Miles --> Yards");
						System.out.println("0 - Exit");
						System.out.println("\n");

						String secondOption = "";

						do {
							System.out.print("Select Your Option: ");
							secondOption = input.nextLine();
						} while (Methods.isInt(secondOption) == false);

						int secondOptionInt = Integer.parseInt(secondOption);

						if (secondOptionInt == 1) {
							System.out.println();
							System.out.println(
									"" + conversionAmount + "Km  --> " + length.KMtoMiles(conversionAmount) + " miles");
							System.out.println();
						} else if (secondOptionInt == 2) {
							System.out.println();
							System.out.println(
									"" + conversionAmount + "Miles  --> " + length.MilestoKM(conversionAmount) + " Km");
							System.out.println();
						} else if (secondOptionInt == 3) {
							System.out.println();
							System.out.println("" + conversionAmount + "Metre  --> "
									+ length.MetertoFeet(conversionAmount) + " Feet");
							System.out.println();
						} else if (secondOptionInt == 4) {
							System.out.println();
							System.out.println("" + conversionAmount + "Feet  --> "
									+ length.FeettoMeter(conversionAmount) + " Metre");
							System.out.println();
						} else if (secondOptionInt == 5) {
							System.out.println();
							System.out.println("" + conversionAmount + "Cm  --> " + length.CMtoInches(conversionAmount)
									+ " Inches");
							System.out.println();
						} else if (secondOptionInt == 6) {
							System.out.println();
							System.out.println("" + conversionAmount + "Inches  --> "
									+ length.InchestoCM(conversionAmount) + " cm");
							System.out.println();
						} else if (secondOptionInt == 7) {
							System.out.println();
							System.out.println("" + conversionAmount + "yards  --> "
									+ length.YardstoMeters(conversionAmount) + " m");
							System.out.println();
						} else if (secondOptionInt == 8) {
							System.out.println();
							System.out.println("" + conversionAmount + "metre  --> "
									+ length.YardstoMeters(conversionAmount) + " yards");
							System.out.println();
						} else if (secondOptionInt == 9) {
							System.out.println();
							System.out.println("" + conversionAmount + "yards  --> "
									+ length.YardstoKM(conversionAmount) + "KiloMeter");
							System.out.println();
						} else if (secondOptionInt == 10) {
							System.out.println();
							System.out.println(
									"" + conversionAmount + "km  --> " + length.KMtoYards(conversionAmount) + "Yards");
							System.out.println();
						} else if (secondOptionInt == 11) {
							System.out.println();
							System.out.println("" + conversionAmount + "yards  --> "
									+ length.YardstoMiles(conversionAmount) + "miles");
							System.out.println();
						} else if (secondOptionInt == 12) {
							System.out.println();
							System.out.println("" + conversionAmount + "Miles  --> "
									+ length.MilestoYards(conversionAmount) + "Yards");
							System.out.println();
						} else if (secondOptionInt == 0) {
							break;
						}
					}

				} else if (selectedOption == 3) {

					String amountString = "";

					do {
						System.out.println("\n");
						System.out.print("Enter Amount To Be Converted: ");
						amountString = input.nextLine();

					} while (Methods.isDouble(amountString) == false);

					double conversionAmount = Double.parseDouble(amountString);

					while (true) {

						System.out.println("\n");
						System.out.println("1.Celsius to Fahrenheit");
						System.out.println("2.Fahrenheit to Celsius");
						System.out.println("3.Celsius to Kelvin");
						System.out.println("4.Kelvin to Celsius");
						System.out.println("5.Kelvin to Fahrenheit");
						System.out.println("6.Fahrenheit to Kelvin");
						System.out.println("0.Back");
						System.out.println("\n");

						String secondOption = "";

						do {
							System.out.print("Select Your Option: ");
							secondOption = input.nextLine();
						} while (Methods.isInt(secondOption) == false);

						int secondOptionInt = Integer.parseInt(secondOption);

						if (secondOptionInt == 0) {
							break;
						} else if (secondOptionInt == 1) {
							System.out.println("");
							System.out.println(conversionAmount + " Celsius is "
									+ temperature.CelsiusToFahrenheit(conversionAmount) + " Fahrenheits");
							System.out.println("");
						} else if (secondOptionInt == 2) {
							System.out.println("");
							System.out.println(conversionAmount + " Fahrenheit is "
									+ temperature.FahrenheitToCelsius(conversionAmount) + " Celsius");
							System.out.println("");
						} else if (secondOptionInt == 3) {
							System.out.println("");
							System.out.println(conversionAmount + " Celsius is "
									+ temperature.CelsiusToKelvin(conversionAmount) + " Kelvin");
							System.out.println("");
						} else if (secondOptionInt == 4) {
							System.out.println("");
							System.out.println(conversionAmount + " Kelvin is "
									+ temperature.KelvinToCelsius(conversionAmount) + " Celsius");
							System.out.println("");
						} else if (secondOptionInt == 5) {
							System.out.println("");
							System.out.println(conversionAmount + " Kelvin is "
									+ temperature.KelvinToFahrenheit(conversionAmount) + " Fahrenheits");
							System.out.println("");
						} else if (secondOptionInt == 6) {
							System.out.println("");
							System.out.println(conversionAmount + " Fahrenheit is "
									+ temperature.FahrenheitToKelvin(conversionAmount) + " Kelvins");
							System.out.println("");
						}

					}
				} else if (selectedOption == 4) {
					String amountString = "";

					do {
						System.out.println("\n");
						System.out.print("Enter Amount To Be Converted: ");
						amountString = input.nextLine();
					} while (Methods.isDouble(amountString) == false);

					double conversionAmount = Double.parseDouble(amountString);

					while (true) {

						System.out.println("\n\n");
						System.out.println("----------------------------- ");
						System.out.println("--- Mass Convertion Page ---- ");
						System.out.println("\n");
						System.out.println("11 - Milligrams to Grams");
						System.out.println("12 - Milligrams to KiloGrams");
						System.out.println("13 - Milligrams to Ton");
						System.out.println("14 - Milligrams to Pounds");
						System.out.println("15 - Milligrams to Ounces");
						System.out.println("------------------------------");
						System.out.println("21 - Grams to Milligrams");
						System.out.println("22 - Grams to Kilograms");
						System.out.println("23 - Grams to Ton");
						System.out.println("24 - Grams to Pounds");
						System.out.println("25 - Grams to Ouncess");
						System.out.println("------------------------------");
						System.out.println("31 - Kilograms to Milligrams");
						System.out.println("32 - Kilograms to Grams");
						System.out.println("33 - Kilograms to Ton");
						System.out.println("34 - Kilograms to Pounds");
						System.out.println("35 - Kilograms to Ounces");
						System.out.println("------------------------------");
						System.out.println("41 - Ton to Milligrams");
						System.out.println("42 - Ton to Grams");
						System.out.println("43 - Ton to Kilograms");
						System.out.println("44 - Ton to Pounds");
						System.out.println("45 - Ton to Ounces");
						System.out.println("------------------------------");
						System.out.println("51 - Pounds to Milligrams");
						System.out.println("52 - Pounds to Grams");
						System.out.println("53 - Pounds to Kilograms");
						System.out.println("54 - Pounds to Ton");
						System.out.println("55 - Pounds to Ounces");
						System.out.println("------------------------------");
						System.out.println("61 - Ounces to Milligrams");
						System.out.println("62 - Ounces to Grams");
						System.out.println("63 - Ounces to Kilograms");
						System.out.println("64 - Ounces to Ton");
						System.out.println("65 - Ounces to Pounds");
						System.out.println("------------------------------");
						System.out.println("0 - Back");
						System.out.println("------------------------------");
						System.out.println("\n");

						String secondOption = "";

						do {
							System.out.print("Select Your Option: ");
							secondOption = input.nextLine();
						} while (Methods.isInt(secondOption) == false);

						int secondOptionInt = Integer.parseInt(secondOption);

						if (secondOptionInt == 0) {
							break;
						}

						else if (secondOptionInt == 11) {
							System.out.println(conversionAmount + " mg is equal to --> "
									+ mass.miligramsToGrams(conversionAmount) + " g");
						}

						else if (secondOptionInt == 12) {
							System.out.println(conversionAmount + " mg is equal to --> "
									+ mass.miligramsToKilograms(conversionAmount) + " kg");
						}

						else if (secondOptionInt == 13) {
							System.out.println(conversionAmount + " mg is equal to --> "
									+ mass.miligramsToTon(conversionAmount) + " t");
						}

						else if (secondOptionInt == 14) {
							System.out.println(conversionAmount + " mg is equal to --> "
									+ mass.miligramsToPounds(conversionAmount) + " lb");
						}

						else if (secondOptionInt == 15) {
							System.out.println(conversionAmount + " mg is equal to --> "
									+ mass.miligramsToOunces(conversionAmount) + " Ounce");
						}

						// ----------------------------------------------------------------------------------------------------------------------------

						else if (secondOptionInt == 21) {
							System.out.println(conversionAmount + " g is equal to --> "
									+ mass.gramsToMiligrams(conversionAmount) + " mg");
						}

						else if (secondOptionInt == 22) {
							System.out.println(conversionAmount + " g is equal to --> "
									+ mass.gramsToKilograms(conversionAmount) + " kg");
						}

						else if (secondOptionInt == 23) {
							System.out.println(conversionAmount + " g is equal to --> "
									+ mass.gramsToTon(conversionAmount) + " t");
						}

						else if (secondOptionInt == 24) {
							System.out.println(conversionAmount + " g is equal to --> "
									+ mass.gramsToPounds(conversionAmount) + " lb");
						}

						else if (secondOptionInt == 25) {
							System.out.println(conversionAmount + " g is equal to --> "
									+ mass.gramsToOunces(conversionAmount) + " ounce");
						}

						// -----------------------------------------------------------------------------------------------------------------------------

						else if (secondOptionInt == 31) {
							System.out.println(conversionAmount + " kg is equal to --> "
									+ mass.kilogramsToMiligrams(conversionAmount) + " mg");
						}

						else if (secondOptionInt == 32) {
							System.out.println(conversionAmount + " kg is equal to --> "
									+ mass.kilogramsToGrams(conversionAmount) + " g");
						}

						else if (secondOptionInt == 33) {
							System.out.println(conversionAmount + " kg is equal to --> "
									+ mass.kilogramsToTon(conversionAmount) + " t");
						}

						else if (secondOptionInt == 34) {
							System.out.println(conversionAmount + " kg is equal to --> "
									+ mass.kilogramsToPounds(conversionAmount) + " lb");
						}

						else if (secondOptionInt == 35) {
							System.out.println(conversionAmount + " kg is equal to --> "
									+ mass.kilogramsToOunces(conversionAmount) + " ounce");
						}

						// -------------------------------------------------------------------------------------------------------------------------------

						else if (secondOptionInt == 41) {
							System.out.println(conversionAmount + " t is equal to --> "
									+ mass.tonToMiligrams(conversionAmount) + " mg");
						}

						else if (secondOptionInt == 42) {
							System.out.println(conversionAmount + " t is equal to --> "
									+ mass.tonToGrams(conversionAmount) + " g");
						}

						else if (secondOptionInt == 43) {
							System.out.println(conversionAmount + " t is equal to --> "
									+ mass.tonToKilograms(conversionAmount) + " kg");
						}

						else if (secondOptionInt == 44) {
							System.out.println(conversionAmount + " t is equal to --> "
									+ mass.tonToPounds(conversionAmount) + " lb");
						}

						else if (secondOptionInt == 45) {
							System.out.println(conversionAmount + " t is equal to --> "
									+ mass.tonToOunces(conversionAmount) + " ounce");
						}

						// --------------------------------------------------------------------------------------------------------------------------------

						else if (secondOptionInt == 51) {
							System.out.println(conversionAmount + " lb is equal to --> "
									+ mass.poundsToMiligrams(conversionAmount) + " mg");
						}

						else if (secondOptionInt == 52) {
							System.out.println(conversionAmount + " lb is equal to --> "
									+ mass.poundsToGrams(conversionAmount) + " g");
						}

						else if (secondOptionInt == 53) {
							System.out.println(conversionAmount + " lb is equal to --> "
									+ mass.poundsToKilograms(conversionAmount) + " kg");
						}

						else if (secondOptionInt == 54) {
							System.out.println(conversionAmount + " lb is equal to --> "
									+ mass.poundsToTon(conversionAmount) + " t");
						}

						else if (secondOptionInt == 55) {
							System.out.println(conversionAmount + " lb is equal to --> "
									+ mass.poundsToOunces(conversionAmount) + " ounce");
						}

						// ---------------------------------------------------------------------------------------------------------------------------------

						else if (secondOptionInt == 61) {
							System.out.println(conversionAmount + " ounce is equal to --> "
									+ mass.ouncesToMiligrams(conversionAmount) + " mg");
						}

						else if (secondOptionInt == 62) {
							System.out.println(conversionAmount + " ounce is equal to --> "
									+ mass.ouncesToGrams(conversionAmount) + " g");
						}

						else if (secondOptionInt == 63) {
							System.out.println(conversionAmount + " ounce is equal to --> "
									+ mass.ouncesToKilograms(conversionAmount) + " kg");
						}

						else if (secondOptionInt == 64) {
							System.out.println(conversionAmount + " ounce is equal to --> "
									+ mass.ouncesToTon(conversionAmount) + " t");
						}

						else if (secondOptionInt == 65) {
							System.out.println(conversionAmount + " ounce is equal to --> "
									+ mass.ouncesToPounds(conversionAmount) + " lb");
						}

						// --------------------------------------------------------------------------------------------------------------------------------

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
