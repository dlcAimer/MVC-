/**
 * Created by 29252 on 2017/7/26.
 */
$(document).ready(function () {
    function freshPage(page) {
        $("#allArtworks").load("./artwork.jsp", "page=" + page, function (responseTxt, statusTxt, xhr) {
            if (statusTxt === "success") {
                let pageStart = parseInt($("#pagination").find("li:nth-child(2)").attr("data-pageNum"));
                let pageEnd = parseInt($("#pagination").find("li:nth-child(11)").attr("data-pageNum"));
                let pageLast = page <= 1 ? 1 : page - 1;
                let pageNext = page + 1;
                let lastBtn = $("#lastPage");
                let nextBtn = $("#nextPage");
                let pageBtn = $("#pagination li:nth-child(2) a:nth-child(1)");
                lastBtn.click(function () {
                    freshPage(pageLast);
                });
                nextBtn.click(function () {
                    freshPage(pageNext);
                });
                for (let i = pageStart; i <= pageEnd; i++) {
                    (function (i) {
                        pageBtn.click(function () {
                            freshPage(i);

                        })
                    })(i);
                    pageBtn = pageBtn.parent().next().children("a");
                }
            }
        });
    }
    freshPage(1);
});