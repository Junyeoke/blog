<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>익명 글쓰기 화면입니다</b></div>
        <div class="card-body">
            <form id="boardForm" action="/board/save" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter author" name="author">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" placeholder="Enter title" name="title">
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="content"></textarea>
                </div>
                <button id="submitButton" type="submit" class="btn btn-primary form-control">글쓰기완료</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

<script>
    document.getElementById("boardForm").addEventListener("submit", function(event) {
        var title = document.getElementsByName("title")[0].value;
        var content = document.getElementsByName("content")[0].value;
        if (title.length > 20 || content.length > 20) {
            alert("제목 또는 내용은 20자를 초과할 수 없습니다.");
            event.preventDefault();
        }
    });
</script>
