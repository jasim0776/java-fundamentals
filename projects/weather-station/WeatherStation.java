public class WeatherStation {

    // These variables store the current state of the weather station.
    // Float is used instead of float so we can store null (meaning UNKNOWN).
    private Float airTemp;
    private Float airPressure;
    private Float precipitation;
    private Float windSpeed;
    private Float windDirection;
    private Float humidity;
    private Float dewPoint;
    private Float soilMoisture;
    private Float cloudCover; 
    // Constructor: initializes the weather station state.
    // When a WeatherStation object is created, all values are set to NULL
    // so that the initial state is clean and predictable.
    public WeatherStation() {
    clearState();
}

    // This method receives updates from the weather station.
    // It only updates the values that are present in the message.
    public void updateState(String message) {

        // Split the incoming message into lines
        // This handles both single-line and multi-line updates
        String[] formattedMessage = message.split("\n");

        // Process each line one by one
        for (String line : formattedMessage) {

            // Split each line into ID and value
            String[] parts = line.split(",");

            // Convert ID from String to int
            int id = Integer.parseInt(parts[0]);

            // Convert value:
            // - "NULL" becomes null
            // - otherwise convert String to Float
            Float value;
            if (parts[1].equals("NULL")) {
                value = null;
            } else {
                value = Float.parseFloat(parts[1]);
            }

            // Update the correct field based on the ID
            switch (id) {
                case 1:
                    airTemp = value;
                    break;
                case 2:
                    airPressure = value;
                    break;
                case 7:
                    precipitation = value;
                    break;
                case 11:
                    windSpeed = value;
                    break;
                case 12:
                    windDirection = value;
                    break;
                case 13:
                    humidity = value;
                    break;
                case 14:
                    dewPoint = value;
                    break;
                case 15:
                    soilMoisture = value;
                    break;
                case 22:
                    cloudCover = value;
                    break;
                // Unknown IDs are ignored automatically
            }
        }
    }

    // This method returns the full current state of the weather station.
    // All values are returned, even if they are null.
    public String getState() {

        // StringBuilder is used to build the output line by line
        StringBuilder result = new StringBuilder();

        // airTemp
        result.append("airTemp:");
        if (airTemp == null) {
            result.append("NULL");
        } else {
            result.append(airTemp);
        }
        result.append("\n");

        // airPressure
        result.append("airPressure:");
        if (airPressure == null) {
            result.append("NULL");
        } else {
            result.append(airPressure);
        }
        result.append("\n");

        // precipitation
        result.append("precipitation:");
        if (precipitation == null) {
            result.append("NULL");
        } else {
            result.append(precipitation);
        }
        result.append("\n");

        // windSpeed
        result.append("windSpeed:");
        if (windSpeed == null) {
            result.append("NULL");
        } else {
            result.append(windSpeed);
        }
        result.append("\n");

        // windDirection
        result.append("windDirection:");
        if (windDirection == null) {
            result.append("NULL");
        } else {
            result.append(windDirection);
        }
        result.append("\n");

        // humidity
        result.append("humidity:");
        if (humidity == null) {
            result.append("NULL");
        } else {
            result.append(humidity);
        }
        result.append("\n");

        // dewPoint
        result.append("dewPoint:");
        if (dewPoint == null) {
            result.append("NULL");
        } else {
            result.append(dewPoint);
        }
        result.append("\n");

        // soilMoisture
        result.append("soilMoisture:");
        if (soilMoisture == null) {
            result.append("NULL");
        } else {
            result.append(soilMoisture);
        }
        result.append("\n");

        // cloudCover
        result.append("cloudCover:");
        if (cloudCover == null) {
            result.append("NULL");
        } else {
            result.append(cloudCover);
        }
        result.append("\n");

        // Convert StringBuilder to String and return
        return result.toString();
    }

    // This method resets all stored values back to NULL.
    // It is used for initialization and explicit resets.
    public void clearState() {
        airTemp = null;
        airPressure = null;
        precipitation = null;
        windSpeed = null;
        windDirection = null;
        humidity = null;
        dewPoint = null;
        soilMoisture = null;
        cloudCover = null;
    }
}
