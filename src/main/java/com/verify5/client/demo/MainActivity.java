package com.verify5.client.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.v5maintest.R;
import com.verify5.client.Verify5Client;
import com.verify5.client.entity.V5Options;
import com.verify5.client.listener.VerifyStateMonitor;
import com.verify5.client.utils.V5LanCnf;

public class MainActivity extends AppCompatActivity {
    private TextView btn, msg;


    String token = "5ec063466aabbc819920bb4e37a89800";
    String host = "free7jysj6c2.verify5.com";

    int tl = 0;
    V5LanCnf lanCnf = V5LanCnf.ZH;
    private boolean isSSL = true;

    private Button en;
    private Button zh;
    private Button tr;
    private TextView lanTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (TextView) findViewById(R.id.test);
        msg = (TextView) findViewById(R.id.result);
        en = (Button) findViewById(R.id.en);
        lanTag = (TextView) findViewById(R.id.lan_tag);
        tr = (Button) findViewById(R.id.tr);

        zh = (Button) findViewById(R.id.zh);
        zh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanCnf = V5LanCnf.ZH;
                lanTag.setText("语言：中文");
            }
        });

        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanCnf = V5LanCnf.TR;
                lanTag.setText("语言：繁体");
            }
        });

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lanCnf = V5LanCnf.EN;
                lanTag.setText("语言：英文");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * 初始化sdk
             * 参数1： context，上下文
             * 参数2：options：基础参数设置
             *          options.setToken("")：如793462f671044be4ba99751eb56c780d
             *          options.setHost("")：如freetvks2vi2.verify5.com
             *          options.setLaunguageType(""),用给定的枚举值,如：LanCnf.EN,(ZH,EN,TR)，一般无需设置
             *          options.setTrustLevel(0)：设置trustLevel，一般无需设置
             *          options.setSSL(false):设置使用协议格式
             *              true:wss
             *              false:ws  默认为
             *
             * 参数5： VerifyStateMonitor monitor：认证结果回调：
             *         result：
             *           为空：认证失败
             *           不为空：认证成功
             */
            @Override
            public void onClick(View view) {

                    // V5图形验证必设参数
                    V5Options options = new V5Options();
                    options.setHost(host);
                    options.setToken(token);
                    // 选设置
                    options.setLaunguageType(lanCnf);
                    options.setTrustLevel(0);
                    options.setSSL(true);

                    Verify5Client.verify(MainActivity.this, options, new VerifyStateMonitor() {
                        @Override
                        public void onVerifyResult(String result) {
                            if (!TextUtils.isEmpty(result)) {
                                msg.setText("成功结果：" + result);
                            } else {
                                msg.setText("null(可能是token错误/应用过期/用量超限");
                            }
                        }
                    });
            }



        });
    }
}
