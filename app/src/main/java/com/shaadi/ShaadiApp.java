package com.shaadi;

import android.app.Application;

import com.shaadi.data.DataManager;
import com.shaadi.di.component.DaggerAppComponent;
import com.shaadi.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public class ShaadiApp extends Application implements HasAndroidInjector {
    private static ShaadiApp shaadiApp;
    @Inject
    public DataManager dataManager;
    @Inject
    public SchedulerProvider schedulerProvider;
    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    public static ShaadiApp getInstance() {
        return shaadiApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        shaadiApp = this;
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}
