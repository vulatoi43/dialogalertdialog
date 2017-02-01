package com.example.thanhvu.dialogalertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btnalert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        btnalert=(Button)findViewById(R.id.btnalert);
        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogalert();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dia=new Dialog(MainActivity.this);
                dia.setTitle("helloworld");
                dia.setContentView(R.layout.dialog);
                dia.show();
                dia.setCancelable(false);
                Button btn1=(Button)dia.findViewById(R.id.dongy);
                Button btn2=(Button)dia.findViewById(R.id.uchiu);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "dang xuat thanh cong", Toast.LENGTH_SHORT).show();
                        dia.dismiss();
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dia.dismiss();
                    }
                });

            }
        });
    }

    private void showDialogalert() {
        final AlertDialog.Builder build=new AlertDialog.Builder(this);
        build.setTitle("hello world");
        build.setMessage("ban co muon dang xuat khong?");
        build.setCancelable(false);
        build.setPositiveButton("dong y " , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "ban da dang xuat thanh cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        build.setNegativeButton("u chiu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=build.create();
        dialog.show();
    }
}
