package com.example.ma.caipiao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @Bind(R.id.et_fucai)
    EditText et_fucai;
    @Bind(R.id.btn_fucai)
    Button btn_fucai;

    @Bind(R.id.et_daletou)
    EditText et_daletou;
    @Bind(R.id.btn_daletou)
    Button btn_daletou;

    @Bind(R.id.et_qixingcai)
    EditText et_qixingcai;
    @Bind(R.id.btn_qixingcai)
    Button btn_qixingcai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //祝你梦想成真.......
        setListener();
    }

    private void setListener() {
        btn_fucai.setOnClickListener(CaiPiaoOnClickListener);
        btn_daletou.setOnClickListener(CaiPiaoOnClickListener);
        btn_qixingcai.setOnClickListener(CaiPiaoOnClickListener);

    }

    private View.OnClickListener CaiPiaoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_fucai:
                    //福彩机选方法
                    Log.d("info", "福彩");
                    fucai();
                    break;
                case R.id.btn_daletou:
                    //大乐透机选方法
                    Log.d("info", "大乐透");
                    daletou();
                    break;
                case R.id.btn_qixingcai:
                    //七星彩机选方法
                    Log.d("info", "七星彩");
                    qixingcai();
                    break;
            }
        }
    };

    /**
     * 七星彩 机选方法
     */
    private void qixingcai() {
        int[] qixingcai = new int[7];
        for (int i = 0; i < 7; i++) {
            qixingcai[i] = new Random().nextInt(10);
        }
        et_qixingcai.setText("七星彩：" + Arrays.toString(qixingcai));
    }

    /**
     * 大乐透 机选方法
     */
    private void daletou() {
        int[] r = new int[35];
        int[] b = new int[12];
        for (int i = 0; i < 35; i++) {
            r[i] = i + 1;
        }
        for (int i = 0; i < 12; i++) {
            b[i] = i + 1;
        }

        int[] red = new int[5];
        boolean[] flag = new boolean[35];
        for (int i = 0; i < 5; i++) {
            int j;
            do {
                j = new Random().nextInt(35);
            } while (flag[j]);
            red[i] = r[j];
            flag[j] = true;
        }
        int[] blue = new int[2];
        boolean[] flag1 = new boolean[12];
        for (int i = 0; i < 2; i++) {
            int j;
            do {
                j = new Random().nextInt(12);
            } while (flag[j]);
            blue[i] = b[j];
            flag[j] = true;
        }
        Arrays.sort(blue);
        Arrays.sort(red);

        et_daletou.setText("红球：" + Arrays.toString(red) + "-蓝球：" + Arrays.toString(blue));
    }

    /**
     * 福彩机选 方法
     */
    private void fucai() {
        int[] r = new int[33];
        int[] b = new int[16];

        for (int i = 0; i < 33; i++) {
            r[i] = i + 1;
        }
        for (int k = 0; k < 16; k++) {
            b[k] = k + 1;
        }
        //在后台日志（logcat）中显示数组的值


        int[] red = new int[6];
        boolean[] flag = new boolean[33];//默认为false
        for (int i = 0; i < 6; i++) {
            int j;
            do {//r数组中随机选下标赋值给j
                j = new Random().nextInt(33);
            } while (flag[j]);//当j位置选过回去重新选
            red[i] = r[j];//选中标记成“已经选”
            flag[j] = true;
        }

        int blue = b[new Random().nextInt(16)];
        Arrays.sort(red);
        et_fucai.setText("红球：" + Arrays.toString(red) + "-" + "蓝球：" + blue);

    }
}
