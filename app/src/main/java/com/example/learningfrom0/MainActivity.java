package com.example.learningfrom0;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ==========================================
        // هنا نبدأ مشروع عطور Aura والشركات العالمية!
        // ==========================================

        // 1. نصنع عطر من ماركة عالمية (مع التقييم)
        Perfume perfume1 = new Perfume("Sauvage", "Dior", 120.00, "A radically fresh composition, raw and noble.", 4.8);

        // 2. نصنع عطر Aura الخاص بك (مع التقييم)
        Perfume auraPerfume = new Perfume("Aura Signature", "Aura Exclusive", 85.50, "An enchanting blend of amber, floral, and oriental notes.", 4.9);

        // 3. ربط عناصر الشاشة (XML) بالكود (Java) لعرض بيانات عطر Aura للمستخدم!
        android.widget.TextView nameTextView = findViewById(R.id.textPerfumeName);
        android.widget.TextView brandTextView = findViewById(R.id.textPerfumeBrand);
        android.widget.TextView priceTextView = findViewById(R.id.textPerfumePrice);
        android.widget.TextView ratingTextView = findViewById(R.id.textPerfumeRating);

        // وضع بيانات عطر Aura داخل عناصر الشاشة لكي يراها المستخدم
        nameTextView.setText(auraPerfume.getName());
        brandTextView.setText("Brand: " + auraPerfume.getBrand());
        priceTextView.setText("Price: $" + auraPerfume.getPrice());
        ratingTextView.setText("Rating: " + auraPerfume.getRating() + " ⭐");

        // طباعة تفاصيل العطر في السجل أيضاً للتأكد
        android.util.Log.d("AuraApp", "Aura Perfume displayed successfully!");
    }
}