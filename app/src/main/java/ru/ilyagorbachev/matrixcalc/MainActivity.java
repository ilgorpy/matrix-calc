package ru.ilyagorbachev.matrixcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/*
Нужно сделать выбор размерности матрицы пользователем. В зависимости от выбора размерности формировать tablelayout
 и заносить всё в двумерный массив, передавая в методы кол-во строк и столбцов, которые вводит пользователь.
 Доделать активность с правилами и теорией.
 */

public class MainActivity extends AppCompatActivity {
    Button btn_clear_A, btn_clear_B, btn_output_A, btn_output_B,
            btn_add, btn_sub, btn_mult, btn_mult_num_A, btn_mult_num_B,
            btn_trans_A, btn_trans_B, btn_det_A, btn_det_B, btn_invert_A,
            btn_invert_B, btn_rank_A, btn_rank_B, btn_create_A;

    EditText number_1,number_2, elemA_11, elemA_12, elemA_13, elemA_21, elemA_22, elemA_23, elemA_31, elemA_32, elemA_33,
                                elemB_11, elemB_12, elemB_13, elemB_21, elemB_22, elemB_23, elemB_31, elemB_32, elemB_33,
                                row_A, col_A, row_B, col_B;

    int[][] matrix_A = new int[3][3];
    int[][] matrix_B = new int[3][3];
    double[][] matrix_Ad = new double[3][3];
    double[][] matrix_Bd = new double[3][3];
    ArrayList<EditText> matAList, matBList;
    ArrayList<EditText> res_A;

    public MainActivity() { }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        elemA_11 = findViewById(R.id.editTextNumber11);
        elemA_12 = findViewById(R.id.editTextNumber12);
        elemA_13 = findViewById(R.id.editTextNumber13);
        elemA_21 = findViewById(R.id.editTextNumber21);
        elemA_22 = findViewById(R.id.editTextNumber22);
        elemA_23 = findViewById(R.id.editTextNumber23);
        elemA_31 = findViewById(R.id.editTextNumber31);
        elemA_32 = findViewById(R.id.editTextNumber32);
        elemA_33 = findViewById(R.id.editTextNumber33);

        elemB_11 = findViewById(R.id.editTextNumber11B);
        elemB_12 = findViewById(R.id.editTextNumber12B);
        elemB_13 = findViewById(R.id.editTextNumber13B);
        elemB_21 = findViewById(R.id.editTextNumber21B);
        elemB_22 = findViewById(R.id.editTextNumber22B);
        elemB_23 = findViewById(R.id.editTextNumber23B);
        elemB_31 = findViewById(R.id.editTextNumber31B);
        elemB_32 = findViewById(R.id.editTextNumber32B);
        elemB_33 = findViewById(R.id.editTextNumber33B);

        btn_clear_A = findViewById(R.id.button_clear_A);
        btn_clear_B = findViewById(R.id.button_clear_B);
        btn_output_A = findViewById(R.id.button_output_A);
        btn_output_B = findViewById(R.id.button_output_B);
        btn_add = findViewById(R.id.button_add);
        btn_sub = findViewById(R.id.button_sub);
        btn_mult = findViewById(R.id.button_mult);
        btn_mult_num_A = findViewById(R.id.button_mult_num_a);
        btn_mult_num_B = findViewById(R.id.button_mult_num_B);
        btn_trans_A = findViewById(R.id.button_trans_A);
        btn_trans_B = findViewById(R.id.button_trans_B);
        btn_det_A = findViewById(R.id.button_det_A);
        btn_det_B = findViewById(R.id.button_det_B);
        btn_invert_A = findViewById(R.id.button_invert_A);
        btn_invert_B = findViewById(R.id.button_invert_B);
        btn_rank_A = findViewById(R.id.button_rank_A);
        btn_rank_B = findViewById(R.id.button_rank_B);


        number_1 = findViewById(R.id.editTextNumber1);
        number_2 = findViewById(R.id.editTextNumber2);


        //row_B = findViewById(R.id.num_row_B);
        //int rowB = Integer.parseInt(String.valueOf(row_B.getText()));
        //col_B = findViewById(R.id.num_col_B);
        //int colB = Integer.parseInt(String.valueOf(col_B.getText()));

        matAList = new ArrayList<>();

        matAList.add(findViewById(R.id.editTextNumber11));
        matAList.add(findViewById(R.id.editTextNumber12));
        matAList.add(findViewById(R.id.editTextNumber13));

        matAList.add(findViewById(R.id.editTextNumber21));
        matAList.add(findViewById(R.id.editTextNumber22));
        matAList.add(findViewById(R.id.editTextNumber23));

        matAList.add(findViewById(R.id.editTextNumber31));
        matAList.add(findViewById(R.id.editTextNumber32));
        matAList.add(findViewById(R.id.editTextNumber33));


        matBList = new ArrayList<>();

