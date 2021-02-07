package StringUtility

class ZigZag {
    fun convertStringToZigZag(s: String, numRows: Int): String {
        var rowPointer: Int = 1
        var charPointer: Int = 0
        var goingDown: Boolean = true
        val rows: MutableMap<Int, MutableList<Char>> = initRowsMap(numRows)
        if (numRows == 1) return s
        while (charPointer < s.length) {
            rows[rowPointer]?.add(s[charPointer])
            if (rowPointer == 1) {
                goingDown = true
            } else if (rowPointer == numRows) {
                goingDown = false
            }
            if (goingDown) {
                rowPointer += 1
            } else {
                rowPointer -= 1
            }
            charPointer += 1
        }
        return concatStringFromRowsMap(rows, numRows)
    }

    private fun initRowsMap(numRows: Int): MutableMap<Int, MutableList<Char>> {
        var counter: Int = numRows
        val baseMap: MutableMap<Int, MutableList<Char>> = mutableMapOf()
        while (counter > 0) {
            baseMap[counter] = mutableListOf()
            counter -= 1
        }
        return baseMap
    }

    private fun concatStringFromRowsMap(rows: MutableMap<Int, MutableList<Char>>, numRows: Int): String {
        var string: String = ""
        var counter: Int = 1
        while (counter <= numRows) {
            string += rows[counter]?.joinToString("")
            counter += 1
        }
        return string
    }
}