package com.hostoj;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private static final String[] LANGUAGES = new String[]
            {
                    "C", "C++", "Pascal",
                    "Java", "Ruby", "Bash",
                    "Python", "PHP", "Perl",
                    "C#", "Obj-C", "FreeBasic"
            };

    private static final String[] STATUS = new String[]
            {
                    "等待", "等待重判", "编译中",
                    "运行并评判", "正确", "格式错误",
                    "答案错误(点击查看对比)", "时间超限", "内存超限",
                    "输出超限", "运行错误", "编译错误",
                    "编译成功", "运行完成"
            };

    private EditText mEtSource, mEtInput, mEtOutput;

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtSource = findViewById(R.id.et_source);
        mEtInput = findViewById(R.id.et_input);
        mEtOutput = findViewById(R.id.et_output);


        mSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, android.R.id.text1, LANGUAGES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        findViewById(R.id.btn_run).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int selectedItemPosition = mSpinner.getSelectedItemPosition();
        JSONObject json = new JSONObject();
        try {
            json.put("problem_id", 0);
            json.put("language", selectedItemPosition);
            json.put("source", mEtSource.getText().toString());
            json.put("input_text",mEtInput.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //todo

    }

    class Task extends AsyncTask<JSONObject,Void,Void>{

        @Override
        protected Void doInBackground(JSONObject... jsonObjects) {
            return null;
        }
    }

}
