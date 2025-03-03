int num = 3;
int hashNum = Integer.hashCode(num);
// Hash value of integer 3 is 3

boolean bol = true;
int hashBol = Boolean.hashCode(bol);
// Hash value of boolean true is 1231

double dec = 3.14159;
int hashDec = Double.hashCode(dec);
// Hash value of decimal 3.14159 is -1340954729

String str = "Hello 算法";
int hashStr = str.hashCode();
// Hash value of string "Hello 算法" is -727081396

Object[] arr = { 12836, "小哈" };
int hashTup = Arrays.hashCode(arr);
// Hash value of array [12836, 小哈] is 1151158

ListNode obj = new ListNode(0);
int hashObj = obj.hashCode();
// Hash value of ListNode object utils.ListNode@7dc5e7b4 is 2110121908
