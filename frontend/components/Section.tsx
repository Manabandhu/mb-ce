import { PropsWithChildren } from 'react';
import { StyleSheet, Text, View } from 'react-native';

type SectionProps = PropsWithChildren<{ title: string }>;

export function Section({ title, children }: SectionProps) {
  return (
    <View style={styles.card}>
      <Text style={styles.title}>{title}</Text>
      {children}
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    backgroundColor: '#fff',
    borderRadius: 12,
    padding: 16,
    marginBottom: 12,
  },
  title: {
    fontSize: 16,
    fontWeight: '700',
    marginBottom: 8,
  },
});
