## 算法-树
整理算法中树结构相关的问题

### 二叉树

**遍历**
前序遍历：根结点 ---> 左子树 ---> 右子树
中序遍历：左子树---> 根结点 ---> 右子树
后序遍历：左子树 ---> 右子树 ---> 根结点
层次遍历：只需按层次遍历即可

### 思路
- 前中后序为什么会是这个顺序，谁定义了这个顺序，以及这个顺序的作用。
- 二叉树题目的递归解法可以分两类思路，第一类是遍历一遍二叉树得出答案，第二类是通过分解问题计算出答案，这两类思路分别对应着 回溯算法核心框架 和 动态规划核心框架。



```java
/** 遍历模版 */
void traverse(TreeNode root) {
    // 前序遍历代码位置
    traverse(root.left);    
    // 中序遍历代码位置
    traverse(root.right);
    // 后序遍历代码位置
}

/** 前序遍历 */
public List<Integer> preorderTraversal(TreeNode root) {
  if (root == null) {
    retuen new LinkedList();
  }
  List<Integer> preorderList = new LinkedList();
  preorderList.add(root.val);
  List<Integer> lf = preorderTraversal(root.left);
  preorderList.addAll(lf);
  List<Integer> lr = preorderTraversal(root.right);
  preorderList.addAll(lr);
  return preorderList;
}

/** 中序遍历 */
public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
        return new LinkedList();
    }
    List<Integer> lf = inorderTraversal(root.left);
    lf.add(root.val);
    List<Integer> lr = inorderTraversal(root.right);
    lf.addAll(lr);
    return lf;
}

/** 后序遍历 */
public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
        return new LinkedList();
    }
    List<Integer> lf = postorderTraversal(root.left);
    List<Integer> lr = postorderTraversal(root.right);
    lf.addAll(lr);
    lf.add(root.val);
    return lf;
}

```
