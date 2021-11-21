## 스프링 배치

### 메타 테이블
----
![image](https://user-images.githubusercontent.com/76584547/142753272-f6efd792-e67d-48ac-a6db-38c40641b95e.png)

#### BATCH_JOB_INSTANCE
----
```
  Job이 실행되면 BATCH_JOB_INSTANCE에 새로운 row를 만든다. Job의 이름과 Job이 시작될때 넘겨받은 파라미터를 Serialize (직렬화) 해서 저장한다. 
  BATCH_JOB_INSTANCE 테이블은 Job Parameter에 따라 생성되는 테이블입니다.
```
![image](https://user-images.githubusercontent.com/76584547/142753552-2c1ce02f-48b7-498b-ba0a-0c1f2cc77b65.png)



#### BATCH_JOB_EXECUTION
----
```
  Job 실행 내용을 담고 있다. Job의 실패 + 성공 횟수만큼 row가 생성된다. 
  JOB_EXECUTION와 JOB_INSTANCE는 부모-자식 관계입니다.
  JOB_EXECUTION은 자신의 부모 JOB_INSTACNE가 성공/실패했던 모든 내역을 갖고 있습니다.
```
![image](https://user-images.githubusercontent.com/76584547/142753402-e7ba7f36-06b9-4a06-a9f6-887487e41a7d.png)

### 참고
---
```
  https://jojoldu.tistory.com/326
  https://www.fwantastic.com/2019/12/spring-batch-2-metadata-jobrepository.html
```
