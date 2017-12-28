public class Main {

    public static void main(String[] args) {
        Vehicle buggy = new Vehicle("Buggy");
        buggy.setRefuelPixelDifference(65);
        buggy.setSpeed(89);
        buggy.setTimeElapsed(11000);
        buggy.setTimeElapsedFuelPixelDifference(2);

        Vehicle buggyBoosted = new Vehicle("Boosted Buggy");
        buggyBoosted.setRefuelPixelDifference(65);
        buggyBoosted.setSpeed(114);
        buggyBoosted.setTimeElapsed(12000);
        buggyBoosted.setTimeElapsedFuelPixelDifference(4);

        System.out.println(buggy.getMilesPerGallon());
        System.out.println(buggyBoosted.getMilesPerGallon());
    }
}
