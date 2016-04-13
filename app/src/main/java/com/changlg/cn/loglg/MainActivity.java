package com.changlg.cn.loglg;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_MSG = "伙计们 just for fun!";
    private static final String TAG = "Loglg";
    private static final String URL_XML = "https://raw.githubusercontent.com/ZhaoKaiQiang/KLog/master/app/src/main/AndroidManifest.xml";
    private static String XML = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!--  Copyright w3school.com.cn --><note><to>George</to><from>John</from><heading>Reminder</heading><body>Don't forget the meeting!</body></note>";
    private static String JSON;
    private static String JSON_LONG;
    private static String STRING_LONG;

    @Bind(R.id.default_log_btn)
    Button defaultLogBtn;
    @Bind(R.id.null_log_btn)
    Button nullLogBtn;
    @Bind(R.id.without_tag_log_btn)
    Button withoutTagLogBtn;
    @Bind(R.id.with_tag_log_btn)
    Button withTagLogBtn;
    @Bind(R.id.long_string_log_btn)
    Button longStringLogBtn;
    @Bind(R.id.params_log_btn)
    Button paramsLogBtn;
    @Bind(R.id.json_log_btn)
    Button jsonLogBtn;
    @Bind(R.id.long_json_log_btn)
    Button longJsonLogBtn;
    @Bind(R.id.json_with_tag_log_btn)
    Button jsonWithTagLogBtn;
    @Bind(R.id.file_log_btn)
    Button fileLogBtn;
    @Bind(R.id.xml_log_btn)
    Button xmlLogBtn;
    @Bind(R.id.xml_net_log_btn)
    Button xmlNetLogBtn;

    private AsyncHttpClient httpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        httpClient = new AsyncHttpClient();
        JSON = getString(R.string.json);
        JSON_LONG = getString(R.string.json_long);
        STRING_LONG = getString(R.string.string_long);
    }


    private void defLog() {
        Loglg.v();
        Loglg.d();
        Loglg.i();
        Loglg.w();
        Loglg.e();
        Loglg.a();
    }

    private void nullLog() {
        Loglg.v(null);
        Loglg.d(null);
        Loglg.i(null);
        Loglg.w(null);
        Loglg.e(null);
        Loglg.a(null);
    }

    private void msgLog() {
        Loglg.v(LOG_MSG);
        Loglg.d(LOG_MSG);
        Loglg.i(LOG_MSG);
        Loglg.w(LOG_MSG);
        Loglg.e(LOG_MSG);
        Loglg.a(LOG_MSG);
    }

    private void tagMsgLog() {
        Loglg.v(TAG, LOG_MSG);
        Loglg.d(TAG, LOG_MSG);
        Loglg.i(TAG, LOG_MSG);
        Loglg.w(TAG, LOG_MSG);
        Loglg.e(TAG, LOG_MSG);
        Loglg.a(TAG, LOG_MSG);
    }

    private void longMsgLog() {
        Loglg.d(TAG, STRING_LONG);
    }

    private void paramsLog() {
        Loglg.v(TAG, LOG_MSG, "param1", "param2", this);
        Loglg.d(TAG, LOG_MSG, "param1", "param2", this);
        Loglg.i(TAG, LOG_MSG, "param1", "param2", this);
        Loglg.w(TAG, LOG_MSG, "param1", "param2", this);
        Loglg.e(TAG, LOG_MSG, "param1", "param2", this);
        Loglg.a(TAG, LOG_MSG, "param1", "param2", this);
    }

    private void jsonLog() {
        Loglg.json(null);
        Loglg.json("CHANG123");
        Loglg.json(JSON);
    }

    private void longJsonLog() {
        Loglg.json(JSON_LONG);
    }

    private void jsonLogWithTag() {
        Loglg.json(TAG, JSON);
    }

    private void fileLog() {
        Loglg.file(Environment.getExternalStorageDirectory(), JSON_LONG);
        Loglg.file(TAG, Environment.getExternalStorageDirectory(), JSON_LONG);
        Loglg.file(TAG, Environment.getExternalStorageDirectory(), "chang.txt", JSON_LONG);
    }

    private void xmlLog() {
        Loglg.xml("chang1234");
        Loglg.xml(null);
        Loglg.xml(XML);
    }

    private void logWithXmlFromNet() {
        httpClient.get(this, URL_XML, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Loglg.e(TAG, responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Loglg.xml(TAG, responseString);
            }
        });
    }


    @OnClick({R.id.default_log_btn, R.id.null_log_btn, R.id.without_tag_log_btn, R.id.with_tag_log_btn, R.id.long_string_log_btn, R.id.params_log_btn, R.id.json_log_btn, R.id.long_json_log_btn, R.id.json_with_tag_log_btn, R.id.file_log_btn, R.id.xml_log_btn, R.id.xml_net_log_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.default_log_btn:
                defLog();
                break;
            case R.id.null_log_btn:
                nullLog();
                break;
            case R.id.without_tag_log_btn:
                msgLog();
                break;
            case R.id.with_tag_log_btn:
                tagMsgLog();
                break;
            case R.id.long_string_log_btn:
                longMsgLog();
                break;
            case R.id.params_log_btn:
                paramsLog();
                break;
            case R.id.json_log_btn:
                jsonLog();
                break;
            case R.id.long_json_log_btn:
                longJsonLog();
                break;
            case R.id.json_with_tag_log_btn:
                jsonLogWithTag();
                break;
            case R.id.file_log_btn:
                fileLog();
                break;
            case R.id.xml_log_btn:
                xmlLog();
                break;
            case R.id.xml_net_log_btn:
                logWithXmlFromNet();
                break;
        }
    }
}
