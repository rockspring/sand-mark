

<updateHandler>

    <autoCommit>
           <maxDocs>50000</maxDocs>
           <maxTime>600000</maxTime>
           <openSearcher>true</openSearcher>
    </autoCommit>

    <autoSoftCommit>
           <maxTime>${solr.autoSoftCommit.maxTime:60000}</maxTime>
    </autoSoftCommit>

</updateHandler>