package com.shaadi.data.remote;


import com.shaadi.data.remote.response.UserListResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author  Payal Jain
 * @version 1.0
 * @since  13/Dec/20
 */
public interface ApiService {
   @GET("?results=10")
   Single<UserListResponse> getList();
}
