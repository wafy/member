# 과제 풀이

## 1번 풀이  

* 스프링배치사용
  * 스프링배치 로깅/추적, 트랜잭션관리, 처리 통계, 리소스관리등 자체 제공 
  * 스프링배치 사용시 처리실패지점부터 실행을 함. 
  * 배치 상태관리는 메티테이블에서 이루어지므로 해당테이블을 생성하여 관리한다. (그림1-1) 
   

* 그림1-1 메타테이블
![메타테이블](https://user-images.githubusercontent.com/310264/183274016-5e0a5349-a757-4190-af9d-b928667df3d0.png)


## 2번 풀이 
* 1번과 동일한 기술을 사용할것입니다.
* 이전 스케줄링이 완료되지 않았으면 대기후 이후 진행하도록 설정

## 3번 풀이 
* redis캐쉬를 사용하여 동일한 요청이 올경우 처리하지 않도록 하겠습니다. 

## 4번 풀이
php를 운영해보지 못해 정확한 답변이 될지 므로지만 일단 아래와 같은 순서로 진행을 할거같습니다.
1. aws 사용한다면 모니터링 툴로 cpu 및 메모리 사용율 체크 
2. datadog등 apm 툴로 http 요청 및 응답 로그 확인
3. php-fpm 으로 프로세스 처리 상태 확인  
4. ngix 로그 분석하여 대량 접속 요청 IP 확인 
5. 리눅스 방화벽에서 해당 IP 차단


## 5번 풀이 
* 클린아키텩처의 소리치는 아키텍처를 응용하여 패키지 구조를 구성하였습니다. 
* 명령과 쿼리 부분을 분리하고 서비스객체의 의존성을 최대한 줄여 단일책임 원칙과 테스트를 용이하게 하였습니다.
* 프로젝트 구조 
  * config : 공통 설정
  * core : 핵심로직
    * member 
      * command : 회원가입 
      * query : 회원조회
    * unconnected
      * command : 장기미사용 등록 
      * query : 장기미사용 조회
  * web :http 처리 요청 
    * v1
      * admin 
* 특정사용자(프로젝트에서는 3개월 미로그인 사용자)를 조회하여 맴버테이블에서는 소프트딜리트를 사용하여 업데이트하고 미사용테이블에 입력하는 방법을 구성하였습니다.
* 대용량처리를 위해 병렬 처리를 사용하였습니다. (ForkJoinPool)
* last_login_time에 인덱스를 추가하였습니다.
* 현재는 모놀릭으로 처리하여 조회가 입력이 동시에 이루어지지만 고도화를 한다고 가정하면 카프카를 사용하여 발행과 컨슈머를 나누어서 개발할거 같습니다. 