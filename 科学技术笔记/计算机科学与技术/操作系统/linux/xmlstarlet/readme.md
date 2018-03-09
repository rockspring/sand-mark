# xmlstarlet

## sel Select from XML document(s)

```
cat pom.xml |sed 's/xmlns="[^"]*"//g' > pom.no-ns.xml
xmlstarlet sel -E utf-8 -t -c //modelVersion -b pom.no-ns.xml

xmlstarlet sel -E utf-8 -t -c /project/dependencies/dependency -b pom.no-ns.xml
xmlstarlet sel -E utf-8 -t -c /project/dependencies/dependency[2] -b pom.no-ns.xml
```
