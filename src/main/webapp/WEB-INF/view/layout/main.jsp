<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>



<div class="container mt-5">
    <div class="bg-light">
        <c:choose>
            <c:when test="${boardList != null && not empty boardList}">
                <table class="table table-striped">
                    <thead class="table-dark">
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성자</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="board" items="${boardList}">
                            <tr>
                                <td>${board.id}</td>
                                <td>${board.title}</td>
                                <td>${board.content}</td>
                                <td>${board.author}</td>
                                <td>
                                    <form action="/board/${board.id}/delete" method="post" style="display: inline;">
                                        <button type="submit" class="btn btn-danger">삭제</button>
                                    </form>
                                    <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
               
            </c:when>
            <c:otherwise>
                <p>아직 생성된 게시글이 없습니다.</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>