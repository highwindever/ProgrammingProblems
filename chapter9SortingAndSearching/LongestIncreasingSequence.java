package chapter9SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LongestIncreasingSequence {
	public class HtWt{
		public int height;
		public int weight;
		
		public HtWt(int height, int weight){
			this.height = height;
			this.weight =weight;
		}
	}
	
	public static void main (String[] args){
		
		LongestIncreasingSequence lis = new LongestIncreasingSequence();

		HtWt hw3 = lis.new HtWt(56,10);
		HtWt hw5 = lis.new HtWt(60,20);
		HtWt hw1 = lis.new HtWt(65,60);
		HtWt hw6 = lis.new HtWt(68,30);
		HtWt hw2 = lis.new HtWt(70,40);
		HtWt hw4 = lis.new HtWt(75,21);
		HtWt hw7 = lis.new HtWt(76,22);
		HtWt hw8 = lis.new HtWt(77,23);
	
		lis.items =new ArrayList<HtWt>();
		lis.items.add(hw1);
		lis.items.add(hw2);
		lis.items.add(hw3);
		lis.items.add(hw4);
		lis.items.add(hw5);
		lis.items.add(hw6);
		lis.items.add(hw7);
		lis.items.add(hw8);
		
		Collections.sort(lis.items,lis.new HWComparator());
		lis.maxSeq = new ArrayList<HtWt>();
		lis.findMaxSeq(lis.items);
		for(HtWt hw:lis.maxSeq){
			System.out.println(hw.height+","+hw.weight);
		}
		
	}
	
	public class HWComparator implements Comparator<HtWt>{
		public int compare(HtWt hw1, HtWt hw2){
			if(hw1.height<hw2.height) return -1;
			else if (hw1.height==hw2.height) return 0;
			else return 1;
		}
	}
	
	
	ArrayList<HtWt> items;
	ArrayList<HtWt> curSeq; 
	ArrayList<HtWt> maxSeq;
	
	public void findMaxSeq(ArrayList<HtWt> seq){
		int curUnfit = 0;
		while(curUnfit<items.size()){
			ArrayList<HtWt> nextSeq = new ArrayList<HtWt>();
			int nextUnfit = fillNextSeq(curUnfit, nextSeq);
			maxSeq = seqWithMaxLength(maxSeq, nextSeq);
			if(nextUnfit==curUnfit) break;
			else curUnfit=nextUnfit;}
	}
	
	ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}
	
	
	int fillNextSeq(int curUnfit, ArrayList<HtWt> nextSeq){
		boolean flag =true;
		int nextUnfit = curUnfit;
		LinkedList<HtWt> ns = new LinkedList<HtWt>();
		ns.add(items.get(curUnfit));
		int nextWeight = items.get(curUnfit).weight;
		for(int i=curUnfit-1;i>=0;i--){
			if(items.get(i).weight<nextWeight) {
				ns.addFirst(items.get(i));
				nextWeight = items.get(i).weight;
			}
		}
		int prevWeight = items.get(curUnfit).weight;
		for(int j=curUnfit+1;j<items.size();j++){
			if(items.get(j).weight>prevWeight) {
				ns.add(items.get(j));
				prevWeight = items.get(j).weight;
			}
			else if(flag==true) {
				nextUnfit =j;
				System.out.println("unfit:"+items.get(j).weight);
				flag=false;
			}
		}
		nextSeq.addAll(ns);
		return nextUnfit;
		
	}
}
