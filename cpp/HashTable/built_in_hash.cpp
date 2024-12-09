int num = 3;
size_t hashNum = hash<int>()(num);
// Hash value of integer 3 is 3

bool bol = true;
size_t hashBol = hash<bool>()(bol);
// Hash value of boolean 1 is 1

double dec = 3.14159;
size_t hashDec = hash<double>()(dec);
// Hash value of decimal 3.14159 is 4614256650576692846

string str = "Hello 算法";
size_t hashStr = hash<string>()(str);
// Hash value of string "Hello 算法" is 15466937326284535026

// In C++, built-in std::hash() only provides hash values for basic data types
// Hash values for arrays and objects need to be implemented separately