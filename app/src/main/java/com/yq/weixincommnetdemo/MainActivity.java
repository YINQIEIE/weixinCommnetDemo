package com.yq.weixincommnetdemo;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_content;
    private MyAdapter adapter;
    private Dialog dialog;//包含输入框的 dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_content = (RecyclerView) findViewById(R.id.rv_content);

        adapter = new MyAdapter(this);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //以下两种监听方式都可以
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                handleWindowChange();
            }
        });

        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                handleWindowChange();
            }
        });
    }

    /**
     * 监听键盘的显示和隐藏
     */
    private void handleWindowChange() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);//获取当前界面显示范围
        Log.i("display  ", "top = " + rect.top);
        Log.i("display  ", "bottom = " + rect.bottom);
        int displayHeight = rect.bottom - rect.top;//app内容显示高度，即屏幕高度-状态栏高度-键盘高度
        int totalHeight = getWindow().getDecorView().getHeight();
        //显示内容的高度和屏幕高度比大于 0.8 时，dismiss dialog
        if ((float) displayHeight / totalHeight > 0.8)//0.8只是一个大致的比例，可以修改
            if (null != dialog && dialog.isShowing()) {
                dialog.dismiss();
                if (adapter.data.get(adapter.data.size() - 1) instanceof BottomBean) {
                    adapter.data.remove(adapter.data.size() - 1);
                    adapter.notifyDataSetChanged();
                }
            }
    }

    /**
     * 显示评论输入 dialog
     *
     * @param itemView
     * @param position
     */
    public void showInputDialog(View itemView, final int position) {
        final int itemBottomY = getCoordinateY(itemView) + itemView.getHeight();//item 底部y坐标
        dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_input, null);
        dialog.setContentView(view);
        //scrollView 点击事件，点击时将 dialog dismiss，设置 onClick 监听无效
        dialog.findViewById(R.id.scrollView).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    dialog.dismiss();
                return true;
            }
        });
        dialog.show();
        itemView.postDelayed(new Runnable() {
            @Override
            public void run() {
                LinearLayout llCommentInput = dialog.findViewById(R.id.ll_comment_input);
                int y = getCoordinateY(llCommentInput);
                Log.i("display", "itemBottomY = " + itemBottomY + "  input text y = " + y);
                if (position == adapter.data.size() - 1) {
                    adapter.data.add(new BottomBean());
                    adapter.bottomHeight = y;
                    adapter.notifyDataSetChanged();
                }
                //滑动 RecyclerView，是对应 item 底部和输入框顶部对齐
                rv_content.smoothScrollBy(0, itemBottomY - y);
            }
        }, 300);
    }

    /**
     * 获取控件左上顶点 y 坐标
     *
     * @param view
     * @return
     */
    private int getCoordinateY(View view) {
        int[] coordinate = new int[2];
        view.getLocationOnScreen(coordinate);
        return coordinate[1];
    }

}
