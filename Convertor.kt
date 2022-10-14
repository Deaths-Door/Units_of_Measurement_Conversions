class Convertor(val from :String, val to:String, var num:String){
    /**
     * All options and units and values for them
     * **/
    private val units = mapOf("Length" to Pair(arrayListOf("km","m","cm","mm"),arrayListOf(1000,100,10)))

    /**
     * Get All units of filtered
     * **/
    fun getUnits(s:String = ""): Map<String, Pair<ArrayList<String>, ArrayList<Int>>> {
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
        if(fromType == toType) sameTypeConvert()
        else notSameTypeConvert()
        return num
    }

    private fun sameTypeConvert() {
        val arr = units[fromType]!!.second
        if(fromIndex > toIndex) arr.reverse()
        var x = 1
        while(fromIndex != toIndex){
            //TODO ADD CUSTOM MULTIPLY FUNCTION
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

    private fun notSameTypeConvert() {

    }
}
