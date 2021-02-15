package com.shaadi.ui.userlist.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.shaadi.R;
import com.shaadi.data.model.User;
import com.shaadi.data.remote.response.Results;
import com.shaadi.databinding.AdapterUserBinding;
import com.shaadi.ui.base.BaseRecyclerViewAdapter;
import com.shaadi.utils.OfflineUserList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 15/Feb/21
 */
public class UserAdapter extends BaseRecyclerViewAdapter<Results, AdapterUserBinding, UserDataView> {
    private final List<Results> mainList = new ArrayList<>();
    private Context context;

    public UserAdapter(@NonNull Context context) {
        super(context, new ArrayList<>());
        this.context = context;
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.adapter_user;
    }

    @NonNull
    @Override
    protected ViewHolder<Results, AdapterUserBinding, UserDataView> createViewHolder(AdapterUserBinding binding) {
        return new UserViewHolder(binding);
    }


    /**
     * add item to list
     * @param results result containd user data
     */
    public void addNewItem(Results results) {
        mainList.add(results);
        addItem(results);
        notifyDataSetChanged();
    }


    private class UserViewHolder extends ViewHolder<Results, AdapterUserBinding, UserDataView> {
        Results item;
        AdapterUserBinding adapterUserBinding;

        UserViewHolder(AdapterUserBinding adapterDemoItemBinding) {
            super(adapterDemoItemBinding);
            adapterDemoItemBinding.setViewModel(mViewData);
            adapterUserBinding = adapterDemoItemBinding;
        }

        @Override
        protected void bindViewData(Results item, UserDataView viewData) {
            this.item = item;
            viewData.userName.set(item.getName().getFirst() + " " + item.getName().getLast());
            if (item.getDob().getAge() != null)
                viewData.age.set(String.valueOf(item.getDob().getAge()));
            if (item.getLocation().getCountry() != null && item.getLocation().getState() != null)
                viewData.country_state.set(item.getLocation().getCountry() + ", " + item.getLocation().getState());
            else if (item.getLocation().getCountry() != null) {
                viewData.country_state.set(item.getLocation().getCountry());
            } else if (item.getLocation().getState() != null) {
                viewData.country_state.set(item.getLocation().getState());
            }
            if (item.getPicture().getMedium() != null) {
                viewData.remoteUserImageUrl.set(item.getPicture().getMedium());
            }


            OfflineUserList offlineUser = new OfflineUserList(new OfflineUserList.OfflineUser() {
                @Override
                public void offlineuserList(List<User> userList) {

                }

                @Override
                public void offlineAcceptDeclineStatus(boolean accept, boolean decline) {
                    viewData.isAcceptOrReject.set(accept || decline);
                    viewData.accept_reject.set(accept ? context.getResources().getString(R.string.member_accept) : decline ? context.getResources().getString(R.string.member_declined) : "");
                }
            });
            offlineUser.getStatus(item.getId());

            adapterUserBinding.setOnAcceptClickListener(view -> {
                offlineUser.updateAcceptStatus(true, item.getId());
                viewData.isAcceptOrReject.set(true);
                viewData.accept_reject.set(context.getResources().getString(R.string.member_accept));
            });
            adapterUserBinding.setOnDeclineClickListener(view -> {
                offlineUser.updateDeclineStatus(true, item.getId());
                viewData.isAcceptOrReject.set(true);
                viewData.accept_reject.set(context.getResources().getString(R.string.member_declined));
            });
        }

        @Override
        protected UserDataView initViewData() {
            return new UserDataView();
        }


    }


}
