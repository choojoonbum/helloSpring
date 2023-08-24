package common;

import org.springframework.data.domain.Page;

public class Pagination {
    public static String pagingStr(Page<?> page, int blockPage, String reqUrl) {

        int totalPages = page.getTotalPages();
        int pageTemp = page.getNumber() / blockPage * blockPage;

        String pagingStr = "";
        pagingStr += "<ul class=\"pagination justify-content-center\">";
        if (pageTemp != 0) {
            pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href=\"" + reqUrl + "?page=0\">처음</a></li>";
            pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href=\""+ reqUrl + "?page=" + (pageTemp-1) + "\">&laquo;</a></li>";
        }

        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= (totalPages-1)) {
            if (pageTemp == page.getNumber()) {
                pagingStr += "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"" + reqUrl + "?page="+ pageTemp + "\">" + (pageTemp+1) + "</a></li>";
            } else {
                pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href=\"" + reqUrl + "?page=" + pageTemp + "\">" + (pageTemp+1) + "</a></li>";
            }
            pageTemp++;
            blockCount++;
        }

        if (pageTemp <= (totalPages-1)) {
            pagingStr += "<li class=\"page-item \"><a class=\"page-link\" href=\"" + reqUrl + "?page=" + pageTemp + "\">&raquo;</a></li>";
            pagingStr += "<li class=\"page-item \"><a class=\"page-link\" href=\"" + reqUrl + "?page=" + (totalPages-1) + "\">마지막</a></li>";
        }
        pagingStr += "</ul>";

        return pagingStr;
    }
}
