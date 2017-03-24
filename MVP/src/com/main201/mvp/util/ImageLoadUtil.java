package com.main201.mvp.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ImageLoadUtil {
	private static Bitmap.Config config = Bitmap.Config.RGB_565;
	
	public static void show(Context context,String url,ImageView iv,int defRes,int w,int h){
		if(verify(url) && iv!=null){
			Picasso.with(context.getApplicationContext()).load(url)
			.placeholder(defRes)
			.error(defRes)
			.resize(w, h)
			.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
			.config(config)
			.into(iv);
		}
	}
	
	public static void show(Context context,String url,ImageView iv,int defRes){
		if(verify(url) && iv!=null){
			Picasso.with(context.getApplicationContext()).load(url)
			.placeholder(defRes)
			.error(defRes)
			.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
			.config(config)
			.into(iv);
		}
	}
	public static void show(Context context,String url,ImageView iv){
		if(verify(url) && iv!=null){
			Picasso.with(context.getApplicationContext()).load(url)
			.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
			.config(config)
			.into(iv);
		}
		
	}
	
	private static boolean verify(String url){
		if(url!=null && url.length()>0){
			return true;
		}
		return false;
	}
}
