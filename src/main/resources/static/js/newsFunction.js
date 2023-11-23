export function createNews(object) {
    return `
        <div class="small-news">
            <img src="${object.imageUrl}" alt="news-img" class="small-news-img">
            <div class="text-container">
                <h3 class="tile">${object.title}</h3>
                <p class="news-description">${object.description}</p>
                <a href="/news" class="link-to-news">See more</a>
            </div>
        </div>
    `;
}
