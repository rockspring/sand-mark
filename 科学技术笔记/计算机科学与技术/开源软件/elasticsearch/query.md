# 查询处理流程

MessageChannelHandler$RequestHandler.run()

SearchServiceTransportAction$SearchQueryTransportHandler.messageReceived(ShardSearchRequest request, TransportChannel channel)

SearchService.executeQueryPhase(ShardSearchRequest request)

QueryPhase.execute(SearchContext searchContext)

IndexSearcher.search(Query query, int n)