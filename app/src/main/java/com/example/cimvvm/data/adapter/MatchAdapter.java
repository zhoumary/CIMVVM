package com.example.cimvvm.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cimvvm.R;
import com.example.cimvvm.data.bean.Match;
import com.example.cimvvm.databinding.MainMatchItemBinding;
import com.example.cimvvm.ui.viewmodel.MainItemVeiwModel;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.DataViewHolder> {
    private static final String TAG = "MatchAdapter";
    private List<Match> matches;

    public MatchAdapter() {
        this.matches = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_match_item,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Match matchModel = matches.get(position);
        holder.setViewModel(new MainItemVeiwModel(matchModel));
    }

    @Override
    public int getItemCount() {
        return this.matches.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<Match> data) {
        if (data == null || data.isEmpty()) {
            this.matches.clear();
        } else {
            this.matches.addAll(matches);
        }
        notifyDataSetChanged();
    }

    /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
        /* package */ MainMatchItemBinding binding;

        /* package */ DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        /* package */ void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        /* package */ void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        /* package */ void setViewModel(MainItemVeiwModel viewModel) {
            if (binding != null) {
                binding.setMatchItem(viewModel);
            }
        }
    }
}
