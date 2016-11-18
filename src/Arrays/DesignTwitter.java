package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignTwitter {

    Map<Integer, Member> members;
    List<Tweet> tweets;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        members = new HashMap<>();
        tweets = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!members.containsKey(userId)) {
            Member m = new Member(userId);
            members.put(userId, m);
        }
        Tweet t = new Tweet(userId, tweetId);
        tweets.add(t);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if(!members.containsKey(userId)) {
            return feed;
        }
        Member user = members.get(userId);
        Tweet t = null;
        for(int i = tweets.size() - 1; i >= 0 && feed.size() < 10; --i) {
            t = tweets.get(i);
            if(t.userId == userId || (user.following != null && user.following.contains(t.userId))) {
                feed.add(t.tweetId);
            }
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!members.containsKey(followeeId)) {
            Member m = new Member(followeeId);
            members.put(followeeId, m);
        }

        if(!members.containsKey(followerId)) {
            Member m = new Member(followerId);
            members.put(followerId, m);
        }

        Member follower = members.get(followerId);
        follower.addFollowee(followeeId);
        return;
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Member follower = members.get(followerId);
        follower.removeFollowee(followeeId);
        return;
    }

    public static void main(String[] args) {
        DesignTwitter obj = new DesignTwitter();
        obj.postTweet(1, 5);
        List<Integer> param_2 = obj.getNewsFeed(1);
        System.out.println(param_2);
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        param_2 = obj.getNewsFeed(1);
        System.out.println(param_2);
        obj.unfollow(1 , 2);
        param_2 = obj.getNewsFeed(1);
        System.out.println(param_2);
    }
}

class Member {
    int id;
    Set<Integer> following;

    public Member(int id) {
        this.id = id;
        following = new HashSet<>();
    }

    public void addFollowee(int followee) {
        following.add(followee);
    }

    public void removeFollowee(int followee) {
        following.remove(followee);
    }
}

class Tweet {
    int userId;
    int tweetId;

    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}