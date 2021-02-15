package com.shaadi.ui.userlist;

import android.os.Bundle;

import com.shaadi.BR;
import com.shaadi.R;
import com.shaadi.databinding.ActivityUserBinding;
import com.shaadi.ui.base.BaseActivity;
import com.shaadi.ui.userlist.adapter.UserAdapter;

import javax.inject.Inject;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
public class UserActivity extends BaseActivity<ActivityUserBinding, UserViewModel> implements UserNavigator {

    @Inject
    UserViewModel mUserViewModel;

    @Inject
    UserAdapter userAdapter;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel getViewModel() {
        return mUserViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserViewModel.setNavigator(this);
        mUserViewModel.setContext(this);
        mUserViewModel.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public UserAdapter getUserAdapter() {
        return userAdapter;
    }
}