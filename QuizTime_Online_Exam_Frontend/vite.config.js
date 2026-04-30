import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0', // Allow network access
    port: 3004, // Set development port to 3006
    allowedHosts: true, // Allow ngrok and other hosts
    proxy: {
      '/api': {
        target: 'http://localhost:8084',
        changeOrigin: true
      }
    }
  }
})
