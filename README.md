# Learn-to-Spring
스프링 공부하기!  
스프링은 기본적으로 Model2 방식

## Spring 
---
- 자바 Framework
- 오픈소스(무료)로 되어있음 → 내부를 볼 수 있기 떄문에 뜯어 고칠 수 있음.
- IoC 컨테이너를 갖음.
- Dependency Injection을 지원함.(의존성 주입)
- 엄청 많은 필터, 어노테이션 지원
    + 스프링 컨테이너의 필터 이름 : 인터셉터  
    
기본적으로 객체를 new를 통해 인스턴스화하면 Heap 메모리 영역에 저장되고 생성된 객체를 다른데에서 쓸수 없고 다시 인스턴스화 해야하지만 스프링에서는 IoC와 DI으로 Component시켜 다른 곳에서 사용할 수 있도록 함.

## IOC(Inversion of Control)
---
- 제어의 역전
- 제어의 흐름을 사용자가 컨트롤 하지 않고 위임한 특별한 객체에 모든 것을 맡기는 것
    + 기존 사용자가 모든 작업을 제어하던 것을 특별한 객체에 모든 것을 위임하여 객체의 생성부터 생명주기 등 모든 객체에 대한 제어권이 넘어간 것

## TDD(Test Driven development) 방법론

## DL (Dependency Lookup)
> 컨테이너가 객체를 생성  
클라이언트는 생성한 객체를 검색(LookUp하여 사용)

## DI (dependency Injection) : 의존성 주입 <더 중요>
> 여기서 필요한 의존성이 있으면 밖에서 만들어서 집어넣는 형식
각 클래스 간의 의존성을 빈 설정 정보를 바탕으로 컨테이너에서 자동으로 연결
```
생성자 주입(Constructor Injection)
세터 주입(Setter Injection)
인터페이스 주입(Interface Injection)
```
DI 의 장점
1. 의존성이 줄어듬 → 변경에 덜 취약
2. 모의 객체를 주입할 수 있기 때문에 단위 테스트가 쉬워짐
3. 가독성이 높아짐
4. 재사용성이 높아짐

## AOP : 관점 지향 프로그래밍 /OOP와 관계가 없음.  
공통적으로 사용하는 영역들을 따로 빼고 인젝션해서 추가하는 방식(스프링이 기본적으로 제공해줌.)
핵심기능과 공통기능을 분리시켜 핵심 로직에 영향을 끼치지 않게 공통기능을 끼워 넣는 개발 형태  
<img alt="AOP구조" src="/img/AOP.PNG">


POJO(plain Old java Object) : 순수 Java만을 통해서 생성한 객체
*

## Spring 설치하기
---
설치 후 압축해제  
실행 후 preferences > 인코딩 및 브라우저 설정  

Spring Starter Project 설정 URL : https://start.spring.io/  
URL에서 해도 되지만 이클립스나 VS코드같은 편집기에서 지원하는 Create Spring Project에서도 동일한 기능을 지원해서 그게 더 편한 거 같다.  

프로젝트 생성 시 선택 요소
```
project  
    gradle-groovy  
    gradle-Kotlin  
    Maven  

language  
    java  
    kotlin  
    Groovy  
```

---
src/main/resources :  자바 클래스에서 사용하는 리소스를 보관하는 공간.

application.properties : 설정 내용들  
설정 파일이 다른데 가보면 없는 경우가 있는데 그럴 경우는 yaml 이 설정 파일인 경우가 있음.  
 
kts : 세팅에서 불러온 gradle 설정이 다 있음.  

jsp는 바로 지원하지 않기 때문에 우리가 설정을 해야함.  
```
* JSP 사용을 위한 설치
Eclipse market place 에서  
Eclipse Enterprise Java and Web Developer Tools 3.29 설치  
```
룰을 어겨도 실행은 되지만 관습적으로 처리되는 부분이 있어서 컨벤션 룰을 잘 지켜줘야 함.

적용된 jdbc : ojdbc6 버전 11.2.0.4 (버전에 맞춰서 맞는 것을 넣어야 함.)


build.gradle : 
implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '2.0.0'
implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
implementation group: 'com.oracle.database.jdbc', name: 'ojdbc6', version: '11.2.0.4'

<br>

## Bean
---
> 스프링 컨테이너가 관리하는 자바 객체로 지금까지는 new 연산을 통해 객체를 생성하고 메서드를 호출했다면 Spring에서는 IoC(제어의 역전)가 적용되어 이러한 객체의 생성과 사용자의 제어권을 스프링에게 넘긴다.  
사용자는 직접 new연산을 이용해 생성한 객체를 사용하지 않고 스프링에 의하여 관리당하는 자바 객체를 사용함.  
*여기서 사용되는 객체를 Bean객체라고 함.* 👍

<br>

