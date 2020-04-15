var main = {
    init : function(){
        var $this = this;

        //등록화면에 저장버튼 이벤트 등록
        $("#btn-save").on("click", function(){
           $this.save();
        });

        //수정화면에 저장버튼 이벤트 등록
        $("#btn-update").on("click", function(){
           $this.update($(this).data("id"));
        });

        //삭제 버튼에 이벤트 등록
        $(".btn-delete").on("click", function(){
            $this.delete($(this).data("id"));
        });
    },

    save : function(){
        var data = {
            "title" : $("#inputTitle").val(),
            "author" : $("#inputAuthor").val(),
            "content" : $("#inputContent").val()
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
            window.location.href = "/board";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    update : function (id) {
        var data = {
            "title" : $("#inputTitle").val(),
            "author" : $("#inputAuthor").val(),
            "content" : $("#inputContent").val()
        };
        $.ajax({
            type : "PUT",
            url : "/api/v1/board/"+id,
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data)
        }).done(function(){
            alert("글 수정이 완료되었습니다!");
            window.location.href = "/board";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    delete : function(id){
        var result = confirm(id+" 게시글을 정말 삭제하시겠습니까~?");
        if(result){
            $.ajax({
                type : "DELETE",
                url : "/api/v1/board/"+id,
                dataType: "json",
                contentType: "application/json;charset=utf-8"
            }).done(function(){
                alert("글 삭제가 완료되었습니다!");
                window.location.href = "/board";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
    }
}

main.init();
