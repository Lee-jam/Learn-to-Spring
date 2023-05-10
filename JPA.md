# JPA 란
**Java Persistence API**  

JPA는 Hibernate의 기능을 스프링 프레임워크에 맞게 확장한 모듈로 기본적인 구조와 동작은 Hibernate 구현을 기반으로 하고 있다.

Persistence(영속성) : 어떤 데이터가 영구적으로 저장되도록 하는 성질  

Persistent Context : 흔히 1차 캐시라 불리며, DB로부터 로드되거나 로드할 엔티티를 관리하고 캐싱한다.  
+ EntityManager 또는 Session과 1:1관계를 갖는다.
    - 세션은 EntityManager의 구현체

API(Application Programming Interface) : 
프로그램을 프로그래밍하기 위한 약속  

*프로토콜과 인터페이스이라는 2종류의 약속이 있다. 인터페이스는 정의된 약속으로 정의된 틀에 맞게 사용해야 한다.(상하관계가 있음)  
프로토콜은 상하관계가 없다.* 

**ORM (Object Relational Mapping)**  
JPA는 ORM 기술로 객체와 데이터베이스의 데이터를 연결해주는 매핑 기술이다.  
DB 데이터와 JAVA에서의 데이터 타입이 다르기 떄문에, DB의 데이터를 JAVA에 사용하기 위해서, Object를 만들어야 하는데, 이것을 모델링이라고 한다.  
DB에서 데이터를 받기 위해, JAVA에서 모델링을 통해 객체에 데이터를 받아올 수 있다.  
반대로 자바에서 객체 코드를 이용해서 DB데이터 테이블을 생성할 수 있는데, 이것을 자동으로 해주는게 ORM이다.

```
JPA의 핵심은 EntityManagerFactory, EntityManager, EntityTransaction이며,
Hibernate에서는 각각 SessionFactory, Session, Transaction으로 상속받고 각각의 Impl로 구현하고 있다.

Spring boot에서 DB를 접근하기 위해 사용할 떄는 Repository를 사용했고 이 레포지토리는 Spring Data JPA의 핵싱이라고 한다. 
```
<br>

## 아키텍처 구조
---
<img src="img/아키텍처 구조.jpg"/>

```
가장 일반적으로 많이 사용하는 계층형 구조
 ○ Controller : 웹 계층
 ○ Service : 비지니스 로직, 트랜잭션 처리
 ○ Repository : JPA로 DB에 직접 접근하는 계층
 ○ Domain : 엔티티가 모여있는 계층

 개발 순서
 ○ Domain 생성
 ○ Repository 생성
 ○ Service 생성
 ○ Controller 생성
```
<br>

## 기본 어노테이션 정리
---
@Entity : DB의 테이블과 1대1 매칭  
@Table(name="?") : name 속성을 이용하여 DB상 실제 테이블 명칭 작성  
@Id : 테이블의 유일 값인 PK필드를 지정  
@Column : 테이블의 컬럼값을 나타내며 굳이 선언하지 않아도 해당 클래스의 필드변수는 모두 컬럼이 됨. 사용하는 이유는 기본 값 외에 추가로 변경이 필요한 옵션이 있는 경우에 사용
```
1. name = "?" : 매핑할 테이블의 컬럼 명
2. insertable = true or false : 엔티티 저장 시 선언된 필드도 같이 저장
3. updatable = true or false : 엔티티 수정 시 필드를 함께 수정
4. table : 지정한 필드를 다른 테이블에 맵핑
5. nullable : NULL을 허용할지, 허용하지 않을지 결정
6. unique : 제약조건을 걸때 사용
7. columnDefiniton : DB 컬럼 정보를 직접적으로 지정할 때 사용
8. length : varchar의 길이를 조정
9. precision, scale : BigInteger, BigEcimal 타입에서 사용, 각각 소수점 포함 자리수, 소수의 자리수를 의미
```