package com.shaadi.data;


import com.shaadi.data.database.DbHelper;
import com.shaadi.data.model.User;
import com.shaadi.data.remote.ApiHelper;
import com.shaadi.data.remote.response.UserListResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper apiHelper;
    private final DbHelper dbHelper;

    @Inject
    AppDataManager(DbHelper dbHelper,ApiHelper apiHelper) {
        this.dbHelper = dbHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<UserListResponse> getUserList() {
        return apiHelper.getUserList();
    }


    @Override
    public Observable<List<User>> getAllUser() {
        return dbHelper.getAllUser();
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return dbHelper.insertUser(user);
    }

    @Override
    public Observable<Boolean> clearDatabase() {
        return dbHelper.clearDatabase();
    }

    @Override
    public Observable<Boolean> updateAcceptStatus(boolean status, String id) {
        return dbHelper.updateAcceptStatus(status,id);
    }

    @Override
    public Observable<Boolean> updateDeclineStatus(boolean status, String id) {
        return dbHelper.updateDeclineStatus(status,id);
    }

    @Override
    public Observable<User> getUser(String id) {
        return dbHelper.getUser(id);
    }
}
