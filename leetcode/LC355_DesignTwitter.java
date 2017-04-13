package leetcode;

import java.util.*;

public class LC355_DesignTwitter {
    public class Twitter {
        private Map<Integer, Set<Integer>> graph;
        private Map<Integer, List<Integer>> tweetsByUser;
        private Map<Integer, Tweet> tweets;
        private int time;
        
        private class Tweet implements Comparable<Tweet> {
            int id, time;
            Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
            @Override
            public int compareTo(Tweet that) {
                return this.time - that.time;
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
            graph = new HashMap<Integer, Set<Integer>>();
            tweetsByUser = new HashMap<Integer, List<Integer>>();
            tweets = new HashMap<Integer, Tweet>();
            time = 0;
        }
        
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            registerUser(userId);
            tweetsByUser.get(userId).add(tweetId);
            tweets.put(tweetId, new Tweet(tweetId, time++));
        }
        
        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            registerUser(userId);
            PriorityQueue<Tweet> queue = new PriorityQueue<>();
            addTweetsToFeed(queue, userId);
            for (int followeeId : graph.get(userId)) {
                addTweetsToFeed(queue, followeeId);
            }
            List<Integer> feed = new ArrayList<>();
            while (!queue.isEmpty()) {
                feed.add(queue.poll().id);
            }
            Collections.reverse(feed);
            return feed;
        }
        
        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                registerUser(followerId);
                registerUser(followeeId);
                graph.get(followerId).add(followeeId);
            }
        }
        
        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                if (graph.containsKey(followerId) && graph.get(followerId).contains(followeeId)) {
                    graph.get(followerId).remove(followeeId);
                }
            }
        }
        
        private void registerUser(int userId) {
            if (!tweetsByUser.containsKey(userId)) {
                tweetsByUser.put(userId, new ArrayList<Integer>());
            }
            if (!graph.containsKey(userId)) {
                graph.put(userId, new HashSet<Integer>());
            }
        }
        
        private void addTweetsToFeed(PriorityQueue<Tweet> queue, int userId) {
            int size = tweetsByUser.get(userId).size();
            int len = Math.min(10, size);
            for (int i = size - 1; len > 0; i--, len--) {
                int tweetId = tweetsByUser.get(userId).get(i);
                queue.add(tweets.get(tweetId));
                if (queue.size() > 10) {
                    queue.poll();
                }
            }
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
