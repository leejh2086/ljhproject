function set() {

        var confirmDelete = confirm("게시글을 삭제하시겠습니까?");

        if (confirmDelete) {
            document.getElementById("update_form").submit();
        } else {
            // 취소한 경우 아무 작업도 수행하지 않음
            return false;
        }
    }
