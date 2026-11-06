package com.example.learningfrom0;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cartLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. ربط العناصر
        TextView textEmptyCart = findViewById(R.id.textEmptyCart);
        RecyclerView recyclerViewCart = findViewById(R.id.recyclerViewCart);

        // 2. الحصول على قائمة العطور في السلة
        List<Perfume> cartList = CartManager.getInstance().getCartList();

        if (cartList.isEmpty()) {
            // إذا كانت السلة فارغة: نُظهر نص "سلتك فارغة" ونخفي القائمة
            textEmptyCart.setVisibility(View.VISIBLE);
            recyclerViewCart.setVisibility(View.GONE);
        } else {
            // إذا كان فيها عطور: نخفي نص "فارغة" ونُظهر القائمة!
            textEmptyCart.setVisibility(View.GONE);
            recyclerViewCart.setVisibility(View.VISIBLE);

            recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
            PerfumeAdapter adapter = new PerfumeAdapter(cartList);
            recyclerViewCart.setAdapter(adapter);
        }

        // 3. زر العودة
        Button btnBackFromCart = findViewById(R.id.btnBackFromCart);
        btnBackFromCart.setOnClickListener(v -> finish());
    }
}
