package com.example.learningfrom0;

import java.util.ArrayList;
import java.util.List;

// صنف إدارة سلة المشتريات (يحفظ العطور التي يختارها المستخدم)
public class CartManager {

    private static CartManager instance;
    private List<Perfume> cartList = new ArrayList<>();

    private CartManager() {}

    // الحصول على النسخة الموحدة للسلة
    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    // إضافة عطر للسلة
    public void addToCart(Perfume perfume) {
        cartList.add(perfume);
    }

    // الحصول على قائمة عطور السلة
    public List<Perfume> getCartList() {
        return cartList;
    }
}
