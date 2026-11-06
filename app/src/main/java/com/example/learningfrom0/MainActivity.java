package com.example.learningfrom0;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        // 1. إنشاء قائمة عطور حقيقية ومتنوعة!
        List<Perfume> perfumeList = new ArrayList<>();
        perfumeList.add(new Perfume("Aura Signature", "Aura Exclusive", 85.50, "An enchanting blend of amber and floral.", 4.9));
        perfumeList.add(new Perfume("Sauvage", "Dior", 120.00, "Radically fresh composition, raw and noble.", 4.8));
        perfumeList.add(new Perfume("Bleu de Chanel", "Chanel", 145.00, "A woody aromatic fragrance for men.", 4.9));
        perfumeList.add(new Perfume("Black Opium", "Yves Saint Laurent", 115.00, "Seductively intoxicating warm scent.", 4.7));
        perfumeList.add(new Perfume("Aventus", "Creed", 325.00, "Sensual, audacious and contemporary scent.", 5.0));
        perfumeList.add(new Perfume("Baccarat Rouge 540", "Maison Francis Kurkdjian", 350.00, "Luminous and intense amber floral.", 4.9));

        // 2. ربط الـ RecyclerView الموجود في الـ XML
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPerfumes);

        // 3. تحديد شكل القائمة (عمودية متتالية)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 4. إنشاء الـ Adapter وتمرير قائمة العطور له
        PerfumeAdapter adapter = new PerfumeAdapter(perfumeList);

        // 5. ربط الـ Adapter بالـ RecyclerView لتظهر العطور على الشاشة!
        recyclerView.setAdapter(adapter);

        // 6. ربط زر الرجوع للرئيسية
        Button btnReturnToHome = findViewById(R.id.btnReturnToHome);
        btnReturnToHome.setOnClickListener(v -> finish());
    }
}
