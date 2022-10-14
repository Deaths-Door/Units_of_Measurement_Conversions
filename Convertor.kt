class Convertor(val from :String, val to:String, var num:String){
    /**
     * All options and units and values for them
     * **/

    private val units = mapOf("Length" to Pair(arrayListOf("km","m","cm","mm"),arrayListOf(1000,100,10)))

    /**
     * Get All units of filtered
     * **/
    val s = mapOf("l" to Pair(1,2))
    fun getUnits(s:String = ""): Map<String, Pair<ArrayList<String>, ArrayList<Int>>> {
        if(s == "") return units
        return units.filter {it.key == s }
       }

    /**
     * if given parms are valid
     **/

    private fun isValidNum(): Boolean = num.matches("([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?".toRegex())

    var fromType = ""
    var fromIndex = -1
    var toType   = ""
    var toIndex  = -1

    fun convert(): String {
        if(!isValidNum()) return "Enter Valid Number"
        if(from == to) return num

        for((key,value) in units){
            if(value.first.indexOf(from) != -1){
                fromType = key
                fromIndex = value.first.indexOf(from)
            }
            if(value.first.indexOf(to) != -1){
                toType = key
                toIndex = value.first.indexOf(to)
            }

            //if found all
            if(fromType != "" && toType != "") break
        }
        //didnt find it
        if(fromIndex == -1 || toIndex == -1) return "WRONG UNITS"

        //same type
        if(fromType == toType) {
            sameTypeConvert()
        }
        return num
    }

    private fun sameTypeConvert() {
        while(fromIndex != toIndex){
            //Convert
        }
    }
}

fun main(){
    print(Convertor("km","cm","1").convert())
}

/*   val indexOfType = options.indexOf(type)
               val indexFrom:Int = units[indexOfType].indexOf(from)
               var indexTo = units[indexOfType].indexOf(to)
               if(indexTo > units[indexOfType].size) indexFrom - 1

               while(indexFrom != indexTo){
                   num = (num.toDouble() *  values[indexOfType][indexTo]).toString()
                   indexTo--
               }*/

