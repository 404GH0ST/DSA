// par_checker2.rs

use stack::Stack;

// check if parentheses match of various symbols
fn par_match(open: char, close: char) -> bool {
    let opens = "([{";
    let closes = ")]}";
    opens.find(open) == closes.find(close)
}

fn par_checker2(par: &str) -> bool {
    let mut char_list = Vec::new();
    for c in par.chars() {
        char_list.push(c);
    }

    let mut index = 0;
    let mut balance = true;
    let mut stack = Stack::new();
    while index < char_list.len() && balance {
        let c = char_list[index];

        if '(' == c || '[' == c || '{' == c {
            stack.push(c);
        } else if stack.is_empty() {
            balance = false;
        } else {
            let top = stack.pop().unwrap();
            if !par_match(top, c) {
                balance = false;
            }
        }

        index += 1;
    }

    balance && stack.is_empty()
}

fn main() {
    let sa = "(){}[]";
    let sb = "(){)[}";
    let res1 = par_checker2(sa);
    let res2 = par_checker2(sb);
    println!("{sa} balanced: {res1}, {sb} balanced: {res2}");
}
