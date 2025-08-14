import React from 'react';
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";


const HomePage = () => {
    // Slider settings
    const sliderSettings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 5000,
        fade: true,
        arrows: true,
        responsive: [
            {
                breakpoint: 768,
                settings: {
                    arrows: false
                }
            }
        ]
    };

    // Hero slides data
    const heroSlides = [

        {
            image: "https://images.unsplash.com/photo-1657753023885-7e30e39bf039?q=80&w=988&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            title: "Timeless Beauty",
            subtitle: "Every piece tells a story",
            buttonText: "Explore Lingerie"
        },
        {
            image: "https://images.unsplash.com/photo-1651671685354-8ef9110ea28e?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            title: "Perfect Fit",
            subtitle: "Designed for your comfort",
            buttonText: "View Bodysuits"
        },
        {
            image: "https://plus.unsplash.com/premium_photo-1683120861720-e5babc80c6a6?q=80&w=988&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            title: "Luxury Comfort",
            subtitle: "Where elegance meets comfort",
            buttonText: "Shop Now"
        }
    ];

    return (
        <div className="min-h-screen bg-gradient-to-br from-pink-50 to-rose-100">
            {/* Hero Slider Section */}
            <section className="relative h-screen overflow-hidden">
                <Slider {...sliderSettings} className="h-full">
                    {heroSlides.map((slide, index) => (
                        <div key={index} className="relative h-screen">
                            <div
                                className="absolute inset-0 bg-cover bg-center bg-no-repeat"
                                style={{ backgroundImage: `url(${slide.image})` }}
                            >
                                <div className="absolute inset-0 bg-gradient-to-r from-pink-200/30 to-rose-200/30"></div>
                                <div className="relative z-10 h-full flex items-center justify-center text-center px-4">
                                    <div>
                                        <h1 className="text-6xl md:text-8xl font-light text-white mb-6 tracking-wider drop-shadow-lg">
                                            {slide.title}
                                        </h1>
                                        <p className="text-xl md:text-2xl text-white mb-8 font-light drop-shadow-lg">
                                            {slide.subtitle}
                                        </p>
                                        <button className="bg-pink-500 hover:bg-pink-600 text-white px-8 py-3 rounded-full text-lg font-medium transition-all duration-300 transform hover:scale-105">
                                            {slide.buttonText}
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </Slider>
            </section>

            {/* Featured Categories Slider */}
            <section className="py-20 px-4">
                <div className="max-w-7xl mx-auto">
                    <h2 className="text-4xl font-light text-center text-gray-800 mb-16 tracking-wide">
                        Featured Collections
                    </h2>
                    <Slider
                        dots={true}
                        infinite={true}
                        speed={500}
                        slidesToShow={3}
                        slidesToScroll={1}
                        autoplay={true}
                        autoplaySpeed={4000}
                        responsive={[
                            {
                                breakpoint: 1024,
                                settings: {
                                    slidesToShow: 2,
                                    slidesToScroll: 1
                                }
                            },
                            {
                                breakpoint: 768,
                                settings: {
                                    slidesToShow: 1,
                                    slidesToScroll: 1
                                }
                            }
                        ]}
                    >
                        {/* Category 1 */}
                        <div className="px-4">
                            <div className="group relative overflow-hidden rounded-2xl shadow-lg">
                                <div className="aspect-[3/4] bg-gradient-to-br from-pink-100 to-rose-200 flex items-center justify-center">
                                    <div className="text-center">
                                        <div className="w-24 h-24 bg-white/80 rounded-full flex items-center justify-center mx-auto mb-4">
                                            <span className="text-4xl">👙</span>
                                        </div>
                                        <h3 className="text-2xl font-light text-gray-800 mb-2">Lingerie</h3>
                                        <p className="text-gray-600">Timeless elegance</p>
                                    </div>
                                </div>
                                <div className="absolute inset-0 bg-black/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-center justify-center">
                                    <button className="bg-white text-gray-800 px-6 py-2 rounded-full font-medium">
                                        Explore
                                    </button>
                                </div>
                            </div>
                        </div>

                        {/* Category 2 */}
                        <div className="px-4">
                            <div className="group relative overflow-hidden rounded-2xl shadow-lg">
                                <div className="aspect-[3/4] bg-gradient-to-br from-purple-100 to-pink-200 flex items-center justify-center">
                                    <div className="text-center">
                                        <div className="w-24 h-24 bg-white/80 rounded-full flex items-center justify-center mx-auto mb-4">
                                            <span className="text-4xl">🩱</span>
                                        </div>
                                        <h3 className="text-2xl font-light text-gray-800 mb-2">Bodysuits</h3>
                                        <p className="text-gray-600">Perfect fit</p>
                                    </div>
                                </div>
                                <div className="absolute inset-0 bg-black/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-center justify-center">
                                    <button className="bg-white text-gray-800 px-6 py-2 rounded-full font-medium">
                                        Explore
                                    </button>
                                </div>
                            </div>
                        </div>

                        {/* Category 3 */}
                        <div className="px-4">
                            <div className="group relative overflow-hidden rounded-2xl shadow-lg">
                                <div className="aspect-[3/4] bg-gradient-to-br from-rose-100 to-pink-200 flex items-center justify-center">
                                    <div className="text-center">
                                        <div className="w-24 h-24 bg-white/80 rounded-full flex items-center justify-center mx-auto mb-4">
                                            <span className="text-4xl">🩲</span>
                                        </div>
                                        <h3 className="text-2xl font-light text-gray-800 mb-2">Underwear</h3>
                                        <p className="text-gray-600">Everyday comfort</p>
                                    </div>
                                </div>
                                <div className="absolute inset-0 bg-black/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-center justify-center">
                                    <button className="bg-white text-gray-800 px-6 py-2 rounded-full font-medium">
                                        Explore
                                    </button>
                                </div>
                            </div>
                        </div>

                        {/* Category 4 */}
                        <div className="px-4">
                            <div className="group relative overflow-hidden rounded-2xl shadow-lg">
                                <div className="aspect-[3/4] bg-gradient-to-br from-pink-100 to-purple-200 flex items-center justify-center">
                                    <div className="text-center">
                                        <div className="w-24 h-24 bg-white/80 rounded-full flex items-center justify-center mx-auto mb-4">
                                            <span className="text-4xl">👗</span>
                                        </div>
                                        <h3 className="text-2xl font-light text-gray-800 mb-2">Sleepwear</h3>
                                        <p className="text-gray-600">Dreamy comfort</p>
                                    </div>
                                </div>
                                <div className="absolute inset-0 bg-black/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-center justify-center">
                                    <button className="bg-white text-gray-800 px-6 py-2 rounded-full font-medium">
                                        Explore
                                    </button>
                                </div>
                            </div>
                        </div>

                        {/* Category 5 */}
                        <div className="px-4">
                            <div className="group relative overflow-hidden rounded-2xl shadow-lg">
                                <div className="aspect-[3/4] bg-gradient-to-br from-rose-100 to-pink-200 flex items-center justify-center">
                                    <div className="text-center">
                                        <div className="w-24 h-24 bg-white/80 rounded-full flex items-center justify-center mx-auto mb-4">
                                            <span className="text-4xl">🎀</span>
                                        </div>
                                        <h3 className="text-2xl font-light text-gray-800 mb-2">Accessories</h3>
                                        <p className="text-gray-600">Complete the look</p>
                                    </div>
                                </div>
                                <div className="absolute inset-0 bg-black/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300 flex items-center justify-center">
                                    <button className="bg-white text-gray-800 px-6 py-2 rounded-full font-medium">
                                        Explore
                                    </button>
                                </div>
                            </div>
                        </div>
                    </Slider>
                </div>
            </section>

            {/* New Arrivals */}
            <section className="py-20 px-4 bg-white">
                <div className="max-w-7xl mx-auto">
                    <h2 className="text-4xl font-light text-center text-gray-800 mb-16 tracking-wide">
                        New Arrivals
                    </h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
                        {/* Product 1 */}
                        <div className="group">
                            <div className="aspect-[3/4] bg-gradient-to-br from-pink-50 to-rose-100 rounded-xl overflow-hidden mb-4 relative">
                                <div className="absolute inset-0 bg-gradient-to-t from-black/10 to-transparent"></div>
                                <div className="absolute top-4 right-4">
                                    <button className="w-8 h-8 bg-white/80 rounded-full flex items-center justify-center text-gray-600 hover:bg-pink-500 hover:text-white transition-colors">
                                        ♥
                                    </button>
                                </div>
                            </div>
                            <h3 className="text-lg font-medium text-gray-800 mb-2">Silk Lace Bra</h3>
                            <p className="text-gray-600 mb-2">$89.99</p>
                            <button className="w-full bg-pink-500 text-white py-2 rounded-lg hover:bg-pink-600 transition-colors">
                                Add to Cart
                            </button>
                        </div>

                        {/* Product 2 */}
                        <div className="group">
                            <div className="aspect-[3/4] bg-gradient-to-br from-purple-50 to-pink-100 rounded-xl overflow-hidden mb-4 relative">
                                <div className="absolute inset-0 bg-gradient-to-t from-black/10 to-transparent"></div>
                                <div className="absolute top-4 right-4">
                                    <button className="w-8 h-8 bg-white/80 rounded-full flex items-center justify-center text-gray-600 hover:bg-pink-500 hover:text-white transition-colors">
                                        ♥
                                    </button>
                                </div>
                            </div>
                            <h3 className="text-lg font-medium text-gray-800 mb-2">Satin Bodysuit</h3>
                            <p className="text-gray-600 mb-2">$129.99</p>
                            <button className="w-full bg-pink-500 text-white py-2 rounded-lg hover:bg-pink-600 transition-colors">
                                Add to Cart
                            </button>
                        </div>

                        {/* Product 3 */}
                        <div className="group">
                            <div className="aspect-[3/4] bg-gradient-to-br from-rose-50 to-pink-100 rounded-xl overflow-hidden mb-4 relative">
                                <div className="absolute inset-0 bg-gradient-to-t from-black/10 to-transparent"></div>
                                <div className="absolute top-4 right-4">
                                    <button className="w-8 h-8 bg-white/80 rounded-full flex items-center justify-center text-gray-600 hover:bg-pink-500 hover:text-white transition-colors">
                                        ♥
                                    </button>
                                </div>
                            </div>
                            <h3 className="text-lg font-medium text-gray-800 mb-2">Lace Panties</h3>
                            <p className="text-gray-600 mb-2">$39.99</p>
                            <button className="w-full bg-pink-500 text-white py-2 rounded-lg hover:bg-pink-600 transition-colors">
                                Add to Cart
                            </button>
                        </div>

                        {/* Product 4 */}
                        <div className="group">
                            <div className="aspect-[3/4] bg-gradient-to-br from-pink-50 to-rose-100 rounded-xl overflow-hidden mb-4 relative">
                                <div className="absolute inset-0 bg-gradient-to-t from-black/10 to-transparent"></div>
                                <div className="absolute top-4 right-4">
                                    <button className="w-8 h-8 bg-white/80 rounded-full flex items-center justify-center text-gray-600 hover:bg-pink-500 hover:text-white transition-colors">
                                        ♥
                                    </button>
                                </div>
                            </div>
                            <h3 className="text-lg font-medium text-gray-800 mb-2">Silk Robe</h3>
                            <p className="text-gray-600 mb-2">$159.99</p>
                            <button className="w-full bg-pink-500 text-white py-2 rounded-lg hover:bg-pink-600 transition-colors">
                                Add to Cart
                            </button>
                        </div>
                    </div>
                </div>
            </section>

            {/* Newsletter Section */}
            <section className="py-20 px-4 bg-gradient-to-r from-pink-100 to-rose-100">
                <div className="max-w-4xl mx-auto text-center">
                    <h2 className="text-4xl font-light text-gray-800 mb-6 tracking-wide">
                        Stay in the Loop
                    </h2>
                    <p className="text-xl text-gray-600 mb-8 font-light">
                        Be the first to know about new collections and exclusive offers
                    </p>
                    <div className="flex flex-col sm:flex-row gap-4 max-w-md mx-auto">
                        <input
                            type="email"
                            placeholder="Enter your email"
                            className="flex-1 px-6 py-3 rounded-full border border-pink-300 focus:outline-none focus:ring-2 focus:ring-pink-500"
                        />
                        <button className="bg-pink-500 hover:bg-pink-600 text-white px-8 py-3 rounded-full font-medium transition-colors">
                            Subscribe
                        </button>
                    </div>
                </div>
            </section>
        </div>
    );
};

export default HomePage;