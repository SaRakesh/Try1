package com.parser.stringsprite.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class JsonData implements Serializable {
	public static final long serialVersionUID = 44L;
	private String from;
	private String to;
	private String[] speaktag;
	private transient String newArg;
	private MyEnum en;

	public JsonData(String from, String to, MyEnum en, String[] speaktag) {
		super();
		this.from = from;
		this.to = to;
		this.speaktag = speaktag;
		this.en = en;
	}

	public MyEnum getEn() {
		return en;
	}

	public void setEn(MyEnum en) {
		this.en = en;
	}

	public String getNewArg() {
		return newArg;
	}

	public void setNewArg(String newArg) {
		this.newArg = newArg;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String[] getSpeaktag() {
		return speaktag;
	}

	public void setSpeaktag(String[] speaktag) {
		this.speaktag = speaktag;
	}

	@Override
	public String toString() {
		return "JsonData [from=" + from + ", to=" + to + ", speaktag=" + Arrays.toString(speaktag) + ", newArg="
				+ newArg + ", en=" + en.myFunction()+" en"+en + "]";
	}

}
