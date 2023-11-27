document.addEventListener('DOMContentLoaded', function () {
    const newsId = window.location.hash.substring(1);
    console.log('News ID:', newsId);

    getNewsData()
        .then(newsData => {
            console.log('News data received:', newsData);
            const selectedNews = findNewsById(newsData, newsId);

            if (selectedNews) {
                console.log('Selected News:', selectedNews);
                updateNewsContent(selectedNews);
            } else {
                console.error('News not found.');
            }
        })
        .catch(error => console.error('Error fetching news:', error));
});

function getNewsData() {
    return fetch('/api/news')
        .then(response => response.json())
        .catch(error => {
            console.error('Error fetching news:', error);
            return [];
        });
}

function findNewsById(newsData, newsId) {
    return newsData.find(item => item.id === parseInt(newsId));
}

function updateNewsContent(newsItem) {
    const dynamicContent = document.getElementById('dynamic-content');

    dynamicContent.innerHTML = `
        <h1 class="news-title">${newsItem.title}</h1>
        <img src="${newsItem.imageUrl}" alt="spooky-house" class="news-body-img">
        <h3 class="news-description">${newsItem.description}</h3>
        <div class="news-body">
            <p>${newsItem.content}</p>
        </div>
    `;
}
