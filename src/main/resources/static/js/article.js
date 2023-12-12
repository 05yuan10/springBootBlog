// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        // fetch()를 통해 /api/articles/ DELETE 요청을 보냄
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            // fetch()가 잘 완료되면 연이어 실행되는 메서드
            .then(() => {
                alert('삭제가 완료되었습니다.');
                // 사용자의 웹 브라우저 화면을 현재 주소를 기반해 옮겨주는 작업
                location.replace('/articles');
            });
    });
}
// 수정 기능
// id가 modify-btn인 엘리먼트 조회
const modifyButton = document.getElementById('modify-btn');
if (modifyButton) {
    // 클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event =>{
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}
// 등록 기능
// id가 create-btn인 엘리먼트 조회
const createButton = document.getElementById('create-btn');
if(createButton) {
    // 클릭 이벤트가 감지되면 등록 API 요청
    createButton.addEventListener('click', event => {
        body = JSON.stringify({
            title: document.getElementById("title").value,
            content: document.getElementById("content").value,
        });

        function success() {
            alert("등록 완료되었습니다.");
            location.replace("/articles");
        }

        function fail() {
            alert("등록 실패했습니다.");
            location.replace("articles");
        }

        httpRequest("POST", "/api/articles", body, success, fail);
    });

    // 쿠키를 가져오는 함수
    function getCookie(key) {
        var result = null;
        var cookie = document.cookie.split(";");
        cookie.some(function (itmem) {
            item = item.replace(" ", "");

            var dic = item.split("=");
            if (key === dic[0]) {
                result = dic[1];
                return true;
            }
        });
        return result;
    }
}
/*
    // HTTP 요청을 보내는 함수
    function httpRequest(method, url, body, success, fail) {
        fetch(`url, {
            method: method,
            headers: {
                // 로컬 스토리지에서 액세스 토큰 값을 가져와 헤더에 추가
                Authorization: "Bearer " + localStorage.getItem("access_token"),
                "Content-Type": "application/json",
            },
            body: body,
        })
            .then((response) => {

            }*/
