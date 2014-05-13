package com.kimikanen.uilib.customfontwidgets;

import com.kimikanen.uilib.customfontwidgets.internal.TypefaceHelper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

/**
 * A custom {@link android.widget.Switch Switch} that can be configured to
 * use a certain font from layout xml
 * 
 * Usage : <br>
 * 
 * <pre>
 * &lt;com.kimikanen.uilib.customfontwidgets.Switch
 * 	android:layout_width="match_parent"
 * 	android:layout_height="wrap_content"
 * 	android:text="Roboto-Thin"
 * 	myapp:typeface="Roboto-Thin" /&gt;
 * </pre>
 * 
 * make sure the value of
 * <code>myapp:typeface</code> is mapped to a file fonts/&lt;value&gt;.ttf in assets folder
 * 
 * @author mbaharsyah
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) 
public class Switch extends android.widget.Switch {

	public Switch(Context context) {
		super(context);
		setFont(context, null, 0);
	}

	public Switch(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFont(context, attrs, 0);
	}

	public Switch(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setFont(context, attrs, defStyle);
	}

	private void setFont(Context context, AttributeSet attrs, int defStyle) {
		// avoid the GUI tool having a problem
		if (isInEditMode()) {
			return;
		}

		// TODO define default
		String asset = "Roboto-Regular";

		if (attrs != null) {
			TypedArray values = context.obtainStyledAttributes(attrs,
					R.styleable.FontStyleable, defStyle, 0);
			if (values != null) {
				asset = values.getString(R.styleable.FontStyleable_typeface);
				values.recycle();
			}
		}

		final Typeface typeface = TypefaceHelper.getInstance().getTypeface(
				context, asset);
		setTypeface(typeface);
	}

}
