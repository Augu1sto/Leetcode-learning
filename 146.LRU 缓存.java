package leetcode.editor.cn;

//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2009 👎 0

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

//Java：LRU 缓存
class LruCache{
    public static void main(String[] args) {
        Solution solution = new LruCache().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class DNode {
            int val;
            int key;
            DNode prev;
            DNode next;
            public DNode() {}
            public DNode(int value, int key){
                this.val = value;
                this.key = key;
            }
        }
        private int capacity;
        private Map<Integer, DNode> map = new HashMap<>();
        private DNode head; // 伪头结点
        private DNode tail; // 伪尾节点
        public LRUCache(int capacity){
            this.capacity = capacity;
            // 使用伪头和伪尾节点
            head = new DNode();
            tail = new DNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key){
            DNode node = this.map.get(key);
            if (node == null) {
                return -1;
            }
            // 访问完节点后，需要将结点从原有位置移出，重新添加到头部
            updateNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            DNode node;
            if (get(key) != -1) {
                node = this.map.get(key);
                node.val = value;
                node.key = key;
                map.put(key, node);
                // 更新
                updateNode(node);
            } else {
                node = new DNode(value, key);
                addNode(node);
                map.put(key, node);
                if (map.size() > this.capacity) {
                    removeEldestNode();
                }
            }

        }

        public void addNode(DNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void removeEldestNode(){
            DNode node = tail.prev;
            // 哈希表里删除
            this.map.remove(node.key);
            // 双向链表里删除
            tail.prev = node.prev;
            tail.prev.next = tail;
        }
        // 移除特定结点
        public void removeNode(DNode node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        // 读取后更新
        public void updateNode(DNode node){
            removeNode(node);
            addNode(node);
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
