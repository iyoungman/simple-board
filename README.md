## About
* 간단한 게시판을 이용해 Front - Backend - DevOps 구축 연습하기


## Skill

> Front
* Vue
* BootStrap

<br>

> Backend 
* Spring
* GraphQL
* MongoDB
    * Sharding
* EmbeddedMongoDB

<br>

> Infra
* Docker
* Jenkins
* Kubernetes
* NCloud
* AWS
* NGrinder

<br>

> Option
* Security
* Kafka
    * 비동기 이메일 발송

***

## Query

```graphql
mutation($input: PostsSaveInput) {
  savePosts(input: $input) {
    	id
   		title 
  }
}


{
  "input": {
    "title": "title",
    "content": "content",
    "author": "author"
  }
}
```

```graphql
query {
  getPosts(id: "5efc551782fd157930458b72") {
   		title 
  }
}
```

```graphql
query {
  getPagingPosts(page: 1) {
   		id
  }
}
```
