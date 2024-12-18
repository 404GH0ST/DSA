// base_converter.rs

use stack::Stack;

fn base_converter(mut dec_num: u32, base: u32) -> String {
    // digits is the string form of integers(especially for 10-15)
    let digits = [
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
    ];
    let mut rem_stack = Stack::new();

    // push rem into the stack
    while dec_num > 0 {
        let rem = dec_num % base;
        rem_stack.push(rem);
        dec_num /= base;
    }

    // pop out elems from the stack to form a string
    let mut base_str = "".to_string();
    while !rem_stack.is_empty() {
        let rem = rem_stack.pop().unwrap() as usize;
        base_str += &digits[rem].to_string();
    }
    base_str
}

fn main() {
    let num1 = 10;
    let num2 = 43;
    let bin_str = base_converter(num1, 2);
    let hex_str = base_converter(num2, 16);
    println!("{num1} = b{bin_str}, {num2} = 0x{hex_str}");
}
