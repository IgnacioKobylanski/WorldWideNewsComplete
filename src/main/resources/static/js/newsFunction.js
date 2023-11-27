//newsFucntion.js

//function for carousell
export function printCarousel(array, carouselContainerId) {
    const carouselContainer = document.getElementById(carouselContainerId);

    if (!carouselContainer) {
        console.error(`Carousel container with id '${carouselContainerId}' not found.`);
        return;
    }

    const limit = 3;
    const limitedArray = array.slice(0, limit);

    for (let index = 0; index < limitedArray.length; index++) {
        const item = limitedArray[index];
        const carouselItem = document.createElement("div");
        carouselItem.classList.add("carousel-item");

        // La primera noticia se marca como activa
        if (index === 0) {
            carouselItem.classList.add("active");
        }

        carouselItem.innerHTML = `
            <a href="/news#${item.id}">
                <img src="${item.imageUrl}" class="d-block w-100" alt="${item.title}">
                <div class="carousel-caption d-none d-md-block">
                    <h5>${item.title}</h5>
                    <p>${item.description}</p>
                </div>
            </a>
        `;

        // Agregar el carouselItem al contenedor del carrusel
        carouselContainer.appendChild(carouselItem);
    }
}




//function for Headlines
export function printHeadlines(array) {
    const headlinesContainer = document.getElementById("headlines-container");

    const limit = 3;
    const limitedArray = array.slice(0, limit);

    for (let item of limitedArray) {
        const newsItem = document.createElement("div");
        newsItem.classList.add("small-news");


        newsItem.innerHTML = `
            <img src="${item.imageUrl}" alt="news-img" class="small-news-img">
            <div class="text-container">
                <h3 class="tile">${item.title}</h3>
                <p class="news-description">${item.description}</p>
                <a href="/news#${item.id}" class="link-to-news">See more</a>
            </div>
        `;

        headlinesContainer.appendChild(newsItem);
    }
}

//Function for the rest of the news
export function printNewsByCategory(array, containerId, category) {
    const container = document.getElementById(containerId);

    const categoryNews = array.filter(item => item.category === category);

    for (let item of categoryNews) {
        const newsItem = document.createElement("div");
        newsItem.classList.add("small-news");

        newsItem.innerHTML = `
            <img src="${item.imageUrl}" alt="news-img" class="small-news-img">
            <div class="text-container">
                <h3 class="tile">${item.title}</h3>
                <p class="news-description">${item.description}</p>
                <a href="/news#${item.id}" class="link-to-news">See more</a>
            </div>
        `;

        container.appendChild(newsItem);
    }
}