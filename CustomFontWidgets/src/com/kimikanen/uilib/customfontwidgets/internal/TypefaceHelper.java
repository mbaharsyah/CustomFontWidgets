package com.kimikanen.uilib.customfontwidgets.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

public class TypefaceHelper {
	
	private LruCache<String, Typeface> fontCache;
	
	private static TypefaceHelper instance;
	
	public static synchronized TypefaceHelper getInstance() {
		if (instance == null) {
			instance = new TypefaceHelper();
		}
		return instance;
	}
	
	private TypefaceHelper() {
		fontCache = new LruCache<String, Typeface>(5);
	}
	
	public Typeface getTypeface(Context context, String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Argument cannot be null or empty string");
		}
		
		Typeface retval = fontCache.get(name);
		if (retval == null) {
			retval = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s.ttf", name));
			
			if (retval == null) {
				throw new IllegalArgumentException(String.format("File fonts/%s.ttf cannot be found in asset", name));
			}
			
			fontCache.put(name, retval);
		}
		
		return retval;
	}
	
	

}
