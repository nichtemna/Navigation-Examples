package com.nichtemna.navagationexample.bottom_ios_style;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nichtemna.navagationexample.R;


/**
 * Created by Lina Shyshova on 09.03.16.
 */
public class NavigationButton extends LinearLayout implements View.OnClickListener {
    private boolean isChecked = false;
    private int mImageResource;
    private int mBgCheckedResource;
    private int mBgUncheckedResource;
    private int mTextColorUncheckedResource;
    private int mTextColorCheckedResource;
    private int mTextResource;
    private OnCheckedChangeListener mChangeListener;
    private Context mContext;

    private ImageView mImageView;
    private TextView mTextView;

    public NavigationButton(Context pContext) {
        super(pContext);
        LayoutInflater inflater = (LayoutInflater) pContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_nav_button, this, true);
        init(pContext);
        initViews();
    }

    public NavigationButton(Context pContext, AttributeSet pAttrs) {
        super(pContext, pAttrs);
        initAttrs(pContext, pAttrs);
        LayoutInflater inflater = (LayoutInflater) pContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_nav_button, this, true);
        init(pContext);
        initViews();
    }

    public NavigationButton(Context pContext, AttributeSet pAttrs, int pDefStyle) {
        super(pContext, pAttrs, pDefStyle);
        initAttrs(pContext, pAttrs);
        LayoutInflater inflater = (LayoutInflater) pContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_nav_button, this, true);
        init(pContext);
        initViews();
    }

    private void init(Context pContext) {
        mContext = pContext;
        setOnClickListener(this);
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.textView);

        updateButtonView();
    }

    private void updateButtonView() {
        mImageView.setImageDrawable(ContextCompat.getDrawable(mContext, mImageResource));
        mTextView.setText(mTextResource);
        mTextView.setVisibility(TextUtils.isEmpty(mContext.getString(mTextResource)) ? View.GONE : View.VISIBLE);
        changeApperance();
    }


    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NavigationButton, 0, 0);
        try {
            mImageResource = a.getResourceId(R.styleable.NavigationButton_image, R.drawable.empty);
            mBgCheckedResource = a.getResourceId(R.styleable.NavigationButton_bg_checked, R.drawable.empty);
            mBgUncheckedResource = a.getResourceId(R.styleable.NavigationButton_bg_unchecked, R.drawable.empty);
            mTextColorCheckedResource = a.getColor(R.styleable.NavigationButton_text_color_checked, 000000);
            mTextColorUncheckedResource = a.getColor(R.styleable.NavigationButton_text_color_unchecked, 000000);
            mTextResource = a.getResourceId(R.styleable.NavigationButton_text, R.string.empty_string);
        } finally {
            a.recycle();
        }
    }

    @Override
    public void onClick(View view) {
        if (!isChecked) {
            setChecked(true);
            if (mChangeListener != null) {
                mChangeListener.onCheckedChanged(this);
            }
        }
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
        changeApperance();
    }

    public void setResources(int textResId, int imageResId) {
        mTextResource = textResId;
        mImageResource = imageResId;
        updateButtonView();
    }

    /**
     * change background image from xml parameters
     */
    private void changeApperance() {
        setBackgroundResource(isChecked ? mBgCheckedResource : mBgUncheckedResource);
        mTextView.setTextColor(isChecked ? mTextColorCheckedResource : mTextColorUncheckedResource);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener changeListener) {
        mChangeListener = changeListener;
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(NavigationButton toggleImageButton);
    }
}