package com.shaadi.ui.userlist;


import android.content.Context;

import com.shaadi.data.DataManager;
import com.shaadi.ui.userlist.adapter.UserAdapter;
import com.shaadi.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
@Module
public class UserActivityModule {

    @Provides
    UserViewModel provideUserActivityModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new UserViewModel(dataManager, schedulerProvider);
    }

    @Provides
    UserAdapter provideUserAdapter(Context context) {
        return new UserAdapter(context);
    }
}
