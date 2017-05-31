package com.d.yangc.framework.java.Lifecycle;

import android.view.View;

/**
 * Created by yangc on 2017/5/31.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
public class Tes {
private OnItemClickLitener  mOnItemClickLitener;



    public void setmOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    interface OnItemClickLitener {

        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
}
