package com.example.pagingandroid.di

import com.example.pagingandroid.usecase.BookUsecase
import com.example.pagingandroid.vm.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataBaseModule::class])
interface AppComponent {
    fun inject(bookUsecase: BookUsecase)
    fun inject(mainViewModel: MainViewModel)
}