package com.example.administrator.whereareyounow.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.administrator.whereareyounow.R;

public class MyScrollView extends ScrollView {

	// 拖动的距离 size = 4 的意思 只允许拖动屏幕的1/4
	private static final int size = 4;
	private View inner;
	private float y;
	private Rect normal = new Rect();
	float dow_y = 0;//按下Y坐标
	float mo_y = 0;//移动是Y的坐标

	public MyScrollView(Context context) {
		super(context);
	}

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			inner = getChildAt(0);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (inner == null) {
			return super.onTouchEvent(ev);
		} else {
			commOnTouchEvent(ev);
		}
		return super.onTouchEvent(ev);
	}

	public void commOnTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			y = ev.getY();
			break;
		case MotionEvent.ACTION_UP:
			if (isNeedAnimation()) {
				// Log.v("mlguitar", "will up and animation");
				animation();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			final float preY = y;
			float nowY = ev.getY();
			/**
			 * size=4 表示 拖动的距离为屏幕的高度的1/4
			 */
			int deltaY = (int) (preY - nowY) / size;
			// 滚动
			// scrollBy(0, deltaY);

			y = nowY;
			// 当滚动到最上或者最下时就不会再滚动，这时移动布局
			if (isNeedMove()) {
				if (normal.isEmpty()) {
					// 保存正常的布局位置
					normal.set(inner.getLeft(), inner.getTop(), inner.getRight(), inner.getBottom());
					return;
				}
				int yy = inner.getTop() - deltaY;

				// 移动布局
				inner.layout(inner.getLeft(), yy, inner.getRight(), inner.getBottom() - deltaY);
			}
			break;
		default:
			break;
		}
	}

	// 开启动画移动

	public void animation() {
		// 开启移动动画
		TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop(), normal.top);
		ta.setDuration(200);
		inner.startAnimation(ta);
		// 设置回到正常的布局位置
		inner.layout(normal.left, normal.top, normal.right, normal.bottom);
		normal.setEmpty();
	}

	// 是否需要开启动画
	public boolean isNeedAnimation() {
		return !normal.isEmpty();
	}

	// 是否需要移动布局
	public boolean isNeedMove() {
		int offset = inner.getMeasuredHeight() - getHeight();
		int scrollY = getScrollY();
		if (scrollY == 0 || scrollY == offset) {
			return true;
		}
		return false;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width= MeasureSpec.getSize(widthMeasureSpec);
		int height= MeasureSpec.getSize(heightMeasureSpec);
		int ChildCount=this.getChildCount();
		//测量出子控件进行改变
		for(int i=0;i<ChildCount;i++){
			View child=this.getChildAt(i);//每一个子控件
			ViewGroup.LayoutParams layoutParams=child.getLayoutParams();
			//解析自定义的宽高，进行替换
			float widthPercent=0;
			float heightPercent=0;
			if (layoutParams instanceof LayoutParams) {
				widthPercent=((LayoutParams) layoutParams).getWidthPercent();
				heightPercent=((LayoutParams) layoutParams).getHeightPercent();
			}
			if (widthPercent!=0) {
				layoutParams.width=(int)(width*widthPercent);
			}
			if(heightPercent!=0){
				layoutParams.height=(int)(height*heightPercent);
			}
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	public ScrollView.LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MyScrollView.LayoutParams(getContext(),attrs);
	}
	public static class LayoutParams extends ScrollView.LayoutParams {
		float widthPercent;
		float heightPercent;

		public float getWidthPercent() {
			return widthPercent;
		}

		public void setWidthPercent(float widthPercent) {
			this.widthPercent = widthPercent;
		}

		public float getHeightPercent() {
			return heightPercent;
		}

		public void setHeightPercent(float heightPercent) {
			this.heightPercent = heightPercent;
		}

		public LayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);
			TypedArray array = c.obtainStyledAttributes(attrs, R.styleable.percentRelativelayout);
			widthPercent = array.getFloat(R.styleable.percentRelativelayout_layout_widthPercent, 0);
			heightPercent = array.getFloat(R.styleable.percentRelativelayout_layout_heightPercent, 0);
			array.recycle();
		}

		public LayoutParams(int w, int h) {
			super(w, h);
			// TODO Auto-generated constructor stub
		}

		public LayoutParams(ViewGroup.LayoutParams source) {
			super(source);
			// TODO Auto-generated constructor stub
		}

		@SuppressLint("NewApi")
		public LayoutParams(android.widget.RelativeLayout.LayoutParams source) {
			super(source);
			// TODO Auto-generated constructor stub
		}

		public LayoutParams(MarginLayoutParams source) {
			super(source);
			// TODO Auto-generated constructor stub
		}

	}
}