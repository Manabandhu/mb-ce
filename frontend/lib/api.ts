const API_BASE = process.env.EXPO_PUBLIC_API_BASE_URL ?? 'http://localhost:8080/api';

export async function getJson<T>(path: string): Promise<T> {
  const response = await fetch(`${API_BASE}${path}`);
  if (!response.ok) {
    throw new Error(`Request failed: ${response.status}`);
  }
  return response.json() as Promise<T>;
}
