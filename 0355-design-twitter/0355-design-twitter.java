class Twitter {

    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> following = new HashMap<>();
    int time = 0;

    class Tweet
    {
        int tweetId;
        int time;

        Tweet(int tweetId, int time)
        {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class HeapNode
    {
        Tweet tweet;
        int userId;
        int index;

        HeapNode(Tweet tweet, int userId, int index)
        {
            this.tweet = tweet;
            this.userId = userId;
            this.index = index;
        }
    }

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId, time++);
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(t);;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.tweet.time, a.tweet.time));
        Set<Integer> tempFollow = following.get(userId);
        List<Tweet> ownTweet = tweets.get(userId);
        if(ownTweet != null)
            maxHeap.offer(new HeapNode(ownTweet.get(ownTweet.size() - 1), userId, ownTweet.size() - 1));
        if(tempFollow != null)
        {    
            for(int currUser : tempFollow)
            {
                List<Tweet> temp = tweets.get(currUser);
                if(temp != null && !temp.isEmpty())
                    maxHeap.offer(new HeapNode(temp.get(temp.size() - 1), currUser, temp.size() - 1));
            }
        }
        while(!maxHeap.isEmpty() && result.size() < 10)
        {
            HeapNode node = maxHeap.poll();
            result.add(node.tweet.tweetId);
            if(node.index > 0)
            {
                Tweet tweet = tweets.get(node.userId).get(node.index - 1);
                maxHeap.offer(new HeapNode(tweet, node.userId, node.index - 1));
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
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