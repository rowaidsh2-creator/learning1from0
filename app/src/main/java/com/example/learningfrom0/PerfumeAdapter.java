package com.example.learningfrom0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// هذا الـ Adapter هو المترجم الذي يأخذ قائمة العطور ويضعها داخل كروت الـ XML
public class PerfumeAdapter extends RecyclerView.Adapter<PerfumeAdapter.PerfumeViewHolder> {

    // قائمة العطور التي نريد عرضها
    private List<Perfume> perfumeList;

    // المُشيد (Constructor) لتمرير القائمة للـ Adapter
    public PerfumeAdapter(List<Perfume> perfumeList) {
        this.perfumeList = perfumeList;
    }

    // 1. إنشاء تصميم الكرت الواحد عند الحاجة
    @NonNull
    @Override
    public PerfumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_perfume, parent, false);
        return new PerfumeViewHolder(view);
    }

    // 2. تعبئة البيانات داخل الكرت (ربط العطر مع العناصر)
    @Override
    public void onBindViewHolder(@NonNull PerfumeViewHolder holder, int position) {
        Perfume perfume = perfumeList.get(position);

        holder.textName.setText(perfume.getName());
        holder.textBrand.setText(perfume.getBrand());
        holder.textPrice.setText("$" + perfume.getPrice());
        holder.textRating.setText("⭐ " + perfume.getRating());

        // عند الضغط على زر "المزيد من المعلومات"
        holder.btnMoreInfo.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PerfumeInfo.class);
            intent.putExtra("perfume_name", perfume.getName());
            intent.putExtra("perfume_brand", perfume.getBrand());
            intent.putExtra("perfume_price", perfume.getPrice());
            intent.putExtra("perfume_rating", perfume.getRating());
            intent.putExtra("perfume_description", perfume.getDescription());
            v.getContext().startActivity(intent);
        });
    }

    // 3. إرجاع عدد العطور الإجمالي في القائمة
    @Override
    public int getItemCount() {
        return perfumeList.size();
    }

    // صنف الحامل (ViewHolder) الذي يمسك عناصر الكرت الواحد
    public static class PerfumeViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textBrand, textPrice, textRating;
        Button btnMoreInfo;

        public PerfumeViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textItemName);
            textBrand = itemView.findViewById(R.id.textItemBrand);
            textPrice = itemView.findViewById(R.id.textItemPrice);
            textRating = itemView.findViewById(R.id.textItemRating);
            btnMoreInfo = itemView.findViewById(R.id.btnMoreInfo);
        }
    }
}
