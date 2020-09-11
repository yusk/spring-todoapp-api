# README

https://qiita.com/kiri__n/items/e664c8d033e611e8260b

## run

```bash
./gradlew bootRun
```

## check

```bash
curl http://localhost:8080/api/todo -XPOST -H 'Content-Type: application/json' -d '{"summary": "my first task"}' | jq .
curl http://localhost:8080/api/todos | jq .
curl http://localhost:8080/api/todo/1 | jq .
curl http://localhost:8080/api/todo/1 -XDELETE -v
```
