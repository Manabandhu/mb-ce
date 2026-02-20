import { useEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { getJson } from '../../lib/api';

type Profile = {
  fullName: string;
  city: string;
  profession: string;
  visaStatus: string;
  profileVerified: boolean;
};

export default function ProfileScreen() {
  const [profile, setProfile] = useState<Profile | null>(null);

  useEffect(() => {
    getJson<Profile>('/profiles/me').then(setProfile).catch(() => setProfile(null));
  }, []);

  if (!profile) {
    return <View style={styles.container}><Text>Loading profile...</Text></View>;
  }

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>{profile.fullName}</Text>
      <Text>{profile.city}</Text>
      <Text>{profile.profession}</Text>
      <Text>Visa: {profile.visaStatus}</Text>
      {profile.profileVerified && <Text style={styles.verified}>Community Verified</Text>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 16, backgroundColor: '#f4f5f7' },
  heading: { fontSize: 26, fontWeight: '700', marginBottom: 8 },
  verified: { marginTop: 8, color: '#0f766e', fontWeight: '700' },
});
