package com.example.criteriaparser.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criteriaparser.R;
import com.example.criteriaparser.databinding.ItemScanBinding;
import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.List;

public class ScanViewAdapter extends RecyclerView.Adapter<ScanViewAdapter.ItemViewHolder> {

    private List<ScanDataApiResponse> data;
    private HandleOnScanClick handleOnScanClick;

    public ScanViewAdapter(HandleOnScanClick handleOnScanClick) {
        this.handleOnScanClick = handleOnScanClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemScanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.item_scan, parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemScanBinding binding;

        ItemViewHolder(@NonNull ItemScanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bind(final ScanDataApiResponse response) {
            binding.name.setText(response.name);
            binding.tag.setText(response.tag);
            binding.tag.setTextColor(Color.parseColor(response.color));
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleOnScanClick.handleOnClick(response);
                }
            });
        }
    }

    public interface HandleOnScanClick {
        void handleOnClick(ScanDataApiResponse response);
    }

    public void setData(List<ScanDataApiResponse> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
