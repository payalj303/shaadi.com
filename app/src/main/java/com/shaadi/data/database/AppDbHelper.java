package com.shaadi.data.database;

import com.shaadi.data.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@SuppressWarnings("unused")
@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<User>> getAllUser() {
        return Observable.fromCallable(() -> mAppDatabase.userDao().loadAllUser());
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return Observable.fromCallable(() -> {
            mAppDatabase.userDao().insert(user);
            return true;
        });
    }


    @Override
    public Observable<Boolean> clearDatabase() {
        return Observable.fromCallable(() -> {
            mAppDatabase.clearAllTables();
            return true;
        });
    }

    @Override
    public Observable<Boolean> updateAcceptStatus(boolean status, String id) {
        return Observable.fromCallable(() -> {
            mAppDatabase.userDao().update(status,id);
            return true;
        });
    }

    @Override
    public Observable<Boolean> updateDeclineStatus(boolean status, String id) {
        return Observable.fromCallable(() -> {
            mAppDatabase.userDao().updateDeclineStatus(status,id);
            return true;
        });
    }

    @Override
    public Observable<User> getUser(String id) {
        return Observable.fromCallable(() -> mAppDatabase.userDao().getUserById(id));
    }
}
