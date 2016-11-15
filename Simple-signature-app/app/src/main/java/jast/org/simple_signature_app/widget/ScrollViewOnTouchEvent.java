package jast.org.simple_signature_app.widget;

/**
 * 滑動的監聽者
 * <p/>
 * Created by jast.lai on 2016/6/13.
 */

import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;


public class ScrollViewOnTouchEvent implements View.OnTouchListener {

    interface OnTouchEventCallBack {
        void onTouchCallBack(int position, int status);

    }

    int status;

    HorizontalScrollView scrollView;
    int okWidth;
    int noWidth;

    final int crossScreen = 20;
    final int delayed = 100;

    int position;

    OnTouchEventCallBack mOnTouchEventCallBack;


    public ScrollViewOnTouchEvent(HorizontalScrollView scrollView, int okWidth, int noWidth) {
        this.scrollView = scrollView;
        this.okWidth = okWidth;
        this.noWidth = noWidth;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCheckListItems(OnTouchEventCallBack mOnTouchEventCallBack, int position) {
        this.mOnTouchEventCallBack = mOnTouchEventCallBack;
        this.position = position;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP) {


            //是不是滑開到刪除的位置
            switch (status) {

                case CheckItem.STATUS_NO_CHOOSE: {


                    // 如果滑過螢幕n分之1就打開
                    if (scrollView.getScrollX() < (okWidth - (okWidth / crossScreen))) {
                        scrollView.post(scrollToOk);
                    } else if (scrollView.getScrollX() > (okWidth + ((noWidth) / crossScreen))) {
                        scrollView.post(scrollToNo);
                    } else {
                        // 沒有就滑回去
                        scrollView.post(scrollToBegin);
                    }
                    break;

                }
                case CheckItem.STATUS_OK: {
                    if (scrollView.getScrollX() > (okWidth / crossScreen)) {
                        scrollView.post(scrollToBegin);
                    } else {
                        scrollView.post(scrollToOk);
                    }
                    break;
                }
                case CheckItem.STATUS_NO: {

                    if (scrollView.getScrollX() < (okWidth + noWidth - ((noWidth) / crossScreen))) {
                        scrollView.post(scrollToBegin);
                    } else {
                        scrollView.post(scrollToNo);
                    }
                    break;

                }
            }

        }


        return false;
    }

    Runnable scrollToNo = new Runnable() {
        @Override
        public void run() {
            scrollView.smoothScrollTo(okWidth + noWidth, 0);
            status = CheckItem.STATUS_NO;
            mOnTouchEventCallBack.onTouchCallBack(position, CheckItem.STATUS_NO);

        }
    };


    Runnable scrollToBegin = new Runnable() {
        @Override
        public void run() {
            scrollView.smoothScrollTo(okWidth, 0);
            status = CheckItem.STATUS_NO_CHOOSE;
            mOnTouchEventCallBack.onTouchCallBack(position, CheckItem.STATUS_NO_CHOOSE);
        }
    };

    Runnable scrollToOk = new Runnable() {
        @Override
        public void run() {
            scrollView.smoothScrollTo(0, 0);
            status = CheckItem.STATUS_OK;
            mOnTouchEventCallBack.onTouchCallBack(position, CheckItem.STATUS_OK);

        }
    };


}
