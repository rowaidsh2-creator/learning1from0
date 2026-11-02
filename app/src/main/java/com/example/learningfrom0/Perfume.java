package com.example.learningfrom0;

public class Perfume {
    private String name;       // اسم العطر (مثل Aura Gold)
    private String brand;      // الشركة العالمية (مثل شانيل، ديور، إلخ)
    private double price;      // سعر العطر
    private String description;// وصف العطر ومكوناته
    private double rating;

    // المُشيد (Constructor) - هو المسؤول عن إنشاء عطر جديد بالبيانات التي ندخلها
    public Perfume(String name, String brand, double price, String description,double rating) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.rating = rating;
    }

    // دالة للحصول على اسم العطر
    public String getName() {
        return name;
    }

    // دالة للحصول على اسم الماركة/الشركه العالمية
    public String getBrand() {
        return brand;
    }

    // دالة للحصول على سعر العطر
    public double getPrice() {
        return price;
    }
    public double getRating() {return rating;}


    // دالة للحصول على وصف العطر
    public String getDescription() {
        return description;
    }

    // ==========================================
    // دوال لتعديل البيانات (Setters)
    // ==========================================

    // دالة لتعديل/تغيير اسم العطر
    public void setName(String name) {
        this.name = name;
    }

    // دالة لتعديل الماركة العالمية
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // دالة لتعديل السعر (مثلاً لو صار خصم على العطر)
    public void setPrice(double price) {
        this.price = price;
    }

    // دالة لتعديل الوصف
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
}
