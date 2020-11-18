package com.example.mycourseproject.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;


import com.example.mycourseproject.R;
import com.example.mycourseproject.View.Storage;

import java.util.Collections;

/*
    Главный экран.
 */
public class MainActivity extends AppCompatActivity {

    // Инифиализируем наши компоненты.
    LottieAnimationView btnAddTask;
    RecyclerView recyclerView; // Прокручиваемый список.
    TaskAdapter taskAdapter; // Адаптер. (Предназначен для отображения данных из list в RecyclerView)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Подгружаем главный экран.

        // Связываем наши компоненты с XML файлом.
        this.btnAddTask = findViewById(R.id.STARTbtnAddTask);
        this.taskAdapter = new TaskAdapter(this); // Создаем адаптер.
        this.recyclerView = findViewById(R.id.STARTtasks);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(taskAdapter); // Устанавливаем адаптер для нашего RecyclerView.

        // Открываем форму добавления задания по нажатию кнопки "+".
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), NewTaskActivity.class);
                startActivity(intent);
            }
        });

        Collections.sort(Storage.getStorage().getList());
        taskAdapter.notifyDataSetChanged(); // Уведомляем об изменениях.
    }
}