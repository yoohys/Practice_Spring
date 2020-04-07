<%@page import="basic.LoginBean"%>
<%@page import="basic.ProductInfo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
배열항목을 출력하는 EL식
홍길동1,홍길동2,홍길동3
<% 
//(1)배열 출력
String[] s = new String[]{"홍길동1","홍길동2","홍길동3"};

//(2)ArrayList 출력
ArrayList<String> List = new ArrayList();
List.add(0, "딸기");
List.add(1, "오렌지");
List.add(2, "복숭아");

//(3)Map객체의 항목 출력
Map<String,String> m = new HashMap();
m.put("홍길동1", "방방곡곡");
m.put("홍길동2", "방방곡곡");
m.put("홍길동3", "방방곡곡");

//(4)JavaBean Property
ProductInfo pi = new ProductInfo();
pi.setName("초코케잌3호");
pi.setValue(20000);

//(5) set & get Serialize(직렬화)
LoginBean lb1 = new LoginBean();
LoginBean lb2 = new LoginBean();
lb1.setUserid("aaa");
lb1.setPasswd("111");
lb2.setUserid("bbb");
lb2.setPasswd("222");

ArrayList<LoginBean> lb = new ArrayList();
lb.add(0, lb1);
lb.add(1, lb2);


request.setAttribute("s", s);
request.setAttribute("List", List);
request.setAttribute("m", m);
request.setAttribute("pi", pi);
request.setAttribute("lb", lb);
request.setAttribute("lb2", lb2);
RequestDispatcher rd = request.getRequestDispatcher("winnersResult.jsp");
rd.forward(request, response);
%>
</body>
</html>