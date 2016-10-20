package Arrays;

import java.util.Arrays;

//Runtime of O(nlogn)
public class IceCreamBinarySearch {
    public static void main(String[] args) {
        int[] iceCreams = new int[]{2,7,13,5,4,13,5};
        int[] result = getIceCreamsIndices(iceCreams, 18);
        if(result != null && result.length > 0) {
            System.out.print("[ ");
            for(int i : result) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
    }

    public static int[] getIceCreamsIndices(int[] menu, int cost) {
        if(menu == null || menu.length == 0) {
            return new int[0];
        }
        MenuItem[] items = new MenuItem[menu.length];

        int i = 0;
        for(int ice : menu) {
            items[i] = new MenuItem(i++, ice);
        }

        Arrays.sort(menu);
        int[] result = new int[2];
        int index = 0;
        int index1 = 0;
        int index2 = 0;

        for(int ice : menu) {
            index = getMenuItem(menu, cost - ice);
            if(index >= 0) {
                index1 = getIndex(ice, items, -1);
                index2 = getIndex(cost - ice, items, result[0]);
                result = new int[]{Math.min(index1, index2), Math.max(index1, index2)};
                return result;
            }
        }
        return null;
    }

    public static int getMenuItem(int[] menu, int cost) {
        int low = 0;
        int high = menu.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(menu[mid] == cost) {
                return mid;
            }
            else if(menu[mid] < cost) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int getIndex(int ice, MenuItem[] items, int exclude) {
        for(MenuItem m : items) {
            if(m.cost == ice && m.index != exclude) {
                return m.index;
            }
        }
        return -1;
    }
}

class MenuItem {
    public int index;
    public int cost;

    public MenuItem(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }   
}