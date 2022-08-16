// Inorder
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;

    while(curr != null) {
        if(curr.left != null) {
            TreeNode temp = curr.left;
            while(temp.right != null && temp.right != curr) temp = temp.right;

            if(temp.right == null) {
                temp.right = curr;
                curr = curr.left;
            } else {
                res.add(curr.val);
                temp.right = null;
                curr = curr.right;
            }
        } else {
            res.add(curr.val);
            curr = curr.right;
        }
    }

    return res;
}

// Preorder
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;

    while(curr != null) {
        if(curr.left != null) {
            TreeNode temp = curr.left;
            while(temp.right != null && temp.right != curr) temp = temp.right;

            if(temp.right == null) {
                res.add(curr.val);
                temp.right = curr;
                curr = curr.left;
            } else {
                temp.right = null;
                curr = curr.right;
            }
        } else {
            res.add(curr.val);
            curr = curr.right;
        }
    }

    return res;
}

// Postorder
public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> out = new ArrayList<Integer>();
	if(root == null)
		return out;
	TreeNode dummy = new TreeNode(-1), pre = null;
	dummy.left = root; root = dummy;
	while(root != null){
		if(root.left != null){
			pre = root.left;
			while(pre.right != null && pre.right != root)
				pre=pre.right;
			if(pre.right == null){
				pre.right = root;
				root = root.left;
			}
			else{
				TreeNode node = pre;
				reverse(root.left,pre);
				while(node != root.left){
					out.add(node.val);
					node = node.right;
				}
				out.add(node.val);          // Print again since we are stopping at node=root.left
				reverse(pre,root.left);
				pre.right = null;
				root = root.right;
			}
		}
		else{
			root = root.right;
		}
	}
	return out;
}
public void reverse(TreeNode from, TreeNode to){
    if(from == to)
        return;
    TreeNode prev = from, node = from.right;
    while(prev != to){
        TreeNode next = node.right;
        node.right = prev;
        prev = node;
        node = next;
    }
}
