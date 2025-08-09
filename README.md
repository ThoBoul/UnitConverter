# Unit Converter (Java Swing)

## Overview
This is a **Java Swing-based Unit Converter** application that allows users to convert values between various units of **Length**, **Temperature**, **Area**, **Volume**, and **Weight**.  
The interface provides radio buttons for selecting the unit category, drop-down menus for choosing the "from" and "to" units, and a text field for entering the value to convert.

## Features
- **Categories Supported**:
  - Length (meters, kilometers, miles, yards, feet, inches, etc.)
  - Temperature (Celsius, Fahrenheit, Kelvin)
  - Area (square meters, acres, hectares, etc.)
  - Volume (liters, gallons, cubic meters, etc.)
  - Weight (kilograms, grams, pounds, etc.)
  
- **Conversion Handling**:
  - Fixed numeric conversion factors for most units.
  - Special handling for temperature conversions (non-linear formulas).
  
- **User Interface**:
  - **Ribbon Panel** with radio buttons for unit category selection.
  - **Main Panel** with:
    - Input field for the value to convert.
    - Drop-down menus for selecting input and output units.
    - Calculate button to perform conversion.
    - Output field showing the result.
    
- **Error Handling**:
  - Displays `"Invalid input"` if the entered value cannot be parsed as a number.

## How It Works
1. The program stores all available units in a **HashMap** (`unitMap`).
2. Conversion rates are stored in another **HashMap** (`unitConversionHashMap`), keyed by `"FromUnit->ToUnit"`.
3. When the user selects a category, the drop-down lists update to show the relevant units.
4. Clicking the **Calculate** button retrieves the selected units, looks up the conversion factor or formula, and displays the result.
5. Temperature conversions are handled with custom formulas.
