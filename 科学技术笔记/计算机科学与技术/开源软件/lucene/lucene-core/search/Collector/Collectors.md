# Collectors

Collectors are primarily meant to be used to gather raw results from a search, and implement sorting or custom result filtering, collation, etc.

## TopDocsCollector

抽象基类

根据条件检索出前N个文档

## TopScoreDocCollector

IndexSearcher内部使用，没有指定排序规则时使用

根据条件检索出前N个文档，根据score+id排序

## TopFieldCollector

IndexSearcher内部使用，显式指定排序规则时使用

根据条件检索出前N个文档，根据field排序

## TimeLimitingCollector

wraps any other Collector and aborts the search if it's taken too much time.

## PositiveScoresOnlyCollector

wraps any other Collector and prevents collection of hits whose score <0.0