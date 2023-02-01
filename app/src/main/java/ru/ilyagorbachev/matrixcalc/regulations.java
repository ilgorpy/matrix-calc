package ru.ilyagorbachev.matrixcalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class regulations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulations);

        Button add_sub_btn = findViewById(R.id.add_sub_btn);
        add_sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoAlert_1("При складывании (вычитании) матриц количество строк и столбцов в обеих матрицах должно быть одинаковым.");
            }
        });

        Button mult_btn = findViewById(R.id.mult_matrix_btn);
        mult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoAlert_2("Для перемножения матриц нужно, чтобы количество столбцов в первой матрице совпадало с количеством строк во второй матрице.");
            }
        });

        Button mult_mat_num_btn = findViewById(R.id.mult_matrix_num_btn);
        mult_mat_num_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoAlert_3("При умножении матрицы на число она может быть любых размеров, а число вещественным. При этом все элементы матрицы будут умножаться на введённое число.");
            }
        });

        Button trans_mat_btn = findViewById(R.id.trans_matrix_btn);
        trans_mat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoAlert_4("При транспонировании матрицы строки меняются местами со столбцами.");
            }
        });
    }

    public void goback(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void add_sub_matrix(View v) { }

    private void showInfoAlert_1(String text) {
        ImageView image = new ImageView(regulations.this);
        image.setImageResource(R.drawable.img);
        AlertDialog.Builder builder = new AlertDialog.Builder(regulations.this);
        builder.setTitle("Сложение и вычитание матриц")
                .setMessage(text)
                .setCancelable(false)
                .setView(image)
                .setPositiveButton("Перейти в калькулятор", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Вернуться в правила", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void mult_matrix(View v) { }

    public void showInfoAlert_2(String text) {
        ImageView image = new ImageView(regulations.this);
        image.setImageResource(R.drawable.mult_matrix);
        AlertDialog.Builder builder = new AlertDialog.Builder(regulations.this);
        builder.setTitle("Умножение матриц")
                .setMessage(text)
                .setCancelable(false)
                .setView(image)
                .setPositiveButton("Перейти в калькулятор", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Вернуться в правила", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void mult_matrix_num(View v) { }

    public void showInfoAlert_3(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(regulations.this);
        builder.setTitle("Умножение матрицы на число")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Перейти в калькулятор", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Вернуться в правила", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void trans_matrix(View v) {}

    public  void showInfoAlert_4(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(regulations.this);
        builder.setTitle("Транспонирование")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Перейти в калькулятор", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Вернуться в правила", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}