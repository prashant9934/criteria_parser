package com.example.criteriaparser.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criteriaparser.R;
import com.example.criteriaparser.databinding.ItemCriteriaViewBinding;
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
        private String $1;
        private String $2;
        private String $3;
        private String $4;

        DetailViewHolder(@NonNull ItemCriteriaViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        void bind(Criterium criteria, int position) {
            initilize$1(criteria);
            initilize$2(criteria);
            initilize$3(criteria);
            initilize$4(criteria);

            binding.name.setText(criteria.text);
            if (position < getItemCount() - 1) {
                binding.tag.setText(context.getString(R.string.and));
            }

            SpannableString spannableString = new SpannableString(criteria.text);
            if ($1 != null) {
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View view) {
                        Toast.makeText(context, "$1 clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                spannableString.setSpan(clickableSpan, criteria.text.indexOf($1), $1.length() + criteria.text.indexOf($1),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if ($2 != null) {
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View view) {
                        Toast.makeText(context, "$2 clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                spannableString.setSpan(clickableSpan, criteria.text.indexOf($2), $2.length() + criteria.text.indexOf($2),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if ($3 != null) {
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View view) {
                        Toast.makeText(context, "$3 clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                spannableString.setSpan(clickableSpan, criteria.text.indexOf($3), $3.length() + criteria.text.indexOf($3),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if ($4 != null) {
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View view) {
                        Toast.makeText(context, "$4 clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                spannableString.setSpan(clickableSpan, criteria.text.indexOf($4), $4.length() + criteria.text.indexOf($4),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            binding.name.setText(spannableString);
            binding.name.setMovementMethod(LinkMovementMethod.getInstance());
            binding.name.setHighlightColor(Color.BLUE);
        }

        private void initilize$1(Criterium criteria) {
            if (criteria.text.contains("$1")) {
                if (criteria.variable.$1.defaultValue != null) {
                    $1 = "(" + criteria.variable.$1.defaultValue + ")";
                    criteria.text = criteria.text.replace("$1", $1);
                } else if (criteria.variable.$1.values.size() > 0) {
                    $1 = "(" + criteria.variable.$1.values.get(0) + ")";
                    criteria.text = criteria.text.replace("$1", $1);
                }
            }
        }

        private void initilize$2(Criterium criteria) {
            if (criteria.text.contains("$2")) {
                if (criteria.variable.$2.values.size() > 0) {
                    $2 = "(" + criteria.variable.$2.values.get(0) + ")";
                    criteria.text = criteria.text.replace("$2", $2);
                }
            }
        }

        private void initilize$3(Criterium criteria) {
            if (criteria.text.contains("$3")) {
                if (criteria.variable.$3.values.size() > 0) {
                    $3 = "(" + criteria.variable.$3.values.get(0) + ")";
                    criteria.text = criteria.text.replace("$3", $3);
                }
            }
        }

        private void initilize$4(Criterium criteria) {
            if (criteria.text.contains("$4")) {
                if (criteria.variable.$4.defaultValue != null) {
                    $4 = "(" + criteria.variable.$4.defaultValue + ")";
                    criteria.text = criteria.text.replace("$4", $4);
                }
            }
        }
    }
}
