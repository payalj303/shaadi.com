package com.shaadi.di.builder;


import com.shaadi.ui.userlist.UserActivity;
import com.shaadi.ui.userlist.UserActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@SuppressWarnings("unused")
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = UserActivityModule.class)
    abstract UserActivity bindUserActivity();

}
