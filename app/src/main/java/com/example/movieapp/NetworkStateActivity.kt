package com.example.movieapp

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkStateActivity(val status: Status, val msg: String){

    companion object{

        val LOADED :NetworkStateActivity
        val LOADING : NetworkStateActivity
        val ERROR : NetworkStateActivity

        init {
            LOADED = NetworkStateActivity(Status.SUCCESS,msg = "Success")
            LOADING = NetworkStateActivity(Status.RUNNING,msg = "Running")
            ERROR = NetworkStateActivity(Status.FAILED,msg = "Failed")
        }

    }
}