        matBList.add(findViewById(R.id.editTextNumber11B));
        matBList.add(findViewById(R.id.editTextNumber12B));
        matBList.add(findViewById(R.id.editTextNumber13B));

        matBList.add(findViewById(R.id.editTextNumber21B));
        matBList.add(findViewById(R.id.editTextNumber22B));
        matBList.add(findViewById(R.id.editTextNumber23B));

        matBList.add(findViewById(R.id.editTextNumber31B));
        matBList.add(findViewById(R.id.editTextNumber32B));
        matBList.add(findViewById(R.id.editTextNumber33B));




        btn_output_B.setOnClickListener(view -> {
            int[][] res = listtomas(matBList, matrix_B);
            showInfoAlert(res, "Вывод матрицы B");
        });
        btn_clear_A.setOnClickListener(view -> {
            elemA_11.setText("");
            elemA_12.setText("");
            elemA_13.setText("");
            elemA_21.setText("");
            elemA_22.setText("");
            elemA_23.setText("");
            elemA_31.setText("");
            elemA_32.setText("");
            elemA_33.setText("");
            number_1.setText("");
        });
        btn_clear_B.setOnClickListener(view -> {
            elemB_11.setText("");
            elemB_12.setText("");
            elemB_13.setText("");
            elemB_21.setText("");
            elemB_22.setText("");
            elemB_23.setText("");
            elemB_31.setText("");
            elemB_32.setText("");
            elemB_33.setText("");
            number_2.setText("");
        });
        btn_mult_num_A.setOnClickListener(view -> {
            if (number_1 != null){
                int[][] res = multiply_number(listtomas(matAList, matrix_A), number_1);
                showInfoAlert_res(res, "Умножение матрицы A на число");
            }
            else
                Toast.makeText(this, "Введите число N", Toast.LENGTH_SHORT).show();
        });
        btn_mult_num_B.setOnClickListener(view -> {
            try{
                int[][] res = multiply_number(listtomas(matBList, matrix_B), number_2);
                showInfoAlert_res(res, "Умножение матрицы B на число");
            }
            catch(NoSuchElementException e) {
                Toast.makeText(this, "Введите число N", Toast.LENGTH_SHORT).show();
            }
        });
        btn_trans_A.setOnClickListener(view -> {
            int[][] res = transposition(listtomas(matAList, matrix_A));
            showInfoAlert_res(res, "Транспонирование матрицы А");
        });
        btn_trans_B.setOnClickListener(view -> {
            int[][] res = transposition(listtomas(matBList, matrix_B));
            showInfoAlert_res(res, "Транспонирование матрицы B");
        });
        btn_det_A.setOnClickListener(view -> {
            int det = determinantInt(listtomas(matAList, matrix_A), 3);
            showInfoAlert_resint(det, "Определитель матрицы А");
        });
        btn_det_B.setOnClickListener(view -> {
            int det = determinantInt(listtomas(matBList, matrix_B), 3);
            showInfoAlert_resint(det, "Определитель матрицы B");
        });
        btn_invert_A.setOnClickListener(view -> {
            int det = determinantInt(listtomas(matAList, matrix_A), 3);
            if (det != 0){
                double[][] res = invert(listtomasd(matAList, matrix_Ad));
                showInfoAlert_resd(res, "Обратная матрица А");
            }
             else{
                Toast.makeText(this, "det(A) = 0 - обратной матрицы не существует", Toast.LENGTH_LONG).show();
            }
        });
        btn_invert_B.setOnClickListener(view -> {
            int det = determinantInt(listtomas(matBList, matrix_B), 3);
            if (det != 0){
                double[][] res = invert(listtomasd(matBList, matrix_Bd));
                showInfoAlert_resd(res, "Обратная матрица B");
            }
            else{
                Toast.makeText(this, "det(B) = 0 - обратной матрицы не существует", Toast.LENGTH_LONG).show();
            }
        });
        btn_rank_A.setOnClickListener(view -> {
            int res = rankOfMatrix(listtomas(matAList, matrix_B));
            showInfoAlert_resint(res, "Ранг матрицы А");
        });
        btn_rank_B.setOnClickListener(view -> {
            int res = rankOfMatrix(listtomas(matBList, matrix_B));
            showInfoAlert_resint(res, "Ранг матрицы B");
        });
        btn_add.setOnClickListener(view -> {
            int[][] res = addition(listtomas(matAList, matrix_A), listtomas(matBList, matrix_B));
            showInfoAlert_res(res, "Сложение матриц");
        });
        btn_sub.setOnClickListener(view -> {
            int[][] res = substraction(listtomas(matAList, matrix_A), listtomas(matBList, matrix_B));
            showInfoAlert_res(res, "Разность матриц");
        });
        btn_mult.setOnClickListener(view -> {
            int[][] res = multiply(listtomas(matAList, matrix_A), listtomas(matBList, matrix_B));
            showInfoAlert_res(res, "Умножение матриц");
        });

    }



    private double[][] listtomasd(ArrayList<EditText> matList, double[][] matrix){
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(matList.get(counter).getText().toString());
                counter++;
            }
        }
        return matrix;
    }

    private int[][] listtomas(ArrayList<EditText> matList, int[][] matrix){
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                if (matList.get(counter) != null)
                    matrix[i][j] = Integer.parseInt(matList.get(counter).getText().toString());
                counter++;
            }
        }
        return matrix;
    }

    public int[][] addition(int[][] matA, int[][] matB){
        int[][] result = new int[3][3];
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[i].length; j++) {
                result[i][j] = matA[i][j] + matB[i][j];
            }
        }
        return result;
    }

    public int[][] multiply_number(int[][] matA, EditText number){
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] += matA[i][j] * Integer.parseInt(String.valueOf(number.getText()));
            }
        }
        return result;
    }

    public int[][] substraction(int[][] matA, int[][] matB){
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matA[i][j] - matB[i][j];
            }
        }
        return result;
    }

    public int[][] multiply(int[][] matA, int[][] matB){
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
        return result;
    }

    public int[][] transposition(int[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return matrix;
    }

    public static int determinantInt(int[][] mat, int n) {
        int D = 0;
        if (n == 1)
            return mat[0][0];
        int[][] temp = new int[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantInt(temp, n - 1);
            sign = -sign;
        }
        return D;
    }
    public static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++){
                if (row != p && col != q){
                    temp[i][j++] = mat[row][col];
                    if (j == 3 - 1){
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    public static double[][] invert(double[][] a){
        int n = a.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;
        gaussian(a, index);
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];
        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j){
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k){
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double[][] a, int[] index){
        int n = index.length;
        double[] c = new double[n];
        for (int i=0; i<n; ++i)
            index[i] = i;
        for (int i=0; i<n; ++i){
            double c1 = 0;
            for (int j=0; j<n; ++j){
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i){
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1){
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    static void swap(int[][] mat, int row1, int row2, int col) {
        for (int i = 0; i < col; i++){
            int temp = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = temp;
        }
    }

    static int rankOfMatrix(int[][] mat){
        int rank = mat.length;
        for (int row = 0; row < rank; row++) {
            if (mat[row][row] != 0) {
                for (int col = 0; col < mat.length; col++){
                    if (col != row) {
                        double mult = (double)mat[col][row] / mat[row][row];
                        for (int i = 0; i < rank; i++)
                            mat[col][i] -= mult * mat[row][i];
                    }
                }
            }
            else {
                boolean reduce = true;
                for (int i = row + 1; i < mat.length; i++){
                    if (mat[i][row] != 0){
                        swap(mat, row, i, rank);
                        reduce = false;
                        break ;
                    }
                }
                if (reduce) {
                    rank--;
                    for (int i = 0; i < mat.length; i ++)
                        mat[i][row] = mat[i][rank];
                }
                row--;
            }
        }
        return rank;
    }

    public StringBuilder outputd(double[][] matrix){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                double roundOff = Math.round(matrix[i][j] * 100.0) / 100.0;
                matrix[j][i] = roundOff;
                result.append(matrix[j][i]).append("   ");
            }
           result.append("\n");
        }
        return result;
    }

    public StringBuilder outputi(int[][] matrix){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                result.append(matrix[i][j]).append("   ");
            }
            result.append("\n");
        }
        return result;
    }


    private boolean isMatricesValid() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assert matAList != null;
                if (matAList.get(counter).getText().toString().isEmpty()){
                    return false;
                }
                matrix_A[i][j] = Integer.parseInt(matAList.get(counter).getText().toString());
                counter++;
            }
        }
        counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assert matBList != null;
                if (matBList.get(counter).getText().toString().isEmpty()){
                    return false;
                }
                matrix_B[i][j] = Integer.parseInt(matBList.get(counter).getText().toString());
                counter++;
            }
        }
        return true;
    }

    private void showInfoAlert(int[][] matrix, String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(outputi(matrix))
                .setCancelable(false)
                .setNegativeButton("Вернуться в калькулятор", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showInfoAlert_check(int n, int m) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Row and col")
                .setMessage(n)
                .setMessage(m)
                .setCancelable(false)
                .setNegativeButton("Вернуться в калькулятор", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfoAlert_resint(int det, String title) {
        StringBuilder res = new StringBuilder();
        res.append(det);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(res)
                .setCancelable(false)
                .setNegativeButton("Вернуться в калькулятор", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfoAlert_res(int[][] matrix, String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(outputi(matrix))
                .setCancelable(false)
                .setNegativeButton("Вернуться в калькулятор", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfoAlert_resd(double[][] matrix, String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(outputd(matrix))
                .setCancelable(false)
                .setNegativeButton("Вернуться в калькулятор", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void startregul(View v) {
        Intent intent = new Intent(this, regulations.class);
        startActivity(intent);
    }
}