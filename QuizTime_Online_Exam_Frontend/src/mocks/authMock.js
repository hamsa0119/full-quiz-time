export const mockLogin = async (username, password) => {
  // Simulate successful login
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        token: 'mock-token-123',
        admin: {
          username,
          role: 'admin',
        },
      });
    }, 300);
  });
};

export const mockRequestOtp = async (email) => {
  // Simulate OTP request
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ message: `OTP sent to ${email}` });
    }, 300);
  });
};

export const mockVerifyOtp = async (email, otp) => {
  // Simulate OTP verification (accept any 4-digit code)
  return new Promise((resolve) => {
    setTimeout(() => {
      if (otp.length === 4) {
        resolve({ success: true });
      } else {
        resolve({ success: false, message: 'Invalid OTP' });
      }
    }, 300);
  });
};

export const mockResetPassword = async (email, otp, newPassword) => {
  // Simulate password reset
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve({ success: true, message: 'Password reset successful' });
    }, 300);
  });
};
