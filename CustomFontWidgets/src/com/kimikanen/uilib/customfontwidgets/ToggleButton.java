package com.kimikanen.uilib.customfontwidgets;

import android.content.Context;
import android.util.AttributeSet;

import com.kimikanen.uilib.customfontwidgets.internal.FontStylist;

/**
 * A custom {@link android.widget.ToggleButton ToggleButton} that can be
 * configured to use a certain font from layout xml
 * 
 * Usage : <br>
 * 
 * <pre>
 * &lt;com.kimikanen.uilib.customfontwidgets.ToggleButton
 * 	android:layout_width="match_parent"
 * 	android:layout_height="wrap_content"
 * 	android:text="Roboto-Thin"
 * 	myapp:typeface="Roboto-Thin" /&gt;
 * </pre>
 * 
 * make sure the value of <code>myapp:typeface</code> is mapped to a file
 * fonts/&lt;value&gt;.ttf in assets folder
 * 
 * @author mbaharsyah
 */
public class ToggleButton extends android.widget.ToggleButton {

	public ToggleButton(Context context) {
		super(context);
		FontStylist.apply(this, null, 0);
	}

	public ToggleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		FontStylist.apply(this, attrs, 0);
	}

	public ToggleButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		FontStylist.apply(this, attrs, defStyle);
	}

}
