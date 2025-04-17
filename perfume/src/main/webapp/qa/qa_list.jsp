<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pack.qa.QaManager, pack.qa.QaDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="qaMgr" class="pack.qa.QaManager" />

<%
    request.setCharacterEncoding("UTF-8");
    String searchType = request.getParameter("searchType"); // 검색 타입
    String searchWord = request.getParameter("searchWord"); // 검색어
    String pageStr = request.getParameter("page"); // 페이지 번호
    int currentPage = (pageStr == null || pageStr.isEmpty()) ? 1 : Integer.parseInt(pageStr);

    String loginId = (String) session.getAttribute("id"); // 세션에서 관리자 ID 가져오기
    request.setAttribute("loginId", loginId); // 로그인 ID
    request.setAttribute("isAdmin", "admin".equals(loginId)); // 관리자 여부 확인

    qaMgr.totalList();
    int pageSu = qaMgr.getPageSu();
    int totalCount = qaMgr.getTotalCount();
    java.util.List<QaDto> list = qaMgr.getDataAll(currentPage, searchType, searchWord);

    request.setAttribute("list", list); // 게시글 리스트
    request.setAttribute("pageSu", pageSu);
    request.setAttribute("totalCount", totalCount);
    request.setAttribute("currentPage", currentPage);
    request.setAttribute("searchType", searchType);
    request.setAttribute("searchWord", searchWord);
%>

<%@ include file="../include/top.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/common2.css">

<div class="page-container">
    <div class="header-row">
        <h2 class="section-title">문의 사항</h2>

        <form method="post" action="qa_list.jsp" class="search-form">
            <label><input type="radio" name="searchType" value="writer" ${searchType eq 'writer' ? 'checked' : ''}> 이름</label>
            <label><input type="radio" name="searchType" value="title" ${searchType eq 'title' || searchType == null ? 'checked' : ''}> 제목</label>
            <label><input type="radio" name="searchType" value="postcontent" ${searchType eq 'postcontent' ? 'checked' : ''}> 내용</label>
            <input type="text" name="searchWord" value="${searchWord != null ? searchWord : ''}" placeholder="검색어 입력">
            <button type="submit"><i class="bi bi-search"></i></button>
        </form>

        <div class="login-box">
            <c:choose>
                <c:when test="${empty loginId}">
                    <form action="login.jsp" method="get">
                        <button type="submit" class="detail-button">관리자 로그인</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="logout.jsp" method="post">
                        <span>${loginId}님</span>
                        <button type="submit">로그아웃</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <table class="basic-table">
        <thead>
        <tr style="text-align: center;">
            <th>NO.</th>
            <th>CONTENT</th>
            <th>NAME</th>
            <th>DATE</th>
            <th>HITS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}" varStatus="status">
            <tr>
                <td>${totalCount - ((currentPage - 1) * 5 + status.index)}</td>
                <td>
                    <form method="post" action="${dto.secretYN == 1 && !isAdmin ? 'qa_check.jsp' : 'qa_detail.jsp'}">
                        <input type="hidden" name="no" value="${dto.publish_no}" />
                        <button type="submit" class="title-btn detail-button">
                            <c:if test="${dto.secretYN == 1}"><i class="bi bi-lock-fill text-info"></i></c:if>
                                ${dto.title}
                        </button>
                    </form>
                </td>
                <td>${fn:substring(dto.writer, 0, 1)}*${fn:substring(dto.writer, fn:length(dto.writer) - 1, fn:length(dto.writer))}</td>
                <td>${dto.postcreatedate}</td>
                <td>0</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="pagination-box">
        <form method="post" action="qa_list.jsp">
            <input type="hidden" name="searchType" value="${searchType}">
            <input type="hidden" name="searchWord" value="${searchWord}">
            <c:forEach var="i" begin="1" end="${pageSu}">
                <button type="submit" name="page" value="${i}" class="${i == currentPage ? 'active' : ''}">${i}</button>
            </c:forEach>
        </form>
    </div>

    <div class="action-button-box">
        <form method="post" action="qa_form.jsp">
            <button type="submit"><i class="bi bi-pencil-square"></i> WRITE</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/qa.js"></script>
<%@ include file="../include/bottom.jsp" %>
