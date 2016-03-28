package com.eharmony.services.mymatchesservice.service.merger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.eharmony.services.mymatchesservice.rest.MatchFeedRequestContext;

@Component
public class FeedMergeStrategyManager {

    @Resource(name = "DefaultFeedMergeStrategy")
    private FeedMergeStrategy HBASE_FEED_ONLY_STRATEGY;

    @Resource(name = "HBaseRedisFeedMergeStrategy")
    private FeedMergeStrategy HBASE_WITH_REDIS_MERGE_STRATEGY;

    /*
     * Given the context, find the corresponding merging strategy
     */
    public FeedMergeStrategy getMergeStrategy(MatchFeedRequestContext requestContext) {

        switch (requestContext.getFeedMergeType()) {

        case HBASE_FEED_ONLY:
            return HBASE_FEED_ONLY_STRATEGY;

        case HBASE_FEED_WITH_MATCH_MERGE:
            return HBASE_WITH_REDIS_MERGE_STRATEGY;
        }

        return HBASE_FEED_ONLY_STRATEGY;

    }
}