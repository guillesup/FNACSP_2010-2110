# Five New Algorithms for the Computation of Sun Position from 2010 to 2110 in Java Language  
**Proposed by [Dr. Roberto Grena.](https://www.researchgate.net/profile/Roberto_Grena)**  
**Implemented by [Guillermo Guzmán Sánchez.](https://plus.google.com/u/0/+GuillermoGuzmánSánchez)**

Heavily based in the [original C++ source code](http://www.solaritaly.enea.it/StrSunPosition/SunPositionEn.php), but applying design patterns and TDD.  

## How to use it
Below is an example of computing the sun's position at Rome, using the algorithm with the highest precision:
```java
// (Algorithm #5)
Algorithm algorithm = new AlgorithmFactory().getInstance(Accuracy.HIGHEST); 

int year = 2020;  
int month = 1;
int day = 25;
int hour = 13;
int minute = 30;
int second = 0;
int nanoSecond = 0;
String zoneId = "Europe/Rome";

ZonedDateTime zonedDateTime = ZonedDateTime.of(year, month, day, hour, minute, second, nanoSecond, ZoneId.of(zoneId));

double longitude = 0.21787;     // Between -> [0, 2PI] rad
double latitude = 0.73117;      // Between -> [-PI/2, PI/2] rad
double pressure = 1.0;          // Between -> [0.85, 1.069] atm
double temperature = 20.0;      // Between -> [-89.2, 54.0] °C

SunPosition sunPosition = SunPosition.Make(algorithm, zonedDateTime, longitude, latitude, pressure, temperature);
sunPosition.computePosition();
```
Getting the computed values:
```java
ZonedDateTime zdt = sunPosition.getZonedDateTime();         
double zenith = sunPosition.getZenith();                    // Zenith angle -> [0,PI] rad
double azimuth = sunPosition.getAzimuth();                  // Azimuth angle -> [-PI,PI] rad
double rightAscension = sunPosition.getRightAscension();    // Right ascension -> [0,2PI] rad
double declination = sunPosition.getDeclination();          // Declination -> [-PI/2, PI/2] rad
double hourAngle = sunPosition.getHourAngle();              // Hour angle -> [-PI,PI] rad
boolean isItDay = sunPosition.isItDay();                    // Return True if the sun is above the horizon
```
Printing the output:
```console
zdt             => 2020-01-25T13:30+01:00[Europe/Rome]
Zenith          => 1.097167781330322
Azimuth         => 0.31452718410556935
Right Ascension => 5.364004066519731
Declination     => -0.33191742160701926
Hour Angle      => -5.98761790109209
Is it day?      => true
```
## Here is another example
In this example the instant sun's position is computed with the time-zone ID passed as String, with the highest precision algorithm (Algorithm #5).  

Using SunPositionNow class as a facade for SunPosition class:
```java
SunPositionNow sunPositionNow = new SunPositionNow("Europe/Rome", longitude, latitude, pressure, temperature);
sunPositionNow.computePosition();
```
The "getting and printing output" process same as before using the sunPositionNow object instead.

