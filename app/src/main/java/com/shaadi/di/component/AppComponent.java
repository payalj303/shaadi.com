package com.shaadi.di.component;

import android.app.Application;

import com.shaadi.ShaadiApp;
import com.shaadi.di.builder.ActivityBuilder;
import com.shaadi.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(ShaadiApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
