package br.com.salosoftwares.mobile.testbottons;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtInitial;
    private Button btnInfo;
    private Button btnWarn;
    private Button btnError;
    private Button btnAssert;
    private SharedPreferences dbTest;

    private Boolean infoClicked;
    private Boolean warnClicked;
    private Boolean errorClicked;
    private Boolean assertClicked;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInfo = findViewById(R.id.btn_info);
        btnWarn = findViewById(R.id.btn_warn);
        btnError = findViewById(R.id.btn_error);
        btnAssert = findViewById(R.id.btn_assert);
        dbTest = getSharedPreferences("db", Context.MODE_PRIVATE);
        txtInitial = findViewById(R.id.txt_initial_text);

        infoClicked = dbTest.getBoolean("infoClicked", false);
        warnClicked = dbTest.getBoolean("warnClicked", false);
        errorClicked = dbTest.getBoolean("errorClicked", false);
        assertClicked = dbTest.getBoolean("assertClicked", false);

        txtInitial.setText(dbTest.getString("txtInitial", String.valueOf(R.string.initial_textStr)));

        if (infoClicked) {
            btnInfo.setText(R.string.btn_info_clicked_textStr);
            btnInfo.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_info_clickedCol));
        }

        if (warnClicked) {
            btnWarn.setText(R.string.btn_warn_clicked_textStr);
            btnWarn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_warn_clickedCol));
        }

        if (errorClicked) {
            btnError.setText(R.string.btn_error_clicked_textStr);
            btnError.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_error_clickedCol));
        }

        if (assertClicked) {
            btnAssert.setText(R.string.btn_assert_clicked_textStr);
            btnAssert.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_assert_clickedCol));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void infoClick(View view) {
        Log.i("infoClick", "btnInfo was clicked!");
        if (!infoClicked) {
            btnInfo.setText(R.string.btn_info_clicked_textStr);
            btnInfo.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_info_clickedCol));
            txtInitial.setText(btnInfo.getText().toString().toUpperCase());
            infoClicked = true;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("infoClicked", true);
            editor.putString("txtInitial", txtInitial.getText().toString());
            editor.apply();
            AlertDialog alertInfoClick = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.alertInfoClicked)
                    .setIcon(R.drawable.alert_popup_icon24dp)
                    .setMessage(R.string.alertInfoClickedMessage)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
                    alertInfoClick.show();
        } else {
            btnInfo.setText(R.string.btn_info_textStr);
            btnInfo.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_infoCol));
            //txtInitial.setText(R.string.initial_textStr);
            infoClicked = false;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("infoClicked", false);
            editor.apply();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void warnClick(View view) {
        if (!warnClicked) {
            btnWarn.setText(R.string.btn_warn_clicked_textStr);
            btnWarn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_warn_clickedCol));
            txtInitial.setText(btnWarn.getText().toString().toUpperCase());
            warnClicked = true;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("warnClicked", true);
            editor.putString("txtInitial", txtInitial.getText().toString());
            editor.apply();
            AlertDialog alertWarnClick = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.alertWarnClicked)
                    .setMessage(R.string.alertWarmClickedMessage)
                    .setIcon(R.drawable.alert_popup_icon24dp)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alertWarnClick.show();
        } else {
            btnWarn.setText(R.string.btn_warn_textStr);
            btnWarn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_warnCol));
            //txtInitial.setText(R.string.initial_textStr);
            warnClicked = false;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("warnClicked", false);
            editor.apply();
        }
        Log.w("warnClick", "btnWarn was clicked!");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void errorClick(View view) {
        if (!errorClicked) {
            btnError.setText(R.string.btn_error_clicked_textStr);
            btnError.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_error_clickedCol));
            txtInitial.setText(btnError.getText().toString().toUpperCase());
            errorClicked = true;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("errorClicked", true);
            editor.putString("txtInitial", txtInitial.getText().toString());
            editor.apply();
            AlertDialog alertErrorClick = new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.alertErrorClicked)
                    .setMessage(R.string.alertErrorClickedMessage)
                    .setIcon(R.drawable.alert_popup_icon24dp)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create();
            alertErrorClick.show();
        } else {
            btnError.setText(R.string.btn_error_textStr);
            btnError.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_errorCol));
            //txtInitial.setText(R.string.initial_textStr);
            errorClicked = false;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("errorClicked", false);
            editor.apply();
        }
        Log.e("errorClick", "btnError was clicked!");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void assertClick(View view) {
        Toast.makeText(getApplicationContext(), R.string.toast_btn_assertStr, Toast.LENGTH_LONG).show();
        if (!assertClicked) {
            btnAssert.setText(R.string.btn_assert_clicked_textStr);
            btnAssert.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_assert_clickedCol));
            txtInitial.setText(btnAssert.getText().toString().toUpperCase());
            assertClicked = true;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("assertClicked", true);
            editor.putString("txtInitial", txtInitial.getText().toString());
            editor.apply();
        } else {
            //btnAssert.setText(R.string.btn_assert_textStr);
            btnAssert.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.btn_assertCol));
            //txtInitial.setText(R.string.initial_textStr);
            assertClicked = false;
            SharedPreferences.Editor editor = dbTest.edit();
            editor.putBoolean("assertClicked", false);
            editor.apply();
        }
    }
}
// Continuar este projeto, falta trabalhar com banco de dados e mudança de aspecto dos botões
