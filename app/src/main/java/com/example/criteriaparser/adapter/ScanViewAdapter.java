package com.example.criteriaparser.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criteriaparser.R;
import com.example.criteriaparser.databinding.ItemScanBinding;
import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.List;

public class ScanViewAdapter extends RecyclerView.Adapter<ScanViewAdapter.ItemViewHolder> {

    public ScanViewAdapter(){

    }

    private List<ScanDataApiResponse> data;
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemScanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.item_scan, parent, true);
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

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private ItemScanBinding binding;
        public ItemViewHolder(@NonNull ItemScanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(ScanDataApiResponse response) {
            binding.name.setText(response.getName());
            binding.tag.setText(response.getTag());
//            binding.tag.setTextColor(response.getColor().);
        }
    }

    public List<ScanDataApiResponse> getData() {
        return data;
    }

    public void setData(List<ScanDataApiResponse> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
