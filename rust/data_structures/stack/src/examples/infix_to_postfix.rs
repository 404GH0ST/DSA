// inflix_to_postfix.rs

mod par_checker3;
use par_checker3::par_checker3;
use stack::Stack;
use std::collections::HashMap;

fn infix_to_postfix(infix: &str) -> Option<String> {
    // check parenthesis
    if !par_checker3(infix) {
        return None;
    }

    // set priority of all symbols
    let mut prec = HashMap::new();
    prec.insert("(", 1);
    prec.insert("+", 2);
    prec.insert("*", 3);

    // ops: save operators, postfix: save postfix expression
    let mut ops = Stack::new();
    let mut postfix = Vec::new();
    for token in infix.split_whitespace() {
        // characters range from 0 - 9 and A - Z can
        // be pushed onto the stack
        if ("A"..="Z").contains(&token) || ("0"..="9").contains(&token) {
            postfix.push(token);
        } else if "(" == token {
            // open mark, push onto the stack
            ops.push(token);
        } else if ")" == token {
            // close mark, pop out from stack
            let mut top = ops.pop().unwrap();
            while top != "(" {
                postfix.push(top);
                top = ops.pop().unwrap();
            }
        } else {
            // check the priority of operators
            while (!ops.is_empty()) && (prec[ops.peek().unwrap()] >= prec[token]) {
                postfix.push(ops.pop().unwrap());
            }
            ops.push(token);
        }
    }

    // push the remaining operators onto the stack
    while !ops.is_empty() {
        postfix.push(ops.pop().unwrap());
    }

    // pop out operators and create the postfix expression
    let mut postfix_str = "".to_string();
    for c in postfix {
        postfix_str += c;
        postfix_str += " ";
    }

    Some(postfix_str)
}

fn main() {
    let infix = "( A + B ) * ( C + D )";
    let postfix = infix_to_postfix(infix);
    match postfix {
        Some(val) => {
            println!("{infix} -> {val}");
        }
        None => {
            println!("{infix} isn't a correct infix string");
        }
    }
}
