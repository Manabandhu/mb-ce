import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, Text, View } from 'react-native';
import { getJson } from '../../lib/api';

type Post = {
  id: number;
  city: string;
  topic: string;
  author: string;
  content: string;
};

export default function CommunityScreen() {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    getJson<Post[]>('/community/posts').then(setPosts).catch(() => setPosts([]));
  }, []);

  return (
    <FlatList
      contentContainerStyle={styles.container}
      data={posts}
      keyExtractor={(item) => item.id.toString()}
      ListHeaderComponent={<Text style={styles.heading}>Community Rooms</Text>}
      renderItem={({ item }) => (
        <View style={styles.card}>
          <Text style={styles.meta}>{item.city} • {item.topic}</Text>
          <Text style={styles.title}>{item.author}</Text>
          <Text>{item.content}</Text>
        </View>
      )}
      ListEmptyComponent={<Text>No posts loaded yet.</Text>}
    />
  );
}

const styles = StyleSheet.create({
  container: { padding: 16, backgroundColor: '#f4f5f7', gap: 12 },
  heading: { fontSize: 22, fontWeight: '700', marginBottom: 10 },
  card: { backgroundColor: '#fff', borderRadius: 12, padding: 14 },
  meta: { color: '#5b6270', marginBottom: 6 },
  title: { fontWeight: '700' },
});
