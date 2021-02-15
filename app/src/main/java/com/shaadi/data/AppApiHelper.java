package com.shaadi.data;


import com.shaadi.data.remote.ApiHelper;
import com.shaadi.data.remote.ApiService;
import com.shaadi.data.remote.response.UserListResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    private final ApiService appApi;

    @Inject
    public AppApiHelper(ApiService appApi) {
        this.appApi = appApi;
    }

    @Override
    public Single<UserListResponse> getUserList() {
        return appApi.getList();
    }


}
