package Arrays;

import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class GreatestNumber {

	public static void main(String[] args) {
		int[] nums1 = {3, 4};
		int[] nums2 = {1, 1, 9};
		int k = 5;

		System.out.println("The greatest number possible is := ");
		int[] result = new GreatestNumber().maxNumber(nums1, nums2, k);

		for(int n: result) {
			System.out.print(n + ", ");
		}
	}

	class Num {
		int value;
		int list;
		int index;

		public Num(int value, int list, int index) {
			this.value = value;
			this.list = list;
			this.index = index;
		}

		public String toString() {
			return this.value  + "-> " + this.list + "-> " + this.index;
		}
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		int rIndex = 0;
		int mIndex = -1;
		int nIndex = -1;
		int mLength = nums1.length - 1;
		int nLength = nums2.length - 1;

		PriorityQueue<Num> cur = new PriorityQueue<>((a, b) -> (b.value - a.value));
		PriorityQueue<Num> backLog = new PriorityQueue<>((a, b) -> (b.value - a.value));

		for(int i = 0; i <= mLength; ++i) {
			cur.offer(new Num(nums1[i], 0, i));
		}

		for(int i = 0; i <= nLength; ++i) {
			cur.offer(new Num(nums2[i], 1, i));
		}

		Num c = null;
		Num b = null;

		while(rIndex < k) {
			if(!cur.isEmpty()) {
				c = cur.poll();
			}

			if(!backLog.isEmpty()) {
				b = backLog.poll();
			}

			if(b == null) {
				if(c.list == 0 && c.index > mIndex && (mLength - c.index + nLength - nIndex >= k - 1 - rIndex)) {
					result[rIndex++] = c.value;
					mIndex = c.index;
				} else if(c.list == 1 && c.index > nIndex && (nLength - c.index + mLength - mIndex >= k - 1 - rIndex)) {
					result[rIndex++] = c.value;
					nIndex = c.index;
				} else {
					backLog.offer(c);
				}	
			} else if(c == null) {
				if(b.list == 0 && b.index > mIndex && (mLength - b.index + nLength - nIndex >= k - 1 - rIndex)) {
					result[rIndex++] = b.value;
					mIndex = b.index;
				} else if(b.list == 1 && b.index > nIndex && (nLength - b.index + mLength - mIndex >= k - 1 - rIndex)) {
					result[rIndex++] = b.value;
					nIndex = b.index;
				} else {
					cur.offer(b);
				}
			} else {
				if(c.value > b.value) {
					if(c.list == 0 && c.index > mIndex && (mLength - c.index + nLength - nIndex >= k - 1 - rIndex)) {
						result[rIndex++] = c.value;
						mIndex = c.index;
					} else if(c.list == 1 && c.index > nIndex && (nLength - c.index + mLength - mIndex >= k - 1 - rIndex)) {
						result[rIndex++] = c.value;
						nIndex = c.index;
					} else {
						if(b.list == 0 && b.index > mIndex && (mLength - b.index + nLength - nIndex >= k - 1 - rIndex)) {
							result[rIndex++] = b.value;
							mIndex = b.index;
						} else if(b.list == 1 && b.index > nIndex && (nLength - b.index + mLength - mIndex >= k - 1 - rIndex)) {
							result[rIndex++] = b.value;
							nIndex = b.index;
						}
						backLog.offer(c);
					}
				} else {
					if(b.list == 0 && b.index > mIndex && (mLength - b.index + nLength - nIndex >= k - 1 - rIndex)) {
						result[rIndex++] = b.value;
						mIndex = b.index;
					} else if(b.list == 1 && b.index > nIndex && (nLength - b.index + mLength - mIndex >= k - 1 -rIndex)) {
						result[rIndex++] = b.value;
						nIndex = b.index;
					} else {
						if(c.list == 0 && c.index > mIndex && (mLength - c.index + nLength - nIndex >= k - 1 - rIndex)) {
							result[rIndex++] = c.value;
							mIndex = c.index;
						} else if(c.list == 1 && c.index > nIndex && (nLength - c.index + mLength - mIndex >= k - 1 - rIndex)) {
							result[rIndex++] = c.value;
							nIndex = c.index;
						}
						cur.offer(b);
						b = null;
					}
				}

			}
		}
		return result;
	}
}