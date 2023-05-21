package com.tripbook.tripbook.views.login.profile

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.tripbook.tripbook.R

class CustomEditText: AppCompatEditText, TextWatcher, View.OnTouchListener, View.OnFocusChangeListener{

    var clearDrawable: Drawable? = null
    private var focusChangeListener: OnFocusChangeListener? = null
    private var touchListener: OnTouchListener? = null

    // AppCompatEditText 클래스 상속의 경우 부모 클래스의 생성자 호출
    constructor(context: Context): super(context){
        init()
    }

    constructor(context: Context, attr: AttributeSet): super(context, attr){
        init()
    }

    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int): super(context, attr, defStyleAttr){
        init()
    }

    // X 버튼 추가, Touch, Focus, TextWatcher 리스너 추가
    private fun init(){
        val tempDrawable = ContextCompat.getDrawable(context, R.drawable.ic_clear)
        clearDrawable = DrawableCompat.wrap(tempDrawable!!)
        DrawableCompat.setTintList(clearDrawable!!, hintTextColors) // 힌트 색상에 drawable 맞춤
        clearDrawable!!.setBounds(0, 0, clearDrawable!!.intrinsicWidth, clearDrawable!!.intrinsicHeight)
        setClearIconVisible(false)


        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
        addTextChangedListener(this)
    }


    private fun setClearIconVisible(visible: Boolean){
        clearDrawable?.setVisible(visible, false)
        val right: Drawable? = if (visible)
            clearDrawable
        else
            null
        setCompoundDrawables(null, null, right, null)
    }

    // 텍스트 길이에 따라 X버튼 보이기 / 없애기
    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if(isFocused)
            setClearIconVisible(text!!.isNotEmpty())
    }
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun setOnFocusChangeListener(onFocusChangeListener: OnFocusChangeListener) {
        this.focusChangeListener = onFocusChangeListener
    }

    override fun setOnTouchListener(onTouchListener: OnTouchListener) {
        this.touchListener = onTouchListener
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        val x = motionEvent.x
        if(clearDrawable!!.isVisible && x > width - paddingRight - clearDrawable!!.intrinsicWidth){
            if(motionEvent.action == MotionEvent.ACTION_UP){
                error = null;
                text = null;
            }
            return true
        }

        return touchListener?.onTouch(view, motionEvent) ?: false
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(hasFocus)
            setClearIconVisible(text!!.isNotEmpty())
        else
            setClearIconVisible(false)

        focusChangeListener?.onFocusChange(view, hasFocus)
    }
}