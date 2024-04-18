class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root, value):
    if root is None:
        return Node(value)
    if value < root.value:
        root.left = insert(root.left, value)
    else:
        root.right = insert(root.right, value)
    return root

def print_level_order(root):
    if root is None:
        return
    
    queue = []
    queue.append(root)

    while queue:
        count = len(queue)
        for i in range(count):
            node = queue.pop(0)
            if node:
                print(node.value, end=" ")
                if node.left:
                    queue.append(node.left)
                else:
                    queue.append(None)
                if node.right:
                    queue.append(node.right)
                else:
                    queue.append(None)
            else:
                print(".", end=" ")
        print()

# Create the tree
values = [6, 4, 8, 3, 5, 7, 9]
root = None
for value in values:
    root = insert(root, value)

# Print tree in level order
print_level_order(root)
