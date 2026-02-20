import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, Text, View } from 'react-native';
import { getJson } from '../../lib/api';

type Room = {
  id: number;
  title: string;
  city: string;
  rent: number;
  verified: boolean;
};

export default function RoomsScreen() {
  const [rooms, setRooms] = useState<Room[]>([]);

  useEffect(() => {
    getJson<Room[]>('/rooms').then(setRooms).catch(() => setRooms([]));
  }, []);

  return (
    <FlatList
      contentContainerStyle={styles.container}
      data={rooms}
      keyExtractor={(item) => item.id.toString()}
      ListHeaderComponent={<Text style={styles.heading}>Find Rooms</Text>}
      renderItem={({ item }) => (
        <View style={styles.card}>
          <Text style={styles.title}>{item.title}</Text>
          <Text>{item.city}</Text>
          <Text>${item.rent}/month</Text>
          {item.verified && <Text style={styles.badge}>Verified</Text>}
        </View>
      )}
      ListEmptyComponent={<Text>No rooms loaded yet.</Text>}
    />
  );
}

const styles = StyleSheet.create({
  container: { padding: 16, backgroundColor: '#f4f5f7', gap: 12 },
  heading: { fontSize: 22, fontWeight: '700', marginBottom: 10 },
  card: { backgroundColor: '#fff', borderRadius: 12, padding: 14 },
  title: { fontWeight: '700' },
  badge: { marginTop: 6, color: '#0f766e', fontWeight: '700' },
});
