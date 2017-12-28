import java.text.DecimalFormat;

public class Vehicle {
    private final int totalTankSizePixels = 161;
    private int gasCanRefuelPixels, timeElapsedFuelPixelDifference, speed;
    private float timeElapsed;
    private String name;

    Vehicle(String name) {
        gasCanRefuelPixels = 0;
        timeElapsedFuelPixelDifference = 0;
        speed = 0;
        timeElapsed = 0;
        this.name = name;
    }

    void setRefuelPixelDifference(int gasCanRefuelPixels) {
        this.gasCanRefuelPixels = gasCanRefuelPixels;
    }

    void setTimeElapsedFuelPixelDifference(int timeElapsedFuelPixelDifference) {
        this.timeElapsedFuelPixelDifference = timeElapsedFuelPixelDifference;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    void setTimeElapsed(float timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    //Gas can = 20L = 5.28344 gallons
    private double getTankSize() {
        double percentOfTank = (double)gasCanRefuelPixels / totalTankSizePixels;
        return 1/percentOfTank * 5.28344;
    }

    private double possibleTimeTraveled(double gallonsUsed) {
        return (getTankSize() / gallonsUsed) * (timeElapsed / 1000) / 60;
    }

    private double possibleDistanceTraveled(double timeTravel) {
        return speed * (timeTravel / 60);
    }

    //timeElapsed = time in milliseconds
    //Speed is input as kph, 1 kph = 0.621371 mph
    String getMilesPerGallon() {
        if(gasCanRefuelPixels == 0 || timeElapsedFuelPixelDifference == 0
                || speed == 0 || timeElapsed == 0) {
            return "Error with the vehicle named " + name + ". Set all values required for MPG calculations!";
        }

        double gallonsPerPixel = getTankSize() / totalTankSizePixels;
        double gallonsUsed = timeElapsedFuelPixelDifference * gallonsPerPixel;
        double distance = (speed * 0.621371) * (timeElapsed / 1000 / 3600);

        double possibleTime = possibleTimeTraveled(gallonsUsed);
        double possibleDistance = possibleDistanceTraveled(possibleTime);

        DecimalFormat df = new DecimalFormat("#.###");
        return name + " MPG: " + df.format(distance / gallonsUsed) + " at an average speed of " + speed + " KPH("
                + df.format(speed * 0.621371) + " MPG) over " + timeElapsed / 1000
                + " seconds.\n" + df.format(gallonsUsed) + " gallons of gas were consumed out of the " + name + "'s "
                + df.format(getTankSize()) + " gallon tank.\nYou could have traveled a distance of "
                + df.format(possibleDistance) + " km(" + df.format(possibleDistance * 0.621371) + " miles) over "
                + df.format(possibleTime) + " minutes at this rate of consumption.\n";
    }
}
