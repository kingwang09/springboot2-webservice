var main = {
    init : function(){
        var $this = this;

        //등록화면에 저장버튼 이벤트 등록
        $("#btn-save").on("click", function(){
           $this.save();
        });
    },

    save : function(){
        var data = {
            "title" : $("#inputTitle").val(),
            "author" : $("#inputAuthor").val(),
            "content" : $("#inputContent").val(),
        };

        $.ajax({
            type : "POST",
            url : "/api/v1/board",
            //dataType
            //contentType 별도로 지정하지 않으면 form으로 인식
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data)
        }).done(function(){
            alert("글 등록이 완료되었습니다!");
            window.location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

main.init();
