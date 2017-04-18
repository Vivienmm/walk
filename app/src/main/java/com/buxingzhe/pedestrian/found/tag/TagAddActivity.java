package com.buxingzhe.pedestrian.found.tag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.buxingzhe.pedestrian.R;
import com.buxingzhe.pedestrian.activity.BaseActivity;
import com.buxingzhe.pedestrian.bean.HotUserTag;
import com.buxingzhe.pedestrian.common.SwipeRefreshProperty;
import com.buxingzhe.pedestrian.found.bean.HotTagBean;
import com.buxingzhe.pedestrian.listen.SwpipeListViewOnScrollListener;
import com.buxingzhe.pedestrian.utils.EnterActUtils;
import com.buxingzhe.pedestrian.widget.TitleBarView;

import java.util.ArrayList;
import java.util.List;

/**
 * 评价
 * Created by QJ on 2016/6/30.
 */
public class TagAddActivity extends BaseActivity implements View.OnClickListener{
    private SwipeRefreshLayout mRefresh;
    private ListView mListView;
    private int currentIndex = 1;
    private final static int pageSize = 20;
    private AddTagAdapter addTagAdapter;
    private String checkTag = "";
    private RelativeLayout vAddTagRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtag);
        findViewId();
        titleBar();
        loadData();
        addListen();

    }
    public void findViewId() {
        vTitleBar = (TitleBarView) findViewById(R.id.tag_title_bar);
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mListView = (ListView) findViewById(R.id.myHistoryActListView);
        vAddTagRL = (RelativeLayout)findViewById(R.id.addTagRL);
        SwipeRefreshProperty.getInstall().setSwipeInfo(getBaseContext(), mRefresh);
        SwpipeListViewOnScrollListener scrollListener = new SwpipeListViewOnScrollListener(mRefresh);
        mRefresh.setEnabled(false);
        mListView.setOnScrollListener(scrollListener);
    }

    public void loadData() {
        addTagAdapter = new AddTagAdapter(mContext);
        mListView.setAdapter(addTagAdapter);
        getHotTag(true, checkTag);
    }
    public void addListen() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据操作
                currentIndex = 1;
                getHotTag(true, checkTag);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*HotUserTag hotUserTag = (HotUserTag) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(hotUserTag.tag)) {
                    et_tag.setText(hotUserTag.tag);
                }*/
            }
        });
        vAddTagRL.setOnClickListener(this);
    }

    public void titleBar() {
        setTitle("添加标签");
        setRightTitle("完成");
    }

    @Override
    public void onRightListener(View v) {
        super.onRightListener(v);
        addTag();
    }

    private void addTag() {
        Intent intent = new Intent();
        List<HotUserTag> hotSelectTags = new ArrayList<>();
        if (addTagAdapter != null){
            List<HotUserTag> hotUserTags = addTagAdapter.getHotUserTags();
            for (int i=0;i<hotUserTags.size();i++){
               HotUserTag tag = hotUserTags.get(i);
               if (tag.isSelect){
                   hotSelectTags.add(tag);
               }
            }
        }
        HotTagBean tagBean = new HotTagBean();
        tagBean.hotSelectTags = hotSelectTags;
        intent.putExtra("data",tagBean);
        setResult(RESULT_OK, intent);
        EnterActUtils.finishActivity(mActivity);
    }


    private void getHotTag(final boolean isClean,String checkTag){
        List<HotUserTag> hotUserTags = new ArrayList<>();
        HotUserTag tag1 = new HotUserTag();
        tag1.tag = "极美的";
        hotUserTags.add(tag1);
        HotUserTag tag2 = new HotUserTag();
        tag2.tag = "大家都喜欢";
        hotUserTags.add(tag2);
        HotUserTag tag3 = new HotUserTag();
        tag3.tag = "天天跑步";
        hotUserTags.add(tag3);
        if (addTagAdapter != null){
            addTagAdapter.setHotUserTagDatas(isClean,hotUserTags);
        }
        stopRefresh();

    }
    private void stopRefresh() {
        if (mRefresh != null)
            mRefresh.setRefreshing(false);
    }
    private void stopRefreshAnimation(){

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.addTagRL:
            Intent intent = new Intent(mContext,TagCreateActivity.class);
            EnterActUtils.startForResultAct(mActivity, intent, 1);
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String tag = data.getStringExtra("createTag");
                if (!TextUtils.isEmpty(tag)){
                    HotUserTag hotUserTags = new HotUserTag();
                    hotUserTags.tag = tag;
                    if (addTagAdapter != null){
                        addTagAdapter.getHotUserTags().add(0, hotUserTags);
                        addTagAdapter.notifyDataSetChanged();
                    }
                }
            break;

        }
    }
}