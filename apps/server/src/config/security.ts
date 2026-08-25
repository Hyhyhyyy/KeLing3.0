const MIN_JWT_SECRET_BYTES = 32;

export function requireJwtSecret(): string {
  const secret = process.env.JWT_SECRET;
  if (!secret || Buffer.byteLength(secret, 'utf8') < MIN_JWT_SECRET_BYTES) {
    throw new Error(`JWT_SECRET must contain at least ${MIN_JWT_SECRET_BYTES} bytes`);
  }
  return secret;
}

export function allowedCorsOrigins(): string[] {
  const configured = (process.env.CORS_ORIGINS || '')
    .split(',')
    .map(value => value.trim())
    .filter(Boolean);

  if (configured.length > 0) return configured;
  if (process.env.NODE_ENV === 'production') {
    throw new Error('CORS_ORIGINS is required in production');
  }
  return ['http://localhost:5173', 'http://localhost:3000'];
}
