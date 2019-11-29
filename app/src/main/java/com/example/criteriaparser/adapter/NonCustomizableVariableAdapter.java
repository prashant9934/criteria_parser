package com.example.criteriaparser.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criteriaparser.R;
import com.example.criteriaparser.databinding.ItemScanBinding;

import java.util.List;

public class NonCustomizableVariableAdapter extends RecyclerView.Adapter<
        NonCustomizableVariableAdapter.NonCustomizableViewHolder> {

    private List<String> values;

    public NonCustomizableVariableAdapter(List<String> values) {
        this.values = values;
    }

    @NonNull
    @Override
    public NonCustomizableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemScanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.item_scan, parent, false);
        return new NonCustomizableViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NonCustomizableViewHolder holder, int position) {
        holder.bind(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values != null ? values.size() : 0;
    }

    public void setValues(List<String> values) {
        this.values = values;
        notifyDataSetChanged();
    }

    class NonCustomizableViewHolder extends RecyclerView.ViewHolder {
        private ItemScanBinding binding;

        NonCustomizableViewHolder(@NonNull ItemScanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bind(String value) {
            binding.tag.setVisibility(View.GONE);
            binding.name.setText(String.valueOf(value));
        }
    }
}
