import React from 'react';

const Footer = () => {
    return (
        <div>
            {/* Footer */}
            <footer className="bg-gray-800 text-white py-12 px-4">
                <div className="max-w-7xl mx-auto grid grid-cols-1 md:grid-cols-4 gap-8">
                    <div>
                        <h3 className="text-xl font-light mb-4">About Us</h3>
                        <p className="text-gray-300 text-sm leading-relaxed">
                            We believe every woman deserves to feel confident and beautiful in her own skin.
                        </p>
                    </div>
                    <div>
                        <h3 className="text-xl font-light mb-4">Customer Service</h3>
                        <ul className="text-gray-300 text-sm space-y-2">
                            <li>Contact Us</li>
                            <li>Shipping & Returns</li>
                            <li>Size Guide</li>
                            <li>FAQ</li>
                        </ul>
                    </div>
                    <div>
                        <h3 className="text-xl font-light mb-4">Collections</h3>
                        <ul className="text-gray-300 text-sm space-y-2">
                            <li>Lingerie</li>
                            <li>Bodysuits</li>
                            <li>Underwear</li>
                            <li>Sleepwear</li>
                        </ul>
                    </div>
                    <div>
                        <h3 className="text-xl font-light mb-4">Follow Us</h3>
                        <div className="flex space-x-4">
                            <button className="w-10 h-10 bg-pink-500 rounded-full flex items-center justify-center hover:bg-pink-600 transition-colors">
                                📱
                            </button>
                            <button className="w-10 h-10 bg-pink-500 rounded-full flex items-center justify-center hover:bg-pink-600 transition-colors">
                                📷
                            </button>
                            <button className="w-10 h-10 bg-pink-500 rounded-full flex items-center justify-center hover:bg-pink-600 transition-colors">
                                🐦
                            </button>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    );

};

export default Footer;