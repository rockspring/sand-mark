The Overseer isn't mentioned much because it's an implementation
detail that the user doesn't have to really consider.

The Overseer first came about to handle writing the clusterstate.json
file, as a suggestion by Ted Dunning.

Originally, each node would try and update the custerstate.json file
themselves - and use optimistic locking and retries.

We decided that a cleaner method was to have an overseer and let new
nodes register themselves and their latest state as part of a list -
the Overseer then watches this list, and when things change, publishes
a new clusterstate.json - no optimistic locking and retries needed.
All the other nodes watch clusterstate.json and are notified to
re-read it when it changes.

Since, the Overseer has picked up a few other duties when it makes
sense. For example, it handles the shard assignments if a user does
not specify them. It also does the work for the collections api -
eventually this will be beneficial in that it will use a distributed
work queue and be able to resume operations that fail before
completing.

I think over time, there are lots of useful applications for the Overseer.

He is elected in the same manner as a leader for a shard - if the
Overseer goes down, someone simply takes his place.

I don't think the Overseer is going away any time soon.






###########################################################################
Cluster leader. Responsible node assignments, cluster state file?