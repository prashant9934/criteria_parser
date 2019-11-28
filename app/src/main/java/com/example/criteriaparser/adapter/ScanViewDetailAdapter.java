package com.example.criteriaparser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criteriaparser.R;
import com.example.criteriaparser.databinding.ItemCriteriaViewBinding;
import com.example.criteriaparser.databinding.ItemScanBinding;
import com.example.criteriaparser.model.Criterium;

import java.util.List;

public class ScanViewDetailAdapter extends RecyclerView.Adapter<ScanViewDetailAdapter.DetailViewHolder> {

    private List<Criterium> data;
    private Context context;

    public ScanViewDetailAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCriteriaViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_criteria_view, parent, false);
        return new DetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        holder.bind(data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public List<Criterium> getData() {
        return data;
    }

    public void setData(List<Criterium> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        private ItemCriteriaViewBinding binding;

        DetailViewHolder(@NonNull ItemCriteriaViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bind(Criterium criteria, int position) {
            binding.name.setText(criteria.text);
            if (position < getItemCount() - 1) {
                binding.tag.setText(context.getString(R.string.and));
            }
        }
    }
}
