package com.example.keyapplication.util

import androidx.test.runner.AndroidJUnit4
import com.example.keyapplication.utils.Utils
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilsTest {

    @Test
    fun formatKeywordTest1() {
        val result = Utils.formatKeyword("")
        assertTrue(result == "")
    }

    @Test
    fun formatKeywordTest2() {
        val result = Utils.formatKeyword("bitis hunter")
        assertTrue(result == "bitis\nhunter")
    }

    @Test
    fun formatKeywordTest3() {
        val result = Utils.formatKeyword("bitis hunter x")
        assertTrue(result == "bitis\nhunter x")
    }

    @Test
    fun formatKeywordTest4() {
        val result = Utils.formatKeyword("xiaomi")
        assertTrue(result == "xiaomi")
    }

    @Test
    fun formatKeywordTest5() {
        val result = Utils.formatKeyword("nguyễn nhật ánh")
        assertTrue(result == "nguyễn\nnhật ánh")
    }

    @Test
    fun formatKeywordTest6() {
        val result = Utils.formatKeyword("anh chính là thanh xuân của em")
        assertTrue(result == "anh chính là\nthanh xuân của em")
    }

    @Test
    fun formatKeywordTest7() {
        val result = Utils.formatKeyword("bitis x hunter")
        assertTrue(result == "bitis x\nhunter")
    }

    @Test
    fun formatKeywordTest8() {
        val result = Utils.formatKeyword("bitis xx hunter")
        assertTrue(result == "bitis xx\nhunter")
    }

    @Test
    fun formatKeywordTest9() {
        val result = Utils.formatKeyword("biti x hunter")
        assertTrue(result == "biti x\nhunter")
    }

    @Test
    fun formatKeywordsTest() {
        val keywords = listOf("", "x", "", "bitis x hunter")
        val formattedKeywords = listOf("", "x", "", "bitis x\nhunter")
        val result = Utils.formatKeywords(keywords)
        assertTrue(result == formattedKeywords)
    }
}
