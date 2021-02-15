package com.shaadi.di.module;

import android.app.Application;
import android.content.Context;


import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shaadi.BuildConfig;
import com.shaadi.data.AppApiHelper;
import com.shaadi.data.AppDataManager;
import com.shaadi.data.DataManager;
import com.shaadi.data.database.AppDatabase;
import com.shaadi.data.database.AppDbHelper;
import com.shaadi.data.database.DbHelper;
import com.shaadi.data.remote.ApiHelper;
import com.shaadi.data.remote.ApiService;
import com.shaadi.utils.AppConstants;
import com.shaadi.utils.rx.AppSchedulerProvider;
import com.shaadi.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppConstants.DB_NAME).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiService provideRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }


}
