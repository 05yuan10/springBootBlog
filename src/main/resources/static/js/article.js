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