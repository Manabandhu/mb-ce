import { ScrollView, StyleSheet, Text } from 'react-native';
import { Section } from '../../components/Section';

export default function DashboardScreen() {
  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.heading}>ManaBandhu</Text>
      <Text style={styles.subheading}>Your community super-app starter</Text>

      <Section title="Today">
        <Text>• 12 new room listings near your city</Text>
        <Text>• 4 rides available for airport tomorrow</Text>
        <Text>• 3 referral posts in Careers room</Text>
      </Section>

      <Section title="Quick Actions">
        <Text>Post Room • Offer Ride • Ask Community</Text>
      </Section>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 16,
    backgroundColor: '#f4f5f7',
  },
  heading: {
    fontSize: 28,
    fontWeight: '800',
    marginBottom: 4,
  },
  subheading: {
    fontSize: 14,
    color: '#5b6270',
    marginBottom: 16,
  },
});
