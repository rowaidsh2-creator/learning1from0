package com.example.learningfrom0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcomeLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. نربط زر "دخول المتجر" الموجود في XML مع الكود هنا في Java
        Button btnEnterStore = findViewById(R.id.btnEnterStore);

        // 2. نطلب من الزر الاستماع للضغطات (عندما يكبس عليه المستخدم)
        btnEnterStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 3. نستخدم الـ Intent للانتقال من شاشة الترحيب (WelcomeActivity) إلى شاشة العطور (MainActivity)
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);

                // 4. نُشغّل الشاشة الجديدة!
                startActivity(intent);
            }
        });

        // 5. ربط زر سلة المشتريات (btncartenter) والانتقال لشاشة السلة CartActivity
        Button btncartenter = findViewById(R.id.btncartenter);
        btncartenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
