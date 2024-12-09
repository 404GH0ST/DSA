// par_checker1.rs

use stack::Stack;

fn par_checker1(par: &str) -> bool {
    // adding characters into Vec
    let mut char_list = Vec::new();
    for c in par.chars() {
        char_list.push(c);
    }

    let mut index = 0;
    let mut balance = true; // determine if balacned
    let mut stack = Stack::new();
    while index < char_list.len() && balance {
        let c = char_list[index];

        if '(' == c {
            stack.push(c);
        } else if stack.is_empty() {
            balance = false;
        } else {
            let _r = stack.pop();
        }

        index += 1;
    }

    // parenthesis matched: balanced and empty stack
    balance && stack.is_empty()
}

fn main() {
    let sa = "()(())";
    let sb = "()((()";
    let res1 = par_checker1(sa);
    let res2 = par_checker1(sb);
    println!("{sa} balanced:{res1}, {sb} balanced:{res2}");
}
