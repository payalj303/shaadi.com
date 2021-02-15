package com.shaadi.ui.userlist;


import com.shaadi.databinding.ActivityUserBinding;
import com.shaadi.ui.userlist.adapter.UserAdapter;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
interface UserNavigator {
    UserAdapter getUserAdapter();

    ActivityUserBinding getViewDataBinding();

}
