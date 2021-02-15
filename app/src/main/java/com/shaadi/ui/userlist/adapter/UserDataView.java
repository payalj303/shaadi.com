package com.shaadi.ui.userlist.adapter;


import android.text.Spannable;

import androidx.databinding.ObservableField;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
public class UserDataView {
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();
    public final ObservableField<String> country_state = new ObservableField<>();
    public final ObservableField<String> remoteUserImageUrl = new ObservableField<>();
    public final ObservableField<String> accept_reject = new ObservableField<>();

    public final ObservableField<Boolean> isAcceptOrReject = new ObservableField<>(false);
}
