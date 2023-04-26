# Learn-to-Spring
스프링 공부하기!  
스프링은 기본적으로 Model2 방식

## IOC(Inversion of Control)
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


POJO(plain Old java Object) :
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
 
kts 세팅에서 불러온 gradle 설정이 다 있음.  
jsp 바로 지원하지 않기 때문에 우리가 설정을 해야함.  
```
Eclipse market place 에서  
Eclipse Enterprise Java and Web Developer Tools 3.29 설치  
```
룰을 어겨도 실행은 되지만 관습적으로 처리되는 부분이 있어서 컨벤션 룰을 잘 지켜줘야 함.

적용된 jdbc : ojdbc6 버전 11.2.0.4 (버전에 맞춰서 맞는 것을 넣어야 함.)


build.gradle : 
implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '2.0.0'
implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
implementation group: 'com.oracle.database.jdbc', name: 'ojdbc6', version: '11.2.0.4'

<!--어노테이션-->
@RequestMapping(value="/test4",method=RequestMethod.GET)  
@RequestMapping(value="/test4",method=RequestMethod.POST)  

@Data  


@Autowired : (스프링에서는 DI를 지원하기 때문에 ...)  
@Repository : db쪽에 연결되는 BEAN 객체 DAO 


스프링부트는 xml파일도 정적이기 때문에 resources 안에 만들어주어야 함.



로깅에는 레벨은 7단계가 존재
```
ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
```

### 센세가 스리슬쩍 말하는 단어들
보일러플레이트코드 :
ORM 방식 :