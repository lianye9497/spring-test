package com.study.px.spring.springtest.dataNode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:二叉树
 * @author: 苏定
 * @create: 2019-07-24 11:17
 **/
@Slf4j
public class Btree {
    private static Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private Btree lchild;
    private Btree rchild;
    private String data;

    public Btree(String c) {
        this.data = c;
        this.lchild = null;
        this.rchild = null;
    }

    public static LinkedList<Btree> createBinTree() {

        LinkedList<Btree> nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Btree("" + array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).lchild = nodeList.get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rchild = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).lchild = nodeList.get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rchild = nodeList.get(lastParentIndex * 2 + 2);
        }
        return nodeList;
    }

    //生成二叉树
    public static List<Btree> createBinTree(Integer[] list) {
        List<Btree> nodeList = new ArrayList<>();
        List<Integer> orderList = sorted(list);
        orderList.forEach(p -> nodeList.add(new Btree("" + p)));
        int k = 0;
        for (int i = 0; i < list.length - 1; i++) {
            Btree btree = nodeList.get(i);
            if (k + 1 >= list.length) {
                return nodeList;
            }
            k += 1;
            btree.lchild = nodeList.get(k);
            if (k + 1 >= list.length) {
                return nodeList;
            }
            k += 1;
            btree.rchild = nodeList.get(k);
        }
        return nodeList;
    }

    //插入节点
    public static void insertNode(Btree root, String insertData) {
        if (root == null || StringUtils.isEmpty(insertData)) {
            return;
        }
        Btree current = root;
        Btree parent = null;
        while (true) {
            parent = current;
            if (Integer.valueOf(insertData) > Integer.valueOf(current.data)) {
                current = current.rchild;
                if (current == null) {
                    parent.rchild = new Btree(insertData);
                    return;
                }
            } else if (Integer.valueOf(insertData) < Integer.valueOf(current.data)) {
                current = current.lchild;
                if (current == null) {
                    parent.lchild = new Btree(insertData);
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static List<Integer> sorted(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        List<Btree> binTree = createBinTree(array);
//        LinkedList<Btree> binTree = createBinTree();
//        preOrderTraverse(binTree.get(0));
        //-=======================生成二叉树,并中序输出=============================//
        List<Integer> list = new ArrayList<>();
        long l = System.currentTimeMillis();
        System.out.println(l);
        Random random = new Random(1564365515597L);
        Btree root = null;
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(100);
            list.add(i1);
            System.out.println(i1);
            if (i == 0) {
                root = new Btree("" + i1);
                continue;
            }
            insertNode(root, "" + i1);
        }
        insertNode(root, "88");
        insertNode(root, "82");
        insertNode(root, "83");
        insertNode(root, "55");

        List<String> before = new ArrayList<>();
        inOrderTraverse(root, before);
        log.info("{}", before);

        //-=======================删除指定节点,并中序输出=============================//
        Integer integer = list.get(random.nextInt(100) % list.size());
        removeNode(root, "" + 82);
//        ss(root);
        System.out.println("==============================================================");
        List<String> after = new ArrayList<>();
        inOrderTraverse(root, after);
        log.info("{}", after);

    }

    private static void ss(Btree root) {
        root.data = "1";
        root = new Btree("2");
    }

    private static void removeNode(Btree root, String s) {
        if (root == null) {
            return;
        }
        Btree current = root;
        Btree parent = current;
        boolean isLeft = false;
        while (true) {
            if (Integer.valueOf(current.data) > Integer.valueOf(s)) {
                parent = current;
                current = current.lchild;
                isLeft = true;
            } else if (Integer.valueOf(current.data) < Integer.valueOf(s)) {
                parent = current;
                current = current.rchild;
                isLeft = false;
            } else {
                if (current.lchild != null && current.rchild != null) {
                    Btree node = findMinNode(current.rchild);
                    if (current == root) {
                        root.data = node.data;
                    } else {
                        if (isLeft){
                            parent.lchild = node;
                         }else {
                            parent.rchild = node;
                        }
                        node.lchild = current.lchild;
                        if (current.rchild != node){
                            node.rchild = current.rchild;
                        }
                    }
                } else {
                    Btree node = current.lchild != null ? current.lchild : current.rchild;
                    if (current == root) {
                        root.data = node.data;
                    } else {
                        if (isLeft) {
                            parent.lchild = node;
                        } else {
                            parent.rchild = node;
                        }
                    }
                }
                return;
            }
        }
    }

    /**
     * 查找最小节点
     *
     * @param rchild
     * @return
     */
    private static Btree findMinNode(Btree rchild) {
        if (rchild == null) {
            return null;
        }
        Btree mini = rchild;//最小节点
        Btree parent = null;//最小节点的父节点
        while (mini.lchild != null) {
            parent = mini;
            mini = mini.lchild;
        }
        //因为左边节点永远小于右边节点，所以左边节点一定是空（要么不存在，存在就应该删除）
        if (parent != null){
            parent.lchild = null;
            //最小节点不可能存在左节点，所以只要判断有没有右节点
            if (mini.rchild != null){
                parent.lchild = mini.rchild;
            }
        }
        return mini;
    }

    /*二叉树的前序遍历递归算法*/
    static void preOrderTraverse(Btree T) {
        if (T == null)
            return;
        log.info("{}", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
        preOrderTraverse(T.lchild);    /*再先序遍历左子树*/
        preOrderTraverse(T.rchild);    /*最后先序遍历右子树*/
    }


    /*二叉树的中序遍历递归算法*/
    static void inOrderTraverse(Btree T, List<String> list) {
        if (T == null)
            return;
        inOrderTraverse(T.lchild, list); /*中序遍历左子树*/
        list.add(T.data);
        inOrderTraverse(T.rchild, list); /*最后中序遍历右子树*/
    }

    /*二叉树的中序遍历递归算法*/
    static void inOrderTraverse(Btree T) {
        if (T == null)
            return;
        inOrderTraverse(T.lchild); /*中序遍历左子树*/
        log.info("{}", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
        inOrderTraverse(T.rchild); /*最后中序遍历右子树*/
    }


    /*二叉树的后序遍历递归算法*/
    static void postOrderTraverse(Btree T) {
        if (T == null)
            return;
        postOrderTraverse(T.lchild);   /*先后序遍历左子树*/
        postOrderTraverse(T.rchild);   /*再后续遍历右子树*/
        log.info("{}", T.data);  /*显示结点数据，可以更改为其他对结点操作*/
    }

}