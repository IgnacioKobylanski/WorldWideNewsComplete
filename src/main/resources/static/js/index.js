document.addEventListener('DOMContentLoaded', function() {
    // Llama a la función para obtener noticias y llenar el contenido
    getNewsAndPopulatePage();
});
import {printNews} from "/js/newsFunction.js"
let sectionHeadline = document.getElementById("headlines");
fetch('/api/news')
  .then(response => response.json())
  .then(newsData => {

    const data = newsData;

    console.log(data);
printNews(data, sectionHeadline)
  })
  .catch(error => console.error('Error fetching news:', error));





/*
// Función para obtener noticias desde el backend y mostrarlas
function getNewsAndPopulatePage() {
    // Hacer una solicitud al endpoint /api/news
    fetch('/api/news')
        .then(response => response.json())
        .then(news => {
            // Llenar el carousel con noticias al azar
            populateCarousel(news);

            // Llenar la sección "Headlines" con las primeras 3 noticias
            const headlinesContainer = document.getElementById('headlines-container');
            const headlinesNews = news.slice(0, 3);

            headlinesNews.forEach(newsItem => {
                const newsContainer = document.createElement('div');
                newsContainer.classList.add('small-news');

                // Crear contenido del newsContainer (imagen, título, descripción)
                newsContainer.innerHTML = `
                    <img src="${newsItem.imageUrl}" alt="news-img" class="small-news-img">
                    <div class="text-container">
                        <h3 class="tile">${newsItem.title}</h3>
                        <p class="news-description">${newsItem.description}</p>
                        <a href="/news" class="link-to-news">See more</a>
                    </div>
                `;

                // Agregar el newsContainer al contenedor de "Headlines"
                headlinesContainer.appendChild(newsContainer);
            });

            // Llenar otras secciones por categoría (si es necesario)
            populateSection(news, 'Local News', 'local-news');
            populateSection(news, 'International News', 'international-news');
            populateSection(news, 'Finance', 'finance');
            populateSection(news, 'Sports', 'sports');
            populateSection(news, 'Entertainment', 'entertainment');
        })
        .catch(error => console.error('Error fetching news:', error));
}

// Función para llenar el carousel con noticias al azar
function populateCarousel(news) {
    // Selecciona el elemento del carousel
    const carousel = document.querySelector('.carousel-fade');

    const randomNews = news.slice(0, 3);

    // Itera sobre las noticias y crea elementos para el carousel
    randomNews.forEach((newsItem, index) => {
        const carouselItem = document.createElement('div');
        carouselItem.classList.add('carousel-item');

        // La primera noticia se marca como activa
        if (index === 0) {
            carouselItem.classList.add('active');
        }

        // Crear contenido del carouselItem (imagen, título, descripción)
        carouselItem.innerHTML = `
            <a href="/news">
                <img src="${newsItem.imageUrl}" class="d-block w-100" alt="${newsItem.title}">
                <div class="carousel-caption d-none d-md-block">
                    <h5>${newsItem.title}</h5>
                    <p>${newsItem.description}</p>
                </div>
            </a>
        `;

        // Agregar el carouselItem al carousel
        carousel.appendChild(carouselItem);
    });
}

// Función para llenar las secciones con noticias por categoría
function populateSection(news, category, sectionId) {
    // Filtra las noticias por categoría
    const categoryNews = news.filter(newsItem => newsItem.category === category);

    // Selecciona el elemento de la sección
    const section = document.getElementById(sectionId);

    // Obtén las primeras 3 noticias (puedes ajustar según sea necesario)
    const sectionNews = categoryNews.slice(0, 3);

    // Itera sobre las noticias y crea elementos para la sección
    sectionNews.forEach(newsItem => {
        const newsContainer = document.createElement('div');
        newsContainer.classList.add('small-news');

        // Crear contenido del newsContainer (imagen, título, descripción)
        newsContainer.innerHTML = `
            <img src="${newsItem.imageUrl}" alt="news-img" class="small-news-img">
            <div class="text-container">
                <h3 class="tile">${newsItem.title}</h3>
                <p class="news-description">${newsItem.description}</p>
                <a href="/news" class="link-to-news">See more</a>
            </div>
        `;

        // Agregar el newsContainer a la sección
        section.appendChild(newsContainer);
    });
}*/
