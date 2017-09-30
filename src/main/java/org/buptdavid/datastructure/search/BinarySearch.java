package org.buptdavid.datastructure.search;

/**
 * 二分查找的实现： 在一个有序数组中查找某个值
 * @author weijielu
 * @see BinarySearchTest
 * 要求线性表有序，且插入删除困难。时间复杂度为log2n
 */
public class BinarySearch {
	
	/**
	 * 使用循环的方式实现二分查找
	 * @param array
	 * @param value
	 * @return
	 */
	public static Integer searchCirculation(int[] array, int value){
		int low = 0;
		int high = array.length - 1;
		int middle;
		
		while(low <= high){
			middle = (low + high) / 2;
			if(value < array[middle]){
				high = middle - 1;
			}else if(value > array[middle]){
				low = middle + 1;
			}else{
				return array[middle];
			}
		}
		
		return null;
	}
	
	/**
	 * 使用递归的方式实现二分查找
	 * @param array
	 * @param value
	 * @return
	 * 不采用递归调用方式，空间复杂度太高
	 */
	public static Integer searchRecursive(int[] array, int value){
		return searchRecursive(array, value, 0, array.length - 1);
	}
	
	private static Integer searchRecursive(int[] array, int value, int low, int high){
		if(high < low){
			return null;
		}
		
		int middle = (low + high) / 2;
		
		if(value < array[middle]){
			return searchRecursive(array, value, low, middle - 1);
		}else if(value > array[middle]){
			return searchRecursive(array, value, middle + 1, high);
		}else {
			return array[middle];
		}
	}

}
