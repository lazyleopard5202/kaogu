var formData = new FormData();
$.ajax({
    type: "post",
    url: "this is a url",
    data: formData,
    processData: false,
    contentType: false,
    success: function(data){
        var newData = eval(data)
        var articleName = newData.articleName;
        var authorName = newData.authorName;
        var time = newData.time;
        var source = newData.source;
        var url = newData.url;
        $("selector").text(articleName);
        $("selector").text(authorName);
        $("selector").text(time);
        $("selector").text(source);
        $("selector").text(url);
    }
});

/**
 * get and set 3 picture urls of 'mm-sources' part
 * run when page on load
 */
$(function(){
    $().get('/index/pic_urls', function(urls) {
        $('#mm_pic1').attr('src', urls.mm_pic1);
        $('#mm_pic2').attr('src', urls.mm_pic2);
        $('#mm_pic3').attr('src', urls.mm_pic3);
    });
});

