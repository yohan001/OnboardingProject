package com.example.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.ValueObject.MovieDetail
import io.reactivex.disposables.CompositeDisposable

class MovieDetailModel (private val movieRepository : MovieDetailRepository,movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetail : LiveData<MovieDetail> = movieRepository.fetchMovieDetailActivity(compositeDisposable,movieId)

    val networkState : LiveData<NetworkStateActivity> = movieRepository.getMovieDetailNetworkState()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}