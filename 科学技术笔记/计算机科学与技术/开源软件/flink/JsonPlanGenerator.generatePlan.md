{
  "jid": "8ae3c1443d44142c861257df1fb2846c",
  "name": "Streaming WordCount",
  "nodes": [
    {
      "id": "b5c8d46f3e7b141acf271f12622e752b",
      "parallelism": 4,
      "operator": "",
      "operator_strategy": "",
      "description": "Keyed Aggregation -&gt; Sink: Unnamed",
      "inputs": [
        {
          "num": 0,
          "id": "20ba6b65f97481d5570070de90e4e791",
          "ship_strategy": "HASH",
          "exchange": "pipelined_bounded"
        }
      ],
      "optimizer_properties": {}
    },
    {
      "id": "20ba6b65f97481d5570070de90e4e791",
      "parallelism": 4,
      "operator": "",
      "operator_strategy": "",
      "description": "Split Reader: Custom File Source -&gt; Flat Map",
      "inputs": [
        {
          "num": 0,
          "id": "bc764cd8ddf7a0cff126f51c16239658",
          "ship_strategy": "REBALANCE",
          "exchange": "pipelined_bounded"
        }
      ],
      "optimizer_properties": {}
    },
    {
      "id": "bc764cd8ddf7a0cff126f51c16239658",
      "parallelism": 1,
      "operator": "",
      "operator_strategy": "",
      "description": "Source: Custom File Source",
      "optimizer_properties": {}
    }
  ]
}