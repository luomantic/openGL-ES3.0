package com.example.opengles.act;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.opengles.R;
import com.example.opengles.adapter.SixStarAdapter;
import com.example.opengles.models.RvData;

import java.util.ArrayList;
import java.util.List;

/**
 * 正交投影与透视投影
 */
public class SixStarAct extends Activity {
    private List<RvData> rvDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_six_star);

        initData();
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.rv_six_star);
        SixStarAdapter sixStarAdapter = new SixStarAdapter(R.layout.item_six_star_adapter, rvDataList);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(sixStarAdapter);

        sixStarAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        sixStarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(SixStarAct.this, SixStarOrthoAct.class));
                        break;
                    case 1:
                        startActivity(new Intent(SixStarAct.this, SixStarFrustumAct.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        String[] names = {
                "正交投影", "透视投影"
        };

        rvDataList = new ArrayList<>();
        for (String name :
                names) {
            RvData rvData = new RvData();
            rvData.setName(name);
            String url = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=532808234,3202881386&fm=27&gp=0.jpg";
            rvData.setUrl(url);
            rvDataList.add(rvData);
        }
    }

}
