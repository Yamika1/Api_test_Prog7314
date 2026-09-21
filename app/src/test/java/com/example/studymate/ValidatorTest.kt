package com.example.studymate

import org.junit.Assert
import org.junit.Test

class ValidatorTest {

@Test
fun IfUsernameIsValid_ReturnTrue(){
    val Username = "sally123#"
    val result = Validator.isValidUsername(Username)
    Assert.assertTrue(result)
}
    @Test
    fun IfUsernameIsInvalid_ReturnFalse(){
        val Username = "sally123"
        val result = Validator.isValidUsername(Username)
        Assert.assertFalse(result)
    }
    @Test
    fun IfPasswordIsValid_ReturnTrue(){
        val Password = "james23#!"
        val result = Validator.isValidPassword(Password)
        Assert.assertTrue(result)
    }
    @Test
    fun IfPasswordIsInvalid_ReturnFalse(){
        val Password = "sally123"
        val result = Validator.isValidPassword(Password)
        Assert.assertFalse(result)
    }
}