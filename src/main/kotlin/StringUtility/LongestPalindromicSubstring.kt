package StringUtility

import java.lang.IllegalStateException
import kotlin.math.ceil
import kotlin.math.floor

class LongestPalindromicSubstring(var s: String) {
    private val dArr: List<Char> = insertDelimiters()
    fun extractLongestPalindrome(): String {
        if (s.isBlank()) throw IllegalStateException("String is empty, it shouldn't be")
        if (s.length == 1) return s;
        var center: Int = 2;
        var longestPalindrome: String? = null
//        println("Searching for palindromes in delimited array $dArr")
        while (center < dArr.size - 2) {
            val palindromeBounds: List<Int>? = searchForPalindromeWithCenter(center)
            if (!palindromeBounds.isNullOrEmpty()) {
                val pal: String = extractPalindromicStringFromDelimitedBounds(s, palindromeBounds)
                if (longestPalindrome.isNullOrBlank() || pal.length > longestPalindrome.length) {
                    longestPalindrome = pal;
                }
            }
            center += 1
        }
        return longestPalindrome?:"${s[0]}"
    }

    private fun searchForPalindromeWithCenter(c: Int): List<Int>? {
        val increment: Int = if (dArr[c] != '#') 2 else 1
        var l: Int = c - increment
        var r: Int = c + increment
//        println("Checking for palindromes centered at $c with l = $l and r = $r")
        if (dArr[l] != dArr[r]) {
//            println("Index $c is not a palindromic center")
            return null
        }
        while (l >= 0 && r < dArr.size - 1 && dArr[l] == dArr[r]) {
//            println("Palindrome found at $l and $r")
            l -= 2
            r += 2
        }
        l += 2
        r -= 2
//        println("Found palindrome bounds at $l and $r")
        return listOf(l, r)
    }

    private fun extractPalindromicStringFromDelimitedBounds(s: String, delimitedBounds: List<Int>): String {
        val start: Int = floor(delimitedBounds[0].toDouble() / 2).toInt();
        val end: Int = ceil(delimitedBounds[1].toDouble() / 2).toInt();
        return s.substring(start, end)
    }

    private fun insertDelimiters(): MutableList<Char> {
        val delimitedArray: MutableList<Char> = mutableListOf('#');
        s.forEach {
            delimitedArray.add(it)
            delimitedArray.add('#')
        }
        return delimitedArray;
    }
}