package com.example.learningfrom0;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerfumeInfo extends AppCompatActivity {

    private Perfume currentPerfume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfume_info);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.perfumeInfoLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. ربط العناصر من الـ XML
        ImageView imageDetail = findViewById(R.id.imagePerfumeDetail);
        TextView textName = findViewById(R.id.textPerfumeDetailName);
        TextView textBrand = findViewById(R.id.textPerfumeDetailBrand);
        TextView textPrice = findViewById(R.id.textPerfumeDetailPrice);
        TextView textRating = findViewById(R.id.textPerfumeDetailRating);
        TextView textDescription = findViewById(R.id.textPerfumeDetailDescription);
        Button btnAddToCart = findViewById(R.id.btnDetailAddToCart);
        Button btnBack = findViewById(R.id.btnDetailBack);

        // 2. استلام معلومات العطر القادم من الـ Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("perfume_name");
        String brand = intent.getStringExtra("perfume_brand");
        double price = intent.getDoubleExtra("perfume_price", 0.0);
        double rating = intent.getDoubleExtra("perfume_rating", 0.0);
        String description = intent.getStringExtra("perfume_description");

        // إنشاء كائن العطر الحالي
        currentPerfume = new Perfume(name, brand, price, description, rating);

        // 3. عرض البيانات في العناصر على الشاشة
        textName.setText(name);
        textBrand.setText("الماركة: " + brand);
        textPrice.setText("$" + price);
        textRating.setText("⭐ " + rating);
        if (description != null && !description.isEmpty()) {
            textDescription.setText(description);
        }

        // 4. تفعيل زر "أضف للسلة"
        btnAddToCart.setOnClickListener(v -> {
            CartManager.getInstance().addToCart(currentPerfume);
            Toast.makeText(v.getContext(), "تمت إضافة " + currentPerfume.getName() + " إلى سلتك! 🛒", Toast.LENGTH_SHORT).show();
        });

        // 5. تفعيل زر "الرجوع"
        btnBack.setOnClickListener(v -> finish());
    }
}
