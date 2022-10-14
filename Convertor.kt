class Convertor(private val from :String, private val to:String, var num:String){
    /**
     * All options and units and values for them
     * **/
    private val units = mapOf(
        "Length" to Pair(arrayListOf("km","m","cm","mm"),arrayListOf(1000.0,100.0,10.0)),
        "Time" to Pair(arrayListOf("year","week","day","hr","min","sec"), arrayListOf(52.0,7.0,24.0,60.0,60.0)),
        "Mass" to Pair(arrayListOf("tonne","kg","g"), arrayListOf(1000.0,1000.0)),
        "Area" to Pair(arrayListOf("km²","m²","cm²","mm²"), arrayListOf(1e+6,1e+5,100.0)),
        "Volume" to Pair(arrayListOf("km³","m³","cm³","mm³"), arrayListOf(1e+9,1e+6,1000.0))
    )
    /**
     * Get All units of filtered
     * **/
    fun getUnits(s:String = ""): Map<String, Pair<ArrayList<String>, ArrayList<Double>>> {
        if(s == "") return units
        return units.filter {it.key == s }
    }

    /**
     * if given parms are valid
     **/
    private var fromType = ""
    private var fromIndex = -1
    private var toType   = ""
    private var toIndex  = -1

    private fun isValidNum(): Boolean = num.matches("([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[eE]([+-]?\\d+))?".toRegex())
    fun convert(): String {
        if(!isValidNum()) return "INVALID NUMBER"
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
        if(fromType == toType) sameTypeConvert() else num = notSameTypeConvert()
        return num
    }

    private fun sameTypeConvert() {
        val arr = units[fromType]!!.second
        if(fromIndex > toIndex) arr.reverse()
        while(fromIndex != toIndex){
            //Convert
            if(fromIndex < toIndex){
                num = (num.toDouble() * arr[toIndex - 1]).toString()
                toIndex--
            }
            else{
                num = (num.toDouble() / arr[fromIndex - 1]).toString()
                fromIndex--
            }
        }
    }
    private fun notSameTypeConvert():String = "FEATURE STILL IN PRODUCTION"
}