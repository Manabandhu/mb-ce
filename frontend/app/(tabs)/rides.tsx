import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, Text, View } from 'react-native';
import { getJson } from '../../lib/api';

type Ride = {
  id: number;
  fromCity: string;
  toCity: string;
  date: string;
  seatsAvailable: number;
};

export default function RidesScreen() {
  const [rides, setRides] = useState<Ride[]>([]);

  useEffect(() => {
    getJson<Ride[]>('/rides').then(setRides).catch(() => setRides([]));
  }, []);

  return (
    <FlatList
      contentContainerStyle={styles.container}
      data={rides}
      keyExtractor={(item) => item.id.toString()}
      ListHeaderComponent={<Text style={styles.heading}>Carpools & Travel</Text>}
      renderItem={({ item }) => (
        <View style={styles.card}>
          <Text style={styles.title}>{item.fromCity} → {item.toCity}</Text>
          <Text>{item.date}</Text>
          <Text>{item.seatsAvailable} seats left</Text>
        </View>
      )}
      ListEmptyComponent={<Text>No rides loaded yet.</Text>}
    />
  );
}

const styles = StyleSheet.create({
  container: { padding: 16, backgroundColor: '#f4f5f7', gap: 12 },
  heading: { fontSize: 22, fontWeight: '700', marginBottom: 10 },
  card: { backgroundColor: '#fff', borderRadius: 12, padding: 14 },
  title: { fontWeight: '700' },
});
