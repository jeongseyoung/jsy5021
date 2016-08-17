<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="a" items="${data}" varStatus="stat">
<c:if test="${stat.index != 0 }">,</c:if>
{img_num:${a.img_num }, writer:'${a.writer }', content:'${a.content }'}
</c:forEach>
]