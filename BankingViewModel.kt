package com.bank.sim.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bank.sim.model.AccountBalance
import com.bank.sim.model.Transaction
import com.bank.sim.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankingViewModel: ViewModel() {
    val balance = MutableLiveData<Double>()
    val transactions = MutableLiveData<List<Transaction>>()
    val support = MutableLiveData<List<String>>()
    private val api: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // placeholder
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    fun fetchBalance(token:String) {
        api.getBalance("Bearer $token").enqueue(object: Callback<com.bank.sim.network.AccountBalance>{
            override fun onResponse(call: Call<com.bank.sim.network.AccountBalance>, response: Response<com.bank.sim.network.AccountBalance>) {
                if(response.isSuccessful){
                    balance.postValue(response.body()?.balance)
                }
            }
            override fun onFailure(call: Call<com.bank.sim.network.AccountBalance>, t: Throwable) {
                // defect handling: log and retry logic placeholder
            }
        })
    }

    fun fetchTransactions(token:String) {
        api.getTransactions("Bearer $token").enqueue(object: Callback<List<com.bank.sim.network.Transaction>>{
            override fun onResponse(call: Call<List<com.bank.sim.network.Transaction>>, response: Response<List<com.bank.sim.network.Transaction>>) {
                if(response.isSuccessful){
                    transactions.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<com.bank.sim.network.Transaction>>, t: Throwable) {
                // defect: display user-friendly error
            }
        })
    }
}
