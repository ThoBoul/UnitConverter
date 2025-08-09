package metricConversion;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame {
	
	// Length units
	private String[] lengthUnits = { "Meter", "Kilometer", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch" };
	private String[] temperatureUnits = { "Celsius", "Fahrenheit", "Kelvin" };
	private String[] areaUnits = { "Square meter", "Square kilometer", "Square mile", "Acre", "Hectare", "Square yard", "Square foot" };
	private String[] volumeUnits = { "Cubic meter", "Liter", "Milliliter", "Cubic centimeter", "Cubic inch", "Cubic foot", "Gallon" };
	private String[] weightUnits = { "Kilogram", "Gram", "Milligram", "Pound", "Ounce", "Ton" };
	
	
	private HashMap<String, String[]> unitMap = new HashMap<String, String[]>();

    private void unitHashMap() {
        unitMap = new HashMap<>();
        unitMap.put("Length", lengthUnits);
        unitMap.put("Temperature", temperatureUnits);
        unitMap.put("Area", areaUnits);
        unitMap.put("Volume", volumeUnits);
        unitMap.put("Weight", weightUnits);
    }
    
    private String[] currentUnits = lengthUnits;
    private String currentUnit = "Length";
    
    private HashMap<String, HashMap<String, String>> unitConversionHashMap = new HashMap<String, HashMap<String, String>>();
    
    
    
    private void createUnitConversionMap() {

        // Length conversions
        HashMap<String, String> lengthConversions = new HashMap<>();
        for (String unit : lengthUnits) {
            lengthConversions.put(unit + "->" + unit, "1");
        }
        lengthConversions.put("Meter->Kilometer", "0.001");
        lengthConversions.put("Kilometer->Meter", "1000");
        lengthConversions.put("Meter->Centimeter", "100");
        lengthConversions.put("Centimeter->Meter", "0.01");
        lengthConversions.put("Meter->Millimeter", "1000");
        lengthConversions.put("Millimeter->Meter", "0.001");
        lengthConversions.put("Meter->Mile", "0.000621371");
        lengthConversions.put("Mile->Meter", "1609.34");
        lengthConversions.put("Meter->Yard", "1.09361");
        lengthConversions.put("Yard->Meter", "0.9144");
        lengthConversions.put("Meter->Foot", "3.28084");
        lengthConversions.put("Foot->Meter", "0.3048");
        lengthConversions.put("Meter->Inch", "39.3701");
        lengthConversions.put("Inch->Meter", "0.0254");
        lengthConversions.put("Kilometer->Centimeter", "100000");
        lengthConversions.put("Centimeter->Kilometer", "0.00001");
        lengthConversions.put("Kilometer->Millimeter", "1000000");
        lengthConversions.put("Millimeter->Kilometer", "0.000001");
        lengthConversions.put("Kilometer->Mile", "0.621371");
        lengthConversions.put("Mile->Kilometer", "1.60934");
        lengthConversions.put("Kilometer->Yard", "1093.61");
        lengthConversions.put("Yard->Kilometer", "0.0009144");
        lengthConversions.put("Kilometer->Foot", "3280.84");
        lengthConversions.put("Foot->Kilometer", "0.0003048");
        lengthConversions.put("Kilometer->Inch", "39370.1");
        lengthConversions.put("Inch->Kilometer", "0.0000254");
        lengthConversions.put("Centimeter->Millimeter", "10");
        lengthConversions.put("Millimeter->Centimeter", "0.1");
        lengthConversions.put("Centimeter->Mile", "0.00000621371");
        lengthConversions.put("Mile->Centimeter", "160934");
        lengthConversions.put("Centimeter->Yard", "0.0109361");
        lengthConversions.put("Yard->Centimeter", "91.44");
        lengthConversions.put("Centimeter->Foot", "0.0328084");
        lengthConversions.put("Foot->Centimeter", "30.48");
        lengthConversions.put("Centimeter->Inch", "0.393701");
        lengthConversions.put("Inch->Centimeter", "2.54");
        lengthConversions.put("Millimeter->Mile", "0.000000621371");
        lengthConversions.put("Mile->Millimeter", "1609340");
        lengthConversions.put("Millimeter->Yard", "0.00109361");
        lengthConversions.put("Yard->Millimeter", "914.4");
        lengthConversions.put("Millimeter->Foot", "0.00328084");
        lengthConversions.put("Foot->Millimeter", "304.8");
        lengthConversions.put("Millimeter->Inch", "0.0393701");
        lengthConversions.put("Inch->Millimeter", "25.4");
        lengthConversions.put("Mile->Yard", "1760");
        lengthConversions.put("Yard->Mile", "0.000568182");
        lengthConversions.put("Mile->Foot", "5280");
        lengthConversions.put("Foot->Mile", "0.000189394");
        lengthConversions.put("Mile->Inch", "63360");
        lengthConversions.put("Inch->Mile", "0.0000157828");
        lengthConversions.put("Yard->Foot", "3");
        lengthConversions.put("Foot->Yard", "0.333333");
        lengthConversions.put("Yard->Inch", "36");
        lengthConversions.put("Inch->Yard", "0.0277778");
        lengthConversions.put("Foot->Inch", "12");
        lengthConversions.put("Inch->Foot", "0.0833333");
        unitConversionHashMap.put("Length", lengthConversions);

        // Temperature conversions
        HashMap<String, String> temperatureConversions = new HashMap<>();
        for (String unit : temperatureUnits) {
            temperatureConversions.put(unit + "->" + unit, "1");
        }
        temperatureConversions.put("Celsius->Fahrenheit", "SPECIAL");
        temperatureConversions.put("Fahrenheit->Celsius", "SPECIAL");
        temperatureConversions.put("Celsius->Kelvin", "SPECIAL");
        temperatureConversions.put("Kelvin->Celsius", "SPECIAL");
        temperatureConversions.put("Fahrenheit->Kelvin", "SPECIAL");
        temperatureConversions.put("Kelvin->Fahrenheit", "SPECIAL");
        unitConversionHashMap.put("Temperature", temperatureConversions);

        // Area conversions
        HashMap<String, String> areaConversions = new HashMap<>();
        for (String unit : areaUnits) { areaConversions.put(unit + "->" + unit, "1"); }
        areaConversions.put("Square meter->Square kilometer", "0.000001");
        areaConversions.put("Square kilometer->Square meter", "1000000");
        areaConversions.put("Square meter->Square mile", "3.861e-7");
        areaConversions.put("Square mile->Square meter", "2.59e+6");
        areaConversions.put("Square meter->Acre", "0.000247105");
        areaConversions.put("Acre->Square meter", "4046.86");
        areaConversions.put("Square meter->Hectare", "0.0001");
        areaConversions.put("Hectare->Square meter", "10000");
        areaConversions.put("Square meter->Square yard", "1.19599");
        areaConversions.put("Square yard->Square meter", "0.836127");
        areaConversions.put("Square meter->Square foot", "10.7639");
        areaConversions.put("Square foot->Square meter", "0.092903");
        areaConversions.put("Square kilometer->Square mile", "0.386102");
        areaConversions.put("Square mile->Square kilometer", "2.58999");
        areaConversions.put("Square kilometer->Acre", "247.105");
        areaConversions.put("Acre->Square kilometer", "0.00404686");
        areaConversions.put("Square kilometer->Hectare", "100");
        areaConversions.put("Hectare->Square kilometer", "0.01");
        areaConversions.put("Square kilometer->Square yard", "1.196e+6");
        areaConversions.put("Square yard->Square kilometer", "8.3613e-7");
        areaConversions.put("Square kilometer->Square foot", "1.076e+7");
        areaConversions.put("Square foot->Square kilometer", "9.2903e-8");
        areaConversions.put("Square mile->Acre", "640");
        areaConversions.put("Acre->Square mile", "0.0015625");
        areaConversions.put("Square mile->Hectare", "258.999");
        areaConversions.put("Hectare->Square mile", "0.00386102");
        areaConversions.put("Square mile->Square yard", "3.098e+6");
        areaConversions.put("Square yard->Square mile", "3.2283e-7");
        areaConversions.put("Square mile->Square foot", "2.788e+7");
        areaConversions.put("Square foot->Square mile", "3.587e-8");
        areaConversions.put("Acre->Hectare", "0.404686");
        areaConversions.put("Hectare->Acre", "2.47105");
        areaConversions.put("Acre->Square yard", "4840");
        areaConversions.put("Square yard->Acre", "0.000206612");
        areaConversions.put("Acre->Square foot", "43560");
        areaConversions.put("Square foot->Acre", "0.0000229568");
        areaConversions.put("Hectare->Square yard", "11959.9");
        areaConversions.put("Square yard->Hectare", "0.0000836127");
        areaConversions.put("Hectare->Square foot", "107639");
        areaConversions.put("Square foot->Hectare", "0.0000092903");
        areaConversions.put("Square yard->Square foot", "9");
        areaConversions.put("Square foot->Square yard", "0.111111");
        unitConversionHashMap.put("Area", areaConversions);

        // Volume conversions
        HashMap<String, String> volumeConversions = new HashMap<>();
        for (String unit : volumeUnits) { volumeConversions.put(unit + "->" + unit, "1"); }
        volumeConversions.put("Cubic meter->Liter", "1000");
        volumeConversions.put("Liter->Cubic meter", "0.001");
        volumeConversions.put("Cubic meter->Milliliter", "1000000");
        volumeConversions.put("Milliliter->Cubic meter", "0.000001");
        volumeConversions.put("Cubic meter->Cubic centimeter", "1000000");
        volumeConversions.put("Cubic centimeter->Cubic meter", "0.000001");
        volumeConversions.put("Cubic meter->Cubic inch", "61023.7441");
        volumeConversions.put("Cubic inch->Cubic meter", "0.000016387064");
        volumeConversions.put("Cubic meter->Cubic foot", "35.3146667");
        volumeConversions.put("Cubic foot->Cubic meter", "0.0283168466");
        volumeConversions.put("Cubic meter->Gallon", "264.172052");
        volumeConversions.put("Gallon->Cubic meter", "0.00378541178");
        volumeConversions.put("Liter->Milliliter", "1000");
        volumeConversions.put("Milliliter->Liter", "0.001");
        volumeConversions.put("Liter->Cubic centimeter", "1000");
        volumeConversions.put("Cubic centimeter->Liter", "0.001");
        volumeConversions.put("Liter->Cubic inch", "61.0237441");
        volumeConversions.put("Cubic inch->Liter", "0.016387064");
        volumeConversions.put("Liter->Cubic foot", "0.0353146667");
        volumeConversions.put("Cubic foot->Liter", "28.3168466");
        volumeConversions.put("Liter->Gallon", "0.264172052");
        volumeConversions.put("Gallon->Liter", "3.78541178");
        volumeConversions.put("Milliliter->Cubic centimeter", "1");
        volumeConversions.put("Cubic centimeter->Milliliter", "1");
        volumeConversions.put("Milliliter->Cubic inch", "0.0610237441");
        volumeConversions.put("Cubic inch->Milliliter", "16.387064");
        volumeConversions.put("Milliliter->Cubic foot", "0.0000353146667");
        volumeConversions.put("Cubic foot->Milliliter", "28316.8466");
        volumeConversions.put("Milliliter->Gallon", "0.000264172052");
        volumeConversions.put("Gallon->Milliliter", "3785.41178");
        volumeConversions.put("Cubic centimeter->Cubic inch", "0.0610237441");
        volumeConversions.put("Cubic inch->Cubic centimeter", "16.387064");
        volumeConversions.put("Cubic centimeter->Cubic foot", "0.0000353146667");
        volumeConversions.put("Cubic foot->Cubic centimeter", "28316.8466");
        volumeConversions.put("Cubic centimeter->Gallon", "0.000264172052");
        volumeConversions.put("Gallon->Cubic centimeter", "3785.41178");
        volumeConversions.put("Cubic inch->Cubic foot", "0.000578703704");
        volumeConversions.put("Cubic foot->Cubic inch", "1728");
        volumeConversions.put("Cubic inch->Gallon", "0.00432900433");
        volumeConversions.put("Gallon->Cubic inch", "231");
        volumeConversions.put("Cubic foot->Gallon", "7.48051948");
        volumeConversions.put("Gallon->Cubic foot", "0.133680556");
        unitConversionHashMap.put("Volume", volumeConversions);

        // Weight conversions
        HashMap<String, String> weightConversions = new HashMap<>();
        for (String unit : weightUnits) {
            weightConversions.put(unit + "->" + unit, "1");
        }
        weightConversions.put("Kilogram->Gram", "1000");
        weightConversions.put("Gram->Kilogram", "0.001");
        weightConversions.put("Gram->Milligram", "1000");
        weightConversions.put("Milligram->Gram", "0.001");
        weightConversions.put("Pound->Kilogram", "0.453592");
        weightConversions.put("Kilogram->Pound", "2.20462");
        weightConversions.put("Ounce->Gram", "28.3495");
        weightConversions.put("Gram->Ounce", "0.035274");
        weightConversions.put("Ton->Kilogram", "1000");
        weightConversions.put("Kilogram->Ton", "0.001");

        unitConversionHashMap.put("Weight", weightConversions);
    }

	//CONSTRUCTOR
	public MainFrame() {
		
		unitHashMap();//initialise the unitHashMap for later
		createUnitConversionMap();//initialise for conversion logic later
		
		JFrame mainFrame = new JFrame("Unit Converter");
		mainFrame.setSize(new Dimension(500, 175));
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		FlowLayout ribbonFlow = new FlowLayout(FlowLayout.CENTER, 10, 10); 
		GridLayout mainGrid = new GridLayout(0, 3, 5, 5);
		
		
		//RIBBON INITIALISE
		JPanel ribbonPanel = new JPanel(ribbonFlow);
		ribbonPanel.setBackground(Color.lightGray);
		
		//RIBBON BUTTONS
		JRadioButton length = new JRadioButton("Length"); length.setSelected(true);
		JRadioButton temperature = new JRadioButton("Temperature");
		JRadioButton area = new JRadioButton("Area");
		JRadioButton volume = new JRadioButton("Volume");
		JRadioButton weight = new JRadioButton("Weight");
		
		ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
		radioButtons.add(length);
		radioButtons.add(temperature);
		radioButtons.add(area);
		radioButtons.add(volume);
		radioButtons.add(weight);

		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		for (JRadioButton button: radioButtons) {
			buttonGroup.add(button);
		}
		for (JRadioButton button: radioButtons) {
			ribbonPanel.add(button);
		}
		
		
		//ADD RIBBON
		mainFrame.add(ribbonPanel, BorderLayout.NORTH);

		
		//MAIN PANEL INITIALISE
		JPanel mainPanel = new JPanel(mainGrid);
		
		//LABELS
		JLabel input = new JLabel("Input");
		JLabel output = new JLabel("Output");
		input.setHorizontalAlignment(SwingConstants.CENTER);
		output.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(input);
		mainPanel.add(new JLabel("")); // empty label with some spaces for gap
		mainPanel.add(output);
		
		JTextField inputTextField = new JTextField(20);

        JTextField outputTextField = new JTextField(20);
        outputTextField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
		
		mainPanel.add(inputTextField);
		mainPanel.add(calculateButton);
		mainPanel.add(outputTextField);
		
		JLabel to = new JLabel("");
		input.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox<String> inputDrop = new JComboBox<>(currentUnits);
		JComboBox<String> outputDrop = new JComboBox<>(currentUnits);
		
		mainPanel.add(inputDrop);
		mainPanel.add(to);
		mainPanel.add(outputDrop);
		
		//ADD PANEL
		mainFrame.add(mainPanel, BorderLayout.CENTER);
		
		//mainFrame.pack();
		mainFrame.setLocationRelativeTo(null); 
		mainFrame.setVisible(true);//LISTENERS
		for (JRadioButton button: radioButtons) {
			button.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        currentUnits = unitMap.get(button.getText());
			        currentUnit = button.getText();
			        inputDrop.removeAllItems();
			        outputDrop.removeAllItems();
			        for (String unit : currentUnits) {
			            inputDrop.addItem(unit);
			            outputDrop.addItem(unit);
			        }
			        inputTextField.setText("");
			    	outputTextField.setText("");
			        mainPanel.revalidate();
			        mainPanel.repaint();
			    }
			});
			
		}
		
		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String inputStr = inputTextField.getText();
				try {
			        Double input = Double.parseDouble(inputStr);
			        
			        String from = (String) inputDrop.getSelectedItem();
			        String to = (String) outputDrop.getSelectedItem();
			        
			        Double output = convertUnit(input, from, to);
			        
			        String outputStr = Double.toString(output);
			        outputTextField.setText(outputStr);
			        
			    } catch (NumberFormatException exception) {
			    	inputTextField.setText("");
			    	outputTextField.setText("Invalid input");
			    }
				
			}
				
		});
		
	}
	
	private double convertUnit(double input, String from, String to) {
	    HashMap<String, String> conversionFormulas = unitConversionHashMap.get(currentUnit);
	    if (conversionFormulas == null) {
	        System.err.println("No conversion formulas for current unit: " + currentUnit);
	        return input;
	    }

	    String key = from + "->" + to;
	    String conversionFormulaStr = conversionFormulas.get(key);
	    if (conversionFormulaStr == null) {
	        System.err.println("No conversion formula for key: " + key + " in category: " + currentUnit);
	        return input;
	    }

	    try {
	        double conversionFactor = Double.parseDouble(conversionFormulaStr);
	        return input * conversionFactor;
	    } catch (NumberFormatException e) {
	        if (currentUnit.equals("Temperature")) { // temperature formulas are a little more complicated
	            switch (key) {
	                case "Celsius->Fahrenheit":
	                    return (input * 9.0 / 5.0) + 32.0;
	                case "Fahrenheit->Celsius":
	                    return (input - 32.0) * 5.0 / 9.0;
	                case "Celsius->Kelvin":
	                    return input + 273.15;
	                case "Kelvin->Celsius":
	                    return input - 273.15;
	                case "Fahrenheit->Kelvin":
	                    return (input - 32.0) * 5.0 / 9.0 + 273.15;
	                case "Kelvin->Fahrenheit":
	                    return (input - 273.15) * 9.0 / 5.0 + 32.0;
	                default:
	                    System.err.println("Unknown temperature conversion: " + key);
	                    return input;
	            }
	        } else {
	            System.err.println("Failed to parse conversion factor for: " + key + ", value: " + conversionFormulaStr);
	            return input;
	        }
	    }
	}
}
