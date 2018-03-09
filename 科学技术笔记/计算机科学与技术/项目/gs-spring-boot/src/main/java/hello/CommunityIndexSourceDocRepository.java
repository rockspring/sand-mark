package hello;

import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by zlq on 6/3/15.
 */
public interface CommunityIndexSourceDocRepository extends SolrCrudRepository<CommunityIndexSourceDoc, Integer> {
}
