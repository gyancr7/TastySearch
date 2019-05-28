# TastySearch
How to run:
Add Application configuration as:
1. TastySearch as Main Class
2. server /config.yaml as program arguments. 

Server will run on port 9000

Parameters for POST API:
```
{
	"query_tokens": ["I", "are", "the"], (list of query tokens)
	"k": 15, (top k number of documents)
	"file_path": "/Users/gyanendrapratap/Downloads/foods.txt" (path to the data file)
}
```

Api to get top ```k``` documents as per requirement for given query:
```
curl -X POST \
  http://localhost:9000/tasty-search/v1/get-top-k-documents \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: e7c306aa-8875-4729-b8ca-4c5487a50dc1' \
  -H 'cache-control: no-cache' \
  -d '{
	"query_tokens": ["I", "are", "the"],
	"k": 15,
	"file_path": "/Users/gyanendrapratap/Downloads/foods.txt"
}'
```

The jar is present inside the target folder of the repo.
Command to run the jar:
```java -jar TastySearch-1.0-SNAPSHOT.jar server /path_to_config.yaml file```

Once the jar is running API can be hit via Postman or browser at: 
```http://localhost:9000/tasty-search/v1/get-top-k-documents```.

Result: Top ```k``` documents based on the score calculated as per the given requirement
