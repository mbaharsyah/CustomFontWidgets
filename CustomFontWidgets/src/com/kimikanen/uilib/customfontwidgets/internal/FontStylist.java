package com.kimikanen.uilib.customfontwidgets.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.kimikanen.uilib.customfontwidgets.R;

public final class FontStylist {

	public static void apply(TextView view, AttributeSet attrs, int defStyle) {
		// avoid the GUI tool having a problem
		if (view.isInEditMode()) {
			return;
		}

		final Context context = view.getContext();

		if (attrs != null) {
			final TypedArray values = context.obtainStyledAttributes(attrs,
					R.styleable.FontStyleable, defStyle, 0);
			
			if (values != null) {
				final String asset = values
						.getString(R.styleable.FontStyleable_typeface);
				values.recycle();

				if (asset != null) {
					final Typeface typeface = TypefaceHelper.getInstance()
							.getTypeface(context, asset);
					view.setTypeface(typeface);
				}
			}
		}
	}

}
