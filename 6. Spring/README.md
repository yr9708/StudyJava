# SPRING

* Spring01_Hello

  > Maven 을 JavaProject에 설치하고 spring-core, spring-context 설정해주고 연습해보자

* Spring02

  > <bean> 태그를 사용하여 객체를 만들어 main 메소드에서 가져와 실행해보자

* Spring03

  > 1. 객체를 만들때 특정 메소드를 이용하여 만들 수 있다. (싱클톤)
  > 2. < constructor-arg >, < property > 사용하여 객체 만들어보자
  > 3. c:emp-ref , p:emp-ref 란?
  > 4. lazy-init

* Spring04

  > 1. java.util.Date 클래스를 이용해서 bean 사용해보기
  >
  > 2. Collection (array, list, set, map, inner bean, ref)

* Spring05

  > applicationContext에 Annotation을 scan할 곳을 지정해주고 실행해보자

* Spring06_AOP

  > 1. cc와 ccc를 구분하지 않는 상태
  > 2. applicationContext에 ccc와 advisor을 설정해주자
  > 3. 자동으로 autoproxy 만들어지게 하고 aspect 설정
  > 4. @Before, @After Annotation을 사용해보자
  > 5. 한번에 pointCut을 걸 수 있는 방법을 알아보자
  > 6. applicationContext에 bean객체를 만들지 않고 코딩해보자
  > 7. aop.framework class를 이용하여 bean객체를 만들어 코딩해보자

* Spring07_HelloMVC

  > 다이나믹 프로젝트로 만들고
  > Controller, biz, dao에 Annotatio을 사용하고 web.xml 설정해보자

* SpringMVC01_Hello

  > Spring Legacy Project로 만들어 web.xml 설정후 home.jsp 불러보자 

* SpringMVC02

  > .do로 실행했을때의 설정 방법과 Controller에서 post, get 방식에 따라 보내지는 jsp를 달리하자

* SpringMVC_Review

  > 혼자 복습한 프로젝트로 model에서 addAttribute할때 list로 보내어 jsp에서 확인해보았다.

* SpringMVC03, SpringMVC03_2

  > DB(oracle)와 Spring을 연결하여 CRUD 해보자
  >
  > redirect사용해보자

* Spring06_TestAop01_Test

  > img와 같이 출력되게 만들어보자

* SpringMVC03_Filter

  > Filter를 사용하여 콘솔에 정보를 찍어보자

* SpringMVC03_Filter_Aop_Login_Interceptor_Transaction_Security

  > Filter+Aop 를 사용하여 콘솔에 정보를 찍어보자
  >
  > Login + Interceptor 를 이용하여 지정된 조건에 의해서만 페이지를 넘겨보자
  >
  > Transaction을 이용하여 중간에 오류가 나면 commit하지 못하게 하자
  >
  > Security를 이용하여 pw가 암호화 되어 DB에 저장되게끔 하자

* SpringMVC04_File

  > File 업로드를 해보자

* SpringMVC05_Update

  > web-app의 version을 4.0 으로 update해서 설정을 바꿔보자

* SpringMVC05_Update_Jdbc

  > Mybatis가 아닌 JDBC를 이용하여 DB를 연동해보자

* SpringMVC05_Update_Jdbc_Javaconfig

  > applicationContext.xml, servlet-context.xml 을 이용하지 않고 javaClass로 바꿔 설정해보자 