package com.shaadi.ui.userlist;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.shaadi.R;
import com.shaadi.data.DataManager;
import com.shaadi.data.model.User;
import com.shaadi.data.remote.response.Dob;
import com.shaadi.data.remote.response.Location;
import com.shaadi.data.remote.response.Name;
import com.shaadi.data.remote.response.Picture;
import com.shaadi.data.remote.response.Results;
import com.shaadi.ui.base.BaseViewModel;
import com.shaadi.utils.AppUtils;
import com.shaadi.utils.OfflineUserList;
import com.shaadi.utils.rx.SchedulerProvider;

import java.util.List;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
public class UserViewModel extends BaseViewModel<UserNavigator> implements OfflineUserList.OfflineUser {
    private OfflineUserList offlineUserList;
    private static final String TAG = UserViewModel.class.getSimpleName();

    UserViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void init() {
        offlineUserList = new OfflineUserList(this);
        offlineUserList.getAllUser();     //get data from db and set in adapter
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        getNavigator().getViewDataBinding().rvUser.setLayoutManager(mLayoutManager);
        getNavigator().getViewDataBinding().rvUser.setAdapter(getNavigator().getUserAdapter());
    }

    //get user list from server
    private void getUserList() {
        if (isNetworkConnected(getContext())) {
            getCompositeDisposable().add(getDataManager().getUserList().doOnSuccess(response -> {
            }).subscribeOn(getSchedulerProvider().io()).observeOn(getSchedulerProvider().ui()).subscribe(response -> {
                if (response != null) {
                    List<Results> userListResponse = response.getResults();
                    for (Results userRes : userListResponse) {
                        userRes.setId(AppUtils.random());
                        offlineUserList.insertUser(userRes);
                        getNavigator().getUserAdapter().addNewItem(userRes);
                    }
                }
            }, throwable -> Log.i(TAG, "getUserList: ")));
        } else {
            Toast.makeText(getContext(), getContext().getResources().getString(R.string.no_internet), Toast.LENGTH_LONG).show();

        }

    }


    @Override
    public void offlineuserList(List<User> userList) {
        if (userList != null && userList.size() == 0) {
            getUserList();  //get user from server if not available in db
        } else if (userList != null) {
            for (User userList1 : userList) {
                Location location = new Location(userList1.country, userList1.city);
                Picture picture = new Picture(userList1.image);
                Dob dob = new Dob(userList1.age);
                Name name = new Name(userList1.fName, userList1.lName);
                Results results = new Results(userList1._id, name, location, picture, dob);
                getNavigator().getUserAdapter().addNewItem(results);
            }
        }
    }

    @Override
    public void offlineAcceptDeclineStatus(boolean accept, boolean decline) {

    }
}
