#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;
int main(int argc, char const *argv[])
{
    /* Initialize hash table */
    unordered_map<int, string> map;

    /* Add operation */
    // Add key-value pair (key, value) to hash table
    map[12836] = "Xiao Ha";
    map[15937] = "Xiao Luo";
    map[16750] = "Xiao Suan";
    map[13276] = "Xiao Fa";
    map[10583] = "Xiao Ya";

    /* Query operation */
    // Input key into hash table, get value
    string name = map[15937];

    /* Delete operation */
    // Delete key-value pair (key, value) from hash table
    map.erase(10583);

    /* Traverse hash table */
    // Traverse key-value pairs key->value
    for (auto kv : map)
    {
        cout << kv.first << " -> " << kv.second << endl;
    }
    // Traverse using iterator key->value
    for (auto iter = map.begin(); iter != map.end(); iter++)
    {
        cout << iter->first << "->" << iter->second << endl;
    }
    return 0;
}