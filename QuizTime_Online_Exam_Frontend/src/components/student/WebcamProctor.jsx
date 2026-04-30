import React, { useRef, useEffect, useState, useCallback } from 'react';
import Webcam from 'react-webcam';
import { Camera, CameraOff, AlertCircle, User } from 'lucide-react';

const WebcamProctor = ({ onInfraction, isExamActive }) => {
    const webcamRef = useRef(null);
    const [hasPermission, setHasPermission] = useState(null);
    const [isCameraReady, setIsCameraReady] = useState(false);

    const handleUserMedia = () => {
        setHasPermission(true);
        setIsCameraReady(true);
    };

    const handleUserMediaError = (error) => {
        console.error('Webcam permission denied:', error);
        setHasPermission(false);
        onInfraction?.('Camera permission denied. Please allow camera access to continue the exam.');
    };

    // Simple detection placeholder (Phase 1)
    // In Phase 2, we can integrate face-api.js here
    useEffect(() => {
        if (!isExamActive || !isCameraReady) return;

        const interval = setInterval(() => {
            // Check if webcam is still active
            if (webcamRef.current && !webcamRef.current.stream?.active) {
                onInfraction?.('Webcam stream lost. Ensure your camera is connected.');
            }
        }, 5000);

        return () => clearInterval(interval);
    }, [isExamActive, isCameraReady, onInfraction]);

    return isExamActive ? (
        <div style={{
            position: 'fixed',
            bottom: '20px',
            right: '20px',
            width: '180px',
            height: '135px',
            borderRadius: '16px',
            overflow: 'hidden',
            boxShadow: '0 10px 25px rgba(0,0,0,0.2)',
            border: '2px solid var(--primary)',
            background: '#000',
            zIndex: 1000,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center'
        }}>
            {hasPermission === false ? (
                <div style={{ color: 'var(--error)', textAlign: 'center', padding: '10px' }}>
                    <CameraOff size={24} style={{ marginBottom: '8px' }} />
                    <div style={{ fontSize: '0.7rem', fontWeight: 600 }}>Access Denied</div>
                </div>
            ) : (
                <>
                    <Webcam
                        audio={false}
                        ref={webcamRef}
                        screenshotFormat="image/jpeg"
                        videoConstraints={{
                            width: 180,
                            height: 135,
                            facingMode: "user"
                        }}
                        onUserMedia={handleUserMedia}
                        onUserMediaError={handleUserMediaError}
                        style={{ width: '100%', height: '100%', objectFit: 'cover' }}
                    />
                    <div style={{
                        position: 'absolute',
                        top: '8px',
                        left: '8px',
                        background: 'rgba(16, 185, 129, 0.8)',
                        color: 'white',
                        padding: '2px 6px',
                        borderRadius: '4px',
                        fontSize: '0.6rem',
                        fontWeight: 800,
                        display: 'flex',
                        alignItems: 'center',
                        gap: '4px'
                    }}>
                        <div style={{ width: '6px', height: '6px', background: 'white', borderRadius: '50%', animation: 'pulse 1.5s infinite' }} />
                        LIVE
                    </div>
                </>
            )}
            <style>{`
                @keyframes pulse {
                    0% { opacity: 1; }
                    50% { opacity: 0.4; }
                    100% { opacity: 1; }
                }
            `}</style>
        </div>
    ) : null;
};

export default WebcamProctor;
