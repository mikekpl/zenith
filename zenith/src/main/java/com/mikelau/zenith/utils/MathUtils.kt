package com.mikelau.zenith.utils

import java.util.ArrayList
import java.util.regex.Pattern

/**
 * Created by mclinica on 04/04/2017.
 */

object MathUtils {

    private val c = charArrayOf('k', 'm', 'b', 't')

    /**
     * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
     *
     * @param n         the number to format
     * @param iteration in fact this is the class from the array c
     * @return a String representing the number n formatted in a shortened way.
     */
    fun shortCount(n: Double, iteration: Int): String {
        if (n < 1000.0) {
            return n.toLong().toString()
        }

        val d = n.toLong() / 100 / 10.0
        val isRound = d * 10 % 10 == 0.0 //true if the decimal part is equal to 0 (then it's trimmed anyway)
        return if (d < 1000) //this determines the class, i.e. 'k', 'm' etc
            (if (d > 99.9 || isRound || !isRound && d > 9.99) //this decides whether to trim the decimals
                d.toInt() * 10 / 10 // (int) d * 10 / 10 drops the decimal
            else
                d.toString() + "").toString() + "" + c[iteration]
        else
            shortCount(d, iteration + 1)
    }

    /**
     * Compares version in SemVer format x.x.x > x.x.x
     * Do note that it also compares multiple digits
     * e.g. (2.11.2 > 2.2.2)
     *
     * @param version1 Indicate 1st version to be compared
     * @param version2 Indicate 2nd version to be compared
     * **/
    fun compareVersion(version1: String, version2: String): Int {

        val first = version1.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val second = version2.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        val len = if (first.size <= second.size) first.size else second.size
        for (i in 0 until len) {
            val firstInt = Integer.parseInt(first[i])
            val secondInt = Integer.parseInt(second[i])
            if (firstInt < secondInt) {
                return -1
            } else if (firstInt > secondInt) {
                return 1
            }
        }

        if (first.size < second.size) {
            for (i in first.size until second.size) {
                val secondInt = Integer.parseInt(second[i])
                if (secondInt != 0) {
                    return -1
                }
            }
        } else if (first.size > second.size) {
            for (i in second.size until first.size) {
                val firstInt = Integer.parseInt(first[i])
                if (firstInt != 0) {
                    return 1
                }
            }
        }

        return 0
    }

    /**
     * Retrieves the ID from the URL
     * e.g. (http://www.google.com/12 returns 12)
     *
     * @param url The url you have to get the id to
     * **/
    fun getIdFromUrl(url: String): Int {
        return try {
            val pattern = Pattern.compile("-?\\d+")
            val matcher = pattern.matcher(url)
            val numbers = ArrayList<String>()
            while (matcher.find()) {
                numbers.add(matcher.group())
            }
            Integer.valueOf(numbers[0])
        } catch (e: Exception) {
            0
        }
    }
}
