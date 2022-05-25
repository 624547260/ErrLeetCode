package com.snowfly.errleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiaofeng on 2022/5/25
 * Desc：1372. 二叉树中的最长交错路径
 *  [https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/]
 */
class Solution01 {
    int maxLong = 0;
    Set<TreeNode> has = new HashSet<>();
    public int longestZigZag(TreeNode root) {
        // int level = maxLongest(root, false, 0);
        // return level;
        traverse(root);
        return maxLong;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        maxLong = Math.max(Math.max(maxLongest(root.right, true, 0), maxLongest(root.left, false, 0)), maxLong);
        traverse(root.left);
        traverse(root.right);

    }

    public int maxLongest(TreeNode root, boolean isLeft, int level){
        if(root == null|| has.contains(root)){
            return level;
        }
        has.add(root);
        int max = level;
        if(isLeft){
            max =  maxLongest(root.left, !isLeft, level+1);
        }else if(!isLeft){
            max =  maxLongest(root.right, !isLeft, level+1);
        }
        return max;
    }
}
