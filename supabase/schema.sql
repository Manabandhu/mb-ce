-- ManaBandhu core schema starter

create extension if not exists "uuid-ossp";

create table if not exists profiles (
  user_id uuid primary key,
  full_name text not null,
  city text,
  languages text[] default '{}',
  profession text,
  visa_status text,
  profile_verified boolean not null default false,
  created_at timestamptz not null default now(),
  updated_at timestamptz not null default now()
);

create table if not exists room_listings (
  id bigserial primary key,
  owner_id uuid not null,
  title text not null,
  city text not null,
  zip text not null,
  rent integer not null,
  gender_preference text default 'Any',
  available_from date not null,
  amenities text[] default '{}',
  verified boolean not null default false,
  created_at timestamptz not null default now()
);

create table if not exists ride_trips (
  id bigserial primary key,
  driver_id uuid not null,
  from_city text not null,
  to_city text not null,
  trip_date date not null,
  departure_time time not null,
  seats_available integer not null,
  suggested_split_amount integer not null default 0,
  created_at timestamptz not null default now()
);

create table if not exists ride_requests (
  id bigserial primary key,
  ride_id bigint not null references ride_trips(id) on delete cascade,
  rider_id uuid not null,
  message text,
  status text not null default 'REQUESTED',
  created_at timestamptz not null default now()
);

create table if not exists community_posts (
  id bigserial primary key,
  author_id uuid not null,
  city text not null,
  topic text not null,
  content text not null,
  upvotes integer not null default 0,
  created_at timestamptz not null default now()
);

alter table profiles enable row level security;
alter table room_listings enable row level security;
alter table ride_trips enable row level security;
alter table ride_requests enable row level security;
alter table community_posts enable row level security;

create policy "Profiles are readable by authenticated users"
  on profiles for select
  to authenticated
  using (true);

create policy "Users can update own profile"
  on profiles for update
  to authenticated
  using (auth.uid() = user_id)
  with check (auth.uid() = user_id);

create policy "Room listings are publicly readable"
  on room_listings for select
  to authenticated
  using (true);

create policy "Owners can manage their room listings"
  on room_listings for all
  to authenticated
  using (auth.uid() = owner_id)
  with check (auth.uid() = owner_id);
