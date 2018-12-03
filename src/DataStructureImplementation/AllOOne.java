package DataStructureImplementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class AllOOne {

    /** Initialize your data structure here. */
    private Bucket max, min;
    private Map<String, Bucket> map;
    private Map<Integer, Bucket> buckets;

    public AllOOne() {
        max = new Bucket(Integer.MAX_VALUE);
        min = new Bucket(Integer.MIN_VALUE);
        map = new HashMap<>();
        buckets = new HashMap<>();
        addBucket(max);
        addBucket(min);
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (key == null || key.length() == 0) return;
        Bucket cur, prev;
        if (!map.containsKey(key)) {
            if (buckets.containsKey(1)) {
                cur = buckets.get(1);
            } else {
                cur = new Bucket(1);
                addBucket(cur);
            }
            cur.keys.add(key);
            if (min == null || min.count == Integer.MIN_VALUE) {
                min = cur;
            }

            if (max == null || max.count == Integer.MAX_VALUE) {
                max = cur;
            }
        } else {
            prev = map.get(key);
            if (buckets.containsKey(prev.count + 1)) {
                cur = buckets.get(prev.count + 1);
            } else {
                cur = new Bucket(prev.count + 1);
                addBucket(cur);
            }
            
            if (max.equals(prev)) max = cur;
            prev.keys.remove(key);
            removeBucket(prev);
            cur.keys.add(key);
        }
        map.put(key, cur);
    }

    private void removeBucket(Bucket bucket) {
        if (bucket.keys != null && !bucket.keys.isEmpty()) return;
        if (bucket.prev != null && bucket.next != null) {
            bucket.prev.next = bucket.next;
            bucket.next.prev = bucket.prev;
        }

        buckets.remove(bucket.count);
        bucket = null;
    }

    private void addBucket(Bucket bucket) {
        Bucket prev, next;
        if (buckets.containsKey(bucket.count - 1)) {
            prev = buckets.get(bucket.count - 1);
            bucket.prev = prev;
            prev.next = bucket;
        }

        if (buckets.containsKey(bucket.count + 1)) {
            next = buckets.get(bucket.count + 1);
            bucket.next = next;
            next.prev = bucket;
        }
        buckets.put(bucket.count, bucket);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (key == null || key.length() == 0 || !map.containsKey(key)) return;
        Bucket cur, prev;
        cur = map.get(key);
        if (cur.count == 1) {
            if (max.equals(cur)) {
                max.count = Integer.MAX_VALUE;
            }
            
            if (min.equals(cur)) {
                min.count = Integer.MIN_VALUE;
            }
            
            cur.keys.remove(key);
            removeBucket(cur);
            map.remove(key);
        } else {
            if (buckets.containsKey(cur.count - 1)) {
                prev = buckets.get(cur.count - 1);
            } else {
                prev = new Bucket(cur.count - 1);
                addBucket(prev);
            }

            prev.keys.add(key);
            cur.keys.remove(key);
            removeBucket(cur);
            map.put(key, prev);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (max.count == Integer.MAX_VALUE || max.keys == null || max.keys.size() == 0) return "";
        return max.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (min.count == Integer.MIN_VALUE || min.keys == null || min.keys.size() == 0) return "";
        return min.keys.iterator().next();
    }

    public static void main(String[] args) {
        AllOOne allOOne = new AllOOne();
        allOOne.inc("1");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.inc("2");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.inc("2");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.inc("3");
        allOOne.inc("3");
        allOOne.inc("3");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.dec("3");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.dec("3");
        allOOne.dec("3");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
        allOOne.inc("2");
        System.out.println(allOOne.getMaxKey());
        System.out.println(allOOne.getMinKey());
    }
}

class Bucket {
    Set<String> keys;
    int count;
    Bucket prev;
    Bucket next;

    private Bucket() {
        keys = new HashSet<>();
        count = 0;
        prev = null;
        next = null;
    }

    Bucket(int count) {
        this();
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return count == bucket.count &&
                Objects.equals(keys, bucket.keys) &&
                Objects.equals(prev, bucket.prev) &&
                Objects.equals(next, bucket.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keys, count, prev, next);
    }
}
