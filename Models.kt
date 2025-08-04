package com.bank.sim.model

data class AccountBalance(val balance: Double)
data class Transaction(val id:String, val amount: Double, val date:String)
data class SupportMessage(val user:String, val message:String)
