from platform import node
from turtle import st

from sqlalchemy import null


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
#
# @lc app=leetcode.cn id=297 lang=python3
#
# [297] 二叉树的序列化与反序列化
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def __init__(self):
        self.st = ""
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return ""
        def preOrder(root):
            if root == None:
                self.st += 'Null#'
            else:
                self.st += (str(root.val)+'#')
                preOrder(root.left)
                preOrder(root.right)
            return self.st
        return preOrder(root)

        


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        print("data:"+data)

        if data == "":
            return None
        nodes = data.split('#')[:-1]
        self.idx = 0
        def buildTree():
            if nodes[self.idx] == "Null":
                self.idx+=1
                return None
            node = TreeNode(int(nodes[self.idx]))
            self.idx+=1
            print(self.idx)
            node.left = buildTree()
            node.right = buildTree()
            return node
        root = buildTree()
        return root



        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
# @lc code=end

