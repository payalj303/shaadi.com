package com.shaadi.utils;

import android.util.Log;

import com.shaadi.ShaadiApp;
import com.shaadi.data.model.User;
import com.shaadi.data.remote.response.Results;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public class OfflineUserList {
    private static final String TAG = "OfflineUserList";
    private OfflineUser offlineUser;

    public OfflineUserList(OfflineUser offlineUser) {
        this.offlineUser = offlineUser;
    }

    /**
     * insert user detail in database
     *
     * @param userRes user details
     */
    public void insertUser(Results userRes) {
        User user = new User(userRes.getId(), userRes.getName().getFirst(), userRes.getName().getLast(), userRes.getDob().getAge(), userRes.getLocation().getCountry(), userRes.getLocation().getCity(), userRes.getPicture().getMedium(), false, false);
        new CompositeDisposable().add(ShaadiApp.getInstance().dataManager.insertUser(user).subscribeOn(ShaadiApp.getInstance().schedulerProvider.io()).observeOn(ShaadiApp.getInstance().schedulerProvider.ui()).subscribe(aBoolean -> {
        }, throwable -> Log.i(TAG, "getUserList13: ")));
    }

    /**
     * get all user from db
     */
    public void getAllUser() {
        new CompositeDisposable().add(ShaadiApp.getInstance().dataManager.getAllUser().subscribeOn(ShaadiApp.getInstance().schedulerProvider.io()).observeOn(ShaadiApp.getInstance().schedulerProvider.ui()).subscribe(userList -> {
            offlineUser.offlineuserList(userList);
        }, throwable -> {
        }));
    }

    /**
     * update status of accept status
     *
     * @param status true if user accept the req
     * @param id     id of user
     */
    public void updateAcceptStatus(boolean status, String id) {
        new CompositeDisposable().add(ShaadiApp.getInstance().dataManager.updateAcceptStatus(status, id).subscribeOn(ShaadiApp.getInstance().schedulerProvider.io()).observeOn(ShaadiApp.getInstance().schedulerProvider.ui()).subscribe(aBoolean -> {
        }, throwable -> Log.i(TAG, "setResponse: ")));
    }

    /**
     * update status of accept status
     *
     * @param status true if user decline the req
     * @param id     id of user
     */
    public void updateDeclineStatus(boolean status, String id) {
        new CompositeDisposable().add(ShaadiApp.getInstance().dataManager.updateDeclineStatus(status, id).subscribeOn(ShaadiApp.getInstance().schedulerProvider.io()).observeOn(ShaadiApp.getInstance().schedulerProvider.ui()).subscribe(aBoolean -> {
        }, throwable -> Log.i(TAG, "setResponse: ")));
    }

    /**
     * get status of user
     *
     * @param id id of user
     */
    public void getStatus(String id) {
        new CompositeDisposable().add(ShaadiApp.getInstance().dataManager.getUser(id).subscribeOn(ShaadiApp.getInstance().schedulerProvider.io()).observeOn(ShaadiApp.getInstance().schedulerProvider.ui()).subscribe(user -> {
            if (user != null)
                offlineUser.offlineAcceptDeclineStatus(user.accept, user.decline);

        }, throwable -> Log.i(TAG, "setResponse: ")));
    }

    public interface OfflineUser {
        void offlineuserList(List<User> userList);

        void offlineAcceptDeclineStatus(boolean accept, boolean decline);
    }
}
