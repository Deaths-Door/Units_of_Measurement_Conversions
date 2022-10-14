# Units_of_Measurement_Conversions
C++ code to convert all units of measurement

Converts all units that I could think Of and numbers of any length


Use class
Parms -> From , To , Number
```kotlin
  val x = Convertor(/*Parms*/)
  
  val x = Convertor(/*Parms*/).convert()
  val x = Convertor("km","m",1).convert()
  // x = 1000
```

Get Working 

Types -> None , School Simple, School detailed 

Value -> Numbers(0..2)      

```kotlin
  val x = Convertor(/*Parms*/, /*Working */)
  
  //gives no working
  val x = Convertor("km","m","1", 1)
  
  //school simple  
  /**
     1 km -> 1000m -> 10000cm
  **/
  val x = Convertor("km","cm","1", 2)
  
  //school detailes
  /**
    1 km * 1000 = 1000m
    1000m * 10 = 10000cm    
  **/
  val x = Convertor("km","cm","1", 2)
```

Get All Units or get all units for certain type

Give no value for no filter and give value like "Length" for units of length
```kotlin
  val x = Convertor(/*Parms*/).getUnits("Length")
```


Possible Errors

```kotlin
   val x = Convertor("km","cm","w12", 2) // INVALID NUMBER
   val x = Convertor("k","cm","12", 2) // WRONG UNITS
   val x = Convertor("N/cm","cm","12", 2) // NOT POSSIBLE TO CONVERT
```
