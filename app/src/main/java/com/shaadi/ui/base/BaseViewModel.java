package com.shaadi.ui.base;

import android.content.Context;

import androidx.lifecycle.ViewModel;


import com.shaadi.data.DataManager;
import com.shaadi.utils.NetworkUtils;
import com.shaadi.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public abstract class BaseViewModel<N> extends ViewModel {

    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private Context context;

    private WeakReference<N> mNavigator;

    protected BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    /**
     * @param context of an application
     * @return network connected or not
     */
    protected boolean isNetworkConnected(Context context) {
        return NetworkUtils.isNetworkConnected(context);
    }


    protected CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    /**
     * @return DataManager
     */
    public DataManager getDataManager() {
        return mDataManager;
    }


    protected N getNavigator() {
        if (mNavigator == null) return null;
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    protected Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    protected SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
