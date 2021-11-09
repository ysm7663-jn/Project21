var main = {
        init : function () {
            var _this = this;
            // 생성
            $('#btn-save').on('click', function () {
                _this.save();
                });

            // 수정
            $('#btn-update').on('click', function () {
                _this.update();
            });
        },

        save : function () {
            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/posts',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 등록되었습니다.');
                window.location.href = '/';     // 글 등록 성곡시 메인페이지(/)로 이동
                }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

        update : function () {
            var data = {
                title: $('#title').val(),
                content: $('#content').val()
            };

            var id = $('#id').val();

            $.ajax({
                type: 'PUT',
                url: '/api/v1/posts/' + id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('글이 수정되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};

main.init();