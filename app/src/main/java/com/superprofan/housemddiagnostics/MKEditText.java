package com.superprofan.housemddiagnostics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * attaching image to edittext
 */

public class MKEditText extends AppCompatEditText {

    public interface IconClickListener{
        void onClick();
    }
    private IconClickListener mIconClickListener;
    private static final String TAG = MKEditText.class.getSimpleName();
    private final int EXTRA_TOUCH_AREA = 50;
    private Drawable mDrawable;
    private boolean touchDown;

    /**
    * constructors
    */
    public MKEditText(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    public MKEditText(Context context) {
        super(context);
    }
    public MKEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    /**
     * display icon on the right
     */
    public void showRightIcon(){
        mDrawable = ContextCompat.getDrawable(getContext(), R.drawable.etbutton);
        setIcon();
    }
    /**
     * not sure what the drawables here do
     */
    private void setIcon() {
        Drawable[] drawables = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], mDrawable,
                drawables[3]);

        //here you can set different kinds of text variation

        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
        setSelection(getText().length());
    }
    /**
     * to do something with the icon
     */
    public void setIconClickListener(IconClickListener iconClickListener) {
        mIconClickListener = iconClickListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int right = getRight();
        final int drawableSize = getCompoundPaddingRight();
        final int x = (int) event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (x + EXTRA_TOUCH_AREA >= right - drawableSize && x <= right + EXTRA_TOUCH_AREA)
                {
                    touchDown = true;
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (x + EXTRA_TOUCH_AREA >= right - drawableSize && x <= right + EXTRA_TOUCH_AREA
                        && touchDown) {
                    touchDown = false;
                    if (mIconClickListener != null) {
                        mIconClickListener.onClick();
                    }
                    return true;
                }
                touchDown = false;
                break;
        }
        return super.onTouchEvent(event);
    }

}
