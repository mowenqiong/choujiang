package com.cn.choujiang;

import java.util.ArrayList;
import java.util.List;

/**
 * 奖
 * 
 * @author MoWenqiong
 * 2015-7-4
 */
public class LuckyNum {
	private List<Integer> periodList = new ArrayList<Integer>();//所在区间
	private Integer start;//最小号码
	private Integer end;//最大号码
	private List<Integer> nums = new ArrayList<Integer>();//特殊号码
	private String level;//奖项等级
	private String name;//奖项名称
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Integer> getPeriodList() {
		return periodList;
	}
	public void setPeriodList(List<Integer> periodList) {
		this.periodList = periodList;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public List<Integer> getNums() {
		return nums;
	}
	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}
	@Override
	public String toString() {
		String s = "";
		String s1 = "";
		for (int i = 0; i < periodList.size(); i++) {
			s1 += periodList.get(i)+",";
		}
		s = "区间 = " + s1;
		s = s + "start = " +start +",end = " + end + ",";
		String s2 = "";
		for (int i = 0; i < nums.size(); i++) {
			s2 += nums.get(i)+",";
		}
		
		s = s + "nums = " + s2 + "level = " + level + ",name = " + name;
		
		return s;
	}
	
}
