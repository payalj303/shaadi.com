package com.shaadi.data.remote;


import com.shaadi.data.remote.response.UserListResponse;

import java.util.List;

import io.reactivex.Single;

/**
 * @author Payal Jain
 * @version 1.0
 * @since 13/Dec/20
 */
public interface ApiHelper {

    Single<UserListResponse> getUserList();

}
