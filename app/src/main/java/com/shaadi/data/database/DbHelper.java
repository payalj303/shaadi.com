package com.shaadi.data.database;

import com.shaadi.data.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@SuppressWarnings("unused")
public interface DbHelper {

    Observable<List<User>> getAllUser();

    Observable<Boolean> insertUser(User user);

    Observable<Boolean> clearDatabase();

    Observable<Boolean> updateAcceptStatus(boolean status, String id);

    Observable<Boolean> updateDeclineStatus(boolean status, String id);

    Observable<User> getUser(String id);
}
