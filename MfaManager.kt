package com.bank.sim.auth

object MfaManager {
    // Simulate sending OTP
    fun sendOtp(phone:String): String {
        // In real app integrate SMS gateway
        println("Sending OTP to $phone")
        return "123456" // stub OTP
    }

    // Validate OTP
    fun validateOtp(input:String, actual:String): Boolean {
        return input == actual
    }
}
