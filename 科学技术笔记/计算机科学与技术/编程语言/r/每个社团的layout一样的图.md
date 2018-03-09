
```
library(igraph)
library(igraphdata)

layout_community <-
  function(graph,
           community_algorithm,
           layout_desired) {
    if (!is_igraph(graph)) {
      stop("Not a graph object")
    }
    
    ## detect the community
    graph_commmunity <- community_algorithm(graph)
    
    ## get the membership
    graph_membership <- membership(graph_commmunity)
    
    ## get the vertex label in each membership
    graph_vertex_list <-
      lapply(1:max(graph_membership), function(x) {
        which(graph_membership == x)
      })
    
    ## split the network according to the community structure
    split_community <-
      lapply(graph_vertex_list, function(x) {
        induced_subgraph(graph, x)
      }) ## the vertex name will be renamed
    
    ## get the layout for each sub network
    layouts <- lapply(split_community, layout_desired)
    
    ## combine the layout all the sub network
    lay <- merge_coords(split_community, layouts)
    
    ## the final outputs
    lay <- cbind(unlist(graph_vertex_list), sort(graph_membership), lay)
    colnames(lay) <-
      c("vertex_label", "community_mem", "coord1", "coord2")
    lay <- lay[order(lay[, 1]), ]
    return(lay)
  }

karate <- make_graph("Zachary")

lay = layout_community(karate, infomap.community, layout.star)

plot(
  karate,
  layout = lay[, 3:4],
  vertex.size = 8,
  edge.color = "red",
  vertex.color = lay[, 2]
)
```