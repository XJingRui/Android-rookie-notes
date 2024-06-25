package com.example.java_version;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public  class Myview extends View {

    private Rect mTextBounds;
    private  Paint mPaint;
    private Integer radius;
    private int mWidth,mHeight;
    private String text;
    //当创建的方式是 new MyView(context)时调用
    public Myview(Context context) {
        this(context,null);
    }
    //当创建的方式是 xml布局的方式时调用
    public Myview(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }
    //    用来我们自己实现一些东西
    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        //获取bg属性
        text = ta.getString(R.styleable.MyView_mntext);
        //注意回收
        ta.recycle();
//初始化画笔
        mPaint=new Paint();
        mTextBounds = new Rect();
        mPaint.setTextSize(100);
        mPaint.getTextBounds(text,0,text.length(),mTextBounds);


    }
    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }
//处理空间大小格式定义
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY){
                mWidth = specWidth;
        }else {
            mWidth =getPaddingLeft()+getPaddingRight()+ mTextBounds.width();
        }

        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        if(specMode ==MeasureSpec.EXACTLY){
            mHeight = specHeight;
        }else {
            mHeight =getPaddingBottom()+getPaddingTop()+ mTextBounds.height();
        }
setMeasuredDimension(mWidth,mHeight);


    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,getPaddingLeft(),getPaddingTop() +mTextBounds.height(),mPaint);
    }
//    @Override
//    protected void ondraw(Canvas canvas);
//    super.onDraw(Canvas);
//@Override
//protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//    //获取模式和尺寸
//    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//    int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//    int width=0, height=0;
//    //根据模式，求得合理的尺寸
//    switch (widthMode) {
//        case MeasureSpec.EXACTLY:
//            width = widthSize;
//            break;
//        case MeasureSpec.AT_MOST:
//        case MeasureSpec.UNSPECIFIED:
//            width = radius * 2;
//            break;
//    }
//    switch (heightMode){
//        case MeasureSpec.EXACTLY:
//            height=heightSize;
//            break;
//        case MeasureSpec.AT_MOST:
//        case MeasureSpec.UNSPECIFIED:
//            height = radius * 2;
//            break;
//    }
//    //设置自定义View的尺寸
//    setMeasuredDimension(width,height);
//}
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(0xff888888);
//        canvas.drawCircle(getWidth()/2, getHeight()/2, radius, mPaint);
//    }



}
