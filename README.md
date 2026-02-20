# ManaBandhu Monorepo

Production-oriented starter for a **Desi community super-app** across Web, iOS, and Android.

## Stack

- **Frontend:** React Native + Expo + expo-router (`frontend/`)
- **Backend:** Java 21 + Spring Boot modular monolith (`backend/`)
- **Data/Auth/Realtime:** Supabase Postgres/Auth/Storage (`supabase/`)

## Implemented MVP foundations

- Auth-ready profile APIs (backend stubs)
- Room listing APIs with filtering
- Ride posting + request APIs
- Community post feed API
- Expo Router app shell with tabs:
  - Dashboard
  - Rooms
  - Rides
  - Community
  - Profile
- Supabase SQL schema + RLS starter policies

## Quick start

### Backend

```bash
cd backend
mvn spring-boot:run
```

Runs on `http://localhost:8080`.

### Frontend

```bash
cd frontend
npm install
npx expo start
```

For web:

```bash
npx expo start --web
```

## API overview

- `GET /api/health`
- `GET /api/profiles/me`
- `PATCH /api/profiles/me`
- `GET /api/rooms?city=&maxRent=&availableFrom=`
- `POST /api/rooms`
- `GET /api/rides?fromCity=&toCity=&date=`
- `POST /api/rides`
- `POST /api/rides/{rideId}/requests`
- `GET /api/community/posts?city=&topic=`
- `POST /api/community/posts`

## Next build steps

1. Replace in-memory services with Supabase/Postgres repositories.
2. Enforce JWT validation using Supabase public JWKs.
3. Add chat with Supabase Realtime + secure channel authorization.
4. Add admin moderation dashboard and scam heuristics.
5. Add push notification workflows designed for future watch surfaces.
