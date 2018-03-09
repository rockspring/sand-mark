
```
install.packages("igraph")
library(igraph)
```


```
d = data.frame(p1     = c('a', 'b', 'c'),
               p2     = c('b', 'c', 'a'),
               weight = c(1, 2, 4))
g = graph.data.frame(d, directed = TRUE)
plot(g, edge.width = E(g)$weight)
```