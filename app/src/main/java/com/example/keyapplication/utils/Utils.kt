package com.example.keyapplication.utils

import android.text.TextUtils
import java.lang.StringBuilder

object Utils {

    private const val BLANK = " "

    fun formatKeywords(keywords: List<String>?): List<String>? {
        if (keywords == null) return null
        val results = mutableListOf<String>()
        for (keyword in keywords) {
            results.add(formatKeyword(keyword))
        }
        return results
    }

    internal fun formatKeyword(keyword: String): String {
        var formattedKeyword = keyword
        if (!TextUtils.isEmpty(keyword) && keyword.contains(BLANK)) {
            val mid = keyword.length / 2
            val lastBlankOfFirstHalf = keyword.lastIndexOf(BLANK, mid)
            val firstBlankOfSecondHalf = keyword.indexOf(BLANK, mid)
            val breakPosition =
                when {
                    lastBlankOfFirstHalf == -1 -> firstBlankOfSecondHalf
                    firstBlankOfSecondHalf == -1 -> lastBlankOfFirstHalf
                    mid - lastBlankOfFirstHalf > firstBlankOfSecondHalf - mid -> firstBlankOfSecondHalf
                    else -> lastBlankOfFirstHalf
                }
            formattedKeyword = StringBuilder()
                .appendln(keyword.substring(0, breakPosition))
                .append(keyword.substring(breakPosition + 1, keyword.length))
                .toString()
        }
        return formattedKeyword
    }
}