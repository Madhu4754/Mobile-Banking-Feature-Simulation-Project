package com.bank.sim.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

data class AccountBalance(val balance: Double)
data class Transaction(val id:String, val amount: Double, val date:String)
data class SupportMessage(val user:String, val message:String)

interface ApiService {
    @GET("account/balance")
    fun getBalance(@Header("Authorization") token:String): Call<AccountBalance>

    @GET("transactions")
    fun getTransactions(@Header("Authorization") token:String): Call<List<Transaction>>

    @GET("support/messages")
    fun getSupportMessages(@Header("Authorization") token:String): Call<List<SupportMessage>>
}
