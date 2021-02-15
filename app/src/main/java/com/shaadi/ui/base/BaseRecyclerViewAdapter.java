package com.shaadi.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public abstract class BaseRecyclerViewAdapter<T, TViewDataBinding extends ViewDataBinding, TViewData> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {

    @NonNull
    private final LayoutInflater mLayoutInflater;
    @NonNull
    private final Context mContext;
    @NonNull
    private List<T> mList;

    protected BaseRecyclerViewAdapter(@NonNull Context context, @NonNull List<T> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    @NonNull
    protected abstract ViewHolder<T, TViewDataBinding, TViewData> createViewHolder(TViewDataBinding binding);

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutRes = getLayoutRes();
        TViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutRes, parent, false);
        return createViewHolder(binding);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T item = getItem(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected Context getContext() {
        return mContext;
    }

    @NonNull
    private T getItem(int position) {
        return mList.get(position);
    }

    public List<T> getList() {
        return this.mList;
    }

    protected void setList(List<T> list) {
        this.mList = list;
    }

    protected void addList(List<T> list) {
        this.mList.addAll(list);
    }

    protected void addItem(T item) {
        this.mList.add(item);
    }

    public void removeListItem(T list) {
        this.mList.remove(list);
    }

    public abstract static class ViewHolder<T, TViewDataBinding, TViewData> extends RecyclerView.ViewHolder {

        protected final TViewData mViewData;
        final TViewDataBinding binding;

        public ViewHolder(TViewDataBinding binding) {
            super(((ViewDataBinding) binding).getRoot());
            this.binding = binding;
            mViewData = initViewData();
            if (mViewData == null) {
                throw new NullPointerException("BaseAdapterViewData must not be null");
            }
        }

        public TViewDataBinding getBinding() {
            return binding;
        }

        void bind(T item) {
            bindViewData(item, mViewData);
        }

        protected abstract void bindViewData(T item, TViewData viewData);

        protected abstract TViewData initViewData();

    }
}
