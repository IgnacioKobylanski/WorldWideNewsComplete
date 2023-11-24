import { printHeadlines } from "/js/newsFunction.js";
import { printNewsByCategory } from "/js/newsFunction.js";
import { printCarousel } from "/js/newsFunction.js";

document.addEventListener('DOMContentLoaded', function() {
    getNews();
});

function getNews() {
    let news;

    fetch('/api/news')
        .then(response => response.json())
        .then(newsData => {
            console.log('Noticias obtenidas:', newsData);

            news = newsData;

            // Functions
            printCarousel(news, 'carousel-inner-container')
            printHeadlines(news);
            printNewsByCategory(news, 'local-news-container', 'Local News');
            printNewsByCategory(news, 'international-news-container', 'International News');
            printNewsByCategory(news, 'finance-container', 'Finance');
            printNewsByCategory(news, 'sports-container', 'Sports');
            printNewsByCategory(news, 'entertainment-container', 'Entertainment');
        })
        .catch(error => console.error('Error fetching news:', error));
}
