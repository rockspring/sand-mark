根据路径分化请求：
/admin/cores
handler = cores.getMultiCoreHandler();
solrReq = SolrRequestParsers.DEFAULT.parse(null, path, req);
handleAdminRequest(req, response, handler, solrReq);

/admin/collections
handler = cores.getCollectionsHandler();
solrReq = SolrRequestParsers.DEFAULT.parse(null, path, req);
handleAdminRequest(req, response, handler, solrReq);

/admin/info
handler = cores.getInfoHandler();
solrReq = SolrRequestParsers.DEFAULT.parse(null, path, req);
handleAdminRequest(req, response, handler, solrReq);
