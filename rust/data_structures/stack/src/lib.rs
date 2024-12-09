#[derive(Debug, Default)]
pub struct Stack<T> {
    pub size: usize,
    pub data: Vec<T>,
}

impl<T> Stack<T> {
    // initialize new stack
    pub fn new() -> Stack<T> {
        Self {
            size: 0,
            data: Vec::new(),
        }
    }

    pub fn is_empty(&self) -> bool {
        0 == self.size
    }

    pub fn len(&self) -> usize {
        self.size
    }

    // clear stack
    pub fn clear(&mut self) {
        self.size = 0;
        self.data.clear();
    }

    // put item into the tail of Vec
    pub fn push(&mut self, val: T) {
        self.data.push(val);
        self.size += 1;
    }

    // size decrease by 1 and return the value
    pub fn pop(&mut self) -> Option<T> {
        if 0 == self.size {
            return None;
        }

        self.size -= 1;
        self.data.pop()
    }

    // return reference to the top value
    pub fn peek(&self) -> Option<&T> {
        if 0 == self.size {
            return None;
        }

        self.data.get(self.size - 1)
    }

    pub fn peek_mut(&mut self) -> Option<&mut T> {
        if 0 == self.size {
            return None;
        }

        self.data.get_mut(self.size - 1)
    }

    // Implementing iteration for stack
    // into_iter: stack modified and becomes a iterator
    // iter: stack unmodified and get a unmutable iterator
    // iter_mut: stack unmodified and get a mutable iterator
    pub fn into_iter(self) -> IntoIter<T> {
        IntoIter(self)
    }

    pub fn iter(&self) -> Iter<T> {
        let mut iterator = Iter { stack: Vec::new() };
        for item in self.data.iter() {
            iterator.stack.push(item);
        }

        iterator
    }

    pub fn iter_mut(&mut self) -> IterMut<T> {
        let mut iterator = IterMut { stack: Vec::new() };
        for item in self.data.iter_mut() {
            iterator.stack.push(item);
        }

        iterator
    }
}

// Implementaion of 3 iterations
pub struct IntoIter<T>(Stack<T>);

impl<T: Clone> Iterator for IntoIter<T> {
    type Item = T;
    fn next(&mut self) -> Option<Self::Item> {
        if !self.0.is_empty() {
            self.0.size -= 1;
            self.0.data.pop()
        } else {
            None
        }
    }
}

pub struct Iter<'a, T: 'a> {
    stack: Vec<&'a T>,
}

impl<'a, T> Iterator for Iter<'a, T> {
    type Item = &'a T;
    fn next(&mut self) -> Option<Self::Item> {
        self.stack.pop()
    }
}

pub struct IterMut<'a, T: 'a> {
    stack: Vec<&'a mut T>,
}

impl<'a, T> Iterator for IterMut<'a, T> {
    type Item = &'a mut T;
    fn next(&mut self) -> Option<Self::Item> {
        self.stack.pop()
    }
}
