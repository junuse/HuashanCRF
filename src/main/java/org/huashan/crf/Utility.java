package org.huashan.crf;

import java.util.ArrayList;

public class Utility {

	private Integer	len = 0;
	private Integer cursor = 0;

	public Integer getCursor() {
		return cursor;
	}

	public void setCursor(Integer cursor) {
		this.cursor = cursor;
	}

	public Integer getLen() {
		return len;
	}

	public void setLen(Integer len) {
		this.len = len;
	}

	public void increase(Integer addition) {
		this.len = this.len + addition;
	}
	public Integer sum(Integer add1, Integer add2) {
		return add1 + add2;
	}
	public Integer step() {
		return this.cursor++;
	}
	public String checkInline(Integer cursor, Integer len, Integer threshold) {
		System.out.println("---------------this.cursor:"+this.cursor);
		System.out.println("this.len:"+this.len);
		System.out.println("cursor:"+cursor);
		System.out.println("addition:"+len);
		if (cursor < this.cursor) {
			System.out.println("skip");
			return "skip";
		}
		if (this.len + len <= threshold) {
			this.cursor = cursor;
			this.len += len;
			System.out.println("true");
			return "true";
		}
		System.out.println("false");
		return "false";
	}
	public ArrayList<ArrayList<String>> grouping(ArrayList<String> strings) {
		Integer len = 0;
		ArrayList<ArrayList<String>> stringArrays = new ArrayList<ArrayList<String>>();
		ArrayList<String> stringArray = new ArrayList<String>();
		for (String string : strings) {
			Integer myLen = (string.length() + 6) / 3;
//			System.out.println("current len:" + len + ",mylen:" + myLen);
			if ( len + myLen > 11 ) {
				if (stringArray.isEmpty()) {
					System.out.println("第一个就放不下");
					return stringArrays;
				}
//				System.out.println("exceed! store and new array:" + stringArray);
				stringArrays.add(stringArray);
				stringArray = new ArrayList<String>();
				len = 0;
			}
			stringArray.add(string);
			len += myLen;
		}
		if (!stringArray.isEmpty()) {
			stringArrays.add(stringArray);
		}
//		System.out.println(stringArrays);
		return stringArrays;
	}
}