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

                <!-- 페이징 처리 -->
                <div class="d-flex justify-content-center">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${currentPage > 1}">
                                <li class="page-item">
                                    <a class="page-link" href="?page=${currentPage - 1}&size=${pageSize}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${totalPages}" var="page">
                                <li class="page-item ${page == currentPage ? 'active' : ''}">
                                    <a class="page-link" href="?page=${page}&size=${pageSize}">${page}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${currentPage < totalPages}">
                                <li class="page-item">
                                    <a class="page-link" href="?page=${currentPage + 1}&size=${pageSize}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </c:when>
            <c:otherwise>
                <p>아직 생성된 게시글이 없습니다.</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
