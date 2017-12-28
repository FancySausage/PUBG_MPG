# PUBG_MPG
Calculating PUBG Vehicle Miles Per Gallon

How to help:
Find a vehicle and a gas can in any PUBG game. Take a screenshot before you refuel the vehicle and after. Use MS Paint to find the pixel difference from the fuel guage before and after you refuel to get the refuel pixel difference (These pixel values are assuming a screen resolution of 1920x1080).

Next, drive without boost on the vehicle on a flat road, and start recording your game when the speed has stabalized. Stop recording when the speed loses stability. Open the video after the game, and take a screenshot of the start of speed stability and stop of speed stability in your clip. Use the time elapsed in milliseconds between start/stop for setTimeElapsed, and use MS Paint to find how much fuel you consumed (in pixels) on the fuel gauge from start/stop. Repeat this process while driving with boost on your vehicle.


CODE GUIDE:
setRefuelPixelDifference() assigns how many pixels of the gas guage are filled when a vehicle is refueled.

setSpeed() is in KPH (use average speed of your recorded clip)

setTimeElapsed() is in milliseconds, and is the duration of vehicle movement recorded at the average speed assigned by setSpeed()

setTimeElapsedFuelPixelDifference() sets the pixel difference of the gas guage from the beginning to the end of your recorded clip.
