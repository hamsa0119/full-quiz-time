const isLocalhost = window.location.hostname === 'localhost' || window.location.hostname === '127.0.0.1';

export const API_BASE_URL = isLocalhost
    ? 'http://localhost:8085'
    : 'http://74.235.80.66:8085';