## Model 객체
--- 
스프링MVC에서 제공하는 객체로 model객체에 객체를 저장해서 뷰페이지로 전달하는 역할

```java
<!-- JSP에서 보내는 형식 -->
request.setAttribute("받는 페이지에서 사용할 이름", 보낼 변수 또는 객체);
Request.getRequestDispacher("이동할 URL 주소").forward(req,resp);
```
JSP에서 위처럼 request로 데이터를 보냈다면 Spring에서는 아래와 같이 보냄
```java
public String home(Model model){
    model.addAttribute("받는 페이지에서 사용할 이름", 보낼 변수 또는 객체);
    return "이동할 URL 주소";
}
```

<br>

## @ 어노테이션
---
> 컴파일러가 무시하지않고 컴파일러에게 힌트를 주는 주석  

@RequestMapping(value="/test4",method=RequestMethod.GET)  
@RequestMapping(value="/test4",method=RequestMethod.POST)  

@Data : lombok에서 지원하는 어노테이션
> Getter,Setter,ToString, EqualsAndHashCode, RequiredArgsConstructor 등을 합친 어노테이션으로 POJO와 bean과 관련된 모든 보일러플레이트를 생성함.  

<br>

### Mapper 와 Repository
---
Mapper와 Repository란  
> DB에 연결하여 데이터를 가져올 때 사용하는 어노테이션  

차이는?  
> 1. Mapper는 Repository에 포함되어 있음.  
Mapper는 **.xml과 같이 SQL문을 정의 해놓은 파일과 많이 사용하여 모델과 매핑시키는 ibatis(mybatis) 방식에서 사용하는 것으로 mapper는 매핑이라는 단어에서 유추할 수 있듯이 SQL문(XML)을 메소드(java)로 매핑 시켜주는 어노테이션  

**즉, 정의해놓은 SQL와 개발할 때 사용하는 메소드를 연결하고 결과 값을 정의해놓은 타입으로 매핑 시키는 어노테이션**

> 2. Repository는 mapper처럼 sql문을 메소드랑 매핑해서 쓰든 아니든 DB를 조회 및 조작하는 것에 중점을 둔 개념..(mapper보다 좀 더 큰 개념)  
repository는 비지니스 로직에서 DB의 데이터를 조회 및 조작하는것을 분리하기 위한 것으로 DB와 연결이 강한 Mapper와 달리 DB의 데이터를 조회 및 조작하는 것에 중점을 뒀다는 것이 가장 큰 개념
```
비지니스 로직이란,
데이터를 어떻게 생성하고 조회하고 수정할 지를 정의하는 것으로 비지니스 로직은 프로그램의 핵심으로 얼마나 쉽게 짜느냐에 따라 프로젝트에 큰 영향을 끼친다.
```
>@Repository는 @Component이 붙어 있어서 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있음.

@Mapper : 
@Repository : db쪽에 연결되는 BEAN 객체 DAO 

@Req

@Autowired : (스프링에서는 DI를 지원하기 때문에 ...)  


스프링부트는 xml파일도 정적이기 때문에 resources 안에 만들어주어야 함.



로깅에는 레벨은 7단계가 존재
```
ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
```


JPA : ORM(객체와 DB의 관계성)

Entity 객체를 만들어서 DB의 테이블과 매칭  
Entitiy Manager Fectory 라는 클래스에서 Entity  
해당하는 Entitiy를 저장하는 공간 : Persistance Context(영속성 컨텍스트)  
하이버네이트

Thymeleaf : html 소스에 작성했을 때 다이나믹한 구조를 JSP처럼 할 수 없으니 그걸 지원해주는 의존성   
H2 Database : 작은 형태의 DB, 메모리 사이즈 정도의 저장공간을 DB 형태로 임시로 만드는 의존성(꼭 메모리 사이즈는 아님)  

---

Spring Security  
CSRF(Cross Site Request Forgery)
_csrf :

영속성 전이 :
고아객체 :

AuditorAware : JPA에서 기본으로 지원  
어디팅에서 빈번하게 쓰이는 4가지
최초 작성일시 - regTime  
작성자 -   
수정 일시 - updateTime  
수정자 -  

ModelMapper 라이브러리를 쓰면 엔티티나 DTO의 변수명을 똑같이 써줘야 함.
DTO 자동생성까지는 아님 정말 엔티티와 DTO를 매핑하는 용도
### 센세가 스리슬쩍 말하는 단어들
보일러플레이트코드 : 재사용가능한 코드  
ORM 방식 :
Dialect : DB마다 약간씩의 문법 차이가 있어서 그것을 방언이라고 표기한 것임.
MockMVC : 어플리케이션 서버에 배포하지 않고 테스트용 MVC환경을 만들어 요청 및 전송, 응답기능을제공해주는 유틸리티