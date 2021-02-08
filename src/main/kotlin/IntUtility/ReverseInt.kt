package IntUtility

import java.lang.IllegalArgumentException

class ReverseInt(var i: Int) {
    public fun reverse(): Int {
        if (i == 0) return 0
        val isNegative: Boolean = i < 0
        i = kotlin.math.abs(i)
        val digits: MutableList<Int> = mutableListOf()
        while (i > 0) {
            digits.add(i % 10)
            i /= 10
        }
        if ( digits.size == 0 || (digits.size == 10 && digits[0] > 2)) return 0
        val reversed = if (isNegative) 0 - toIntFromDigitsArray(digits)
        else toIntFromDigitsArray(digits)
        if (!isNegative && reversed < 0 || isNegative && reversed > 0) return 0
        return reversed
    }

    private fun toIntFromDigitsArray(digits: MutableList<Int>): Int {
        var intValue: Int = digits[0];
        var counter: Int = 1;
        while (counter < digits.size) {
            intValue *= 10
            intValue += digits[counter]
            counter += 1
        }
        return intValue
    }
}