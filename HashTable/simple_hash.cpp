/* Additive hash */
int addHash(string key) {
  long long hash = 0;
  const int MODULUS = 1000000007;
  for (unsigned char c : key) {
    hash = (hash + (int)c) % MODULUS;
  }
  return (int)hash;
}

/* Multiplicative hash */
int mulHash(string key) {
  long long hash = 0;
  const int MODULUS = 1000000007;
  for (unsigned char c : key) {
    hash = (31 * hash + (int)c) % MODULUS;
  }
  return (int)hash;
}

/* XOR hash */
int xorHash(string key) {
  int hash = 0;
  const int MODULUS = 1000000007;
  for (unsigned char c : key) {
    hash ^= (int)c;
  }
  return hash & MODULUS;
}

/* Rotational hash */
int rotHash(string key) {
  long long hash = 0;
  const int MODULUS = 1000000007;
  for (unsigned char c : key) {
    hash = ((hash << 4) ^ (hash >> 28) ^ (int)c) % MODULUS;
  }
  return (int)hash;
}