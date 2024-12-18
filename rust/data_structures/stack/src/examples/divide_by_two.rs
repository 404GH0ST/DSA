// divide_by_two.rs

use stack::Stack;

fn divide_by_two(mut dec_num: u32) -> String {
    // save the remainder in a stack
    let mut rem_stack = Stack::new();

    // push rem into the stack
    while dec_num > 0 {
        let rem = dec_num % 2;
        rem_stack.push(rem);
        dec_num /= 2;
    }

    let mut bin_str = "".to_string();
    while !rem_stack.is_empty() {
        let rem = rem_stack.pop().unwrap().to_string();
        bin_str += &rem;
    }

    bin_str
}

fn main() {
    let num = 10;
    let bin_str = divide_by_two(num);
    println!("{num} = b{bin_str}");
}
