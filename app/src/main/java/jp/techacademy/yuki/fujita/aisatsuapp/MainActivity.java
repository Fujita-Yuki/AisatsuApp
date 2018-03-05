package jp.techacademy.yuki.fujita.aisatsuapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay <= 2) {
                            mTextView.setText("こんばんは");
                        } else if (hourOfDay < 10) {
                            mTextView.setText("おはよう");
                        } else if (hourOfDay < 18) {
                            mTextView.setText("こんにちは");
                        } else {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                12,
                0,
                true);
        timePickerDialog.show();
    }
}

//AisatsuAppのプロジェクトを新規作成し、時刻に応じたあいさつを行うアプリを作成してください。
//
//        以下の要件を満たすアプリを作成してください。
//
//        画面内にButtonとTextViewを配置してください。
//        ButtonをタッチするとTimePickerDialogを表示して，設定した時刻に応じてTextViewに表示されるあいさつを変化させてください。
//        2:00 ~ 9:59 では「おはよう」
//        10:00 ~ 17:59 では「こんにちは」
//        18:00 ~ 1:59 では「こんばんは」
//        ヒント
//        TimePickerDialogのインスタンスのhourOfDayとminuteから時刻と分を取得できます。